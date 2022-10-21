package servlets;

import java.io.IOException;
import java.time.LocalDate;

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
    	IUsuario cu = Fabrica.getInstance().getControladorUsuario();
    	ITuristica ct = Fabrica.getInstance().getControladorTuristica();
    	
    	
    	LocalDate now = LocalDate.now();
    	String nomSal = request.getParameter("nombreSalida"); //pasar con el link en el boton de inscribirse
    	String Cant = request.getParameter("cantidad-turistas");	
    	if (Cant!= null && nomSal!=null) {
    		int cantidadTuristas = Integer.parseInt(Cant);
    		ct.seleccionarSalida(nomSal);
    		int cupos = ct.getDTSalidaTuristica().getCuposDisponibles();
    		float costo = ct.getDTSalidaTuristica().getActividadTuristicaAsoc().getCostoTurista();
    		request.getSession().setAttribute("costo",costo );
    		String nickTuri = "";
        	if (request.getSession().getAttribute("usuario_dt") != null) {
              if (request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) {
            	  DTTurista turista = (DTTurista) request.getSession().getAttribute("usuario_dt");
            	  nickTuri = turista.getNickname();
            	  cu.seleccionarTurista(nickTuri);
            	  
            	  
              }
        	}
        	
        	if(cantidadTuristas <= cupos) {
          	   String tipo = request.getParameter("param");
              	 //caso general
               if (tipo.equals("general") && nomSal!= null ) {
              	try {
      				cu.crearInscripcion(nickTuri, nomSal, cantidadTuristas, costo, now);
      			 } catch (YaExisteInscripcionTuristaSalida e) {
      				// TODO Auto-generated catch block
      				e.printStackTrace();
      			}
        
          	   }
              }

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
