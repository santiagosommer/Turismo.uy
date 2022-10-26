package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Paquete;



public class DTPaquete {
  private String Nombre;
  private String Descripcion;
  private int PeriodoValidez;
  private int Descuento;
  private LocalDate FechaAlta;
  private ArrayList<DTActividadTuristica> ActividadesTuristicas; 
  
 public DTPaquete(String nombre,String descripcion,int periodoValidez,int descuento,LocalDate fechaAlta) {
	 setNombre(nombre);
	 setDescripcion(descripcion);
	 setPeriodoValidez(periodoValidez);
	 setDescuento(descuento);
	 setActividadesTuristicas(new ArrayList<DTActividadTuristica>());	
	 setFechaAlta(fechaAlta);
	
 }
  
  
 public DTPaquete(Paquete pa) {
	 setNombre(pa.getNombre());
	 setDescripcion(pa.getDescripcion());
	 setPeriodoValidez(pa.getPeriodoValidez());
	 setDescuento(pa.getDescuento());
	 FechaAlta = pa.getFechaAlta();
	 ActividadesTuristicas = new ArrayList<DTActividadTuristica>();
	
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


public LocalDate getFechaAlta() {
	return FechaAlta;
}


public void setFechaAlta(LocalDate fechaAlta) {
	FechaAlta = fechaAlta;
}
}
