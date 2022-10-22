package ServidorCentral.Logica.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;

class FabricaTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testGetInstance() {
		Fabrica fab1 = Fabrica.getInstance();
		Fabrica fab2 = Fabrica.getInstance();
		assertEquals(fab1, fab2);
	}

	@Test
	void testGetControladorUsuario() {
		Fabrica fab = Fabrica.getInstance();
		IUsuario usr = null;
	    usr = fab.getControladorUsuario();
		assertNotNull(usr);
	}

	@Test
	void testGetControladorPaquete() {
		
		Fabrica fab = Fabrica.getInstance();
		IPaquete paq = null;
	    paq = fab.getControladorPaquete();
		assertNotNull(paq);
		
	}

	@Test
	void testGetControladorTuristica() {
		Fabrica fab = Fabrica.getInstance();
		ITuristica turistica = fab.getControladorTuristica();
		assertNotNull(turistica);
	}

}
