package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private IUsuario ICUsu;
    private ITuristica ICTuri;
    private IPaquete ICP;
    private AltaDeUsuario altaUsuarioIFrame;
	private ConsultaDeUsuario consultaUsuarioIFrame;
	private ModificarDatosDeUsuario modificarDatosUsuarioIFrame;
	private ConsultaDeActividadTuristica consultaActividadTuristicaIFrame;
	private AltaDeSalidaTuristica altaSalidaTuristicaIFrame;
	private ConsultaDeSalidaTuristica   consultaSalidaTuristicaIFrame;
	private InscripcionASalidaTuristica  inscripciónSalidaTurísticaIFrame;
	//private CrearPaquetedeActividadesTurísticas  crearPaqueteActividadesTuristicasIFrame
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
		 ICTuri = fabrica.getControladorTuristica();
		 ICP = fabrica.getControladorPaquete();
		 
		 altaUsuarioIFrame = new AltaDeUsuario(ICUsu);
		 altaUsuarioIFrame.setVisible(false);
		 frmServidorcentral.getContentPane().add(altaUsuarioIFrame);
		 
		 
		 consultaUsuarioIFrame = new ConsultaDeUsuario(ICUsu);
		 consultaUsuarioIFrame.setVisible(false);
		 frmServidorcentral.getContentPane().add(consultaUsuarioIFrame);
		 
		 modificarDatosUsuarioIFrame = new ModificarDatosDeUsuario(ICUsu);
		 modificarDatosUsuarioIFrame.setVisible(false);
		 frmServidorcentral.getContentPane().add(modificarDatosUsuarioIFrame);
		 
		 
		 
		 
		 
			
		
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
		
		
		JMenuItem mntmAltaDeUsuario = new JMenuItem("Alta de Usuario");
		 mntmAltaDeUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//AltaIFrame.limpiarFormulario();
            	altaUsuarioIFrame.setVisible(true);
            }
        });
		menuUsuario.add(mntmAltaDeUsuario);
		
		
		JMenuItem mntmConsultaDeUsuario = new JMenuItem("Consulta de Usuario");
		mntmConsultaDeUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//consultaDePerPropInternalFrame.limpiarFormulario();
            	consultaUsuarioIFrame.setVisible(true);
            }
        });
		menuUsuario.add(mntmConsultaDeUsuario);
		
		
		JMenuItem mntmModificarDatosDeUsuario = new JMenuItem("Modificar Datos de Usuario");
		mntmModificarDatosDeUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//consultaDePerPropInternalFrame.limpiarFormulario();
            	modificarDatosUsuarioIFrame.setVisible(true);
            }
        });
		menuUsuario.add(mntmModificarDatosDeUsuario);
		
	   
	}

}
