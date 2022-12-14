package ServidorCentral.Logica.Controladores;
import ServidorCentral.Logica.Clases.*;
import ServidorCentral.Logica.DataTypes.*;
import ServidorCentral.Logica.Excepciones.*;
import ServidorCentral.Logica.Fabrica.Fabrica;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Date;
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
	private Categoria categoriaSeleccionada;
	private Map<String, ActividadTuristica> ActividadesTuristicas;
	private Map<String, Departamento> Departamentos;
	private Map<String,Categoria> Categorias;
	
	private ControladorTuristica() {
		Departamentos = new HashMap<String,Departamento>();
		ActividadesTuristicas = new HashMap<String,ActividadTuristica>();	
		Categorias = new HashMap<String, Categoria>();
		actividadSeleccionada = null;
		salidaSeleccionada = null;
		departamentoSeleccionado = null;
		categoriaSeleccionada = null;
		
	}
	
	public  void finalizarActividadTuristica(String nombreActividad) {
		ActividadTuristica act =  ActividadesTuristicas.get(nombreActividad);
		act.setEstado(EstadoActividad.Finalizada);
		ActividadesTuristicas.remove(nombreActividad);
		ActividadesTuristicas.put(nombreActividad, act);
		
	}
	
	public void reset() {
		Departamentos = new HashMap<String,Departamento>();
		ActividadesTuristicas = new HashMap<String,ActividadTuristica>();	
		Categorias = new HashMap<String, Categoria>();
		actividadSeleccionada = null;
		salidaSeleccionada = null;
		departamentoSeleccionado = null;
		categoriaSeleccionada = null;
	}
	
	//operaciones
	
	//nuevas:
	
	@Override
	public Set<DTActividadTuristica> listarActividadesDeptoYCate(String depto,String cat){
		Set<DTActividadTuristica> res = new HashSet<DTActividadTuristica>();
		if (depto.contentEquals("") || cat.contentEquals("") || (depto.contentEquals("Departamento") && cat.contentEquals("Categoria"))) {
			for (String key : ActividadesTuristicas.keySet()) {
				res.add(new DTActividadTuristica(ActividadesTuristicas.get(key)));
			}
			return res;
		}
		if (cat.contentEquals("Categoria")) {
			for (String key : ActividadesTuristicas.keySet()) {
				ActividadTuristica act = ActividadesTuristicas.get(key);
				if (depto.contentEquals(act.getInfoDepartamento().getNombre()) && act.getEstado() == EstadoActividad.Confirmada) {
					res.add(new DTActividadTuristica(act));
				}
			}
			return res;
		}
		if (depto.contentEquals("Departamento")) {
			for (String key : ActividadesTuristicas.keySet()) {
				ActividadTuristica act = ActividadesTuristicas.get(key);
				if (act.tieneCat(cat) && act.getEstado() == EstadoActividad.Confirmada) {
					res.add(new DTActividadTuristica(act));
				}
			}
			return res;
		}
		
		for (String key : ActividadesTuristicas.keySet()) {
			ActividadTuristica act = ActividadesTuristicas.get(key);
			if (act.tieneCat(cat) && depto.contentEquals(act.getInfoDepartamento().getNombre()) && act.getEstado() == EstadoActividad.Confirmada) {
				res.add(new DTActividadTuristica(act));
			}
		}
		
		return res;
		
	}
	
	@Override
	public Boolean existeInscripcion(String salida, String nombreTurista) {
		seleccionarSalida(salida);
		ArrayList<Inscripcion> inscripciones = salidaSeleccionada.getInscripcionesAsociadas();
		for (int i=0;i<inscripciones.size();i++) {
			if (inscripciones.get(i).getTurista().getNickname() == nombreTurista) {
			  return true;
		  }
		      
		 }
		return false;
	}
	
	public void crearCategoria(String nombre) throws CategoriaRepetidaException {
		
		if (existeCategoria(nombre)){
			throw new CategoriaRepetidaException("La Categoria con nombre " + nombre + " ya existe");
		} else {
			Categoria nueva = new Categoria(nombre);
			Categorias.put(nombre, nueva);
		}
	
		
		
		
	}
	
	public Boolean existeCategoria(String nombre) {
		Boolean existe = Categorias.containsKey(nombre);
		return existe;

	}
	
	public Set<String> listarCategorias(){
		
		String nombreCat;
		Set<String> lista = new HashSet<String>();
		

		for (Iterator<Map.Entry<String, Categoria>> entries = Categorias.entrySet().iterator(); entries.hasNext(); ) {
		    Map.Entry<String, Categoria> entry = entries.next();
		    nombreCat = entry.getKey();
		    lista.add(nombreCat);
		}
	
		return lista;
		
	}
	
	public Set<String> listarCategoriasActividad(String actividad){
		
		Set<String> lista = new HashSet<String>();
		
		boolean existe = ActividadesTuristicas.containsKey(actividad);
		if (existe) {
			ActividadTuristica activ = ActividadesTuristicas.get(actividad);
			Map<String, Categoria> categorias = activ.getCategorias();
			
			String nombreCategoria;	
			for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {	
				nombreCategoria = entry.getKey();
			    lista.add(nombreCategoria);
			}
			
		} 
		return lista;
	}
	
	
	public static ControladorTuristica getInstancia() {
		if (instancia == null) {
			instancia = new ControladorTuristica();
		}
		return instancia;
	}
	
	public void limpiarDepartamentos(){
		Departamentos.clear();
	}
	
	
	
	
	
	public void seleccionarActividad(String actividad) {
		//ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = instancia.ActividadesTuristicas;
		ActividadTuristica actividadSelec = actividades.get(actividad);
		actividadSeleccionada = actividadSelec;
	}
	
	public void seleccionarSalida(String salida) {
		//ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = instancia.ActividadesTuristicas;
		for (Map.Entry<String, ActividadTuristica> entry : actividades.entrySet()) {
		    ActividadTuristica activ = entry.getValue();
		    Map<String, SalidaTuristica> salidasActiv = activ.getSalidas();
		    boolean existe = salidasActiv.containsKey(salida);
		    if (existe) {
		    	SalidaTuristica salidaSelec = salidasActiv.get(salida);
		    	salidaSeleccionada = salidaSelec;
		    	return;
		    } else {
		    	salidaSeleccionada = null;
		    }
		}		
		
	}
	
	public void seleccionarDepartamento(String departamento) {
		//ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, Departamento> departamentos = instancia.Departamentos;
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
			return new DTActividadTuristica(actividadSeleccionada);
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
		} else {
			return null;
		}
	}
	
	public ArrayList<DTInscripcion> getDTInscripcionesDeSalida(){
		ArrayList<Inscripcion> inscripciones = salidaSeleccionada.getInscripcionesAsociadas();
		ArrayList<DTInscripcion> inscripcionesDT = new ArrayList<>();
			
		for (Inscripcion inscripcion : inscripciones) {
			
			DTTurista turistaAutor = new DTTurista(inscripcion.getTurista().getNickname(), inscripcion.getTurista().getNombre(), inscripcion.getTurista().getApellido(), inscripcion.getTurista().getEmail(), inscripcion.getTurista().getFechaNacimiento(),inscripcion.getTurista().getContrase??a(), inscripcion.getTurista().getNacionalidad());
			inscripcionesDT.add(new DTInscripcion(inscripcion.getFecha(), inscripcion.getCantidadTuristas(), inscripcion.getCosto(), turistaAutor, getDTSalidaTuristica()));
		}
		return inscripcionesDT;
	}


	public void crearActividadTuristica(String nombre, String descripcion, int duracion, float costoTurista, LocalDate fechaAlta, String ciudad, String departamento,String proveedorNick, Set<String> categorias) throws NombreActividadRepetidoException {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Map<String, ActividadTuristica> actividades = crTuristica.ActividadesTuristicas;
		seleccionarDepartamento(departamento);
		Departamento dep = departamentoSeleccionado;
		if (existeActividad(nombre)){
			throw new NombreActividadRepetidoException("La Actividad con nombre " + nombre + " ya existe");
		}
		ControladorUsuario crUsuario = ControladorUsuario.getInstancia();
		Map<String,Proveedor> provsMap = crUsuario.getProveedores();
		Proveedor proveedor = provsMap.get(proveedorNick);
		
		Map<String, Categoria> categoriasMap = new HashMap<String, Categoria>();
		
		Iterator<String> itr = categorias.iterator();
		
		while(itr.hasNext()) {
			String cat = itr.next();
			categoriasMap.put(cat, Categorias.get(cat));
		}
		
		ActividadTuristica nuevaActividad = new ActividadTuristica(nombre, descripcion, duracion, costoTurista, fechaAlta, dep, ciudad, proveedor, categoriasMap);
		actividades.put(nombre, nuevaActividad);
		Map<String, ActividadTuristica> actividadesDeProveedor = proveedor.getActividadesTuristicas();
		actividadesDeProveedor.put(nombre, nuevaActividad);
		proveedor.setActividadesTuristicas(actividadesDeProveedor);
		Map<String, ActividadTuristica> actividadesDeDepartamento = dep.getActividadesTuristicas(); 
		actividadesDeDepartamento.put(nombre, nuevaActividad);
		dep.setActividadesTuristicas(actividadesDeDepartamento);
		itr = categorias.iterator();
		while(itr.hasNext()) {
			Categorias.get(itr.next()).getActividadesTuristicas().put(nombre, nuevaActividad);
		}
		
	}
	
	public void crearSalidaTuristica(String nombre,int cantMaxTuristas, LocalDate fechaAlta, DTInfoSalida infoSalida, String actividad) throws NombreSalidaRepetidoException, NoHayActividadConEseNombreException {
		
		seleccionarActividad(actividad);
		ActividadTuristica activ = actividadSeleccionada;
		if (activ == null) {
			throw new NoHayActividadConEseNombreException("No hay una Actividad Turistica con nombre " + actividad);
		}
		if (existeSalida(nombre)){
			throw new NombreSalidaRepetidoException("La Salida con nombre " + nombre + " ya existe");
		}
		SalidaTuristica nuevaSalida = new SalidaTuristica(nombre, cantMaxTuristas, fechaAlta, infoSalida);
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
		

		for (Iterator<Map.Entry<String, Departamento>> entries = crTuristica.Departamentos.entrySet().iterator(); entries.hasNext(); ) {
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
				Date input = info.getFecha().getTime();
				LocalDate fechaSalida = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate fechaActual = LocalDate.now();
				if (fechaSalida.compareTo(fechaActual) > 0) {
					DTSalidaTuristica dtSalida = new DTSalidaTuristica(salida.getNombre(),salida.getCantidadMaxTuristas(), salida.getFechaAlta(), info, salida.getCuposDisponibles(),null);		//cambiar a actividad asociada?
					dtSalidas.add(dtSalida);
				}
			
		   }
				
			
			return dtSalidas;}
		
	  else {
			return null;
		}
	}
	
	public Set<String> listarActividadesDeDepartamento(String departamento){
		//(Confirmadas)
		
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
			    if(entry.getValue().getEstado() == EstadoActividad.Confirmada) { //nuevo
			    	lista.add(nombreActividad);
			    }
			    
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

	
	public Boolean existeDepartamento(String departamento) {
		return Departamentos.containsKey(departamento);
	}
	
	
	public void crearDepartamento(String nombre,String descripcion, String URL) {
		if (!existeDepartamento(nombre)) {
			Departamento dep = new Departamento(nombre,descripcion,URL);
			Departamentos.put(nombre, dep);
		}
	}

	@Override
	public Boolean existeSalida(String salida) {
		
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
		return actividadSeleccionada;
	}

	@Override
	public SalidaTuristica getSalidaSeleccionada() {
		return salidaSeleccionada;
	}


	public Categoria getCategoriaSeleccionada() {
		return categoriaSeleccionada;
	}


	public void setCategoriaSeleccionada(Categoria categoriaSeleccionada) {
		this.categoriaSeleccionada = categoriaSeleccionada;
	}


	@Override
	public Set<String> listarActividadesAgregadas() {
		Set<String> lista = new HashSet<String>();
		
		Map<String, ActividadTuristica> actividades = ActividadesTuristicas;
		for (Map.Entry<String, ActividadTuristica> entry : actividades.entrySet()) {
		   if (entry.getValue().getEstado() == EstadoActividad.Agregada) {
			   lista.add(entry.getKey());
			   
		   }
		}
		return lista;
	}


	@Override
	public void AceptarActividad(String actividad) {
		ActividadTuristica act = ActividadesTuristicas.get(actividad);
		act.setEstado(EstadoActividad.Confirmada);
		
	}


	@Override
	public void RechazarActividad(String actividad) {
		ActividadTuristica act = ActividadesTuristicas.get(actividad);
		act.setEstado(EstadoActividad.Rechazada);
		
	}
	
	@Override
	public Set<DTPaquete> listarPaquetesCategoria(String cat) {
		
		Set<DTPaquete> lista = new HashSet<DTPaquete>();
		if (cat!=null && !cat.contentEquals("") && !cat.contentEquals("Categorias")) {
			Categoria categoria = Categorias.get(cat);
			for (Map.Entry<String, Paquete> entry : categoria.getPaquetes().entrySet()) {
				   lista.add(new DTPaquete(entry.getValue()));
			}
			return lista;
		} else {
			return Fabrica.getInstance().getControladorPaquete().infoPaquetes();
					
		}
		
	}
	
}



	