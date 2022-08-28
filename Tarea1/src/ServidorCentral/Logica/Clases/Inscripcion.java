package ServidorCentral.Logica.Clases;

import java.time.LocalDate;
//import java.time.LocalTime;


public class Inscripcion {

	LocalDate Fecha;
	private int CantidadTuristas;
	private float Costo;
	private Turista turista;
	private SalidaTuristica SalidaAsociada;
	
	
	public Inscripcion(LocalDate fecha, int cantidadTuristas, float costo, SalidaTuristica salidaAsociada, Turista turista) { //
		Fecha = fecha;
		CantidadTuristas = cantidadTuristas ;
		Costo = costo;
		this.turista = turista;
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

	public LocalDate getFecha() {
		return Fecha;
	}

	public void setFecha(LocalDate fecha) {
		Fecha = fecha;
	}

   public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}


	
}
