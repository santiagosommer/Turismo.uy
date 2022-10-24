<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/inscripcionASalidaTuristica.css"%></style>
    <title>Inscripcion Salida</title>
</head>
<body>
    
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    
        <div class="container">
         <form class="form-register" action="AltaTurista" method="post">
            <div class="h1">
                <h2>Inscribirse a Salida Turistica</h2>
            </div>
       <% String Error =  (String) request.getAttribute("error"); %>

        <div></div>    
            
            <div class="CantidadTuristas">
              <div class="input-container">
                    <div class="input-outer">
                        <img src="media/icons/avatar.svg" class="icon">
                        <input type="text" id="id-input" class="input-style" placeholder="Cantidad Turistas" name="cantidad-turistas" required>
                    </div>
                 </div>
            </div>     
           

            <div class="tabs">
                <div class="tab">
                <% //https://stackoverflow.com/questions/36304847/to-pass-a-parameter-form-one-jsp-page-to-another-using-onclick
                //forma1   %>
               	  <a href="#?param=general"> <button class="tablinks" onclick="openCity(event, 'General')">  General </button> </a>
              	  <a href="#?param=paquete"> <button class="tablinks" onclick="openCity(event, 'Paquete')">Paquete </button> </a>       
                </div>
                  <div id="General" class="tabcontent">
						<%  float costo = 0;
							if (request.getSession().getAttribute("costo")!= null){
								if (request.getParameter("cantidad-turistas")!=null	){
									costo = (float) request.getSession().getAttribute("costo");
									String cant = request.getParameter("cantidad-turistas");	
									int cantidadt =  Integer.parseInt(cant);
									costo = costo* cantidadt;
								}
							}%>
						
                    <p><b>Costo:</b> $<%= costo %> </p>
                  </div>

                  <div id="Paquete" class="tabcontent">
                    <select name="paquetes" class ="controls" id="Paquete">
                        <option value="gastronomia"> Paquetes Disponibles </option>

                      </select>
                    <p> <b> Descuento:  </b> 0.00%</p>

                    <p> <b> Costo:</b> $0.00</p>

                  </div>
                  <div class="botones">
                  	<input type="button" class="button" id="inscribirButton" value="Inscribirse">
                    <button type="button" id="cancelarButton" onclick="window.location.href='/Tarea2Dynamic/Home';">Cancelar</button>
                </div>



            </div>
            </form>

        </div>

    <script src="media/js/mantenerSesion.js"></script>
    <script src="media/js/inscripcionASalidaTuristica.js"></script>
</body>
</html>