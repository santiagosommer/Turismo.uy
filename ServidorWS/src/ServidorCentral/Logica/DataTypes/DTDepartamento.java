package ServidorCentral.Logica.DataTypes;

import ServidorCentral.Logica.Clases.Departamento;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DTDepartamento {
	
	private String Nombre;
	private String Descripcion;
	private String URL;
	
	public DTDepartamento(Departamento dep) {
		setNombre(dep.getNombre());
		setDescripcion(dep.getDescripcion());
		setURL(dep.getURL());
	}

	public DTDepartamento(String nombre2, String descripcion2, String url2) {
		setNombre(nombre2);
		setDescripcion(descripcion2);
		setURL(url2);
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
	public String getURL() {
		return URL;
	}
	public void setURL(String url) {
		URL = url;
	}
	

}
