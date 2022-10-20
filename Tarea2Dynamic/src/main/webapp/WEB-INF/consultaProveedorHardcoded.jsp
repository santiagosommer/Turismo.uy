<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    
    <script  >
    
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
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
   
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
     <%@page import=" java.util.ArrayList"%>
     <%@page import= "java.util.Iterator"%>
     
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    <title>Consulta Proveedor</title>
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
       
         
         ArrayList<DTActividadTuristica> act = new ArrayList<DTActividadTuristica>();
        if (request.getSession().getAttribute("prov_dt") != null) {
           DTProveedor p = (DTProveedor) request.getSession().getAttribute("prov_dt");
     
            nombre = p.getNombre();
            nickName = p.getNickname();
            email = p.getEmail();
            fechaN = p.getFechaNacimiento().toString();
            desc =  p.getDescripcionGeneral();
            url = p.getURL();
            apellido = p.getApellido();
             act = p.getActividades();
             
         
        }
%>	
                <div class="img-container">
                    <img src="https://c.wallhere.com/photos/55/39/safe_house_cia_agent_tobin_frost_denzel_washington-584127.jpg!d" height="200">
                </div>
                <h3>  <%= nombre%> </h3>
                <h5> <%= nickName %> / <%= email%></h5>
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
            </div>
            <div class="tab-contents">
                <div id="Perfil" class="tabcontent">
                    <p><b>Nickname:</b> <%= nickName%></p>
                    <p><b>Nombre: </b> <%= nombre%></p>
                    <p><b>Apellido: </b> <%= apellido%></p>
                    <p><b>E-mail:</b> email </p>
                    <p><b>Fecha de Nacimiento:</b> <%= fechaN %></p>
                    <p><b>Descripcion:</b> <%= desc %> </p>
                    <p><b>URL:</b>  <%= url %> </p>
                </div>
                <div id="Actividades" class="tabcontent">
                
                <% for (int i=0; i< act.size();i++) {
                	
                	if (act.get(i).getEstado() == EstadoActividad.Confirmada) {
                    
                     %>
                    <div class="Actividad">
                        <div class="imagenActividad">
                            <img src = "https://s3.amazonaws.com/turismorocha/eventos/2569/cover/degusta-048968300-1659558891.jpg">
                        </div>
                        <div class="Actividad-text">
                            <h3><%= act.get(i).getNombre() %></h3>
                            <p><a href="./consultaActividad1.html" class="links">Leer mas.</a></p>
                        </div>
                    </div>
                    <hr>
                    <%}} %>
                   
                </div>
            </div>
        </div>
    </div>

 
    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>