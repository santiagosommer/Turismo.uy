<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/altaUsuario.css"%></style>
    <title>Registro Turista</title>
</head>
<body>
        
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="content">
        <section class="form-register">
            <h4>Registrarse</h4>
            <div class="input-outer">
                <img src="./../icons/avatar.svg" class="icon">
                <input type="text" class="input-style" placeholder="Nickname" name="nickname" required>
            </div>
            <div class="input-outer">
                <img src="./../icons/avatar.svg" class="icon">
                <input type="text" class="input-style" placeholder="Nombre" name="nombre" required>
            </div>
            <div class="input-outer">
                <img src="./../icons/avatar.svg" class="icon">
                <input type="text" class="input-style" placeholder="Apellido" name="apellido" required>
            </div>
            <div class="input-outer">
                <img src="./../icons/email.svg" class="icon">
                <input type="email" class="input-style" placeholder="E-mail" name="email" required>
            </div>
            <div class="input-outer">
                <img src="./../icons/date.svg" class="icon">
                <input type="date" class="input-style" placeholder="Fecha de nacimiento" name="bDate" required>
            </div>
            <div class="input-outer">
                <img src="./../icons/lock.svg" class="icon">
                <input type="password" class="input-style" placeholder="Contraseña" name="password" required>
            </div>
            <div class="input-outer">
                <img src="./../icons/lock.svg" class="icon">
                <input type="password" class="input-style" placeholder="Confirmar contraseña" name="confirmPasword" required>
            </div>
            <div class="input-outer">
                <img src="./../icons/location2.svg" class="icon">
                <input type="text" class="input-style" placeholder="Nacionalidad" name="nacionalidad" required>
            </div>
            <h5>Seleccione una foto de perfil</h5>
            <div class="input-outer">
                <img src="./../icons/image.svg" class="icon">
                <input type="file" class="input-style" placeholder="img" name="img" required>
            </div>
            <div style="display:flex; justify-content:space-between;">
                <button type="button" id="registrarButton">Registrar</button>
                <button type="button" id="cancelarButton" style="background: white; color: black; border: 2px solid #968EF8;">Cancelar</button>
            </div>
        </section>
    </div>

    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>