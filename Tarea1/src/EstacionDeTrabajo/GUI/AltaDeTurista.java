package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;

//import excepciones.UsuarioRepetidoException;
//import logica.IControladorUsuario;

import ServidorCentral.Logica.Interfaces.IUsuario;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class AltaDeTurista extends JInternalFrame {
	
	private IUsuario cu;
	
	private JTextField textFieldNickName;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldNacionalidad;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AltaDeTurista frame = new AltaDeTurista();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AltaDeTurista(IUsuario controlUsr) {
		cu = controlUsr;
		
		setBounds(100, 100, 371, 300);	
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 65, 0, 65, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNickName = new JLabel("NickName");
		GridBagConstraints gbc_lblNickName = new GridBagConstraints();
		gbc_lblNickName.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickName.gridx = 1;
		gbc_lblNickName.gridy = 1;
		getContentPane().add(lblNickName, gbc_lblNickName);
		
		textFieldNickName = new JTextField();
		GridBagConstraints gbc_textFieldNickName = new GridBagConstraints();
		gbc_textFieldNickName.gridwidth = 3;
		gbc_textFieldNickName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNickName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNickName.gridx = 2;
		gbc_textFieldNickName.gridy = 1;
		getContentPane().add(textFieldNickName, gbc_textFieldNickName);
		textFieldNickName.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.gridwidth = 3;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 2;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 3;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		textFieldApellido = new JTextField();
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.gridwidth = 3;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.gridx = 2;
		gbc_textFieldApellido.gridy = 3;
		getContentPane().add(textFieldApellido, gbc_textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 4;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.gridwidth = 3;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 4;
		getContentPane().add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
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
		
		JComboBox<Integer> comboBoxDia = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBoxDia = new GridBagConstraints();
		gbc_comboBoxDia.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDia.gridx = 2;
		gbc_comboBoxDia.gridy = 6;
		getContentPane().add(comboBoxDia, gbc_comboBoxDia);
		for(int i = 1; i <= 31; i++) {
			comboBoxDia.addItem(i);
		}
		
		JComboBox<Integer> comboBoxMes = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBoxMes = new GridBagConstraints();
		gbc_comboBoxMes.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMes.gridx = 3;
		gbc_comboBoxMes.gridy = 6;
		getContentPane().add(comboBoxMes, gbc_comboBoxMes);
		for(int i = 1; i <= 12; i++) {
			comboBoxMes.addItem(i);
		}
		
		JComboBox<Integer> comboBoxAño = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBoxAño = new GridBagConstraints();
		gbc_comboBoxAño.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAño.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAño.gridx = 4;
		gbc_comboBoxAño.gridy = 6;
		getContentPane().add(comboBoxAño, gbc_comboBoxAño);
		for(int i = 1900; i <= 2030; i++) {
			comboBoxAño.addItem(i);
		}
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		GridBagConstraints gbc_lblNacionalidad = new GridBagConstraints();
		gbc_lblNacionalidad.anchor = GridBagConstraints.EAST;
		gbc_lblNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblNacionalidad.gridx = 1;
		gbc_lblNacionalidad.gridy = 7;
		getContentPane().add(lblNacionalidad, gbc_lblNacionalidad);
		
		textFieldNacionalidad = new JTextField();
		GridBagConstraints gbc_textFieldNacionalidad = new GridBagConstraints();
		gbc_textFieldNacionalidad.gridwidth = 3;
		gbc_textFieldNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNacionalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNacionalidad.gridx = 2;
		gbc_textFieldNacionalidad.gridy = 7;
		getContentPane().add(textFieldNacionalidad, gbc_textFieldNacionalidad);
		textFieldNacionalidad.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					altaTuristaActionPerformed();
				} catch (UsuarioRepetidoException ex) {
                }
			}
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 9;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
                setVisible(false);
			}
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 9;
		getContentPane().add(btnCancelar, gbc_btnCancelar);

	}
	
	protected void altaTuristaActionPerformed() throws UsuarioRepetidoException {
		String nickname = this.textFieldNickName.getText();
		String nombre = this.textFieldNombre.getText();
        String apellido = this.textFieldApellido.getText();
        String email = this.textFieldEmail.getText();
        String nacionalidad = this.textFieldNacionalidad.getText();
        
        if (checkFormulario()) {
        		try {
            		LocalDate date = LocalDate.now();
                    cu.altaTurista(nickname, nombre, apellido, email, date , nacionalidad);

                    // Muestro éxito de la operación
                    JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario", JOptionPane.INFORMATION_MESSAGE);
                    
                    limpiarFormulario();
                    setVisible(false);

                } catch (UsuarioRepetidoException e) {
                    // Muestro error de registro
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
                    throw new UsuarioRepetidoException("Es usuario esta Repetido");

                }

        }
	}
	
	protected boolean checkFormulario(){
		String nickname = this.textFieldNickName.getText();
		String nombre = this.textFieldNombre.getText();
        String apellido = this.textFieldApellido.getText();
        String email = this.textFieldEmail.getText();
        String nacionalidad = this.textFieldNacionalidad.getText();
        
        if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || nacionalidad.isEmpty()) {
        	JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
        

	}
	
	private void limpiarFormulario() {
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldNickName.setText("");
        textFieldNacionalidad.setText("");
        textFieldEmail.setText("");
    }

}
