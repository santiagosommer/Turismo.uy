package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.IPaquete;
import ServidorCentral.Logica.Interfaces.ITuristica;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AceptaroRechazarActividadTuristica extends JInternalFrame {
	private JComboBox<String> comboBoxActividades;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args,ITuristica interfazTuristica) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AceptaroRechazarActividadTuristica frame = new AceptaroRechazarActividadTuristica( interfazTuristica);
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
	public AceptaroRechazarActividadTuristica(ITuristica interfazTuristica) {
		setTitle("Aceptar/Rechazar Actividad Turistica");
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{438, 0};
		gridBagLayout.rowHeights = new int[]{93, 170, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 121, 223, 0};
		gbl_panel_1.rowHeights = new int[]{0, 83, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Actividades Agregadas");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		comboBoxActividades = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		panel_1.add(comboBoxActividades, gbc_comboBox);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 72, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 13, 36, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cambia el estado
			}
		});
		
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridheight = 3;
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnAceptar, gbc_btnNewButton);
		
		JButton btnRechazar = new JButton("Rechazar");
		btnRechazar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cambiar estado
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 3;
		gbc_btnNewButton_1.gridx = 5;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnRechazar, gbc_btnNewButton_1);

	}
	public void cargarAct() {
		Fabrica fabricaU = Fabrica.getInstance();
		ITuristica ctrT = fabricaU.getControladorTuristica();
		//	Iterator<String> iterator = ctrT.listarActividadesAgregadas()
	    //     while(iterator.hasNext()) { 
	    	//    String setElement = iterator.next(); 
	    //	    comboBoxActividades.addItem(setElement);
		 //    }
	}

}
