
package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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
        
    	request.setAttribute("listarDepartamentos", port.listarDepartamentos().getDato());
    	
    	if (request.getParameter("depa")==null && request.getParameter("nombre")==null) {
    		request.getRequestDispatcher("/WEB-INF/altaSalida.jsp").forward(request, response);
    		return;
    	}
    	
    	String departamento = request.getParameter("depa");
    	if (departamento == null)
    		request.setAttribute("listarActividades", new ArrayList<String>());
    	else
    		request.setAttribute("listarActividades", port.listarActividadesDeDepartamento(departamento).getDato());
    	
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
    		String dateString = date.toString()+":00";
    		String actualString = actual.toString()+":00";
    		String iso = date.toString();
    		if (date.getSecond() == 0 && date.getNano() == 0) {
    		    iso += ":00"; // necessary hack because the second part is not optional in XML
    		}
    		XMLGregorianCalendar xml = null;
			try {
				xml = DatatypeFactory.newInstance().newXMLGregorianCalendar(iso);
			} catch (DatatypeConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		XMLGregorianCalendar xmlGregorianCalendar = null;
			try {
				xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(actual.toString());
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			port.crearSalidaTuristica(nombre, cuposMax , xmlGregorianCalendar, xml, lugar, actividad);
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