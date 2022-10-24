package servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;

/**
 * Servlet implementation class ConsultaPaqueteIndex
 */
@WebServlet("/ConsultaPaqueteIndex")
public class ConsultaPaqueteIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaPaqueteIndex() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ITuristica itur = Fabrica.getInstance().getControladorTuristica();
    	String cat = request.getParameter("Categoria");
    	request.setAttribute("categorias", itur.listarCategorias());
    	request.setAttribute("lista_paquetes_a_mostrar", itur.listarPaquetesCategoria(cat));
    	
    	IPaquete ipaq = Fabrica.getInstance().getControladorPaquete();
    	
    	
    	request.getRequestDispatcher("/WEB-INF/consultaPaqIndex.jsp").forward(request, response);
    	
    	
    	
    	
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
