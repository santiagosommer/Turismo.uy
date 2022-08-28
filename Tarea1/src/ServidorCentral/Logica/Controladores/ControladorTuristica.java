package ServidorCentral.Logica.Controladores;
import ServidorCentral.Logica.Clases.*;
import ServidorCentral.Logica.DataTypes.*;
import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;



public class ControladorTuristica implements ITuristica {
	
	//atributos
	
	private static ControladorTuristica instancia = null;
	
	private ActividadTuristica actividadSeleccionada;
	private SalidaTuristica salidaSeleccionada;
	private Departamento departamentoSeleccionado;
	
	private Map<String, ActividadTuristica> ActividadesTuristicas;
	private Map<String, Departamento> Departamentos;
	
	private ControladorTuristica() {
		Departamentos = new HashMap<String,Departamento>();
		ActividadesTuristicas = new HashMap<String,ActividadTuristica>();
		actividadSeleccionada = null;
		salidaSeleccionada = null;
		departamentoSeleccionado = null;
	}
	
	//operaciones
	
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
	
	public void seleccionarDepartamento(String departamento) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, Departamento> departamentos = crTuristica.Departamentos;
		Departamento departamentoSelec = departamentos.get(departamento);
		departamentoSeleccionado = departamentoSelec;
	}
	
	public DTDepartamento getDTDepartamento() {
		if (departamentoSeleccionado==null) {
			return null;
		}
		else {
		return new DTDepartamento(departamentoSeleccionado.getNombre(),departamentoSeleccionado.getDescripcion(),departamentoSeleccionado.getURL());
		}
	}
	
	public DTActividadTuristica getDTActividadTuristica() {
		
		if (actividadSeleccionada!= null) {
		seleccionarDepartamento(actividadSeleccionada.getInfoDepartamento().getNombre());
		DTDepartamento dtdep = getDTDepartamento();
		
		Fabrica fabrica = Fabrica.getInstance(); 
		IUsuario controladorUsr = fabrica.getControladorUsuario();
		controladorUsr.seleccionarProveedor(actividadSeleccionada.getProveedor().getNickname()); // por nickname o por email?
		DTProveedor dtprov = controladorUsr.getDTProveedor();			
		return new DTActividadTuristica(actividadSeleccionada.getNombre(),actividadSeleccionada.getDescripcion(),actividadSeleccionada.getDuracion(),
				actividadSeleccionada.getCostoTurista(),actividadSeleccionada.getFechaAlta(),dtdep,dtprov,actividadSeleccionada.getCiudad());
		} else {
			return null;
		}
		
	
	}
	
	public DTSalidaTuristica getDTSalidaTuristica() {
		
		if (actividadSeleccionada!= null) {
		seleccionarActividad(salidaSeleccionada.getActividadTuristicaAsociada().getNombre());
		DTActividadTuristica act = getDTActividadTuristica();
		return  new DTSalidaTuristica(salidaSeleccionada.getNombre(),
				salidaSeleccionada.getCantidadMaxTuristas(),salidaSeleccionada.getFechaAlta(),
				salidaSeleccionada.getInfoSalida(),salidaSeleccionada.getCuposDisponibles(),act);
		}else {
			return null;
		}
	}
	
	public void crearActividadTuristica(String nombre, String descripcion, int duracion, float costoTurista, LocalDate fechaAlta, String ciudad, String departamento,Proveedor proveedor) throws NombreActividadRepetidoException {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		seleccionarDepartamento(departamento);
		Departamento dep = departamentoSeleccionado;
		if (existeActividad(nombre)){
			throw new NombreActividadRepetidoException("La Actividad con nombre" + nombre + "ya existe");
		}
		ActividadTuristica nuevaActividad = new ActividadTuristica(nombre, descripcion, duracion, costoTurista, fechaAlta, dep, ciudad, proveedor);
		actividades.put(nombre, nuevaActividad);
		Map<String, ActividadTuristica> actividadesDeProveedor = proveedor.getActividadesTuristicas();
		actividadesDeProveedor.put(nombre, nuevaActividad);
		proveedor.setActividadesTuristicas(actividadesDeProveedor);
		Map<String, ActividadTuristica> actividadesDeDepartamento = dep.getActividadesTuristicas(); 
		actividadesDeDepartamento.put(nombre, nuevaActividad);
		dep.setActividadesTuristicas(actividadesDeDepartamento);
	}
	
	public void crearSalidaTuristica(String nombre,int cantMaxTuristas, LocalDate fechaAlta, DTInfoSalida infoSalida, int cuposDisponibles, String actividad) throws NombreSalidaRepetidoException, NoHayActividadConEseNombreException {
		
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		seleccionarActividad(actividad);
		ActividadTuristica activ = actividadSeleccionada;
		if (actividadSeleccionada == null) {
			throw new NoHayActividadConEseNombreException("No hay una Actividad Turistica con nombre" + actividad);
		}
		if (existeSalida(nombre)){
			throw new NombreSalidaRepetidoException("La Salida con nombre" + nombre + "ya existe");
		}
		SalidaTuristica nuevaSalida = new SalidaTuristica(nombre, cantMaxTuristas, fechaAlta, infoSalida, cuposDisponibles);
		nuevaSalida.setActividadTuristicaAsociada(activ);
		//falla test porq hay que crear Actividad primero
		Map<String,SalidaTuristica> salidasDeActividad = activ.getSalidas();
		salidasDeActividad.put(nombre,nuevaSalida);	
		activ.setSalidas(salidasDeActividad);
	}
	
	public Set<String> listarDepartamentos(){
		
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
				
		String nombreDep;
		Set<String> lista = new HashSet<String>();
		
		if ( !crTuristica.Departamentos.isEmpty()) {

		for (Iterator<Map.Entry<String, Departamento>> entries = crTuristica.Departamentos.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Departamento> entry = entries.next();
		    nombreDep = entry.getKey();
		    lista.add(nombreDep);
		}
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
	
	/*public Boolean existeSalida(String salida, String actividad) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		ActividadTuristica activ = actividades.get(actividad);
		Map<String, SalidaTuristica> salidas = activ.getSalidas();	
		Boolean existe = salidas.containsKey(salida);
		return existe;
	}*/
	
	public Boolean existeDepartamento(String departamento) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, Departamento> departamentos = crTuristica.Departamentos;
		Boolean existe = departamentos.containsKey(departamento);
		return existe;
	}
	
	public void crearDepartamento(String nombre,String descripcion, String URL) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		if (!existeDepartamento(nombre)) {
			Departamento dep = new Departamento(nombre,descripcion,URL);
			crTuristica.Departamentos.put(nombre, dep);
		}
	}

	@Override
	public Boolean existeSalida(String salida) {
		// TODO Auto-generated method stub
		
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		for (Map.Entry<String, ActividadTuristica> entry : actividades.entrySet()) {
		    ActividadTuristica activ = entry.getValue();
		    Map<String, SalidaTuristica> salidasActiv = activ.getSalidas();
		    boolean existe = salidasActiv.containsKey(salida);
		    if (existe) {
		    	return existe;
		    }	    
		}
		return false;
		
		
	}

	@Override
	public ActividadTuristica getActividadSeleccionada() {
		// TODO Auto-generated method stub
		return actividadSeleccionada;
	}

	@Override
	public SalidaTuristica getSalidaSeleccionada() {
		// TODO Auto-generated method stub
		return salidaSeleccionada;
	}
	
}



	