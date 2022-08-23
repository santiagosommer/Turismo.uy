package ServidorCentral.Logica.Fabrica;

import ServidorCentral.Logica.Interfaces.IUsuario;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Controladores.ControladorPaquete;
import ServidorCentral.Logica.Controladores.ControladorUsuario;

public class Fabrica {
		Fabrica(){}	
	    public IUsuario getControladorUsuario() {
	        return (IUsuario) ControladorUsuario.getInstancia() ;
	    }	      
	    
	    public IPaquete getControladorPaquete() {
	    	return (IPaquete) ControladorPaquete.getInstancia();
	    }
}
