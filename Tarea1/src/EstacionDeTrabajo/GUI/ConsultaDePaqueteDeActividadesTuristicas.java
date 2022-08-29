package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
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

public class ConsultaDePaqueteDeActividadesTuristicas extends JInternalFrame {
	
	private JLabel descripcionLabel;
	private JLabel nomPaqueteLabel;
	private JLabel validezLabel;
	private JLabel descuentoLabel;
	private IPaquete cu;
	private DefaultListModel<String> l1;
	private JLabel nomActLabel;
	private DefaultListModel<String> l2;
	private JLabel FechaAltaLabel;
	private JLabel descripcionActLabel;
	private JLabel CostoActLabel;
	private JLabel DepartamentoLabel;
	private JLabel DuracionActLabel ;
	private JLabel CiudadActLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,IPaquete c,ITuristica T) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDePaqueteDeActividadesTuristicas frame = new ConsultaDePaqueteDeActividadesTuristicas(c,T);
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
	public ConsultaDePaqueteDeActividadesTuristicas(IPaquete ctr,ITuristica turi) {
		cu = ctr;
		setBounds(100, 100, 516, 541);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 97, 376, 0};
		gridBagLayout.rowHeights = new int[]{77, 87, 84, 127, 68, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("     Paquetes");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		//Modelos
		  l1 = new DefaultListModel<>(); //Paquetes
	      l2 = new DefaultListModel<>(); //Actividades
	     
	  
		
		 
		 JList listaPaquetes = new JList<>(l1);
		 scrollPane.setViewportView(listaPaquetes);
		 
		 
		 listaPaquetes.addListSelectionListener(new ListSelectionListener() {
	    	    public void valueChanged(ListSelectionEvent event) {
	    	        if (!event.getValueIsAdjusting()){
	    	            @SuppressWarnings("unchecked")
						JList<String> source = (JList)event.getSource();     
	    	            String selectedPaquete = source.getSelectedValue();   
	    	            if (selectedPaquete!= null) {
	    	            	nomActLabel.setText("");
	    	        		
	    	        		FechaAltaLabel.setText("");
	    	        		descripcionActLabel.setText("");
	    	        		CostoActLabel.setText("");
	    	        		DepartamentoLabel.setText("");
	    	        	    DuracionActLabel.setText("") ;
	    	        		CiudadActLabel.setText("");
	    	            	ctr.seleccionarPaquete(selectedPaquete);
	 	    	            l2.removeAllElements();
	 	    	            nomPaqueteLabel.setText(selectedPaquete);
	 	    	            DTPaquete paquete = cu.getDtPaquete();
	 	    	            if (paquete!= null) {
	 	    	        	  validezLabel.setText(String.valueOf(paquete.getPeriodoValidez()));
	 	    	        	  descripcionLabel.setText(paquete.getDescripcion());
	 	    	        	  descuentoLabel.setText(String.valueOf(paquete.getDescuento()));
	 	    	        	  Set<String> s = cu.listarActividadesPaquete();
	 	    	        	  if (s!=null && !s.isEmpty()) { //listar actividades paquetes
	 	    	        		 Iterator<String> itr = s.iterator();
	 	    	    			 while(itr.hasNext()) {
	 	    	    			   l2.addElement(itr.next());
	 	    	    		     }
	 	    	        	 }
	 	    	           }
	    	            }
	    	        }
	    	    }
	    	});
		 
		 
		
		
		JLabel lblNewLabel_1 = new JLabel("      Informacion Paquete");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{106, 213, 0};
		gbl_panel_1.rowHeights = new int[]{0, 43, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
		
		
		
		JLabel lblNewLabel_23 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
		gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_23.gridx = 0;
		gbc_lblNewLabel_23.gridy = 0;
		panel_1.add(lblNewLabel_23, gbc_lblNewLabel_23);
		
		nomPaqueteLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
		gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_24.gridx = 1;
		gbc_lblNewLabel_24.gridy = 0;
		panel_1.add(nomPaqueteLabel, gbc_lblNewLabel_24);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 1;
		gbc_scrollPane_2.gridy = 1;
		panel_1.add(scrollPane_2, gbc_scrollPane_2);
		
		descripcionLabel = new JLabel("");
		scrollPane_2.setViewportView(descripcionLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Periodo validez:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 2;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		validezLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 2;
		panel_1.add(validezLabel, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("Descuento:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 3;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		 descuentoLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 3;
		panel_1.add(descuentoLabel, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("     Actividades Turisticas");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 2;
		getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
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
		
		JList listaActividades = new JList<>(l2);
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 0;
		panel_2.add(listaActividades, gbc_list_1);
		
		
		 listaActividades.addListSelectionListener(new ListSelectionListener() {
	    	    public void valueChanged(ListSelectionEvent event) {
	    	        if (!event.getValueIsAdjusting()){
	    	            @SuppressWarnings("unchecked")
						JList<String> source = (JList)event.getSource();     
	    	            String selectedActividad = source.getSelectedValue();   
	    	            if (selectedActividad!= null) {
	    	            	turi.seleccionarActividad(selectedActividad);
	 	    	            nomActLabel.setText(selectedActividad);
	 	    	            DTActividadTuristica act = turi.getDTActividadTuristica();
	 	    	            if (act!= null) {
	 	    	            	FechaAltaLabel.setText(act.getFechaAlta().toString());
	 	    	            	descripcionActLabel.setText(act.getDescripcion());
	 	    	            	CiudadActLabel.setText(act.getCiudad());
	 	    	            	DepartamentoLabel.setText(act.getInfoDepartamento().getNombre());
	 	    	            	DuracionActLabel.setText(String.valueOf(act.getDuracion()));
	 	    	            	CostoActLabel.setText(String.valueOf(act.getCostoTurista()));
	 	    	        	   
	 	    	        	 }
	 	    	           }
	    	            }
	    	        }
	    	    
	    	});
		
		
		
		
		JLabel lblNewLabel_9 = new JLabel("     Informacion Actividad");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 3;
		getContentPane().add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 3;
		getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 131, 58, 92, 0};
		gbl_panel_3.rowHeights = new int[]{0, 68, 28, 21, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_10 = new JLabel("Nombre");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 0;
		panel_3.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		 nomActLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 1;
		gbc_lblNewLabel_14.gridy = 0;
		panel_3.add(nomActLabel, gbc_lblNewLabel_14);
		
		JLabel lblNewLabel_20 = new JLabel("Fecha Alta:");
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_20.gridx = 2;
		gbc_lblNewLabel_20.gridy = 0;
		panel_3.add(lblNewLabel_20, gbc_lblNewLabel_20);
		
		 FechaAltaLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_25 = new GridBagConstraints();
		gbc_lblNewLabel_25.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_25.gridx = 3;
		gbc_lblNewLabel_25.gridy = 0;
		panel_3.add(FechaAltaLabel, gbc_lblNewLabel_25);
		
		JLabel lblNewLabel_11 = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 1;
		panel_3.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 1;
		panel_3.add(scrollPane_1, gbc_scrollPane_1);
		
	    descripcionActLabel = new JLabel("");
		scrollPane_1.setViewportView(descripcionActLabel);
		
		JLabel lblNewLabel_18 = new JLabel("Ciudad");
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_18.gridx = 2;
		gbc_lblNewLabel_18.gridy = 1;
		panel_3.add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		 CiudadActLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_19.gridx = 3;
		gbc_lblNewLabel_19.gridy = 1;
		panel_3.add(CiudadActLabel, gbc_lblNewLabel_19);
		
		JLabel lblNewLabel_12 = new JLabel("Duracion:");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 2;
		panel_3.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		 DuracionActLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 1;
		gbc_lblNewLabel_16.gridy = 2;
		panel_3.add(DuracionActLabel, gbc_lblNewLabel_16);
		
		JLabel lblNewLabel_21 = new JLabel("Departamento:");
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_21.gridx = 2;
		gbc_lblNewLabel_21.gridy = 2;
		panel_3.add(lblNewLabel_21, gbc_lblNewLabel_21);
		
		 DepartamentoLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
		gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_22.gridx = 3;
		gbc_lblNewLabel_22.gridy = 2;
		panel_3.add(DepartamentoLabel, gbc_lblNewLabel_22);
		
		JLabel lblNewLabel_13 = new JLabel("Costo:");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 3;
		panel_3.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		 CostoActLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_17.gridx = 1;
		gbc_lblNewLabel_17.gridy = 3;
		panel_3.add(CostoActLabel, gbc_lblNewLabel_17);
		
		
		
		
		

	}
	
	
	public void cargarPaquetes() {
			Set<String> set = cu.listarPaquetes();
			if (!set.isEmpty()) {
			   Iterator<String> itr = set.iterator();
			   while(itr.hasNext()) {
			 	  l1.addElement(itr.next());
			 	  }
			}

	}


	public void LimpiarFormulario() {

	
		l1.removeAllElements();
		l2.removeAllElements();
		descripcionLabel.setText("");
		nomPaqueteLabel.setText("");
		validezLabel.setText("");
		descuentoLabel.setText("");
		nomActLabel.setText("");
		
		FechaAltaLabel.setText("");
		descripcionActLabel.setText("");
		CostoActLabel.setText("");
		DepartamentoLabel.setText("");
	    DuracionActLabel.setText("") ;
		CiudadActLabel.setText("");
	}	
	
}


