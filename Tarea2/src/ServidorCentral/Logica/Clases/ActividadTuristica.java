package ServidorCentral.Logica.Clases;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.Map;

import ServidorCentral.Logica.DataTypes.EstadoActividad;


public class ActividadTuristica {

	private String Nombre;
	private String Descripcion;
	private int Duracion;
	private float CostoTurista;
	private LocalDate FechaAlta;
	private Departamento Departamento;
	private Map<String, SalidaTuristica> Salidas;
	private Proveedor Proveedor;
	private Map<String, Paquete> Paquetes;
	private String NombreCiudad;
	private Map<String, Categoria> Categorias;
	private EstadoActividad Estado;
	private int VisitasActividad; //nuevo
	private String URLVideo;

	public ActividadTuristica(String nombre, String descripcion, int duracion, float costoTurista, LocalDate fechaAlta,
			Departamento infoDepartamento, String ciudad, Proveedor proveedor,Map<String, Categoria> categorias) {
		setNombre(nombre);
		setDescripcion(descripcion);
		setDuracion(duracion);
		setCostoTurista(costoTurista);
		setFechaAlta(fechaAlta);
		setInfoDepartamento(infoDepartamento);
		setSalidas(new HashMap<String, SalidaTuristica>());
		setPaquetes(new HashMap<String, Paquete>());
		setProveedor(proveedor);
		setCiudad(ciudad);
		setCategorias(categorias);
		Estado = EstadoActividad.Agregada;
		VisitasActividad = 0;
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

	public int getDuracion() {
		return Duracion;
	}

	public void setDuracion(int duracion) {
		Duracion = duracion;
	}

	public float getCostoTurista() {
		return CostoTurista;
	}

	public void setCostoTurista(float costoTurista) {
		CostoTurista = costoTurista;
	}

	public Departamento getInfoDepartamento() {
		return Departamento;
	}

	public void setInfoDepartamento(Departamento departamento) {
		Departamento = departamento;
	}

	public String getCiudad() {
		return NombreCiudad;
	}

	public void setCiudad(String ciudad) {
		NombreCiudad = ciudad;
	}

	public LocalDate getFechaAlta() {
		return FechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		FechaAlta = fechaAlta;
	}

	public Map<String, SalidaTuristica> getSalidas() {
		return Salidas;
	}

	public void setSalidas(Map<String, SalidaTuristica> salidas) {
		Salidas = salidas;
	}

	public Map<String, Paquete> getPaquetes() {
		return Paquetes;
	}

	public void setPaquetes(Map<String, Paquete> paquetes) {
		Paquetes = paquetes;
	}

	public Proveedor getProveedor() {
		return Proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		Proveedor = proveedor;
	}

	public Map<String, Categoria> getCategorias() {
		return Categorias;
	}

	public void setCategorias(Map<String, Categoria> categorias) {
		Categorias = categorias;
	}

	public EstadoActividad getEstado() {
		return Estado;
	}

	public void setEstado(EstadoActividad estado) {
		Estado = estado;
	}

	public boolean tieneCat(String cat) {
		for (String key : Categorias.keySet()) {
			return key.contentEquals(cat);
		}
		return false;
	}

	public int getVisitasActividad() {
		return VisitasActividad;
	}

	public void setVisitasActividad(int visitasActividad) {
		VisitasActividad = visitasActividad;
	}

	public String getURLVideo() {
		return URLVideo;
	}

	public void setURLVideo(String uRLVideo) {
		URLVideo = uRLVideo;
	}
	
	
	
}
