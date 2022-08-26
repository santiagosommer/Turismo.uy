package ServidorCentral.Logica.Controladores;
import ServidorCentral.Logica.Clases.*;
import ServidorCentral.Logica.DataTypes.*;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import ServidorCentral.Logica.Interfaces.ITuristica;



public class ControladorTuristica implements ITuristica {
	
	//atributos
	
	private static ControladorTuristica instancia = null;
	
	private ActividadTuristica actividadSeleccionada;
	private SalidaTuristica salidaSeleccionada;
	private Departamento departamentoSeleccionado;
	
	private Map<String, ActividadTuristica> ActividadesTuristicas;
	private Map<String, Departamento> Departamentos;
	
	private ControladorTuristica() {
		setActividades(new HashMap<String,ActividadTuristica>());
		setDepartamentos(new HashMap<String,Departamento>());
		actividadSeleccionada = null;
		salidaSeleccionada = null;
		departamentoSeleccionado = null;
	}
	
	//operaciones
	
	private void setDepartamentos(HashMap<String, Departamento> hashMap) {
		// TODO Auto-generated method stub
		
	}

	private void setActividades(HashMap<String, ActividadTuristica> hashMap) {
		// TODO Auto-generated method stub
		
	}

	public static ControladorTuristica getInstancia() {
		if (instancia == null) {
			instancia = new ControladorTuristica();
		}
		return instancia;
	}
	
	public void seleccionarActividad(String actividad) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		ActividadTuristica actividadSelec = actividades.get(actividad);
		actividadSeleccionada = actividadSelec;
	}
	
	public void seleccionarSalida(String salida) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		for (Map.Entry<String, ActividadTuristica> entry : actividades.entrySet()) {
		    ActividadTuristica activ = entry.getValue();
		    Map<String, SalidaTuristica> salidasActiv = activ.getSalidas();
		    boolean existe = salidasActiv.containsKey(salida);
		    if (existe) {
		    	SalidaTuristica salidaSelec = salidasActiv.get(salida);
		    	salidaSeleccionada = salidaSelec;
		    } else {
		    	salidaSeleccionada = null;
		    }
		}		
		
	}
	
	public void seleccionarDepartemento(String departamento) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, Departamento> departamentos = crTuristica.Departamentos;
		Departamento departamentoSelec = departamentos.get(departamento);
		departamentoSeleccionado = departamentoSelec;
	}
	
	public DTActividadTuristica getDTActividadTuristica() {
		return null;
	}
	public DTSalidaTuristica getDTSalidaTuristica() {
		return null;
	}
	
	public void crearActividadTuristica(String nombre, String descripcion, int duracion, float costoTurista, LocalDate fechaAlta, String ciudad, String departamento) {}
	
	public void crearSalidaTuristica(String nombre,int cantMaxTuristas, LocalDate fechaAlta, DTInfoSalida infoSalida, int cuposDisponibles) throws NombreSalidaRepetidoException {
		
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		
		if (existeSalida(nombre,actividadSeleccionada.getNombre())){
			throw new NombreSalidaRepetidoException("La Salida con nombre" + nombre + "ya existe");
		}
		SalidaTuristica nuevaSalida = new SalidaTuristica(nombre, cantMaxTuristas, fechaAlta, infoSalida, cuposDisponibles);
		nuevaSalida.setActividadTuristicaAsociada(actividadSeleccionada);
		Map<String,SalidaTuristica> salidasDeActividad = actividadSeleccionada.getSalidas();
		salidasDeActividad.put(nombre,nuevaSalida);	
		actividadSeleccionada.setSalidas(salidasDeActividad);
	}

	
	public Set<String> listarDepartamentos(){
		
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, Departamento> departamentos = crTuristica.Departamentos;
		String nombreDep;
		Set<String> lista = new HashSet<String>();
				
		for (Iterator<Map.Entry<String, Departamento>> entries = departamentos.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Departamento> entry = entries.next();
		    nombreDep = entry.getKey();
		    lista.add(nombreDep);
		}
		return lista;
	}
	
	public Set<DTSalidaTuristica> datosSalidasVigentes(String actividad) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		boolean existe = actividades.containsKey(actividad);
		if (existe) {
			ActividadTuristica activ = actividades.get(actividad);
			Map<String, SalidaTuristica> salidas = activ.getSalidas();
			SalidaTuristica salida;
			Set<DTSalidaTuristica> dtSalidas = new HashSet<DTSalidaTuristica>();
						
			for (Map.Entry<String, SalidaTuristica> entry : salidas.entrySet()) {
				salida = entry.getValue();
				DTInfoSalida info = salida.getInfoSalida();
				LocalDate fechaSalida = info.getFecha();
				LocalDate fechaActual = LocalDate.now();
				if (fechaSalida.compareTo(fechaActual) > 0){
					DTSalidaTuristica dtSalida = new DTSalidaTuristica(salida.getNombre(),salida.getCantidadMaxTuristas(), salida.getFechaAlta(), info, salida.getCuposDisponibles(), null);
					dtSalidas.add(dtSalida);
				}
			}
			return dtSalidas;
		} else {
			return null;
		}
	}
	
	public Set<String> listarActividadesDeDepartamento(String departamento){
		
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, Departamento> departamentos = crTuristica.Departamentos;
		boolean existe = departamentos.containsKey(departamento);
		if (existe) {
			Departamento dep = departamentos.get(departamento);
			Map<String, ActividadTuristica> actividades = dep.getActividadesTuristicas();
			
			String nombreActividad;
			Set<String> lista = new HashSet<String>();			
			for (Map.Entry<String, ActividadTuristica> entry : actividades.entrySet()) {
			    nombreActividad = entry.getKey();
			    lista.add(nombreActividad);
			}
			return lista;
			
		} else {
			return null;
			
		}
	}
	
	public Set<String> listarSalidasActividad(String actividad){
		
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		boolean existe = actividades.containsKey(actividad);
		if (existe) {
			ActividadTuristica activ = actividades.get(actividad);
			Map<String, SalidaTuristica> salidas = activ.getSalidas();
			
			String nombreSalida;
			Set<String> lista = new HashSet<String>();			
			for (Map.Entry<String, SalidaTuristica> entry : salidas.entrySet()) {	
				nombreSalida = entry.getKey();
			    lista.add(nombreSalida);
			}
			return lista;
			
		} else {
			return null;	
		}
	
	}

	public Boolean existeActividad(String actividad) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		Boolean existe = actividades.containsKey(actividad);
		return existe;
	}
	
	public Boolean existeSalida(String salida, String actividad) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		ActividadTuristica activ = actividades.get(actividad);
		Map<String, SalidaTuristica> salidas = activ.getSalidas();	
		Boolean existe = salidas.containsKey(salida);
		return existe;
	}
	
	public Boolean existeDepartamento(String departamento) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, Departamento> departamentos = crTuristica.Departamentos;
		Boolean existe = departamentos.containsKey(departamento);
		return existe;
	}
	
	public void crearDepartamento(String nombre,String descripcion, String URL) {}

	@Override
	public Boolean existeSalida(String salida) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


	