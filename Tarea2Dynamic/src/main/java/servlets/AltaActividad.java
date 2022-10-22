package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.DTUsuario;
import ServidorCentral.Logica.DataTypes.EstadoError;
import ServidorCentral.Logica.DataTypes.EstadoSesion;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;

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
    	
    	if (request.getParameter("nombre")==null || !checkFormulario(request)) {
    		request.getRequestDispatcher("/WEB-INF/altaActividad.jsp").forward(request, response);
    		return;
    	}
 	
    	String nombre = request.getParameter("nombre");
    	String descripcion = request.getParameter("descripcion");
    	String duracion = (String) request.getParameter("duracion");
    	String costo = (String) request.getParameter("costo");
    	String ciudad = request.getParameter("ciudad");
        String departamento = request.getParameter("departamento");
		DTUsuario prov = request.getSession().getAtributte("usuario_dt");

		String[] str = request.getParameterValues("categorias");
		Set<String> cats = new HashSet<String>(); 

		for(String s : str) {
			cats.add(s);
		}
    	
    	ITuristica ct = Fabrica.getInstance().getControladorTuristica();
    	
    	try {
			ct.crearActividadTuristica(nombre, descripcion, Integer.parseInt(duracion), Float.parseFloat(costo), LocalDate.now(), ciudad, departamento, prov.getNickname(), cats);
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