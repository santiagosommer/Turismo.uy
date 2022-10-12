package ServidorCentral.Logica.DataTypes;

import java.util.ArrayList;
import java.util.Map;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Categoria;
import ServidorCentral.Logica.Clases.Paquete;

public class DTCategoria {
	private String Nombre;
	private ArrayList<DTActividadTuristica> InfoActividadesTuristicas;
	private ArrayList<DTPaquete> InfoPaquetes;
	
	public DTCategoria(Categoria cat) {
		Nombre = cat.getNombre();
		
		Map<String,ActividadTuristica> map = cat.getActividadesTuristicas();
		Map<String,Paquete> paq = cat.getPaquetes();
		
		InfoActividadesTuristicas = new ArrayList<DTActividadTuristica>();
		for(Map.Entry<String,ActividadTuristica > entry : map.entrySet()) {
			DTActividadTuristica auxIAct = new DTActividadTuristica(entry.getValue());
			this.InfoActividadesTuristicas.add(auxIAct);
		}
		
		
		InfoPaquetes= new ArrayList<DTPaquete>();
		for(Map.Entry<String, Paquete> entry : paq.entrySet()) {
			DTPaquete auxIPa = new DTPaquete(entry.getValue());
			this.InfoPaquetes.add(auxIPa);
		}
		//para cada uno guardo un dt
		
		
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public ArrayList<DTActividadTuristica> getInfoActividadesTuristicas() {
		return InfoActividadesTuristicas;
	}
	public void setInfoActividadesTuristicas(ArrayList<DTActividadTuristica> infoActividadesTuristicas) {
		InfoActividadesTuristicas = infoActividadesTuristicas;
	}
	public ArrayList<DTPaquete> getInfoPaquetes() {
		return InfoPaquetes;
	}
	public void setInfoPaquetes(ArrayList<DTPaquete> infoPaquetes) {
		InfoPaquetes = infoPaquetes;
	}
	
	

}
