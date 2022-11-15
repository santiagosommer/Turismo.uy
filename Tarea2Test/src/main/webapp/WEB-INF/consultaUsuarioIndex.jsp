<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <%@page import="java.util.ArrayList"%>
    <%@page import="java.util.Iterator"%>
    <%@page import="webservice.SetDTUsuario"%>
    <%@page import="webservice.DtUsuario"%>
    <%@page import="webservice.DtTurista"%>
    <%@page import="webservice.DtProveedor"%>
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
                       <% //borrado %>
                </div>
            </div>
            <div class="Consultas">
            
            
             <% 
          
        if (request.getAttribute("Usuarios") != null) {
        	ArrayList<DtUsuario> s = (ArrayList<DtUsuario>) request.getAttribute("Usuarios") ;
             for (int i = 0; i < s.size(); i++) {
            	String nick = s.get(i).getNickname();
            	%>	
            	
            	 <div class="container-consulta">
                    <div class="img-container">
                        <img src="media/icons/avatar.svg" height="200">
                    </div>
                    <h3> <%= s.get(i).getNombre()%></h3>
                    <h5> <%= nick%> / <%= s.get(i).getEmail()%></h5>
                    <%   if (s.get(i) instanceof DtProveedor) {
                    	%>
                    	<p><a href="/Tarea2Test/ConsultaProveedor?paramP=<%=nick%>" class="links">Leer mas.</a></p>
                    	
                    <%	}
                    	%>
                    	
                    	 <%   if (s.get(i) instanceof DtTurista) {
                    	%>
                    	<p><a href="/Tarea2Test/ConsultaTurista?paramT=<%=nick%>" class="links">Leer mas.</a></p>
                    	
                    
                     <%	}
                    	%>
                   
                </div>
                <hr>
                
              
        <%

           }             
        }
    %>
           
               
               
          
        </div>
       
    </div>
    
     
    </div>
    
    

    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>