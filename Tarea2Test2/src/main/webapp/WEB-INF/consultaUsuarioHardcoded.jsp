<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    <%@page import="java.util.Set"%>
    <%@page import="java.util.Iterator"%>
    <%@page import="ServidorCentral.Logica.DataTypes.*"%>
    
       <script >
       let i, tabcontent, tablinks;
       tabcontent = document.getElementsByClassName("tabcontent");
       tablinks = document.getElementsByClassName("tablinks");


       //Grab the first tab and open it
       tabcontent[0].style.display = "block";
       tablinks[0].classList += " selected";

       function openTab(evt, tabName) {
           // Get all elements with class="tabcontent" and hide them
           tabcontent = document.getElementsByClassName("tabcontent");
           for (i = 0; i < tabcontent.length; i++) {
               tabcontent[i].style.display = "none";
           }

           // Get all elements with class="tablinks" and remove the class "selected"
           tablinks = document.getElementsByClassName("tablinks");
           for (i = 0; i < tablinks.length; i++) {
               tablinks[i].className = tablinks[i].className.replace(" selected", "");
           }

           // Show the current tab, and add a "selected" class to the button that opened the tab
           document.getElementById(tabName).style.display = "block";
           document.getElementById(tabName+"-tab").classList += " selected";
       }
       
       </script>
    <style><%@include file="./../media/css/consultaUsuarioIndex.css"%></style>
    
    <%@page import=" java.util.ArrayList"%>
     <%@page import= "java.util.Iterator"%>
    
    
    <title>Consulta Usuario</title>
</head>
<body>

    <jsp:include page="/WEB-INF/topBar.jsp"></jsp:include>


    <div class="content">
        <div class="Consultas">
         <% 
         String nombre ="";
         String nickName ="";
         String email ="";
         String fechaN = "";
         String desc ="";
         String url = "";
         String nacionalidad = "";
         String apellido = "";
         
         boolean esPropio = false;
         ArrayList<DTInscripcion> InscSal = new ArrayList<DTInscripcion>();
         
        if (request.getSession().getAttribute("turi_dt") != null) {
           DTTurista t = (DTTurista) request.getSession().getAttribute("turi_dt") ;
            nombre = t.getNombre();
            nickName = t.getNickname();
            apellido = t.getApellido();
            email = t.getEmail();
            fechaN = t.getFechaNacimiento().toString();
            nacionalidad = t.getNacionalidad();
            InscSal = t.getInscripciones();
		 
            if ((EstadoSesion) request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) {
       	 
       	      if ((DTTurista) request.getSession().getAttribute("usuario_dt") != null) {
       		    DTTurista turi = (DTTurista) request.getSession().getAttribute("usuario_dt");
       		    if (nickName.equals(turi.getNickname())){
       			  esPropio = true;
       		    }
       	       }
       	     }
        }
        
        
         %>	
    
            <div class="container-consulta">
                <div class="img-container">
                    <img src="media/icons/avatar.svg" height="200">
                </div>
                <h3> <%= nombre %> 	 <%=apellido  %> </h3>
                <h5> <%= nickName %> / <%= email %> </h5>
            </div>
            <div class="top-bar-links">
                <div class="tab">
                    <div class="tablinks" id="Perfil-tab" onclick="openTab(event, 'Perfil')">
                        Perfil
                    </div>
                </div>
                <div class="tab">
                    <div class="tablinks" id="Salidas-tab" onclick="openTab(event, 'Salidas')">
                        Salidas
                    </div>
                </div>
                <%if (esPropio){ %>
                  <div class="tab" id="Paquetes-tab-container">
                    <div class="tablinks" id="Paquetes-tab" onclick="openTab(event, 'Paquetes')">
                        Paquetes
                    </div>
                </div>
                <%} %>
            </div>
            <div class="tab-contents">
           		 <div id="Paquetes" class="tabcontent">
             
                </div>
                <div id="Perfil" class="tabcontent">
                    <p><b>Nickname:</b>  <%= nickName %> </p>
                    <p><b>Nombre:</b> <%= nombre %> </p>
                    <p><b>Apellido: </b> <%= apellido%></p>
                    <p><b>E-mail:</b>  <%= email %> </p>
                    <p><b>Fecha de Nacimiento:</b>  <%= fechaN %> </p>
                    <p><b>Nacionalidad:</b> <%= nacionalidad %> </p>
                </div>
                <div id="Salidas" class="tabcontent">
                
                 <% for (int i=0; i< InscSal.size();i++) {
                    
                     %>
                      <div class="Salida">
						  <div class="imagenSalida">
                             <img src = "media/icons/avatar.svg">
                          </div>
                          <div class="Salida-text">
                             <h3><%= InscSal.get(i).getSalidaAsociada().getNombre() %></h3>
                             <%if(esPropio){ %>
                           	 	<p> Fecha Inscripcion:<%= InscSal.get(i).getFecha().toString() %> </p>
                           	 	<p>Cantidad Turistas: <%= InscSal.get(i).getCantidadTuristas() %> </p>
                            	<p> Costo: <%= InscSal.get(i).getCosto() %> </p>	
                             <%} %>
                            <p><a href="/Tarea2Test/ConsultaSalida?paramS=<%=InscSal.get(i).getSalidaAsociada().getNombre()%>" class="links">Leer mas.</a></p>
                            
                          </div>
                      </div>
                    
                    <%} %>
                    <script>window.onload=openTab(event, 'Perfil');</script>

                </div>
            </div>
        </div>
    </div>

  
</body>
</html>