package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Paquete;
import ServidorCentral.Logica.Clases.SalidaTuristica;

public class DTActividadTuristica {
	private String Nombre;
	private String Descripcion;
	private int Duracion;
	private float CostoTurista;
	private LocalDate FechaAlta;
	private DTDepartamento InfoDepartamento;
	private ArrayList<DTSalidaTuristica> InfoSalidas;
	private DTProveedor Proveedor;
	private ArrayList<DTPaquete> InfoPaquetes;
	private String Ciudad;
	
	public DTActividadTuristica(String nombre,String descripcion,int duracion,float costoTurista,
			LocalDate fechaAlta,DTDepartamento infoDepartamento,
			DTProveedor proveedor,String ciudad) {
		Nombre = nombre;
		Descripcion = descripcion;
		Duracion = duracion;
		CostoTurista = costoTurista;
		FechaAlta = fechaAlta;
		InfoDepartamento = infoDepartamento;
		InfoSalidas = new ArrayList<DTSalidaTuristica>();
		Proveedor = proveedor;
		InfoPaquetes = new ArrayList<DTPaquete>();
		Ciudad = ciudad;
		
		
		
	}
	public DTActividadTuristica(ActividadTuristica at) {
		Nombre = at.getNombre();
		Descripcion = at.getDescripcion();
		Duracion = at.getDuracion();
		CostoTurista = at.getCostoTurista();
		FechaAlta = at.getFechaAlta();
		Ciudad = at.getCiudad();
		InfoDepartamento = new DTDepartamento(at.getInfoDepartamento());
		InfoSalidas = new ArrayList<DTSalidaTuristica>();
		
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
	public DTProveedor getProveedor() {
		return Proveedor;
	}
	public void setProveedor(DTProveedor proveedor) {
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
	
}
