<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/altaUsuario.css"%></style>
    <title>Registro Usuario</title>
</head>
<body>
    
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="content">
        <div class="titles">
            <h1>¿Quién eres?</h1>
        </div>

        <div class="altaUsuario">
            <a href="/WEB-INF/altaTurista">
                <figure>
                    <img src="./../icons/plane.svg" alt="" class="img-altaUsuario">
                    <figcaption>Turista</figcaption>
                </figure>
            </a>
            <a href="/WEB-INF/altaProveedor">
                <figure>
                    <img src="./../icons/ticket.svg" alt="" class="img-altaUsuario">
                    <figcaption>Proveedor</figcaption>
                </figure>
            </a>
        </div>
    </div>
</body>
</html>