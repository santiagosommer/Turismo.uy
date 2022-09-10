package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.JInternalFrame;

import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;
import java.awt.GridLayout;
import java.awt.Label;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import java.awt.List;
import java.awt.PopupMenu;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ConsultaDeActividadTuristica extends JInternalFrame {
	
	private ITuristica interfazTuristica;
	
	private JComboBox<Object> comboDepartamentos;
	private JComboBox<Object> comboActividades;
	private JComboBox<String> comboSalidas;
	private JComboBox<String> comboPaquetes;
	
	private JLabel lblActividades;
	
	private JLabel lblNombre;
	private JLabel lblNombreContent;

	private JLabel lblDescripcion;
	private JLabel lblDescripcionContent;

	private JLabel lblProveedor;
	private JLabel lblproveedor;

	private JLabel lblCiudad;
	private JLabel lblCiudadContent;

	private JLabel lblDuracion;
	private JLabel lblDuracionContent;

	private JLabel lblCostoPorTurista;
	private JLabel lblCostoPorTuristaContent;

	private JLabel lblFechaDeAlta;
	private JLabel lblFechaDeAltaContent;

	private JLabel lblDepartamento;
	private JLabel lblDepartamentoContent;
	
	private JLabel lblSalidas;
	private JLabel lblPaquetes;
	
	private JButton btnInfo;
	private JButton btnInfo_1;
	
	private JScrollPane scrollPane;

	
	public void limpiarFormulario() {
		comboDepartamentos.removeAllItems();
		comboActividades.removeAllItems();
		comboSalidas.removeAllItems();
		comboPaquetes.removeAllItems();
		
		Set<String> deps = interfazTuristica.listarDepartamentos();
		for (String string : deps) {
			comboDepartamentos.addItem(string);
		}
		
		comboDepartamentos.setSelectedIndex(-1);
		comboActividades.setSelectedIndex(-1);
		comboSalidas.setSelectedIndex(-1);
		comboPaquetes.setSelectedIndex(-1);
		
		comboActividades.setVisible(false);
		lblActividades.setVisible(false);
		
		toggleInfoContentVisibility(false);
		
	}
	
	private void toggleInfoContentVisibility(Boolean state) {
		lblNombre.setVisible(state);
		lblNombreContent.setVisible(state);
		
		lblDescripcion.setVisible(state);
		lblDescripcionContent.setVisible(state);
		
		lblProveedor.setVisible(state);
		lblproveedor.setVisible(state);
		
		lblCiudad.setVisible(state);
		lblCiudadContent.setVisible(state);
		
		lblDuracion.setVisible(state);
		lblDuracionContent.setVisible(state);
		
		lblCostoPorTurista.setVisible(state);
		lblCostoPorTuristaContent.setVisible(state);
		
		lblFechaDeAlta.setVisible(state);
		lblFechaDeAltaContent.setVisible(state);
		
		lblDepartamento.setVisible(state);
		lblDepartamentoContent.setVisible(state);
		
		lblSalidas.setVisible(state);
		lblPaquetes.setVisible(state);
		
		comboSalidas.setVisible(state);
		comboPaquetes.setVisible(state);
		
		btnInfo.setVisible(state);
		btnInfo_1.setVisible(state);
		
		scrollPane.setVisible(state);		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ITuristica InterfazTuristica, IPaquete InterfazPaquete, JFrame principal) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDeActividadTuristica frame = new ConsultaDeActividadTuristica(InterfazTuristica, InterfazPaquete, principal);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ConsultaDeActividadTuristica(ITuristica interfazTuristica, IPaquete interfazPaquete, JFrame principalFrame) {
		getContentPane().setEnabled(false);
		setResizable(true);
		setClosable(true);
		setTitle("Consulta de Actividad Turistica");
		setVisible(false);
		this.interfazTuristica = interfazTuristica;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 156, 488, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 65, 30, 30, 30, 30, 30, 30, 0, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
				
		JLabel lblNewLabel = new JLabel("Departamento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		comboDepartamentos = new JComboBox<>();
		GridBagConstraints gbc_comboDepartamentos = new GridBagConstraints();
		gbc_comboDepartamentos.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboDepartamentos.insets = new Insets(0, 0, 5, 5);
		gbc_comboDepartamentos.gridx = 2;
		gbc_comboDepartamentos.gridy = 1;
		getContentPane().add(comboDepartamentos, gbc_comboDepartamentos);
		comboDepartamentos.setSelectedIndex(-1);
		
		
		comboDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboDepartamentos.getSelectedIndex() != -1) {	
					String dptoElegido = comboDepartamentos.getSelectedItem().toString();
					interfazTuristica.seleccionarDepartamento(dptoElegido);
					Set<String> actividadesDeDpto = interfazTuristica.listarActividadesDeDepartamento(dptoElegido);
					comboActividades.removeAllItems();
					for (String actividad : actividadesDeDpto) {
						comboActividades.addItem(actividad);
					}
					lblActividades.setVisible(true);
					comboActividades.setVisible(true);
					
					comboActividades.setSelectedIndex(-1);
					
					toggleInfoContentVisibility(false);

				}
			}
		});
		
		lblActividades = new JLabel("Actividades");
		GridBagConstraints gbc_lblActividades = new GridBagConstraints();
		gbc_lblActividades.insets = new Insets(0, 0, 5, 5);
		gbc_lblActividades.gridx = 1;
		gbc_lblActividades.gridy = 2;
		getContentPane().add(lblActividades, gbc_lblActividades);
		lblActividades.setHorizontalAlignment(SwingConstants.LEFT);
		
		comboActividades = new JComboBox<>();
		GridBagConstraints gbc_comboActividades = new GridBagConstraints();
		gbc_comboActividades.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboActividades.insets = new Insets(0, 0, 5, 5);
		gbc_comboActividades.gridx = 2;
		gbc_comboActividades.gridy = 2;
		getContentPane().add(comboActividades, gbc_comboActividades);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		lblNombreContent = new JLabel("\"Nombre\"");
		GridBagConstraints gbc_lblNombreContent = new GridBagConstraints();
		gbc_lblNombreContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreContent.gridx = 2;
		gbc_lblNombreContent.gridy = 4;
		getContentPane().add(lblNombreContent, gbc_lblNombreContent);
		
		lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 5;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 5;
		getContentPane().add(scrollPane, gbc_scrollPane);
		
		lblDescripcionContent = new JLabel("\"Descripcion\"");
		scrollPane.setViewportView(lblDescripcionContent);
		
		lblProveedor = new JLabel("Proveedor:");
		GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
		gbc_lblProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProveedor.gridx = 1;
		gbc_lblProveedor.gridy = 6;
		getContentPane().add(lblProveedor, gbc_lblProveedor);
		
		lblproveedor = new JLabel("\"Proveedor\"");
		GridBagConstraints gbc_lblproveedor = new GridBagConstraints();
		gbc_lblproveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblproveedor.gridx = 2;
		gbc_lblproveedor.gridy = 6;
		getContentPane().add(lblproveedor, gbc_lblproveedor);
		
		lblDuracion = new JLabel("Duracion:");
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 1;
		gbc_lblDuracion.gridy = 7;
		getContentPane().add(lblDuracion, gbc_lblDuracion);
		
		lblDuracionContent = new JLabel("\"Duracion\"");
		GridBagConstraints gbc_lblDuracionContent = new GridBagConstraints();
		gbc_lblDuracionContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracionContent.gridx = 2;
		gbc_lblDuracionContent.gridy = 7;
		getContentPane().add(lblDuracionContent, gbc_lblDuracionContent);
		
		lblCostoPorTurista = new JLabel("Costo por Turista:");
		GridBagConstraints gbc_lblCostoPorTurista = new GridBagConstraints();
		gbc_lblCostoPorTurista.insets = new Insets(0, 0, 5, 5);
		gbc_lblCostoPorTurista.gridx = 1;
		gbc_lblCostoPorTurista.gridy = 8;
		getContentPane().add(lblCostoPorTurista, gbc_lblCostoPorTurista);
		
		lblCostoPorTuristaContent = new JLabel("$300");
		GridBagConstraints gbc_lblCostoPorTuristaContent = new GridBagConstraints();
		gbc_lblCostoPorTuristaContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblCostoPorTuristaContent.gridx = 2;
		gbc_lblCostoPorTuristaContent.gridy = 8;
		getContentPane().add(lblCostoPorTuristaContent, gbc_lblCostoPorTuristaContent);
		
		lblFechaDeAlta = new JLabel("Fecha de Alta:");
		GridBagConstraints gbc_lblFechaDeAlta = new GridBagConstraints();
		gbc_lblFechaDeAlta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeAlta.gridx = 1;
		gbc_lblFechaDeAlta.gridy = 9;
		getContentPane().add(lblFechaDeAlta, gbc_lblFechaDeAlta);
		
		lblFechaDeAltaContent = new JLabel("30/4/2020");
		GridBagConstraints gbc_lblFechaDeAltaContent = new GridBagConstraints();
		gbc_lblFechaDeAltaContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeAltaContent.gridx = 2;
		gbc_lblFechaDeAltaContent.gridy = 9;
		getContentPane().add(lblFechaDeAltaContent, gbc_lblFechaDeAltaContent);
		
		lblCiudad = new JLabel("Ciudad: ");
		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
		gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudad.gridx = 1;
		gbc_lblCiudad.gridy = 10;
		getContentPane().add(lblCiudad, gbc_lblCiudad);
		
		lblCiudadContent = new JLabel("\"Ciudad\"");
		GridBagConstraints gbc_lblCiudadContent = new GridBagConstraints();
		gbc_lblCiudadContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblCiudadContent.gridx = 2;
		gbc_lblCiudadContent.gridy = 10;
		getContentPane().add(lblCiudadContent, gbc_lblCiudadContent);
		
		lblDepartamento = new JLabel("Departamento:");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.gridx = 1;
		gbc_lblDepartamento.gridy = 11;
		getContentPane().add(lblDepartamento, gbc_lblDepartamento);
		
		lblDepartamentoContent = new JLabel("\"Departamento\"");
		GridBagConstraints gbc_lblDepartamentoContent = new GridBagConstraints();
		gbc_lblDepartamentoContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamentoContent.gridx = 2;
		gbc_lblDepartamentoContent.gridy = 11;
		getContentPane().add(lblDepartamentoContent, gbc_lblDepartamentoContent);
		
		lblSalidas = new JLabel("Salidas:");
		GridBagConstraints gbc_lblSalidas = new GridBagConstraints();
		gbc_lblSalidas.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalidas.gridx = 1;
		gbc_lblSalidas.gridy = 13;
		getContentPane().add(lblSalidas, gbc_lblSalidas);
		
		comboSalidas = new JComboBox<>();
		GridBagConstraints gbc_comboSalidas = new GridBagConstraints();
		gbc_comboSalidas.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboSalidas.insets = new Insets(0, 0, 5, 5);
		gbc_comboSalidas.gridx = 2;
		gbc_comboSalidas.gridy = 13;
		getContentPane().add(comboSalidas, gbc_comboSalidas);
		
		btnInfo = new JButton("Info");
		GridBagConstraints gbc_btnInfo = new GridBagConstraints();
		gbc_btnInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnInfo.gridx = 3;
		gbc_btnInfo.gridy = 13;
		getContentPane().add(btnInfo, gbc_btnInfo);
		
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboSalidas.getSelectedIndex() != -1) {
					interfazTuristica.seleccionarActividad(comboActividades.getSelectedItem().toString());
					interfazTuristica.seleccionarSalida(comboSalidas.getSelectedItem().toString());
					InfoSalida popupSalida = new InfoSalida(interfazTuristica.getDTSalidaTuristica());
					principalFrame.getContentPane().add(popupSalida);
					principalFrame.getContentPane().setComponentZOrder(popupSalida, 2);
				}
			}
		});
		
		lblPaquetes = new JLabel("Paquetes:");
		GridBagConstraints gbc_lblPaquetes = new GridBagConstraints();
		gbc_lblPaquetes.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaquetes.gridx = 1;
		gbc_lblPaquetes.gridy = 14;
		getContentPane().add(lblPaquetes, gbc_lblPaquetes);
		
		comboPaquetes = new JComboBox<>();
		GridBagConstraints gbc_comboPaquetes = new GridBagConstraints();
		gbc_comboPaquetes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboPaquetes.insets = new Insets(0, 0, 5, 5);
		gbc_comboPaquetes.gridx = 2;
		gbc_comboPaquetes.gridy = 14;
		getContentPane().add(comboPaquetes, gbc_comboPaquetes);
		
		btnInfo_1 = new JButton("Info");
		GridBagConstraints gbc_btnInfo_1 = new GridBagConstraints();
		gbc_btnInfo_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnInfo_1.gridx = 3;
		gbc_btnInfo_1.gridy = 14;
		getContentPane().add(btnInfo_1, gbc_btnInfo_1);
		btnInfo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboPaquetes.getSelectedIndex() != -1) {
					interfazPaquete.seleccionarPaquete(comboPaquetes.getSelectedItem().toString());
					InfoPaquete popupSalida = new InfoPaquete(interfazPaquete.getDtPaquete());
					principalFrame.getContentPane().add(popupSalida);
					principalFrame.getContentPane().setComponentZOrder(popupSalida, 2);
				}
			}
		});
		
		comboActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboActividades.getSelectedItem() != null) {
					toggleInfoContentVisibility(true);
					
					interfazTuristica.seleccionarActividad(comboActividades.getSelectedItem().toString());
					DTActividadTuristica actividadElegida = interfazTuristica.getDTActividadTuristica();
					
					lblNombreContent.setText(actividadElegida.getNombre());		
					lblDescripcionContent.setText("<html>" + actividadElegida.getDescripcion() + "</html>");
					lblproveedor.setText(actividadElegida.getProveedor());
					lblCiudadContent.setText(actividadElegida.getCiudad());
					lblDuracionContent.setText(String.valueOf(actividadElegida.getDuracion()));
					lblCostoPorTuristaContent.setText("$"+String.valueOf(actividadElegida.getCostoTurista()));
					lblFechaDeAltaContent.setText(actividadElegida.getFechaAlta().toString());
					lblDepartamentoContent.setText(actividadElegida.getInfoDepartamento().getNombre());
					
					comboSalidas.removeAllItems();
					Set<String> listaSalidas = interfazTuristica.listarSalidasActividad(actividadElegida.getNombre());
					for (String salida : listaSalidas) {
						comboSalidas.addItem(salida);
					}
					comboSalidas.setSelectedIndex(-1);
					
					comboPaquetes.removeAllItems();
					ArrayList<DTPaquete> listaPaquetes = actividadElegida.getInfoPaquetes();
					for (DTPaquete paquete : listaPaquetes) {
						comboPaquetes.addItem(paquete.getNombre());
					}
					comboPaquetes.setSelectedIndex(-1);
					
				}
			}
		});	
	}
}


