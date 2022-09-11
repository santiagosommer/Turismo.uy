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
import javax.swing.JFrame;
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
import ServidorCentral.Logica.Controladores.ControladorTuristica;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Excepciones.YaExisteInscripcionTuristaSalida;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;
//import excepciones.UsuarioRepetidoException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class InscripcionASalidaTuristica extends JInternalFrame {
	
	private ActividadTuristica actividad;
	private IUsuario controladorUsuario;
  	private JComboBox<String> comboBoxDepartamentos;
  	private String selectedTurista;
  	private JComboBox<String> listaTuristas;
  	private JComboBox<String> listaSalidas;
  	private JComboBox<String> listaActividades;
  	private ITuristica controladorAct;
  	private  DefaultComboBoxModel<String> l3;
  	private  DefaultComboBoxModel<String> l1;
  	private DefaultComboBoxModel<String> l2;
  	private JSpinner CantTuristas;

	/**
	 * Create the frame.
	 */
	public InscripcionASalidaTuristica(IUsuario ctrl, ITuristica interfazTuristica, JFrame principalFrame) {
		setClosable(true);
		setMaximizable(true);
		setResizable(true);
		setTitle("Inscripcion a Salida Turistica");
		
		controladorUsuario = ctrl;
		Fabrica fabricaU = Fabrica.getInstance();
		ITuristica ctr = fabricaU.getControladorTuristica();
		
		setBounds(100, 100, 848, 507);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{605, 0};
		gridBagLayout.rowHeights = new int[]{300, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{40, 45, 188, 242, 70, 0, 0};
		gbl_panel.rowHeights = new int[] {30, 35, 35, 35, 0, 35, 0, 35};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Departamentos:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBoxDepartamentos = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		panel.add(comboBoxDepartamentos, gbc_comboBox);
		
		
		comboBoxDepartamentos.setSelectedIndex(-1);
		
		 
		
		JLabel lblNewLabel_1 = new JLabel("Actividades Turisticas:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		//modelos listas
    
        l1 = new DefaultComboBoxModel<>(); //Actividades
        l2 = new DefaultComboBoxModel<>(); //Salidas
        l3 = new DefaultComboBoxModel<>(); //Turistas
		
				
		listaActividades = new JComboBox<>(l1);
		GridBagConstraints gbc_listaActividades = new GridBagConstraints();
		gbc_listaActividades.gridwidth = 2;
		gbc_listaActividades.fill = GridBagConstraints.HORIZONTAL;
		gbc_listaActividades.insets = new Insets(0, 0, 5, 5);
		gbc_listaActividades.gridx = 2;
		gbc_listaActividades.gridy = 2;
		panel.add(listaActividades, gbc_listaActividades);
		
		
		//listar Salidas vigentes
		listaActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaActividades.getSelectedIndex() != -1) {
    	            String selectedActividad = listaActividades.getSelectedItem().toString();
    	            if (selectedActividad != null) {
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
	    	            	listaSalidas.setSelectedIndex(-1);
	    	            	listaTuristas.removeAllItems();
			    	    }
			    	}
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Salidas Turisticas vigentes:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
				
		 listaSalidas = new JComboBox<>(l2);
		 listaSalidas.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if (listaSalidas.getSelectedIndex() != -1) {
			 		ListarTuristas();
			 		listaTuristas.setSelectedIndex(-1);
		 		}
		 	}
		 });
		 GridBagConstraints gbc_listaSalidas = new GridBagConstraints();
		 gbc_listaSalidas.fill = GridBagConstraints.HORIZONTAL;
		 gbc_listaSalidas.gridwidth = 2;
		 gbc_listaSalidas.insets = new Insets(0, 0, 5, 5);
		 gbc_listaSalidas.gridx = 2;
		 gbc_listaSalidas.gridy = 3;
		 panel.add(listaSalidas, gbc_listaSalidas);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listaSalidas.getSelectedIndex() != -1 && listaActividades.getSelectedIndex() != -1) {
					interfazTuristica.seleccionarActividad(listaActividades.getSelectedItem().toString());
					interfazTuristica.seleccionarSalida(listaSalidas.getSelectedItem().toString());
					InfoSalida popupSalida = new InfoSalida(interfazTuristica.getDTSalidaTuristica());
					principalFrame.getContentPane().add(popupSalida);
					principalFrame.getContentPane().setComponentZOrder(popupSalida, 2);
				}
			}
		});
		GridBagConstraints gbc_btnInfo = new GridBagConstraints();
		gbc_btnInfo.anchor = GridBagConstraints.WEST;
		gbc_btnInfo.insets = new Insets(0, 0, 5, 5);
		gbc_btnInfo.gridx = 4;
		gbc_btnInfo.gridy = 3;
		panel.add(btnInfo, gbc_btnInfo);
		
		JLabel lblNewLabel_12 = new JLabel("      Turistas");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 4;
		panel.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		//Listar turistas
		
	    listaTuristas = new JComboBox<>(l3);
	    GridBagConstraints gbc_listaTuristas = new GridBagConstraints();
	    gbc_listaTuristas.fill = GridBagConstraints.HORIZONTAL;
	    gbc_listaTuristas.gridwidth = 2;
	    gbc_listaTuristas.insets = new Insets(0, 0, 5, 5);
	    gbc_listaTuristas.gridx = 2;
	    gbc_listaTuristas.gridy = 4;
	    panel.add(listaTuristas, gbc_listaTuristas);
	    
	    JLabel lblNewLabel_14 = new JLabel("Cantidad turistas:");
	    GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
	    gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
	    gbc_lblNewLabel_14.gridx = 1;
	    gbc_lblNewLabel_14.gridy = 5;
	    panel.add(lblNewLabel_14, gbc_lblNewLabel_14);
	    
	    CantTuristas = new JSpinner();
	    CantTuristas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
	    GridBagConstraints gbc_CantTuristas = new GridBagConstraints();
	    gbc_CantTuristas.fill = GridBagConstraints.HORIZONTAL;
	    gbc_CantTuristas.insets = new Insets(0, 0, 5, 5);
	    gbc_CantTuristas.gridx = 2;
	    gbc_CantTuristas.gridy = 5;
	    panel.add(CantTuristas, gbc_CantTuristas);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 7;
		panel.add(btnAceptar, gbc_btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	InscribirASalida(arg0);
            }
        });
		
				
		//Cancelar
		JButton BotonCancelar = new JButton("Cancelar");
		GridBagConstraints gbc_BotonCancelar = new GridBagConstraints();
		gbc_BotonCancelar.anchor = GridBagConstraints.WEST;
		gbc_BotonCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_BotonCancelar.gridx = 3;
		gbc_BotonCancelar.gridy = 7;
		panel.add(BotonCancelar, gbc_BotonCancelar);
	    		
		BotonCancelar.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	        limpiarFormulario();
	        setVisible(false);
            }
        });
	    
	    listaTuristas.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent event) {
    	    	if (listaTuristas.getSelectedIndex() != -1) {
    	            selectedTurista = listaTuristas.getSelectedItem().toString();
    	            if (selectedTurista!= null) {
    	            	 ctrl.seleccionarTurista(selectedTurista);
    	            }
    	          }
    	    }
    	});
		
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
			 		   while(iterator.hasNext()) { 
			 			    	   String Element = iterator.next(); 
			 			    	    l1.addElement(Element);
			 			 }
			 		   l2.removeAllElements();
			 		   listaActividades.setSelectedIndex(-1);
			 		   listaSalidas.setSelectedIndex(-1);
			 		   listaTuristas.removeAllItems();
			 		   listaTuristas.setSelectedIndex(-1);
			 	   } 
			    }
	     });
	}

	void limpiarFormulario() {
		comboBoxDepartamentos.setSelectedIndex(-1);
		selectedTurista = null;
		CantTuristas.setValue(1);

		l1.removeAllElements();
		l2.removeAllElements();
		l3.removeAllElements();
		
	}
	
	 protected void InscribirASalida(ActionEvent arg0) {
		
		if (CheckFormulario()) {
			
			try {
			
				LocalDate fechaInscripcion = LocalDate.now();
				int cantTuristas = (int)CantTuristas.getValue();
	
              
				controladorUsuario.crearInscripcion(selectedTurista,controladorAct.getDTSalidaTuristica().getNombre(),Integer.valueOf(cantTuristas),actividad.getCostoTurista(),fechaInscripcion);
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
		
		int cantTuristas = (int)CantTuristas.getValue();
		if (cantTuristas < 1 || (comboBoxDepartamentos.getSelectedIndex() == -1 || listaTuristas.getSelectedIndex() == -1 || listaSalidas.getSelectedIndex() == -1 || listaActividades.getSelectedIndex() == -1)) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Inscripcion a Salida Turistica",
                    JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		
		Fabrica fabrica = Fabrica.getInstance();
	    controladorAct = fabrica.getControladorTuristica();
		if (controladorAct.getSalidaSeleccionada()!= null) {
		 if (cantTuristas > controladorAct.getDTSalidaTuristica().getCuposDisponibles())  {
			 JOptionPane.showMessageDialog(this, "No hay suficientes cupos en " + controladorAct.getSalidaSeleccionada().getNombre() , "Inscripcion a Salida Turistica",
	                    JOptionPane.ERROR_MESSAGE);
			return false;
			
		}
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
				if (!cturistico.listarDepartamentos().isEmpty()) {
				     Iterator<String> iterator = cturistico.listarDepartamentos().iterator(); 
				     while(iterator.hasNext()) { 
					    String setElement = iterator.next(); 
					    comboBoxDepartamentos.addItem(setElement);
				     }
				   }
			
	}
	
}