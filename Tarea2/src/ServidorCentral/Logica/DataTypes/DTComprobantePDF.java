package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.time.LocalTime;

public class DTComprobantePDF {
	String NombreTurista;
	String NombreActividad;
	String NombreSalida;
	LocalDate FechaSalida;
	LocalTime HoraSalida;
	int CantidadTur;
	
	DTComprobantePDF() {
		
		
		
	}
	
	public String getNombreTurista() {
		return NombreTurista;
	}
	public void setNombreTurista(String nombre) {
		NombreTurista = nombre;
	}
	
	public String getNombreActividad() {
		return NombreActividad;
	}
	public void setNombreActividad(String nombre) {
		NombreActividad = nombre;
	}
	public String getNombreSalida() {
		return NombreSalida;
	}
	public void setNombreSalida(String nombre) {
		NombreSalida = nombre;
	}
	
	public LocalDate getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(LocalDate fecha) {
		FechaSalida = fecha;
	}
	
	public LocalTime getHoraSalida() {
		return HoraSalida;
	}
	public void setHoraSalida(LocalTime hora) {
		HoraSalida = hora;
	}
	
	public int getCantidadTur() {
		return CantidadTur;
	}
	public void setNombreTurista(int cantidadTur) {
		CantidadTur = cantidadTur;
	}
	
	
	
	
}
