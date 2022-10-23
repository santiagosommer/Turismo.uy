package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServidorCentral.Logica.DataTypes.DTProveedor;
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.DataTypes.EstadoSesion;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IUsuario;

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
    	
    	IUsuario cru = Fabrica.getInstance().getControladorUsuario();
    	if (request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_PROVEEDOR) {
    		DTProveedor pro = (DTProveedor) request.getSession().getAttribute("usuario_dt");
    		cru.seleccionarProveedor(pro.getNickname());
    		request.getSession().setAttribute("usuario_dt", cru.getDTProveedor());
    	}
    	
    	if (request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) {
    		DTTurista turi = (DTTurista) request.getSession().getAttribute("usuario_dt");
    		cru.seleccionarTurista(turi.getNickname());
    		request.getSession().setAttribute("usuario_dt", cru.getDTTurista());
    	}
    	
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
