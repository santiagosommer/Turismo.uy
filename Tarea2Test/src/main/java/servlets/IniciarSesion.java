package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.EstadoError;
import webservice.EstadoSesion;
import webservice.Publicador;
import webservice.PublicadorService;

/**
 * Servlet implementation class IniciarSesion
 */
@WebServlet("/IniciarSesion")
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	request.setAttribute("estado_error", null);
    	
    	String nick_or_email = request.getParameter("email-or-nickname-content");
    	String passw = request.getParameter("password-content");
    	
    	if (nick_or_email == null || passw == null) {
    		request.getRequestDispatcher("/WEB-INF/inicioDeSesion.jsp").forward(request, response);
    		return;
    	}
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        
        EstadoError nuevoEstado = port.iniciarSesion(nick_or_email, passw);
    	
    	request.setAttribute("estado_error", nuevoEstado);
    	
    	if (nuevoEstado == EstadoError.EXITO_PROVEEDOR || nuevoEstado == EstadoError.EXITO_TURISTA) {
    		if(nuevoEstado == EstadoError.EXITO_PROVEEDOR) {
    			request.getSession().setAttribute("estado_sesion", EstadoSesion.LOGIN_PROVEEDOR);
    			request.getSession().setAttribute("usuario_dt", port.getDTProveedor());
    		}else {
    			request.getSession().setAttribute("estado_sesion", EstadoSesion.LOGIN_TURISTA);
    			request.getSession().setAttribute("usuario_dt", port.getDTTurista());
    		}
    		
    		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    	}else {
    		request.getSession().setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
    		request.getRequestDispatcher("/WEB-INF/inicioDeSesion.jsp").forward(request, response);
    	}
    	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
