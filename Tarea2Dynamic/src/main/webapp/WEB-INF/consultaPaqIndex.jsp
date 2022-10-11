<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaIndex.css"%></style>
    <title>Consulta Paquetes</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>
    
    <div style="display: flex; flex-direction: column;">
        <div style="display:flex; align-items: center; gap: 20px; justify-content: center;">
            <img src="./../icons/money.svg" style="height:96px; " alt="">
            <h1 style="text-align: center;">Consultar paquetes</h1>
        </div>
        <div class="content">

            <div class="filtros">
                <div class="filtro">
                    <select name="Categorias" class="Categorias">
                        <option value="Departamento">Categorias</option>
                        <option value="Rocha">Gatronomia</option>
                    </select>
                </div>
            </div>
            <div class="Consultas">
                <div class="conjuntoConsulta">
                    <div class="imagen">
                        <img src="https://sites.google.com/site/areasprotegidasenuruguay/_/rsrc/1411660757953/algunas-de-las-areas-ingresadas-por-el-snap/laguna-de-rocha/Mapa_Rocha_BLOG.jpg?height=280&width=400" height="200">
                    </div>
                    <div class="descripcion">
                        <div class="nombre">
                            Disfrutar Rocha
                        </div>
                        Actividades para hacer en familia y disfrutar arte y gastronomia
                        <a href="./ConsultaPaquete.html" class="links selected">Leer mas.</a>
                    </div>
                </div>
                <hr>
                <div class="conjuntoConsulta">
                    <div class="imagen">
                        <img src="https://www.lr21.com.uy/wp-content/uploads/2021/12/plaza-toros-colonia.jpg" height="200">
                    </div>
                    <div class="descripcion">
                        <div class="nombre">
                            Un dia en Colonia
                        </div>
                        Paseos por el casco historico y se puede terminar con Almuerzo en la Plaza de Toros
                        <a href="#" class="links selected">Leer mas.</a>
                    </div>
                </div>
                <hr>
                <div class="conjuntoConsulta">
                    <div class="imagen">
                        <img src="http://www.indra.org.uy/images/inauguracion-03.jpg" height="200">
                    </div>
                    <div class="descripcion">
                        <div class="nombre">
                            Valle Del Lunarejo
                        </div>
                        Visite un area protegida con un paisaje natural hermoso
                        <a href="#" class="links selected">Leer mas.</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>
