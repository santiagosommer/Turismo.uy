<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="webservice.EstadoError"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/headMobile.jsp"></jsp:include>
    <%@page import="webservice.DtSalidaTuristica"%>
    <%@page import="webservice.EstadoSesion"%>
    <title>Consulta Actividad Mobile</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <!-- Animate Style -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
    <!-- Custom CSS -->
    <style><%@include file="./../media/css/consultaMobile.css"%></style>
</head>
<body>
    
<!-- Navbar -->
<div class="container my-3">
<nav class="navbar navbar-expand-lg bg-* shadow-lg rounded animate__animated animate__fadeInDown">
  <div class="container-fluid">
    <a class="navbar-brand" href="./index.html">Turismo.uy</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">        
        <li class="nav-item">
          <a class="nav-link" href="/TurismoMobile/ConsultaActividadesMobile">Actividades Turisticas</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/TurismoMobile/Home">Salir</a>
          </li>               
      </ul>      
    </div>
  </div>
</nav>               
</div>
<!-- Navbar -->

<section class="vh-100 gradient-custom">
  
  		<% String fecha = "";
           String hora = "";
           String cupos = "";
           String lugar = "";
           String nombre = "";
           if ((DtSalidaTuristica) request.getSession().getAttribute("salida_dt") != null) {
        	   DtSalidaTuristica s = (DtSalidaTuristica) request.getSession().getAttribute("salida_dt") ;
        	   nombre = s.getNombre();
        	   fecha = s.getInfoSalida().getFecha().toString();
        	   hora = s.getInfoSalida().getHora().toString();
        	   lugar = s.getInfoSalida().getLugar();
        	   cupos = String.valueOf(s.getCuposDisponibles());
           }%>

    <div class="container py-5 ">
    <div class="row text-center justify-content-center animate__animated animate__bounceInUp">
        <div class="col-sm-8 col-md-10 col-lg-6 col-xl-4">
            <div class="card shadow">
                <div class="card-body">
                    <h5 class="card-title"> <%= nombre %> </h5>
                    <img src="./../media/download.jpg" class="img-fluid" alt="Responsive image">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item" role="presentation" style="color: aqua;">
                          <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Info</button>
                        </li>
                        
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="salidas tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab"><p class="card-text">
                        <b>Fecha: </b><%= fecha %>
                        <br>
                        <b>Hora: </b><%= hora %>
                        <br>
                        <b>Cupos Disponibles:: </b> <%= cupos %>
                        <br>
                        <b>Lugar: </b><%= lugar %>                        
                        </div>
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>

  </section>

    <!-- Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>