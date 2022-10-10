<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<div class="top-bar">
      <div class="top-bar-left">
          <img src="media/icons/bus.svg" class="bus-icon">
          <div class="top-bar-links">
              <a href="#" class="links selected">Principal</a>
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
          <a href="./consultaUsuarioIndex.html"><img src="media/icons/group.svg" class="larger-icon"></a>
          <div id="menu-proveedor" class="dropdown" style="display: none;">
            <h5 class="menu-proveedor-dropdown">Menu Proveedor</h5>
            <div class="dropdown-content">
                <a href="#">Alta de Actividad Turistica</a>
                <a href="#">Alta de Salida Turistica</a>
            </div>
        </div>
        <div style="display:flex; align-items: center; gap: 5px;">
            <h3 id="user-name"></h3>
            <div class="dropdown">
                <img src="media/icons/avatar.svg" class="avatar icon">
                <div class="dropdown-content">
                    <a id="dropdown-1" href="#">Iniciar Sesion</a>
                    <a id="dropdown-2" href="#">Registrarse</a>
                </div>
            </div>
        </div>
    </div>
</div>