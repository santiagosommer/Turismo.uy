package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;

import ServidorCentral.Logica.Clases.SalidaTuristica;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Excepciones.DepartamentoNoExisteException;
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

public class ConsultaDeSalidaTuristica extends JInternalFrame {
	
  private JComboBox<String> comboBoxDepartamentos;
  private JLabel LugarLabel;
  private JLabel HoraLabel;
  private JLabel FechaLabel;
  private JLabel NombreLabel;
  private JLabel LabelMaxTuristas;
  private DefaultListModel<String> l1;
  private DefaultListModel<String> l2;
  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,ITuristica ctrl) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDeSalidaTuristica frame = new ConsultaDeSalidaTuristica(ctrl);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaDeSalidaTuristica(ITuristica ctrl) {
		
		
		
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{116, 145, 140, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 23, 0, 59, 62, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
       
       //modelos listas
              
        l1 = new DefaultListModel<>();
        l2 = new DefaultListModel<>();
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{129, 137, 0, 0};
		gbl_panel.rowHeights = new int[]{44, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel(" Departamento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
		
		 comboBoxDepartamentos = new JComboBox<String>();
		comboBoxDepartamentos.setBackground(new Color(245, 255, 250));
		GridBagConstraints gbc_comboBoxDepartamentos = new GridBagConstraints();
		gbc_comboBoxDepartamentos.anchor = GridBagConstraints.SOUTH;
		gbc_comboBoxDepartamentos.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDepartamentos.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDepartamentos.gridx = 1;
		gbc_comboBoxDepartamentos.gridy = 0;
		panel.add(comboBoxDepartamentos, gbc_comboBoxDepartamentos);
		comboBoxDepartamentos.setSelectedIndex(-1);
		
	      //agrega departamentos
		   try {
			if (!ctrl.listarDepartamentos().isEmpty()) {
			   Iterator<String> iterator = ctrl.listarDepartamentos().iterator(); //ver
			   while(iterator.hasNext()) { 
				   String setElement = iterator.next(); 
				   comboBoxDepartamentos.addItem(setElement);
			   }
			   }
		} catch (DepartamentoNoExisteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
		
		JLabel lblNewLabel_1 = new JLabel("Actividades Turisticas");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList<>(l1);
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel_2 = new JLabel("Salidas Turisticas");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.gridheight = 3;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 3;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		JList list_1 = new JList<>(l2);
		scrollPane_1.setViewportView(list_1);
		
		
		//listar actividades
      comboBoxDepartamentos.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		 	   @SuppressWarnings("unchecked") //?
			JComboBox<String> cb = (JComboBox<String>)e.getSource();
		 	   
		 	   String DepartamentoSelecc = (String)cb.getSelectedItem();
		 	   if(ctrl.existeDepartamento(DepartamentoSelecc)) {
		 		   ctrl.seleccionarDepartamento(DepartamentoSelecc);
		 		   Set<String> actividades = ctrl.listarActividadesDeDepartamento(DepartamentoSelecc);
		 		   Iterator<String> iterator = actividades.iterator();
		 		   l1.removeAllElements(); //limpia las listas
		 		   l2.removeAllElements();
		 		   while(iterator.hasNext()) { 
		 			    	   String Element = iterator.next(); 
		 			    	    l1.addElement(Element);
		 			 }
		 		   
		 		   
		 	   }
		 	   
		    }
     });
      
      
      //lista salidas
		
      list.addListSelectionListener(new ListSelectionListener() {
    	    public void valueChanged(ListSelectionEvent event) {
    	        if (!event.getValueIsAdjusting()){
    	            @SuppressWarnings("unchecked")
					JList<String> source = (JList)event.getSource();
    	            String selectedActividad = source.getSelectedValue();
    	            if (selectedActividad!=null) {
    	            Set<String> salidas = ctrl.listarSalidasActividad(selectedActividad);
    	            if (ctrl.existeActividad(selectedActividad)) {
    	            	ctrl.seleccionarActividad(selectedActividad);
    	            }
    	            l2.removeAllElements();
    	            if (salidas!= null) {
    	            	Iterator<String> iterator = salidas.iterator();
    	            	
    	            	while(iterator.hasNext()) { 
	 			    	    String Salida = iterator.next(); 
	 			    	    l2.addElement(Salida);
    	            	}
    	           }
    	           
    	      }}
    	  }
    	});
      
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 5;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{107, 114, 83, 104, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 23, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Informacion");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
	    NombreLabel = new JLabel("");
		NombreLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 1;
		panel_1.add(NombreLabel, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha:");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		FechaLabel = new JLabel("");
		FechaLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_81 = new GridBagConstraints();
		gbc_lblNewLabel_81.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_81.gridx = 1;
		gbc_lblNewLabel_81.gridy = 2;
		panel_1.add(FechaLabel, gbc_lblNewLabel_81);
		
		JLabel lblNewLabel_7 = new JLabel("Hora:");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 2;
		panel_1.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		 HoraLabel = new JLabel("");
		HoraLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_82 = new GridBagConstraints();
		gbc_lblNewLabel_82.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_82.gridx = 3;
		gbc_lblNewLabel_82.gridy = 2;
		panel_1.add(HoraLabel, gbc_lblNewLabel_82);
		
		JLabel lblNewLabel_6 = new JLabel("Lugar:");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 3;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		 LugarLabel = new JLabel("");
		LugarLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 3;
		panel_1.add(LugarLabel, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_0 = new JLabel("Cantidad maxima turistas:");
		lblNewLabel_0.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_83 = new GridBagConstraints();
		gbc_lblNewLabel_83.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_83.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_83.gridx = 2;
		gbc_lblNewLabel_83.gridy = 3;
		panel_1.add(lblNewLabel_0, gbc_lblNewLabel_83);
		
	    LabelMaxTuristas = new JLabel("");
	    LabelMaxTuristas.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_max = new GridBagConstraints();
		gbc_lblNewLabel_max.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_max.gridx = 3;
		gbc_lblNewLabel_max.gridy = 3;
		panel_1.add(LabelMaxTuristas, gbc_lblNewLabel_max);
		
		
		
		  list_1.addListSelectionListener(new ListSelectionListener() {
	    	    public void valueChanged(ListSelectionEvent event) {
	    	        if (!event.getValueIsAdjusting()){
	    	            @SuppressWarnings("unchecked")
						JList<String> source = (JList)event.getSource();
	    	            String selectedSalida = source.getSelectedValue();
	    	            if(selectedSalida!=null) {
	    	            
	    	           
	    	           ctrl.seleccionarSalida(selectedSalida);
	    	           NombreLabel.setText(selectedSalida);
	    	           DTSalidaTuristica sal = ctrl.getDTSalidaTuristica();
	    	           if (sal!= null) {
	    	        	LabelMaxTuristas.setText(String.valueOf(sal.getCantidadMaxTuristas()));
	    	           //lugar
	    	           LugarLabel.setText(sal.getInfoSalida().getLugar());
	    	           //Hora
	    	           HoraLabel.setText(sal.getInfoSalida().getHora().toString());	    	           
	    	           //Fecha
	    	           FechaLabel.setText(sal.getInfoSalida().getFecha().toString());
	    	           
	    	           }
	    	        }}
	    	    }
	    	});
	}
	
	void limpiarFormulario() {
		comboBoxDepartamentos.setSelectedIndex(-1);
		LugarLabel.setText("");
		HoraLabel.setText("");
		NombreLabel.setText("");
		FechaLabel.setText("");
		LabelMaxTuristas.setText("");
		l1.removeAllElements();
		l2.removeAllElements();
		
		
		
	}

}
