package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
import ServidorCentral.Logica.Controladores.*;
import ServidorCentral.Logica.Interfaces.*;
import ServidorCentral.Logica.Fabrica.Fabrica;

import javax.swing.JFrame;

public class Principal {

	
	
	private JFrame frame;
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
		
		Fabrica fabrica = new Fabrica(); //?
		 ICUsu =   fabrica.getControladorUsuario();
		 
		 
		 
	//	ServidorCentral.Logica.Fabrica.Fabrica fabrica = Fabrica.Fabrica();
		
		
	//	ICUsu = fabrica.getControladorUsuario();
		
		
		
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
