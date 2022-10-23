<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <title>TurisUY</title>
</head>
<body>

	<jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="content">
        <div>
            <h1 style="text-align: center;">Bienvenido!</h1>
            <h2>Aqui tienes unas recomendaciones para tus siguientes pasos:</h2>
        </div>
        <div style="display:flex; flex: 1 0 1; width: 100%; justify-content: space-between;">
            <div class="recommendations">
                <div class="recommendation-item">
                    <img src="media/icons/avatar.svg" class="recommendation-icon">
                    <h3><a href="/Tarea2Test/AltaUsuario">Registra</a> una cuenta o <a href="/Tarea2Test/IniciarSesion">entra con una cuenta</a> ya existente </h3>
                </div>
                <div class="recommendation-item">
                    <img src="media/icons/wind-surfing.svg" class="recommendation-icon">
                    <h3>Revisa las nuevas e innovadoras <a href="#">actividades</a> que tenemos para ti!</h3>
                </div>
                <div class="recommendation-item">
                    <img src="media/icons/money.svg" class="recommendation-icon">
                    <h3>Los mejores <a href="#">paquetes</a> de actividades para tu mayor ahorro!</h3>
                </div>
            </div>
        </div>
    </div>

</body>
</html>