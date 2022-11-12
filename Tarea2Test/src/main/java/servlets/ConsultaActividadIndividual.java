package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.DtActividadTuristica;
import webservice.Publicador;
import webservice.PublicadorService;


/**
 * Servlet implementation class ConsultaActividadIndividual
 */
@WebServlet("/ConsultaActividadIndividual")
public class ConsultaActividadIndividual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaActividadIndividual() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    private void processRequest(
    	      HttpServletRequest request, HttpServletResponse response) 
    	      throws ServletException, IOException{
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
    	String nomAct = request.getParameter("paramAct"); //pasar en link
    	 if (nomAct != null) {
    		 port.seleccionarActividad(nomAct);
    		 DtActividadTuristica act = port.getDTActividadTuristica();
    		 request.getSession().setAttribute("act_dt", act);
    		 RequestDispatcher dispatcher = request.getRequestDispatcher(
         	          "/WEB-INF/consultaActividad1.jsp"); 
         	        dispatcher.forward(request, response);
    	 }
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			processRequest(request, response);
	}

}
