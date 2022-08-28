package ServidorCentral.Logica.Clases;

import java.time.LocalDate;
//import java.time.LocalTime;


public class Inscripcion {
<<<<<<< HEAD
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
=======
	LocalDate Fecha;
	private int CantidadTuristas;
	private float Costo;
	//private Turista turista;
	private SalidaTuristica SalidaAsociada;
	
	
	public Inscripcion(LocalDate fecha, int cantidadTuristas, float costo, SalidaTuristica salidaAsociada) { // Turista turista
		Fecha = fecha;
		CantidadTuristas = cantidadTuristas ;
		Costo = costo;
		//this.turista = turista;
>>>>>>> 2667cee7121cb8aab80ca2b0dce9a2a9d19fb0ca
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

<<<<<<< HEAD
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
=======
	//public Turista getTurista() {
		//return turista;
	//}

	//public void setTurista(Turista turista) {
		//this.turista = turista;
	//}

>>>>>>> 2667cee7121cb8aab80ca2b0dce9a2a9d19fb0ca
	
}
