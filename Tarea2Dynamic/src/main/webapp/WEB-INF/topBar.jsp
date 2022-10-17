<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="ServidorCentral.Logica.DataTypes.EstadoSesion"%>
<%@page import="ServidorCentral.Logica.DataTypes.DTTurista"%>
<%@page import="ServidorCentral.Logica.DataTypes.DTProveedor"%>

<div class="top-bar">
	<div class="top-bar-left">
        <img src="media/icons/bus.svg" class="bus-icon">
        <div class="top-bar-links">
            <a href="/Tarea2Dynamic/Home" class="links selected">Principal</a>
            <a href="#" class="links">Actividades</a>
            <a href="#" class="links">Paquetes</a>
        </div>
    </div>
    <div class="top-bar-right">
        <div class="search-bar">
            <label for="search-bar-input"></label>
            <input type="text" id="search-bar-input" class="search-bar-input" size="30" placeholder="Actividades, Paquetes, etc..." name="search-bar-content">
            <a href="#"><img src="media/icons/zoom.svg" class="icon"></a>
        </div>
        <a href="/Tarea2Dynamic/ConsultaUsuario"><img src="media/icons/group.svg" class="larger-icon"></a>
		
		<% if (request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_PROVEEDOR) { %>
		
		<div id="menu-proveedor" class="dropdown">
            <h5 class="menu-proveedor-dropdown">Menu Proveedor</h5>
            <div class="dropdown-content">
                <a href="#">Alta de Actividad Turistica</a>
                <a href="#">Alta de Salida Turistica</a>
            </div>
		</div>
		
		<div style="display:flex; align-items: center; gap: 5px;">
		<% DTProveedor prov =(DTProveedor) request.getSession().getAttribute("usuario_dt"); %>
            <h3 id="user-name"><%= prov.getNombre() %></h3>
            <div class="dropdown">
                <img src="media/icons/avatar.svg" class="avatar icon">
                <div class="dropdown-content">
                    <a id="dropdown-1" href="#">Ver Perfil</a>
                    <a id="dropdown-2" href="/Tarea2Dynamic/CerrarSesion">Cerrar Sesion</a>
                </div>
            </div>
        </div>
        
		<% }else{ %>
		
			<% if (request.getSession().getAttribute("estado_sesion") == EstadoSesion.LOGIN_TURISTA) { %>
			
			<div style="display:flex; align-items: center; gap: 5px;">
			<% DTTurista turi =(DTTurista) request.getSession().getAttribute("usuario_dt"); %>
	            <h3 id="user-name"><%= turi.getNombre() %></h3>
	            <div class="dropdown">
	                <img src="media/icons/avatar.svg" class="avatar icon">
	                <div class="dropdown-content">
	                    <a id="dropdown-1" href="#">Ver Perfil</a>
	                    <a id="dropdown-2" href="/Tarea2Dynamic/CerrarSesion">Cerrar Sesion</a>
	                </div>
	            </div>
	        </div>
			
			<% }else{ %>
			
	        <div style="display:flex; align-items: center; gap: 5px;">
	            <h3 id="user-name"></h3>
	            <div class="dropdown">
	                <img src="media/icons/avatar.svg" class="avatar icon">
	                <div class="dropdown-content">
	                    <a id="dropdown-1" href="/Tarea2Dynamic/IniciarSesion">Iniciar Sesion</a>
	                    <a id="dropdown-2" href="/Tarea2Dynamic/AltaUsuario">Registrarse</a>
	                </div>
	            </div>
	        </div>
	        
	        <% } %>
        <% } %>
    </div>
</div>