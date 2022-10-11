package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.EstadoSesion;

/**
 * Servlet implementation class IniciarSesion
 */
@WebServlet("/IniciarSesion")
public class IniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request)
	{
		return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
	}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	switch(getEstado(request)){
		case NO_LOGIN:
			// hace que se ejecute el jsp sin cambiar la url
			request.getRequestDispatcher("/WEB-INF/inicioDeSesion.jsp").
					forward(request, response);
			break;
		case LOGIN_INCORRECTO:
			// hace que se ejecute el jsp sin cambiar la url
			request.getRequestDispatcher("/WEB-INF/inicioDeSesion.jsp").
					forward(request, response);
			break;
		case LOGIN_CORRECTO:
			// manda una redirección a otra URL (cambia la URL)
			response.sendRedirect("/WEB-INF/index.jsp");
			break;
	}
    	
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/inicioDeSesion.jsp");
		dispatcher.forward(request, response);
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
