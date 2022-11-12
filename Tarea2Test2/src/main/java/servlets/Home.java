package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ServidorCentral.Logica.DataTypes.EstadoSesion;
import ServidorCentral.Logica.Excepciones.SalidaExpirada;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Interfaces.CargaDeDatos;


/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * carga los datos de prueba 
	 * @param request 
     * @throws SalidaExpirada 
	 */
    
    private static void cargarDatos() {
    	
    	CargaDeDatos carga = CargaDeDatos.getInstancia();
    	
    	try {
			carga.cargarDatos();
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SalidaExpirada e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    /**
	 * inicializa la sesión si no estaba creada 
	 * @param request 
	 */
    
	public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("paginas_navegadas") == null) {
			session.setAttribute("paginas_navegadas", 0);
		}
		if (session.getAttribute("estado_sesion") == null) {
			session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SalidaExpirada {
		cargarDatos();
		initSession(request);
		
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request,response);
		} catch (ServletException | IOException | SalidaExpirada e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ServletException | IOException | SalidaExpirada e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
