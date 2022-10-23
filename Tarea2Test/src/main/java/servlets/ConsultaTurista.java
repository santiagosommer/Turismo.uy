package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.Excepciones.UsuarioNoExisteException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IUsuario;

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
  	      throws ServletException, IOException, UsuarioNoExisteException {
    	
    	
      	Fabrica fab = Fabrica.getInstance();
      	IUsuario ctrlUsr = fab.getControladorUsuario();
        String IDTuri = request.getParameter("paramT");
        if (IDTuri != null) {
        	ctrlUsr.seleccionarTurista(IDTuri);
        	DTTurista turi = ctrlUsr.getDTTurista(); 
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
		try {
			processRequest(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioNoExisteException e) {
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
			processRequest(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
