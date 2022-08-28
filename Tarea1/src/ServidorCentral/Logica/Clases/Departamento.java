package ServidorCentral.Logica.Clases;

import java.util.HashMap;
import java.util.Map;

public class Departamento {

	private String NombreDepartamento;
	private String Descripcion;
	private String URL;
	private Map<String, ActividadTuristica> ActividadesTuristicas;
	
	public Departamento(String nombre, String descripcion, String url) {
		NombreDepartamento = nombre;
		Descripcion = descripcion;
		URL = url;
		ActividadesTuristicas = new HashMap<String, ActividadTuristica>();
	}
	
	public String getNombre() {
		return NombreDepartamento;
	}
	public void setNombre(String nombre) {
		NombreDepartamento = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String url) {
		URL = url;
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
}
