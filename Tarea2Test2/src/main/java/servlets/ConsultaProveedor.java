package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.DTProveedor;
import ServidorCentral.Logica.Excepciones.UsuarioNoExisteException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IUsuario;

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
  	      throws ServletException, IOException, UsuarioNoExisteException {
  	
  	Fabrica fab = Fabrica.getInstance();
  	IUsuario ctrlUsr = fab.getControladorUsuario();
  //Consulta Proveedor
    String ID = request.getParameter("paramP");
    if (ID != null) {
    	ctrlUsr.seleccionarProveedor(ID);
    	DTProveedor prov = ctrlUsr.getDTProveedor();
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
