package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ServidorCentral.Logica.Clases.Inscripcion;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DTInscripcion {
	private Calendar Fecha;
	private int CantidadTuristas;
	private float Costo;
	private DTTurista Autor;
	private DTSalidaTuristica SalidaAsociada;
	
	
	public DTInscripcion(LocalDate fecha, int cantidadTuristas, float costo, DTTurista autor,DTSalidaTuristica salidaAsociada) {
		LocalDate in = fecha;
		setFecha(new GregorianCalendar(in.getYear(),in.getMonthValue(),in.getDayOfMonth()));
		CantidadTuristas = cantidadTuristas ;
		Costo = costo;
		Autor = autor;
		SalidaAsociada = salidaAsociada;
	}
	
	public DTInscripcion(Inscripcion ins) {
		LocalDate in = ins.getFecha();
		setFecha(new GregorianCalendar(in.getYear(),in.getMonthValue(),in.getDayOfMonth()));
		setCantidadTuristas(ins.getCantidadTuristas());
		setCosto(ins.getCosto());
		setSalidaAsociada(new DTSalidaTuristica(ins.getSalidaAsociada()));

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

	public Calendar getFecha() {
		return Fecha;
	}

	public void setFecha(Calendar fecha) {
		Fecha = fecha;
	}
	
	
	
}
