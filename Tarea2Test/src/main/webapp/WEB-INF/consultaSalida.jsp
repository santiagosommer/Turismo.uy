<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
    <script >
       let i, tabcontent, tablinks;
       tabcontent = document.getElementsByClassName("tabcontent");
       tablinks = document.getElementsByClassName("tablinks");


       //Grab the first tab and open it
       tabcontent[0].style.display = "block";
       tablinks[0].classList += " selected";

       function openTab(evt, tabName) {
           // Get all elements with class="tabcontent" and hide them
           tabcontent = document.getElementsByClassName("tabcontent");
           for (i = 0; i < tabcontent.length; i++) {
               tabcontent[i].style.display = "none";
           }

           // Get all elements with class="tablinks" and remove the class "selected"
           tablinks = document.getElementsByClassName("tablinks");
           for (i = 0; i < tablinks.length; i++) {
               tablinks[i].className = tablinks[i].className.replace(" selected", "");
           }

           // Show the current tab, and add a "selected" class to the button that opened the tab
           document.getElementById(tabName).style.display = "block";
           document.getElementById(tabName+"-tab").classList += " selected";
       }
       
       </script>
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
             <a href = "/Tarea2Test/InscripcionASalidaTuristica?nombreSalida=<%=nombre%>"> <button id="botonInscripcionSalida">Inscribirse</button>
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