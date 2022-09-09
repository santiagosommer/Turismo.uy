package EstacionDeTrabajo.GUI;

import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;
import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import ServidorCentral.Logica.DataTypes.DTInscripcion;
import ServidorCentral.Logica.DataTypes.DTProveedor;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.Excepciones.UsuarioNoExisteException;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;

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
import java.awt.Font;
import javax.swing.UIManager;

public class ConsultaDeUsuario extends JInternalFrame {
	
	private IUsuario cu;
	private ITuristica ct;
	private JFrame principalFrame;
	
	JComboBox<String> comboBoxListUsuarios;
	private JLabel lblDescripcionNacionalidad;
	private JLabel lblLinkWeb;
	JComboBox<String> comboBoxListaTuristicas;
	private JLabel lblTuristicas;
	private JLabel lblUsuarios;
	private JLabel textFieldNickName;
	private JLabel textFieldNombre;
	private JLabel textFieldApellido;
	private JLabel textFieldEmail;
	private JLabel textFieldFecha;
	private JLabel textFieldDescripcionNacionalidad;
	private JLabel textFieldLinkWeb;
	private JButton btnInfo;
	
	

	public ConsultaDeUsuario(IUsuario controladorUsuario, ITuristica CTuri, JFrame principal) {
		setTitle("Consulta de Usuario");
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		cu = controladorUsuario;
		ct = CTuri;
		principalFrame = principal;
		
		setBounds(100, 100, 777, 688);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{37, 143, 266, 0, 33, 0};
		gridBagLayout.rowHeights = new int[]{32, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		comboBoxListUsuarios = new JComboBox<String>();
		comboBoxListUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetearInfo();
				listarDataUsuarioActionPerformed();
			}
		});
		
		lblUsuarios = new JLabel("Usuarios (NickNames)");
		GridBagConstraints gbc_lblUsuarios = new GridBagConstraints();
		gbc_lblUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuarios.gridx = 1;
		gbc_lblUsuarios.gridy = 1;
		getContentPane().add(lblUsuarios, gbc_lblUsuarios);
		GridBagConstraints gbc_comboBoxListUsuarios = new GridBagConstraints();
		gbc_comboBoxListUsuarios.gridwidth = 2;
		gbc_comboBoxListUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxListUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxListUsuarios.gridx = 2;
		gbc_comboBoxListUsuarios.gridy = 1;
		getContentPane().add(comboBoxListUsuarios, gbc_comboBoxListUsuarios);
		
		JLabel lblNickName = new JLabel("NickName");
		GridBagConstraints gbc_lblNickName = new GridBagConstraints();
		gbc_lblNickName.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickName.gridx = 1;
		gbc_lblNickName.gridy = 2;
		getContentPane().add(lblNickName, gbc_lblNickName);
		
		textFieldNickName = new JLabel("New label");
		textFieldNickName.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldNickName = new GridBagConstraints();
		gbc_textFieldNickName.gridwidth = 2;
		gbc_textFieldNickName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNickName.gridx = 2;
		gbc_textFieldNickName.gridy = 2;
		getContentPane().add(textFieldNickName, gbc_textFieldNickName);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JLabel("New label");
		textFieldNombre.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.gridwidth = 2;
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 3;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 4;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		textFieldApellido = new JLabel("New label");
		textFieldApellido.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.gridwidth = 2;
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellido.gridx = 2;
		gbc_textFieldApellido.gridy = 4;
		getContentPane().add(textFieldApellido, gbc_textFieldApellido);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 5;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JLabel("New label");
		textFieldEmail.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.gridwidth = 2;
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 5;
		getContentPane().add(textFieldEmail, gbc_textFieldEmail);
		
		JLabel lblFecha = new JLabel("Fecha");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 6;
		getContentPane().add(lblFecha, gbc_lblFecha);
		
		textFieldFecha = new JLabel("New label");
		textFieldFecha.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldFecha = new GridBagConstraints();
		gbc_textFieldFecha.gridwidth = 2;
		gbc_textFieldFecha.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFecha.gridx = 2;
		gbc_textFieldFecha.gridy = 6;
		getContentPane().add(textFieldFecha, gbc_textFieldFecha);
		
		lblDescripcionNacionalidad = new JLabel("DescripcionNacionalidad");
		GridBagConstraints gbc_lblDescripcionNacionalidad = new GridBagConstraints();
		gbc_lblDescripcionNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionNacionalidad.gridx = 1;
		gbc_lblDescripcionNacionalidad.gridy = 7;
		getContentPane().add(lblDescripcionNacionalidad, gbc_lblDescripcionNacionalidad);
		lblDescripcionNacionalidad.setVisible(false);
		
		textFieldDescripcionNacionalidad = new JLabel("New label");
		textFieldDescripcionNacionalidad.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldDescripcionNacionalidad = new GridBagConstraints();
		gbc_textFieldDescripcionNacionalidad.gridwidth = 2;
		gbc_textFieldDescripcionNacionalidad.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescripcionNacionalidad.gridx = 2;
		gbc_textFieldDescripcionNacionalidad.gridy = 7;
		getContentPane().add(textFieldDescripcionNacionalidad, gbc_textFieldDescripcionNacionalidad);
		
		lblLinkWeb = new JLabel("LinkWeb");
		GridBagConstraints gbc_lblLinkWeb = new GridBagConstraints();
		gbc_lblLinkWeb.insets = new Insets(0, 0, 5, 5);
		gbc_lblLinkWeb.gridx = 1;
		gbc_lblLinkWeb.gridy = 8;
		getContentPane().add(lblLinkWeb, gbc_lblLinkWeb);
		lblLinkWeb.setVisible(false);
		
		comboBoxListaTuristicas = new JComboBox<String>();
		comboBoxListaTuristicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				resetearInfoExtra();
