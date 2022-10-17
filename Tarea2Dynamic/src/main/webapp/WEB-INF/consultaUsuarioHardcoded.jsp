<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <%@page import="java.util.Set"%>
    <%@page import="java.util.Iterator"%>
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    
    
    <title>Consulta Usuario</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>


    <div class="content">
        <div class="Consultas">
      
           <% 
         String nombre ="";
         String nickName ="";
         String email ="";
         String fechaN = "";
         String desc ="";
         String url = "";
         String nacionalidad = "";
       
       
        if (request.getAttribute("InfoTurista") != null) {
           DTTurista t = (DTTurista) request.getAttribute("InfoTurista") ;
            nombre = t.getNombre();
            nickName = t.getNickname();
            email = t.getEmail();
            fechaN = t.getFechaNacimiento().toString();
            nacionalidad = t.getNacionalidad();
            
            //seguir con las Salidas
            
            
            
       }
            	%>	
    
            <div class="container-consulta">
                <div class="img-container">
                    <img src="https://pbs.twimg.com/media/EOHAP9zWoAsnkiM?format=jpg&name=small" height="200">
                </div>
                <h3> <%= nombre %>	</h3>
                <h5> <%= nickName %> / <%= email %> </h5>
            </div>
            <div class="top-bar-links">
                <div class="tab">
                    <div class="tablinks" id="Perfil-tab" onclick="openTab(event, 'Perfil')">
                        Perfil
                    </div>
                </div>
                <div class="tab">
                    <div class="tablinks" id="Salidas-tab" onclick="openTab(event, 'Salidas')">
                        Salidas
                    </div>
                </div>
            </div>
            <div class="tab-contents">
                <div id="Perfil" class="tabcontent">
                    <p><b>Nickname:</b>  <%= nickName %> </p>
                    <p><b>Nombre:</b> <%= nombre %> </p>
                    <p><b>E-mail:</b>  <%= email %> </p>
                    <p><b>Fecha de Nacimiento:</b>  <%= fechaN %> </p>
                    <p><b>Nacionalidad:</b> <%= nacionalidad %> </p>
                </div>
                <div id="Salidas" class="tabcontent">
                    <div class="Salida">
                        <div class="imagenSalida">
                            <img src = "https://city.woow.com.uy/media/catalog/product/cache/dcf64a24127a43d9ce9fe76e3e5f8061/n/u/nueva2_3_1.jpg">
                        </div>
                        <div class="Salida-text">
                            <h3>Degusta Agosto</h3>
                            <p><a href="#" class="links">Leer mas.</a></p>
                        </div>
                    </div>
                    <div class="Salida">
                        <div class="imagenSalida">
                            <img src = "https://s3.amazonaws.com/turismorocha/operadores/1/med/bahia-resto-053888900-1458674720.JPG">
                        </div>
                        <div class="Salida-text">
                            <h3>Degusta Setiembre</h3>
                            <p><a href="./consultaSalida.html" class="links">Leer mas.</a></p>
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