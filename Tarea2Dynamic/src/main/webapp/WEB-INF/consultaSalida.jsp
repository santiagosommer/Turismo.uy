<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    <title>Consulta Salida</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

<div class="content">
        <div class="Consultas">
            <div class="container-consulta">
                <div class="img-container">
                    <img src = "https://s3.amazonaws.com/turismorocha/operadores/1/med/bahia-resto-053888900-1458674720.JPG" class="imagenSalidaDegusta">
                </div>
                <h3>Degusta Setiembre</h3>
                <button id="botonInscripcionSalida" onclick="location.href='inscripcionASalidaTuristica.html'">Inscribirse</button>
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
                    <p><b>Fecha:</b> 03/09/2022</p>
                    <p><b>Hora:</b> 17hs</p>
                    <p><b>Cupos Disponibles:</b> 20</p>
                    <p><b>Lugar:</b> Sociedad Agropecuaria de Rocha</p>
                </div>                
            </div>
        </div>
</div>

    <script src="./../js/consultaDeUsuario.js"></script>
    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>