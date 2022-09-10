package EstacionDeTrabajo.GUI;

import javax.swing.JInternalFrame;

import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

public class InfoActividad extends JInternalFrame{
	
	
	public InfoActividad(DTActividadTuristica acti) {
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		setVisible(true);
		setTitle("Informacion de Salida Turistica");
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		getContentPane().add(lblNombre);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		getContentPane().add(lblNombre_1);
		lblNombre_1.setText(acti.getNombre());
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		getContentPane().add(lblProveedor);
		
		JLabel lblProveedor_1 = new JLabel("Proveedor:");
		getContentPane().add(lblProveedor_1);
		lblProveedor_1.setText(acti.getProveedor());
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		getContentPane().add(lblDepartamento);
		
		JLabel lblDepartamento_1 = new JLabel("Departamento:");
		getContentPane().add(lblDepartamento_1);
		lblDepartamento_1.setText(acti.getInfoDepartamento().getNombre());
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		getContentPane().add(lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		
		JLabel lblDescripcion_1 = new JLabel("Descripcion: ");
		scrollPane.setViewportView(lblDescripcion_1);
		lblDescripcion_1.setText(acti.getDescripcion());
		
		JLabel lblDuracion = new JLabel("Duracion (En hs):");
		getContentPane().add(lblDuracion);
		lblDuracion.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblDuracion_1 = new JLabel("Duracion (En hs):");
		lblDuracion_1.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(lblDuracion_1);
		lblDuracion_1.setText(String.valueOf(acti.getDuracion()));
		
		JLabel lblCosto = new JLabel("Costo:");
		getContentPane().add(lblCosto);
		lblCosto.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCosto_1 = new JLabel("Costo:");
		lblCosto_1.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(lblCosto_1);
		lblCosto_1.setText(String.valueOf(acti.getCostoTurista()));
		
		JLabel lblCuidad = new JLabel("Ciudad:");
		getContentPane().add(lblCuidad);
		
		JLabel lblCuidad_1 = new JLabel("Ciudad:");
		getContentPane().add(lblCuidad_1);
		lblCuidad_1.setText(acti.getCiudad());
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de alta:");
		getContentPane().add(lblFechaDeAlta);
		
		JLabel lblFechaDeAlta_1 = new JLabel("Fecha de alta:");
		getContentPane().add(lblFechaDeAlta_1);
		lblFechaDeAlta_1.setText(acti.getFechaAlta().toString());
		
		
		
	}
}