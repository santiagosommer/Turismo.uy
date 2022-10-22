package ServidorCentral.Logica.Tests;

import static org.junit.Assert.assertEquals;
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
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.DataTypes.DTInscripcion;
import ServidorCentral.Logica.DataTypes.DTProveedor;
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.DataTypes.EstadoError;
import ServidorCentral.Logica.DataTypes.EstadoSesion;
import ServidorCentral.Logica.Excepciones.CategoriaRepetidaException;
import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Excepciones.UsuarioNoExisteException;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Excepciones.YaExisteInscripcionTuristaSalida;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.CargaDeDatos;
import ServidorCentral.Logica.Interfaces.IUsuario;

class ControladorUsuarioTest {

	private static IUsuario ctrU;
	
	
	@BeforeAll
	static void setUpBeforeClass() {
		Fabrica fabrica = Fabrica.getInstance();
		ctrU = fabrica.getControladorUsuario();
	}
	
	@BeforeEach
	void setUp() {
		ControladorPaquete.getInstancia().reset();
		ControladorTuristica.getInstancia().reset();
 		ControladorUsuario.getInstancia().reset();
	}
	
	
	@Test
	void testGetInstancia() {
		ControladorUsuario cu = ControladorUsuario.getInstancia();
		ControladorUsuario cu2 = ControladorUsuario.getInstancia();
		assertEquals(cu,cu2);
	}

