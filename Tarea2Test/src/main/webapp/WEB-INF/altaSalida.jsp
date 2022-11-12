<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Set" %>
<%@page import="webservice.EstadoError"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/altaSalida.css"%></style>
    <title>Alta Salida</title>
    
</head>
<body>
    
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="container">
        <div class="imagen">
            <img src="media/icons/plus.svg">
        </div>
        <div class="texto">
            <h2>Agregar Salida Turistica</h2>
            
             <% EstadoError estadoError = (EstadoError) request.getAttribute("estado_error"); %>
             <% if (estadoError == EstadoError.ERROR_SALIDA){ %>
	        	<div class="error-frame">
	                		
              			Ya existe una salida con ese nombre.       			
	        	</div>
	        <% } %>
            
        </div>
		
        <div class="formulario ">
        <form action="AltaSalida" method="get">
            <div class="container2">
                <div class="departamentoycategorias">

                        <div class="img1"> <img src="media/icons/location2.svg" class="iconop" ></div>
                        
                        <% Set<String> departamentos = (Set<String>) request.getAttribute("listarDepartamentos");
                        %>
                         
                        <div class="s1">  <select class ="controls" name="departamento" id="cars">
                        
                        <%if (departamentos!=null)for (String dep : departamentos){ %>
                        
                            <option value="<%=dep%>"><%=dep%></option>
                            
						<%}%>
					

                          </select></div>
                          
                        <button type="button" class="boton" onclick="window.location.href = '/Tarea2Test/AltaSalida?depa='+document.getElementById('cars').value" id="extraButton">Select</button>
						
						 
                        <div class="img2"> <img src="media/icons/tag.svg" class="iconop" > </div>
                        
                        <% Set<String> actividades = (Set<String>) request.getAttribute("listarActividades");
                        %>
                        
                        <div class="s2">  <select name="actividades" class ="controls" id="cars" required>
                        
                        <%if (actividades!=null) for (String act : actividades){ %>
                        
                            <option value="<%=act%>"><%=act%></option>
                            
						<%}%>

                          </select></div>



                </div>
                <div class="c2">
                    <img src="media/icons/reservation.svg" class="iconop" >
                    <input type="text" name="nombre" class ="controls"  placeholder="Nombre de la Salida" required>
                </div>
                <div class="c3">
                    <img src="media/icons/clock.svg" class="iconop" >
                    <input class="controls" type="datetime-local" name="dateNHour" id="dateNHour" placeholder="Fecha y Hora de salida" required>
                </div>
                <div class="c4">
                    <img src="media/icons/location.svg" class="iconop" >
                    <input type="text" name="lugarsalida" class ="controls"  placeholder="Lugar de salida" required>
                </div>
                <div class="c5">
                    <div class="Costo"> <img src="media/icons/cuposMax.svg" class="iconop" >
                        <input type="number" min="1" name="maxcupos"  placeholder="Cupos maximos" class ="controls" required>
                    </div>
                </div>
                <div class="c6">
                    <img src="media/icons/image.svg" class="iconop"  >
                    <input class ="controls" type="file" name="img" id="img" placeholder="Seleccionar imagen" >
                </div>
                <div class="c7">
                    <input class="boton" type="submit" value="Confirmar">
                    <button type="button" class="boton2" onclick="window.location.href='/Tarea2Test/Home';" id="cancelButton">Cancelar</button>
                </div>
              </div>
		</form>
        </div>


    </div>

</body></html>