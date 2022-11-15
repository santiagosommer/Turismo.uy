package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeFactory;

import webservice.DtProveedor;
import webservice.EstadoError;
import webservice.NombreActividadRepetidoException_Exception;
import webservice.Publicador;
import webservice.PublicadorService;
import webservice.SetString;

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
    	
    	String nombre = request.getParameter("nombre_alta_actividad");
    	Integer duracion = Integer.parseInt(request.getParameter("duracion"));
    	float costo = Float.parseFloat(request.getParameter("costo"));
    
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
    	
    	if (port.existeActividad(nombre)) {
    		// nombre repetido
    		request.setAttribute("estado_error", EstadoError.ERROR_NICK_OR_EMAIL);
    		return false;
    	}
    	if (duracion<1) {
    		// duracion negativa o 0
    		request.setAttribute("estado_error", EstadoError.ERROR_CONTRA);
    		return false;
    	}
    	if (!(costo>0)) {
    		// costo negativo o 0
    		request.setAttribute("estado_error", EstadoError.ERROR_EMAIL);
    		return false;
    	}

    	return true;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	request.setAttribute("estado_error", null);
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
    	request.setAttribute("depas_act", port.listarDepartamentos());
		request.setAttribute("cat_act", port.listarCategorias());
    	if (request.getParameter("nombre_alta_actividad")==null || !checkFormulario(request)) {
    		request.getRequestDispatcher("/WEB-INF/altaActividad.jsp").forward(request, response);
    		return;
    	}
    	
    	String nombre = request.getParameter("nombre_alta_actividad");
    	String descripcion = request.getParameter("descripcion");
    	Integer duracion = Integer.parseInt(request.getParameter("duracion"));
    	float costo = Float.parseFloat(request.getParameter("costo"));
    	String ciudad = request.getParameter("ciudad");
        String departamento = request.getParameter("departamento");

		String[] str = request.getParameterValues("categorias");
		Set<String> cats = new HashSet<String>(); 

		String prov = ((DtProveedor) request.getSession().getAttribute("usuario_dt")).getNickname();
		
		for(String s : str) {
			cats.add(s);
		}
    	
    	
    	try {
    		port.crearActividadTuristica(nombre, descripcion, duracion, costo, DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString()), ciudad, departamento, prov, cats);
//			ct.AceptarActividad(nombre);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    	} catch (NombreActividadRepetidoException_Exception e) {
			e.printStackTrace();
		}
    	
    
		
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