<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/inscripcionASalidaTuristica.css"%></style>
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
    <%@page import=" java.util.ArrayList"%>
     <%@page import= "java.util.Iterator"%>
    <title>Inscripcion Salida</title>
</head>
<body>
    
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    
        <div class="container">
            <div class="h1">
                <h2>Inscribirse a Salida Turistica</h2>
            </div>

	<div class="error-frame">
       
       <% String Error =  (String) request.getAttribute("error");
       
       %>
       <% 
       if (Error!= null){ %>
       
    	<% if (Error.equals("CuposInsuficientes")){ %>
 			No hay suficientes cupos.
 		<% } 
 		  if (Error.equals("ExisteInscripcion")){ %>
 			Ya existe una inscripcion.
 		<%}} %>
 		
       
	</div>

       <form class="form-register" > 
            
            <div class="CantidadTuristas">
              <div class="input-container">
                    <div class="input-outer">
                        <img src="media/icons/avatar.svg" class="icon">
                        <% 
                      // String valor ="";
                    //    if (request.getParameter("cantidad-turistas")!=null) {                    
                        //	 valor = request.getParameter("cantidad-turistas");
                        //} //para evitar lo de null
                        	                   
                        %>
                        
                        <input type="text"  id="id-input" class="input-style" placeholder="Cantidad Turistas" name="cantidad-turistas" required value= <%= request.getParameter("cantidad-turistas")%> >
                    </div>
                 </div>
            </div>     
           

            <div class="tabs">
                <div class="tab">
               
    			 <a href="#?param=general"> <button class="tablinks" onclick="openCity(event, 'General')">  General </button> </a>
              	  <a href="#?param=paquete"> <button class="tablinks" onclick="openCity(event, 'Paquete')"> Paquete </button> </a>       
                </div>
                  <div id="General" class="tabcontent"> 
                  <% 		
                  		ArrayList<DTPaquete> paquetesComprados = new ArrayList<DTPaquete>();
                  			float costo = 0;
                 			 int cantidadt = 0;
							if (request.getSession().getAttribute("dtsalida")!= null) {
								DTSalidaTuristica salida = (DTSalidaTuristica) request.getSession().getAttribute("dtsalida");
								costo = salida.getActividadTuristicaAsoc().getCostoTurista();
								if (request.getParameter("cantidad-turistas")!=null	) {
									String cant = request.getParameter("cantidad-turistas");	
									cantidadt =  Integer.parseInt(cant);
									
								}
								
								costo = costo * cantidadt;
								
							} %>
						
                    <p><b>Costo:</b>  $<%= costo %> </p>
                  </div>

                  <div id="Paquete" class="tabcontent">
                    <select name="paquetes" class ="controls" id="Paquete">
                     <option value="gastronomia"> Paquetes Disponibles </option>
                        <%for (DTPaquete p : paquetesComprados) {%>
		            			 <option value="gastronomia">  
		                    	<%= p.getNombre()  %>
		                    	</option>
	                   		<% } %>
                       
							
                      </select>
                    <p> <b> Descuento:  </b> 0.00%</p>

                    <p> <b> Costo:</b> $0.00</p>

                  </div>
                  <div class="botones">
                  <input type="submit" class="button" id="inscribirButton" value="Inscribirse"> 
                  <button type="button" id="cancelarButton" onclick="window.location.href='/Tarea2Dynamic/Home';">Cancelar</button>
                </div>



            </div>
            
            </form>

        </div>

    <script src="media/js/mantenerSesion.js"></script>
    <script src="media/js/inscripcionASalidaTuristica.js"></script>
</body>
</html>