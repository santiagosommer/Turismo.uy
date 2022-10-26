<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/compraPaquete.css"%></style>
    <title>Compra Paquete</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="content">
        <div class="container">
            <div class="h1">
                <h2>Comprar Paquete</h2>
            </div>

                <div class="paquetes">
                        <div class="s2" >  <select name="paquetes" class ="controls" id="cars">
                            <option value="disfrutarRocha">Disfrutar Rocha</option>
                          </select> </div>
                </div>
           <div class="conteiner2"></div>
                <div class="info">
                    <b>Costo:</b>  $0.00 
                    <hr>
                    <b>Cantidad de Turistas:</b>  00 
                    <hr>
                    <b>Vencimiento</b>  00/00/00 
                </div>
            </div>
                    <div class="botones">
                        <button type="button" id="comprarButton">Comprar</button>
                        <button type="button" id="cancelarButton">Cancelar</button>
                    </div>

        </div>


    <script src="./../js/mantenerSesion.js"></script>
    <script src="./../js/compraPaquete.js"></script>
</body>
</html>