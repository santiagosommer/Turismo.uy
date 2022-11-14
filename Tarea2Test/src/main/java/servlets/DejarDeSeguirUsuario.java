package servlets;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.DtUsuario;
import webservice.EstadoError;
import webservice.EstadoSesion;
import webservice.Publicador;
import webservice.PublicadorService;

/**
 * Servlet implementation class SeguirUsuario
 */
@WebServlet("/DejarDeSeguirUsuario")

public class DejarDeSeguirUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DejarDeSeguirUsuario() {
    	 super();
         // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
    	
        String seguido = request.getParameter("nombreUsuario");
        String seguidor = ((DtUsuario) request.getSession().getAttribute("usuario_dt")).getNickname();
        
        port.dejarDeSeguirUsuario(seguido,seguidor);
        
    	request.getRequestDispatcher("/WEB-INF/dejarDeSeguirUsuario.jsp").forward(request, response);
		
	}
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}

