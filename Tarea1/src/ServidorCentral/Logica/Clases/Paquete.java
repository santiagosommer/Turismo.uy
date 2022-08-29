package ServidorCentral.Logica.Clases;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Paquete {
	private String Nombre;
	  private String Descripcion;
	  private int PeriodoValidez;
	  private int Descuento;
	  private LocalDate FechaAlta;
	  private Map<String, ActividadTuristica> ActividadesTuristicas;
	 
	  
	 public Paquete(String nombre,String descripcion,int periodoValidez,int descuento,LocalDate fechaAlta ) {
		 Nombre = nombre;
		 Descripcion = descripcion;
		 PeriodoValidez = periodoValidez;
		 Descuento = descuento;
		 FechaAlta = fechaAlta;
		 this.setActividadesTuristicas(new HashMap<String, ActividadTuristica>()); 
		 
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


	public LocalDate getFechaAlta() {
		return FechaAlta;
	}


	public void setFechaAlta(LocalDate fechaAlta) {
		FechaAlta = fechaAlta;
	}
	
	public Set<String> listarActividades(){
		Set<String> res = new HashSet<>();
		if (!ActividadesTuristicas.isEmpty()) {
			ActividadesTuristicas.forEach((k,v)->res.add(k));	
		} 
			
		return res;
	
	}
}
