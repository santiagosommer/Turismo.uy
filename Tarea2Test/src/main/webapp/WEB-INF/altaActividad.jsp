<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="webservice.EstadoError"%>
<%@page import="webservice.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/altaActividad.css"%></style>
    <title>Alta Actividad</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="container">
        <div class="imagen">
            <img src="media/icons/plus.svg">
        </div>
        <div class="texto">
            <h2>Agregar Actividad Turistica</h2>
            
            <% EstadoError Error =  (EstadoError) request.getAttribute("estado_error"); %>
		<% if (Error!= null){ %>
			<div class="error-frame">
		       
		       <% if (Error == EstadoError.ERROR_NICK_OR_EMAIL) {%>
		       		Nombre repetido.
		       <%} %>
		    	<% if (Error == EstadoError.ERROR_CONTRA){ %>
		 			Duracion debe ser mayor a 0.
		 		<% } 
		 		  if (Error == EstadoError.ERROR_EMAIL){ %>
		 			Costo debe ser mayor a 0.
		 		<%} %>
		 		
		       
			</div>
			
		<% } %>
            
        </div>
        
        <div class="formulario">
        	<form class="formulario" action="AltaActividad" method="get">
            <div class="container2">
		
                <div class="departamentoycategorias">

                        <div class="img1"> <img src="media/icons/location2.svg" class="iconop" ></div>
                        <div class="s1">  
                        	<select class ="controls" name="departamento" id="depas">
	                        	<% SetString departamentosdt = (SetString) request.getAttribute("depas_act");
	                        	List<String> departamentos = departamentosdt.getDato();
	                        	%>
	                        	<%	for (int i = 0; i < departamentos.size(); i++) { %>
	                        	    <option value="<%= departamentos.get(i) %>"><%= departamentos.get(i) %></option>
	                        	<% } %>
	                   
                          	</select>
                        </div>
                        <div class="img2"> <img src="media/icons/tag.svg" class="iconop" > </div>
                        <div class="s2">  
                        	<select name="categorias" class ="controls" id="categ" required multiple>
                        	
                        		<% SetString categoriasdt = (SetString) request.getAttribute("cat_act");
                        		List<String> categorias = categoriasdt.getDato(); %>
                        		<%	for (int i = 0; i < categorias.size(); i++) { %>
                        	    	<option value="<%= categorias.get(i) %>"><%= categorias.get(i) %></option>
                        		<% } %>
                          	</select>
                        </div>
                </div>
                <div class="c2">
                    <img src="media/icons/reservation.svg" class="iconop" >
                    <input type="text" name="nombre_alta_actividad" class ="controls"  placeholder="Nombre de la Actividad" required>
                </div>
                <div class="c3">
                    <img src="media/icons/write.svg" class="iconop" >
                    <input  type="text" name="descripcion" id="descripcion" class ="controls"  placeholder="Descripcion" required>
                </div>
                <div class="c4">
                    <img src="media/icons/clock.svg" class="iconop" >
                    <input type="number" min="1" name="duracion" class ="controls"  placeholder="Duracion hh" required>
                </div>
                <div class="c5">
                    <div class="Costo ">
                        <img src="media/icons/money2.svg" class="iconop" >
                        <input type="number" min="0.01" step="0.01" name="costo"  placeholder="Costo" class ="controls" required>
                    </div>
                </div>
                <div class="c6">
                    <div class="ciudad ">
                        <img src="media/icons/location.svg" class="iconop" >
                        <input type="text" name="ciudad"  placeholder="Ciudad" class ="controls" required>
                    </div>
                </div>
                <div class="c7">
                    <img src="media/icons/image.svg" class="iconop"  >
                    <input class ="controls" type="file" name="img" id="img" placeholder="Seleccionar imagen">
                </div>
                <div class="c8">
                    <input class="boton" type="submit" value="Confirmar">
                    <button type="button" class="boton2" onclick="window.location.href='/web/Home';" id="cancelButton">Cancelar</button>
                </div>
              </div>
              </form>
        </div>
    </div>
</body>
</html>