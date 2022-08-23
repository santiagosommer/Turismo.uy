package interfaces;

import java.time.LocalDate;
import java.util.Set;

import datatypes.DTProveedor;
import datatypes.DTSalidaTuristica;
import datatypes.DTTurista;

public interface IUsuario {

	public abstract void seleccionarTurista(String Turista);
	public abstract void seleccionarProveedor(String Proveedor);
	public abstract Set<String> listarUsuarios(); 
	public abstract Set<String> listarProveedores();
	public abstract DTTurista getDTTurista();
	public abstract DTProveedor getDTProveedor();
	public abstract void modificarDatosTurista(String nombre, String apellido, LocalDate fechaNac, String nacionalidad);
	public abstract void modificarDatosProveedor(String nombre, String apellido, LocalDate fechaNac, String desc, String url);
	public abstract void crearInscripcion(DTSalidaTuristica salida); //cambiar por datos
	public abstract Boolean existeUsuario(String nickN);
}
