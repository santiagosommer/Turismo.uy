package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import webservice.EstadoError;
import webservice.EstadoSesion;
import webservice.Publicador;
import webservice.PublicadorService;
import webservice.UsuarioRepetidoException_Exception;


/**
 * Servlet implementation class AltaProveedor
 */
@WebServlet("/AltaProveedor")
public class AltaProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AltaProveedor() {
        // TODO Auto-generated constructor stub
    }

    protected boolean checkFormulario(HttpServletRequest request) {
    	
    	String nickname = request.getParameter("nickname");
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	String confirmPasword = request.getParameter("confirmPasword");
    	
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
    	
    	if (port.existeUsuario(nickname)) {
    		// nickname repetido
    		request.setAttribute("estado_error", EstadoError.ERROR_NICK_OR_EMAIL);
    		return false;
    	}
    	if (port.existeUsuarioEmail(email)) {
    		// email repetido
    		request.setAttribute("estado_error", EstadoError.ERROR_EMAIL);
    		return false;
    	}
    	if (!confirmPasword.equals(password)) {
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
    		request.getRequestDispatcher("/WEB-INF/altaProveedor.jsp").forward(request, response);
    		return;
    	}
    	
    	if (!checkFormulario(request)) {
    		request.getRequestDispatcher("/WEB-INF/altaProveedor.jsp").forward(request, response);
    		return;
    	}
    	
    	String nickname = request.getParameter("nickname");
    	String nombre = request.getParameter("nombre");
    	String apellido = request.getParameter("apellido");
    	String email = request.getParameter("email");
    	String bDate = (String) request.getParameter("bDate");
		LocalDate date = LocalDate.parse(bDate);
    	String password = request.getParameter("password");
    	String descripcion = request.getParameter("descripcion");
    	String url = "";
    	if (request.getParameter("url") != null) {
        	url = request.getParameter("url");
    	}
    	
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        
        XMLGregorianCalendar xmlGregorianCalendar = null;
		try {
			xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
    		port.altaProveedor(nickname, nombre, apellido, email, xmlGregorianCalendar, password, descripcion, url);
		} catch (UsuarioRepetidoException_Exception e) {
			e.printStackTrace();
		}
    	
    	request.getSession().setAttribute("estado_sesion", EstadoSesion.LOGIN_PROVEEDOR);
    	port.seleccionarProveedor(nickname);
		request.getSession().setAttribute("usuario_dt", port.getDTProveedor());
		
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
