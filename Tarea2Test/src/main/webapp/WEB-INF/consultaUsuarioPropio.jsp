<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    <%@page import=" java.util.ArrayList"%>
    <script type="text/javascript">
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
     <%@page import="java.util.Set"%>
    <%@page import="java.util.Iterator"%>
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    <title>Perfil</title>
</head>
<body>
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="content">
        <div class="Consultas">
            <div class="container-consulta">
            
              <% 
         String nombre ="";
         String nickName ="";
         String email ="";
         String fechaN = "";
         String desc ="";
         String url = "";
         String apellido = "";
         if ((EstadoSesion) request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) {
        	 
        	   if ((DTTurista) request.getSession().getAttribute("usuario_dt") != null) {
        		   DTTurista t = (DTTurista) request.getSession().getAttribute("usuario_dt");
 		             nombre = t.getNombre();
 		             nickName = t.getNickname();
 		             apellido = t.getApellido();
 		             email = t.getEmail();
        		   
        		          
       		  }
         }
        
       
        	   
        	   if ((EstadoSesion)request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_PROVEEDOR) {
              	 
            	   if ((DTProveedor)request.getSession().getAttribute("usuario_dt") != null) {
            		           DTProveedor p = (DTProveedor) request.getSession().getAttribute("usuario_dt");
            		           nombre = p.getNombre();
            		           nickName = p.getNickname();
            		           email = p.getEmail();
            		           fechaN = p.getFechaNacimiento().toString();
 
             }
        	   }
         
            	%>	
            	
    
                <div class="img-container">
                    <img id="imagen_perfil" src="media/icons/avatar.svg" height="200">
                </div>
                <h3 id="title-nombre"> <%= nombre %>	</h3>
                <h5 id="title-nickname-email"> <%= nickName %> / <%= email %>  </h5>
                </div>
            <div class="top-bar-links">
                <div class="tab">
                    <div class="tablinks" id="Perfil-tab" onclick="openTab(event, 'Perfil')">
                        Perfil
                    </div>
                </div>
                
                <%    if ((EstadoSesion)request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_PROVEEDOR) {
                 	 
             	   if ((DTProveedor)request.getSession().getAttribute("usuario_dt") != null) {
                %>
                <div class="tab" id="Actividades-tab-container">
                    <div class="tablinks" id="Actividades-tab" onclick="openTab(event, 'Actividades')">
                        Actividades
                    </div>
                </div>
                
                <% }} %>
                <% 
                  if ((EstadoSesion)request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) {
                	  if ((DTTurista)request.getSession().getAttribute("usuario_dt") != null) {
                	  
                	  %>
                  
                <div class="tab" id="Salidas-tab-container">
                    <div class="tablinks" id="Salidas-tab" onclick="openTab(event, 'Salidas')">
                        Salidas
                    </div>
                </div>
                <div class="tab" id="Paquetes-tab-container">
                    <div class="tablinks" id="Paquetes-tab" onclick="openTab(event, 'Paquetes')">
                        Paquetes
                    </div>
                </div>
                
                <% } } %>
            </div>
            <div class="tab-contents">
                <div id="Perfil" class="tabcontent">
                
                <%	   if ((EstadoSesion)request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_PROVEEDOR) {
                	  DTProveedor p = (DTProveedor) request.getSession().getAttribute("usuario_dt");
            		           nombre = p.getNombre();
            		           nickName = p.getNickname();
            		           email = p.getEmail();
            		           fechaN = p.getFechaNacimiento().toString();
            		          url = p.getURL();
            		          desc = p.getDescripcionGeneral();
            		           %>
                
                
                 <p><b>Nickname:</b> <%= nickName%></p>
                    <p><b>Nombre: </b> <%= nombre%></p>
                    <p><b>Apellido: </b> <%= apellido%></p>
                    <p><b>E-mail:</b> email </p>
                    <p><b>Fecha de Nacimiento:</b> <%= fechaN %></p>
                    <p><b>Descripcion:</b> <%= desc %> </p>
                    <p><b>URL:</b>  <%= url %> </p>
                    
                <%} %>
                	
                 <% if ((EstadoSesion)request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) {
                	 DTTurista t = (DTTurista) request.getSession().getAttribute("usuario_dt");
   		             nombre = t.getNombre();
   		             nickName = t.getNickname();
   		             apellido = t.getApellido();
   		             email = t.getEmail();
   		             fechaN = t.getFechaNacimiento().toString();
                     String nacionalidad = "";
        		     nacionalidad = t.getNacionalidad();%>    
                    
                    <p><b>Nickname:</b>  <%= nickName %> </p>
                    <p><b>Nombre:</b> <%= nombre %> </p>
                    <p><b>Apellido: </b> <%= apellido%></p>
                    <p><b>E-mail:</b>  <%= email %> </p>
                    <p><b>Fecha de Nacimiento:</b>  <%= fechaN %> </p>
                    <p><b>Nacionalidad:</b> <%= nacionalidad %> </p>
                <%
                } %>
                </div>
                
                
                
                <div id="Actividades" class="tabcontent">
                
                <%   
                ArrayList<DTActividadTuristica> act = new ArrayList<DTActividadTuristica>();
                if ((EstadoSesion)request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_PROVEEDOR) {
                   DTProveedor p = (DTProveedor) request.getSession().getAttribute("usuario_dt");
                   act = p.getActividades();

                for (int i=0; i < act.size();i++) {
                    
                     %>
                    <div class="Actividad">
                        <div class="imagenActividad">
                            <img src = "media/icons/avatar.svg">
                        </div>
                        <div class="Actividad-text">
						
                            <h3> <%= act.get(i).getNombre() %> </h3>
                            <p>Estado: <%= act.get(i).getEstado() %></p>
                            <p><a href="/Tarea2Test/ConsultaActividadIndividual?paramAct=<%= act.get(i).getNombre() %>" class="links">Leer más.</a></p>
                        </div>
                    </div>
                    <hr>     
                    
      <%     }  } %>        
                    
                </div>
                <div id="Salidas" class="tabcontent">
                
                <%ArrayList<DTInscripcion> InscSal = new ArrayList<DTInscripcion>();
                if ((EstadoSesion)request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) {
					 DTTurista t = (DTTurista) request.getSession().getAttribute("usuario_dt");
					 InscSal = t.getInscripciones();
					 for (int i=0; i< InscSal.size();i++) {
               
                %>
                
                
                  <div class="Salida">
                    
                
                        <div class="imagenSalida">
                            <img src = "media/icons/avatar.svg">
                        </div>
                        <div class="Salida-text">
                            <h3><%= InscSal.get(i).getSalidaAsociada().getNombre() %></h3>
                            <p> Fecha Inscripcion:<%= InscSal.get(i).getFecha().toString() %> </p>
                            <p>Cantidad Turistas: <%= InscSal.get(i).getCantidadTuristas() %> </p>
                            <p> Costo: <%= InscSal.get(i).getCosto() %> </p>
                            <p><a href="/Tarea2Test/ConsultaSalida?paramS=<%= InscSal.get(i).getSalidaAsociada().getNombre()%>" class="links">Leer mas.</a></p>
                        </div>
                    </div>
                    
                
                
                <%
                } }
                %>
                
                
                </div>
                <div id="Paquetes" class="tabcontent">
                <%
                ArrayList<DTPaquete> paquetes = new ArrayList<DTPaquete>();
                
                %>
                
                
                
                
                </div>
            </div>
        </div>
    </div>
    <script>window.onload=openTab(event, 'Perfil');</script>

    <script src="./../js/consultaDeUsuario.js"></script>
    <script src="./../js/consultaUsuarioPropio.js"></script>
</body>
</html>