package ServidorCentral.Logica.Controladores;
import ServidorCentral.Logica.Clases.*;
import ServidorCentral.Logica.DataTypes.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import ServidorCentral.Logica.Interfaces.ITuristica;



public class ControladorTuristica implements ITuristica {
	
	private static ControladorTuristica instancia = null;
	
	private ActividadTuristica actividadSeleccionada;
	private SalidaTuristica salidaSeleccionada;
	private Departamento departamentoSeleccionado;
	
	private Map<String, ActividadTuristica> ActividadesTuristicas;
	private Map<String, Departamento> Departamentos;
	
	private ControladorTuristica() {
		
	}
	
	public static ControladorTuristica getInstancia() {
		if (instancia == null) {
			instancia = new ControladorTuristica();
		}
		return instancia;
	}
	
	public void seleccionarActividad(String actividad) {}
	public void seleccionarSalida(String salida) {}
	public void selecciionarDepartemento(String departemneto) {}
	public DTActividadTuristica getDTActividadTuristica() {
		return null;
	}
	public DTSalidaTuristica getDTSalidaTuristica() {
		return null;
	}
	public void crearActividadTuristica(String nombre, String descripcion, int duracion, float costoTurista, LocalDate fechaAlta, String ciudad, String departamento) {}
	public Set<String> listarDepartamentos(){
		return null;
	}
	public Set<String> listarActividadesDeDepartamento(String departemento){
		return null;
	}
	public Set<DTSalidaTuristica> datosSalidasVigentes(String actividad) {
		return null;
	}
	
	public void crearSalidaTuristica(String nombre,int cantMaxTuristas, LocalDate fechaAlta, DTInfoSalida infoSalida, int cuposDisponibles) {}
	public Set<String> listarSalidasActividad(){
		return null;
	}
	public Boolean existeActividad(String actividad) {
		return false;
	}
	public Boolean existeSalida(String salida) {
		return false;
	}
	public Boolean existeDepartamento(String departamento) {
		return false;
	}
	public void crearDepartamento(String nombre,String descripcion, String URL) {}
	}

	


	