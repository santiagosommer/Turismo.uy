package ServidorCentral.Logica.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import EstacionDeTrabajo.GUI.CrearPaqueteDeActividadesTuristicas;
import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Excepciones.NombrePaqueteRepetidoException;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;

class ControladorPaqueteTest {

	private static IPaquete crPaq;
	private static IUsuario crUsuario;
	private static ITuristica crTuri;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Fabrica fabrica = Fabrica.getInstance();
		crPaq = fabrica.getControladorPaquete();
		crTuri = fabrica.getControladorTuristica();
		crUsuario = fabrica.getControladorUsuario();
		
		
		
			
		
	}

	@Test
	void testCrearPaqueteOk() {
		
		String nombrePaque = "paq1";
		String descripcion = "Esto es una descripcion";
		int periodoValidez = 5;
		int Descuento = 20;
		LocalDate fechaAlt = LocalDate.now();
		try {
			
			crPaq.crearPaquete(nombrePaque, descripcion, periodoValidez, Descuento, fechaAlt);
			crPaq.seleccionarPaquete(nombrePaque);
		
			DTPaquete  paq= crPaq.getDtPaquete();
			
			assertEquals(paq.getNombre(), nombrePaque);
			assertEquals(paq.getDescripcion(), descripcion);
			assertEquals(paq.getPeriodoValidez(), periodoValidez);
			assertEquals(paq.getDescuento(), Descuento);
			assertEquals(paq.getFechaAlta(), fechaAlt);
					
		} catch (NombrePaqueteRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}	
	}
	
	@Test
	void testCrearPaqueteNombreRepetido() {
		
		String nombrePaque = "paq2";
		String descripcion = "Esto es una descripcion";
		int periodoValidez = 5;
		int Descuento = 20;
		LocalDate fechaAlt = LocalDate.now();
		
		try {
			
			crPaq.crearPaquete(nombrePaque, descripcion, periodoValidez, Descuento, fechaAlt);
			crPaq.crearPaquete(nombrePaque, descripcion, periodoValidez, 5, fechaAlt);
		
					
		} catch (NombrePaqueteRepetidoException e) {
			fail(e.getMessage());
			e.printStackTrace();
		}	
		
		assertThrows(NombrePaqueteRepetidoException.class, () -> {crPaq.crearPaquete(nombrePaque, descripcion, periodoValidez, 5, fechaAlt);;});
	}
	
	

	@Test
	void testListarPaquetes() {
		
		
		fail("Not yet implemented");
		
	}

	@Test
	void testListarActividadesAAgregar() {
		
		
		
		fail("Not yet implemented");
	}

	@Test
	void testGetDtPaquete() {
		fail("Not yet implemented");
	}

	@Test
	void testAgregarActividadPaqueteOK() {
		
		crTuri.crearDepartamento("Maldonado", "descripcion", "maldonado.com.uy");
		LocalDate date = LocalDate.of(1992, 3, 5);
		try {
			crUsuario.altaProveedor("prov", "juan", "pedro", "rodr", date, "descri", "www.juan.org");
		} catch (UsuarioRepetidoException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		crUsuario.seleccionarProveedor("prov");
		String nombrePaque = "paq3";
		String descripcion = "Esto es una descripcion";
		int periodoValidez = 5;
		int Descuento = 20;
		LocalDate fechaAlt = LocalDate.now();
		try {
			crPaq.crearPaquete(nombrePaque, descripcion, periodoValidez, Descuento, fechaAlt);
		} catch (NombrePaqueteRepetidoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			crTuri.crearActividadTuristica(nombrePaque, descripcion, 
					periodoValidez, Descuento, fechaAlt, descripcion,
					"Maldonado", "prov");
		} catch (NombreActividadRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		crTuri.seleccionarDepartamento("Maldonado");
		crPaq.seleccionarPaquete(nombrePaque);
		crPaq.AgregarActividadPaquete(nombrePaque, nombrePaque);
		
		
		
		Iterator<DTActividadTuristica> iterator = crPaq.getDtPaquete().getActividadesTuristicas().iterator();
		DTActividadTuristica actividadTuristica = (DTActividadTuristica) iterator.next();
		assertEquals( nombrePaque,actividadTuristica.getNombre());

		
		
		
		fail("Not yet implemented");
	}

	@Test
	void testListarActividadesPaquete() {
		
		
		
		
	}

}
