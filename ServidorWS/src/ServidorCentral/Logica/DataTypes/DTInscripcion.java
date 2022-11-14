package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ServidorCentral.Logica.Clases.Inscripcion;

public class DTInscripcion {
	private XMLGregorianCalendar Fecha;
	private int CantidadTuristas;
	private float Costo;
	private DTTurista Autor;
	private DTSalidaTuristica SalidaAsociada;
	
	
	public DTInscripcion(LocalDate fecha, int cantidadTuristas, float costo, DTTurista autor,DTSalidaTuristica salidaAsociada) {
		try {
			setFecha(DatatypeFactory.newInstance().newXMLGregorianCalendar(fecha.toString()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CantidadTuristas = cantidadTuristas ;
		Costo = costo;
		Autor = autor;
		SalidaAsociada = salidaAsociada;
	}
	
	public DTInscripcion(Inscripcion ins) {
		try {
			setFecha(DatatypeFactory.newInstance().newXMLGregorianCalendar(ins.getFecha().toString()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public XMLGregorianCalendar getFecha() {
		return Fecha;
	}

	public void setFecha(XMLGregorianCalendar fecha) {
		Fecha = fecha;
	}
	
	
	
}
