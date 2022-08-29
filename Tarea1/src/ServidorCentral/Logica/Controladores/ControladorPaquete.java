package ServidorCentral.Logica.Controladores;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Departamento;
import ServidorCentral.Logica.Clases.Paquete;
import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.Clases.SalidaTuristica;
import ServidorCentral.Logica.Excepciones.NombrePaqueteRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;


public class ControladorPaquete implements IPaquete {
    private Paquete PaqueteSeleccionado;
	private Map<String, Paquete> Paquetes;
	
	private static ControladorPaquete instancia = null;
	
	public static ControladorPaquete getInstancia() {
		if (instancia == null) {
			instancia = new ControladorPaquete();
		}
		return instancia;
	}
	
	private ControladorPaquete() {
		setPaquetes(new HashMap<String,Paquete>());
		PaqueteSeleccionado = null;
				
	}
	
	@Override
	public void crearPaquete(String nombrePaque, String descripcion, 
			int periodoValidez,int Descuento, LocalDate fechaAlta) throws NombrePaqueteRepetidoException {
		if (Paquetes.containsKey(nombrePaque)) {
			throw new NombrePaqueteRepetidoException("Ya existe un paquete con nombre" + nombrePaque);
		}else {
			Paquete nuevo = new Paquete(nombrePaque,descripcion, periodoValidez,Descuento,fechaAlta);
			Paquetes.put(nombrePaque, nuevo);
		}
		
		
	}
	
	@Override
	public void seleccionarPaquete(String paquete) {
		if (existePaquete(paquete)) {
			PaqueteSeleccionado = Paquetes.get(paquete);
		}
		
	}
	
	@Override
	public boolean existePaquete(String paquete) {
		
		return Paquetes.containsKey(paquete);
	}
	
	@Override
	public Set<String> listarPaquetes() {
		
		Set<String> res = new HashSet<String>();
		Paquetes.forEach((k,v)->res.add(k)); 
		return res;
		
	}
	
	public Set<String>  listarActividadesAAgregar(String departamento) { //segun departamento, que no formen parte de paquete
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		Set<String> actividadesDepto = crTuristica.listarActividadesDeDepartamento(departamento);
		
		if (!actividadesDepto.isEmpty()) {
			Set<String> lista = new HashSet<String>();
			Map<String, Paquete> paquetes = instancia.Paquetes;
			Map<String, ActividadTuristica> actividadesDePauete = PaqueteSeleccionado.getActividadesTuristicas();
			for(String actividad: actividadesDepto) {
				if (!actividadesDePauete.containsKey(actividad)) {
					lista.add(actividad);
				}
			}
			return lista;
		} else 	return null;
	 }

	public Map<String, Paquete> getPaquetes() {
		return Paquetes;
	}

	public void setPaquetes(Map<String, Paquete> paquetes) {
		Paquetes = paquetes;
	}

	
	public Paquete getPaqueteSeleccionado() {
		return PaqueteSeleccionado;
	}

	public void setPaqueteSeleccionado(Paquete paqueteSeleccionado) {
		PaqueteSeleccionado = paqueteSeleccionado;
	}

	@Override
	public DTPaquete getDtPaquete() {
		// TODO Auto-generated method stub
		if (PaqueteSeleccionado!= null) {
			return new DTPaquete(PaqueteSeleccionado.getNombre(),PaqueteSeleccionado.getDescripcion(),PaqueteSeleccionado.getPeriodoValidez(),PaqueteSeleccionado.getDescuento());

		}
		else {
		return null;
		}
	}

	
	
	
	
	public void AgregarActividadPaquete(String paquete, String actividad) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		crTuristica.seleccionarActividad(actividad);
		ActividadTuristica a = crTuristica.getActividadSeleccionada();	
		seleccionarPaquete(paquete);
		Paquete p = PaqueteSeleccionado;
		
		Map<String,Paquete> paquetesDeA = a.getPaquetes(); //link de a a p
		paquetesDeA.put(paquete, p);
		a.setPaquetes(paquetesDeA);
		
		Map<String,ActividadTuristica> actividadesDeP = p.getActividadesTuristicas(); //link de p a a
		actividadesDeP.put(actividad, a);
		p.setActividadesTuristicas(actividadesDeP);
	}

	@Override
	public Set<String> listarActividadesPaquete() {
		if (PaqueteSeleccionado!= null)
			return PaqueteSeleccionado.listarActividades();
		else {
			Set<String> res = new HashSet<String>();
			return res;
			
		}
		// TODO Auto-generated method stub
		
	}	

	
}
