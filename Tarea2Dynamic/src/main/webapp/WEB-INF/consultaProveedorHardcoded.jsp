<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <script src="/js/consultaDeUsuario.js" type="text/javascript"></script>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
   
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
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
       
       
        if (request.getSession().getAttribute("prov_dt") != null) {
           DTProveedor p = (DTProveedor) request.getSession().getAttribute("prov_dt");
        		//   request.getAttribute("InfoProveedor") ;
            nombre = p.getNombre();
            nickName = p.getNickname();
            email = p.getEmail();
            fechaN = p.getFechaNacimiento().toString();
            desc =  p.getDescripcionGeneral();
            url = p.getURL();
            //seguir con las actividades
            
            
            
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
                    <p><b>Nombre Completo:</b> <%= nombre%></p>
                    <p><b>E-mail:</b> email </p>
                    <p><b>Fecha de Nacimiento:</b> <%= fechaN %></p>
                    <p><b>Descripcion:</b> <%= desc %> </p>
                    <p><b>URL:</b>  <%= url %> </p>
                </div>
                <div id="Actividades" class="tabcontent">
                    <div class="Actividad">
                        <div class="imagenActividad">
                            <img src = "https://s3.amazonaws.com/turismorocha/eventos/2569/cover/degusta-048968300-1659558891.jpg">
                        </div>
                        <div class="Actividad-text">
                            <h3>Degusta</h3>
                            <p><a href="./consultaActividad1.html" class="links">Leer mas.</a></p>
                        </div>
                    </div>
                    <hr>
                    <div class="Actividad">
                        <div class="imagenActividad">
                            <img src = "https://s3.amazonaws.com/turismorocha/eventos/2579/cover/teatro-con-sabores-008950900-1659638152.jpg">
                        </div>
                        <div class="Actividad-text">
                            <h3>Teatro con Sabores</h3>
                            <p><a href="#" class="links">Leer mas.</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="./../js/consultaDeUsuario.js"></script>
    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>