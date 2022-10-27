<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
     <%@page import="java.util.Set"%>
    <%@page import="java.util.Iterator"%>
    <%@page import=" java.util.ArrayList"%>
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    <title>Consulta Actividad</title>
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
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>
    <div class="content">
     <%  
     	String nombre = "";
     	int duracion = 0;
     	float costo = 1;
     	String ciudad = "";
     	String fechaAlta = "";
     	Set<String> cate = null;
     	String descripcion = "";
     	//agregar paquetes
     	ArrayList<DTPaquete> paque = new ArrayList<DTPaquete>();
     	ArrayList<DTSalidaTuristica> Salidas = new ArrayList<DTSalidaTuristica>();
         if (request.getSession().getAttribute("act_dt") != null) {
     		DTActividadTuristica act = (DTActividadTuristica) request.getSession().getAttribute("act_dt");
     		nombre = act.getNombre();
     		duracion = act.getDuracion();
     		costo = act.getCostoTurista();
     		ciudad = act.getCiudad();
     		fechaAlta = act.getFechaAlta().toString();
     		descripcion = act.getDescripcion();
     		Salidas = act.getSalidas();
     		cate = act.getCategorias();
     		paque = act.getInfoPaquetes();
     	  }
     %>
        <div class="Consultas">
          <div class="container-consulta">
            <div class="img-container">
              <img src="media/icons/avatar.svg" height="200">
            </div>
            <h3><%= nombre %></h3>
          </div>
          <div class="top-bar-links">
            <div class="tab">
              <div class="tablinks" id="Info-tab" onclick="openTab(event, 'Info')">
                Info
              </div>
            </div>
            <div class="tab">
              <div class="tablinks" id="Salidas-tab" onclick="openTab(event, 'Salidas')">
                Salidas
              </div>
            </div>
            <div class="tab">
              <div class="tablinks" id="Paquetes-tab" onclick="openTab(event, 'Paquetes')">
                Paquetes
              </div>
            </div>
          </div>
          
          <div class="tab-contents">
            <div id="Info" class="tabcontent">
              <p><b>Duración:</b> <%= duracion %></p>
              <p><b>Costo:</b> $<%= costo %></p>
              <p><b>Ciudad:</b> <%= ciudad %></p>
              <p><b>Fecha Alta:</b> <%= fechaAlta %></p>
              <p><b>Categoría/s:</b> 
			  <% if(cate != null)for(String s : cate){ %>
					<%= s %>
			  <% } %>
			  
			  </p> <% //ver %>
              <p><b>Descripcion:</b> <%= descripcion %></p>
            </div>
            <div id="Salidas" class="tabcontent">
             <% for (int i=0; i< Salidas.size();i++) {
           
                     %>
              <div class="Salida">
                <div class="imagenSalida">
                  <img src = "media/icons/avatar.svg" height="200">
                </div>
                <div class="Salida-text">
                  <h3><%=  Salidas.get(i).getNombre() %></h3>
                  <p><a href="/Tarea2Test/ConsultaSalida?paramS=<%=Salidas.get(i).getNombre()%>" class="links">Leer mas.</a></p>
                </div>
              </div>
              <hr>
         <%} %>
              
            </div>
            
            <div id="Paquetes" class="tabcontent">
            <% for (int i=0; i< paque.size();i++) { %>
            
              <div class="Paquete">
                <div class="imagenPaquete">
                  <img src = "media/icons/avatar.svg">
                </div>
                <div class="Paquete-text">
                  <h3><%=  paque.get(i).getNombre() %></h3>
                  <p><a href="/Tarea2Test/ConsultaPaquete?paramPaq=<%=paque.get(i).getNombre()%>" class="links">Leer mas.</a></p>
                </div>
              </div>
              
              <%} %>
            </div>
          </div>
        </div>
      </div>
      <script>window.onload=openTab(event, 'Info');</script>
      <script src="./../js/consultaDeUsuario.js"></script>
</body>
</html>