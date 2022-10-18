<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/altaActividad.css"%></style>
    <title>Alta Actividad</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="container">
        <div class="imagen">
            <img src="../icons/plus.svg">
        </div>
        <div class="texto">
            <h2>Agregar Actividad Turistica</h2>
        </div>
        <div class="formulario ">
            <div class="container2">
                <div class="departamentoycategorias">

                        <div class="img1"> <img src="./../icons/location2.svg" class="iconop" ></div>
                        <div class="s1">  <select class ="controls" name="departamento" id="depas">
                            <option value="rocha">Rocha</option>

                          </select></div>
                        <div class="img2"> <img src="./../icons/tag.svg" class="iconop" > </div>
                        <div class="s2">  <select name="categorias" class ="controls" id="categ">
                            <option value="gastronomia">Gastronomia</option>

                          </select> </div>
                </div>
                <div class="c2">
                    <img src="./../icons/reservation.svg" class="iconop" >
                    <input type="text" name="nombre" class ="controls"  placeholder="Nombre de la Actividad" required>
                </div>
                <div class="c3">
                    <img src="./../icons/write.svg" class="iconop" >
                    <input  type="text" name="descripcion" id="descripcion" class ="controls"  placeholder="Descripci�n" required>
                </div>
                <div class="c4">
                    <img src="./../icons/clock.svg" class="iconop" >
                    <input type="text" name="duracion" class ="controls"  placeholder="Duracion hh" required>
                </div>
                <div class="c5">
                    <div class="Costo ">
                        <img src="./../icons/money2.svg" class="iconop" >
                        <input type="text" name="costo"  placeholder="Costo" class ="controls" required>
                    </div>
                </div>
                <div class="c6">
                    <div class="ciudad ">
                        <img src="./../icons/location.svg" class="iconop" >
                        <input type="text" name="ciudad"  placeholder="Ciudad" class ="controls" required>
                    </div>
                </div>
                <div class="c7">
                    <img src="./../icons/image.svg" class="iconop"  >
                    <input class ="controls" type="file" name="img" id="img" placeholder="Seleccionar imagen" required>
                </div>
                <div class="c8">
                    <input class="boton" type="submit" value="Confirmar">
                    <input class="boton2" type="submit" value="Cancelar">
                </div>
              </div>
        </div>
    </div>
</body>
</html>