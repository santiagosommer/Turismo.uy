package EstacionDeTrabajo.GUI;

import javax.swing.JInternalFrame;

import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.Interfaces.ITuristica;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.time.LocalDate;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class InfoSalida extends JInternalFrame{
	
	public static void main(String[] args, DTSalidaTuristica dt) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoSalida frame = new InfoSalida(dt);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InfoSalida(DTSalidaTuristica salida) {
		setResizable(true);
		setClosable(true);
		setVisible(true);
		setTitle("Informacion de Salida Turistica");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		JLabel lblNombrecontent = new JLabel("NombreContent");
		GridBagConstraints gbc_lblNombrecontent = new GridBagConstraints();
		gbc_lblNombrecontent.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombrecontent.gridx = 2;
		gbc_lblNombrecontent.gridy = 1;
		getContentPane().add(lblNombrecontent, gbc_lblNombrecontent);
		lblNombrecontent.setText(salida.getNombre());
		
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad  Maxima de Turistas: ");
		GridBagConstraints gbc_lblCantidadMaximaDe = new GridBagConstraints();
		gbc_lblCantidadMaximaDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidadMaximaDe.gridx = 1;
		gbc_lblCantidadMaximaDe.gridy = 2;
		getContentPane().add(lblCantidadMaximaDe, gbc_lblCantidadMaximaDe);
		
		JLabel lblCantidadMaximaDe_1 = new JLabel("Cantidad Maxima de Turistas Content");
		GridBagConstraints gbc_lblCantidadMaximaDe_1 = new GridBagConstraints();
		gbc_lblCantidadMaximaDe_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidadMaximaDe_1.gridx = 2;
		gbc_lblCantidadMaximaDe_1.gridy = 2;
		getContentPane().add(lblCantidadMaximaDe_1, gbc_lblCantidadMaximaDe_1);
		lblCantidadMaximaDe_1.setText(String.valueOf(salida.getCantidadMaxTuristas()));
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta: ");
		GridBagConstraints gbc_lblFechaDeAlta = new GridBagConstraints();
		gbc_lblFechaDeAlta.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeAlta.gridx = 1;
		gbc_lblFechaDeAlta.gridy = 3;
		getContentPane().add(lblFechaDeAlta, gbc_lblFechaDeAlta);
		
		JLabel lblFechaDeAlta_1 = new JLabel("Fecha de Alta Content");
		GridBagConstraints gbc_lblFechaDeAlta_1 = new GridBagConstraints();
		gbc_lblFechaDeAlta_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeAlta_1.gridx = 2;
		gbc_lblFechaDeAlta_1.gridy = 3;
		getContentPane().add(lblFechaDeAlta_1, gbc_lblFechaDeAlta_1);
		lblFechaDeAlta_1.setText(salida.getFechaAlta().toString());
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida: ");
		GridBagConstraints gbc_lblFechaDeSalida = new GridBagConstraints();
		gbc_lblFechaDeSalida.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeSalida.gridx = 1;
		gbc_lblFechaDeSalida.gridy = 4;
		getContentPane().add(lblFechaDeSalida, gbc_lblFechaDeSalida);
		
		JLabel lblFechaDeSalida_1 = new JLabel("Fecha de Salida Content");
		GridBagConstraints gbc_lblFechaDeSalida_1 = new GridBagConstraints();
		gbc_lblFechaDeSalida_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeSalida_1.gridx = 2;
		gbc_lblFechaDeSalida_1.gridy = 4;
		getContentPane().add(lblFechaDeSalida_1, gbc_lblFechaDeSalida_1);
		lblFechaDeSalida_1.setText(salida.getInfoSalida().getFecha().toString());
		
		JLabel lblCuposDisponibles = new JLabel("Cupos Disponibles:");
		GridBagConstraints gbc_lblCuposDisponibles = new GridBagConstraints();
		gbc_lblCuposDisponibles.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuposDisponibles.gridx = 1;
		gbc_lblCuposDisponibles.gridy = 5;
		getContentPane().add(lblCuposDisponibles, gbc_lblCuposDisponibles);
		
		JLabel lblCuposDisponiblesContent = new JLabel("Cupos Disponibles Content");
		GridBagConstraints gbc_lblCuposDisponiblesContent = new GridBagConstraints();
		gbc_lblCuposDisponiblesContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuposDisponiblesContent.gridx = 2;
		gbc_lblCuposDisponiblesContent.gridy = 5;
		getContentPane().add(lblCuposDisponiblesContent, gbc_lblCuposDisponiblesContent);
		lblCuposDisponiblesContent.setText(String.valueOf(salida.getCuposDisponibles()));
		
		
		
	}
}