<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
    <title>Consulta Salida</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

<div class="content">
        <div class="Consultas">
        
        <% String fecha = "";
           String hora = "";
           String cupos = "";
           String lugar = "";
           String nombre = "";
           if (request.getSession().getAttribute("salida_dt") != null) {
        	   DTSalidaTuristica s = (DTSalidaTuristica) request.getSession().getAttribute("salida_dt") ;
        	   nombre = s.getNombre();
        	   fecha = s.getInfoSalida().getFecha().toString();
        	   hora = s.getInfoSalida().getHora().toString();
        	   lugar = s.getInfoSalida().getLugar();
        	   cupos = String.valueOf(s.getCuposDisponibles());
           }%>
            <div class="container-consulta">
                <div class="img-container">
                    <img src = "https://s3.amazonaws.com/turismorocha/operadores/1/med/bahia-resto-053888900-1458674720.JPG" class="imagenSalidaDegusta">
                </div>
                <h3> <%= nombre %> </h3>
                
                <%        if (request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) { %>
             <a href = "/Tarea2Dynamic/InscripcionASalidaTuristica?nombreSalida=<%=nombre%>"> <button id="botonInscripcionSalida">Inscribirse</button>
             </a>   
             <%} %>
            </div>
            <div class="top-bar-links">
                <div class="tab">
                    <div class="tablinks" id="Perfil-tab" onclick="openTab(event, 'Perfil')">
                        Info
                    </div>
                </div>                
            </div>
            <div class="tab-contents">
                <div id="Perfil" class="tabcontent">
                    <p><b>Fecha:</b> <%= fecha  %></p>
                    <p><b>Hora:</b> <%= hora  %> </p>
                    <p><b>Cupos Disponibles:</b> <%= cupos  %></p>
                    <p><b>Lugar:</b>  <%= lugar %></p>
                </div>                
            </div>
        </div>
</div>

    <script src="./../js/consultaDeUsuario.js"></script>
    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>