<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/inscripcionASalidaTuristica.css"%></style>
    <%@page import="webservice.DtSalidaTuristica"%>
    <%@page import=" java.util.ArrayList"%>
     <%@page import= "java.util.Iterator"%>
    <title>Inscripcion Salida</title>
    
    <script>
    
    document.addEventListener("keyup", function() {
    	  var input = document.getElementById("id-input").value;
    	  var costo = document.getElementById("costo-oculto").textContent;
    	  document.getElementById("costo").innerHTML = "<b>Costo:</b> $" + costo * input;
    	});
    
    </script>
    
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
       
       <% if (Error.equals("Negativo")) {%>
       		Ingresar cantidad mayor a 0.
       <%} %>
    	<% if (Error.equals("CuposInsuficientes")){ %>
 			No hay suficientes cupos.
 		<% } 
 		  if (Error.equals("ExisteInscripcion")){ %>
 			Ya existe una inscripcion.
 		<%} %>
 		 <% if (Error.equals("SalidaExpirada")){ %>
 			La Salida expiro.
 		<%} %>
 		
       
	</div>
	<%} %>
	
		<% Float costo = ((DtSalidaTuristica) request.getSession().getAttribute("dtsalida")).getActividadTuristicaAsoc().getCostoTurista() ;%>
	
		
       <form class="form-register" method="get"> 
            
            <div class="CantidadTuristas">
              <div class="input-container">
                    <div class="input-outer">
                        <img src="media/icons/avatar.svg" class="icon">
                        
                        <input type="number" min="1" id="id-input" class="input-style" placeholder="Cantidad Turistas" name="cantidad-turistas" required >
                    </div>
                 </div>
            </div>     
           

                  
						
                   <p id="costo"><b>Costo:</b> $<%= costo %> </p>
                  

                  <div class="botones">
                  <input type="submit" class="button" id="inscribirButton" value="Inscribirse"> 
                  <button class="button" type="button" id="cancelarButton" onclick="window.location.href='/web/Home';" style="background: white; color: black; border: 2px solid #968EF8;">Cancelar</button>
                </div>



            
            </form>
            
            
            <div id="costo-oculto" style="font-size: 0;"> <%=costo%></div>

        </div>

</body>
</html>