package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.Publicador;
import webservice.PublicadorService;

/**
 * Servlet implementation class ConsultaActividadesIndex
 */
@WebServlet("/ConsultaActividadesIndex")
public class ConsultaActividadesIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaActividadesIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String dep = request.getParameter("Departamento");
    	String cat = request.getParameter("Categoria");
    	
    	if (dep == null) dep = "";
    	if (cat == null) cat = "";
    	
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        
    	request.setAttribute("departamentos", port.listarDepartamentos().getDato());
    	
    	request.setAttribute("categorias", port.listarCategorias().getDato());
    	
    	request.setAttribute("lista_actividades_a_mostrar", port.listarActividadesDeptoYCate(dep, cat).getDato());
    	
		request.getRequestDispatcher("/WEB-INF/consultaActividadesMobile.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
