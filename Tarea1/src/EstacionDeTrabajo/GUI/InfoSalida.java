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
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		getContentPane().add(lblNombre);
		
		JLabel lblNombrecontent = new JLabel("NombreContent");
		getContentPane().add(lblNombrecontent);
		lblNombrecontent.setText("Nombre");
		
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad  Maxima de Turistas: ");
		getContentPane().add(lblCantidadMaximaDe);
		
		JLabel lblCantidadMaximaDe_1 = new JLabel("Cantidad Maxima de Turistas Content");
		getContentPane().add(lblCantidadMaximaDe_1);
		lblCantidadMaximaDe_1.setText(String.valueOf(salida.getCantidadMaxTuristas()));
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta: ");
		getContentPane().add(lblFechaDeAlta);
		
		JLabel lblFechaDeAlta_1 = new JLabel("Fecha de Alta Content");
		getContentPane().add(lblFechaDeAlta_1);
		lblFechaDeAlta_1.setText("2001-01-01");
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida: ");
		getContentPane().add(lblFechaDeSalida);
		
		JLabel lblFechaDeSalida_1 = new JLabel("Fecha de Salida Content");
		getContentPane().add(lblFechaDeSalida_1);
		lblFechaDeSalida_1.setText("2001-01-01");
		
		JLabel lblCuposDisponibles = new JLabel("Cupos Disponibles:");
		getContentPane().add(lblCuposDisponibles);
		
		JLabel lblCuposDisponiblesContent = new JLabel("Cupos Disponibles Content");
		getContentPane().add(lblCuposDisponiblesContent);
		lblCuposDisponiblesContent.setText(String.valueOf(salida.getCuposDisponibles()));
		
		
		
	}
}