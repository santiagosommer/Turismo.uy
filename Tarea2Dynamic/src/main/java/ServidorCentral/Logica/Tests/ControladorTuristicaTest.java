package ServidorCentral.Logica.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Excepciones.CategoriaRepetidaException;
import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;
import ServidorCentral.Logica.Controladores.ControladorTuristica;
import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import ServidorCentral.Logica.DataTypes.DTDepartamento;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;

class ControladorTuristicaTest {
	
	private static ITuristica crTuri;
	private static IUsuario crUsu;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		crTuri = fabrica.getControladorTuristica();
		crUsu = fabrica.getControladorUsuario();
	}
	
	@Test
	void testGetInstancia() {
		ControladorTuristica ct = ControladorTuristica.getInstancia();
		ControladorTuristica ctr = ControladorTuristica.getInstancia();
		assertEquals(ct,ctr);
	}

	@Test
	void testGetDTDepartamento() {
		
		ControladorTuristica ct = ControladorTuristica.getInstancia();
		
		ct.limpiarDepartamentos();
		
		crTuri.crearDepartamento("Montevideo", "pequenio", "www.mvd.com");
		crTuri.seleccionarDepartamento("Montevideo");
		DTDepartamento dep = crTuri.getDTDepartamento();
		DTDepartamento depOk = new DTDepartamento("Montevideo", "pequenio", "www.mvd.com");
		
		assertEquals(dep.getNombre(), depOk.getNombre());
		assertEquals(dep.getDescripcion(), depOk.getDescripcion());
		assertEquals(dep.getURL(), depOk.getURL());
		
	}

	@Test
	void testCrearActividadTuristicaOk() throws UsuarioRepetidoException {
			
		crTuri.crearDepartamento("Rocha", "mediano", "www.rch.com");
		crUsu.altaProveedor("washi", "Washington", "Gomez", "WG.com", LocalDate.of(1989, 10, 1),"contra", "alto", "www.w.com");
		
		try {
			crTuri.crearCategoria("categoria3");
		} catch (CategoriaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<String> categorias = new HashSet<String>();
		categorias.add("categoria3");
		
		try {
			crTuri.crearActividadTuristica("Degusta", "Festival gastronomico de productos locales en Rocha", 3, (float)800, LocalDate.of(2022, 7, 20), "Rocha", "Rocha", "washi", categorias);
			
			crTuri.seleccionarActividad("Degusta");
			DTActividadTuristica act = crTuri.getDTActividadTuristica();
			
			assertEquals(act.getNombre(), "Degusta");
			assertEquals(act.getDescripcion(), "Festival gastronomico de productos locales en Rocha");
			assertEquals(act.getDuracion(), 3);
			boolean costoIgual = (act.getCostoTurista() == (float) 800);
			assert(costoIgual);
			assertEquals(act.getCiudad(), "Rocha");
			assertEquals(act.getInfoDepartamento().getNombre(), "Rocha");
			assertEquals(act.getProveedor(), "Washington" + " " + "Gomez");
			assertEquals(act.getFechaAlta(), LocalDate.of(2022, 7, 20));
		}
		catch (NombreActividadRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
			
		}
		
		assertThrows(NombreActividadRepetidoException.class, () -> {crTuri.crearActividadTuristica("Degusta", "Festival gastronomico de productos locales en Rocha", 3, (float)800, LocalDate.of(2022, 7, 20), "Rocha", "Rocha", "washi",categorias);});

	}

	@Test
	void testCrearSalidaTuristicaOk() {
		DTInfoSalida info = new DTInfoSalida(LocalDate.of(2022,10, 11), LocalTime.of(10, 30), "bosque");
		
		try {
			
			crTuri.crearSalidaTuristica("campamento", 10, LocalDate.of(2022, 8, 27), info, "paseo");
			
			crTuri.seleccionarSalida("campamento");
			DTSalidaTuristica salida = crTuri.getDTSalidaTuristica();
			
			assertEquals(salida.getNombre(), "campamento");
			assertEquals(salida.getCantidadMaxTuristas(),10);
			assertEquals(salida.getFechaAlta(), LocalDate.of(2022, 8, 27));
			assertEquals(salida.getInfoSalida(), info);
			assertEquals(salida.getActividadTuristicaAsoc().getNombre(), "paseo" );
			
		} catch (NombreSalidaRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} catch (NoHayActividadConEseNombreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		assertThrows(NoHayActividadConEseNombreException.class, () -> {crTuri.crearSalidaTuristica("campamento2", 10, LocalDate.of(2022, 8, 27), info, "a");});
		
	}
	
	@Test
	void testCrearSalidaTuristicaRepetidoNombre() {
		
		crTuri.crearDepartamento("Montevideo", "pequenio", "www.mvd.com");
		try {
			crUsu.altaProveedor("Pepecho", "Pepe", "Diaz", "peped.com", LocalDate.of(2000, 10, 1),"contra", "alto", "ww.com");
		} catch (UsuarioRepetidoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			crTuri.crearCategoria("categoria4");
		} catch (CategoriaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<String> categorias = new HashSet<String>();
		categorias.add("categoria4");
		
		try {
			crTuri.crearActividadTuristica("playa", "pasar el dia", 30, (float) 500, LocalDate.of(2022, 8, 28), "pocitos", "Montevideo", "Pepecho", categorias);
		} catch (NombreActividadRepetidoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String nombre = "paseo playa";
		int cant = 20;
		String lugar = "playaHermosa";
		String actividad = "playa";
		LocalDate fecha = LocalDate.of(2022, 8, 28);
		LocalDate fechaS = LocalDate.of(2022,10, 12);
		LocalTime horaS = LocalTime.of(10, 40);
		DTInfoSalida info = new DTInfoSalida(fechaS, horaS, lugar);
		
		try {
			crTuri.crearSalidaTuristica(nombre, cant, fecha, info, actividad);	
		} catch (NombreSalidaRepetidoException | NoHayActividadConEseNombreException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(NombreSalidaRepetidoException.class, () -> {crTuri.crearSalidaTuristica(nombre, cant, fecha, info, actividad);});
		
		
	}

	@Test
	void testListarDepartamentos(){
		
		ControladorTuristica ct = ControladorTuristica.getInstancia();
		
		ct.limpiarDepartamentos();
		
		crTuri.crearDepartamento("Montevideo", "pequenio", "www.mvd.com");
		crTuri.crearDepartamento("Durazno", "grande", "www.dur.com");
		crTuri.crearDepartamento("Salto", "mediano", "www.sto.com");
		crTuri.crearDepartamento("Cerro Largo", "mediano", "www.cl.com");
		crTuri.crearDepartamento("Rocha", "mediano", "www.rch.com");
		
		Set<String> departamentos = crTuri.listarDepartamentos();
		Set<String> depOk = new HashSet<String>();
		depOk.add("Montevideo");
		depOk.add("Durazno");
		depOk.add("Salto");
		depOk.add("Cerro Largo");
		depOk.add("Rocha");
		
		assertEquals(departamentos, depOk);
	}

	@Test
	void testDatosSalidasVigentesOk() throws UsuarioRepetidoException, NombreActividadRepetidoException, NombreSalidaRepetidoException, NoHayActividadConEseNombreException {
		
		crUsu.altaProveedor("Lola", "Lorena", "Paz", "lp.com", LocalDate.of(1999, 10, 1),"contra", "rubia", "www.l.com");
		try {
			crTuri.crearCategoria("categoria5");
		} catch (CategoriaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<String> categorias = new HashSet<String>();
		categorias.add("categoria5");
		crTuri.crearActividadTuristica("shopping", "con gift card", 15, (float) 1000, LocalDate.of(2022, 8, 28), "punta carretas", "Montevideo", "Lola", categorias);
		LocalDate fechaS = LocalDate.of(2022,10, 12);
		LocalTime horaS = LocalTime.of(10, 40);
		String lugar = "puerta shopping";
		DTInfoSalida info = new DTInfoSalida(fechaS, horaS, lugar);
		crTuri.crearSalidaTuristica("zara", 10, LocalDate.of(2022, 8, 28), info, "shopping");
		
		//crTuri.datosSalidasVigentes("shopping");
		
		crTuri.seleccionarSalida("zara");
		Set<DTSalidaTuristica> datos = crTuri.datosSalidasVigentes("shopping");
		
		Set<DTSalidaTuristica> datosOk = new HashSet<DTSalidaTuristica>();
		crTuri.seleccionarSalida("zara");
		DTSalidaTuristica salidaPrueba = crTuri.getDTSalidaTuristica();
		datosOk.add(salidaPrueba);
		
		Iterator<DTSalidaTuristica> i = datos.iterator();
		Iterator<DTSalidaTuristica> j = datosOk.iterator();
		while (i.hasNext()) {
			DTSalidaTuristica salida = i.next();
			DTSalidaTuristica salidaOk = j.next();
			assertEquals(salidaOk.getNombre(), salida.getNombre());
			assertEquals(salidaOk.getCantidadMaxTuristas(), salida.getCantidadMaxTuristas());
			assertEquals(salidaOk.getFechaAlta(), salida.getFechaAlta());
			assertEquals(salidaOk.getInfoSalida(), salida.getInfoSalida());
			assertEquals(salidaOk.getCuposDisponibles(), salida.getCuposDisponibles());
		}
			
	}

	@Test
	void testListarActividadesDeDepartamento() throws NombreActividadRepetidoException, UsuarioRepetidoException {
		
		crTuri.crearDepartamento("Salto", "mediano", "www.sto.com");
		
		crUsu.altaProveedor("Pipi", "Paula", "Lopez", "lopez.com", LocalDate.of(2000, 10, 1),"contra", "alta", "www.com");
		
		try {
			crTuri.crearCategoria("categoria6");
		} catch (CategoriaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<String> categorias = new HashSet<String>();
		categorias.add("categoria6");
		
		crTuri.crearActividadTuristica("paseo", "largo", 30, (float)600, LocalDate.of(2022, 8, 25), "pocitos", "Salto", "Pipi", categorias);
		crTuri.crearActividadTuristica("paseo2", "corto", 10, (float)100, LocalDate.of(2022, 8, 26), "prado", "Salto", "Pipi", categorias);
		crTuri.AceptarActividad("paseo");
		crTuri.AceptarActividad("paseo2");
		Set<String> actividadesDep = crTuri.listarActividadesDeDepartamento("Salto");
		Set<String> actividadesDepOk = new HashSet<String>();
		
		actividadesDepOk.add("paseo");
		actividadesDepOk.add("paseo2");
		
		assertEquals(actividadesDepOk, actividadesDep);
		
	}

	@Test
	void testListarSalidasActividadOk() throws UsuarioRepetidoException, NombreActividadRepetidoException {
		
		crTuri.crearDepartamento("Cerro Largo", "mediano", "www.cl.com");
		crUsu.altaProveedor("Lolo", "Lorenzo", "Lopez", "llopez.com", LocalDate.of(2005, 11, 12),"contra", "alto", "www.lolo.com");
		
		try {
			crTuri.crearCategoria("categoria7");
		} catch (CategoriaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<String> categorias = new HashSet<String>();
		categorias.add("categoria7");
		
		crTuri.crearActividadTuristica("restoran", "amplio", 50, (float)300, LocalDate.of(2022, 8, 2), "pocitos", "Cerro Largo", "Lolo", categorias);
		
		DTInfoSalida info = new DTInfoSalida(LocalDate.of(2022, 10, 25), LocalTime.of(12, 30), "parada");
		try {
			crTuri.crearSalidaTuristica("cena", 6, LocalDate.of(2022, 9, 25), info, "restoran");
			crTuri.crearSalidaTuristica("almuerzo", 10, LocalDate.of(2022, 8, 28), info, "restoran");
			
			Set<String> salidasDeActiv = crTuri.listarSalidasActividad("restoran");
			Set<String> salidasDeActivOk = new HashSet<String>();
			
			salidasDeActivOk.add("cena");
			salidasDeActivOk.add("almuerzo");
			
			assertEquals(salidasDeActiv, salidasDeActivOk);
			
		} catch (NombreSalidaRepetidoException | NoHayActividadConEseNombreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	@Test
	void testListarCategoriasActividad() {
		
		crTuri.crearDepartamento("Rocha", "La Organización de Gestión del Destino (OGD) Rocha es un ámbito de articulación público – privada en el sector turístico que integran la Corporación Rochense de Turismo y la Intendencia de Rocha a través de su Dirección de Turismo." , "www.turismorocha.gub.uy");
		
		
		try {
			crUsu.altaProveedor("washington","Washington","Rocha","washington@turismorocha.gub.uy",LocalDate.of(1970,9,14),"asdfg654","Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha - Uruguay","http://turismorocha.gub.uy/");
		} catch (UsuarioRepetidoException e2) {
			e2.printStackTrace();
		}
		
		try {
			crTuri.crearCategoria("Cultura y Patrimonio");
			crTuri.crearCategoria("Gastronomia");
		} catch (CategoriaRepetidaException e1) {
			e1.printStackTrace();
		}
		String C3 ="Cultura y Patrimonio";
		String C4 ="Gastronomia";
		Set<String> A2 = new HashSet<String>();
		A2.add(C3);
		A2.add(C4);
		try {
			crTuri.crearActividadTuristica("Teatro con Sabores","En el mes aniversario del Club Deportivo Unión de Rocha te invitamos a una merienda deliciosa.",3,500,LocalDate.of(2022,7,21),"Rocha","Rocha","washington",A2);
		} catch (NombreActividadRepetidoException e) {
			e.printStackTrace();
		}
		crTuri.AceptarActividad("Teatro con Sabores");
 		Set<String> generado = crTuri.listarCategoriasActividad("Teatro con Sabores");
		
		Set<String> correcto = new HashSet<String>();
		correcto.add("Cultura y Patrimonio");
		correcto.add("Gastronomia");
		
		assertEquals(correcto,generado);
 		
	}

}
