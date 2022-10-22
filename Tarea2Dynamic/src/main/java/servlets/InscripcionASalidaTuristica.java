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
import ServidorCentral.Logica.DataTypes.EstadoError;
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
    
    protected boolean checkFormulario(HttpServletRequest request) {
    	
    	IUsuario cu = Fabrica.getInstance().getControladorUsuario();
    	ITuristica ct = Fabrica.getInstance().getControladorTuristica();
    	String nomSal = request.getParameter("nombreSalida");
    	String Cant = request.getParameter("cantidad-turistas");
    	int cantTuristas = Integer.parseInt(Cant);
    	ct.seleccionarSalida(nomSal);
    	int cantCupos = ct.getDTSalidaTuristica().getCuposDisponibles();
    	
    	if (cantTuristas > cantCupos) {
    		request.setAttribute("error", "CuposInsuficientes");
    		return false;
    	}
    	
    	//ya existe inscripcion turista
    	if (request.getSession().getAttribute("usuario_dt") != null) {
            if (request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) {
          	  DTTurista turista = (DTTurista) request.getSession().getAttribute("usuario_dt");
          	  String nickTurista = turista.getNickname();
          	  cu.seleccionarTurista(nickTurista);
          	  if (ct.existeInscripcion(nomSal, nickTurista)) {
          		request.setAttribute("error", "ExisteInscripcion"); 
          		  return false;
          	  }
            }
    	}
    
    	
    	return true;
    }
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	IUsuario cu = Fabrica.getInstance().getControladorUsuario();
    	ITuristica ct = Fabrica.getInstance().getControladorTuristica();
    	
    	
    	LocalDate now = LocalDate.now();
    	String nomSal = request.getParameter("nombreSalida"); 
    	
    	if ( nomSal!=null) {
    		
    		if (request.getParameter("cantidad-turistas")==null) {
        		request.getRequestDispatcher("/WEB-INF/InscripcionASalidaTuristica.jsp").forward(request, response);
        		return;
        	}
        	
    		if (!checkFormulario(request)) {
        		request.getRequestDispatcher("/WEB-INF/InscripcionASalidaTuristica.jsp").forward(request, response);
        		return;
        	}
    		
    		
    		
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher(
      	          "/WEB-INF/inscripcionASalidaTuristica.jsp"); 
      	        dispatcher.forward(request, response); //ver donde va
      	        
      	        
      	     String Cant = request.getParameter("cantidad-turistas");
      	   if (Cant!=null) {
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
        	
        	
        	
          	  String tipo = request.getParameter("param");
              	 //caso general
               if (tipo.equals("general") )
                 try {
      			   cu.crearInscripcion(nickTuri, nomSal, cantidadTuristas, costo, now);
      			 } catch (YaExisteInscripcionTuristaSalida e) {
      				// TODO Auto-generated catch block
      				e.printStackTrace();
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
