<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    <title>Consulta Proveedor</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="content">
        <div class="Consultas">
            <div class="container-consulta">
                <div class="img-container">
                    <img src="https://c.wallhere.com/photos/55/39/safe_house_cia_agent_tobin_frost_denzel_washington-584127.jpg!d" height="200">
                </div>
                <h3>Washington Rocha</h3>
                <h5>washington / washington@turismorocha.gub.uy</h5>
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
                    <p><b>Nickname:</b> washington</p>
                    <p><b>Nombre:</b> Washington</p>
                    <p><b>Apellido:</b> Rocha</p>
                    <p><b>E-mail:</b> washington@turismorocha.gub.uy</p>
                    <p><b>Fecha de Nacimiento:</b> 14/09/1970</p>
                    <p><b>Descripcion:</b> "Hola! me llamo Washington y soy el encargado
                        del portal de turismo del departamento de Rocha -
                        Uruguay"</p>
                    <p><b>URL:</b> http://turismorocha.gub.uy/</p>
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