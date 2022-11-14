package ServidorCentral.Logica.DataTypes;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DTInfoSalida {
 private XMLGregorianCalendar Fecha;
 private XMLGregorianCalendar Hora;
 private String Lugar;
 
 public DTInfoSalida(LocalDate fecha, LocalTime hora, String lugar) {
	 LocalDate in = fecha;
	 try {
		setFecha(DatatypeFactory.newInstance().newXMLGregorianCalendar(in.toString()));
	} catch (DatatypeConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 Hora.setHour(hora.getHour());
	 Hora.setMinute(hora.getMinute());
	 Hora.setSecond(hora.getSecond());
	 setLugar(lugar);
 }
 
public XMLGregorianCalendar getFecha() {
	return Fecha;
}

public void setFecha(XMLGregorianCalendar fecha) {
	Fecha = fecha;
}

public XMLGregorianCalendar getHora() {
	return Hora;
}

public void setHora(XMLGregorianCalendar hora) {
	Hora = hora;
}

public String getLugar() {
	return Lugar;
}

public void setLugar(String lugar) {
	Lugar = lugar;
}

}
