package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ServidorCentral.Logica.Clases.SalidaTuristica;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DTSalidaTuristica {
 private String Nombre;
 private int CantidadMaxTuristas;
 private Calendar FechaAlta;
 private DTInfoSalida InfoSalida;
 private int CuposDisponibles;
 private DTActividadTuristica ActividadTuristicaAsoc;
 private ArrayList<DTInscripcion> inscripcionesAsoc;
 
 public  DTSalidaTuristica (String nombre,int cantidadMaxTuristas,LocalDate fechaAltaSalida,DTInfoSalida infoSalida,
		 int cuposDisponibles,DTActividadTuristica actividadTuristicaAsoc) {
	 setNombre(nombre);
	 setCantidadMaxTuristas(cantidadMaxTuristas);
	 LocalDate in = fechaAltaSalida;
	 setFechaAlta(new GregorianCalendar(in.getYear(),in.getMonthValue(),in.getDayOfMonth()));
	 setInfoSalida(infoSalida);
	 setCuposDisponibles(cuposDisponibles); 
	 setActividadTuristicaAsoc(actividadTuristicaAsoc);
	 inscripcionesAsoc = new ArrayList<DTInscripcion>();
	 
 }
 
 public DTSalidaTuristica(SalidaTuristica sal) {
	 Nombre = sal.getNombre();
	 CantidadMaxTuristas = sal.getCantidadMaxTuristas();
	 LocalDate in = sal.getFechaAlta();
	 setFechaAlta(new GregorianCalendar(in.getYear(),in.getMonthValue(),in.getDayOfMonth()));
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
public Calendar getFechaAlta() {
	return FechaAlta;
}
public void setFechaAlta(Calendar fechaAltaSalida) {
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
