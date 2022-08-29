package ServidorCentral.Logica.Interfaces;
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.Excepciones.UsuarioNoExisteException;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Excepciones.YaExisteInscripcionTuristaSalida;
import ServidorCentral.Logica.DataTypes.DTProveedor;

import java.time.LocalDate;
import java.util.Set;


public interface IUsuario {

	public abstract Boolean esTurista(String nickname);
	public abstract void seleccionarTurista(String Turista);
	public abstract void seleccionarProveedor(String Proveedor);
	public abstract Set<String> listarUsuarios() throws UsuarioNoExisteException; 
	public abstract Set<String> listarProveedores() throws UsuarioNoExisteException;
	public abstract Set<String> listarTuristas();
	public abstract DTTurista getDTTurista();
	public abstract DTProveedor getDTProveedor();
//	public abstract void modificarDatosTurista(String nombre, String apellido, LocalDate fechaNac, String nacionalidad);
//	public abstract void modificarDatosProveedor(String nombre, String apellido, LocalDate fechaNac, String desc, String url);
	public abstract void crearInscripcion(String nombreTurista,String nombreSalida, int cantidadTuristas,Float costo, LocalDate fechaAlta) throws YaExisteInscripcionTuristaSalida;
	public abstract Boolean existeUsuario(String nickN);
	public abstract Boolean existeUsuarioEmail(String email);
	public abstract void altaProveedor(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String descripcionGeneral, String url) throws UsuarioRepetidoException;
	public abstract void altaTurista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String nacionalidad) throws UsuarioRepetidoException;
}
