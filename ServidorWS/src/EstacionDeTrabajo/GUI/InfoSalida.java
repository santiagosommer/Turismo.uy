package EstacionDeTrabajo.GUI;

import javax.swing.JInternalFrame;

import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import java.awt.EventQueue;

public class InfoSalida extends JInternalFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		lblFechaDeAlta_1.setText(new SimpleDateFormat("MM/dd/yyyy").format(salida.getFechaAlta().getTime()));
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de Salida: ");
		getContentPane().add(lblFechaDeSalida);
		
		JLabel lblFechaDeSalida_1 = new JLabel("Fecha de Salida Content");
		getContentPane().add(lblFechaDeSalida_1);
		lblFechaDeSalida_1.setText(new SimpleDateFormat("MM/dd/yyyy").format(salida.getInfoSalida().getFecha().getTime()));
		
		JLabel lblCuposDisponibles = new JLabel("Cupos Disponibles:");
		getContentPane().add(lblCuposDisponibles);
		
		JLabel lblCuposDisponiblesContent = new JLabel("Cupos Disponibles Content");
		getContentPane().add(lblCuposDisponiblesContent);
		lblCuposDisponiblesContent.setText(String.valueOf(salida.getCuposDisponibles()));
		
		
		
	}
}