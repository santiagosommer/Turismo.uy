package datatypes;

public class DTDepartamento {
	
	private String Nombre;
	private String Descripcion;
	private String URL;
	
	public DTDepartamento(String nombre, String descripcion, String url) {
		Nombre = nombre;
		Descripcion = descripcion;
		URL = url;
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
