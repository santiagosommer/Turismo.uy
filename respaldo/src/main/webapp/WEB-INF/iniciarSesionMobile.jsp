<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/headMobile.jsp"></jsp:include>
    <title>Inicio Sesion movil</title>
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <!-- Animate Style -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
</head>
<body>
    
<section class="vh-100 gradient-custom">
    
    <div class="container py-5 h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5 text-center" style="color: white;">
            <h1 class="animate__animated animate__fadeInDown">Turismo.uy</h1>
          <div class="card bg-dark text-white animate__animated animate__fadeIn" style="border-radius: 1rem;">
            <div class="card-body p-5 text-center">
  
              <div class="mb-md-5 mt-md-4 pb-5">
  				
  				<form action="IniciarSesion" method="post">
  				

                
  				
                <h2 class="fw-bold mb-2 text-uppercase">Ingresar</h2>
                <p class="text-white-50 mb-5">Por favor, ingrese sus datos.</p>
  
                <div class="form-outline form-white mb-4">
                  <input type="text" id="typeEmailX" class="form-control form-control-lg" name="email-or-nickname-content" required/>
                  <label class="form-label" for="typeEmailX">Nick o Email</label>
                </div>
  
                <div class="form-outline form-white mb-4">
                  <input type="password" id="typePasswordX" class="form-control form-control-lg" name="password-content" required/>
                  <label class="form-label" for="typePasswordX">Contraseña</label>
                </div>
  
                
  
                <button class="btn btn-outline-light btn-lg px-5" type="submit">Ingresar</button>
  				
  				</form>
               
  
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