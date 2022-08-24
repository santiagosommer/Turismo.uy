package ServidorCentral.Logica.Interfaces;

import java.util.Set;

public interface IPaquete {
	public abstract void seleccionarPaquete(String paquete);

	public abstract void crearPaquete(String nombrePaque, String descripcion, 
			int periodoValidez,int Descuento);
	
	public abstract boolean existePaquete(String paquete);

	public abstract Set<String> listarPaquetes();

	public abstract Set<String>  listarActividadesAAgregar();
	
}
