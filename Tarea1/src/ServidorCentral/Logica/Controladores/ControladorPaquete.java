package ServidorCentral.Logica.Controladores;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;


import ServidorCentral.Logica.Clases.Paquete;
import ServidorCentral.Logica.Interfaces.IPaquete;

public class ControladorPaquete implements IPaquete {
    private Paquete PaqueteSeleccionado;
	private Map<String, Paquete> Paquetes;
	private static ControladorPaquete instancia = null;
	
	public static ControladorPaquete getInstancia() {
		if (instancia == null) {
			instancia = new ControladorPaquete();
		}
		return instancia;
	}
	
	private ControladorPaquete() {
		setPaquetes(new HashMap<String,Paquete>());
		PaqueteSeleccionado = null;
				
	}
	
	@Override
	public void crearPaquete(String nombrePaque, String descripcion, 
			int periodoValidez,int Descuento) {
		
	}
	
	@Override
	public void seleccionarPaquete(String paquete) {
		
		
	}
	
	@Override
	public boolean existePaquete(String paquete) {
		
		return true;
	}
	
	@Override
	public Set<String> listarPaquetes() {
		
		return null;
		
	}
	
	
	@Override
	public Set<String>  listarActividadesAAgregar() {
		
		return null;
		
		
	}

	public Map<String, Paquete> getPaquetes() {
		return Paquetes;
	}

	public void setPaquetes(Map<String, Paquete> paquetes) {
		Paquetes = paquetes;
	}

	
	public Paquete getPaqueteSeleccionado() {
		return PaqueteSeleccionado;
	}

	public void setPaqueteSeleccionado(Paquete paqueteSeleccionado) {
		PaqueteSeleccionado = paqueteSeleccionado;
	}

	
	
	
	
	
	
	
}
