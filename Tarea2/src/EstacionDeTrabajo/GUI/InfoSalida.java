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
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		setVisible(true);
		setTitle("Informacion de Salida Turistica");
		setBounds(0, 0, 550, 400);
		
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre");
		getContentPane().add(lblNombre);
		
		JLabel lblNombrecontent = new JLabel("NombreContent");
		getContentPane().add(lblNombrecontent);
		lblNombrecontent.setText(salida.getNombre());
		
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad  Maxima de Turistas: ");
		getContentPane().add(lblCantidadMaximaDe);
		
		JLabel lblCantidadMaximaDe_1 = new JLabel("Cantidad Maxima de Turistas Content");
		getContentPane().add(lblCantidadMaximaDe_1);
		lblCantidadMaximaDe_1.setText(String.valueOf(salida.getCantidadMaxTuristas()));
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de Alta: ");
		getContentPane().add(lblFechaDeAlta);
		
		JLabel lblFechaDeAlta_1 = new JLabel("Fecha de Alta Content");
		getContentPane().add(lblFechaDeAlta_1);
		lblFechaDeAlta_1.setText(salida.getFechaAlta().toString());
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida: ");
		getContentPane().add(lblFechaDeSalida);
		
		JLabel lblFechaDeSalida_1 = new JLabel("Fecha de Salida Content");
		getContentPane().add(lblFechaDeSalida_1);
		lblFechaDeSalida_1.setText(salida.getInfoSalida().getFecha().toString());
		
		JLabel lblCuposDisponibles = new JLabel("Cupos Disponibles:");
		getContentPane().add(lblCuposDisponibles);
		
		JLabel lblCuposDisponiblesContent = new JLabel("Cupos Disponibles Content");
		getContentPane().add(lblCuposDisponiblesContent);
		lblCuposDisponiblesContent.setText(String.valueOf(salida.getCuposDisponibles()));
		
		
		
	}
}