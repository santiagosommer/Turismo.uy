package ServidorCentral.Logica.Controladores;

import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;
import ServidorCentral.Logica.Excepciones.UsuarioNoExisteException;
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
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.DataTypes.EstadoError;
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
		setTuristas(new HashMap<String, Turista>());
		setProveedores(new HashMap<String, Proveedor>());
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
	public String getNickname(String email) {
		for (Map.Entry<String, Turista> entry : Turistas.entrySet()) {
			if (email.equals(entry.getValue().getEmail()))
				return entry.getValue().getNickname();
		}
		for (Map.Entry<String, Proveedor> entry : Proveedores.entrySet()) {
			if (email.equals(entry.getValue().getEmail()))
				return entry.getValue().getNickname();
		}
		return null;
	}
	
	@Override
	public EstadoError iniciarSesion(String nick_or_email, String passw) {
		EstadoError nuevoEstado;
		
		if (existeUsuario(nick_or_email) || existeUsuarioEmail(nick_or_email)) {
    		if (existeUsuario(nick_or_email)) { // nick_or_email es nickname
    			if (esTurista(nick_or_email)) { // nick_or_email es de un turista
    				seleccionarTurista(nick_or_email);
    				if (turistaSeleccionado.getContrasenia().equals(passw)) {
    					nuevoEstado = EstadoError.EXITO_TURISTA;
    				}else {
    					nuevoEstado = EstadoError.ERROR_CONTRA;
    				}
    			}else { // nick_or_email es de un proveedor
    				seleccionarProveedor(nick_or_email);
    				if (proveedorSeleccionado.getContrasenia().equals(passw)) {
    					nuevoEstado = EstadoError.EXITO_PROVEEDOR;
    				}else {
    					nuevoEstado = EstadoError.ERROR_CONTRA;
    					
    				}
    			}
    		}else { // nick_or_email es email
    			String nickname = getNickname(nick_or_email);
    			if (esTurista(nickname)) {
    				seleccionarTurista(nickname);
    				if (turistaSeleccionado.getContrasenia().equals(passw)) {
    					nuevoEstado = EstadoError.EXITO_TURISTA;
    				}else {
    					nuevoEstado = EstadoError.ERROR_CONTRA;
    				}
    			}else {
    				seleccionarProveedor(nickname);
    				if (proveedorSeleccionado.getContrasenia().equals(passw)) {
    					nuevoEstado = EstadoError.EXITO_PROVEEDOR;
    				}else {
    					nuevoEstado = EstadoError.ERROR_CONTRA;
    				}
    			}
    		}
    	}else {
    		nuevoEstado = EstadoError.ERROR_NICK_OR_EMAIL;
    	}
		
		return nuevoEstado;
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
	public Set<String> listarUsuarios() throws UsuarioNoExisteException {
		Set<String> res = new HashSet<String>();
		if (Turistas.isEmpty() && Proveedores.isEmpty())
			throw new UsuarioNoExisteException("No existen usuarios registrados");
		Turistas.forEach((k, v) -> res.add(v.getNickname()));
		Proveedores.forEach((k, v) -> res.add(v.getNickname()));
		return res;
	}

	@Override
	public Set<String> listarProveedores() throws UsuarioNoExisteException {
		Set<String> res = new HashSet<String>();
		if (Proveedores.isEmpty())
			throw new UsuarioNoExisteException("No existen proveedores registrados");
		Proveedores.forEach((k, v) -> res.add(k.toString()));
		return res;
	}

	@Override
	public DTTurista getDTTurista() {
		return new DTTurista(turistaSeleccionado);
	}

	@Override
	public DTProveedor getDTProveedor() {
		return new DTProveedor(proveedorSeleccionado);
	}

//	@Override
//	public void modificarDatosTurista(String nombre, String apellido, LocalDate fechaNac, String nacionalidad) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void modificarDatosProveedor(String nombre, String apellido, LocalDate fechaNac, String desc, String url) {
//		// TODO Auto-generated method stub
//
//	}

	@Override

	public void crearInscripcion(String nicknameTurista,String nombreSalida, int cantidadTuristas,Float costo, LocalDate fechaAlta) throws YaExisteInscripcionTuristaSalida {
		// TODO Auto-generated method stub
		
		Fabrica fabrica = Fabrica.getInstance();
		ITuristica ctrl = fabrica.getControladorTuristica();
		ctrl.seleccionarSalida(nombreSalida);
		seleccionarTurista(nicknameTurista);
		SalidaTuristica sal = ctrl.getSalidaSeleccionada();
		Turista turi = turistaSeleccionado;
	
		//comprobar que turista no tiene una inscripcion a esa Salida
		if (turi!= null) {
		ArrayList<Inscripcion> inscripciones = turi.getInscripciones();
		boolean tieneInsc = false;
		if (!inscripciones.isEmpty()) {
			Iterator<Inscripcion> it = inscripciones.iterator();
			while (it.hasNext() && !tieneInsc) {
				Inscripcion j = (Inscripcion) it.next();
				if (j.getSalidaAsociada().getNombre() == sal.getNombre()) {
					tieneInsc = true;
				}
			}
		}

		if (tieneInsc) {

			throw new YaExisteInscripcionTuristaSalida(
					"El turista ya tiene una inscripcion a la salida de nombre" + sal.getNombre());

		} else {

		
		  if (sal.getCuposDisponibles()>= cantidadTuristas) {
	           //: calcular costo:
	          float Costo = cantidadTuristas * costo;
	          sal.setCuposDisponibles(sal.getCuposDisponibles() - cantidadTuristas); //actualizo cupos disponibles
	          Inscripcion ins = new Inscripcion(fechaAlta, cantidadTuristas,Costo,sal,turi);
	         //agregar a inscripciones de turista
	          turi.agregarInscripcion(ins);   
		   } else {}
		  
		  }
		}
	}

	@Override
	public Boolean existeUsuario(String nickN) {
		return Proveedores.containsKey(nickN) || Turistas.containsKey(nickN);
	}

	@Override
	public Boolean existeUsuarioEmail(String email) {
		for (Map.Entry<String, Turista> entry : Turistas.entrySet()) {
			if (email.equals(entry.getValue().getEmail()))
				return true;
		}
		for (Map.Entry<String, Proveedor> entry : Proveedores.entrySet()) {
			if (email.equals(entry.getValue().getEmail()))
				return true;
		}
		return false;
	}

	@Override
	public void altaProveedor(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento,String contrasenia,
			String descripcionGeneral, String url) throws UsuarioRepetidoException {
		if (existeUsuario(nickname)) {
			throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado");
		}
		if (existeUsuarioEmail(email)) {
			throw new UsuarioRepetidoException("El email " + email + " ya esta registrado");
		}
		Proveedor p = new Proveedor(nickname, nombre, apellido, email, fechaNacimiento,contrasenia, descripcionGeneral, url);
		Proveedores.put(nickname, p);
	}

	@Override
	public void altaTurista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento,String contrasenia,
			String nacionalidad) throws UsuarioRepetidoException {
		if (existeUsuario(nickname)) {
			throw new UsuarioRepetidoException("El nickname " + nickname + " ya esta registrado");
		}
		if (existeUsuarioEmail(email)) {
			throw new UsuarioRepetidoException("El email " + email + " ya esta registrado");
		}
		Turista t = new Turista(nickname, nombre, apellido, email, fechaNacimiento, contrasenia,nacionalidad);
		Turistas.put(nickname, t);
	}

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
		Set<String> res = new HashSet<String>();
		Turistas.forEach((k, v) -> res.add(k));
		return res;
	}

}
