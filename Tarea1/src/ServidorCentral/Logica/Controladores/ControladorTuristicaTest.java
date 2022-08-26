package ServidorCentral.Logica.Controladores;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ServidorCentral.Logica.Clases.SalidaTuristica;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;

class ControladorTuristicaTest {

	private static ITuristica controlador;
	private static DTInfoSalida validDt;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Fabrica fabrica = Fabrica.getInstance();
	    controlador = fabrica.getControladorTuristica();
	    LocalDate f = LocalDate.of(2022, 10, 5);
	    LocalTime t = LocalTime.of(12, 0);
	    validDt = new DTInfoSalida(f, t, "lugar");
		
		
	}

	@Test
	void testSeleccionarActividad() {
		fail("Not yet implemented");
		
		
	}

	@Test
	void testSeleccionarSalida() {
		fail("Not yet implemented");
	}

	@Test
	void testSeleccionarDepartemento() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDTActividadTuristica() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDTSalidaTuristica() {
		fail("Not yet implemented");
	}

	@Test
	void testCrearActividadTuristica() {
		fail("Not yet implemented");
	}

	@Test
	void testCrearSalidaTuristicaOK()  {
		try {
	  LocalDate now = LocalDate.now();
	 controlador.crearSalidaTuristica("nom", 4, now, validDt,4);
	  
		controlador.seleccionarSalida("nom");
		DTSalidaTuristica salida1 = controlador.getDTSalidaTuristica();
		assertEquals(now,salida1.getFechaAlta());
		assertEquals(validDt.getFecha(), salida1.getInfoSalida().getFecha());
	} catch(NombreSalidaRepetidoException e) {
		
		
		fail(e.getMessage());
		e.printStackTrace();
	 }
	}
		
			
		
	

	@Test
	void testListarDepartamentos() {
		fail("Not yet implemented");
	}

	@Test
	void testDatosSalidasVigentes() {
		fail("Not yet implemented");
	}

	@Test
	void testListarActividadesDeDepartamento() {
		fail("Not yet implemented");
	}

	@Test
	void testListarSalidasActividad() {
		fail("Not yet implemented");
	}

	@Test
	void testExisteActividad() {
		fail("Not yet implemented");
	}

	@Test
	void testExisteSalidaStringString() {
		fail("Not yet implemented");
	}

	@Test
	void testExisteDepartamento() {
		fail("Not yet implemented");
	}

	@Test
	void testCrearDepartamento() {
		fail("Not yet implemented");
	}

	@Test
	void testExisteSalidaString() {
		fail("Not yet implemented");
	}

}
