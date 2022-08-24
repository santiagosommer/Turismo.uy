package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
import ServidorCentral.Logica.Controladores.*;
import ServidorCentral.Logica.Interfaces.*;
import ServidorCentral.Logica.Fabrica.Fabrica;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;

public class Principal {

	
	
	private JFrame frmServidorcentral;
	private AltaDeUsuario altaUsuarioInternalFrame;
    private IUsuario ICUsu;
    private ITuristica ICTuri;
    private IPaquete ICP;
    //private AltaDeUsuario altaUsuarioIFrame;
	//private ConsultaDeUsuario consultaUsuarioIFrame;
	//	private ModificarDatosDeUsuario modificarDatosUsuarioIFrame;
		
		//private ConsultadeActividadTurística consultaActividadTurísticaIFrame
		//private AltadeSalidaTurística altaSalidaTurísticaIFrame
		//private ConsultadeSalidaTurística   consultaSalidaTurísticaIFrame
		//private InscripciónaSalidaTurística  inscripciónSalidaTurísticaIFrame
		//private CrearPaquetedeActividadesTurísticas  crearPaqueteActividadesTurísticasIFrame
	    //private AgregarActividadTurísticaaPaquete  agregarActividadTurísticaPaqueteIFrame
		//private ConsultadePaquetedeActividadesTurísticas  consultaPaqueteActividadesTurísticasIFrame

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmServidorcentral.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		
		Fabrica fabrica = new Fabrica(); //?
		 ICUsu =   fabrica.getControladorUsuario();
		 
		 
		 
	//	ServidorCentral.Logica.Fabrica.Fabrica fabrica = Fabrica.Fabrica();
		
		
	//	ICUsu = fabrica.getControladorUsuario();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServidorcentral = new JFrame();
		frmServidorcentral.setTitle("Servidor Central");
		frmServidorcentral.setBounds(100, 100, 450, 300);
		frmServidorcentral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmServidorcentral.setJMenuBar(menuBar);
		
		JMenu menuSistema = new JMenu("Sistema");
		menuBar.add(menuSistema);
		
		JMenuItem menuItemSalir = new JMenuItem("Salir");
		menuSistema.add(menuItemSalir);
		
		JMenu menuUsuario = new JMenu("Usuario");
		menuBar.add(menuUsuario);
		
		JMenuItem menuItemAltaDeUsuario = new JMenuItem("Alta de Ususario");
		menuItemAltaDeUsuario.setSelected(true);
		menuUsuario.add(menuItemAltaDeUsuario);
		
		altaUsuarioInternalFrame = new AltaDeUsuario(ICUsu);
		altaUsuarioInternalFrame.setBounds(28, 37, 370, 123);
		altaUsuarioInternalFrame.setVisible(false);
		frmServidorcentral.getContentPane().setLayout(null);
		frmServidorcentral.getContentPane().add(altaUsuarioInternalFrame);
	}

}
