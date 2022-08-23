package Controladores;

import java.util.Map;
import java.util.Set;

import Interfaces.IPaquete;

public class ControladorPaquete implements IPaquete {

	private Map<String, Paquete> Paquetes;
	private static ControladorPaquete instancia = null;
	
	public static ControladorPaquete getInstancia() {
		if (instancia == null) {
			instancia = new ControladorPaquete();
		}
		return instancia;
	}
	
	private ControladorPaquete() {
		Paquetes = new HashMap<String,Paquete>();
				
	}
	
	@Override
	public void crearPaquete(String nombrePaque, String descripcion, 
			int periodoValidez,int Descuento){
		
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

	
	
	
	
	
	
	
}
