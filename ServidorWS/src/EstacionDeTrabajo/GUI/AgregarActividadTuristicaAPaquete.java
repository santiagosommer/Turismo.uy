package EstacionDeTrabajo.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AgregarActividadTuristicaAPaquete extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IPaquete controlPaquete;
	private JLabel lblPaquetes;
	private JComboBox<String> comboBoxPaquetes;
    private	String paqueteseleccionado;
	private JLabel lblDepartamentos;
	private JComboBox<String> comboBoxDepartamentos;	
	private JLabel lblActividadesFueraDel;
	private JComboBox<String> comboBoxActividadesFueraDePaquete;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
//	public static void main(String[] args, IPaquete ctrl) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AgregarActividadTuristicaAPaquete frame = new AgregarActividadTuristicaAPaquete(ctrl);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public AgregarActividadTuristicaAPaquete(IPaquete iCPaquete) {
		Fabrica fabricaU = Fabrica.getInstance();
		ITuristica ctrT = fabricaU.getControladorTuristica();
		
		
		setBounds(10, 40, 400, 200);
		
		controlPaquete = iCPaquete;
		setResizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Agregar Actividad Turistica A Paquete");
		setBounds(10, 40, 400, 200);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{37, 117, 71, 87, 62, 0};
		gridBagLayout.rowHeights = new int[]{0, 24, 24, 24, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		lblPaquetes = new JLabel("Paquetes:");
		GridBagConstraints gbc_lblPaquetes = new GridBagConstraints();
		gbc_lblPaquetes.insets = new Insets(0, 0, 5, 5);
		gbc_lblPaquetes.gridx = 1;
		gbc_lblPaquetes.gridy = 1;
		getContentPane().add(lblPaquetes, gbc_lblPaquetes);
		
		comboBoxPaquetes = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxPaquetes = new GridBagConstraints();
		gbc_comboBoxPaquetes.fill = GridBagConstraints.BOTH;
		gbc_comboBoxPaquetes.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxPaquetes.gridwidth = 2;
		gbc_comboBoxPaquetes.gridx = 2;
		gbc_comboBoxPaquetes.gridy = 1;
		getContentPane().add(comboBoxPaquetes, gbc_comboBoxPaquetes);
		
		
		comboBoxPaquetes.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			 	   @SuppressWarnings("unchecked") //?
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
			 	  paqueteseleccionado = (String)cb.getSelectedItem();
			 	  if(paqueteseleccionado!= null) {
			 		 controlPaquete.seleccionarPaquete(paqueteseleccionado);
			 	  }
		   }   });
		
		lblDepartamentos = new JLabel("Departamentos:");
		GridBagConstraints gbc_lblDepartamentos = new GridBagConstraints();
		gbc_lblDepartamentos.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamentos.gridx = 1;
		gbc_lblDepartamentos.gridy = 2;
		getContentPane().add(lblDepartamentos, gbc_lblDepartamentos);
		
		comboBoxDepartamentos = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxDepartamentos = new GridBagConstraints();
		gbc_comboBoxDepartamentos.fill = GridBagConstraints.BOTH;
		gbc_comboBoxDepartamentos.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDepartamentos.gridwidth = 2;
		gbc_comboBoxDepartamentos.gridx = 2;
		gbc_comboBoxDepartamentos.gridy = 2;
		getContentPane().add(comboBoxDepartamentos, gbc_comboBoxDepartamentos);
		
		
		comboBoxDepartamentos.setSelectedIndex(-1);
		
		comboBoxDepartamentos.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			 	   @SuppressWarnings("unchecked") //?
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
			 	  comboBoxActividadesFueraDePaquete.removeAllItems();
			 	  String depseleccionado = (String)cb.getSelectedItem();
			 	  ctrT.seleccionarDepartamento(depseleccionado);
			 	  
			 	 if (paqueteseleccionado!=null){
			 		controlPaquete.seleccionarPaquete(paqueteseleccionado);
			 	
		   if (!controlPaquete.listarPaquetes().isEmpty()) {
				
			if(!controlPaquete.listarActividadesAAgregar(depseleccionado).isEmpty()) {
				
	         Iterator<String> iterator = controlPaquete.listarActividadesAAgregar(depseleccionado).iterator(); 
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    comboBoxActividadesFueraDePaquete.addItem(setElement);
		     }}
			
		}}
		} });
		
		lblActividadesFueraDel = new JLabel("Actividades Fuera Del Paquete:");
		GridBagConstraints gbc_lblActividadesFueraDel = new GridBagConstraints();
		gbc_lblActividadesFueraDel.insets = new Insets(0, 0, 5, 5);
		gbc_lblActividadesFueraDel.gridx = 1;
		gbc_lblActividadesFueraDel.gridy = 3;
		getContentPane().add(lblActividadesFueraDel, gbc_lblActividadesFueraDel);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AgregarActividadTuristicaAPaquetePerformed(e);
            	setVisible(false);
            }
        });
		
		
		comboBoxActividadesFueraDePaquete = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxActividadesFueraDePaquete = new GridBagConstraints();
		gbc_comboBoxActividadesFueraDePaquete.gridwidth = 2;
		gbc_comboBoxActividadesFueraDePaquete.fill = GridBagConstraints.BOTH;
		gbc_comboBoxActividadesFueraDePaquete.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxActividadesFueraDePaquete.gridx = 2;
		gbc_comboBoxActividadesFueraDePaquete.gridy = 3;
		getContentPane().add(comboBoxActividadesFueraDePaquete, gbc_comboBoxActividadesFueraDePaquete);
		comboBoxActividadesFueraDePaquete.setSelectedIndex(-1);
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.VERTICAL;
		gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 4;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               limpiarFormulario();
               setVisible(false);
            }
        });
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 0, 5);
		gbc_btnCancelar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCancelar.gridx = 3;
		gbc_btnCancelar.gridy = 4;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
		
		 if (!ctrT.listarDepartamentos().isEmpty()) {
	         Iterator<String> iterator = ctrT.listarDepartamentos().iterator(); 
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    comboBoxDepartamentos.addItem(setElement);
		     }
		   }
		 paqueteseleccionado = null ;
	
	}
	
	protected void AgregarActividadTuristicaAPaquetePerformed(ActionEvent e) {
		String paqueteSelecBox =  (String)comboBoxPaquetes.getSelectedItem();
		String actividadSelecBox = (String)comboBoxActividadesFueraDePaquete.getSelectedItem();
		
		if (checkFormulario()) {
				controlPaquete.AgregarActividadPaquete(paqueteSelecBox, actividadSelecBox);
				
				JOptionPane.showMessageDialog(this, "La actividad " + actividadSelecBox + " se ha agregado al Paquete", "Agregar Actividad A Paquete",
                        JOptionPane.INFORMATION_MESSAGE);
				
				limpiarFormulario();
				setVisible(false);
		}
	
	}
	
	public void limpiarFormulario() {
		comboBoxActividadesFueraDePaquete.setSelectedIndex(-1);
		comboBoxDepartamentos.setSelectedIndex(-1);
		comboBoxPaquetes.setSelectedIndex(-1);
		comboBoxPaquetes.removeAllItems();
		comboBoxActividadesFueraDePaquete.removeAllItems();
	}
	
	private boolean checkFormulario() {
		String paqueteSelecBox =  (String)comboBoxPaquetes.getSelectedItem();
		String depSelecBox = (String)comboBoxDepartamentos.getSelectedItem();
		String actividadSelecBox = (String)comboBoxActividadesFueraDePaquete.getSelectedItem();
		
		if (comboBoxDepartamentos.getSelectedIndex() == -1 || comboBoxPaquetes.getSelectedIndex() == -1  || comboBoxActividadesFueraDePaquete.getSelectedIndex() == -1 ) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Inscripcion a Salida Turistica",
                    JOptionPane.ERROR_MESSAGE);
            return false;
		}
		
		if (depSelecBox.equals("Departamento")|| actividadSelecBox.equals("Actividad") || paqueteSelecBox.equals("Paquete")) {
			JOptionPane.showMessageDialog(this, "Rellene los campos (*)", "Agregar Actividad A Paquete",
                    JOptionPane.ERROR_MESSAGE);
		return false;
		}
		return true;
	}
	

	public void CargarPaquetes() {
		comboBoxPaquetes.setSelectedIndex(-1);
		if (!controlPaquete.listarPaquetes().isEmpty()) {
	         Iterator<String> iterator = controlPaquete.listarPaquetes().iterator(); 
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    comboBoxPaquetes.addItem(setElement);
		     }
		   }

	}
	
public void cargarDep() {
		

			Fabrica fabricaU = Fabrica.getInstance();
			ITuristica ctrT = fabricaU.getControladorTuristica();
			Iterator<String> iterator = ctrT.listarDepartamentos().iterator(); 
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    comboBoxDepartamentos.addItem(setElement);
	    	 }

	}
	
	public void cargarAct() {
		Fabrica fabricaU = Fabrica.getInstance();
		IPaquete ctrP = fabricaU.getControladorPaquete();
			String dep = (String)comboBoxDepartamentos.getSelectedItem();
			Iterator<String> iterator = ctrP.listarActividadesAAgregar(dep).iterator(); 
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    comboBoxActividadesFueraDePaquete.addItem(setElement);
		     }
	}
}
