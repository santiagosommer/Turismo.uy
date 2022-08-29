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
import ServidorCentral.Logica.Excepciones.DepartamentoNoExisteException;
import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;
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
	}

	@Test
	void testCrearActividadTuristica() {
		//fail("Not yet implemented");
	}

	@Test
	void testCrearSalidaTuristicaOk() {
		String nombre = "campamento";
		int cant = 10;
		String lugar = "bosque";
		String actividad = "paseo";
		LocalDate fecha = LocalDate.of(2022, 8, 27);
		LocalDate fechaS = LocalDate.of(2022,10, 11);
		LocalTime horaS = LocalTime.of(10, 30);
		DTInfoSalida info = new DTInfoSalida(fechaS, horaS, lugar);
		
		try {
			crTuri.crearSalidaTuristica(nombre, cant, fecha, info, actividad);
			
			crTuri.seleccionarSalida(nombre);
			DTSalidaTuristica salida = crTuri.getDTSalidaTuristica();
			
			assertEquals(salida.getNombre(), nombre);
			assertEquals(salida.getCantidadMaxTuristas(),cant);
			assertEquals(salida.getFechaAlta(), fecha);
			assertEquals(salida.getInfoSalida(), info);
			assertEquals(salida.getActividadTuristicaAsoc().getNombre(), actividad );
			
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
	void testListarDepartamentos() throws DepartamentoNoExisteException {
		
		crTuri.crearDepartamento("Montevideo", "pequenio", "www.mvd.com");
		crTuri.crearDepartamento("Durazno", "grande", "www.dur.com");
		crTuri.crearDepartamento("Salto", "mediano", "www.sto.com");
		
		Set<String> departamentos = crTuri.listarDepartamentos();
		Set<String> depOk = new HashSet<String>();
		depOk.add("Montevideo");
		depOk.add("Durazno");
		depOk.add("Salto");
		
		assertEquals(departamentos, depOk);
	}

	@Test
	void testDatosSalidasVigentes() {
		//fail("Not yet implemented");
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
	void testListarSalidasActividad() {
		//fail("Not yet implemented");
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
