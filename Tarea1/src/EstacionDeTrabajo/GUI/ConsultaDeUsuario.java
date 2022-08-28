package EstacionDeTrabajo.GUI;

import ServidorCentral.Logica.Interfaces.IUsuario;
import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import ServidorCentral.Logica.DataTypes.DTInscripcion;
import ServidorCentral.Logica.DataTypes.DTProveedor;
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.Excepciones.UsuarioNoExisteException;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaDeUsuario extends JInternalFrame {
	
	private IUsuario cu;
	
	JComboBox<String> comboBoxListUsuarios;
	private JTextField textFieldNickName;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldFecha;
	private JTextField textFieldDescripcionNacionalidad;
	private JTextField textFieldLinkWeb;
	private JLabel lblDescripcionNacionalidad;
	private JLabel lblLinkWeb;
	private JButton btnSalir;
	JComboBox<String> comboBoxListaTuristicas;
	private JLabel lblTuristicas;
	
	

	public ConsultaDeUsuario(IUsuario controladorUsuario) {
		cu = controladorUsuario;
		setBounds(100, 100, 462, 460);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 143, 266, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		comboBoxListUsuarios = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxListUsuarios = new GridBagConstraints();
		gbc_comboBoxListUsuarios.gridwidth = 2;
		gbc_comboBoxListUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxListUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxListUsuarios.gridx = 1;
		gbc_comboBoxListUsuarios.gridy = 1;
		getContentPane().add(comboBoxListUsuarios, gbc_comboBoxListUsuarios);
		
		JButton btnSeleccionarUsuario = new JButton("Seleccionar");
		btnSeleccionarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarDataUsuarioActionPerformed();
			}
		});
		GridBagConstraints gbc_btnSeleccionarUsuario = new GridBagConstraints();
		gbc_btnSeleccionarUsuario.gridwidth = 2;
		gbc_btnSeleccionarUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_btnSeleccionarUsuario.gridx = 1;
		gbc_btnSeleccionarUsuario.gridy = 2;
		getContentPane().add(btnSeleccionarUsuario, gbc_btnSeleccionarUsuario);
		
		JLabel lblNickName = new JLabel("NickName");
		GridBagConstraints gbc_lblNickName = new GridBagConstraints();
		gbc_lblNickName.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickName.gridx = 1;
		gbc_lblNickName.gridy = 3;
		getContentPane().add(lblNickName, gbc_lblNickName);
		
		textFieldNickName = new JTextField();
		textFieldNickName.setEditable(false);
		GridBagConstraints gbc_textFieldNickName = new GridBagConstraints();
		gbc_textFieldNickName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNickName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNickName.gridx = 2;
		gbc_textFieldNickName.gridy = 3;
		getContentPane().add(textFieldNickName, gbc_textFieldNickName);
		textFieldNickName.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 4;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 5;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldApellido.gridx = 2;
		gbc_textFieldApellido.gridy = 5;
		getContentPane().add(textFieldApellido, gbc_textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 6;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 6;
		getContentPane().add(textFieldEmail, gbc_textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 7;
		getContentPane().add(lblFecha, gbc_lblFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setEditable(false);
		GridBagConstraints gbc_textFieldFecha = new GridBagConstraints();
		gbc_textFieldFecha.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFecha.gridx = 2;
		gbc_textFieldFecha.gridy = 7;
		getContentPane().add(textFieldFecha, gbc_textFieldFecha);
		textFieldFecha.setColumns(10);
		
		lblDescripcionNacionalidad = new JLabel("DescripcionNacionalidad");
		GridBagConstraints gbc_lblDescripcionNacionalidad = new GridBagConstraints();
		gbc_lblDescripcionNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionNacionalidad.gridx = 1;
		gbc_lblDescripcionNacionalidad.gridy = 8;
		getContentPane().add(lblDescripcionNacionalidad, gbc_lblDescripcionNacionalidad);
		lblDescripcionNacionalidad.setVisible(false);
		
		textFieldDescripcionNacionalidad = new JTextField();
		textFieldDescripcionNacionalidad.setEditable(false);
		GridBagConstraints gbc_textFieldDescripcionNacionalidad = new GridBagConstraints();
		gbc_textFieldDescripcionNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescripcionNacionalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescripcionNacionalidad.gridx = 2;
		gbc_textFieldDescripcionNacionalidad.gridy = 8;
		getContentPane().add(textFieldDescripcionNacionalidad, gbc_textFieldDescripcionNacionalidad);
		textFieldDescripcionNacionalidad.setColumns(10);
		textFieldDescripcionNacionalidad.setVisible(false);
		
		lblLinkWeb = new JLabel("LinkWeb");
		GridBagConstraints gbc_lblLinkWeb = new GridBagConstraints();
		gbc_lblLinkWeb.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinkWeb.gridx = 1;
		gbc_lblLinkWeb.gridy = 9;
		getContentPane().add(lblLinkWeb, gbc_lblLinkWeb);
		lblLinkWeb.setVisible(false);
		
		textFieldLinkWeb = new JTextField();
		textFieldLinkWeb.setEditable(false);
		GridBagConstraints gbc_textFieldLinkWeb = new GridBagConstraints();
		gbc_textFieldLinkWeb.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLinkWeb.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLinkWeb.gridx = 2;
		gbc_textFieldLinkWeb.gridy = 9;
		getContentPane().add(textFieldLinkWeb, gbc_textFieldLinkWeb);
		textFieldLinkWeb.setColumns(10);
		textFieldLinkWeb.setVisible(false);
		
		lblTuristicas = new JLabel("New label");
		GridBagConstraints gbc_lblTuristicas = new GridBagConstraints();
		gbc_lblTuristicas.gridwidth = 2;
		gbc_lblTuristicas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTuristicas.gridx = 1;
		gbc_lblTuristicas.gridy = 10;
		getContentPane().add(lblTuristicas, gbc_lblTuristicas);
		lblTuristicas.setVisible(false);
		
		comboBoxListaTuristicas = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxListaTuristicas = new GridBagConstraints();
		gbc_comboBoxListaTuristicas.gridwidth = 2;
		gbc_comboBoxListaTuristicas.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxListaTuristicas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxListaTuristicas.gridx = 1;
		gbc_comboBoxListaTuristicas.gridy = 11;
		getContentPane().add(comboBoxListaTuristicas, gbc_comboBoxListaTuristicas);
		comboBoxListaTuristicas.setVisible(false);
		
		JButton btnConsultarExtra = new JButton("ConsultarExtra");
		GridBagConstraints gbc_btnConsultarExtra = new GridBagConstraints();
		gbc_btnConsultarExtra.gridwidth = 2;
		gbc_btnConsultarExtra.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultarExtra.gridx = 1;
		gbc_btnConsultarExtra.gridy = 12;
		getContentPane().add(btnConsultarExtra, gbc_btnConsultarExtra);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarConsultaUsuario();
			}
		});
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.gridwidth = 2;
		gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalir.gridx = 1;
		gbc_btnSalir.gridy = 13;
		getContentPane().add(btnSalir, gbc_btnSalir);

	}
	
	protected void listarDataUsuarioActionPerformed() {
		String userSelected = comboBoxListUsuarios.getSelectedItem().toString();
		if(cu.esTurista(userSelected)) {
			cu.seleccionarTurista(userSelected);
			DTTurista dtt = cu.getDTTurista();
			textFieldNickName.setText(dtt.getNickname());
			textFieldNombre.setText(dtt.getNombre());
			textFieldApellido.setText(dtt.getApellido());
			textFieldEmail.setText(dtt.getEmail());
			textFieldFecha.setText(dtt.getFechaNacimiento().toString());
			textFieldDescripcionNacionalidad.setText(dtt.getNacionalidad());
			textFieldDescripcionNacionalidad.setVisible(true);
			lblDescripcionNacionalidad.setText("Nacionalidad");
			lblDescripcionNacionalidad.setVisible(true);
			
			ArrayList<DTInscripcion> ins = dtt.getInscripciones();
			
			Iterator<DTInscripcion> iter = ins.iterator();
			while (iter.hasNext()) {
				comboBoxListaTuristicas.addItem(iter.next().getSalidaAsociada().getNombre());
			}
			
			comboBoxListaTuristicas.setVisible(true);
			
			lblTuristicas.setText("Salidas Inscripto");
			lblTuristicas.setVisible(true);
			
		}else {
			cu.seleccionarProveedor(userSelected);
			DTProveedor dtp = cu.getDTProveedor();
			textFieldNickName.setText(dtp.getNickname());
			textFieldNombre.setText(dtp.getNombre());
			textFieldApellido.setText(dtp.getApellido());
			textFieldEmail.setText(dtp.getEmail());
			textFieldFecha.setText(dtp.getFechaNacimiento().toString());
			textFieldDescripcionNacionalidad.setText(dtp.getDescripcionGeneral());
			textFieldDescripcionNacionalidad.setVisible(true);
			lblDescripcionNacionalidad.setText("Descripcion");
			lblDescripcionNacionalidad.setVisible(true);
			textFieldLinkWeb.setText(dtp.getURL());
			lblLinkWeb.setVisible(true);
			textFieldLinkWeb.setVisible(true);
			
			ArrayList<DTActividadTuristica> act = dtp.getActividades();
			
			Iterator<DTActividadTuristica> iter = act.iterator();
			while (iter.hasNext()) {
				comboBoxListaTuristicas.addItem(iter.next().getNombre());
			}
			
			comboBoxListaTuristicas.setVisible(true);
			
			lblTuristicas.setText("Actividades que Provee");
			lblTuristicas.setVisible(true);
			
		}
	}
	
	public void cargarUsuarios() {
		try {
			Set<String> set = cu.listarUsuarios();
			Iterator<String> itr = set.iterator();
			while(itr.hasNext()) {
				comboBoxListUsuarios.addItem(itr.next());
			}
		}catch (UsuarioNoExisteException e) {
            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
        }

	}
	
	protected void cerrarConsultaUsuario(){
		comboBoxListUsuarios.removeAllItems();
		textFieldNickName.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldEmail.setText("");
		textFieldFecha.setText("");
		textFieldDescripcionNacionalidad.setText("");
		textFieldDescripcionNacionalidad.setVisible(false);
		lblDescripcionNacionalidad.setVisible(false);
		lblLinkWeb.setVisible(false);
		textFieldLinkWeb.setVisible(false);
		setVisible(false);
		
	}
}
