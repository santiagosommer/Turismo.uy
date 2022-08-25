package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ConsultaDeSalidaTuristica extends JInternalFrame {

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
		gridBagLayout.columnWidths = new int[]{216, 162, 0};
		gridBagLayout.rowHeights = new int[]{0, 21, 20, 36, 68, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Seleccionar Departamento");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
       JComboBox<String> comboBoxDepartamentos = new JComboBox<String>();
		//solo para pruebas
       comboBoxDepartamentos.addItem("dep1");
       comboBoxDepartamentos.addItem("dep2");
       
       //esto agrega departamentos
    //   Iterator<String> iterator = ctrl.listarDepartamentos().iterator();
    //   while(iterator.hasNext()) { 
    //	   String setElement = iterator.next(); 
    	//   comboBoxDepartamentos.addItem(setElement);
    	   
      //  }

  
       
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		getContentPane().add(comboBoxDepartamentos, gbc_comboBox);
		
		
		
	  
		
		
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 4;
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 4;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		
		
	

	}

}
