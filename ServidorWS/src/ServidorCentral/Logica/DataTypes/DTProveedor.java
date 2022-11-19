package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Proveedor;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DTProveedor extends DTUsuario {
 
private String DescripcionGeneral;
private String URL;
private ArrayList<DTActividadTuristica> InfoActividades;
 
 
public DTProveedor(String nickname, String nombre, String apellido, String email,LocalDate fechaNacimiento,String contra, String descripcionGeneral,String url) {
		super(nickname, nombre, apellido, email, fechaNacimiento, contra);
		DescripcionGeneral = descripcionGeneral;
		URL = url;
		InfoActividades = new ArrayList<DTActividadTuristica>();
		
	
}

public DTProveedor(Proveedor pro) {
	super(pro.getNickname(),pro.getNombre(),pro.getApellido(),pro.getEmail(),pro.getFechaNacimiento(),pro.getContraseña());
	setDescripcionGeneral(pro.getDescripcionGeneral());
	setURL(pro.getURL());
	setActividades(new ArrayList<DTActividadTuristica>());
	
	Map<String, ActividadTuristica> map = pro.getActividadesTuristicas();
	
	for(Map.Entry<String, ActividadTuristica> entry : map.entrySet()) {
		DTActividadTuristica auxIAct = new DTActividadTuristica(entry.getValue());
		InfoActividades.add(auxIAct);
	}

	
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
