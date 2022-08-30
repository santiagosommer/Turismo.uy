package ServidorCentral.Logica.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ServidorCentral.Logica.Clases.Inscripcion;
import ServidorCentral.Logica.Clases.SalidaTuristica;
import ServidorCentral.Logica.Clases.Turista;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;

class InscripcionTest {

	private static LocalDate Fecha;
	private static int CantidadTuristas;
	private static float Costo;
	private static Turista turista;
	private static SalidaTuristica SalidaAsociada;

	private static Inscripcion pepitoInscripcion;
	
	
	@BeforeEach
	void setUp() throws Exception {
		Fecha = LocalDate.of(2001, 1, 1);
		CantidadTuristas = 5;
		Costo = 2000;
		turista = new Turista("robertito2", "Roberto", "Carlos", "millondeamigos@email.com", LocalDate.of(1969, 1, 1), "chilena");
		
		SalidaAsociada = new SalidaTuristica("Salida al Recital", CantidadTuristas, Fecha, new DTInfoSalida(LocalDate.of(2022, 8, 29), LocalTime.of(21,0), "Teatro Candombe"));
		pepitoInscripcion = new Inscripcion(Fecha, CantidadTuristas, Costo, SalidaAsociada, turista);
	}

	@Test
	public void getCantidadTuristasTest() {
		int esperado = InscripcionTest.CantidadTuristas;
		
		assertEquals(esperado, pepitoInscripcion.getCantidadTuristas());
	}
	
	@Test
	public void setCantidadTuristasTest() {
		int esperado = InscripcionTest.CantidadTuristas;
		
		pepitoInscripcion.setCantidadTuristas(esperado);
		
		assertEquals(esperado, pepitoInscripcion.getCantidadTuristas());
	}
	
	@Test
	public void getCostoTest() {
		float esperado = InscripcionTest.Costo;
		
		assertEquals(esperado, pepitoInscripcion.getCosto());
	}
	
	@Test
	public void setCostoTests() {
		float esperado = InscripcionTest.Costo;
		
		pepitoInscripcion.setCosto(esperado);
		
		assertEquals(esperado, pepitoInscripcion.getCosto());
	}
	
	@Test
	public void getSalidaAsociada() {
		SalidaTuristica esperado = InscripcionTest.SalidaAsociada;
		
		assertEquals(esperado, pepitoInscripcion.getSalidaAsociada());
	}
	
	@Test
	public void setSalidaAsociada() {
		SalidaTuristica esperado = InscripcionTest.SalidaAsociada;
		
		pepitoInscripcion.setSalidaAsociada(esperado);
		
		assertEquals(esperado, pepitoInscripcion.getSalidaAsociada());
	}

	@Test
	public void getFechaTest() {
		LocalDate esperado = InscripcionTest.Fecha;
		
		assertEquals(esperado, pepitoInscripcion.getFecha());
	}

	@Test
	public void setFechaTest() {
		LocalDate esperado = InscripcionTest.Fecha;
		
		pepitoInscripcion.setFecha(esperado);
		
		assertEquals(esperado, pepitoInscripcion.getFecha());
	}

	@Test
   public void getTuristaTest() {
		Turista esperado = InscripcionTest.turista;
		
		assertEquals(esperado, pepitoInscripcion.getTurista());
	}

   @Test
	public void setTuristaTest() {
		Turista esperado = InscripcionTest.turista;
		
		pepitoInscripcion.setTurista(esperado);
		
		assertEquals(esperado, pepitoInscripcion.getTurista());
	}

}