//				listarDataTuristicaActionPerformed();
			}
		});
		
		textFieldLinkWeb = new JLabel("New label");
		textFieldLinkWeb.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldLinkWeb = new GridBagConstraints();
		gbc_textFieldLinkWeb.gridwidth = 2;
		gbc_textFieldLinkWeb.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLinkWeb.gridx = 2;
		gbc_textFieldLinkWeb.gridy = 8;
		getContentPane().add(textFieldLinkWeb, gbc_textFieldLinkWeb);
		
		lblTuristicas = new JLabel("New label");
		GridBagConstraints gbc_lblTuristicas = new GridBagConstraints();
		gbc_lblTuristicas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTuristicas.gridx = 1;
		gbc_lblTuristicas.gridy = 9;
		getContentPane().add(lblTuristicas, gbc_lblTuristicas);
		lblTuristicas.setVisible(false);
		GridBagConstraints gbc_comboBoxListaTuristicas = new GridBagConstraints();
		gbc_comboBoxListaTuristicas.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxListaTuristicas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxListaTuristicas.gridx = 2;
		gbc_comboBoxListaTuristicas.gridy = 9;
		getContentPane().add(comboBoxListaTuristicas, gbc_comboBoxListaTuristicas);
		comboBoxListaTuristicas.setVisible(false);
		
		btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarDataTuristicaActionPerformed();
			}
		});
		GridBagConstraints gbc_btnInfo = new GridBagConstraints();
		gbc_btnInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnInfo.gridx = 3;
		gbc_btnInfo.gridy = 9;
		getContentPane().add(btnInfo, gbc_btnInfo);

	}
	
	protected void listarDataTuristicaActionPerformed() {
		if(comboBoxListaTuristicas.getSelectedIndex() == -1) return;
		String datoSeleccionado = comboBoxListaTuristicas.getSelectedItem().toString();
		String dato = datoSeleccionado.replace("Actividad: ", "");
		dato = dato.replace("Salida: ", "");
		if (ct.existeActividad(dato)) {
			ct.seleccionarActividad(dato);
			DTActividadTuristica dtat = ct.getDTActividadTuristica();
			
			InfoActividad popupSalida = new InfoActividad(dtat);
			popupSalida.setBounds(0, 0, 660, 200);
			principalFrame.getContentPane().add(popupSalida);
			principalFrame.getContentPane().setComponentZOrder(popupSalida, 0);
			
			
			
		}else {
			ct.seleccionarSalida(dato);
			DTSalidaTuristica dtst = ct.getDTSalidaTuristica();
			
			InfoSalida popupSalida = new InfoSalida(dtst);
			popupSalida.setBounds(0, 0, 660, 180);
			principalFrame.getContentPane().add(popupSalida);
			principalFrame.getContentPane().setComponentZOrder(popupSalida, 0);
			
			
		}
		
	}

	protected void listarDataUsuarioActionPerformed() {
		if (comboBoxListUsuarios.getSelectedIndex() == -1)return;
		String userSelected = comboBoxListUsuarios.getSelectedItem().toString();
		comboBoxListaTuristicas.removeAllItems();
		comboBoxListaTuristicas.setVisible(false);
		btnInfo.setVisible(false);
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
			
			if (!ins.isEmpty()) {
				
				for (DTInscripcion dtInscripcion : ins) {
					comboBoxListaTuristicas.addItem(dtInscripcion.getSalidaAsociada().getNombre());
				}
				
				comboBoxListaTuristicas.setVisible(true);
				btnInfo.setVisible(true);
				comboBoxListaTuristicas.setSelectedIndex(-1);
				
				lblTuristicas.setText("Salidas Inscripto");
				lblTuristicas.setVisible(true);
				
				
			}else {
				lblTuristicas.setText("No hay Salidas Inscripto");
				lblTuristicas.setVisible(true);
			}
			
			
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
			for (DTActividadTuristica dtAT : act) {
				comboBoxListaTuristicas.addItem("Actividad: " + dtAT.getNombre());
				ArrayList<DTSalidaTuristica> salidas = dtAT.getSalidas();
				for (DTSalidaTuristica salida : salidas) {
					comboBoxListaTuristicas.addItem("Salida: " + salida.getNombre());	
				}
			}
			
			if (!act.isEmpty()) {
				comboBoxListaTuristicas.setVisible(true);
				btnInfo.setVisible(true);
				comboBoxListaTuristicas.setSelectedIndex(-1);
				
				lblTuristicas.setText("Actividades que Provee");
				lblTuristicas.setVisible(true);
				
				
			}else {
				lblTuristicas.setText("No hay Actividades que Provee");
				lblTuristicas.setVisible(true);
			}
			
		}
	}
	
	public void cargarUsuarios() {
		try {
			Set<String> set = cu.listarUsuarios();
			Iterator<String> itr = set.iterator();
			while(itr.hasNext()) {
				comboBoxListUsuarios.addItem(itr.next());
			}

			comboBoxListUsuarios.setSelectedIndex(-1);
		}catch (UsuarioNoExisteException e) {
            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
        }

	}
	
	protected void cerrarConsultaUsuario(){
		comboBoxListUsuarios.removeAllItems();
		comboBoxListUsuarios.setSelectedIndex(-1);
		comboBoxListaTuristicas.removeAllItems();
		comboBoxListaTuristicas.setSelectedIndex(-1);
		comboBoxListaTuristicas.setVisible(false);
		btnInfo.setVisible(false);
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
		lblTuristicas.setVisible(false);
		
		
		setVisible(false);
		
	}
	
	protected void resetearInfo(){
		comboBoxListaTuristicas.removeAllItems();
		comboBoxListaTuristicas.setSelectedIndex(-1);
		comboBoxListaTuristicas.setVisible(false);
		btnInfo.setVisible(false);
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
		lblTuristicas.setVisible(false);
		
		
	}
	
}
