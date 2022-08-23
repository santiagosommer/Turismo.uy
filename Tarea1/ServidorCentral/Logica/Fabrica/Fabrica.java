package interfaces;

import controladores.ControladorUsuario;

public class Fabrica {
		Fabrica(){}	
	    public IUsuario getControladorUsuario() {
	        return ControladorUsuario.getInstancia() ;
	    }	      
}
