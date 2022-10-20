<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="ServidorCentral.Logica.DataTypes.EstadoError"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/altaSalida.css"%></style>
    <title>Alta Salida</title>
</head>
<body>
    
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="container">
        <div class="imagen">
            <img src="../icons/plus.svg">
        </div>
        <div class="texto">
            <h2>Agregar Salida Turistica</h2>
        </div>
        <div class="formulario ">
            <div class="container2">
                <div class="departamentoycategorias">

                        <div class="img1"> <img src="./../icons/location2.svg" class="iconop" ></div>
                        <div class="s1">  <select class ="controls" name="departamento" id="cars">
                            <option value="volvo">Rocha</option>

                          </select></div>
                        <div class="img2"> <img src="./../icons/tag.svg" class="iconop" > </div>
                        <div class="s2">  <select name="actividades" class ="controls" id="cars">
                            <option value="degusta">Degusta</option>

                          </select> </div>



                </div>
                <div class="c2">
                    <img src="./../icons/reservation.svg" class="iconop" >
                    <input type="text" name="nombre" class ="controls"  placeholder="Nombre de la Salida" required>
                </div>
                <div class="c3">
                    <img src="./../icons/clock.svg" class="iconop" >
                    <input class="controls" type="datetime-local" name="dateNHour" id="dateNHour" placeholder="Fecha y Hora de salida" required>
                </div>
                <div class="c4">
                    <img src="./../icons/location.svg" class="iconop" >
                    <input type="text" name="lugarsalida" class ="controls"  placeholder="Lugar de salida" required>
                </div>
                <div class="c5">
                    <div class="Costo"> <img src="./../icons/cuposMax.svg" class="iconop" >
                        <input type="text" name="maxcupos"  placeholder="Cupos maximos" class ="controls" required>
                    </div>
                </div>
                <div class="c6">
                    <img src="./../icons/image.svg" class="iconop"  >
                    <input class ="controls" type="file" name="img" id="img" placeholder="Seleccionar imagen" required>
                </div>
                <div class="c7">
                    <input class="boton" type="submit" value="Confirmar">
                    <input class="boton2" type="submit" value="Cancelar">
                </div>
              </div>

        </div>


    </div>


    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>