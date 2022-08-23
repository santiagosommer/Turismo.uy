package ServidorCentral.Logica.Interfaces;
import java.util.Set;

import datatypes.DTFecha;
import datatypes.DTSalidaTuristica;
import datatypes.DTActividadTuristica;

public interface ITuristica {
	
	public abstract void seleccionarActividad(String actividad) {}
	public abstract void seleccionarSalida(String salida) {}
	public abstract void selecciionarDepartemento(String departemneto) {}
	public abstract DTActividadTuristica getDTActividadTuristica() {}
	public abstract DTSalidaTuristica getDTSalidaTuristica() {}
	public abstract void crearActividadTuristica(String nombre, String descripcion, int duracion, float costoTurista, DTFecha fechaAlta, String ciudad, String departamento) {}
	public abstract Set<String> listarDepartamentos(){}
	public abstract Set<String> listarActividadesDeDepartamento(String departemento){}
	public abstract Set<DTSalidaTuristica> datosSalidasVigentes(String actividad) {}
	public abstract void crearSalidaTuristica(String nombre,int cantMaxTuristas, DTFecha fechaAlta, DTInfoSalida infoSalida, int cuposDisponibles) {}
	public abstract Set<String> listarSalidasActividad(){}
	public abstract Boolean existeActividad(String actividad) {}
	public abstract Boolean existeSalida(String salida) {}
	public abstract Boolean existeDepartamento(String departamento) {}
	public abstract void crearDepartamento(String nombre,String descripcion, String URL) {}
	

}
