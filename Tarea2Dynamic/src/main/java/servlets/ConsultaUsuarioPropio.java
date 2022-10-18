package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.DTUsuario;

/**
 * Servlet implementation class ConsultaUsuarioPropio
 */
@WebServlet("/ConsultaUsuarioPropio")
public class ConsultaUsuarioPropio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuarioPropio() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	DTUsuario usr = (DTUsuario) request.getSession().getAttribute("usuario_dt");
    	//request.setAttribute("dt", usr); //
    	request.getRequestDispatcher("/WEB-INF/consultaUsuarioPropio.jsp").forward(request, response);
    	
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
