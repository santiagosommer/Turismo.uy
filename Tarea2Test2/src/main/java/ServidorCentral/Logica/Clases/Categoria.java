package ServidorCentral.Logica.Clases;
import java.util.HashMap;
import java.util.Map;

public class Categoria {

	private String Nombre;
	private Map<String, ActividadTuristica> ActividadesTuristicas;
	private Map<String, Paquete> Paquetes;

	
	public Categoria(String nombre){
		Nombre = nombre;
		ActividadesTuristicas = new HashMap<String, ActividadTuristica>();
		Paquetes = new HashMap<String, Paquete>();
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Map<String, ActividadTuristica> getActividadesTuristicas() {
		return ActividadesTuristicas;
	}

	public void setActividadesTuristicas(Map<String, ActividadTuristica> actividadesTuristicas) {
		ActividadesTuristicas = actividadesTuristicas;
	}
	
	public void addActividadTuristica(ActividadTuristica a ) {
		ActividadesTuristicas.put(a.getNombre(), a);
	}

	public Map<String, Paquete> getPaquetes() {
		return Paquetes;
	}

	public void setPaquetes(Map<String, Paquete> paquete) {
		Paquetes = paquete;
	}
	
	public void addPaquete(Paquete p ) {
		Paquetes.put( p.getNombre(), p);
	}
	
	
	
	
	

}
