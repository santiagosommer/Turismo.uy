<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaIndex.css"%></style>
    <title>Consulta Actividades</title>
</head>
<body>
        
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>
        
        
    <div style="display: flex; flex-direction: column;">
        <div style="display:flex; align-items: center; gap: 20px; justify-content: center;">
            <img src="./../icons/shark.svg" style="height:96px; " alt="">
            <h1 style="text-align: center;">Consultar actividades</h1>
        </div>
        <div class="content">

            <div class="filtros">
                <div class="filtro">
                    <select name="Departamento" class="Departamento">
                        <option value="Departamento">Departamento</option>
                        <option value="Rocha">Rocha</option>
                    </select>
                </div>
                <div class="filtro">
                        <select name="Categoria" class="Categoria">
                            <option value="Categoria">Categoria</option>
                            <option value="Cat1">Gastronomia</option>
                        </select>
                </div>
            </div>
            <div class="Consultas">
                <div class="conjuntoConsulta">
                    <div class="imagen">
                        <img src="https://s3.amazonaws.com/turismorocha/eventos/2569/cover/degusta-048968300-1659558891.jpg" height="200">
                    </div>
                    <div class="descripcion">
                        <div class="nombre">
                            Degusta
                        </div>
                        Festival gastronomico de productos locales en Rocha
                        <a href="./consultaActividad1.html" class="links selected">Leer mas.</a>
                    </div>
                </div>
                <hr>
                <div class="conjuntoConsulta">
                    <div class="imagen">
                        <img src="https://s3.amazonaws.com/turismorocha/eventos/2579/cover/teatro-con-sabores-008950900-1659638152.jpg" height="200">
                    </div>
                    <div class="descripcion">
                        <div class="nombre">
                            Teatro con Sabores
                        </div>
                        En el mes aniversario del Club Deportivo Union de Rocha te invitamos a una merienda deliciosa.
                        <a href="#" class="links selected">Leer mas.</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>
