package EstacionDeTrabajo.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.SalidaTuristica;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Excepciones.DepartamentoNoExisteException;
import ServidorCentral.Logica.Excepciones.YaExisteInscripcionTuristaSalida;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;
//import excepciones.UsuarioRepetidoException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class InscripcionASalidaTuristica extends JInternalFrame {
	
	 private DTSalidaTuristica sal;
	 private ActividadTuristica actividad;
	  private IUsuario controladorUsuario;
	  private JTextField CantTuristasTextField;
	  private JComboBox<String> comboBoxDepartamentos;
	  private JLabel LugarLabel;
	  private JLabel HoraLabel;
	  private JLabel FechaLabel;
	  private JLabel NombreLabel;
	  private JLabel SalidaTuristica;
	  private String selectedTurista;
	  private JList listaTuristas;
	  private JList<String> listaSalidas;
	  private JList listaActividades;
	  private ITuristica controladorAct;
	  private  DefaultListModel<String> l3;
	  private  DefaultListModel<String> l1;
	  private DefaultListModel<String> l2;
	  private JLabel CuposLabel;
	  
	//JComboBox comboBoxDepartamentos;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fabrica fabrica = Fabrica.getInstance();
					IUsuario ctr = fabrica.getControladorUsuario();
					InscripcionASalidaTuristica frame = new InscripcionASalidaTuristica(ctr);
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
	public InscripcionASalidaTuristica(IUsuario ctrl) {
		
		controladorUsuario = ctrl;
		Fabrica fabricaU = Fabrica.getInstance();
		ITuristica ctr = fabricaU.getControladorTuristica();
		
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 708, 787);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{605, 0};
		gridBagLayout.rowHeights = new int[]{300, 115, 193, 78, 84, 44, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{118, 45, 188, 242, 70, 0, 0};
		gbl_panel.rowHeights = new int[]{50, 111, 114, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Departamentos:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBoxDepartamentos = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.SOUTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 0;
		panel.add(comboBoxDepartamentos, gbc_comboBox);
		
		
		comboBoxDepartamentos.setSelectedIndex(-1);
		
		 
		
		JLabel lblNewLabel_1 = new JLabel("Actividades Turisticas:");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		//modelos listas
        
	        l1 = new DefaultListModel<>(); //Actividades
	        l2 = new DefaultListModel<>(); //Salidas
	        l3 = new DefaultListModel<>(); //Turistas

		
		listaActividades = new JList<>(l1);
		scrollPane.setViewportView(listaActividades);
		
		JLabel lblNewLabel_2 = new JLabel("Salidas Turisticas vigentes:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 2;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
				
		 listaSalidas = new JList<>(l2);
		scrollPane_1.setViewportView(listaSalidas);
		
		//listar actividades
	      comboBoxDepartamentos.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			 	   @SuppressWarnings("unchecked") //?
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
			 	   
			 	   String DepartamentoSelecc = (String)cb.getSelectedItem();
			 	   
			 	   if(ctr.existeDepartamento(DepartamentoSelecc)) {
			 		   ctr.seleccionarDepartamento(DepartamentoSelecc);
			 		   Set<String> actividades = ctr.listarActividadesDeDepartamento(DepartamentoSelecc);
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
	      
	      
	      //listar Salidas vigentes
	      
	      
	      listaActividades.addListSelectionListener(new ListSelectionListener() {
	    	    public void valueChanged(ListSelectionEvent event) {
	    	        if (!event.getValueIsAdjusting()){
	    	            @SuppressWarnings("unchecked")
						JList<String> source = (JList)event.getSource();
	    	            String selectedActividad = source.getSelectedValue();
	    	            if (selectedActividad!=null) {
	    	            
	    	            if (ctr.existeActividad(selectedActividad)) {
	    	            	ctr.seleccionarActividad(selectedActividad);
	    	            	actividad = ctr.getActividadSeleccionada();
	    	            	
	    	            }
	    	            
	    	            Set<DTSalidaTuristica> salidas = ctr.datosSalidasVigentes(selectedActividad); 
	    	            l2.removeAllElements();
	    	            if (salidas!= null) {
	    	            	Iterator<DTSalidaTuristica> iterator = salidas.iterator();
	    	            	
	    	            	while(iterator.hasNext()) { 
		 			    	    String Salida = iterator.next().getNombre(); 
		 			    	    l2.addElement(Salida);
	    	            	}
	    	           }
	    	           
	    	      }
	    	  }
	    	    }
	    	    
	    	});
	      
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{130, 131, 84, 124, 0};
		gbl_panel_1.rowHeights = new int[]{26, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Informacion Salida");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		panel_1.add(separator, gbc_separator);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre:");
		lblNewLabel_4.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		NombreLabel = new JLabel("");
		NombreLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 2;
		panel_1.add(NombreLabel, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("Fecha:");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 2;
		gbc_lblNewLabel_8.gridy = 2;
		panel_1.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		FechaLabel = new JLabel("");
		FechaLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 3;
		gbc_lblNewLabel_10.gridy = 2;
		panel_1.add(FechaLabel, gbc_lblNewLabel_10);
		
		JLabel lblNewLabel_5 = new JLabel("Hora:");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 3;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		HoraLabel = new JLabel("");
		HoraLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 3;
		panel_1.add(HoraLabel, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Lugar:");
		lblNewLabel_9.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 2;
		gbc_lblNewLabel_9.gridy = 3;
		panel_1.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		LugarLabel = new JLabel("");
		LugarLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 3;
		gbc_lblNewLabel_11.gridy = 3;
		panel_1.add(LugarLabel, gbc_lblNewLabel_11);
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 4;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 4;
		
		JLabel lblNewLabel_6 = new JLabel("Cupos Disponibles:");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_61 = new GridBagConstraints();
		gbc_lblNewLabel_61.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_61.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_61.gridx = 0;
		gbc_lblNewLabel_61.gridy = 4;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_61);
		
		 CuposLabel = new JLabel("");
		CuposLabel.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_CuposLabel = new GridBagConstraints();
		gbc_CuposLabel.insets = new Insets(0, 0, 0, 5);
		gbc_CuposLabel.gridx = 1;
		gbc_CuposLabel.gridy = 4;
		panel_1.add(CuposLabel, gbc_CuposLabel);
		
		//Al seleccionar salida
		
		listaSalidas.addListSelectionListener(new ListSelectionListener() {
    	    public void valueChanged(ListSelectionEvent event) {
    	        if (!event.getValueIsAdjusting()){
    	            @SuppressWarnings("unchecked")
					JList<String> source = (JList)event.getSource();
    	            String selectedSalida = source.getSelectedValue();
    	            if (selectedSalida!=null) {
    	             ctr.seleccionarSalida(selectedSalida);
    	             NombreLabel.setText(selectedSalida);
    	             SalidaTuristica salidaTuri = ctr.getSalidaSeleccionada();
    	             sal = ctr.getDTSalidaTuristica();
    	             if (sal!= null) {
    	        	
    	            	 //lugar
    	            	 LugarLabel.setText(sal.getInfoSalida().getLugar());
    	            	 //Hora
    	            	 HoraLabel.setText(sal.getInfoSalida().getHora().toString());	    	           
    	            	 //Fecha
    	            	 FechaLabel.setText(sal.getInfoSalida().getFecha().toString());
    	            	 SalidaTuristica.setText(selectedSalida);
    	            	 //Cupos
    	            	 String cupos = String.valueOf(salidaTuri.getCuposDisponibles());
    	            	 CuposLabel.setText(cupos); 
    	           
    	           }}
    	        }
    	    }
    	});

		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{117, 0, 463, 0, 0};
		gbl_panel_2.rowHeights = new int[]{168, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_12 = new JLabel("      Turistas");
		lblNewLabel_12.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 0;
		panel_2.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 2;
		gbc_scrollPane_2.gridy = 0;
		panel_2.add(scrollPane_2, gbc_scrollPane_2);
		
		//Listar turistas
		
	    listaTuristas = new JList<>(l3);
		scrollPane_2.setViewportView(listaTuristas);
		
		
		
		
		listaTuristas.addListSelectionListener(new ListSelectionListener() {
    	    public void valueChanged(ListSelectionEvent event) {
    	        if (!event.getValueIsAdjusting()){
    	            @SuppressWarnings("unchecked")
					JList<String> source = (JList)event.getSource();
    	            selectedTurista = source.getSelectedValue();
    	            if (selectedTurista!= null) {
    	            	 ctrl.seleccionarTurista(selectedTurista);
    	            }
    	          }
    	        }
    	});
		
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{140, 101, 0, 0, 104, 87, 146, 0};
		gbl_panel_3.rowHeights = new int[]{0, 33, 25, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_13 = new JLabel("Salida Turistica:");
		lblNewLabel_13.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 1;
		panel_3.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
	    SalidaTuristica = new JLabel("");
		SalidaTuristica.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 1;
		gbc_lblNewLabel_16.gridy = 1;
		panel_3.add(SalidaTuristica, gbc_lblNewLabel_16);
		
		JLabel lblNewLabel_14 = new JLabel("Cantidad turistas:");
		lblNewLabel_14.setFont(new Font("SansSerif", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 4;
		gbc_lblNewLabel_14.gridy = 1;
		panel_3.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		CantTuristasTextField = new JTextField();
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 1;
		panel_3.add(CantTuristasTextField, gbc_textField);
		CantTuristasTextField.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 4;
		getContentPane().add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 179, 115, 0, 115, 0};
		gbl_panel_4.rowHeights = new int[]{33, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_15 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_15.gridx = 1;
		gbc_lblNewLabel_15.gridy = 0;
		panel_4.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel_4.add(btnAceptar, gbc_btnNewButton);
		
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
            		 InscribirASalida(arg0);
            	
               
            }
        });

		
		//Cancelar
		JButton BotonCancelar = new JButton("Cancelar");
		BotonCancelar.setFont(new Font("SansSerif", Font.BOLD, 10));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 0;
		panel_4.add(BotonCancelar, gbc_btnNewButton_1);
		
		BotonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                setVisible(false);
            }
        });
		

	}

	void limpiarFormulario() {
		comboBoxDepartamentos.setSelectedIndex(-1);
		LugarLabel.setText("");
		HoraLabel.setText("");
		NombreLabel.setText("");
		FechaLabel.setText("");
		SalidaTuristica.setText("");
		selectedTurista = null;
		CantTuristasTextField.setText("");	
		CuposLabel.setText("");
		
		l1.removeAllElements();
		l2.removeAllElements();
		l3.removeAllElements();
		
	}
	
	 protected void InscribirASalida(ActionEvent arg0) {
		
		if (CheckFormulario()) {
			
			try {
			
				LocalDate fechaInscripcion = LocalDate.now();
				String cantTuristas = this.CantTuristasTextField.getText();
	
              
				controladorUsuario.crearInscripcion(selectedTurista,sal.getNombre(),Integer.valueOf(cantTuristas),actividad.getCostoTurista(),fechaInscripcion);
                // Muestro éxito de la operación
				//String c = "costo";,
				
				String x = "La inscripcion se ha creado con éxito";  //El costo de la misma es: $ " + c
                JOptionPane.showMessageDialog(this, x, "Registrar Usuario",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (YaExisteInscripcionTuristaSalida e) {
                // Muestro error 
               JOptionPane.showMessageDialog(this, e.getMessage(), "Inscripcion a Salida Turistica", JOptionPane.ERROR_MESSAGE);
           }

			 limpiarFormulario();
	         setVisible(false);
		}
			
	}
	
	private Boolean CheckFormulario() {
		
		String cantTuristas = this.CantTuristasTextField.getText();
		if (cantTuristas.isEmpty() || (comboBoxDepartamentos.getSelectedIndex() == -1 || listaTuristas.isSelectionEmpty() || listaSalidas.isSelectionEmpty()|| listaActividades.isSelectionEmpty())) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Inscripcion a Salida Turistica",
                    JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		Fabrica fabrica = Fabrica.getInstance();
	    controladorAct = fabrica.getControladorTuristica();
		if (controladorAct.getSalidaSeleccionada()!= null) {
		 if (Integer.parseInt(cantTuristas) > sal.getCuposDisponibles())  {
			 JOptionPane.showMessageDialog(this, "No hay suficientes cupos en " + controladorAct.getSalidaSeleccionada().getNombre() , "Inscripcion a Salida Turistica",
	                    JOptionPane.ERROR_MESSAGE);
			return false;
			
		}
		}
		
		 try {
	            Integer.parseInt(cantTuristas);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "La cantidad debe ser un numero", "Inscripcion a Salida Turistica",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
    
		return true;
	}



public void ListarTuristas(){
	
	if (controladorUsuario.listarTuristas() != null && !controladorUsuario.listarTuristas().isEmpty()) {
		
		Iterator<String> it = controladorUsuario.listarTuristas().iterator();
    	
    	while(it.hasNext()) { 
	    	    String Turista = it.next(); 
	    	    l3.addElement(Turista);
    	}
		
	}
	
}

public void cargarDatosDepartamentos() {
	
	Fabrica fabr =Fabrica.getInstance();
	ITuristica cturistico = fabr.getControladorTuristica();
	  try {
			if (!cturistico.listarDepartamentos().isEmpty()) {
			     Iterator<String> iterator = cturistico.listarDepartamentos().iterator(); 
			     while(iterator.hasNext()) { 
				    String setElement = iterator.next(); 
				    comboBoxDepartamentos.addItem(setElement);
			     }
			   }
		} catch (DepartamentoNoExisteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
}



}