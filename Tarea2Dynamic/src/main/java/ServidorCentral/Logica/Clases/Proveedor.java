package ServidorCentral.Logica.Clases;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Proveedor extends Usuario {
	private String DescripcionGeneral;
	private String URL;
	
	private Map<String, ActividadTuristica> ActividadesTuristicas;
	
	public Proveedor(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento,String contrasenia, String descripcionGeneral, String url ) {
		super(nickname, nombre, apellido, email, fechaNacimiento,contrasenia);
		setActividadesTuristicas(new HashMap<String, ActividadTuristica>());
		setDescripcionGeneral(descripcionGeneral);
		setURL(url);
		
	}
	public String getDescripcionGeneral() {
		return DescripcionGeneral;
	}
	public void setDescripcionGeneral(String descripcionGeneral) {
		DescripcionGeneral = descripcionGeneral;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String url) {
		URL = url;
	}
	public Map<String, ActividadTuristica> getActividadesTuristicas() {
		return ActividadesTuristicas;
	}
	public void setActividadesTuristicas(Map<String, ActividadTuristica> actividadesTuristicas) {
		ActividadesTuristicas = actividadesTuristicas;
	}
	
	
}


