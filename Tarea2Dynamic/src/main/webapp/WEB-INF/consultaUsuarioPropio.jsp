<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
     <%@page import="java.util.Set"%>
    <%@page import="java.util.Iterator"%>
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
    <style><%@include file="./../media/css/consultaUsuario.css"%></style>
    <title>Perfil</title>
</head>
<body>
    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>

    <div class="content">
        <div class="Consultas">
            <div class="container-consulta">
              <% 
         String nombre ="";
         String nickName ="";
         String email ="";
         String fechaN = "";
         String desc ="";
         String url = "";
         
         if (request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) {
        	 
        	   if (request.getSession().getAttribute("usuario_dt") != null) {
        		           DTTurista t = (DTTurista) request.getSession().getAttribute("usuario_dt");
        		           nombre = t.getNombre();
        		           nickName = t.getNickname();
        		           email = t.getEmail();
        		           fechaN = t.getFechaNacimiento().toString();
        		           String nacionalidad = "";
        		           nacionalidad = t.getNacionalidad();
       		  }
         }
        
       
        	   
        	   if (request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_PROVEEDOR) {
              	 
            	   if (request.getSession().getAttribute("usuario_dt") != null) {
            		           DTProveedor p = (DTProveedor) request.getSession().getAttribute("usuario_dt");
            		           nombre = p.getNombre();
            		           nickName = p.getNickname();
            		           email = p.getEmail();
            		           fechaN = p.getFechaNacimiento().toString();
 
             }
        	   }
     
            //seguir con las Salidas
            
            
            
       
            	%>	
            	
    
                <div class="img-container">
                    <img id="img-perfil" src="" height="200">
                </div>
                <h3 id="title-nombre"> <%= nombre %>	</h3>
                <h5 id="title-nickname-email"> <%= nickName %> / <%= email %>  </h5>
                </div>
            <div class="top-bar-links">
                <div class="tab">
                    <div class="tablinks" id="Perfil-tab" onclick="openTab(event, 'Perfil')">
                        Perfil
                    </div>
                </div>
                <div class="tab" id="Actividades-tab-container">
                    <div class="tablinks" id="Actividades-tab" onclick="openTab(event, 'Actividades')">
                        Actividades
                    </div>
                </div>
                <div class="tab" id="Salidas-tab-container">
                    <div class="tablinks" id="Salidas-tab" onclick="openTab(event, 'Salidas')">
                        Salidas
                    </div>
                </div>
                <div class="tab" id="Paquetes-tab-container">
                    <div class="tablinks" id="Paquetes-tab" onclick="openTab(event, 'Paquetes')">
                        Paquetes
                    </div>
                </div>
            </div>
            <div class="tab-contents">
                <div id="Perfil" class="tabcontent">
                </div>
                <div id="Actividades" class="tabcontent">
                </div>
                <div id="Salidas" class="tabcontent">
                </div>
                <div id="Paquetes" class="tabcontent">
                </div>
            </div>
        </div>
    </div>

    <script src="./../js/consultaDeUsuario.js"></script>
    <script src="./../js/mantenerSesion.js"></script>
    <script src="./../js/consultaUsuarioPropio.js"></script>
</body>
</html>