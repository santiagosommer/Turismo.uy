package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ServidorCentral.Logica.Clases.SalidaTuristica;

public class DTSalidaTuristica {
 private String Nombre;
 private int CantidadMaxTuristas;
 private XMLGregorianCalendar FechaAlta;
 private DTInfoSalida InfoSalida;
 private int CuposDisponibles;
 private DTActividadTuristica ActividadTuristicaAsoc;
 private ArrayList<DTInscripcion> inscripcionesAsoc;
 
 public  DTSalidaTuristica (String nombre,int cantidadMaxTuristas,LocalDate fechaAltaSalida,DTInfoSalida infoSalida,
		 int cuposDisponibles,DTActividadTuristica actividadTuristicaAsoc) {
	 setNombre(nombre);
	 setCantidadMaxTuristas(cantidadMaxTuristas);
	 try {
		setFechaAlta(DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaAltaSalida.toString()));
	} catch (DatatypeConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 setInfoSalida(infoSalida);
	 setCuposDisponibles(cuposDisponibles); 
	 setActividadTuristicaAsoc(actividadTuristicaAsoc);
	 inscripcionesAsoc = new ArrayList<DTInscripcion>();
	 
 }
 
 public DTSalidaTuristica(SalidaTuristica sal) {
	 Nombre = sal.getNombre();
	 CantidadMaxTuristas = sal.getCantidadMaxTuristas();
	 try {
		FechaAlta = DatatypeFactory.newInstance().newXMLGregorianCalendar(sal.getFechaAlta().toString());
	} catch (DatatypeConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 InfoSalida = sal.getInfoSalida();
	 CuposDisponibles = sal.getCuposDisponibles();
 }
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public int getCantidadMaxTuristas() {
	return CantidadMaxTuristas;
}
public void setCantidadMaxTuristas(int cantidadMaxTuristas) {
	CantidadMaxTuristas = cantidadMaxTuristas;
}
public XMLGregorianCalendar getFechaAlta() {
	return FechaAlta;
}
public void setFechaAlta(XMLGregorianCalendar fechaAltaSalida) {
	FechaAlta = fechaAltaSalida;
}
public DTInfoSalida getInfoSalida() {
	return InfoSalida;
}
public void setInfoSalida(DTInfoSalida infoSalida) {
	InfoSalida = infoSalida;
}
public int getCuposDisponibles() {
	return CuposDisponibles;
}
public void setCuposDisponibles(int cuposDisponibles) {
	CuposDisponibles = cuposDisponibles;
}
public DTActividadTuristica getActividadTuristicaAsoc() {
	return ActividadTuristicaAsoc;
}
public void setActividadTuristicaAsoc(DTActividadTuristica actividadTuristicaAsoc) {
	ActividadTuristicaAsoc = actividadTuristicaAsoc;
}
public ArrayList<DTInscripcion> getInscripciones() {
	return inscripcionesAsoc;
}
public void setInscripciones(ArrayList<DTInscripcion> inscripcionesAsoc) {
	this.inscripcionesAsoc = inscripcionesAsoc;
}

	
}
