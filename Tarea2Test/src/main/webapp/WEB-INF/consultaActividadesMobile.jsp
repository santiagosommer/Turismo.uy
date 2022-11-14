<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="webservice.EstadoError"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/headMobile.jsp"></jsp:include>
    <%@page import="java.util.Set"%>
    <%@page import="java.util.Iterator"%>
    <%@page import="webservice.*"%>
    <title>Consulta Actividades Mobile</title>
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
          <a class="nav-link" href="./html/consultaActividades.html">Actividades Turisticas</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="./html/iniciarSesion.html">Salir</a>
          </li>               
      </ul>      
    </div>
  </div>
</nav>               
</div>
<!-- Navbar -->

<div class="container my-3">

<%
        Set<String> deptos = (Set<String>) request.getAttribute("departamentos");
        Set<String> cats = (Set<String>) request.getAttribute("categorias");
        Set<DtActividadTuristica> acts = (Set<DtActividadTuristica>) request.getAttribute("lista_actividades_a_mostrar");
%>
    
    <div class="dropdown">
    	<form class="filtros" action="ConsultaActividadesIndex" method="get">
        	<button class="dropb btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
            	Departamentos
        	</button>
        	<ul class="dropdown-menu">
          	<li><a class="dropdown-item" href="#">Action</a></li>
          	<li><a class="dropdown-item" href="#">Another action</a></li>
          	<li><a class="dropdown-item" href="#">Something else here</a></li>
        	</ul>
          
        	<button class="dropb btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Categorias
        	</button>
        	<ul class="dropdown-menu">
	            <li><a class="dropdown-item" href="#">Action</a></li>
            	<li><a class="dropdown-item" href="#">Another action</a></li>
            	<li><a class="dropdown-item" href="#">Something else here</a></li>
        	</ul>
        </form>
    </div>

        <div class="row text-center animate__animated animate__bounceInUp">
            <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 mb-3">
                <div class="card shadow">
                    <div class="card-body">
                        <h5 class="card-title">Card Title 1</h5>
                        <img src="./../media/download.jpg" class="img-fluid" alt="Responsive image">
                        <p class="card-text">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ex dolor vel reiciendis quas id mollitia adipisci ipsa non, necessitatibus totam?</p>
                        <a href="#" class="btn btn-info">Go somewhere</a>
                    </div>
                </div>
            </div>          
             
        </div>      
</div>


    <!-- Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>