package clases;

import java.util.HashMap;
import java.util.Map;

public class Paquete {
	private String Nombre;
	  private String Descripcion;
	  private int PeriodoValidez;
	  private int Descuento;
	  private Map<String, ActividadTuristica> ActividadesTuristicas;
	 
	  
	 public Paquete(String nombre,String descripcion,int periodoValidez,int descuento ) {
		 Nombre = nombre;
		 Descripcion = descripcion;
		 PeriodoValidez = periodoValidez;
		 Descuento = descuento;
		 this.setActividadesTuristicas(new HashMap<String, ActividadTuristica>()); //esto fue automatico 
		 
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


	public Map<String, ActividadTuristica> getActividadesTuristicas() {
		return ActividadesTuristicas;
	}


	public void setActividadesTuristicas(Map<String, ActividadTuristica> actividadesTuristicas) {
		ActividadesTuristicas = actividadesTuristicas;
	}
	
	
}
