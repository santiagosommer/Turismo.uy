package ServidorCentral.Logica.Interfaces;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.DataTypes.DTPaquete;

import java.time.LocalDate;
import java.util.Set;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.SalidaTuristica;
import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import ServidorCentral.Logica.DataTypes.DTDepartamento;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Excepciones.CategoriaRepetidaException;
import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;



public interface ITuristica {
	
	public abstract Set<String> listarCategorias();
	public abstract Set<String> listarCategoriasActividad(String actividad);
	public abstract void crearCategoria(String nombre) throws CategoriaRepetidaException;
	public abstract void seleccionarActividad(String actividad);
	public abstract ActividadTuristica getActividadSeleccionada();
	public abstract void seleccionarSalida(String salida);
	public abstract SalidaTuristica getSalidaSeleccionada();
	public abstract void seleccionarDepartamento(String departemneto);
	public abstract DTActividadTuristica getDTActividadTuristica();
	public abstract DTSalidaTuristica getDTSalidaTuristica();
	public abstract DTDepartamento getDTDepartamento();
	public abstract void crearActividadTuristica(String nombre, String descripcion, int duracion, float costoTurista, LocalDate fechaAlta, String ciudad, String departamento,String proveedorNick, Set<String> categorias) throws NombreActividadRepetidoException;
	public abstract Set<String> listarDepartamentos();
	public abstract Set<String> listarActividadesDeDepartamento(String departemento);
	public abstract Set<DTSalidaTuristica> datosSalidasVigentes(String actividad);
	public abstract void crearSalidaTuristica(String nombre,int cantMaxTuristas, LocalDate fechaAlta, DTInfoSalida infoSalida, String actividad) throws NombreSalidaRepetidoException, NoHayActividadConEseNombreException;
	public abstract Set<String> listarSalidasActividad(String actividad);
	public abstract Boolean existeActividad(String actividad);
	public abstract Boolean existeSalida(String salida);
	public abstract Boolean existeDepartamento(String departamento);
	public abstract void crearDepartamento(String nombre,String descripcion, String URL);
	public abstract Boolean existeInscripcion(String salida, String nombreTurista);
	public abstract Set<String> listarActividadesAgregadas();
	public abstract void AceptarActividad(String actividad);
	public abstract void RechazarActividad(String actividad);
	public abstract Set<DTActividadTuristica> listarActividadesDeptoYCate(String depto,String cat);
	public abstract Set<DTPaquete> listarPaquetesCategoria(String cat);
	
	

}
