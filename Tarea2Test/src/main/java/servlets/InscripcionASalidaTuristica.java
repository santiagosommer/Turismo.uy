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

import webservice.Publicador;
import webservice.PublicadorService;
import webservice.YaExisteInscripcionTuristaSalida_Exception;
import webservice.DtSalidaTuristica;
import webservice.DtUsuario;


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
			throws ServletException, IOException, DatatypeConfigurationException {
	   
	   PublicadorService service = new PublicadorService();
       Publicador port = service.getPublicadorPort();
	   
	   if (request.getParameter("cantidad-turistas")==null) {
		   port.seleccionarSalida(request.getParameter("nombreSalida"));
		   request.getSession().setAttribute("dtsalida",port.getDTSalidaTuristica());
		   request.getRequestDispatcher("/WEB-INF/inscripcionASalidaTuristica.jsp").forward(request, response);
		   return;
	   }
	   Integer cant = Integer.parseInt(request.getParameter("cantidad-turistas"));
	   
	   String turi = ((DtUsuario) request.getSession().getAttribute("usuario_dt")).getNickname();
	   
	   DtSalidaTuristica salida = (DtSalidaTuristica)request.getSession().getAttribute("dtsalida");
	   
	   if (cant<=0) {
		   request.setAttribute("error", "Negativo");
		   request.getRequestDispatcher("/WEB-INF/inscripcionASalidaTuristica.jsp").forward(request, response);
		   return;
	   }
	   
	   if (cant > salida.getCuposDisponibles()) {
		   request.setAttribute("error", "CuposInsuficientes");
		   request.getRequestDispatcher("/WEB-INF/inscripcionASalidaTuristica.jsp").forward(request, response);
		   return;
	   }
	   
	   LocalDate localDate1 = LocalDate.of(
			   salida.getInfoSalida().getFecha().getYear(), 
			   salida.getInfoSalida().getFecha().getMonth(), 
			   salida.getInfoSalida().getFecha().getDay());
		if(localDate1.isBefore(LocalDate.now())) {
		   request.setAttribute("error", "SalidaExpirada");
		   request.getRequestDispatcher("/WEB-INF/inscripcionASalidaTuristica.jsp").forward(request, response);
		   return;
	   }
	   
	   try {
		   
		   port.crearInscripcion(turi, salida.getNombre(), cant, salida.getActividadTuristicaAsoc().getCostoTurista(), DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDate.now().toString()));
		   request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		   return;
	   } catch (YaExisteInscripcionTuristaSalida_Exception e1) {
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
			try {
				processRequest(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			try {
				processRequest(request,response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
