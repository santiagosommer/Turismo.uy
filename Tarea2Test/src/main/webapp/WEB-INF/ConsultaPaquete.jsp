<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    <title>Consulta Paquete</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>




<div class="content">
  <div class="Consultas">
    <div class="container-consulta">
      <div class="img-container">
        <img src="https://sites.google.com/site/areasprotegidasenuruguay/_/rsrc/1411660757953/algunas-de-las-areas-ingresadas-por-el-snap/laguna-de-rocha/Mapa_Rocha_BLOG.jpg?height=280&width=400" height="200">
      </div>
      <h3>Disfrutar Rocha</h3>
      <button id="botonComprarPaquete" onclick="location.href='compraPaquete.html'">Comprar Paquete </button>
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
        <p><b>Validez:</b> 60 dias</p>
        <p><b>Descuento:</b> 20%</p>
        <p><b>Fecha Alta:</b> 10/08/2022</p>
        <p><b>Descripcion:</b> Actividades para hacer en familia y disfrutar arte y gastronomia</p>
      </div>
      <div id="Actividades" class="tabcontent">
        <div class="Actividad">
          <div class="imagenSalida">
            <img src = "https://s3.amazonaws.com/turismorocha/eventos/2569/cover/degusta-048968300-1659558891.jpg">
          </div>
          <div class="Salida-text">
            <h3>Degusta</h3>
            <p><a href="./consultaActividad1.html" class="links">Leer mas.</a></p>
          </div>
        </div>
        <div class="Actividad">
          <div class="imagenSalida">
            <img src = "https://s3.amazonaws.com/turismorocha/eventos/2579/cover/teatro-con-sabores-008950900-1659638152.jpg">
          </div>
          <div class="Salida-text">
            <h3>Teatro con Sabores</h3>
            <p><a href="#" class="links">Leer mas.</a></p>
          </div>
        </div>
      </div>
      <div id="Categorias" class="tabcontent">
        <p><b>Gastronomia</b></p>
      </div>
    </div>
  </div>
</div>

    <script src="./../js/consultaDeUsuario.js"></script>
    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>