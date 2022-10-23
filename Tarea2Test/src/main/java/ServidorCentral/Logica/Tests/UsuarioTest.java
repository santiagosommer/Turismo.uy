package ServidorCentral.Logica.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Inscripcion;
import ServidorCentral.Logica.Clases.Proveedor;
import ServidorCentral.Logica.Clases.SalidaTuristica;
import ServidorCentral.Logica.Clases.Turista;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;

@TestInstance(Lifecycle.PER_CLASS)
class UsuarioTest {

	static String nickname;
	static String nombre;
	static String apellido;
	static String email;
	static LocalDate fechaNacimiento;
	static String contra;
	
	static Turista robertoTurista;
	static String nacionalidad;
	static ArrayList<Inscripcion> inscripciones;
	
	static Proveedor robertoProveedor;
	static String DescripcionGeneral;
	static String URL;
	static Map<String, ActividadTuristica> ActividadesTuristicas;
	
	@BeforeEach
	public void beforeTest() throws Exception {
		nickname = "robertito12";                   
		nombre = "Roberto";                         
		apellido = "Carlos";                        
		email = "millondeamigos@gmail.com";         
		fechaNacimiento = LocalDate.of(1997,7,6);
		contra = "contra";
		
		//Turista
		nacionalidad = "uruguaya";
		inscripciones = new ArrayList<Inscripcion>();
		robertoTurista = new Turista(nickname, nombre, apellido, email, fechaNacimiento, contra, nacionalidad);
		
		//Proveedor
		DescripcionGeneral = "Me llamo Roberto Carlos.";
		URL = "robertocarlos.com";
		robertoProveedor = new Proveedor(nickname, nombre, apellido, email, fechaNacimiento, contra, DescripcionGeneral, URL);
		ActividadesTuristicas = new HashMap<String, ActividadTuristica>();
	}

	@Test
	public void getNicknameTest() {
		String esperado = UsuarioTest.nickname;
		
		assertEquals(esperado, robertoTurista.getNickname());
		assertEquals(esperado, robertoProveedor.getNickname());
	}

	@Test
	public void setNicknameTest() {
		String nuevoNick = "nuevoNick";
		
		robertoProveedor.setNickname(nuevoNick);
		robertoTurista.setNickname(nuevoNick);
		
		assertEquals(nuevoNick, robertoProveedor.getNickname());
		assertEquals(nuevoNick, robertoTurista.getNickname());
	}

	@Test
	public void getNombre() {
		String esperado = UsuarioTest.nombre;
		
		assertEquals(esperado, robertoTurista.getNombre());
		assertEquals(esperado, robertoProveedor.getNombre());
	}

	@Test
	public void setNombre() {
		String nuevoNombre = "nuevoNombre";
		
		robertoProveedor.setNombre(nuevoNombre);
		robertoTurista.setNombre(nuevoNombre);
		
		assertEquals(nuevoNombre, robertoProveedor.getNombre());
		assertEquals(nuevoNombre, robertoTurista.getNombre());
	}

	@Test
	public void getApellido() {
		String esperado = UsuarioTest.apellido;
		
		assertEquals(esperado, robertoTurista.getApellido());
		assertEquals(esperado, robertoProveedor.getApellido());
	}

	@Test
	public void setApellido() {
		String nuevoApellido = "nuevoApellido";
		
		robertoProveedor.setApellido(nuevoApellido);
		robertoTurista.setApellido(nuevoApellido);
		
		assertEquals(nuevoApellido, robertoProveedor.getApellido());
		assertEquals(nuevoApellido, robertoTurista.getApellido());
	}

	@Test
	public void getEmail() {
		String esperado = UsuarioTest.email;
		
		assertEquals(esperado, robertoTurista.getEmail());
		assertEquals(esperado, robertoProveedor.getEmail());
	}

	@Test
	public void setEmail() {
		String nuevoEmail = "nuevoEmail";
		
		robertoProveedor.setEmail(nuevoEmail);
		robertoTurista.setEmail(nuevoEmail);
		
		assertEquals(nuevoEmail, robertoProveedor.getEmail());
		assertEquals(nuevoEmail, robertoTurista.getEmail());
	}

