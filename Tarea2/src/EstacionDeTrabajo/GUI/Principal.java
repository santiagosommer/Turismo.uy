package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import ServidorCentral.Logica.Controladores.*;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Interfaces.*;
import ServidorCentral.Logica.Fabrica.Fabrica;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;

public class Principal {

	private JFrame frmServidorcentral;
	private IUsuario ICUsu;
	private ITuristica ICTuri;
	private IPaquete ICP;
	private AltaDeProveedor altaProveedorIFrame;
	private AltaDeTurista altaTuristaIFrame;
	private ConsultaDeUsuario consultaUsuarioIFrame;
	private ModificarDatosDeUsuario modificarDatosUsuarioIFrame;
	private ConsultaDeActividadTuristica consultaActividadTuristicaIFrame;
	private AltaDeSalidaTuristica altaSalidaTuristicaIFrame;
	private ConsultaDeSalidaTuristica consultaSalidaTuristicaIFrame;
	private InscripcionASalidaTuristica inscripcionSalidaTuristicaIFrame;
	private CrearPaqueteDeActividadesTuristicas crearPaqueteIFrame;
	private AltaDeActividadTuristica crearActividadTuristicaIFrame;
	private AgregarActividadTuristicaAPaquete agregarActividadTurísticaAPaqueteIFrame;
	private ConsultaDePaqueteDeActividadesTuristicas consultaPaqueteIFrame;
	private CargaDeDatos cargaDeDatos;

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
	 * 
	 * @throws DepartamentoNoExisteException
	 */

