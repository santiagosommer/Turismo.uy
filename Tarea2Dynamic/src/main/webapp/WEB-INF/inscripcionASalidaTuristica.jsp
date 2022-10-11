<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/inscripcionASalidaTuristica.css"%></style>
    <title>Inscripcion Salida</title>
</head>
<body>
    
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    
        <div class="container">
            <div class="h1">
                <h2>Inscribirse a Salida Turistica</h2>
            </div>


        <div></div>    
            
            <div class="CantidadTuristas">
              <div class="input-container">
                    <div class="input-outer">
                        <img src="media/icons/avatar.svg" class="icon">
                        <input type="text" id="id-input" class="input-style" placeholder="Cantidad Turistas" name="cantidad-turistas" required>
                    </div>
                 </div>
            </div>     
           

            <div class="tabs">
                <div class="tab">
                    <button class="tablinks" onclick="openCity(event, 'General')">General</button>
                    <button class="tablinks" onclick="openCity(event, 'Paquete')">Paquete</button>
                </div>
                  <div id="General" class="tabcontent">

                    <p><b>Costo:</b> $0.00 </p>
                  </div>

                  <div id="Paquete" class="tabcontent">
                    <select name="paquetes" class ="controls" id="Paquete">
                        <option value="gastronomia"> Paquetes Disponibles </option>

                      </select>
                    <p> <b> Descuento:  </b> 0.00%</p>

                    <p> <b> Costo:</b> $0.00</p>



                  </div>
                  <div class="botones">
                    <button type="button" id="inscribirButton">Inscribirse</button>
                    <button type="button" id="cancelarButton">Cancelar</button>
                </div>



            </div>

        </div>

    <script src="media/js/mantenerSesion.js"></script>
    <script src="media/js/inscripcionASalidaTuristica.js"></script>
</body>
</html>