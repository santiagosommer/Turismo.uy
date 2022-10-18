package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Categoria;
import ServidorCentral.Logica.Clases.Paquete;
import ServidorCentral.Logica.Clases.SalidaTuristica;



public class DTActividadTuristica {
	
	enum EstadoActividad{
		   Agregada,Confirmada, Rechazada;
		}
	
	private String Nombre;
	private String Descripcion;
	private int Duracion;
	private float CostoTurista;
	private LocalDate FechaAlta;
	private DTDepartamento InfoDepartamento;
	private ArrayList<DTSalidaTuristica> InfoSalidas;
	private String Proveedor;
	private ArrayList<DTPaquete> InfoPaquetes;
	private String Ciudad;
	private ArrayList<DTCategoria> InfoCategorias;
	private EstadoActividad Estado;
	
	
	
	public DTActividadTuristica(ActividadTuristica at) {
		setNombre(at.getNombre());
		setDescripcion(at.getDescripcion());
		setDuracion(at.getDuracion());
		setCostoTurista(at.getCostoTurista());
		setFechaAlta(at.getFechaAlta());
		setCiudad(at.getCiudad());
		setInfoDepartamento(new DTDepartamento(at.getInfoDepartamento()));
		setSalidas(new ArrayList<DTSalidaTuristica>());
		setProveedor(at.getProveedor().getNombre() + " " + at.getProveedor().getApellido());
		setEstado(EstadoActividad.Agregada);
		
		Map<String,SalidaTuristica> map = at.getSalidas();
		
		for(Map.Entry<String, SalidaTuristica> entry : map.entrySet()) {
			DTSalidaTuristica auxISal = new DTSalidaTuristica(entry.getValue());
			InfoSalidas.add(auxISal);
		}
		
		this.InfoPaquetes = new ArrayList<DTPaquete>();
		
		Map<String,Paquete> mapp = at.getPaquetes();
		
		for(Map.Entry<String, Paquete> entry : mapp.entrySet()) {
			DTPaquete auxIPa = new DTPaquete(entry.getValue());
			this.InfoPaquetes.add(auxIPa);
		}
		this.InfoCategorias = new ArrayList<DTCategoria>();
		Map<String,Categoria> categorias = at.getCategorias();
		for(Map.Entry<String, Categoria> entry : categorias.entrySet()) {
			DTCategoria auxIPa = new DTCategoria(entry.getValue());
			this.InfoCategorias.add(auxIPa);
		}
		
		
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
	public DTDepartamento getInfoDepartamento() {
		return InfoDepartamento;
	}
	public void setInfoDepartamento(DTDepartamento infoDepartamento) {
		InfoDepartamento = infoDepartamento;
	}
	public ArrayList<DTSalidaTuristica> getSalidas() {
		return InfoSalidas;
	}
	public void setSalidas(ArrayList<DTSalidaTuristica> salidas) {
		InfoSalidas = salidas;
	}
	public String getProveedor() {
		return Proveedor;
	}
	public void setProveedor(String proveedor) {
		Proveedor = proveedor;
	}
	public ArrayList<DTPaquete> getInfoPaquetes() {
		return InfoPaquetes;
	}
	public void setInfoPaquetes(ArrayList<DTPaquete> infoPaquetes) {
		InfoPaquetes = infoPaquetes;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public LocalDate getFechaAlta() {
		return FechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		FechaAlta = fechaAlta;
	}
	
	public EstadoActividad getEstado() {
		return Estado;
	}

	public void setEstado(EstadoActividad estado) {
		Estado = estado;
	}
	
}
