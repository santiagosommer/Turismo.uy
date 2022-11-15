<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="webservice.EstadoError"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/headMobile.jsp"></jsp:include>
    <title>Index Mobile</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <!-- Animate Style -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
</head>
<body>
    
<!-- Navbar -->
<div class="container my-3">
<nav class="navbar navbar-expand-lg bg-* shadow-lg rounded animate__animated animate__fadeInDown">
  <div class="container-fluid">
    <a class="navbar-brand" href="/TurismoMobile/Home">Turismo.uy</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">        
        <li class="nav-item">
          <a class="nav-link" href="/TurismoMobile/ConsultaActividadesIndex">Actividades Turisticas</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/TurismoMobile/IniciarSesion">Salir</a>
          </li>               
      </ul>      
    </div>
  </div>
</nav>               
</div>
<!-- Navbar -->

<div class="row d-flex justify-content-center align-items-center h-100">
    <h1 class ="d-flex justify-content-center align-items-center h-100 animate__animated animate__fadeIn"  style="color:white">Bienvenido a Turismo.uy!</h1>
</div>

    <!-- Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>