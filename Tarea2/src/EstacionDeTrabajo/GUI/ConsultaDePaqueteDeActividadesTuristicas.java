package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Excepciones.UsuarioNoExisteException;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.undo.CannotUndoException;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ConsultaDePaqueteDeActividadesTuristicas extends JInternalFrame {
	private IPaquete cu;
	private DefaultComboBoxModel<String> l1;
	private DefaultComboBoxModel<String> l2;
	private JComboBox<String> listaActividades;
	private JComboBox<String> listaPaquetes;
	private JComboBox listaCategorias;
	/**
	 * Create the frame.
	 */
	public ConsultaDePaqueteDeActividadesTuristicas(IPaquete ctr,ITuristica turi, JFrame principalFrame) {
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle("Consulta de Paquete");
		cu = ctr;
		setBounds(100, 100, 872, 183);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 97, 376, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 35, 35, 22, 68, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		//Modelos
		l1 = new DefaultComboBoxModel<>(); //Paquetes
		l2 = new DefaultComboBoxModel<>();
		
		JLabel lblNewLabel = new JLabel("Paquetes");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		listaPaquetes = new JComboBox<>(l1);
		GridBagConstraints gbc_listaPaquetes = new GridBagConstraints();
		gbc_listaPaquetes.fill = GridBagConstraints.HORIZONTAL;
		gbc_listaPaquetes.gridx = 0;
		gbc_listaPaquetes.gridy = 0;
		panel.add(listaPaquetes, gbc_listaPaquetes);
		

		
		JButton btnInfoPaquetes = new JButton("Info");

		GridBagConstraints gbc_btnInfoPaquetes = new GridBagConstraints();
		gbc_btnInfoPaquetes.anchor = GridBagConstraints.WEST;
		gbc_btnInfoPaquetes.insets = new Insets(0, 0, 5, 0);
		gbc_btnInfoPaquetes.gridx = 3;
		gbc_btnInfoPaquetes.gridy = 1;
		getContentPane().add(btnInfoPaquetes, gbc_btnInfoPaquetes);
		
		JLabel lblNewLabel_8 = new JLabel("Actividades Turisticas de Paquete");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 2;
		getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 2;
		getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		listaActividades = new JComboBox<>(l2);
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 0;
		panel_2.add(listaActividades, gbc_list_1);
		
		JButton btnInfoATs = new JButton("Info");
		GridBagConstraints gbc_btnInfoATs = new GridBagConstraints();
		gbc_btnInfoATs.insets = new Insets(0, 0, 5, 0);
		gbc_btnInfoATs.gridx = 3;
		gbc_btnInfoATs.gridy = 2;
		getContentPane().add(btnInfoATs, gbc_btnInfoATs);
		
		JLabel lblNewLabel_1 = new JLabel("Categorias");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		listaCategorias = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		getContentPane().add(listaCategorias, gbc_comboBox);
		
		listaPaquetes.addActionListener(new ActionListener() {
	 	 	public void actionPerformed(ActionEvent e) {
	 	 		listaActividades.setSelectedIndex(-1);
	 	 		if (listaPaquetes.getSelectedIndex() != -1) 
	 	 		{
	 		 		String selectedPaquete = listaPaquetes.getSelectedItem().toString();   
	 	            if (selectedPaquete!= null) 
	 	            {
	 	            	listaActividades.setSelectedIndex(-1);
	 	            	ctr.seleccionarPaquete(selectedPaquete);
	     	            l2.removeAllElements();
	     	            DTPaquete paquete = cu.getDtPaquete();
	     	            if (paquete!= null) {
	     	            	
		     	        	Set<String> s = cu.listarActividadesPaquete();
		     	        	if (s!=null && !s.isEmpty()) { //listar actividades paquetes
		     	        		 Iterator<String> itr = s.iterator();
		     	    			 while(itr.hasNext()) { l2.addElement(itr.next()); }
		     	    			 
		     	    			 //listar categorias paquete.
		     	    			listaCategorias.removeAllItems();
		    					Set<String> Categorias = cu.listarCategoriasPaquete(selectedPaquete);
		    					for (String categoria : Categorias) {
		    						listaCategorias.addItem(categoria);
		    					}
		    					listaCategorias.setSelectedIndex(-1);
		     	        	}
	     	            }
	 	            }
	 	 		}
	 	 	}
	 	});
		
		btnInfoPaquetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaPaquetes.getSelectedIndex() != -1) 
				{
					ctr.seleccionarPaquete(listaPaquetes.getSelectedItem().toString());
					InfoPaquete popupSalida = new InfoPaquete(ctr.getDtPaquete());
					principalFrame.getContentPane().add(popupSalida);
					principalFrame.getContentPane().setComponentZOrder(popupSalida, 2);
				}
			}
		});
		
		btnInfoATs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaActividades.getSelectedIndex() != -1) 
				{
					turi.seleccionarActividad(listaActividades.getSelectedItem().toString());
					InfoActividad popupAct = new InfoActividad(turi.getDTActividadTuristica());
					principalFrame.getContentPane().add(popupAct);
					principalFrame.getContentPane().setComponentZOrder(popupAct, 2);
				}
			}
		});
	
	
	}	
	public void cargarPaquetes() {
			Set<String> set = cu.listarPaquetes();
			if (!set.isEmpty()) {
			   Iterator<String> itr = set.iterator();
			   while(itr.hasNext()) {
			 	  l1.addElement(itr.next());
			 	  }
			}
			listaActividades.setSelectedIndex(-1);
	}


	public void LimpiarFormulario() {
		listaCategorias.setSelectedIndex(-1);
		l1.removeAllElements();
		l2.removeAllElements();
		listaActividades.setSelectedIndex(-1);
		listaPaquetes.setSelectedIndex(-1);
		
	}	
	
}


