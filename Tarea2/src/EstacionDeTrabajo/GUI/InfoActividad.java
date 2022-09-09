package EstacionDeTrabajo.GUI;

import javax.swing.JInternalFrame;

import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class InfoActividad extends JInternalFrame{
	
	
	public InfoActividad(DTActividadTuristica acti) {
		setResizable(true);
		setClosable(true);
		setVisible(true);
		setTitle("Informacion de Paquete");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		getContentPane().add(lblNombre, gbc_lblNombre);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre_1 = new GridBagConstraints();
		gbc_lblNombre_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre_1.gridx = 2;
		gbc_lblNombre_1.gridy = 1;
		getContentPane().add(lblNombre_1, gbc_lblNombre_1);
		lblNombre_1.setText(acti.getNombre());
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
		gbc_lblProveedor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProveedor.gridx = 1;
		gbc_lblProveedor.gridy = 2;
		getContentPane().add(lblProveedor, gbc_lblProveedor);
		
		JLabel lblProveedor_1 = new JLabel("Proveedor:");
		GridBagConstraints gbc_lblProveedor_1 = new GridBagConstraints();
		gbc_lblProveedor_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblProveedor_1.gridx = 2;
		gbc_lblProveedor_1.gridy = 2;
		getContentPane().add(lblProveedor_1, gbc_lblProveedor_1);
		lblProveedor_1.setText(acti.getProveedor());
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
		gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento.gridx = 1;
		gbc_lblDepartamento.gridy = 3;
		getContentPane().add(lblDepartamento, gbc_lblDepartamento);
		
		JLabel lblDepartamento_1 = new JLabel("Departamento:");
		GridBagConstraints gbc_lblDepartamento_1 = new GridBagConstraints();
		gbc_lblDepartamento_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartamento_1.gridx = 2;
		gbc_lblDepartamento_1.gridy = 3;
		getContentPane().add(lblDepartamento_1, gbc_lblDepartamento_1);
		lblDepartamento_1.setText(acti.getInfoDepartamento().getNombre());
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 4;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		JLabel lblDescripcion_1 = new JLabel("Descripcion: ");
		GridBagConstraints gbc_lblDescripcion_1 = new GridBagConstraints();
		gbc_lblDescripcion_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion_1.gridx = 2;
		gbc_lblDescripcion_1.gridy = 4;
		getContentPane().add(lblDescripcion_1, gbc_lblDescripcion_1);
		lblDescripcion_1.setText(acti.getDescripcion());
		
		JLabel lblDuracion = new JLabel("Duracion (En hs):");
		GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
		gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion.gridx = 1;
		gbc_lblDuracion.gridy = 5;
		getContentPane().add(lblDuracion, gbc_lblDuracion);
		lblDuracion.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblDuracion_1 = new JLabel("Duracion (En hs):");
		lblDuracion_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblDuracion_1 = new GridBagConstraints();
		gbc_lblDuracion_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuracion_1.gridx = 2;
		gbc_lblDuracion_1.gridy = 5;
		getContentPane().add(lblDuracion_1, gbc_lblDuracion_1);
		lblDuracion_1.setText(String.valueOf(acti.getDuracion()));
		
		JLabel lblCosto = new JLabel("Costo:");
		GridBagConstraints gbc_lblCosto = new GridBagConstraints();
		gbc_lblCosto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto.gridx = 1;
		gbc_lblCosto.gridy = 6;
		getContentPane().add(lblCosto, gbc_lblCosto);
		lblCosto.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCosto_1 = new JLabel("Costo:");
		lblCosto_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCosto_1 = new GridBagConstraints();
		gbc_lblCosto_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCosto_1.gridx = 2;
		gbc_lblCosto_1.gridy = 6;
		getContentPane().add(lblCosto_1, gbc_lblCosto_1);
		lblCosto_1.setText(String.valueOf(acti.getCostoTurista()));
		
		JLabel lblCuidad = new JLabel("Ciudad:");
		GridBagConstraints gbc_lblCuidad = new GridBagConstraints();
		gbc_lblCuidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuidad.gridx = 1;
		gbc_lblCuidad.gridy = 7;
		getContentPane().add(lblCuidad, gbc_lblCuidad);
		
		JLabel lblCuidad_1 = new JLabel("Ciudad:");
		GridBagConstraints gbc_lblCuidad_1 = new GridBagConstraints();
		gbc_lblCuidad_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblCuidad_1.gridx = 2;
		gbc_lblCuidad_1.gridy = 7;
		getContentPane().add(lblCuidad_1, gbc_lblCuidad_1);
		lblCuidad_1.setText(acti.getCiudad());
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de alta:");
		GridBagConstraints gbc_lblFechaDeAlta = new GridBagConstraints();
		gbc_lblFechaDeAlta.insets = new Insets(0, 0, 0, 5);
		gbc_lblFechaDeAlta.gridx = 1;
		gbc_lblFechaDeAlta.gridy = 8;
		getContentPane().add(lblFechaDeAlta, gbc_lblFechaDeAlta);
		
		JLabel lblFechaDeAlta_1 = new JLabel("Fecha de alta:");
		GridBagConstraints gbc_lblFechaDeAlta_1 = new GridBagConstraints();
		gbc_lblFechaDeAlta_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblFechaDeAlta_1.gridx = 2;
		gbc_lblFechaDeAlta_1.gridy = 8;
		getContentPane().add(lblFechaDeAlta_1, gbc_lblFechaDeAlta_1);
		lblFechaDeAlta_1.setText(acti.getFechaAlta().toString());
		
		
		
	}
}