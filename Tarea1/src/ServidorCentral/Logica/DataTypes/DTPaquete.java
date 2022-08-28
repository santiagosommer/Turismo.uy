package ServidorCentral.Logica.DataTypes;

import java.util.ArrayList;

import ServidorCentral.Logica.Clases.Paquete;



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
	 ActividadesTuristicas = new ArrayList<DTActividadTuristica>();	
	
 }
  
  
 public DTPaquete(Paquete pa) {
	 Nombre = pa.getNombre();
	 Descripcion = pa.getDescripcion();
	 PeriodoValidez = pa.getPeriodoValidez();
	 Descuento = pa.getDescuento();
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
