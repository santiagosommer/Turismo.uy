<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <%@page import="java.util.Set"%>
    <%@page import="java.util.HashSet"%>
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
    <%! @SuppressWarnings("unchecked") %>
    <style><%@include file="./../media/css/consultaIndex.css"%></style>
    <title>Consulta Paquetes</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>
    
     <%
        Set<String> cats = (Set<String>) request.getAttribute("categorias");
     	Set<DTPaquete> paqs = new HashSet<DTPaquete>();
         paqs = (Set<DTPaquete>) request.getAttribute("lista_paquetes_a_mostrar");
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
                     <%for (String c : cats) {%>
                        <option value= <%= c %>> <%= c %></option>
                        <% } %>
                    </select>
                    <input type="submit" class="button" id="consultaPaquete" value="Consultar">
                </div>
                </form>
            </div>
            <div class="Consultas">
            <%for (DTPaquete p : paqs) {%>
            
                <div class="conjuntoConsulta">
                    <div class="imagen">
                        <img src="media/icons/avatar.svg" height="200">
                    </div>
                    <div class="descripcion">
                        <div class="nombre">
                            <%= p.getNombre() %>
                        </div>
                        <%= p.getDescripcion() %>
                        <a href="/Tarea2Test/ConsultaPaquete?paramPaq=<%= p.getNombre()%>" class="links selected">Leer mas.</a>
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
