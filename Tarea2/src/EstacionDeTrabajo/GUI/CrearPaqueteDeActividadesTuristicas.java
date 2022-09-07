package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import ServidorCentral.Logica.Excepciones.NombrePaqueteRepetidoException;
import ServidorCentral.Logica.Excepciones.YaExisteInscripcionTuristaSalida;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;

public class CrearPaqueteDeActividadesTuristicas extends JInternalFrame {
	private JTextField textFieldNombre;
	private JTextArea descripcionTextArea;
	private JTextField textFieldValidez;
	private JTextField textFieldDescuento;
	private IPaquete controladorPaquete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fabrica f = Fabrica.getInstance();
					IPaquete c = f.getControladorPaquete();
					CrearPaqueteDeActividadesTuristicas frame = new CrearPaqueteDeActividadesTuristicas(c);
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
	public CrearPaqueteDeActividadesTuristicas(IPaquete ctrl) {
		setTitle("Crear Paquete");

		controladorPaquete = ctrl;

		setBounds(100, 100, 384, 225);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 119, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 34, 44, 34, 28, 41, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);

		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		getContentPane().add(textFieldNombre, gbc_textField);
		textFieldNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);

		descripcionTextArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 5, 0);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 2;
		getContentPane().add(descripcionTextArea, gbc_textArea);

		JLabel lblNewLabel_2 = new JLabel("Periodo validez (dias)");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);

		textFieldValidez = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		getContentPane().add(textFieldValidez, gbc_textField_1);
		textFieldValidez.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Descuento");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);

		textFieldDescuento = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		getContentPane().add(textFieldDescuento, gbc_textField_2);
		textFieldDescuento.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 192, 171, 0 };
		gbl_panel.rowHeights = new int[] { 31, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnAceptar, gbc_btnNewButton);

		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearPaquete(arg0);
			}
		});

		// cancelar
		JButton btnCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnCancelar, gbc_btnNewButton_1);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});

	}

	void limpiarFormulario() {

		textFieldNombre.setText("");
		descripcionTextArea.setText("");
		textFieldValidez.setText("");
		textFieldDescuento.setText("");

	}

private Boolean CheckFormulario() {
		
		String descuento = this.textFieldDescuento.getText();
		String validez = this.textFieldValidez.getText();
		String nom = this.textFieldNombre.getText();
		
		if (descuento.isEmpty() || validez.isEmpty() || nom.isEmpty() ){
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Crear Paquete de Actividades Turisticas",
                    JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		 try {
	            Integer.parseInt(textFieldDescuento.getText());
	            Integer.parseInt(validez);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "La validez y el descuento deben ser numeros enteros", "Crear Paquete de Actividades Turisticas",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		 
		 if (Integer.parseInt(descuento) < 0 || Integer.parseInt(descuento) < 0) {
				JOptionPane.showMessageDialog(this, "Ingrese un numero valido", "Alta de Salida Turistica",
						JOptionPane.ERROR_MESSAGE);
				return false;
		 }
		return true;
	}

	protected void CrearPaquete(ActionEvent arg0) {

		if (CheckFormulario()) {

			try {

				LocalDate fechaAlta = LocalDate.now();
				String descripcion = this.descripcionTextArea.getText();
				String descuento = this.textFieldDescuento.getText();
				String validez = this.textFieldValidez.getText();
				String nom = this.textFieldNombre.getText();
				controladorPaquete.crearPaquete(nom, descripcion, Integer.parseInt(validez),
						Integer.parseInt(descuento), fechaAlta);
				// Muestro éxito de la operación
				String x;
				if (controladorPaquete.getPaquetes().isEmpty()) {
					x = "No Hay Paquetes";
				} else {
					x = "El paquete se ha creado con éxito";
				}
				JOptionPane.showMessageDialog(this, x, "Crear Paquete de Actividades Turisticas",
						JOptionPane.INFORMATION_MESSAGE);

			} catch (NombrePaqueteRepetidoException e) {
				// Muestro error
				JOptionPane.showMessageDialog(this, e.getMessage(), "Crear Paquete De Actividades Turisticas",
						JOptionPane.ERROR_MESSAGE);

			}

			limpiarFormulario();
		}

	}
}
