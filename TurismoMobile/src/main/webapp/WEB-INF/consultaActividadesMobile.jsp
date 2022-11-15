<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="webservice.EstadoError"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/headMobile.jsp"></jsp:include>
    <%@page import="java.util.ArrayList"%>
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
        ArrayList<String> deptos = (ArrayList<String>) request.getAttribute("departamentos");
        ArrayList<String> cats = (ArrayList<String>) request.getAttribute("categorias");                                                       
        ArrayList<DtActividadTuristica> acts = (ArrayList<DtActividadTuristica>) request.getAttribute("lista_actividades_a_mostrar");
        %>
    
    <div class="dropdown">
    	<form class="filtros" action="ConsultaActividadesIndex" method="get">
        	<select class="form-select" aria-label="Departamentos">
                <option value="Departamento">Departamentos</option>
                <%for (int i = 0; i < deptos.size(); i++){%>
	            			<option value="<%= deptos.get(i) %>">
	                    	<%= deptos.get(i) %>
	                    	</option>
                    	<% } %>
              </select>
              
              <select class="form-select" aria-label="Departamentos">
                <option value="Categoria">Categoria</option>
                           <%for (int i = 0; i < cats.size(); i++) {%>
		            			<option value="<%= cats.get(i) %>">
		                    	<%= cats.get(i) %>
		                    	</option>
	                   		<% } %>
              </select>     
        </form>
    </div>

		<%for (DtActividadTuristica s : acts) {%>
        <div class="row text-center animate__animated animate__bounceInUp">
            <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 mb-3">
                <div class="card shadow">
                    <div class="card-body">
                        <h5 class="card-title"> <%= s.getNombre() %> </h5>
                        <img src="media/icons/avatar.svg" class="img-fluid" alt="Responsive image">
                        <p class="card-text"> <%= s.getDescripcion() %> </p>
                        <a href="/Tarea2Test/ConsultaActividadIndividual?paramAct=<%= s.getNombre()%>" class="btn btn-info">Leer mas.</a>
                    </div>
                </div>
            </div>          
             
        </div>
        <% } %>      
</div>


    <!-- Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>