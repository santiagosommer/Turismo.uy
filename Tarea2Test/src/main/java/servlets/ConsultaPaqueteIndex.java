package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.DtPaquete;
import webservice.Publicador;
import webservice.PublicadorService;

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
    	
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
    	String cat = request.getParameter("Categorias");
    	request.setAttribute("categorias", port.listarCategorias().getDato());
    	if (cat == null)
        	request.setAttribute("lista_paquetes_a_mostrar", port.listarPaquetesCategoria("").getDato());
    	else
    		request.setAttribute("lista_paquetes_a_mostrar", port.listarPaquetesCategoria(cat).getDato());
    	
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
