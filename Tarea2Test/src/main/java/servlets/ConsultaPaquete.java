package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;

/**
 * Servlet implementation class ConsultaPaquete
 */
@WebServlet("/ConsultaPaquete")
public class ConsultaPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaPaquete() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Fabrica fab = Fabrica.getInstance();
    	IPaquete paqs = fab.getControladorPaquete();
    	ITuristica ctrTur = fab.getControladorTuristica();
    	String nomPaq = request.getParameter("paramPaq"); 
    	ArrayList<DTActividadTuristica> actividades = new ArrayList<DTActividadTuristica>();
    	
    	 if (nomPaq != null) {
    		 paqs.seleccionarPaquete(nomPaq);
    		Set<String> acts = paqs.listarActividadesPaquete();
    		for (String act: acts) {
    			ctrTur.seleccionarActividad(act);
    			DTActividadTuristica agregar = ctrTur.getDTActividadTuristica();
    			actividades.add(agregar);
    			
    		}
    		 
    		 DTPaquete paq = paqs.getDtPaquete();
    		 request.getSession().setAttribute("paq_dt", paq);
    		 request.getSession().setAttribute("ActPaq", actividades);
    		 request.getRequestDispatcher("/WEB-INF/ConsultaPaquete.jsp").forward(request, response); 
         	        
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
