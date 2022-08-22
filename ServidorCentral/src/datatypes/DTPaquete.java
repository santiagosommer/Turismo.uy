package datatypes;

import java.util.ArrayList;

public class DTPaquete {
  private String Nombre;
  private String Descripcion;
  private int PeriodoValidez;
  private int Descuento;
  private ArrayList<DTActividadTuristica> ActividadesTuristicas;
  
 public DTPaquete(String nombre,String descripcion,int periodoValidez,int descuento, ArrayList<DTActividadTuristica> actividadesTuristicas) {
	 Nombre = nombre;
	 Descripcion = descripcion;
	 PeriodoValidez = periodoValidez;
	 Descuento = descuento;
	 ActividadesTuristicas = actividadesTuristicas;
	 
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
}
