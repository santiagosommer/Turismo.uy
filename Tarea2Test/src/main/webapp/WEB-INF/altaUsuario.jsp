<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/altaUsuario.css"%></style>
    <title>Registro Usuario</title>
</head>
<body>
    
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="content">
    
        <div class="titles">
            <h1>¿Quién eres?</h1>
        </div>

        <div class="altaUsuario">
        	<figure>
            	<a href="/Tarea2Test/AltaTurista">                
            		<img src="media/icons/plane.svg" alt="" class="img-altaUsuario">                                        
            	</a>
            	<figcaption>
                	<a style="text-decoration:none;color:black;" href="/Tarea2Test/AltaTurista">  
                		Turista
                	</a>
                </figcaption>  
            </figure>
            
            <figure>            
            	<a href="/Tarea2Test/AltaProveedor">            
                	<img src="media/icons/ticket.svg" alt="" class="img-altaUsuario">
                </a>     
                <figcaption>
                	<a style="text-decoration:none;color:black;" href="/Tarea2Test/AltaProveedor">  
                		Proveedor
                	</a>
                </figcaption>               
                </figure>                           
        </div>
    </div>
</body>
</html>