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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ConsultaDeUsuario extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUsuario cu;
	private ITuristica ct;
	private JFrame principalFrame;
	
	JComboBox<String> comboBoxListUsuarios;
	private JLabel lblDescripcionNacionalidad;
	private JLabel lblLinkWeb;
	private JLabel lblNickName;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblEmail;
	private JLabel lblFecha;
	
	JComboBox<String> comboBoxActividades;
	JComboBox<String> comboBoxSalidas;
	private JLabel lblTuristicas;
	private JLabel lblUsuarios;
	private JLabel textFieldNickName;
	private JLabel textFieldNombre;
	private JLabel textFieldApellido;
	private JLabel textFieldEmail;
	private JLabel textFieldFecha; 
	private JLabel textFieldDescripcionNacionalidad;
	private JLabel textFieldLinkWeb;
	private JButton btnInfoAT;
	private JButton btnInfoSalidas;
	private JLabel lblSalidas;
	
	

	public ConsultaDeUsuario(IUsuario controladorUsuario, ITuristica CTuri, JFrame principal) {
		setTitle("Consulta de Usuario");
		setMaximizable(true);
		setClosable(true);
		setResizable(true);
		cu = controladorUsuario;
		ct = CTuri;
		principalFrame = principal;
		
		setBounds(100, 100, 777, 473);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{37, 244, 266, 0, 0, 33, 0};
		gridBagLayout.rowHeights = new int[] {35, 35, 35, 35, 35, 35, 35, 35, 35, 0, 35, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 2.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		comboBoxListUsuarios = new JComboBox<String>();
		comboBoxListUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetearInfo();
				listarDataUsuarioActionPerformed();
			}
		});
		
		lblUsuarios = new JLabel("Usuarios (Nicknames)");
		GridBagConstraints gbc_lblUsuarios = new GridBagConstraints();
		gbc_lblUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuarios.gridx = 1;
		gbc_lblUsuarios.gridy = 1;
		getContentPane().add(lblUsuarios, gbc_lblUsuarios);
		GridBagConstraints gbc_comboBoxListUsuarios = new GridBagConstraints();
		gbc_comboBoxListUsuarios.gridwidth = 3;
		gbc_comboBoxListUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxListUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxListUsuarios.gridx = 2;
		gbc_comboBoxListUsuarios.gridy = 1;
		getContentPane().add(comboBoxListUsuarios, gbc_comboBoxListUsuarios);
		
		lblNickName = new JLabel("Nickname");
		GridBagConstraints gbc_lblNickName = new GridBagConstraints();
		gbc_lblNickName.insets = new Insets(0, 0, 5, 5);
		gbc_lblNickName.gridx = 1;
		gbc_lblNickName.gridy = 2;
		getContentPane().add(lblNickName, gbc_lblNickName);
		
		textFieldNickName = new JLabel("New label");
		textFieldNickName.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldNickName = new GridBagConstraints();
		gbc_textFieldNickName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNickName.gridx = 2;
		gbc_textFieldNickName.gridy = 2;
		getContentPane().add(textFieldNickName, gbc_textFieldNickName);
		
		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		textFieldNombre = new JLabel("New label");
		textFieldNombre.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombre.gridx = 2;
		gbc_textFieldNombre.gridy = 3;
		getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		
		lblApellido = new JLabel("Apellido");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 4;
		getContentPane().add(lblApellido, gbc_lblApellido);
		
		textFieldApellido = new JLabel("New label");
		textFieldApellido.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldApellido.gridx = 2;
		gbc_textFieldApellido.gridy = 4;
		getContentPane().add(textFieldApellido, gbc_textFieldApellido);
		
		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 5;
		getContentPane().add(lblEmail, gbc_lblEmail);
		
		textFieldEmail = new JLabel("New label");
		textFieldEmail.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
		gbc_textFieldEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEmail.gridx = 2;
		gbc_textFieldEmail.gridy = 5;
		getContentPane().add(textFieldEmail, gbc_textFieldEmail);
		
		 lblFecha = new JLabel("Fecha");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 6;
		getContentPane().add(lblFecha, gbc_lblFecha);
		
		textFieldFecha = new JLabel("New label");
		textFieldFecha.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldFecha = new GridBagConstraints();
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
		
		comboBoxActividades = new JComboBox<String>();
		comboBoxActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				resetearInfoExtra();
