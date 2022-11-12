<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="webservice.EstadoError"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/altaUsuario.css"%></style>
    <title>Registro Proveedor</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>
        
    <div class="content">
        <form class="form-register" action="AltaProveedor" method="post">
            <h4>Registrarse</h4>
            
            <% EstadoError estadoError = (EstadoError) request.getAttribute("estado_error"); %>
                	
            <% if (estadoError == EstadoError.ERROR_NICK_OR_EMAIL || estadoError == EstadoError.ERROR_CONTRA || estadoError == EstadoError.ERROR_EMAIL){ %>
	        	<div class="error-frame">
	                		
              		<% if (estadoError == EstadoError.ERROR_NICK_OR_EMAIL){ %>
              			Ese nickname ya esta en uso.
              		<% } %>
              		<% if (estadoError == EstadoError.ERROR_CONTRA){ %>
             			Las contraseñas deben ser iguales.
             		<% } %>
             		<% if (estadoError == EstadoError.ERROR_EMAIL){ %>
             			Ese email ya esta en uso.
             		<% } %>
	                			
	        	</div>
	        <% } %>
            
            <div class="input-outer">
                <img src="media/icons/avatar.svg" class="icon">
                <input type="text" class="input-style" placeholder="Nickname" name="nickname" required>
            </div>
            <div class="input-outer">
                <img src="media/icons/avatar.svg" class="icon">
                <input type="text" class="input-style" placeholder="Nombre" name="nombre" required>
            </div>
            <div class="input-outer">
                <img src="media/icons/avatar.svg" class="icon">
                <input type="text" class="input-style" placeholder="Apellido" name="apellido" required>
            </div>
            <div class="input-outer">
                <img src="media/icons/email.svg" class="icon">
                <input type="email" class="input-style" placeholder="E-mail" name="email" required>
            </div>
            <div class="input-outer">
                <img src="media/icons/date.svg" class="icon">
                <input type="date" class="input-style" placeholder="Fecha de nacimiento" name="bDate" required>
            </div>
            <div class="input-outer">
                <img src="media/icons/lock.svg" class="icon">
                <input type="password" class="input-style" placeholder="Contraseña" name="password" required>
            </div>
            <div class="input-outer">
                <img src="media/icons/lock.svg" class="icon">
                <input type="password" class="input-style" placeholder="Confirmar contraseña" name="confirmPasword" required>
            </div>
            <div class="input-outer">
                <img src="media/icons/write.svg" class="icon">
                <input type="text" class="input-style" placeholder="Descripción" name="descripcion" required>
            </div>
            <div class="input-outer">
                <img src="media/icons/url.svg" class="icon">
                <input type="text" class="input-style" placeholder="Url (opcional)" name="url">
            </div>
            <h5>Seleccione una foto de perfil</h5>
            <div class="input-outer">
                <img src="media/icons/image.svg" class="icon">
                <input type="file" class="input-style" placeholder="img" name="img">
            </div>
            <div style="display:flex; justify-content:space-between;">
                <input type="submit" class="button" id="registrarButton" value="Registrar">
                <button class="button" type="button" id="cancelarButton" onclick="window.location.href='/Tarea2Test/Home';" style="background: white; color: black; border: 2px solid #968EF8;">Cancelar</button>
            </div>
        </form>
    </div>

</body>
</html>