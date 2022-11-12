package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.DtProveedor;
import webservice.Publicador;
import webservice.PublicadorService;

/**
 * Servlet implementation class ConsultaProveedor
 */
@WebServlet("/ConsultaProveedor")
public class ConsultaProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaProveedor() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(
  	      HttpServletRequest request, HttpServletResponse response) 
  	      throws ServletException, IOException{
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
  //Consulta Proveedor
    String ID = request.getParameter("paramP");
    if (ID != null) {
    	port.seleccionarProveedor(ID);
    	DtProveedor prov = port.getDTProveedor();
        request.setAttribute("InfoProveedor", prov);
        request.getSession().setAttribute("prov_dt", prov);
        RequestDispatcher dispatcher2 = request.getRequestDispatcher(
  	          "/WEB-INF/consultaProveedorHardcoded.jsp"); 
  	        dispatcher2.forward(request, response);
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
