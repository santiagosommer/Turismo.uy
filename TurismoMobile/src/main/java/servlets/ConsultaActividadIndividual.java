package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.DtActividadTuristica;
import webservice.DtProveedor;
import webservice.EstadoActividad;
import webservice.EstadoSesion;
import webservice.Publicador;
import webservice.PublicadorService;


/**
 * Servlet implementation class ConsultaActividadIndividual
 */
@WebServlet("/ConsultaActividadIndividual")
public class ConsultaActividadIndividual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaActividadIndividual() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    private void processRequest(
    	      HttpServletRequest request, HttpServletResponse response) 
    	      throws ServletException, IOException{
    	PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
    	String nomAct = request.getParameter("paramAct"); 
    	Boolean finalizable = false;
    	 if (nomAct != null) {
    		 port.seleccionarActividad(nomAct);
    		 DtActividadTuristica actividad = port.getDTActividadTuristica();
    		 
    		 if ((EstadoSesion) request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_PROVEEDOR){
      			if ((DtProveedor) request.getSession().getAttribute("usuario_dt") != null) {
      				
          		   DtProveedor prov = (DtProveedor) request.getSession().getAttribute("usuario_dt");
          		   String nomProv = prov.getNombre() + " " + prov.getApellido(); //tambien se puede modificar que la actividad sea propia si se guarda el nickName del proveedor 
          		   
          		 if (nomProv.equals(actividad.getProveedor()) && actividad.getInfoPaquetes().isEmpty() && actividad.getEstado() == EstadoActividad.CONFIRMADA ){
          			 port.seleccionarProveedor(prov.getNickname());
          			 if (port.datosSalidasVigentes(actividad.getNombre()) == null) { //por que no funciona empty?
          				 request.getSession().setAttribute("finalizable", true);
          			 }
          			 
          			 
          		 }
      		}
        
      	  }
    		 DtActividadTuristica act = port.getDTActividadTuristica();
    		 request.getSession().setAttribute("act_dt", act);
    		 RequestDispatcher dispatcher = request.getRequestDispatcher(
         	          "/WEB-INF/consultaActividadMobile.jsp"); 
         	        dispatcher.forward(request, response);
    	 }
    	
    	 
    	 if (finalizable) {
    		 
    		// port.finalizarActividadProveedor() (esta en el otro proyecto)
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
