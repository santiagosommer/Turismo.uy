package controladores;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import clases.ActividadTuristica;
import clases.Proveedor;
import clases.Turista;
import datatypes.DTProveedor;
import datatypes.DTSalidaTuristica;
import datatypes.DTTurista;
import interfaces.IUsuario;

public class ControladorUsuario implements IUsuario {
	
	private Map<String, Turista> Turistas;
	private Map<String, Proveedor> Proveedores;
	private Proveedor proveedorSeleccionado; //getters y setters?
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void seleccionarProveedor(String Proveedor) {
		// TODO Auto-generated method stub
		
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
	public void crearInscripcion(DTSalidaTuristica salida) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Boolean existeUsuario(String nickN) {
		// TODO Auto-generated method stub
		return null;
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
