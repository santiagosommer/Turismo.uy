package servlets;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.EstadoError;
import ServidorCentral.Logica.DataTypes.EstadoSesion;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IUsuario;

/**
 * Servlet implementation class AltaTurista
 */
@WebServlet("/AltaTurista")
public class AltaTurista extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AltaTurista() {
        // TODO Auto-generated constructor stub
    }
    
    protected boolean checkFormulario(HttpServletRequest request) {
    	
    	String nickname = request.getParameter("nickname");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String confirmPasword = request.getParameter("confirmPasword");
    	
    	IUsuario cu = Fabrica.getInstance().getControladorUsuario();
    	
    	if (cu.existeUsuario(nickname)) {
    		// nickname repetido
    		request.setAttribute("estado_error", EstadoError.ERROR_NICK_OR_EMAIL);
    		return false;
    	}
    	if (cu.existeUsuarioEmail(email)) {
    		// email repetido
    		request.setAttribute("estado_error", EstadoError.ERROR_EMAIL);
    		return false;
    	}
    	if (confirmPasword == password) {
    		// contraseñas distintas
    		request.setAttribute("estado_error", EstadoError.ERROR_CONTRA);
    		return false;
    	}
    	
    	
    	return true;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	request.setAttribute("estado_error", null);
    	
    	if (request.getParameter("nickname")==null) {
    		request.getRequestDispatcher("/WEB-INF/altaTurista.jsp").forward(request, response);
    		return;
    	}
    	
    	if (!checkFormulario(request)) {
    		request.getRequestDispatcher("/WEB-INF/altaTurista.jsp").forward(request, response);
    		return;
    	}
    	
    	String nickname = request.getParameter("nickname");
    	String nombre = request.getParameter("nombre");
    	String apellido = request.getParameter("apellido");
    	String email = request.getParameter("email");
    	String bDate = (String) request.getParameter("bDate");
		LocalDate date = LocalDate.parse(bDate);
    	String password = request.getParameter("password");
    	String nacionalidad = request.getParameter("nacionalidad");
    	
    	IUsuario cu = Fabrica.getInstance().getControladorUsuario();
    	
    	try {
			cu.altaTurista(nickname, nombre, apellido, email, date, password, nacionalidad);
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();
		}
    	
    	request.setAttribute("estado_sesion", EstadoSesion.LOGIN_TURISTA);
    	cu.seleccionarTurista(nickname);
		request.setAttribute("usuario_dt", cu.getDTTurista());
		
    	request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    	
    	//adquirimos la info
    	//guardamos la info para enviarla(request.setatributte)
    	
    	//nos comunicamos con el jsp
    	//requestdispatcher elem = request.getreqdisp(/jsp)
    	
    	//enviamos la info con elem.forward(req, resp)
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request,response);
	}

}
