package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.DataTypes.EstadoSesion;
import ServidorCentral.Logica.Excepciones.YaExisteInscripcionTuristaSalida;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;

/**
 * Servlet implementation class InscripcionASalidaTuristica
 */
@WebServlet("/InscripcionASalidaTuristica")
public class InscripcionASalidaTuristica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscripcionASalidaTuristica() {
        super();
        // TODO Auto-generated constructor stub
       
    }
    
    
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	   ITuristica ct = Fabrica.getInstance().getControladorTuristica();
	   
	   if (request.getParameter("cantidad-turistas")==null) {
		   ct.seleccionarSalida(request.getParameter("nombreSalida"));
		   request.getSession().setAttribute("dtsalida",ct.getDTSalidaTuristica());
		   request.getRequestDispatcher("/WEB-INF/inscripcionASalidaTuristica.jsp").forward(request, response);
		   return;
	   }
	   Integer cant = Integer.parseInt(request.getParameter("cantidad-turistas"));
	   
	   IUsuario cu = Fabrica.getInstance().getControladorUsuario();
	   
	   String turi = ((DTTurista) request.getSession().getAttribute("usuario_dt")).getNickname();
	   
	   DTSalidaTuristica salida = (DTSalidaTuristica)request.getSession().getAttribute("dtsalida");
	   
	   if (cant > salida.getCuposDisponibles()) {
		   request.setAttribute("error", "CuposInsuficientes");
		   request.getRequestDispatcher("/WEB-INF/inscripcionASalidaTuristica.jsp").forward(request, response);
		   return;
	   }
	   
	   try {
		   cu.crearInscripcion(turi, salida.getNombre(), cant, salida.getActividadTuristicaAsoc().getCostoTurista(), LocalDate.now());
		   request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		   return;
	   } catch (YaExisteInscripcionTuristaSalida e1) {
		   request.setAttribute("error", "ExisteInscripcion");
		   request.getRequestDispatcher("/WEB-INF/inscripcionASalidaTuristica.jsp").forward(request, response);
		   return;
	   }
	    	
   }
   	   

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

}
