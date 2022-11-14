<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="webservice.EstadoError"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/headMobile.jsp"></jsp:include>
    <%@page import="java.util.Set"%>
    <%@page import="java.util.Iterator"%>
    <%@page import=" java.util.ArrayList"%>
    <%@page import="webservice.*"%>
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

<section class="vh-100 gradient-custom">
  
	<%  
        String nombre = "";
     	int duracion = 0;
     	float costo = 1;
     	String ciudad = "";
     	String fechaAlta = "";
     	Set<String> cate = null;
     	String descripcion = "";
     	//agregar paquetes
     	ArrayList<DtPaquete> paque = new ArrayList<DtPaquete>();
     	ArrayList<DtSalidaTuristica> Salidas = new ArrayList<DtSalidaTuristica>();
        
         if (request.getSession().getAttribute("act_dt") != null) {
     		DtActividadTuristica act = (DtActividadTuristica) request.getSession().getAttribute("act_dt");
     		nombre = act.getNombre();
     		duracion = act.getDuracion();
     		costo = act.getCostoTurista();
     		ciudad = act.getCiudad();
     		fechaAlta = act.getFechaAlta().toString();
     		descripcion = act.getDescripcion();
     		Salidas = (ArrayList<DtSalidaTuristica>) act.getSalidas();
     	    cate = (Set<String>) act.getCategorias();
     		paque = (ArrayList<DtPaquete>) act.getInfoPaquetes();
     		
         }	
     %>

    <div class="container py-5 ">
    <div class="row text-center justify-content-center animate__animated animate__bounceInUp">
        <div class="col-sm-8 col-md-10 col-lg-6 col-xl-4">
            <div class="card shadow">
                <div class="card-body">
                    <h5 class="card-title"> <%= nombre %> </h5>
                    <img src="media/icons/avatar.svg" class="img-fluid" alt="Responsive image">
                    <ul class="nav nav-tabs" id="myTab" role="tablist">
                        <li class="nav-item" role="presentation" style="color: aqua;">
                          <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">Info</button>
                        </li>
                        <li class="nav-item" role="presentation">
                          <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">Salidas</button>
                        </li>
                        <li class="nav-item" role="presentation">
                          <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false">Paquetes</button>
                        </li>
                    </ul>
                    <div class="tab-content" id="myTabContent">
                        <div class="salidas tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab"><p class="card-text">
                        <b>Descripcion: </b><%= descripcion %>
                        <br>
                        <b>Duracion: </b><%= duracion %><br><b>Costo: </b>$<%= costo %>
                        <br>
                        <b>Ciudad: </b><%= ciudad %>
                        <br>
                        <b>Fecha alta: </b><%= fechaAlta %>
                        <br>
                        <b>Categorias: </b>
                        <% if(cate != null)for(String s : cate){ %>
							<%= s %>
			  			<% } %>
			  			</p>
                        </div>
                        <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            <!-- Tab Salidas -->
                        <div class="salidas">
                        <% for (int i=0; i< Salidas.size();i++) { %>
                            <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 mb-3">
                                <div class="card shadow">
                                    <div class="card-body">                                        
                                        <p class="card-text">
                                        <h3><%=  Salidas.get(i).getNombre() %></h3>
                  <p><a href="/Tarea2Test/ConsultaSalida?paramS=<%=Salidas.get(i).getNombre()%>" class="links">Leer mas.</a></p> 
                                        </p>                                                                                
                                    </div>
                                </div>
                            </div>                           
                        </div>
                        <hr>
                        <%} %>
                            <!-- Tab Salidas -->
                        </div>
                        <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">
                            <!-- Tab Paquetes -->
                            <% for (int i=0; i< paque.size();i++) { %>
                            <div class="salidas">
                                <div class="col-sm-12 col-md-6 col-lg-4 col-xl-4 mb-3">
                                    <div class="card shadow">
                                        <div class="card-body">                                        
                                            <p class="card-text">
                                            <h3><%=  paque.get(i).getNombre() %></h3>
                  <p><a href="/Tarea2Test/ConsultaPaquete?paramPaq=<%=paque.get(i).getNombre()%>" class="links">Leer mas.</a></p>  
                                            </p>                                                                                
                                        </div>
                                    </div>
                                </div>                               
                            </div>
                            <%} %>
                            <!-- Tab Paquetes -->
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