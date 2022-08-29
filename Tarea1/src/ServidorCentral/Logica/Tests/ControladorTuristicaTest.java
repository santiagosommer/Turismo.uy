package ServidorCentral.Logica.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;

class ControladorTuristicaTest {
	
	private static ITuristica crTuri;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		crTuri = fabrica.getControladorTuristica();
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
		int cupos = 10;
		LocalDate fecha = LocalDate.of(2022, 8, 27);
		LocalDate fechaS = LocalDate.of(2022,10, 11);
		LocalTime horaS = LocalTime.of(10, 30);
		DTInfoSalida info = new DTInfoSalida(fechaS, horaS, lugar);
		
		try {
			crTuri.crearSalidaTuristica(nombre, cant, fecha, info, cupos);
			
			crTuri.seleccionarSalida(nombre);
			DTSalidaTuristica salida = crTuri.getDTSalidaTuristica();
			
			assertEquals(salida.getNombre(), nombre);
			assertEquals(salida.getCantidadMaxTuristas(),cant);
			assertEquals(salida.getFechaAlta(), fecha);
			assertEquals(salida.getInfoSalida(), info);
			assertEquals(salida.getCuposDisponibles(), cupos);
			
		} catch (NombreSalidaRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}	
	}
	
	@Test
	void testCrearSalidaTuristicaRepetidoNombre() {
		String nombre = "playa";
		int cant = 20;
		String lugar = "playaHermosa";
		int cupos = 20;
		LocalDate fecha = LocalDate.of(2022, 8, 28);
		LocalDate fechaS = LocalDate.of(2022,10, 12);
		LocalTime horaS = LocalTime.of(10, 40);
		DTInfoSalida info = new DTInfoSalida(fechaS, horaS, lugar);
		
		try {
			crTuri.crearSalidaTuristica(nombre, cant, fecha, info, cupos);	
		} catch (NombreSalidaRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}
		assertThrows(NombreSalidaRepetidoException.class, () -> {crTuri.crearSalidaTuristica(nombre, cant, fecha, info, cupos);});
		
	}

	@Test
	void testListarDepartamentos() {
		//fail("Not yet implemented");
	}

	@Test
	void testDatosSalidasVigentes() {
		//fail("Not yet implemented");
	}

	@Test
	void testListarActividadesDeDepartamento() {
		//fail("Not yet implemented");
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
