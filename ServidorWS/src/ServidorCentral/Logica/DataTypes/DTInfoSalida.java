package ServidorCentral.Logica.DataTypes;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DTInfoSalida {
 private Calendar Fecha;
 private Calendar Hora;
 private String Lugar;
 
 public DTInfoSalida(LocalDate fecha, LocalTime hora, String lugar) {
	 LocalDate in = fecha;
	setFecha(new GregorianCalendar(in.getYear(),in.getMonthValue(),in.getDayOfMonth(),hora.getHour(),hora.getMinute()));
	
	 setLugar(lugar);
 }
 
public Calendar getFecha() {
	return Fecha;
}

public void setFecha(Calendar fecha) {
	Fecha = fecha;
}

public Calendar getHora() {
	return Hora;
}

public void setHora(Calendar hora) {
	Hora = hora;
}

public String getLugar() {
	return Lugar;
}

public void setLugar(String lugar) {
	Lugar = lugar;
}

}
