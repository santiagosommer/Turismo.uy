package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
import ServidorCentral.Logica.Interfaces.IUsuario;

import javax.swing.JInternalFrame;

public class ModificarDatosDeUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,IUsuario ctrl) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosDeUsuario frame = new ModificarDatosDeUsuario(ctrl);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarDatosDeUsuario(IUsuario ctrl) {
		setBounds(100, 100, 450, 300);
		

	}

}
