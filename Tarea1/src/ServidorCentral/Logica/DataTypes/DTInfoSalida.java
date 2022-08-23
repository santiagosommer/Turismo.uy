package datatypes;


import java.time.LocalDate;
import java.time.LocalTime;

public class DTInfoSalida {
 private LocalDate Fecha;
 private LocalTime Hora;
 private String Lugar;
 
 public DTInfoSalida(LocalDate fecha, LocalTime hora, String lugar) {
	 Fecha = fecha;
	 Hora = hora;
	 Lugar = lugar;
 }
 
public LocalDate getFecha() {
	return Fecha;
}

public void setFecha(LocalDate fecha) {
	Fecha = fecha;
}

public LocalTime getHora() {
	return Hora;
}

public void setHora(LocalTime hora) {
	Hora = hora;
}

public String getLugar() {
	return Lugar;
}

public void setLugar(String lugar) {
	Lugar = lugar;
}

}
