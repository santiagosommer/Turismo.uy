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
		
		Fabrica fabrica = Fabrica.getInstance();
		ICUsu =   fabrica.getControladorUsuario();
		ICTuri = fabrica.getControladorTuristica();
		ICP = fabrica.getControladorPaquete();
		 frmServidorcentral.getContentPane().setLayout(null);
		 
		 
		 consultaUsuarioIFrame = new ConsultaDeUsuario(ICUsu);
		 consultaUsuarioIFrame.setBounds(10, 0, 450, 300);
		 frmServidorcentral.getContentPane().add(consultaUsuarioIFrame);
		 
		 modificarDatosUsuarioIFrame = new ModificarDatosDeUsuario(ICUsu);
		 modificarDatosUsuarioIFrame.setBounds(50, 24, 350, 176);
		 consultaUsuarioIFrame.getContentPane().add(modificarDatosUsuarioIFrame);
		 modificarDatosUsuarioIFrame.setVisible(false);
		 
		 altaUsuarioIFrame = new AltaDeUsuario(ICUsu);
		 altaUsuarioIFrame.setBounds(21, 10, 328, 132);
		 frmServidorcentral.getContentPane().add(altaUsuarioIFrame);
		 altaUsuarioIFrame.setVisible(false);
		 consultaUsuarioIFrame.setVisible(false);
		 
		 
		 consultaSalidaTuristicaIFrame = new ConsultaDeSalidaTuristica(ICTuri);
		 consultaSalidaTuristicaIFrame.setBounds(10, 0, 677, 411);
		 frmServidorcentral.getContentPane().add(consultaSalidaTuristicaIFrame);
		 consultaSalidaTuristicaIFrame.setVisible(false);
		 consultaSalidaTuristicaIFrame.setClosable(true);
		 
		 
		 
		 
		 
		 
			
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServidorcentral = new JFrame();
		frmServidorcentral.setTitle("Servidor Central");
		frmServidorcentral.setBounds(100, 100, 847, 579);
		frmServidorcentral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuSistema = new JMenu("Sistema");
		menuBar.add(menuSistema);
		
		JMenuItem menuItemSalir = new JMenuItem("Salir");
		menuSistema.add(menuItemSalir);
		
		frmServidorcentral.setJMenuBar(menuBar);
		  menuItemSalir.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) {
	                // Salgo de la aplicación
	            	frmServidorcentral.setVisible(false);
	            	frmServidorcentral.dispose();
	            }
	        });
		
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
		
		JMenu mnActividadesTuristicas = new JMenu("Actividades Turisticas");
		menuBar.add(mnActividadesTuristicas);
		
		JMenuItem mntmAltaActividadTuristica = new JMenuItem("Alta Actividad Turistica");
		mnActividadesTuristicas.add(mntmAltaActividadTuristica);
		
		JMenuItem mntmConsultaActividadTuristica = new JMenuItem("Consulta Actividad Turistica");
		mnActividadesTuristicas.add(mntmConsultaActividadTuristica);
		
		JMenu menuSalidas = new JMenu("Salidas Turisticas");
		menuBar.add(menuSalidas);
		
		JMenuItem mntmConsultaDeSalida = new JMenuItem("Consulta de Salida Turistica");
		mntmConsultaDeSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	consultaSalidaTuristicaIFrame.limpiarFormulario();
            	consultaSalidaTuristicaIFrame.setVisible(true);
            }
        });
		
		JMenuItem mntmAltaSalidaTuristica = new JMenuItem("Alta Salida Turistica");
		mntmAltaSalidaTuristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaSalidaTuristicaIFrame.limpiarFormulario();
				altaSalidaTuristicaIFrame.setVisible(true);
			}
		});
		menuSalidas.add(mntmAltaSalidaTuristica);
		
		
		menuSalidas.add(mntmConsultaDeSalida);
		
		JMenuItem mntmIncripcionASalida = new JMenuItem("Incripcion a Salida Turistica");
		menuSalidas.add(mntmIncripcionASalida);
		
		JMenu mnPaquetes = new JMenu("Paquetes");
		menuBar.add(mnPaquetes);
		
		JMenuItem mntmCrearPaquete = new JMenuItem("Crear Paquete ");
		mnPaquetes.add(mntmCrearPaquete);
		
		JMenuItem mntmAgregarActividadA = new JMenuItem("Agregar Actividad a Paquete");
		mnPaquetes.add(mntmAgregarActividadA);
		
		JMenuItem mntmConsultaDePaquete = new JMenuItem("Consulta de Paquete");
		mnPaquetes.add(mntmConsultaDePaquete);
		
		
		
		
		
	   
	}
}
