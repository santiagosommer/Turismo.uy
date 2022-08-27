package ServidorCentral.Logica.Controladores;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Excepciones.YaExisteInscripcionTuristaSalida;
import ServidorCentral.Logica.Fabrica.Fabrica;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import ServidorCentral.Logica.Clases.Turista;
import ServidorCentral.Logica.DataTypes.DTProveedor;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Inscripcion;
import ServidorCentral.Logica.Clases.Proveedor;
import ServidorCentral.Logica.Clases.SalidaTuristica;


public class ControladorUsuario implements IUsuario {
	
	private Map<String, Turista> Turistas;
	private Map<String, Proveedor> Proveedores;
	private Proveedor proveedorSeleccionado; 
	private Turista turistaSeleccionado;
	
	private static ControladorUsuario instancia = null;
	
	private ControladorUsuario() {
		setTuristas(new HashMap<String,Turista >());
		setProveedores(new HashMap<String,Proveedor >());
		proveedorSeleccionado = null;
		turistaSeleccionado = null;
		
	}
	public static ControladorUsuario getInstancia() {
		if (instancia == null) {
			instancia = new ControladorUsuario();
		}
		return instancia;
	}
	@Override
	public Boolean esTurista(String nickname) {
		return Turistas.containsKey(nickname);
	}
	@Override
	public void seleccionarTurista(String Turista) {
		turistaSeleccionado = Turistas.get(Turista);
		
	}
	@Override
	public void seleccionarProveedor(String Proveedor) {
		proveedorSeleccionado = Proveedores.get(Proveedor);
		
	}
	@Override
	public Set<String> listarUsuarios() {
		Set<String> res = new HashSet<String> ();
		Turistas.forEach((k,v)->res.add(v.toString()));
		Proveedores.forEach((k,v)->res.add(v.toString()));
		return res;
	}
	@Override
	public Set<String> listarProveedores() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DTTurista getDTTurista() {
		if (turistaSeleccionado!= null) {
		  return new DTTurista(turistaSeleccionado.getNickname(),turistaSeleccionado.getNombre(), turistaSeleccionado.getApellido(), turistaSeleccionado.getEmail(),turistaSeleccionado.getFechaNacimiento(), turistaSeleccionado.getNacionalidad());
		}else {
		  return null;
	}
	}
	@Override
	public DTProveedor getDTProveedor() {
		if (proveedorSeleccionado!=null) {
		  return new DTProveedor(proveedorSeleccionado.getNickname(), proveedorSeleccionado.getNombre(), proveedorSeleccionado.getApellido(),proveedorSeleccionado.getEmail(),proveedorSeleccionado.getFechaNacimiento() , proveedorSeleccionado.getDescripcionGeneral() , proveedorSeleccionado.getURL());
		} else {
		  return null;
	}
	}
	@Override
	public void modificarDatosTurista(String nombre, String apellido, LocalDate fechaNac, String nacionalidad) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void modificarDatosProveedor(String nombre, String apellido, LocalDate fechaNac, String desc, String url) {
		// TODO Auto-generated method stub
		
	}
	@Override
	
	public void crearInscripcion(String nombre, int cantidadTuristas, LocalDate fechaAlta,DTInfoSalida infoSalida,int CuposDisponibles) throws YaExisteInscripcionTuristaSalida {
		// TODO Auto-generated method stub
		Fabrica fabrica = Fabrica.getInstance();
		ITuristica ctrl = fabrica.getControladorTuristica();
		ActividadTuristica act = ctrl.getActividadSeleccionada();
		SalidaTuristica sal = ctrl.getSalidaSeleccionada();
		Turista turi = turistaSeleccionado;
		
		//comprobar que turista no tiene una inscripcion a esa Salida
		ArrayList<Inscripcion> inscripciones = turi.getInscripciones();
		boolean tieneInsc = false;
		if (!inscripciones.isEmpty()) {
			Iterator it = inscripciones.iterator();
			while (it.hasNext() && !tieneInsc) {
				Inscripcion j = (Inscripcion) it.next();
				if (j.getSalidaAsociada().getNombre() == sal.getNombre()) {
					tieneInsc = true;
				}	
			}	
		}
		
		if(tieneInsc) {
		
	    throw new YaExisteInscripcionTuristaSalida("El turista ya tiene una inscripcion a la salida de nombre" + sal.getNombre());
			
			
		} else {
		
		  if (CuposDisponibles>= cantidadTuristas && sal!=null && act!=null && turi!= null) {
	           //: calcular costo:
	          float costo = cantidadTuristas * act.getCostoTurista();
	          sal.setCuposDisponibles(CuposDisponibles - cantidadTuristas); //actualizo cupos disponibles
	          Inscripcion ins = new Inscripcion(fechaAlta, cantidadTuristas,costo,sal);
	         //agregar a inscripciones de turista
	          turi.agregarInscripcion(ins);   
		   } else {}
		  }
		
	
		
	}
	@Override
	public Boolean existeUsuario(String nickN) {
		return Proveedores.containsKey(nickN) || Turistas.containsKey(nickN);
	}
	@Override
	public void altaProveedor(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String descripcionGeneral, String url) throws UsuarioRepetidoException {
		if(existeUsuario(nickname)) {
			// exception here
			throw new UsuarioRepetidoException("El usuario " + nickname + " ya esta registrado");
		}
		Proveedor p = new Proveedor(nickname, nombre, apellido, email, fechaNacimiento, descripcionGeneral, url);
		Proveedores.put(nickname,p);
	}
	@Override
	public void altaTurista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String nacionalidad) throws UsuarioRepetidoException {
		if(existeUsuario(nickname)) {
			// exception here
			throw new UsuarioRepetidoException("El usuario " + nickname + " ya esta registrado");
		}
		Turista t = new Turista(nickname, nombre, apellido, email, fechaNacimiento, nacionalidad);
		Turistas.put(nickname,t);
	}
	
	
	// 
	public Map<String, Turista> getTuristas() {
		return Turistas;
	}
	public void setTuristas(Map<String, Turista> turistas) {
		Turistas = turistas;
	}
	public Map<String, Proveedor> getProveedores() {
		return Proveedores;
	}
	public void setProveedores(Map<String, Proveedor> proveedores) {
		Proveedores = proveedores;
	}
	@Override
	public Set<String> listarTuristas() {
		
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
