package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
import ServidorCentral.Logica.Interfaces.IUsuario;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class ConsultaDeUsuario extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, IUsuario cu) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDeUsuario frame = new ConsultaDeUsuario(cu);
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
	public ConsultaDeUsuario(IUsuario cu) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 405, 251);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);

	}
}