//				listarDataTuristicaActionPerformed();
				comboBoxSalidas.removeAllItems();
				if (comboBoxActividades.getSelectedIndex() != -1) 
				{
					CTuri.seleccionarActividad(comboBoxActividades.getSelectedItem().toString());
					DTActividadTuristica dtAct = CTuri.getDTActividadTuristica();
					
					if (dtAct != null) 
					{
						ArrayList<DTSalidaTuristica> dtSalidas =  dtAct.getSalidas();
						for (DTSalidaTuristica salida : dtSalidas) comboBoxSalidas.addItem(salida.getNombre());
						if (!dtSalidas.isEmpty()) 
						{
							lblSalidas.setVisible(true);
							lblSalidas.setText("Salidas Asociadas a Actividad");
							comboBoxSalidas.setVisible(true);
							btnInfoSalidas.setVisible(true);
							comboBoxSalidas.setSelectedIndex(-1);
						}
					}
				}
			}
		});
		
		textFieldLinkWeb = new JLabel("New label");
		textFieldLinkWeb.setFont(UIManager.getFont("Label.font"));
		GridBagConstraints gbc_textFieldLinkWeb = new GridBagConstraints();
		gbc_textFieldLinkWeb.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLinkWeb.gridx = 2;
		gbc_textFieldLinkWeb.gridy = 8;
		getContentPane().add(textFieldLinkWeb, gbc_textFieldLinkWeb);
		
		lblTuristicas = new JLabel("Actividades Asociadas");
		GridBagConstraints gbc_lblTuristicas = new GridBagConstraints();
		gbc_lblTuristicas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTuristicas.gridx = 1;
		gbc_lblTuristicas.gridy = 10;
		getContentPane().add(lblTuristicas, gbc_lblTuristicas);
		lblTuristicas.setVisible(false);
		GridBagConstraints gbc_comboBoxActividades = new GridBagConstraints();
		gbc_comboBoxActividades.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxActividades.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxActividades.gridx = 2;
		gbc_comboBoxActividades.gridy = 10;
		getContentPane().add(comboBoxActividades, gbc_comboBoxActividades);
		comboBoxActividades.setVisible(false);
		
		btnInfoAT = new JButton("Info");
		btnInfoAT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarDataTuristicaActionPerformed();
			}
		});
		GridBagConstraints gbc_btnInfoAT = new GridBagConstraints();
		gbc_btnInfoAT.anchor = GridBagConstraints.WEST;
		gbc_btnInfoAT.insets = new Insets(0, 0, 5, 5);
		gbc_btnInfoAT.gridx = 3;
		gbc_btnInfoAT.gridy = 10;
		getContentPane().add(btnInfoAT, gbc_btnInfoAT);
		
		lblSalidas = new JLabel("Salidas Asociadas a Actividad");
		GridBagConstraints gbc_lblSalidas = new GridBagConstraints();
		gbc_lblSalidas.insets = new Insets(0, 0, 0, 5);
		gbc_lblSalidas.gridx = 1;
		gbc_lblSalidas.gridy = 11;
		getContentPane().add(lblSalidas, gbc_lblSalidas);
		
		comboBoxSalidas = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxSalidas = new GridBagConstraints();
		gbc_comboBoxSalidas.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxSalidas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSalidas.gridx = 2;
		gbc_comboBoxSalidas.gridy = 11;
		getContentPane().add(comboBoxSalidas, gbc_comboBoxSalidas);
		
		btnInfoSalidas = new JButton("Info");
		btnInfoSalidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listarDataSalidaActionPerformed();
			}
		});
		GridBagConstraints gbc_btnInfoSalidas = new GridBagConstraints();
		gbc_btnInfoSalidas.anchor = GridBagConstraints.WEST;
		gbc_btnInfoSalidas.insets = new Insets(0, 0, 0, 5);
		gbc_btnInfoSalidas.gridx = 3;
		gbc_btnInfoSalidas.gridy = 11;
		getContentPane().add(btnInfoSalidas, gbc_btnInfoSalidas);

	}
	
	protected void listarDataTuristicaActionPerformed() {
		if(comboBoxActividades.getSelectedIndex() == -1) return;
		String dato = comboBoxActividades.getSelectedItem().toString();
		if (ct.existeActividad(dato)) {
			ct.seleccionarActividad(dato);
			DTActividadTuristica dtat = ct.getDTActividadTuristica();
			InfoActividad popupActividad = new InfoActividad(dtat);
			principalFrame.getContentPane().add(popupActividad);
			principalFrame.getContentPane().setComponentZOrder(popupActividad, 2);
		}
	}

	protected void listarDataSalidaActionPerformed() {
		if(comboBoxSalidas.getSelectedIndex() == -1) return;
		String dato = comboBoxSalidas.getSelectedItem().toString();
		ct.seleccionarSalida(dato);
		DTSalidaTuristica dtst = ct.getDTSalidaTuristica();
		
		InfoSalida popupSalida = new InfoSalida(dtst);
		principalFrame.getContentPane().add(popupSalida);
		principalFrame.getContentPane().setComponentZOrder(popupSalida, 2);		
	}

	protected void listarDataUsuarioActionPerformed() {
		comboBoxActividades.removeAllItems();
		if (comboBoxListUsuarios.getSelectedIndex() == -1) return;
		String userSelected = comboBoxListUsuarios.getSelectedItem().toString();
		comboBoxActividades.setVisible(false);
		btnInfoAT.setVisible(false);
		
		lblNickName.setVisible(true);
		lblNombre.setVisible(true);
		lblApellido.setVisible(true);
		lblEmail.setVisible(true);
		lblFecha.setVisible(true);
		
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
					comboBoxSalidas.addItem(dtInscripcion.getSalidaAsociada().getNombre());
				}
				
				comboBoxSalidas.setVisible(true);
				btnInfoSalidas.setVisible(true);
				comboBoxSalidas.setSelectedIndex(-1);
				
				lblSalidas.setText("Salidas Inscripto");
				lblSalidas.setVisible(true);
				
				
			}else {
				lblSalidas.setText("No hay Salidas Inscripto");
				lblSalidas.setVisible(true);
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
				comboBoxActividades.addItem(dtAT.getNombre());
			}
			
			if (!act.isEmpty()) {
				
				lblTuristicas.setVisible(true);
				comboBoxActividades.setVisible(true);
				btnInfoAT.setVisible(true);
				comboBoxActividades.setSelectedIndex(-1);
				
				lblSalidas.setVisible(false);
				comboBoxSalidas.setVisible(false);
				btnInfoSalidas.setVisible(false);
				comboBoxSalidas.setSelectedIndex(-1);
				
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
		comboBoxActividades.removeAllItems();
		comboBoxActividades.setSelectedIndex(-1);
		comboBoxActividades.setVisible(false);
		comboBoxSalidas.setVisible(false);
		
		lblNickName.setVisible(false);
		lblNombre.setVisible(false);
		lblApellido.setVisible(false);
		lblEmail.setVisible(false);
		lblFecha.setVisible(false);
		
		
		
		
		
		btnInfoAT.setVisible(false);
		btnInfoSalidas.setVisible(false);
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
		lblSalidas.setVisible(false);
		setVisible(false);
		
	}
	
	protected void resetearInfo(){
		comboBoxActividades.removeAllItems();
		comboBoxActividades.setVisible(false);
		comboBoxActividades.setSelectedIndex(-1);
		comboBoxSalidas.removeAllItems();
		comboBoxSalidas.setVisible(false);
		comboBoxSalidas.setSelectedIndex(-1);
		
		btnInfoAT.setVisible(false);
		btnInfoSalidas.setVisible(false);
		
		
		textFieldNickName.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldEmail.setText("");
		textFieldFecha.setText("");
		textFieldDescripcionNacionalidad.setText("");
		
		lblNickName.setVisible(false);
		lblNombre.setVisible(false);
		lblApellido.setVisible(false);
		lblEmail.setVisible(false);
		lblFecha.setVisible(false);
		textFieldDescripcionNacionalidad.setVisible(false);
		lblDescripcionNacionalidad.setVisible(false);
		lblLinkWeb.setVisible(false);
		textFieldLinkWeb.setVisible(false);
		lblTuristicas.setVisible(false);
		lblSalidas.setVisible(false);
		
		
	}
	
}
