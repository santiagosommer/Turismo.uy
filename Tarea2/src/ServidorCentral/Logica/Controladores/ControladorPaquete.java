package ServidorCentral.Logica.Controladores;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Categoria;
import ServidorCentral.Logica.Clases.Paquete;
import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.Excepciones.NombrePaqueteRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;


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
	
	public void reset() {
		setPaquetes(new HashMap<String,Paquete>());
		PaqueteSeleccionado = null;
	}
	
	
	
	public Set<String> listarCategoriasPaquete(String paquete){
		
		Set<String> lista = new HashSet<String>();
		
		boolean existe = Paquetes.containsKey(paquete);
		if (existe) {
			Paquete paq = Paquetes.get(paquete);
			Map<String, Categoria> categorias = paq.getCategorias();
			
			String nombreCategoria;	
			for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {	
				nombreCategoria = entry.getKey();
			    lista.add(nombreCategoria);
			}
			
		} 
		return lista;
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
		Fabrica fabrica  = Fabrica.getInstance();
		ITuristica crTuristica = fabrica.getControladorTuristica();
		Set<String> actividadesDepto = crTuristica.listarActividadesDeDepartamento(departamento);
		
		
		Set<String> lista = new HashSet<String>();
		if (actividadesDepto!= null && !actividadesDepto.isEmpty()) {
			
			Map<String, ActividadTuristica> actividadesDePauete = PaqueteSeleccionado.getActividadesTuristicas();
			
		
			for(String actividad: actividadesDepto) {
				if (!actividadesDePauete.containsKey(actividad)) {
					lista.add(actividad);
			}
			}
		}
		
			return lista;
		
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
			return new DTPaquete(PaqueteSeleccionado.getNombre(),PaqueteSeleccionado.getDescripcion(),
					PaqueteSeleccionado.getPeriodoValidez(),PaqueteSeleccionado.getDescuento(),
					PaqueteSeleccionado.getFechaAlta());

		}
		else {
		return null;
		}
	}

	
	public void AgregarActividadPaquete(String paquete, String actividad) {
		ControladorTuristica crTuristica = ControladorTuristica.getInstancia();
		crTuristica.seleccionarActividad(actividad);
		seleccionarPaquete(paquete);
		Paquete p = PaqueteSeleccionado;
		
		ActividadTuristica a = crTuristica.getActividadSeleccionada();	
		Map<String,Categoria> categorias = a.getCategorias(); //agregar categorias a paquete
		for (Map.Entry<String, Categoria> entry : categorias.entrySet()) {	
			
			Map<String,Categoria> categoriasPaq =  p.getCategorias();
			
			if (!categoriasPaq .containsKey(entry.getKey())){ 
				categoriasPaq .put(entry.getKey(), entry.getValue());
			}
			
			//Agrego el link entre el paquete y la categoria
			Map<String,Paquete> paquetesCategoria = entry.getValue().getPaquetes();
			if (!paquetesCategoria.containsKey(paquete)) {
				paquetesCategoria.put(paquete, p); 
			}
			
		}
		
		
		Map<String,Paquete> paquetesDeA = a.getPaquetes(); //link de a a p
		paquetesDeA.put(paquete, p);
		
		
		Map<String,ActividadTuristica> actividadesDeP = p.getActividadesTuristicas(); //link de p a a
		actividadesDeP.put(actividad, a);
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
	@Override
	public Set<DTPaquete> infoPaquetes() {
		
		Set<DTPaquete> lista = new HashSet<DTPaquete>();
		for (Map.Entry<String, Paquete> entry : Paquetes.entrySet()) {
			   lista.add(new DTPaquete(entry.getValue()));
			
		}
		return lista;
	}	
	
}
