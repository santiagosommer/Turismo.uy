<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/inscripcionASalidaTuristica.css"%></style>
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
    <%@page import=" java.util.ArrayList"%>
     <%@page import= "java.util.Iterator"%>
    <title>Inscripcion Salida</title>
</head>
<body>
    
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    
        <div class="container">
            <div class="h1">
                <h2>Inscribirse a Salida Turistica</h2>
            </div>
<% String Error =  (String) request.getAttribute("error"); %>
<% if (Error!= null){ %>
	<div class="error-frame">
       
       
    	<% if (Error.equals("CuposInsuficientes")){ %>
 			No hay suficientes cupos.
 		<% } 
 		  if (Error.equals("ExisteInscripcion")){ %>
 			Ya existe una inscripcion.
 		<%} %>
 		
       
	</div>
	
	<% } %>

       <form class="form-register" method="get"> 
            
            <div class="CantidadTuristas">
              <div class="input-container">
                    <div class="input-outer">
                        <img src="media/icons/avatar.svg" class="icon">
                        
                        <input type="text"  id="id-input" class="input-style" placeholder="Cantidad Turistas" name="cantidad-turistas" required >
                    </div>
                 </div>
            </div>     
           

                  
						
                   <p><b>Costo:</b>  $$ </p>
                  

                  <div class="botones">
                  <input type="submit" class="button" id="inscribirButton" value="Inscribirse"> 
                  <button class="button" type="button" id="cancelarButton" onclick="window.location.href='/Tarea2Test/Home';" style="background: white; color: black; border: 2px solid #968EF8;">Cancelar</button>
                </div>



            
            </form>

        </div>

</body>
</html>