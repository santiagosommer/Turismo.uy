<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
     <%@page import="java.util.Set"%>
    <%@page import=" java.util.ArrayList"%>
    <%@page import="webservice.*"%>
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
    <title>Consulta Paquete</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>


		<% 

	
		DtPaquete paq = (DtPaquete) request.getSession().getAttribute("paq_dt");
		String  nombre = paq.getNombre();
		%>

<div class="content">
  <div class="Consultas">
    <div class="container-consulta">
      <div class="img-container">
        <img src="media/icons/avatar.svg" height="200">
      </div>
      <h3><%= nombre %></h3>
      <button id="botonComprarPaquete" onclick="location.href='/Tarea2Test/ComprarPaquete'">Comprar Paquete </button>
    </div>
    <div class="top-bar-links">
      <div class="tab">
        <div class="tablinks" id="Perfil-tab" onclick="openTab(event, 'Perfil')">
          Perfil
        </div>
      </div>
      <div class="tab">
        <div class="tablinks" id="Actividades-tab" onclick="openTab(event, 'Actividades')">
          Actividades
        </div>
      </div>
      <div class="tab">
        <div class="tablinks" id="Categorias-tab" onclick="openTab(event, 'Categorias')">
          Categorias
        </div>
      </div>
    </div>
    <div class="tab-contents">
      <div id="Perfil" class="tabcontent">
        <p><b>Validez:</b> <%= paq.getPeriodoValidez() %> dias</p>
        <p><b>Descuento:</b> <%= paq.getDescuento()  %> % </p>
        <p><b>Fecha Alta:</b> <%= paq.getFechaAlta() %></p>
        <p><b>Descripcion:</b> <%= paq.getDescripcion() %></p>
      </div>
      <div id="Actividades" class="tabcontent">
      <% ArrayList<DtActividadTuristica> act = (ArrayList<DtActividadTuristica>) request.getSession().getAttribute("ActPaq");
      if (act!= null){
      	for (DtActividadTuristica a: act){  %>
      
        <div class="Actividad">
          <div class="imagenSalida">
            <img src = "media/icons/avatar.svg" height="200">
          </div>
          <div class="Salida-text">
            <h3><%= a.getNombre() %></h3>
            <p><a href="/Tarea2Test/ConsultaActividadIndividual?paramAct=<%= a.getNombre()%>" class="links">Leer mas.</a></p>
          </div>
        </div>
        <%}%> 
        
      </div>
      
      <div id="Categorias" class="tabcontent">
      
      	<% ArrayList<String> p = new ArrayList<String>();
      	for (DtActividadTuristica a: act){ 
      		ArrayList<String> cats = (ArrayList<String>) a.getCategorias();
            for (int i=0; i< cats.size();i++){  
            	if (!p.contains(cats.get(i))) {
            		p.add(cats.get(i)); %> 
      	       <p><b> <%= cats.get(i) %> </b></p>
        <% } }}}%>
      </div>
    </div>
  </div>
</div>
	<script>window.onload=openTab(event, 'Perfil');</script>
    <script src="./../js/consultaDeUsuario.js"></script>
    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>