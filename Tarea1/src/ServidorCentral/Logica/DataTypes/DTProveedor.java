package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;

public class DTProveedor extends DTUsuario {
 
private String DescripcionGeneral;
private String URL;
private ArrayList<DTActividadTuristica> InfoActividades;
 
 
public DTProveedor(String nickname, String nombre, String apellido, String email,LocalDate fechaNacimiento, String descripcionGeneral,String url) {
		super(nickname, nombre, apellido, email, fechaNacimiento);
		DescripcionGeneral = descripcionGeneral;
		URL = url;
		InfoActividades = new ArrayList<DTActividadTuristica>();
		
		//InfoActividades = actividades;
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

public ArrayList<DTActividadTuristica> getActividades() {
	return InfoActividades;
}

public void setActividades(ArrayList<DTActividadTuristica> actividades) {
	InfoActividades = actividades;
}
	
	


public void addInfoActividad(DTActividadTuristica actividad) {
		InfoActividades.add(actividad);
	
}
}
