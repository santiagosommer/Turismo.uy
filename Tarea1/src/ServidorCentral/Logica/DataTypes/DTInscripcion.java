package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.time.LocalTime;

public class DTInscripcion {
	private LocalDate Fecha;
	private int CantidadTuristas;
	private float Costo;
	private DTTurista Autor;
	private DTSalidaTuristica SalidaAsociada;
	
	
	public DTInscripcion(LocalDate fecha, int cantidadTuristas, float costo, DTTurista autor,DTSalidaTuristica salidaAsociada) {
		Fecha = fecha;
		CantidadTuristas = cantidadTuristas ;
		Costo = costo;
		Autor = autor;
		SalidaAsociada = salidaAsociada;
	}
	
	public int getCantidadTuristas() {
		return CantidadTuristas;
	}
	public void setCantidadTuristas(int cantidadTuristas) {
		CantidadTuristas = cantidadTuristas;
	}
	public float getCosto() {
		return Costo;
	}
	public void setCosto(float costo) {
		Costo = costo;
	}
	
	public DTSalidaTuristica getSalidaAsociada() {
		return SalidaAsociada;
	}
	public void setSalidaAsociada(DTSalidaTuristica salidaAsociada) {
		SalidaAsociada = salidaAsociada;
	}

	public DTTurista getAutor() {
		return Autor;
	}

	public void setAutor(DTTurista autor) {
		Autor = autor;
	}

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}
	
	
	
}
