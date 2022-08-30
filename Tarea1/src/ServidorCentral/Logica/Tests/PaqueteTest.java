package ServidorCentral.Logica.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Paquete;

class PaqueteTest {

		private static String Nombre;
		private static String Descripcion;
		private static int PeriodoValidez;
		private static int Descuento;
		private static LocalDate FechaAlta;
		private static Map<String, ActividadTuristica> ActividadesTuristicas;
		
		private static Paquete paquetePrueba;

	@BeforeEach
	void setUp() throws Exception {
		Nombre = "Pepito";
		Descripcion = "Pepito Descripcion";
		PeriodoValidez = 30;
		Descuento = 30;
		FechaAlta = LocalDate.of(2001, 1, 1);
		ActividadesTuristicas = new HashMap<String, ActividadTuristica>();
		
		paquetePrueba = new Paquete(Nombre, Descripcion, PeriodoValidez, Descuento, FechaAlta);
	}
	
	@Test
	 public void getNombreTest() {
		String esperado = PaqueteTest.Nombre;
		
		assertEquals(esperado, paquetePrueba.getNombre());
	}
	
	@Test
	 public void setNombreTest() {
		String esperado = PaqueteTest.Nombre;
		
		paquetePrueba.setNombre(esperado);
		
		assertEquals(esperado, paquetePrueba.getNombre());
	}
	 
	 @Test
	 public void getDescripcionTest() {
		String esperado = PaqueteTest.Descripcion;
		
		assertEquals(esperado, paquetePrueba.getDescripcion());
	}
	 
	 @Test
	 public void setDescripcionTest() {
		String esperado = PaqueteTest.Descripcion;
		
		paquetePrueba.setDescripcion(esperado);
		
		assertEquals(esperado, paquetePrueba.getDescripcion());
	}
	 
	 @Test
	 public void getPeriodoValidezTest() {
		int esperado = PaqueteTest.PeriodoValidez;
		
		assertEquals(esperado, paquetePrueba.getPeriodoValidez());
	}
	 
	 @Test
	 public void setPeriodoValidezTest() {
		int esperado = PaqueteTest.PeriodoValidez;
		
		paquetePrueba.setPeriodoValidez(esperado);
		
		assertEquals(esperado, paquetePrueba.getPeriodoValidez());
	}
	 
	 @Test
	 public void getDescuentoTest() {
		int esperado = PaqueteTest.Descuento;
		
		assertEquals(esperado, paquetePrueba.getDescuento());
	}
	 
	 @Test
	 public void setDescuentoTest() {
		int esperado = PaqueteTest.Descuento;
		
		paquetePrueba.setDescuento(esperado);
		
		assertEquals(esperado, paquetePrueba.getDescuento());
	}

	@Test
	public void getActividadesTuristicasTest() {
		Map<String,ActividadTuristica> esperado = PaqueteTest.ActividadesTuristicas;
		
		assertEquals(esperado, paquetePrueba.getActividadesTuristicas());		
	}

	@Test
	public void setActividadesTuristicasTest() {
		Map<String,ActividadTuristica> esperado = PaqueteTest.ActividadesTuristicas;
		
		paquetePrueba.setActividadesTuristicas(esperado);
		
		assertEquals(esperado, paquetePrueba.getActividadesTuristicas());
	}

	@Test
	public void getFechaAltaTest() {
		LocalDate esperado = PaqueteTest.FechaAlta;

		assertEquals(esperado, paquetePrueba.getFechaAlta());
	}

	@Test
	public void setFechaAltaTest() {
		LocalDate esperado = PaqueteTest.FechaAlta;
		
		paquetePrueba.setFechaAlta(esperado);
		
		assertEquals(esperado, paquetePrueba.getFechaAlta());
	}
	
	@Test
	public void listarActividadesEmptyTest(){
		Set<String> esperado = new HashSet<String>();
		
		paquetePrueba.setActividadesTuristicas(PaqueteTest.ActividadesTuristicas);
		
		assertEquals(esperado, paquetePrueba.listarActividades());		
	}
	
	@Test
	public void listarActividadesThingsTest(){
		ActividadTuristica at = new ActividadTuristica("Roberto", "Descripcion", 1, 1, LocalDate.of(2001, 1, 1), null, "Algo", null);
		Map<String,ActividadTuristica> mapAt = new HashMap<>();
		mapAt.put(at.getNombre(), at);
		
		Set<String> esperado = new HashSet<String>();
		esperado.add(at.getNombre());
		
		paquetePrueba.setActividadesTuristicas(mapAt);
		
		assertEquals(esperado, paquetePrueba.listarActividades());	
	}

}
