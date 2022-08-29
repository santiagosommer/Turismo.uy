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
	private ITuristica ct;
	
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
	private JLabel lblProveedor;
	private JTextField textFieldProveedor;
	private JTextField textFieldDepartamento;
	private JTextField textFieldNombreTuristica;
	private JTextField textFieldDescripcionFecha;
	private JTextField textFieldDuracionHora;
	private JTextField textFieldCostoLugar;
	private JTextField textFieldCiudadCantMax;
	private JLabel lblDepartamento;
	private JLabel lblNombreTuristica;
	private JLabel lblDescripcionFecha;
	private JLabel lblDuracionHora;
	private JLabel lblCostoLugar;
	private JLabel lblCiudadCantMax;
	private JTextField textFieldFechaDeAlta;
	private JLabel lblFechaDeAlta;
	private JButton btnConsultarExtra;
	
	

	public ConsultaDeUsuario(IUsuario controladorUsuario, ITuristica CTuri) {
		setResizable(true);
		cu = controladorUsuario;
		ct = CTuri;
		
		setBounds(100, 100, 462, 688);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 143, 266, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				resetearInfo();
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
		
		btnConsultarExtra = new JButton("ConsultarExtra");
		btnConsultarExtra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetearInfoExtra();
				listarDataTuristicaActionPerformed();
			}
		});
		GridBagConstraints gbc_btnConsultarExtra = new GridBagConstraints();
		gbc_btnConsultarExtra.gridwidth = 2;
		gbc_btnConsultarExtra.insets = new Insets(0, 0, 5, 5);
		gbc_btnConsultarExtra.gridx = 1;
		gbc_btnConsultarExtra.gridy = 12;
		getContentPane().add(btnConsultarExtra, gbc_btnConsultarExtra);
		btnConsultarExtra.setVisible(false);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarConsultaUsuario();
			}
		});
		
		lblProveedor = new JLabel("Proveedor");
		GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
		gbc_lblProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProveedor.gridx = 1;
		gbc_lblProveedor.gridy = 13;
		getContentPane().add(lblProveedor, gbc_lblProveedor);
		lblProveedor.setVisible(false);
		
		textFieldProveedor = new JTextField();
		textFieldProveedor.setEditable(false);
		GridBagConstraints gbc_textFieldProveedor = new GridBagConstraints();
		gbc_textFieldProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldProveedor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldProveedor.gridx = 2;
		gbc_textFieldProveedor.gridy = 13;
		getContentPane().add(textFieldProveedor, gbc_textFieldProveedor);
		textFieldProveedor.setColumns(10);
		textFieldProveedor.setVisible(false);
		
		lblDepartamento = new JLabel("Departamento");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.gridx = 1;
		gbc_lblDepartamento.gridy = 14;
		getContentPane().add(lblDepartamento, gbc_lblDepartamento);
		lblDepartamento.setVisible(false);
		
		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setEditable(false);
		GridBagConstraints gbc_textFieldDepartamento = new GridBagConstraints();
		gbc_textFieldDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDepartamento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDepartamento.gridx = 2;
		gbc_textFieldDepartamento.gridy = 14;
		getContentPane().add(textFieldDepartamento, gbc_textFieldDepartamento);
		textFieldDepartamento.setColumns(10);
		textFieldDepartamento.setVisible(false);
		
		lblNombreTuristica = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombreTuristica = new GridBagConstraints();
		gbc_lblNombreTuristica.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreTuristica.gridx = 1;
		gbc_lblNombreTuristica.gridy = 15;
		getContentPane().add(lblNombreTuristica, gbc_lblNombreTuristica);
		lblNombreTuristica.setVisible(false);
		
		textFieldNombreTuristica = new JTextField();
		textFieldNombreTuristica.setEditable(false);
		GridBagConstraints gbc_textFieldNombreTuristica = new GridBagConstraints();
		gbc_textFieldNombreTuristica.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNombreTuristica.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNombreTuristica.gridx = 2;
		gbc_textFieldNombreTuristica.gridy = 15;
		getContentPane().add(textFieldNombreTuristica, gbc_textFieldNombreTuristica);
		textFieldNombreTuristica.setColumns(10);
		textFieldNombreTuristica.setVisible(false);
		
		lblDescripcionFecha = new JLabel("Descripcion\\Fecha");
		GridBagConstraints gbc_lblDescripcionFecha = new GridBagConstraints();
		gbc_lblDescripcionFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionFecha.gridx = 1;
		gbc_lblDescripcionFecha.gridy = 16;
		getContentPane().add(lblDescripcionFecha, gbc_lblDescripcionFecha);
		lblDescripcionFecha.setVisible(false);
		
		textFieldDescripcionFecha = new JTextField();
		textFieldDescripcionFecha.setEditable(false);
		GridBagConstraints gbc_textFieldDescripcionFecha = new GridBagConstraints();
		gbc_textFieldDescripcionFecha.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDescripcionFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescripcionFecha.gridx = 2;
		gbc_textFieldDescripcionFecha.gridy = 16;
		getContentPane().add(textFieldDescripcionFecha, gbc_textFieldDescripcionFecha);
		textFieldDescripcionFecha.setColumns(10);
		textFieldDescripcionFecha.setVisible(false);
		
		lblDuracionHora = new JLabel("Duracion\\Hora");
		GridBagConstraints gbc_lblDuracionHora = new GridBagConstraints();
		gbc_lblDuracionHora.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracionHora.gridx = 1;
		gbc_lblDuracionHora.gridy = 17;
		getContentPane().add(lblDuracionHora, gbc_lblDuracionHora);
		lblDuracionHora.setVisible(false);
		
		textFieldDuracionHora = new JTextField();
		textFieldDuracionHora.setEditable(false);
		GridBagConstraints gbc_textFieldDuracionHora = new GridBagConstraints();
		gbc_textFieldDuracionHora.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDuracionHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDuracionHora.gridx = 2;
		gbc_textFieldDuracionHora.gridy = 17;
		getContentPane().add(textFieldDuracionHora, gbc_textFieldDuracionHora);
		textFieldDuracionHora.setColumns(10);
		textFieldDuracionHora.setVisible(false);
		
		lblCostoLugar = new JLabel("Costo\\Lugar");
		GridBagConstraints gbc_lblCostoLugar = new GridBagConstraints();
		gbc_lblCostoLugar.insets = new Insets(0, 0, 5, 5);
		gbc_lblCostoLugar.gridx = 1;
		gbc_lblCostoLugar.gridy = 18;
		getContentPane().add(lblCostoLugar, gbc_lblCostoLugar);
		lblCostoLugar.setVisible(false);
		
		textFieldCostoLugar = new JTextField();
		textFieldCostoLugar.setEditable(false);
		GridBagConstraints gbc_textFieldCostoLugar = new GridBagConstraints();
		gbc_textFieldCostoLugar.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCostoLugar.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCostoLugar.gridx = 2;
		gbc_textFieldCostoLugar.gridy = 18;
		getContentPane().add(textFieldCostoLugar, gbc_textFieldCostoLugar);
		textFieldCostoLugar.setColumns(10);
		textFieldCostoLugar.setVisible(false);
		
		lblCiudadCantMax = new JLabel("Ciudad\\CantMax");
		GridBagConstraints gbc_lblCiudadCantMax = new GridBagConstraints();
		gbc_lblCiudadCantMax.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudadCantMax.gridx = 1;
		gbc_lblCiudadCantMax.gridy = 19;
		getContentPane().add(lblCiudadCantMax, gbc_lblCiudadCantMax);
		lblCiudadCantMax.setVisible(false);
		
		textFieldCiudadCantMax = new JTextField();
		textFieldCiudadCantMax.setEditable(false);
		GridBagConstraints gbc_textFieldCiudadCantMax = new GridBagConstraints();
		gbc_textFieldCiudadCantMax.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCiudadCantMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCiudadCantMax.gridx = 2;
		gbc_textFieldCiudadCantMax.gridy = 19;
		getContentPane().add(textFieldCiudadCantMax, gbc_textFieldCiudadCantMax);
		textFieldCiudadCantMax.setColumns(10);
		textFieldCiudadCantMax.setVisible(false);
		
		lblFechaDeAlta = new JLabel("FechaDeAlta");
		GridBagConstraints gbc_lblFechaDeAlta = new GridBagConstraints();
		gbc_lblFechaDeAlta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeAlta.gridx = 1;
		gbc_lblFechaDeAlta.gridy = 20;
		getContentPane().add(lblFechaDeAlta, gbc_lblFechaDeAlta);
		lblFechaDeAlta.setVisible(false);
		
		textFieldFechaDeAlta = new JTextField();
		textFieldFechaDeAlta.setEditable(false);
		GridBagConstraints gbc_textFieldFechaDeAlta = new GridBagConstraints();
		gbc_textFieldFechaDeAlta.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFechaDeAlta.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFechaDeAlta.gridx = 2;
		gbc_textFieldFechaDeAlta.gridy = 20;
		getContentPane().add(textFieldFechaDeAlta, gbc_textFieldFechaDeAlta);
		textFieldFechaDeAlta.setVisible(false);
		
		textFieldFechaDeAlta.setColumns(10);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.gridwidth = 2;
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 1;
		gbc_btnSalir.gridy = 21;
		getContentPane().add(btnSalir, gbc_btnSalir);

	}
	
	protected void listarDataTuristicaActionPerformed() {
		String datoSeleccionado = comboBoxListaTuristicas.getSelectedItem().toString();
		String dato = datoSeleccionado.replace("Actividad: ", "");
		dato = dato.replace("Salida: ", "");
		if (ct.existeActividad(dato)) {
			ct.seleccionarActividad(dato);
			DTActividadTuristica dtat = ct.getDTActividadTuristica();
			lblProveedor.setVisible(true);
			lblDepartamento.setVisible(true);
			lblNombreTuristica.setVisible(true);
			lblDescripcionFecha.setText("Descripcion");
			lblDescripcionFecha.setVisible(true);
			lblDuracionHora.setText("Duracion (En hs)");
			lblDuracionHora.setVisible(true);
			lblCostoLugar.setText("Costo");
			lblCostoLugar.setVisible(true);
			lblCiudadCantMax.setText("Ciudad");
			lblCiudadCantMax.setVisible(true);
			lblFechaDeAlta.setVisible(true);
			textFieldProveedor.setText(dtat.getProveedor());
			textFieldProveedor.setVisible(true);
			textFieldDepartamento.setText(dtat.getInfoDepartamento().getNombre());
			textFieldDepartamento.setVisible(true);
			textFieldNombreTuristica.setText(dtat.getNombre());
			textFieldNombreTuristica.setVisible(true);
			textFieldDescripcionFecha.setText(dtat.getDescripcion());
			textFieldDescripcionFecha.setVisible(true);
			textFieldDuracionHora.setText(String.valueOf(dtat.getDuracion()));
			textFieldDuracionHora.setVisible(true);
			textFieldCostoLugar.setText(String.valueOf(dtat.getCostoTurista()));
			textFieldCostoLugar.setVisible(true);
			textFieldCiudadCantMax.setText(dtat.getCiudad());
			textFieldCiudadCantMax.setVisible(true);
			textFieldFechaDeAlta.setText(dtat.getFechaAlta().toString());
			textFieldFechaDeAlta.setVisible(true);
			
		}else {
			ct.seleccionarSalida(dato);
			DTSalidaTuristica dtst = ct.getDTSalidaTuristica();
			lblNombreTuristica.setVisible(true);
			lblDescripcionFecha.setText("Fecha");
			lblDescripcionFecha.setVisible(true);
			lblDuracionHora.setText("Hora");
			lblDuracionHora.setVisible(true);
			lblCostoLugar.setText("Lugar");
			lblCostoLugar.setVisible(true);
			lblCiudadCantMax.setText("CantMax Turistas");
			lblCiudadCantMax.setVisible(true);
			lblFechaDeAlta.setVisible(true);
			textFieldNombreTuristica.setText(dtst.getNombre());
			textFieldNombreTuristica.setVisible(true);
			textFieldDescripcionFecha.setText(dtst.getInfoSalida().getFecha().toString());
			textFieldDescripcionFecha.setVisible(true);
			textFieldDuracionHora.setText(dtst.getInfoSalida().getHora().toString());
			textFieldDuracionHora.setVisible(true);
			textFieldCostoLugar.setText(dtst.getInfoSalida().getLugar());
			textFieldCostoLugar.setVisible(true);
			textFieldCiudadCantMax.setText(String.valueOf(dtst.getCantidadMaxTuristas()));
			textFieldCiudadCantMax.setVisible(true);
			textFieldFechaDeAlta.setText(dtst.getFechaAlta().toString());
			textFieldFechaDeAlta.setVisible(true);
			
		}
		
	}

	protected void listarDataUsuarioActionPerformed() {
		String userSelected = comboBoxListUsuarios.getSelectedItem().toString();
		comboBoxListaTuristicas.removeAllItems();
		comboBoxListaTuristicas.setVisible(false);
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
				
				lblTuristicas.setText("Salidas Inscripto");
				lblTuristicas.setVisible(true);
				
				btnConsultarExtra.setVisible(true);
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
				
				lblTuristicas.setText("Actividades que Provee");
				lblTuristicas.setVisible(true);
				
				btnConsultarExtra.setVisible(true);
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
		}catch (UsuarioNoExisteException e) {
            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
        }

	}
	
	protected void cerrarConsultaUsuario(){
		comboBoxListUsuarios.removeAllItems();
		comboBoxListaTuristicas.removeAllItems();
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
		lblProveedor.setVisible(false);
		lblDepartamento.setVisible(false);
		lblNombreTuristica.setVisible(false);
		lblDescripcionFecha.setVisible(false);
		lblDuracionHora.setVisible(false);
		lblCostoLugar.setVisible(false);
		lblCiudadCantMax.setVisible(false);
		lblFechaDeAlta.setVisible(false);
		textFieldProveedor.setVisible(false);
		textFieldDepartamento.setVisible(false);
		textFieldNombreTuristica.setVisible(false);
		textFieldDescripcionFecha.setVisible(false);
		textFieldDuracionHora.setVisible(false);
		textFieldCostoLugar.setVisible(false);
		textFieldCiudadCantMax.setVisible(false);
		textFieldFechaDeAlta.setVisible(false);
		btnConsultarExtra.setVisible(false);
		
		setVisible(false);
		
	}
	
	protected void resetearInfo(){
		comboBoxListaTuristicas.removeAllItems();
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
		lblProveedor.setVisible(false);
		lblDepartamento.setVisible(false);
		lblNombreTuristica.setVisible(false);
		lblDescripcionFecha.setVisible(false);
		lblDuracionHora.setVisible(false);
		lblCostoLugar.setVisible(false);
		lblCiudadCantMax.setVisible(false);
		lblFechaDeAlta.setVisible(false);
		textFieldProveedor.setVisible(false);
		textFieldDepartamento.setVisible(false);
		textFieldNombreTuristica.setVisible(false);
		textFieldDescripcionFecha.setVisible(false);
		textFieldDuracionHora.setVisible(false);
		textFieldCostoLugar.setVisible(false);
		textFieldCiudadCantMax.setVisible(false);
		textFieldFechaDeAlta.setVisible(false);
		btnConsultarExtra.setVisible(false);
		
		
	}
	
	protected void resetearInfoExtra(){
		lblProveedor.setVisible(false);
		lblDepartamento.setVisible(false);
		lblNombreTuristica.setVisible(false);
		lblDescripcionFecha.setVisible(false);
		lblDuracionHora.setVisible(false);
		lblCostoLugar.setVisible(false);
		lblCiudadCantMax.setVisible(false);
		lblFechaDeAlta.setVisible(false);
		textFieldProveedor.setVisible(false);
		textFieldDepartamento.setVisible(false);
		textFieldNombreTuristica.setVisible(false);
		textFieldDescripcionFecha.setVisible(false);
		textFieldDuracionHora.setVisible(false);
		textFieldCostoLugar.setVisible(false);
		textFieldCiudadCantMax.setVisible(false);
		textFieldFechaDeAlta.setVisible(false);
		
	}
}
