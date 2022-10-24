package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;

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
    	String nomPaq = request.getParameter("paramPaq"); 
    	 if (nomPaq != null) {
    		 paqs.seleccionarPaquete(nomPaq);
    		 DTPaquete paq = paqs.getDtPaquete();
    		 request.getSession().setAttribute("paq_dt", paq);
    		 RequestDispatcher dispatcher = request.getRequestDispatcher(
         	          "/WEB-INF/ConsultaPaquete.jsp"); 
         	        dispatcher.forward(request, response);
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
