<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <%@page import="java.util.Set"
			import="java.util.ArrayList"
    
    
    %>
    <%@page import="java.util.Iterator"%>
    <%@page import="java.util.Iterator"%>
    <%@page import="webservice.*"%>
    <style><%@include file="./../media/css/consultaIndex.css"%></style>
    <title>Consulta Actividades</title>
</head>
<body>
        
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>
        
        
    <div style="display: flex; flex-direction: column;">
        <div style="display:flex; align-items: center; gap: 20px; justify-content: center;">
            <img src="./../icons/shark.svg" style="height:96px; " alt="">
            <h1 style="text-align: center;">Consultar actividades</h1>
        </div>
        
        <%
        ArrayList<String> deptos = (ArrayList<String>) request.getAttribute("departamentos");
        Set<String> cats = (Set<String>) request.getAttribute("categorias");
        Set<DtActividadTuristica> acts = (Set<DtActividadTuristica>) request.getAttribute("lista_actividades_a_mostrar");
        %>
        <div class="content">

            <div class="filtros">
            <form class="filtros" action="ConsultaActividadesIndex" method="get">
                <div class="filtro">
                    <select name="Departamento" class="Departamento">
                        <option value="Departamento">Departamento</option>
                        <%for (String s : deptos) {%>
	            			<option value="<%= s %>">
	                    	<%= s %>
	                    	</option>
                    	<% } %>
                    </select>
                </div>
                <div class="filtro">
                      <select name="Categoria" class="Categoria">
                          <option value="Categoria">Categoria</option>
                           <%for (String s : cats) {%>
		            			<option value="<%= s %>">
		                    	<%= s %>
		                    	</option>
	                   		<% } %>
                      </select>
                </div>
                <div class="filtro">
                        <input type="submit" class="button" id="consultaActividad" value="Consultar">
                </div>
            </form>
            </div>
            <div class="Consultas">
            
            	<%for (DtActividadTuristica s : acts) {%>
	                 <div class="conjuntoConsulta">
	                    <div class="imagen">
	                        <img src="media/icons/avatar.svg" height="200">
	                    </div>
	                    <div class="descripcion">
	                        <div class="nombre">
	                           <%= s.getNombre() %>
	                        </div>
	                        <%= s.getDescripcion() %>
	                        <a href="/Tarea2Test/ConsultaActividadIndividual?paramAct=<%= s.getNombre()%>" class="links selected">Leer mas.</a>
	                    </div>
	                </div>
	                <hr>
                <% } %>
                
            </div>
        </div>
    </div>

    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>
