
package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.EstadoError;
import webservice.NoHayActividadConEseNombreException_Exception;
import webservice.NombreSalidaRepetidoException_Exception;
import webservice.Publicador;
import webservice.PublicadorService;

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
    
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
    	
    	if (port.existeSalida(nombre)) {
    		// nombre repetido
    		request.setAttribute("estado_error", EstadoError.ERROR_SALIDA);
    		return false;
    	}

    	return true;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	request.setAttribute("estado_error", null);
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        
    	Set<String> deps = new HashSet<>(port.listarDepartamentos().getDato());
    	request.setAttribute("listarDepartamentos", deps);
    	
    	if (request.getParameter("depa")==null && request.getParameter("nombre")==null) {
    		request.getRequestDispatcher("/WEB-INF/altaSalida.jsp").forward(request, response);
    		return;
    	}
    	
    	String departamento = request.getParameter("depa");
    	Set<String> acts = new HashSet<String>();
    	if (departamento != null)
	    	acts = new HashSet<>(port.listarActividadesDeDepartamento(departamento).getDato());
	    request.setAttribute("listarActividades", acts);
    	
    	if (request.getParameter("nombre")==null) {
    		request.getRequestDispatcher("/WEB-INF/altaSalida.jsp").forward(request, response);
    		return;
    	}
    	
    	if (!checkFormulario(request)) {
    		request.getRequestDispatcher("/WEB-INF/altaSalida.jsp").forward(request, response);
    		return;
    	}
    	
    	String actividad = request.getParameter("actividades");
    	String nombre = request.getParameter("nombre");
    	LocalDateTime date = LocalDateTime.parse(request.getParameter("dateNHour"));
    	String lugar = request.getParameter("lugarsalida");
    	
    	Integer cuposMax = Integer.parseInt(request.getParameter("maxcupos"));
    	
    	
    	
    	try {
    		LocalDate actual = LocalDate.now();
			port.crearSalidaTuristica(nombre, cuposMax , actual.toString(), date.toString(), lugar, actividad);
		} catch (NombreSalidaRepetidoException_Exception | NoHayActividadConEseNombreException_Exception e) {
			e.printStackTrace();
		}
    	
		
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