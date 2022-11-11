package ServidorCentral.Logica.Interfaces;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import ServidorCentral.Logica.Clases.Paquete;
import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.Excepciones.NombrePaqueteRepetidoException;

public interface IPaquete {
	
	public abstract Set<String> listarCategoriasPaquete(String paquete);
	public abstract void seleccionarPaquete(String paquete);

	public abstract void crearPaquete(String nombrePaque, String descripcion, 
			int periodoValidez,int Descuento, LocalDate fechaAlta) throws NombrePaqueteRepetidoException;
	
	public abstract boolean existePaquete(String paquete);

	public abstract Set<String> listarPaquetes();

	
	public abstract Set<String>  listarActividadesAAgregar(String departamento);
	public abstract  Map<String, Paquete> getPaquetes();

	public abstract DTPaquete getDtPaquete();

	public abstract void AgregarActividadPaquete(String paqueteSelecBox, String actividadSelecBox);
	
	public abstract Set<String> listarActividadesPaquete();
	public abstract Set<DTPaquete> infoPaquetes();

}
