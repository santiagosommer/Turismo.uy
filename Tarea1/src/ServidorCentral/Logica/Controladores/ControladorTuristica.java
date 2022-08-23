package ServidorCentral.Logica.Controladores;

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
	public DTActividadTuristica getDTActividadTuristica() {}
	public DTSalidaTuristica getDTSalidaTuristica() {}
	public void crearActividadTuristica(String nombre, String descripcion, int duracion, float costoTurista, DTFecha fechaAlta, String ciudad, String departamento) {}
	public Set<String> listarDepartamentos(){}
	public Set<String> listarActividadesDeDepartamento(String departemento){}
	public Set<DTSalidaTuristica> datosSalidasVigentes(String actividad) {}
	public void crearSalidaTuristica(String nombre,int cantMaxTuristas, DTFecha fechaAlta, DTInfoSalida infoSalida, int cuposDisponibles) {}
	public Set<String> listarSalidasActividad(){}
	public Boolean existeActividad(String actividad) {}
	public Boolean existeSalida(String salida) {}
	public Boolean existeDepartamento(String departamento) {}
	public void crearDepartamento(String nombre,String descripcion, String URL) {}
	