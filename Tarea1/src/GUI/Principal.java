package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Principal {

	private JFrame frame;
   // private IUsuario ICUsu;
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
					window.frame.setVisible(true);
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
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
