<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.util.HashSet"%>
    <%@page import="webservice.*"%>
    <style><%@include file="./../media/css/consultaIndex.css"%></style>
    <title>Consulta Paquetes</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>
    
     <%
     ArrayList<String> cats = (ArrayList<String>) request.getAttribute("categorias");
     ArrayList<DtPaquete> paqs = (ArrayList<DtPaquete>) request.getAttribute("lista_paquetes_a_mostrar");
        %>
    
    <div style="display: flex; flex-direction: column;">
        <div style="display:flex; align-items: center; gap: 20px; justify-content: center;">
            <img src="media/icons/money.svg" style="height:96px; " alt="">
            <h1 style="text-align: center;">Consultar paquetes</h1>
        </div>
        <div class="content">
        
  
            <div class="filtros">
            <form class="filtros" action="ConsultaPaqueteIndex" method="get">
                <div class="filtro">
                    <select name="Categorias" class="Categorias">
                    <option value="Categorias">Categorias</option>
                     <%for (int i=0; i< cats.size();i++) {%>
                        <option value="<%= cats.get(i) %>"><%= cats.get(i) %></option>
                        <% } %>
                    </select>
                    <input type="submit" class="button" id="consultaPaquete" value="Consultar">
                </div>
                </form>
            </div>
            <div class="Consultas">
            <%for (int i=0; i< paqs.size();i++)  {%>
            
                <div class="conjuntoConsulta">
                    <div class="imagen">
                        <img src="media/icons/avatar.svg" height="200">
                    </div>
                    <div class="descripcion">
                        <div class="nombre">
                            <%= paqs.get(i).getNombre() %>
                        </div>
                        <%= paqs.get(i).getDescripcion() %>
                        <a href="/Tarea2Test/ConsultaPaquete?paramPaq=<%= paqs.get(i).getNombre()%>" class="links selected">Leer mas.</a>
                    </div>
                </div>
                <hr>
                <%} %>
                
                
                
                
            </div>
        </div>
    </div>
    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>
