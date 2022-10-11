<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    <title>Consulta Actividad</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>


    <div class="content">
        <div class="Consultas">
          <div class="container-consulta">
            <div class="img-container">
              <img src="https://s3.amazonaws.com/turismorocha/eventos/2569/cover/degusta-048968300-1659558891.jpg" height="200">
            </div>
            <h3>Degusta</h3>
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
              <p><b>Duración:</b> 3 dias</p>
              <p><b>Costo:</b> $800</p>
              <p><b>Ciudad:</b> Rocha</p>
              <p><b>Fecha Alta:</b> 20/7/2022</p>
              <p><b>Categoría:</b> Gastronomia</p>
              <p><b>Descripcion:</b> Festival gastronómico de productos locales en Rocha</p>
            </div>
            <div id="Salidas" class="tabcontent">
              <div class="Salida">
                <div class="imagenSalida">
                  <img src = "https://city.woow.com.uy/media/catalog/product/cache/dcf64a24127a43d9ce9fe76e3e5f8061/n/u/nueva2_3_1.jpg" height="200">
                </div>
                <div class="Salida-text">
                  <h3>Degusta Agosto</h3>
                  <p><a href="#" class="links">Leer mas.</a></p>
                </div>
              </div>
              <hr>
              <div class="Salida">
                <div class="imagenSalida">
                  <img src = "https://s3.amazonaws.com/turismorocha/operadores/1/med/bahia-resto-053888900-1458674720.JPG" height="200">
                </div>
                <div class="Salida-text">
                  <h3>Degusta Setiembre</h3>
                  <p><a href="./consultaSalida.html" class="links">Leer mas.</a></p>
                </div>
              </div>
            </div>
            <div id="Paquetes" class="tabcontent">
              <div class="Paquete">
                <div class="imagenPaquete">
                  <img src = "https://sites.google.com/site/areasprotegidasenuruguay/_/rsrc/1411660757953/algunas-de-las-areas-ingresadas-por-el-snap/laguna-de-rocha/Mapa_Rocha_BLOG.jpg?height=280&width=400">
                </div>
                <div class="Paquete-text">
                  <h3>Disfrutar Rocha</h3>
                  <p><a href="./ConsultaPaquete.html" class="links">Leer mas.</a></p>
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