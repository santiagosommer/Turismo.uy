package ServidorCentral.Logica.Interfaces;
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.DataTypes.DTProveedor;

import java.time.LocalDate;
import java.util.Set;


public interface IUsuario {

	public abstract void seleccionarTurista(String Turista);
	public abstract void seleccionarProveedor(String Proveedor);
	public abstract Set<String> listarUsuarios(); 
	public abstract Set<String> listarProveedores();
	public abstract DTTurista getDTTurista();
	public abstract DTProveedor getDTProveedor();
	public abstract void modificarDatosTurista(String nombre, String apellido, LocalDate fechaNac, String nacionalidad);
	public abstract void modificarDatosProveedor(String nombre, String apellido, LocalDate fechaNac, String desc, String url);
	public abstract void crearInscripcion(String nombre, int cantidadMaxTuristas, LocalDate fechaAlta,DTInfoSalida infoSalida,int CuposDisponibles);
	public abstract Boolean existeUsuario(String nickN);
	public abstract void altaProveedor(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String descripcionGeneral, String url) throws UsuarioRepetidoException;
	public abstract void altaTurista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String nacionalidad) throws UsuarioRepetidoException;
}
