package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import ServidorCentral.Logica.Excepciones.DepartamentoNoExisteException;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AgregarActividadTuristicaAPaquete extends JInternalFrame {
	
	private IPaquete controlPaquete;
	private JLabel lblPaquetes;
	private JComboBox<String> comboBoxPaquetes;
	private JLabel lblDepartamentos;
	private JComboBox<String> comboBoxDepartamentos;	
	private JLabel lblActividadesFueraDel;
	private JComboBox<String> comboBoxActividadesFueraDePaquete;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	public static void main(String[] args, IPaquete ctrl) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarActividadTuristicaAPaquete frame = new AgregarActividadTuristicaAPaquete(ctrl);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AgregarActividadTuristicaAPaquete(IPaquete iCPaquete) throws DepartamentoNoExisteException {
		setBounds(10, 40, 400, 200);
		
		controlPaquete = iCPaquete;
		setResizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Agregar Actividad Turistica A Paquete");
		setBounds(10, 40, 400, 200);
		
		getContentPane().setLayout(null);
		
		lblPaquetes = new JLabel("Paquetes:");
		lblPaquetes.setBounds(12, 12, 92, 15);
		getContentPane().add(lblPaquetes);
		
		comboBoxPaquetes = new JComboBox<String>();
		comboBoxPaquetes.setBounds(140, 7, 120, 24);
		getContentPane().add(comboBoxPaquetes);
		
		Fabrica fabricaU = Fabrica.getInstance();
		IPaquete ctrP = fabricaU.getControladorPaquete();
		
		
		
		lblDepartamentos = new JLabel("Departamentos:");
		lblDepartamentos.setBounds(12, 48, 132, 15);
		getContentPane().add(lblDepartamentos);
		
		comboBoxDepartamentos = new JComboBox<String>();
		comboBoxDepartamentos.setBounds(140, 43, 120, 24);
		getContentPane().add(comboBoxDepartamentos);
		   
		ITuristica ctrT = fabricaU.getControladorTuristica();
		
		comboBoxDepartamentos.setSelectedIndex(-1);
		 if (!ctrT.listarDepartamentos().isEmpty()) {
	         Iterator<String> iterator = ctrT.listarDepartamentos().iterator(); 
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    comboBoxDepartamentos.addItem(setElement);
		     }
		   }
		 
		lblActividadesFueraDel = new JLabel("Actividades Fuera Del Paquete:");
		lblActividadesFueraDel.setBounds(12, 83, 258, 15);
		getContentPane().add(lblActividadesFueraDel);
		
		comboBoxActividadesFueraDePaquete = new JComboBox<String>();
		comboBoxActividadesFueraDePaquete.setBounds(247, 78, 131, 24);
		getContentPane().add(comboBoxActividadesFueraDePaquete);
		comboBoxActividadesFueraDePaquete.setSelectedIndex(-1);
		if (!ctrP.listarPaquetes().isEmpty()) {
	         Iterator<String> iterator = ctrP.listarActividadesAAgregar((String)comboBoxDepartamentos.getSelectedItem()).iterator(); 
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    comboBoxActividadesFueraDePaquete.addItem(setElement);
		     }
		}
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AgregarActividadTuristicaAPaquetePerformed(e);
            	setVisible(false);
            }
        });
		btnAceptar.setBounds(44, 131, 117, 25);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               limpiarFormulario();
               setVisible(false);
            }
        });
		btnCancelar.setBounds(231, 131, 117, 25);
		getContentPane().add(btnCancelar);
	
	}
	
	protected void AgregarActividadTuristicaAPaquetePerformed(ActionEvent e) {
		String paqueteSelecBox =  (String)comboBoxPaquetes.getSelectedItem();
		String depSelecBox = (String)comboBoxDepartamentos.getSelectedItem();
		String actividadSelecBox = (String)comboBoxActividadesFueraDePaquete.getSelectedItem();
		
		if (checkFormulario()) {
				controlPaquete.AgregarActividadPaquete(paqueteSelecBox, depSelecBox, actividadSelecBox);
				
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
	}
	
	private boolean checkFormulario() {
		String paqueteSelecBox =  (String)comboBoxPaquetes.getSelectedItem();
		String depSelecBox = (String)comboBoxDepartamentos.getSelectedItem();
		String actividadSelecBox = (String)comboBoxActividadesFueraDePaquete.getSelectedItem();
		
		
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
}