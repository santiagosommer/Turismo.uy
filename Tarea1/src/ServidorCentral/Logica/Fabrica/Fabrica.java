package ServidorCentral.Logica.Fabrica;

import ServidorCentral.Logica.Interfaces.IUsuario;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Controladores.ControladorPaquete;
import ServidorCentral.Logica.Controladores.ControladorUsuario;
import ServidorCentral.Logica.Controladores.ControladorTuristica;

public class Fabrica {
		public Fabrica(){}	
	    public IUsuario getControladorUsuario() {
	        return (IUsuario) ControladorUsuario.getInstancia() ;
	    }	      
	    
	    public IPaquete getControladorPaquete() {
	    	return (IPaquete) ControladorPaquete.getInstancia();
	    }
	    
	    public ITuristica getControladorTuristica() {
	    	return (ITuristica) ControladorTuristica.getInstancia();
	    }
}
