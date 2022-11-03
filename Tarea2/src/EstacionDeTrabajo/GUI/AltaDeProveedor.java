package EstacionDeTrabajo.GUI;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Interfaces.IUsuario;

import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AltaDeProveedor extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IUsuario cu;

	private JTextField textFieldNickName;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldDescripcion;
	private JTextField textFieldLinkWeb;
	JComboBox<Integer> comboBoxDia;
	JComboBox<Integer> comboBoxMes;
	JComboBox<Integer> comboBoxAño;
	private JTextField textFieldContraseña;
	private JTextField textFieldConfirmacionContraseña;
	

	public AltaDeProveedor(IUsuario controlUsr) {
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Alta de Proveedor");
		cu = controlUsr;
		setBounds(100, 100, 788, 348);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 101, 0, 0, 89, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 29, 26, 20, 30, 12, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblNickname = new JLabel("Nickname");
		GridBagConstraints gbc_lblNickname = new GridBagConstraints();
		gbc_lblNickname.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickname.gridx = 1;
		gbc_lblNickname.gridy = 1;
		getContentPane().add(lblNickname, gbc_lblNickname);

		textFieldNickName = new JTextField();
		textFieldNickName.setColumns(10);
		GridBagConstraints gbc_textFieldNickName = new GridBagConstraints();
		gbc_textFieldNickName.gridwidth = 3;
		gbc_textFieldNickName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNickName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNickName.gridx = 2;
		gbc_textFieldNickName.gridy = 1;
		getContentPane().add(textFieldNickName, gbc_textFieldNickName);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		getContentPane().add(lblNombre, gbc_lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.gridwidth = 3;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 2;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);

		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 3;
		getContentPane().add(lblApellido, gbc_lblApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.gridwidth = 3;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.gridx = 2;
		gbc_textFieldApellido.gridy = 3;
		getContentPane().add(textFieldApellido, gbc_textFieldApellido);

		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		getContentPane().add(lblEmail, gbc_lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.gridwidth = 3;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 4;
		getContentPane().add(textFieldEmail, gbc_textFieldEmail);

		JLabel lblDia = new JLabel("Dia");
		GridBagConstraints gbc_lblDia = new GridBagConstraints();
		gbc_lblDia.insets = new Insets(0, 0, 5, 5);
		gbc_lblDia.gridx = 2;
		gbc_lblDia.gridy = 5;
		getContentPane().add(lblDia, gbc_lblDia);

		JLabel lblMes = new JLabel("Mes");
		GridBagConstraints gbc_lblMes = new GridBagConstraints();
		gbc_lblMes.insets = new Insets(0, 0, 5, 5);
		gbc_lblMes.gridx = 3;
		gbc_lblMes.gridy = 5;
		getContentPane().add(lblMes, gbc_lblMes);

		JLabel lblAnio = new JLabel("Año");
		GridBagConstraints gbc_lblAnio = new GridBagConstraints();
		gbc_lblAnio.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnio.gridx = 4;
		gbc_lblAnio.gridy = 5;
		getContentPane().add(lblAnio, gbc_lblAnio);

		JLabel lblFecha = new JLabel("Fecha");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 6;
		getContentPane().add(lblFecha, gbc_lblFecha);

		comboBoxDia = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBoxDia = new GridBagConstraints();
		gbc_comboBoxDia.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDia.gridx = 2;
		gbc_comboBoxDia.gridy = 6;
		getContentPane().add(comboBoxDia, gbc_comboBoxDia);
		for (int i = 1; i <= 31; i++) {
			comboBoxDia.addItem(i);
		}

		comboBoxMes = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBoxMes = new GridBagConstraints();
		gbc_comboBoxMes.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMes.gridx = 3;
		gbc_comboBoxMes.gridy = 6;
		getContentPane().add(comboBoxMes, gbc_comboBoxMes);
		for (int i = 1; i <= 12; i++) {
			comboBoxMes.addItem(i);
		}

		comboBoxAño = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBoxAño = new GridBagConstraints();
		gbc_comboBoxAño.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAño.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAño.gridx = 4;
		gbc_comboBoxAño.gridy = 6;
		getContentPane().add(comboBoxAño, gbc_comboBoxAño);
		for (int i = 1900; i <= 2030; i++) {
			comboBoxAño.addItem(i);
		}

		JLabel lblDescripcion = new JLabel("Descripcion");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 7;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);

		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setColumns(10);
		GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
		gbc_textFieldDescripcion.gridwidth = 3;
		gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescripcion.gridx = 2;
		gbc_textFieldDescripcion.gridy = 7;
		getContentPane().add(textFieldDescripcion, gbc_textFieldDescripcion);

		JLabel lblLinkWeb = new JLabel("Link Web (Opcional)");
		GridBagConstraints gbc_lblLinkWeb = new GridBagConstraints();
		gbc_lblLinkWeb.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinkWeb.gridx = 1;
		gbc_lblLinkWeb.gridy = 8;
		getContentPane().add(lblLinkWeb, gbc_lblLinkWeb);

		textFieldLinkWeb = new JTextField();
		GridBagConstraints gbc_textFieldLinkWeb = new GridBagConstraints();
		gbc_textFieldLinkWeb.gridwidth = 3;
		gbc_textFieldLinkWeb.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLinkWeb.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLinkWeb.gridx = 2;
		gbc_textFieldLinkWeb.gridy = 8;
		getContentPane().add(textFieldLinkWeb, gbc_textFieldLinkWeb);
		textFieldLinkWeb.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					altaProveedorActionPerformed();
				} catch (UsuarioRepetidoException ex) {
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 9;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldContraseña = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 9;
		getContentPane().add(textFieldContraseña, gbc_textField);
		textFieldContraseña.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Confirmación contraseña:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 10;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldConfirmacionContraseña = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 10;
		getContentPane().add(textFieldConfirmacionContraseña, gbc_textField_1);
		textFieldConfirmacionContraseña.setColumns(10);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 12;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limpiarFormulario();
						setVisible(false);
					}
				});
				GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
				gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
				gbc_btnCancelar.gridx = 3;
				gbc_btnCancelar.gridy = 12;
				getContentPane().add(btnCancelar, gbc_btnCancelar);

	}

	protected void altaProveedorActionPerformed() throws UsuarioRepetidoException {
		String nickname = this.textFieldNickName.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		String nacionalidad = this.textFieldDescripcion.getText();
		String linkWeb = this.textFieldLinkWeb.getText();
		String contraseña = this.textFieldContraseña.getText();

		if (checkFormulario()) {
			try {
				int dia = (int) comboBoxDia.getSelectedItem();
				int mes = (int) comboBoxMes.getSelectedItem();
				int anio = (int) comboBoxAño.getSelectedItem();
				try {
					LocalDate date = LocalDate.of(anio, mes, dia);
					cu.altaProveedor(nickname, nombre, apellido, email, date,contraseña, nacionalidad, linkWeb);

					// Muestro éxito de la operación
					JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
							JOptionPane.INFORMATION_MESSAGE);

					limpiarFormulario();
				} catch (DateTimeException e) {
					JOptionPane.showMessageDialog(this, "Ingrese fecha valida", "Registrar Usuario",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

			} catch (UsuarioRepetidoException e) {
				// Muestro error de registro
				JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
				throw new UsuarioRepetidoException("Es usuario esta Repetido");

			}

		}
	}

	protected boolean checkFormulario() {
		String nickname = this.textFieldNickName.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		String nacionalidad = this.textFieldDescripcion.getText();
		String contraseña = this.textFieldContraseña.getText();
		String confirmacionContraseña = this.textFieldConfirmacionContraseña.getText();

		if (contraseña.isEmpty() || confirmacionContraseña.isEmpty() || nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || nacionalidad.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (!contraseña.equals(confirmacionContraseña)) {
			JOptionPane.showMessageDialog(this, "No coinciden los campos Contraseña y Confirmacion de Contraseña", "Registrar Usuario",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;

	}

	private void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldNickName.setText("");
		textFieldEmail.setText("");
		textFieldDescripcion.setText("");
		textFieldLinkWeb.setText("");
		textFieldContraseña.setText("");
		textFieldConfirmacionContraseña.setText("");
	}

}
