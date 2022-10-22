package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;

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
    	
    	Fabrica fa = Fabrica.getInstance();
    	ITuristica itur = fa.getControladorTuristica();
    	
    	request.setAttribute("departamentos", itur.listarDepartamentos());
    	
    	request.setAttribute("categorias", itur.listarCategorias());
    	
    	request.setAttribute("lista_actividades_a_mostrar", itur.listarActividadesDeptoYCate(dep, cat));
    	
		request.getRequestDispatcher("/WEB-INF/consultaActIndex.jsp").forward(request, response);
		
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
