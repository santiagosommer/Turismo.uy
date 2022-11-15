<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/head.jsp"></jsp:include>
    
    <script  >
    
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
    <style> <%@include file="./../media/css/consultaUsuarioIndex.css"%> </style>
   
    <%@page import="webservice.*"%>
     <%@page import=" java.util.ArrayList"%>
     <%@page import= "java.util.Iterator"%>
     <%@page import="java.text.SimpleDateFormat"%>
    <%@page import="java.util.Date"%>
     
    <title>Consulta Proveedor</title>
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
         String apellido = "";
         
         ArrayList<DtUsuario> seg = new ArrayList<DtUsuario>();
         boolean esPropio = false;
         ArrayList<DtActividadTuristica> act = new ArrayList<DtActividadTuristica>();
        if (request.getSession().getAttribute("prov_dt") != null) {
           DtProveedor p = (DtProveedor) request.getSession().getAttribute("prov_dt");
     
            nombre = p.getNombre();
            nickName = p.getNickname();
            email = p.getEmail();
            fechaN = new SimpleDateFormat("MM/dd/yyyy").format(p.getFechaNacimiento().toGregorianCalendar().getTime());
            
            desc =  p.getDescripcionGeneral();
            url = p.getURL();
            apellido = p.getApellido();
            act = (ArrayList<DtActividadTuristica>) p.getInfoActividades();
            //seg = p.getSeguidores();
             
            if ((EstadoSesion) request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_PROVEEDOR) {
              	 
            	   if ((DtProveedor) request.getSession().getAttribute("usuario_dt") != null) {
            		   DtProveedor prov = (DtProveedor) request.getSession().getAttribute("usuario_dt");
            		 if (nickName.equals(prov.getNickname())){
            			 esPropio = true;
            		 }
         
       	 }
            }
        }
%>	
                <div class="img-container">
                    <img src="media/icons/avatar.svg" height="200">
                </div>
                <h3>  <%= nombre%> </h3>
                <h5> <%= nickName %> / <%= email%></h5>
                </div>
            <div class="top-bar-links">
                <div class="tab">
                    <div class="tablinks" id="Perfil-tab" onclick="openTab(event, 'Perfil')">
                        Perfil
                    </div>
                </div>
                
                <div class="tab">
                    <div class="tablinks" id="Seguidores-tab" onclick="openTab(event, 'Seguidores')">
                        Seguidores
                    </div>
                </div>
                
                <div class="tab">
                    <div class="tablinks" id="Actividades-tab" onclick="openTab(event, 'Actividades')">
                        Actividades
                    </div>
                </div>
            </div>
            <div class="tab-contents">
                <div id="Perfil" class="tabcontent">
                    <p><b>Nickname:</b> <%= nickName%></p>
                    <p><b>Nombre: </b> <%= nombre%></p>
                    <p><b>Apellido: </b> <%= apellido%></p>
                    <p><b>E-mail:</b> <%= email %></p>
                    <p><b>Fecha de Nacimiento:</b> <%= fechaN %></p>
                    <p><b>Descripcion:</b> <%= desc %> </p>
                    <p><b>URL:</b>  <%= url %> </p>
                </div>
                
                  <div id="Seguidores">
               <% for (int j = 0; j < seg.size(); j++){  %>  
                     <div class="Salida">
						  <div class="imagenSalida">
                             <img src = "media/icons/avatar.svg">
                          </div>
                          <div class="Salida-text">
                             <% DtTurista tur = (DtTurista) seg.get(j);
                              DtProveedor prov = (DtProveedor) seg.get(j);
                              if (tur!= null) { //mostrar nickname %>
                                 <%= tur.getNickname() %>
                              <%}  if (prov!=null) {%>
                                 <%= prov.getNickname() %>
                              <%} %>
                          </div>
                     </div>   
               <%} %>        
                
                </div>
                
                <%if (esPropio){ %>
                 <div id="Actividades" class="tabcontent">
                
                <%   
                ArrayList<DtActividadTuristica> actividades = new ArrayList<DtActividadTuristica>();
                if ((EstadoSesion)request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_PROVEEDOR) {
                   DtProveedor p = (DtProveedor) request.getSession().getAttribute("prov_dt");
                   actividades = (ArrayList<DtActividadTuristica>) p.getInfoActividades();

                for (int i=0; i < actividades.size();i++) {
                    
                     %>
                    <div class="Actividad">
                        <div class="imagenActividad">
                            <img src = "media/icons/avatar.svg">
                        </div>
                        <div class="Actividad-text">
						
                            <h3> <%= actividades.get(i).getNombre() %> </h3>
                            <p>Estado: <%= actividades.get(i).getEstado() %></p>
                            <p><a href="/Tarea2Test/ConsultaActividadIndividual?paramAct=<%= actividades.get(i).getNombre() %>" class="links">Leer más.</a></p>
                        </div>
                    </div>
                    <hr>     
                    
      <%     }  } %>        
                    
                </div>
                
                
                <%} else {%>
                <div id="Actividades" class="tabcontent">
                
                <% for (int i=0; i< act.size();i++) {
                	
                	if (act.get(i).getEstado() == EstadoActividad.CONFIRMADA) {
                    
                     %>
                    <div class="Actividad">
                        <div class="imagenActividad">
                            <img src = "media/icons/avatar.svg">
                        </div>
                        <div class="Actividad-text">
                            <h3><%= act.get(i).getNombre() %></h3>
                            <p><a href="/Tarea2Test/ConsultaActividadIndividual?paramAct=<%=act.get(i).getNombre() %>" class="links">Leer mas.</a></p>
                        </div>
                    </div>
                    <hr>

                    <% }} }%>
                    

                <script>window.onload=openTab(event, 'Perfil');</script>
                   
                </div>
            </div>
        </div>
    </div>

 
    <script src="./../js/mantenerSesion.js"></script>
</body>
</html>