	@Test
	public void getFechaNacimiento() {
		LocalDate esperado = UsuarioTest.fechaNacimiento;
		
		assertEquals(esperado, robertoTurista.getFechaNacimiento());
		assertEquals(esperado, robertoProveedor.getFechaNacimiento());
	}

	@Test
	public void setFechaNacimientoTest() {
		LocalDate nuevaFecha = LocalDate.of(2001,1,1);
		
		robertoProveedor.setFechaNacimiento(nuevaFecha);
		robertoTurista.setFechaNacimiento(nuevaFecha);
		
		assertEquals(nuevaFecha, robertoProveedor.getFechaNacimiento());
		assertEquals(nuevaFecha, robertoTurista.getFechaNacimiento());
	}

	@Test
	public void toStringTest() {
		assertEquals(UsuarioTest.nombre + " " + UsuarioTest.apellido + " - NickName: " + UsuarioTest.nickname , robertoTurista.toString());
		assertEquals(UsuarioTest.nombre + " " + UsuarioTest.apellido + " - NickName: " + UsuarioTest.nickname , robertoProveedor.toString());	
	}
	
	//Turista
	
	@Test
	public void getNacionalidadTest() {
		String esperado = UsuarioTest.nacionalidad;
		
		assertEquals(esperado, robertoTurista.getNacionalidad());
	}

	@Test
	public void setNacionalidadTest() {
		String nuevaNacionalidad = "nuevaNacionalidad";
		
		robertoTurista.setNacionalidad(nuevaNacionalidad);
		
		assertEquals(nuevaNacionalidad, robertoTurista.getNacionalidad());
	}

	@Test
	public void getInscripcionesTest() {
		ArrayList<Inscripcion> esperado = UsuarioTest.inscripciones;
		
		assertEquals(esperado, robertoTurista.getInscripciones());
	}

	@Test
	public void setInscripcionesTest() {
		ArrayList<Inscripcion> nuevaIns = new ArrayList<Inscripcion>();
		
		robertoTurista.setInscripciones(nuevaIns);
		
		assertEquals(nuevaIns, robertoTurista.getInscripciones());
	}
 
	@Test
	public void agregarInscripcionTest() {
		ArrayList<Inscripcion> nuevaInsLista = new ArrayList<Inscripcion>();

		SalidaTuristica nuevaSalida = new SalidaTuristica("Salida", 5, LocalDate.of(2001, 1, 1), new DTInfoSalida(LocalDate.of(2001,1,1), LocalTime.of(17, 0), "En lo de pedrito"));
		Inscripcion nuevaIns = new Inscripcion(LocalDate.of(2001, 1, 1), 5, 200, nuevaSalida, robertoTurista);
		
		robertoTurista.agregarInscripcion(nuevaIns);
		nuevaInsLista.add(nuevaIns);
		
		assertEquals(nuevaInsLista, robertoTurista.getInscripciones());
		
	}
	
	//Proveedores
	
	@Test
	public void getDescripcionGeneralTest() {
		String esperado = UsuarioTest.DescripcionGeneral;
		
		assertEquals(esperado, robertoProveedor.getDescripcionGeneral());
	}
	
	@Test
	public void setDescripcionGeneralTest() {
		String esperado = UsuarioTest.DescripcionGeneral;
		
		robertoProveedor.setDescripcionGeneral(esperado);
		
		assertEquals(esperado, robertoProveedor.getDescripcionGeneral());
	}
	
	@Test
	public void getURLTest() {
		String esperado = UsuarioTest.URL;
		
		assertEquals(esperado, robertoProveedor.getURL());
	}
	
	@Test
	public void setURLTest() {
		String esperado = UsuarioTest.URL;
		
		robertoProveedor.setURL(esperado);
		
		assertEquals(esperado, robertoProveedor.getURL());
	}
	
	@Test
	public void getActividadesTuristicasTest() {
		Map<String, ActividadTuristica> esperado = UsuarioTest.ActividadesTuristicas;
		
		assertEquals(esperado, robertoProveedor.getActividadesTuristicas());
	}
	
	@Test
	public void setActividadesTuristicasTest() {
		Map<String, ActividadTuristica> esperado = UsuarioTest.ActividadesTuristicas;
		
		robertoProveedor.setActividadesTuristicas(esperado);
		
		assertEquals(esperado, robertoProveedor.getActividadesTuristicas());
	}
	


}
