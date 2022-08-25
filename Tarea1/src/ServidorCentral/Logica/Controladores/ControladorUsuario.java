package ServidorCentral.Logica.Controladores;
import ServidorCentral.Logica.Interfaces.IUsuario;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import ServidorCentral.Logica.Clases.Turista;
import ServidorCentral.Logica.DataTypes.DTProveedor;
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.Clases.Proveedor;


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
	public void seleccionarTurista(String Turista) {
		turistaSeleccionado = Turistas.get(Turista);
		
	}
	@Override
	public void seleccionarProveedor(String Proveedor) {
		proveedorSeleccionado = Proveedores.get(Proveedor);
		
	}
	@Override
	public Set<String> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Set<String> listarProveedores() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DTTurista getDTTurista() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public DTProveedor getDTProveedor() {
		// TODO Auto-generated method stub
		return null;
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
	
	public void crearInscripcion(String nombre, int cantidadMaxTuristas, LocalDate fechaAlta,DTInfoSalida infoSalida,int CuposDisponibles) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Boolean existeUsuario(String nickN) {
		return Proveedores.containsKey(nickN) || Turistas.containsKey(nickN);
	}
	@Override
	public void altaProveedor(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String descripcionGeneral, String url) {
		if(existeUsuario(nickname)) {
			// exception here
		}
		Proveedor p = new Proveedor(nickname, nombre, apellido, email, fechaNacimiento, descripcionGeneral, url);
		Proveedores.put(nickname,p);
	}
	@Override
	public void altaTurista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String nacionalidad) {
		if(existeUsuario(nickname)) {
			// exception here
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
	
	
	
	
}
