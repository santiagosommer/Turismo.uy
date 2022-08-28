package ServidorCentral.Logica.Controladores;

import java.time.LocalDate;
import java.util.HashMap;

import java.util.Map;
import java.util.Set;


import ServidorCentral.Logica.Clases.Paquete;
import ServidorCentral.Logica.Excepciones.NombrePaqueteRepetidoException;
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
			int periodoValidez,int Descuento, LocalDate fechaAlta) throws NombrePaqueteRepetidoException {
		if (Paquetes.containsKey(nombrePaque)) {
			throw new NombrePaqueteRepetidoException("Ya existe un paquete con nombre" + nombrePaque);
		}else {
			Paquete nuevo = new Paquete(nombrePaque,descripcion, periodoValidez,Descuento,fechaAlta);
			Paquetes.put(nombrePaque, nuevo);
		}
		
		
	}
	
	@Override
	public void seleccionarPaquete(String paquete) {
		if (existePaquete(paquete)) {
			PaqueteSeleccionado = Paquetes.get(paquete);
		}
		
	}
	
	@Override
	public boolean existePaquete(String paquete) {
		
		return Paquetes.containsKey(paquete);
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
