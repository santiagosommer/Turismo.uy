package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;

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
			LocalDate fechaAlta,DTDepartamento infoDepartamento,ArrayList<DTSalidaTuristica> salidas,
			DTProveedor proveedor, ArrayList<DTPaquete> infoPaquetes,String ciudad) {
		Nombre = nombre;
		Descripcion = descripcion;
		Duracion = duracion;
		CostoTurista = costoTurista;
		FechaAlta = fechaAlta;
		InfoDepartamento = infoDepartamento;
		InfoSalidas = salidas;
		Proveedor = proveedor;
		InfoPaquetes = infoPaquetes;
		Ciudad = ciudad;
		
		
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
