package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
//import java.util.ArrayList;

public class DTSalidaTuristica {
 private String Nombre;
 private int CantidadMaxTuristas;
 private LocalDate FechaAlta;
 private DTInfoSalida InfoSalida;
 private int CuposDisponibles;
 private DTActividadTuristica ActividadTuristicaAsoc;
 
 public  DTSalidaTuristica (String nombre,int cantidadMaxTuristas,LocalDate fechaAltaSalida,DTInfoSalida infoSalida,
		 int cuposDisponibles,DTActividadTuristica actividadTuristicaAsoc) {
	 Nombre = nombre;
	 CantidadMaxTuristas = cantidadMaxTuristas;
	 FechaAlta = fechaAltaSalida;
	 InfoSalida = infoSalida;
	 CuposDisponibles = cuposDisponibles; 
	 ActividadTuristicaAsoc =  actividadTuristicaAsoc;
	 
	 
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
public LocalDate getFechaAlta() {
	return FechaAlta;
}
public void setFechaAlta(LocalDate fechaAltaSalida) {
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

	
	
}
