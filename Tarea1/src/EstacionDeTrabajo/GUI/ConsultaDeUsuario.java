package EstacionDeTrabajo.GUI;

import ServidorCentral.Logica.Interfaces.IUsuario;

import javax.swing.JInternalFrame;

public class ConsultaDeUsuario extends JInternalFrame {


	public ConsultaDeUsuario(IUsuario cu) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

	}
}
