package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.DtTurista;
import webservice.Publicador;
import webservice.PublicadorService;

/**
 * Servlet implementation class ConsultaTurista
 */
@WebServlet("/ConsultaTurista")
public class ConsultaTurista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaTurista() {
        super();
        // TODO Auto-generated constructor stub
        
    
    }
    
    private void processRequest(
  	      HttpServletRequest request, HttpServletResponse response) 
  	      throws ServletException, IOException{
    	
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        
        String IDTuri = request.getParameter("paramT");
        if (IDTuri != null) {
        	port.seleccionarTurista(IDTuri);
        	DtTurista turi = port.getDTTurista(); 
        	request.getSession().setAttribute("turi_dt", turi);
            request.setAttribute("InfoTurista", turi); //?
            RequestDispatcher dispatcher3 = request.getRequestDispatcher(
      	          "/WEB-INF/consultaUsuarioHardcoded.jsp"); 
      	        dispatcher3.forward(request, response);
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
