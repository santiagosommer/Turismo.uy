<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    <title>Consulta Usuario</title>
</head>
<body>
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div style="display: flex; flex-direction: column;">
        <div style="display:flex; align-items: center; gap: 20px; justify-content: center;">
            <img src="./../icons/user-search.svg" style="height:96px; " alt="">
            <h1 style="text-align: center;">Consultar usuarios</h1>
        </div>
        <div class="content">
            <div class="filtros">
                <div class="filtro">
                        <select name="TipoUsuario" class="Categoria">
                            <option>Usuario</option>
                            <option>Turista</option>
                            <option>Proveedor</option>
                        </select>
                </div>
            </div>
            <div class="Consultas">
                <div class="container-consulta">
                    <div class="img-container">
                        <img src="https://pbs.twimg.com/media/EOHAP9zWoAsnkiM?format=jpg&name=small" height="200">
                    </div>
                    <h3>Rosa Maria Martinez</h3>
                    <h5>lachiqui / mirtha.legrand.ok@hotmail.com.ar</h5>
                    <p><a href="./consultaUsuarioHardcoded.html" class="links">Leer mas.</a></p>
                </div>
                <hr>
                <div class="container-consulta">
                    <div class="img-container">
                        <img src="https://ca-times.brightspotcdn.com/dims4/default/2413d30/2147483647/strip/true/crop/720x1024+0+0/resize/840x1195!/format/webp/quality/90/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F9b%2Fe3%2F0973ea3441e396271b457c1e0b31%2Fap22146719572803.jpg" height="200">
                    </div>
                    <h3>Elizabeth Windsor</h3>
                    <h5>isabelita / isabelita@thecrown.co.uk</h5>
                    <p><a href="#" class="links">Leer mas.</a></p>
                </div>
                <hr>
                <div class="container-consulta">
                    <div class="img-container">
                        <img src="https://es.web.img2.acsta.net/c_310_420/pictures/14/01/20/09/27/059623.jpg" height="200">
                    </div>
                    <h3>Anibal Martinez</h3>
                    <h5>anibal / anibal@fing.edu.uy</h5>
                    <p><a href="#" class="links">Leer mas.</a></p>
                </div>
                <hr>
                <div class="container-consulta">
                    <div class="img-container">
                        <img src="https://c.wallhere.com/photos/55/39/safe_house_cia_agent_tobin_frost_denzel_washington-584127.jpg!d" height="200">
                    </div>
                    <h3>Washington Rocha</h3>
                    <h5>washington / washington@turismorocha.gub.uy</h5>
                    <p><a href="./consultaProveedorHardcoded.html" class="links">Leer mas.</a></p>
                </div>
                <hr>
                <div class="container-consulta">
                    <div class="img-container">
                        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSI6iVebQtM32FoIZFXUPSIhJlQo2asvOouzw&usqp=CAU" height="200">
                    </div>
                    <h3>Pablo Bengoechea</h3>
                    <h5>eldiez / eldiez@socfomturriv.org.uy</h5>
                    <p><a href="#" class="links">Leer mas.</a></p>
                </div>
                <hr>
                <div class="container-consulta">
                    <div class="img-container">
                        <img src="https://pbs.twimg.com/media/EmLg8pkXYAAkuGY?format=jpg&name=small">
                    </div>
                    <h3>Mercedes Venn</h3>
                    <h5>meche / meche@colonia.gub.uy</h5>
                    <p><a href="#" class="links">Leer mas.</a></p>
                </div>
            </div>
        </div>
    </div>

    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>