	public Principal() {
		initialize();

		Fabrica fabrica = Fabrica.getInstance();
		ICUsu = fabrica.getControladorUsuario();
		ICTuri = fabrica.getControladorTuristica();
		ICP = fabrica.getControladorPaquete();
		frmServidorcentral.getContentPane().setLayout(null);

		consultaUsuarioIFrame = new ConsultaDeUsuario(ICUsu, ICTuri, frmServidorcentral);
		consultaUsuarioIFrame.setBounds(10, 0, 768, 469);
		frmServidorcentral.getContentPane().add(consultaUsuarioIFrame);
		
		altaProveedorIFrame = new AltaDeProveedor(ICUsu);
		frmServidorcentral.getContentPane().add(altaProveedorIFrame);
		
		altaTuristaIFrame = new AltaDeTurista(ICUsu);
		frmServidorcentral.getContentPane().add(altaTuristaIFrame);
		

		modificarDatosUsuarioIFrame = new ModificarDatosDeUsuario(ICUsu);
		modificarDatosUsuarioIFrame.setBounds(0, 10, 350, 176);
		consultaUsuarioIFrame.getContentPane().add(modificarDatosUsuarioIFrame);
		modificarDatosUsuarioIFrame.setVisible(false);

		consultaSalidaTuristicaIFrame = new ConsultaDeSalidaTuristica(ICTuri);
		consultaSalidaTuristicaIFrame.setResizable(true);
		consultaSalidaTuristicaIFrame.setMaximizable(true);
		consultaSalidaTuristicaIFrame.setBounds(52, 0, 677, 411);
		frmServidorcentral.getContentPane().add(consultaSalidaTuristicaIFrame);
		consultaSalidaTuristicaIFrame.setVisible(false);
		consultaSalidaTuristicaIFrame.setClosable(true);

		consultaActividadTuristicaIFrame = new ConsultaDeActividadTuristica(ICTuri, ICP, frmServidorcentral);
		consultaActividadTuristicaIFrame.setMaximizable(true);
		consultaActividadTuristicaIFrame.setBounds(52, 0, 800, 560);
		frmServidorcentral.getContentPane().add(consultaActividadTuristicaIFrame);

		altaSalidaTuristicaIFrame = new AltaDeSalidaTuristica(ICTuri);
		altaSalidaTuristicaIFrame.setBounds(10, 40, 768, 596);
		frmServidorcentral.getContentPane().add(altaSalidaTuristicaIFrame);
		altaSalidaTuristicaIFrame.setVisible(false);
		altaSalidaTuristicaIFrame.setClosable(true);
		
		crearActividadTuristicaIFrame = new AltaDeActividadTuristica(ICTuri, ICUsu);
		crearActividadTuristicaIFrame.setBounds(10, 40, 733, 560);
		frmServidorcentral.getContentPane().add(crearActividadTuristicaIFrame);
		crearActividadTuristicaIFrame.setVisible(false);
		crearActividadTuristicaIFrame.setClosable(true);
		

		inscripcionSalidaTuristicaIFrame = new InscripcionASalidaTuristica(ICUsu);
		inscripcionSalidaTuristicaIFrame.setResizable(true);
		inscripcionSalidaTuristicaIFrame.setMaximizable(true);
		inscripcionSalidaTuristicaIFrame.setLocation(-21, 0);
		consultaSalidaTuristicaIFrame.setBounds(10, 0, 677, 411);
		frmServidorcentral.getContentPane().add(inscripcionSalidaTuristicaIFrame);

		inscripcionSalidaTuristicaIFrame.setVisible(false);
		inscripcionSalidaTuristicaIFrame.setClosable(true);

		crearPaqueteIFrame = new CrearPaqueteDeActividadesTuristicas(ICP);
		crearPaqueteIFrame.setResizable(true);
		crearPaqueteIFrame.setMaximizable(true);
		crearPaqueteIFrame.setBounds(52, 0, 677, 411);
		frmServidorcentral.getContentPane().add(crearPaqueteIFrame);
		crearPaqueteIFrame.setVisible(false);
		crearPaqueteIFrame.setClosable(true);

		agregarActividadTurísticaAPaqueteIFrame = new AgregarActividadTuristicaAPaquete(ICP);
		agregarActividadTurísticaAPaqueteIFrame.setBounds(10, 40, 552, 280);
		frmServidorcentral.getContentPane().add(agregarActividadTurísticaAPaqueteIFrame);
		agregarActividadTurísticaAPaqueteIFrame.setVisible(false);
		agregarActividadTurísticaAPaqueteIFrame.setClosable(true);

		consultaPaqueteIFrame = new ConsultaDePaqueteDeActividadesTuristicas(ICP, ICTuri);
		consultaPaqueteIFrame.setResizable(true);
		consultaPaqueteIFrame.setMaximizable(true);

		consultaPaqueteIFrame.setBounds(52, 0, 639, 558);
		frmServidorcentral.getContentPane().add(consultaPaqueteIFrame);
		consultaPaqueteIFrame.setVisible(false);
		consultaPaqueteIFrame.setClosable(true);

		try {
			cargaDeDatos = new CargaDeDatos(ICUsu, ICTuri, ICP);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * cargarDatosDepartamentos(); altaSalidaTuristicaIFrame.cargarDatosProvee
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServidorcentral = new JFrame();
		frmServidorcentral.setTitle("Servidor Central");
		frmServidorcentral.setBounds(100, 100, 890, 773);
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
		
		JMenu mnAltaDeUsuario = new JMenu("Alta de Usuario");
		menuUsuario.add(mnAltaDeUsuario);
		
		JMenuItem mntmAltaDeTurista = new JMenuItem("Alta de Turista");
		mntmAltaDeTurista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				altaTuristaIFrame.setVisible(true);
			}
		});
		mnAltaDeUsuario.add(mntmAltaDeTurista);
		
		JMenuItem mntmAltaDeProveedor = new JMenuItem("Alta de Proveedor");
		mntmAltaDeProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaProveedorIFrame.setVisible(true);
			}
		});
		mnAltaDeUsuario.add(mntmAltaDeProveedor);

		JMenuItem mntmConsultaDeUsuario = new JMenuItem("Consulta de Usuario");
		mntmConsultaDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// consultaDePerPropInternalFrame.limpiarFormulario();