	@Test
	void testListar() {
		ControladorUsuario cu = ControladorUsuario.getInstancia();
		
		cu.getProveedores().clear();
		cu.getTuristas().clear();
		
		assertThrows(UsuarioNoExisteException.class, () -> {cu.listarProveedores();});
		assertThrows(UsuarioNoExisteException.class, () -> {cu.listarUsuarios();});
		
		try {
			cu.altaProveedor("nicoP", "", "", "1", null,"", "", "");
			cu.altaProveedor("nicoP2", "", "", "2", null,"", "", "");
			cu.altaTurista("nicoT", "", "", "3", null,"", "");
			cu.altaTurista("nicoT2", "", "", "4", null,"", "");
			
		} catch (UsuarioRepetidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try { //listarProveedores
			Set<String> listaProveedores = cu.listarProveedores();
			
			Set<String> listaBien = new HashSet<String>();
			
			listaBien.add("nicoP");
			listaBien.add("nicoP2");
			
			assert(listaProveedores.equals(listaBien));
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try { // listarUsuarios
			
			Set<String> listaU = cu.listarUsuarios();
			
			Set<String> listaBienU = new HashSet<String>();
			
			listaBienU.add("nicoP");
			listaBienU.add("nicoP2");
			listaBienU.add("nicoT");
			listaBienU.add("nicoT2");
			
			assert(listaU.equals(listaBienU));
		} catch (UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// listarTuristas
		
		Set<String> listaT = cu.listarTuristas();
		
		Set<String> listaBienT = new HashSet<String>();
		
		listaBienT.add("nicoT");
		listaBienT.add("nicoT2");
		
		assert(listaT.equals(listaBienT));
		
	}


//	@Test
//	void testModificarDatosTurista() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testModificarDatosProveedor() {
//		fail("Not yet implemented");
//	}

	@Test
	void testCrearInscripcion() {
		ControladorUsuario cu = ControladorUsuario.getInstancia();
		ControladorTuristica ct = ControladorTuristica.getInstancia();
		
		try { // crear Proveedor
			cu.altaProveedor("nickProveedorCrearInscripcion", "", "", "emailCrearInsicripcionP", LocalDate.of(0, 1, 2),"", "", "");
		} catch (UsuarioRepetidoException e2) {
			e2.printStackTrace();
		}
		
		// crear Departamento
		ct.crearDepartamento("XdLand", "", "");
		try {
			ct.crearCategoria("catTestCU");
		} catch (CategoriaRepetidaException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Set<String> categorias = new HashSet<String>();
		categorias.add("catTestCU");
		try { // crear Actividad Turistica
			ct.crearActividadTuristica("nombreActividad", null, 0, 0, null, null, "XdLand", "nickProveedorCrearInscripcion",categorias);
		} catch (NombreActividadRepetidoException e1) {
			e1.printStackTrace();
		}
		
		//crear infoSalida
		DTInfoSalida infoSalida = new DTInfoSalida(LocalDate.of(0, 1, 2), null, "tu cacita");
		
		try { //crear SalidaTuristica
			ct.crearSalidaTuristica("nombreSalida", 10, LocalDate.of(0, 1, 2), infoSalida, "nombreActividad");
		} catch (NombreSalidaRepetidoException e1) {
			e1.printStackTrace();
		} catch (NoHayActividadConEseNombreException e1) {
			e1.printStackTrace();
		}
		
		try {	//crearTusita
			cu.altaTurista("nombreTurista", "", "", "emailCrearInsicripcionT", LocalDate.of(0, 1, 2),"", "");
			
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();
		}
		
		try {	//crear y testear inscripcion
			cu.seleccionarTurista("nombreTurista");
			cu.crearInscripcion("nombreTurista", "nombreSalida", 3, (float) 2, LocalDate.of(1, 2, 3));
			
			DTInscripcion dtTest = cu.getDTTurista().getInscripciones().get(0);
			
			assertEquals(dtTest.getCantidadTuristas(),3);
			boolean costoIgual = (dtTest.getCosto() == (float) 6);
			assert(costoIgual);
			assert(dtTest.getFecha().equals(LocalDate.of(1, 2, 3)));
			assertEquals(dtTest.getSalidaAsociada().getNombre(),"nombreSalida");
			
			
		} catch (YaExisteInscripcionTuristaSalida e) {
			e.printStackTrace();
		}
		
		assertThrows(YaExisteInscripcionTuristaSalida.class, () -> {cu.crearInscripcion("nombreTurista", "nombreSalida", 3, (float) 2, LocalDate.of(1, 2, 3));});
		
	}

	@Test
	void testAltaProveedor() {
		Fabrica fa = Fabrica.getInstance();
		IUsuario cu = fa.getControladorUsuario();
		
		try {
			cu.altaProveedor("nicoPNick", "nicoPNombre", "nicoPApellido", "NicoPEmail", LocalDate.of(1, 2, 3),"contra", "NicoPDescripcion", "NicoPURL");
			cu.seleccionarProveedor("nicoPNick");
			DTProveedor dtp = cu.getDTProveedor();
			
			assertEquals(dtp.getNickname(), "nicoPNick");
			assertEquals(dtp.getNombre(), "nicoPNombre");
			assertEquals(dtp.getApellido(), "nicoPApellido");
			assertEquals(dtp.getEmail(), "NicoPEmail");
			assertEquals(dtp.getFechaNacimiento(),LocalDate.of(1, 2, 3));
			assertEquals(dtp.getContra(),"contra");
			assertEquals(dtp.getDescripcionGeneral(),"NicoPDescripcion");
			assertEquals(dtp.getURL(),"NicoPURL");
			
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();
		}
		
		assertThrows(UsuarioRepetidoException.class, () -> {cu.altaProveedor("nicoPNick", "nicoNombre2", "nicoApellido2", "NicoPEmail2", LocalDate.of(0, 1, 2),"contra", "nicoNacionalidad2", "xd");});
		assertThrows(UsuarioRepetidoException.class, () -> {cu.altaProveedor("nicoPNick2", "nicoNombre2", "nicoApellido2", "NicoPEmail", LocalDate.of(0, 1, 2),"contra", "nicoNacionalidad2", "xd");});
		
	}

	@Test
	void testAltaTurista() {
		Fabrica fa = Fabrica.getInstance();
		IUsuario cu = fa.getControladorUsuario();
		
		try {
			cu.altaTurista("nicoNick", "nicoNombre", "nicoApellido", "nicoEmail", LocalDate.of(0, 1, 2),"contra", "nicoNacionalidad");
			cu.seleccionarTurista("nicoNick");
			DTTurista dtt = cu.getDTTurista();
			
			assertEquals(dtt.getNickname(), "nicoNick");
			assertEquals(dtt.getNombre(), "nicoNombre");
			assertEquals(dtt.getApellido(), "nicoApellido");
			assertEquals(dtt.getEmail(), "nicoEmail");
			assertEquals(dtt.getFechaNacimiento(),LocalDate.of(0, 1, 2));
			assertEquals(dtt.getNacionalidad(),"nicoNacionalidad");
			
			assert(cu.esTurista("nicoNick"));
			
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();
		}
		assertThrows(UsuarioRepetidoException.class, () -> {cu.altaTurista("nicoNick", "nicoNombre2", "nicoApellido2", "nicoEmail2", LocalDate.of(0, 1, 2),"contra", "nicoNacionalidad2");});
		assertThrows(UsuarioRepetidoException.class, () -> {cu.altaTurista("nicoNick2", "nicoNombre2", "nicoApellido2", "nicoEmail", LocalDate.of(0, 1, 2),"contra", "nicoNacionalidad2");});
		
	}
	
	@Test
	void testIniciarSesion() {
		try {
			CargaDeDatos cd = CargaDeDatos.getInstancia();
			cd.setYaCargo(false);
			cd.cargarDatos();
		} catch (UsuarioRepetidoException e) {
			e.printStackTrace();
		}
		assertEquals(EstadoError.EXITO_TURISTA,ctrU.iniciarSesion("isabelita","r5t6y7u8"));
		assertEquals(EstadoError.EXITO_TURISTA,ctrU.iniciarSesion("isabelita@thecrown.co.uk","r5t6y7u8"));
		assertEquals(EstadoError.ERROR_NICK_OR_EMAIL,ctrU.iniciarSesion("mal","r5t6y7u8"));
		assertEquals(EstadoError.ERROR_CONTRA,ctrU.iniciarSesion("isabelita@thecrown.co.uk","mal"));
		assertEquals(EstadoError.ERROR_CONTRA,ctrU.iniciarSesion("isabelita","mal"));
		assertEquals(EstadoError.EXITO_PROVEEDOR,ctrU.iniciarSesion("washington","asdfg654"));
		assertEquals(EstadoError.EXITO_PROVEEDOR,ctrU.iniciarSesion("washington@turismorocha.gub.uy","asdfg654"));
		assertEquals(EstadoError.ERROR_NICK_OR_EMAIL,ctrU.iniciarSesion("mal","asdfg654"));
		assertEquals(EstadoError.ERROR_CONTRA,ctrU.iniciarSesion("washington","mal"));
		assertEquals(EstadoError.ERROR_CONTRA,ctrU.iniciarSesion("washington@turismorocha.gub.uy","mal"));
		EstadoSesion estado = EstadoSesion.LOGIN_PROVEEDOR;
		estado = EstadoSesion.LOGIN_TURISTA;
		assertEquals(EstadoSesion.LOGIN_TURISTA,estado);
	}

}
