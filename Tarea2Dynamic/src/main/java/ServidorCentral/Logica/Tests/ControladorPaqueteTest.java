package ServidorCentral.Logica.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ServidorCentral.Logica.Controladores.ControladorPaquete;
import ServidorCentral.Logica.Controladores.ControladorTuristica;
import ServidorCentral.Logica.Controladores.ControladorUsuario;
import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.Excepciones.CategoriaRepetidaException;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Excepciones.NombrePaqueteRepetidoException;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.CargaDeDatos;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;

class ControladorPaqueteTest {

	private static IPaquete crPaq;
	private static IUsuario crUsuario;
	private static ITuristica crTuri;
	
	
	@BeforeAll
	static void setUpBeforeClass() {
		Fabrica fabrica = Fabrica.getInstance();
		crPaq = fabrica.getControladorPaquete();
		crTuri = fabrica.getControladorTuristica();
		crUsuario = fabrica.getControladorUsuario();
	}
	
	@BeforeEach
	void setUp() {
		ControladorPaquete.getInstancia().reset();
		ControladorTuristica.getInstancia().reset();
 		ControladorUsuario.getInstancia().reset();
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
		
					
		} catch (NombrePaqueteRepetidoException e) {
			e.printStackTrace();
		}	
		
		assertThrows(NombrePaqueteRepetidoException.class, () -> {crPaq.crearPaquete(nombrePaque, descripcion, periodoValidez, 5, fechaAlt);});
	}

	@Test
	void testListarActividadesAAgregar() {
		
		crTuri.crearDepartamento("Montevideo", "descripcion", "montevideo.com.uy");
		
		try {
			crUsuario.altaProveedor("prove", "juan", "pedro", "email", LocalDate.of(1992, 3, 5), "contra", "algo", "www.juan.org");
		} catch (UsuarioRepetidoException e2) {
			e2.printStackTrace();
		}
		
		crUsuario.seleccionarProveedor("prove");
		String nombrePaque = "paq4";
		String descripcion = "Esto es una descripcion";
		int periodoValidez = 5;
		int Descuento = 20;
		LocalDate fechaAlt = LocalDate.now();
		
		try {
			crPaq.crearPaquete(nombrePaque, descripcion, periodoValidez, Descuento, fechaAlt);
		} catch (NombrePaqueteRepetidoException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			crTuri.crearCategoria("categoria1");
		} catch (CategoriaRepetidaException e1) {
			e1.printStackTrace();
		}
		Set<String> categorias = new HashSet<String>();
		categorias.add("categoria1");
		
		try {
			crTuri.crearActividadTuristica(nombrePaque, descripcion, 
					periodoValidez, Descuento, fechaAlt, descripcion,
					"Montevideo", "prove", categorias);
		} catch (NombreActividadRepetidoException e) {
			e.printStackTrace();
		}
		
		crTuri.seleccionarDepartamento("Montevideo");
		crPaq.seleccionarPaquete(nombrePaque);
		Set<String> lstaSet =  crPaq.listarActividadesAAgregar("Montevideo");
		Boolean boolOk = false;
		if (lstaSet != null) {
			boolOk = true;
		}
		assertTrue(boolOk);
	
	}


	@Test
	void testAgregarActividadPaqueteOK() {
		
		
		crTuri.crearDepartamento("Maldonado", "descripcion", "maldonado.com.uy");
		
		LocalDate date = LocalDate.of(1992, 3, 5);
		try {
			crUsuario.altaProveedor("prov", "juan", "pedro", "rodr", date, "contra", "descri", "www.juan.org");
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
			crTuri.crearCategoria("categoria2");
		} catch (CategoriaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<String> categorias = new HashSet<String>();
		categorias.add("categoria2");
		
		try {
			crTuri.crearActividadTuristica(nombrePaque, descripcion, 
					periodoValidez, Descuento, fechaAlt, descripcion,
					"Maldonado", "prov",categorias);
		} catch (NombreActividadRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		crTuri.seleccionarDepartamento("Maldonado");
		crPaq.seleccionarPaquete(nombrePaque);
		crPaq.AgregarActividadPaquete(nombrePaque, nombrePaque);
		
		
		Set<String> actividades = crPaq.listarActividadesPaquete();
		//ArrayList<DTActividadTuristica> actividades = crPaq.getDtPaquete().getActividadesTuristicas();
		
		Boolean boolOk = false;
		if (actividades!= null && !actividades.isEmpty()) {
			boolOk = true;
		}
		assertTrue(boolOk);
	

		
		
		
		
	}

	@Test
	void testListarActividadesPaquete() {
		
		
		
		
	}

	
	@Test
	void testListarCategoriasPaquete() {
		try {
			CargaDeDatos cd = CargaDeDatos.getInstancia();
			cd.setYaCargo(false);
			cd.cargarDatos();
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();
		}
		Set<String> generado = crPaq.listarCategoriasPaquete("Disfrutar Rocha");
		
		Set<String> correcto = new HashSet<String>();
		correcto.add("Cultura y Patrimonio");
		correcto.add("Gastronomia");
		
		assertEquals(generado,correcto);
	
	}
}
