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

public class ConsultaDeActividadTuristica extends JInternalFrame {
	
	private JComboBox<Object> comboDepartamentos;
	private JPanel panelActividades;
	private JComboBox<Object> comboActividades;
	private JPanel panelInfo;
	private JComboBox<String> comboSalidas;
	private JComboBox<String> comboPaquetes;
	
	public void limpiarFormulario() {
		comboDepartamentos.setSelectedIndex(-1);
		comboActividades.setSelectedIndex(-1);
		comboSalidas.setSelectedIndex(-1);
		comboPaquetes.setSelectedIndex(-1);
		
		panelActividades.setVisible(false);
		panelInfo.setVisible(false);
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
		setResizable(true);
		setClosable(true);
		setTitle("Consulta de Actividad Turistica");
		setBounds(100, 100, 536, 344);
		getContentPane().setLayout(null);
		setVisible(false);
		
		JPanel panelBase = new JPanel();
		panelBase.setBounds(12, 12, 502, 288);
		getContentPane().add(panelBase);
		panelBase.setLayout(null);
		
		JPanel panelDepartamentos = new JPanel();
		panelDepartamentos.setBounds(0, 0, 502, 29);
		panelBase.add(panelDepartamentos);
		panelDepartamentos.setLayout(new BoxLayout(panelDepartamentos, BoxLayout.X_AXIS));
		
		JLabel lblNewLabel = new JLabel("Departamento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panelDepartamentos.add(lblNewLabel);
		
		panelDepartamentos.add(Box.createRigidArea(new Dimension(10,0)));
		
		comboDepartamentos = new JComboBox<>(interfazTuristica.listarDepartamentos().toArray());
		comboDepartamentos.setMaximumRowCount(4);
		comboDepartamentos.setSelectedIndex(-1);
		panelDepartamentos.add(comboDepartamentos);
		
		panelActividades = new JPanel();
		panelActividades.setBounds(0, 29, 502, 29);
		panelBase.add(panelActividades);
		panelActividades.setLayout(new BoxLayout(panelActividades, BoxLayout.X_AXIS));
		panelActividades.setVisible(false);
		
		JLabel lblActividades = new JLabel("Actividades");
		lblActividades.setHorizontalAlignment(SwingConstants.LEFT);
		panelActividades.add(lblActividades);
		
		Component rigidArea = Box.createRigidArea(new Dimension(32, 0));
		panelActividades.add(rigidArea);
		
		comboActividades = new JComboBox<>();
		panelActividades.add(comboActividades);
		
		panelInfo = new JPanel();
		panelInfo.setBounds(0, 58, 502, 229);
		panelBase.add(panelInfo);
		panelInfo.setLayout(new GridLayout(0, 2, 0, 0));
		panelInfo.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panelInfo.add(lblNombre);
		
		JLabel lblNombreContent = new JLabel("\"Nombre\"");
		panelInfo.add(lblNombreContent);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		panelInfo.add(lblDescripcion);
		
		JLabel lblDescripcionContent = new JLabel("\"Descripcion\"");
		panelInfo.add(lblDescripcionContent);
		
		JLabel lblDuracion = new JLabel("Duracion:");
		panelInfo.add(lblDuracion);
		
		JLabel lblDuracionContent = new JLabel("\"Duracion\"");
		panelInfo.add(lblDuracionContent);
		
		JLabel lblCostoPorTurista = new JLabel("Costo por Turista:");
		panelInfo.add(lblCostoPorTurista);
		
		JLabel lblCostoPorTuristaContent = new JLabel("$300");
		panelInfo.add(lblCostoPorTuristaContent);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta:");
		panelInfo.add(lblFechaDeAlta);
		
		JLabel lblFechaDeAltaContent = new JLabel("30/4/2020");
		panelInfo.add(lblFechaDeAltaContent);
		
		JLabel lblCiudad = new JLabel("Ciudad: ");
		panelInfo.add(lblCiudad);
		
		JLabel lblCiudadContent = new JLabel("\"Ciudad\"");
		panelInfo.add(lblCiudadContent);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		panelInfo.add(lblDepartamento);
		
		JLabel lblDepartamentoContent = new JLabel("\"Departamento\"");
		panelInfo.add(lblDepartamentoContent);
		
		JLabel lblSalidas = new JLabel("Salidas:");
		panelInfo.add(lblSalidas);
		
		JPanel panelSalidas = new JPanel();
		panelInfo.add(panelSalidas);
		panelSalidas.setLayout(new BoxLayout(panelSalidas, BoxLayout.X_AXIS));
		
		comboSalidas = new JComboBox<>();
		panelSalidas.add(comboSalidas);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboSalidas.getSelectedIndex() != -1) {
					interfazTuristica.seleccionarActividad(comboActividades.getSelectedItem().toString());
					interfazTuristica.seleccionarSalida(comboSalidas.getSelectedItem().toString());
					InfoSalida popupSalida = new InfoSalida(interfazTuristica.getDTSalidaTuristica());
					popupSalida.setBounds(0, 0, 400, 400);
					principalFrame.getContentPane().add(popupSalida);
					principalFrame.getContentPane().setComponentZOrder(popupSalida, 2);
				}
			}
		});
		panelSalidas.add(btnInfo);
		
		JLabel lblPaquetes = new JLabel("Paquetes:");
		panelInfo.add(lblPaquetes);
		
		JPanel panelPaquetes = new JPanel();
		panelInfo.add(panelPaquetes);
		panelPaquetes.setLayout(new BoxLayout(panelPaquetes, BoxLayout.X_AXIS));
		
		comboPaquetes = new JComboBox<>();
		panelPaquetes.add(comboPaquetes);
		
		JButton btnInfo_1 = new JButton("Info");
		btnInfo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboPaquetes.getSelectedIndex() != -1) {
					System.out.println("Presionado boton de paquetes");
				}
			}
		});
		panelPaquetes.add(btnInfo_1);
		
		
		comboDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboDepartamentos.getSelectedIndex() != -1) {
					panelActividades.setVisible(true);			
					String dptoElegido = comboDepartamentos.getSelectedItem().toString();
					interfazTuristica.seleccionarDepartamento(dptoElegido);
					Set<String> actividadesDeDpto = interfazTuristica.listarActividadesDeDepartamento(dptoElegido);
					comboActividades.removeAllItems();
					for (String actividad : actividadesDeDpto) {
						comboActividades.addItem(actividad);
					}
				}
			}
		});
		
		comboActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboActividades.getSelectedItem() != null) {
					panelInfo.setVisible(true);
					interfazTuristica.seleccionarActividad(comboActividades.getSelectedItem().toString());		
					DTActividadTuristica actividadElegida = interfazTuristica.getDTActividadTuristica();
					lblNombreContent.setText(actividadElegida.getNombre());		
					lblDescripcionContent.setText(actividadElegida.getDescripcion());
					lblCiudadContent.setText(actividadElegida.getCiudad());
					lblDuracionContent.setText(String.valueOf(actividadElegida.getDuracion()));
					lblCostoPorTuristaContent.setText(String.valueOf(actividadElegida.getCostoTurista()));
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


