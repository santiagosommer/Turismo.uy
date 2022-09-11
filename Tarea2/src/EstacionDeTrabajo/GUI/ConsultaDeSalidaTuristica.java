package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;

import ServidorCentral.Logica.Clases.SalidaTuristica;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;


import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToggleButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.GridLayout;

public class ConsultaDeSalidaTuristica extends JInternalFrame {
	
	
  private JComboBox<String> comboBoxDepartamentos;
  private JComboBox<String> comboActividades;
  private JComboBox<String> comboSalidas;
  private JButton btnInfo;
  
	/**
	 * Create the frame.
	 */
	public ConsultaDeSalidaTuristica(ITuristica controladorTuristica, JFrame principalFrame) {
		setMaximizable(true);
		setResizable(true);
		setTitle("Consulta de Salida Turistica");
		
		
		setClosable(true);
		setBounds(100, 100, 476, 243);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {221, 360, 0};
		gridBagLayout.rowHeights = new int[] {35, 35, 35, 35, 35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
	      
		  JLabel lblNewLabel = new JLabel("Departamento");
		  GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		  gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		  gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		  gbc_lblNewLabel.gridx = 0;
		  gbc_lblNewLabel.gridy = 1;
		  getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		 
		  comboBoxDepartamentos = new JComboBox<String>();
		  
		  GridBagConstraints gbc_comboBoxDepartamentos = new GridBagConstraints();
		  gbc_comboBoxDepartamentos.fill = GridBagConstraints.BOTH;
		  gbc_comboBoxDepartamentos.insets = new Insets(0, 0, 5, 5);
		  gbc_comboBoxDepartamentos.gridx = 1;
		  gbc_comboBoxDepartamentos.gridy = 1;
		  getContentPane().add(comboBoxDepartamentos, gbc_comboBoxDepartamentos);
		  comboBoxDepartamentos.setSelectedIndex(-1);
	     JLabel lblNewLabel_1 = new JLabel("Actividades Turisticas");
	     GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
	     gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
	     gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
	     gbc_lblNewLabel_1.gridx = 0;
	     gbc_lblNewLabel_1.gridy = 2;
	     getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
	     
	     comboActividades = new JComboBox<String>();
	     
	     
	     GridBagConstraints gbc_comboActividades = new GridBagConstraints();
	     gbc_comboActividades.fill = GridBagConstraints.BOTH;
	     gbc_comboActividades.insets = new Insets(0, 0, 5, 5);
	     gbc_comboActividades.gridx = 1;
	     gbc_comboActividades.gridy = 2;
	     getContentPane().add(comboActividades, gbc_comboActividades);
	     
	    
	     
	     JLabel lblNewLabel_2 = new JLabel("Salidas Turisticas");
	     GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
	     gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
	     gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
	     gbc_lblNewLabel_2.gridx = 0;
	     gbc_lblNewLabel_2.gridy = 3;
	     getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
	     comboSalidas = new JComboBox<String>();
	     GridBagConstraints gbc_comboSalidas = new GridBagConstraints();
	     gbc_comboSalidas.fill = GridBagConstraints.BOTH;
	     gbc_comboSalidas.insets = new Insets(0, 0, 5, 5);
	     gbc_comboSalidas.gridx = 1;
	     gbc_comboSalidas.gridy = 3;
	     getContentPane().add(comboSalidas, gbc_comboSalidas);
	     
	     
		  comboBoxDepartamentos.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
		  			comboActividades.removeAllItems();
			  		if (comboBoxDepartamentos.getSelectedIndex() != -1) 
			  		{
			  			String departamentoElegido = comboBoxDepartamentos.getSelectedItem().toString();
			  			controladorTuristica.seleccionarDepartamento(departamentoElegido);
				  		Set<String> actividadesSet = controladorTuristica.listarActividadesDeDepartamento(departamentoElegido);
				  		if (!actividadesSet.isEmpty()) 
				  		{
				  			for (String string : actividadesSet) {
								comboActividades.addItem(string);
							}
				  			comboActividades.setSelectedIndex(-1);
				  		}
			  		}
			  	}
			  });
		  
		     comboActividades.addActionListener(new ActionListener() {
			     	public void actionPerformed(ActionEvent e) {
		     			comboSalidas.removeAllItems();
			     		if (comboActividades.getSelectedIndex() != -1) 
			     		{
			     			String actividadElegida = comboActividades.getSelectedItem().toString();
			     			Set<String> salidaSet = controladorTuristica.listarSalidasActividad(actividadElegida);
			     			
			     			if (!salidaSet.isEmpty()) {
				     			for (String string : salidaSet) {
									comboSalidas.addItem(string);
								}
			     			}
			     			comboSalidas.setSelectedIndex(-1);
			     		}
			     	}
			     });
	     
	     btnInfo = new JButton("Info");
	     btnInfo.addActionListener(new ActionListener() {
	     	public void actionPerformed(ActionEvent e) {
	     		if (comboSalidas.getSelectedIndex() != -1 && comboActividades.getSelectedIndex() != -1) 
	     		{
	     			controladorTuristica.seleccionarActividad(comboActividades.getSelectedItem().toString());
					controladorTuristica.seleccionarSalida(comboSalidas.getSelectedItem().toString());
					DTSalidaTuristica dtSalida = controladorTuristica.getDTSalidaTuristica();
					InfoSalida popupSalida = new InfoSalida(dtSalida);
					principalFrame.getContentPane().add(popupSalida);
					principalFrame.getContentPane().setComponentZOrder(popupSalida, 2);
	     		}
	     	}
	     });
	     GridBagConstraints gbc_btnInfo = new GridBagConstraints();
	     gbc_btnInfo.anchor = GridBagConstraints.WEST;
	     gbc_btnInfo.insets = new Insets(0, 0, 5, 0);
	     gbc_btnInfo.gridx = 2;
	     gbc_btnInfo.gridy = 3;
	     getContentPane().add(btnInfo, gbc_btnInfo);
		 
}
	    
	    
	void limpiarFormulario() {
		comboBoxDepartamentos.setSelectedIndex(-1);
		comboBoxDepartamentos.removeAllItems();
		comboActividades.removeAllItems();
		comboSalidas.removeAllItems();
	}
	public void cargarDatosDepartamentos() {
		Fabrica fabr =Fabrica.getInstance();
		ITuristica cturistico = fabr.getControladorTuristica();
		if (!cturistico.listarDepartamentos().isEmpty()) 
		{
		  Iterator<String> iterator = cturistico.listarDepartamentos().iterator(); 
		  while(iterator.hasNext()) 
		  { 
			  String setElement = iterator.next(); 
			  comboBoxDepartamentos.addItem(setElement);
		  }
		}
	}
}
