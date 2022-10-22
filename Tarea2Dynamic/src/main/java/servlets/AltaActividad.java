package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.EstadoError;
import ServidorCentral.Logica.DataTypes.EstadoSesion;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;

/**
 * Servlet implementation class AltaActividad
 */
@WebServlet("/AltaActividad")
public class AltaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AltaActividad() {
        // TODO Auto-generated constructor stub
    }
    
    protected boolean checkFormulario(HttpServletRequest request) {
    	
    	String nombre = request.getParameter("nombre");
    
    	ITuristica ct = Fabrica.getInstance().getControladorTuristica();
    	
    	if (ct.existeActividad(nombre)) {
    		// nombre repetido
    		request.setAttribute("estado_error", EstadoError.ERROR_ACTIVIDAD);
    		return false;
    	}

    	return true;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	request.setAttribute("estado_error", null);
    	
    	if (request.getParameter("nombre")==null) {
    		request.getRequestDispatcher("/WEB-INF/altaActividad.jsp").forward(request, response);
    		return;
    	}
    	
    	if (!checkFormulario(request)) {
    		request.getRequestDispatcher("/WEB-INF/altaActividad.jsp").forward(request, response);
    		return;
    	}
    	
    	String nombre = request.getParameter("nombre");
    	String descripcion = request.getParameter("descripcion");
    	String duracion = (String) request.getParameter("duracion");
    	String costo = (String) request.getParameter("costo");
    	String ciudad = request.getParameter("ciudad");
        String departamento = request.getParameter("departamento");
        String categorias = request.getParameter("categorias"); 
    	
    	ITuristica ct = Fabrica.getInstance().getControladorTuristica();
    	
    	try {
			ct.crearActividadTuristica(nombre, descripcion, Integer.parseInt(duracion), Float.valueOf(costo), ciudad, departamento, categorias); //actualizar logica
		} catch (NombreActividadRepetidoException e) {
			e.printStackTrace();
		}
    	
    	request.getSession().setAttribute("estado_sesion", EstadoSesion.LOGIN_Actividad);
    	ct.seleccionarActividad(nombre);
		request.getSession().setAttribute("usuario_dt", ct.getDTActividadTuristica());
		
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