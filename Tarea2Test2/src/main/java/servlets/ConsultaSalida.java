package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;

/**
 * Servlet implementation class ConsultaSalida
 */
@WebServlet("/ConsultaSalida")
public class ConsultaSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaSalida() {
        super();
    }
    
    
    
    private void processRequest(
    	      HttpServletRequest request, HttpServletResponse response) 
    	      throws ServletException, IOException {
      	
      	
          Fabrica fab = Fabrica.getInstance();
          ITuristica ctrlAct = fab.getControladorTuristica();
          String IDSalida = request.getParameter("paramS");
          if (IDSalida != null) {
          	ctrlAct.seleccionarSalida(IDSalida);
          	DTSalidaTuristica sal = ctrlAct.getDTSalidaTuristica();
          	request.getSession().setAttribute("salida_dt", sal);
              //request.setAttribute("InfoTurista", turi); //?
              RequestDispatcher dispatcher = request.getRequestDispatcher(
        	          "/WEB-INF/consultaSalida.jsp"); 
        	        dispatcher.forward(request, response);
          }
      }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		processRequest(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		
	}

}
