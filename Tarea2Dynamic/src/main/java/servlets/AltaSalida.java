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
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IUsuario;

/**
 * Servlet implementation class AltaSalida
 */
@WebServlet("/AltaSalida")
public class AltaSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AltaSalida() {
        // TODO Auto-generated constructor stub
    }
    
    protected boolean checkFormulario(HttpServletRequest request) {
    	
    	String nombre = request.getParameter("nombre");
    	String descripcion = request.getParameter("descripcion");
        String duracion = request.getParameter("duracion");
        String costo = request.getParameter("costo");
        String ciudad = request.getParameter("ciudad");


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
    		request.getRequestDispatcher("/WEB-INF/altaSalida.jsp").forward(request, response);
    		return;
    	}
    	
    	if (!checkFormulario(request)) {
    		request.getRequestDispatcher("/WEB-INF/altaSalida.jsp").forward(request, response);
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
			cu.altaSalida(nickname, nombre, apellido, email, date, password, nacionalidad);
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();
		}
    	
    	request.getSession().setAttribute("estado_sesion", EstadoSesion.LOGIN_Salida);
    	cu.seleccionarSalida(nickname);
		request.getSession().setAttribute("usuario_dt", cu.getDTSalida());
		
    	request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);		
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