//				consultaUsuarioIFrame.resetearInfo();
//				consultaUsuarioIFrame.resetearInfoExtra();
				consultaUsuarioIFrame.cerrarConsultaUsuario();
				consultaUsuarioIFrame.cargarUsuarios();
				consultaUsuarioIFrame.comboBoxListaTuristicas.setVisible(false);
				consultaUsuarioIFrame.setVisible(true);
			}
		});
		menuUsuario.add(mntmConsultaDeUsuario);

		JMenuItem mntmModificarDatosDeUsuario = new JMenuItem("Modificar Datos de Usuario");
		mntmModificarDatosDeUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// consultaDePerPropInternalFrame.limpiarFormulario();
				modificarDatosUsuarioIFrame.setVisible(true);
			}
		});
		menuUsuario.add(mntmModificarDatosDeUsuario);

		JMenu mnActividadesTuristicas = new JMenu("Actividades Turisticas");
		menuBar.add(mnActividadesTuristicas);

		JMenuItem mntmAltaActividadTuristica = new JMenuItem("Alta Actividad Turistica");
		mntmAltaActividadTuristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearActividadTuristicaIFrame.limpiarFormulario();
				crearActividadTuristicaIFrame.cargarDatosDepartamentos();
				crearActividadTuristicaIFrame.cargarDatosProveedores();
				crearActividadTuristicaIFrame.setVisible(true);
			}
		});
		mnActividadesTuristicas.add(mntmAltaActividadTuristica);

		JMenuItem mntmConsultaActividadTuristica = new JMenuItem("Consulta Actividad Turistica");
		mntmConsultaActividadTuristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaActividadTuristicaIFrame.limpiarFormulario();
				consultaActividadTuristicaIFrame.setVisible(true);
			}
		});
		mnActividadesTuristicas.add(mntmConsultaActividadTuristica);

		JMenu menuSalidas = new JMenu("Salidas Turisticas");
		menuBar.add(menuSalidas);

		JMenuItem mntmConsultaDeSalida = new JMenuItem("Consulta de Salida Turistica");
		mntmConsultaDeSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaSalidaTuristicaIFrame.limpiarFormulario();
				consultaSalidaTuristicaIFrame.cargarDatosDepartamentos();
				consultaSalidaTuristicaIFrame.setVisible(true);
			}
		});

		JMenuItem mntmAltaSalidaTuristica = new JMenuItem("Alta Salida Turistica");
		mntmAltaSalidaTuristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaSalidaTuristicaIFrame.limpiarFormulario();
				altaSalidaTuristicaIFrame.cargarDep();
				altaSalidaTuristicaIFrame.cargarAct();
				altaSalidaTuristicaIFrame.setVisible(true);
			}
		});
		menuSalidas.add(mntmAltaSalidaTuristica);

		menuSalidas.add(mntmConsultaDeSalida);

		JMenu mnPaquetes = new JMenu("Paquetes");
		menuBar.add(mnPaquetes);

		JMenuItem mntmCrearPaquete = new JMenuItem("Crear Paquete ");
		mnPaquetes.add(mntmCrearPaquete);
		mntmCrearPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearPaqueteIFrame.limpiarFormulario();
				crearPaqueteIFrame.setVisible(true);
			}
		});

		JMenuItem mntmAgregarActividadAPaquete = new JMenuItem("Agregar Actividad a Paquete");
		mntmAgregarActividadAPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarActividadTurísticaAPaqueteIFrame.limpiarFormulario();
				agregarActividadTurísticaAPaqueteIFrame.cargarDep();
				agregarActividadTurísticaAPaqueteIFrame.CargarPaquetes();
				agregarActividadTurísticaAPaqueteIFrame.setVisible(true);
			}
		});
		mnPaquetes.add(mntmAgregarActividadAPaquete);

		JMenuItem mntmConsultaDePaquete = new JMenuItem("Consulta de Paquete");
		mnPaquetes.add(mntmConsultaDePaquete);

		mntmConsultaDePaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaPaqueteIFrame.LimpiarFormulario();
				consultaPaqueteIFrame.cargarPaquetes();
				consultaPaqueteIFrame.setVisible(true);
			}
		});

		JMenuItem mntmInscripcionASalida = new JMenuItem("Inscripcion a Salida Turistica");
		mntmInscripcionASalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscripcionSalidaTuristicaIFrame.cargarDatosDepartamentos();
				inscripcionSalidaTuristicaIFrame.limpiarFormulario();
				inscripcionSalidaTuristicaIFrame.ListarTuristas();
				inscripcionSalidaTuristicaIFrame.setVisible(true);
			}
		});

		menuSalidas.add(mntmInscripcionASalida);

		JMenu mnCargaDeDatos = new JMenu("Carga de Datos");
		menuBar.add(mnCargaDeDatos);

		JMenuItem mntmCargarDatosIniciales = new JMenuItem("Cargar datos iniciales");
		mntmCargarDatosIniciales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (cargaDeDatos.cargarDatos()) {
						JOptionPane.showMessageDialog(frmServidorcentral, "La carga de datos fue exitosa!");
					}
					else {
						JOptionPane.showMessageDialog(frmServidorcentral, "Los datos ya fueron cargados!");
					}
				} catch (UsuarioRepetidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnCargaDeDatos.add(mntmCargarDatosIniciales);

	}

	public boolean getConsultaUsuarioIFrameClosable() {
		return consultaUsuarioIFrame.isClosable();
	}

	public void setConsultaUsuarioIFrameClosable(boolean closable) {
		consultaUsuarioIFrame.setClosable(closable);
	}
}
