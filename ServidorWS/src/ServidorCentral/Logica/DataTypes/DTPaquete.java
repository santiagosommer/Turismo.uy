package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import ServidorCentral.Logica.Clases.Paquete;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class DTPaquete {
  private String Nombre;
  private String Descripcion;
  private int PeriodoValidez;
  private int Descuento;
  private Calendar FechaAlta;
  private ArrayList<DTActividadTuristica> ActividadesTuristicas; 
  
 public DTPaquete(String nombre,String descripcion,int periodoValidez,int descuento,LocalDate fechaAlta) {
	 setNombre(nombre);
	 setDescripcion(descripcion);
	 setPeriodoValidez(periodoValidez);
	 setDescuento(descuento);
	 setActividadesTuristicas(new ArrayList<DTActividadTuristica>());	
	 LocalDate in = fechaAlta;
	 setFechaAlta(new GregorianCalendar(in.getYear(),in.getMonthValue(),in.getDayOfMonth()));
	
 }
  
  
 public DTPaquete(Paquete pa) {
	 setNombre(pa.getNombre());
	 setDescripcion(pa.getDescripcion());
	 setPeriodoValidez(pa.getPeriodoValidez());
	 setDescuento(pa.getDescuento());
}


public String getNombre() {
	return Nombre;
}
 public void setNombre(String nombre) {
	Nombre = nombre;
}
 public String getDescripcion() {
	return Descripcion;
}
 
 public void setDescripcion(String descripcion) {
	Descripcion = descripcion;
}
 public int getPeriodoValidez() {
	return PeriodoValidez;
}
 public void setPeriodoValidez(int periodoValidez) {
	PeriodoValidez = periodoValidez;
}
 public int getDescuento() {
	return Descuento;
}
 public void setDescuento(int descuento) {
	Descuento = descuento;
}
 public ArrayList<DTActividadTuristica> getActividadesTuristicas() {
	return ActividadesTuristicas;
}
 public void setActividadesTuristicas(ArrayList<DTActividadTuristica> actividadesTuristicas) {
	ActividadesTuristicas = actividadesTuristicas;
}


public Calendar getFechaAlta() {
	return FechaAlta;
}


public void setFechaAlta(Calendar fechaAlta) {
	FechaAlta = fechaAlta;
}
}
