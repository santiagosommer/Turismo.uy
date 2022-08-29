package ServidorCentral.Logica.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.security.cert.TrustAnchor;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;

import EstacionDeTrabajo.GUI.AltaDeProveedor;
import EstacionDeTrabajo.GUI.CargaDeDatos;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;

import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;

import ServidorCentral.Logica.DataTypes.DTActividadTuristica;

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

	/*@Test
	void testSeleccionarActividad() {
		//fail("Not yet implemented");
	}

	@Test
	void testSeleccionarSalida() {
		//fail("Not yet implemented");
	}

	@Test
	void testSeleccionarDepartamento() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetDTDepartamento() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetDTActividadTuristica() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetDTSalidaTuristica() {
		//fail("Not yet implemented");
	}*/

	@Test
	void testCrearActividadTuristicaOk() throws UsuarioRepetidoException {
			
		crTuri.crearDepartamento("Rocha", "mediano", "www.rch.com");
		crUsu.altaProveedor("washi", "Washington", "Gomez", "WG.com", LocalDate.of(1989, 10, 1), "alto", "www.w.com");
		
		try {
			crTuri.crearActividadTuristica("Degusta", "Festival gastronomico de productos locales en Rocha", 3, (float)800, LocalDate.of(2022, 7, 20), "Rocha", "Rocha", "washi");
			
			crTuri.seleccionarActividad("Degusta");
			DTActividadTuristica act = crTuri.getDTActividadTuristica();
			
			assertEquals(act.getNombre(), "Degusta");
			assertEquals(act.getDescripcion(), "Festival gastronomico de productos locales en Rocha");
			assertEquals(act.getDuracion(), 3);
			assertEquals(act.getCostoTurista(), (float)800);
			assertEquals(act.getCiudad(), "Rocha");
			assertEquals(act.getInfoDepartamento().getNombre(), "Rocha");
			assertEquals(act.getProveedor(), "Washington" + " " + "Gomez");
			assertEquals(act.getFechaAlta(), LocalDate.of(2022, 7, 20));
		}
		catch (NombreActividadRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
			
		}

	}

	@Test
	void testCrearSalidaTuristicaOk() {
		
		try {
			
			DTInfoSalida info = new DTInfoSalida(LocalDate.of(2022,10, 11), LocalTime.of(10, 30), "bosque");
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
	}
	
	@Test
	void testCrearSalidaTuristicaRepetidoNombre() {
		
		crTuri.crearDepartamento("Montevideo", "pequenio", "www.mvd.com");
		try {
			crUsu.altaProveedor("Pepecho", "Pepe", "Diaz", "peped.com", LocalDate.of(2000, 10, 1), "alto", "ww.com");
		} catch (UsuarioRepetidoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			crTuri.crearActividadTuristica("playa", "pasar el dia", 30, (float) 500, LocalDate.of(2022, 8, 28), "pocitos", "Montevideo", "Pepecho");
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
		
		crUsu.altaProveedor("Lola", "Lorena", "Paz", "lp.com", LocalDate.of(1999, 10, 1), "rubia", "www.l.com");
		crTuri.crearActividadTuristica("shopping", "con gift card", 15, (float) 1000, LocalDate.of(2022, 8, 28), "punta carretas", "Montevideo", "Lola");
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
		DTSalidaTuristica salida = crTuri.getDTSalidaTuristica();
		datosOk.add(salida);
		
		assertEquals(datos, datosOk);
	}

	@Test
	void testListarActividadesDeDepartamento() throws NombreActividadRepetidoException, UsuarioRepetidoException {
		
		crTuri.crearDepartamento("Salto", "mediano", "www.sto.com");
		
		crUsu.altaProveedor("Pipi", "Paula", "Lopez", "lopez.com", LocalDate.of(2000, 10, 1), "alta", "www.com");
		
		crTuri.crearActividadTuristica("paseo", "largo", 30, (float)600, LocalDate.of(2022, 8, 25), "pocitos", "Salto", "Pipi");
		crTuri.crearActividadTuristica("paseo2", "corto", 10, (float)100, LocalDate.of(2022, 8, 26), "prado", "Salto", "Pipi");
		
		Set<String> actividadesDep = crTuri.listarActividadesDeDepartamento("Salto");
		Set<String> actividadesDepOk = new HashSet<String>();
		
		actividadesDepOk.add("paseo");
		actividadesDepOk.add("paseo2");
		
		assertEquals(actividadesDep, actividadesDepOk);
		
	}

	@Test
	void testListarSalidasActividadOk() throws UsuarioRepetidoException, NombreActividadRepetidoException {
		
		crTuri.crearDepartamento("Cerro Largo", "mediano", "www.cl.com");
		crUsu.altaProveedor("Lolo", "Lorenzo", "Lopez", "llopez.com", LocalDate.of(2005, 11, 12), "alto", "www.lolo.com");
		crTuri.crearActividadTuristica("restoran", "amplio", 50, (float)300, LocalDate.of(2022, 8, 2), "pocitos", "Cerro Largo", "Lolo");
		
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
	void testExisteActividad() {
		//fail("Not yet implemented");
	}

	@Test
	void testExisteDepartamento() {
		//fail("Not yet implemented");
	}

	@Test
	void testCrearDepartamento() {
		//fail("Not yet implemented");
	}

	@Test
	void testExisteSalida() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetActividadSeleccionada() {
		//fail("Not yet implemented");
	}

	@Test
	void testGetSalidaSeleccionada() {
		//fail("Not yet implemented");
	}

}
