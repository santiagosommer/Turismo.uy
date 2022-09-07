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
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 594, 286);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);
		
		JLabel lblNombrecontent = new JLabel("NombreContent");
		panel.add(lblNombrecontent);
		lblNombrecontent.setText(salida.getNombre());
		
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad  Maxima de Turistas: ");
		panel.add(lblCantidadMaximaDe);
		
		JLabel lblCantidadMaximaDe_1 = new JLabel("Cantidad Maxima de Turistas Content");
		panel.add(lblCantidadMaximaDe_1);
		lblCantidadMaximaDe_1.setText(String.valueOf(salida.getCantidadMaxTuristas()));
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta: ");
		panel.add(lblFechaDeAlta);
		
		JLabel lblFechaDeAlta_1 = new JLabel("Fecha de Alta Content");
		panel.add(lblFechaDeAlta_1);
		lblFechaDeAlta_1.setText(salida.getFechaAlta().toString());
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida: ");
		panel.add(lblFechaDeSalida);
		
		JLabel lblFechaDeSalida_1 = new JLabel("Fecha de Salida Content");
		panel.add(lblFechaDeSalida_1);
		lblFechaDeSalida_1.setText(salida.getInfoSalida().getFecha().toString());
		
		JLabel lblCuposDisponibles = new JLabel("Cupos Disponibles:");
		panel.add(lblCuposDisponibles);
		
		JLabel lblCuposDisponiblesContent = new JLabel("Cupos Disponibles Content");
		panel.add(lblCuposDisponiblesContent);
		lblCuposDisponiblesContent.setText(String.valueOf(salida.getCuposDisponibles()));
		
		
		
	}
}