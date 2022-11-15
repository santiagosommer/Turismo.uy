package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.DtActividadTuristica;
import webservice.DtPaquete;
import webservice.Publicador;
import webservice.PublicadorService;

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
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
    	String nomPaq = request.getParameter("paramPaq"); 
    	ArrayList<DtActividadTuristica> actividades = new ArrayList<DtActividadTuristica>();
    	
    	 if (nomPaq != null) {
    		 port.seleccionarPaquete(nomPaq);
    		List<String> acts = port.listarActividadesPaquete().getDato();
    		for (String act: acts) {
    			port.seleccionarActividad(act);
    			DtActividadTuristica agregar = port.getDTActividadTuristica();
    			actividades.add(agregar);
    			
    		}
    		 
    		 DtPaquete paq = port.getDtPaquete();
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
