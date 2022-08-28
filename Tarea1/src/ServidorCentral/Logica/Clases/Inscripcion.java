package ServidorCentral.Logica.Clases;

import java.time.LocalTime;


public class Inscripcion {
	private LocalTime Fecha;
	private int CantidadTuristas;
	private float Costo;
	private Turista Autor;
	private SalidaTuristica SalidaAsociada;
	
	
	public Inscripcion(LocalTime fecha, int cantidadTuristas, float costo, Turista autor, SalidaTuristica salidaAsociada) {
		setFecha(fecha);
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
	
	public SalidaTuristica getSalidaAsociada() {
		return SalidaAsociada;
	}
	public void setSalidaAsociada(SalidaTuristica salidaAsociada) {
		SalidaAsociada = salidaAsociada;
	}

	public LocalTime getFecha() {
		return Fecha;
	}

	public void setFecha(LocalTime fecha) {
		Fecha = fecha;
	}

	public Turista getAutor() {
		return Autor;
	}

	public void setAutor(Turista autor) {
		Autor = autor;
	}
	
}
