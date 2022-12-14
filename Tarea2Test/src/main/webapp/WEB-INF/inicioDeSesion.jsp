<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="webservice.EstadoError"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/inicioDeSesion.css"%></style>
    <title>Inicio de Sesion</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="content">
        <div>
            <h2 style="text-align:center;">Iniciar Sesion</h2>
            <form action="IniciarSesion" method="post">
                <div class="input-container">
                	
                	<% EstadoError estadoError = (EstadoError) request.getAttribute("estado_error"); %>
                	
                	<% if (estadoError == EstadoError.ERROR_NICK_OR_EMAIL || estadoError == EstadoError.ERROR_CONTRA){ %>
	                	<div class="error-frame">
	                		
	                		<% if (estadoError == EstadoError.ERROR_NICK_OR_EMAIL){ %>
	                			Nickname-Email incorrecto.
	                		<% } %>
	                		<% if (estadoError == EstadoError.ERROR_CONTRA){ %>
	               				Contraseņa incorrecta.
                			<% } %>
	                			
	             		</div>
	             	<% } %>
                    <div class="input-outer">
                        <img src="media/icons/avatar.svg" class="icon">
                        <input type="text" id="id-input" class="input-style" size="30" placeholder="Nickname or E-mail" name="email-or-nickname-content" required>
                    </div>
                    <div class="input-outer">
                        <img src="media/icons/lock.svg" class="icon">
                        <input type="password" id="password-input" class="input-style" size="30" placeholder="Password" name="password-content" required>
                    </div>
                    <div style="display:flex; justify-content:space-between;">
                        <input type="submit" class="button" id="iniciarButton" value="Iniciar Sesion">
                  	    <button type="button" class="button" onclick="window.location.href='/web/Home';" id="cancelButton" style="background: white; color: black; border: 2px solid #968EF8;">Cancelar</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    
</body>
</html>