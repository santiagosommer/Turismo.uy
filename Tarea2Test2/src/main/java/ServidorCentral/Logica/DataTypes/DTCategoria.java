package ServidorCentral.Logica.DataTypes;

import java.util.Map;

public class DTCategoria {
	private String Nombre;
	private Map<String, DTActividadTuristica> ActividadesTuristicas;
	private Map<String, DTPaquete> Paquetes;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public Map<String, DTActividadTuristica> getActividadesTuristicas() {
		return ActividadesTuristicas;
	}
	public void setActividadesTuristicas(Map<String, DTActividadTuristica> actividadesTuristicas) {
		ActividadesTuristicas = actividadesTuristicas;
	}
	public Map<String, DTPaquete> getPaquetes() {
		return Paquetes;
	}
	public void setPaquetes(Map<String, DTPaquete> paquetes) {
		Paquetes = paquetes;
	}
	
	

}
