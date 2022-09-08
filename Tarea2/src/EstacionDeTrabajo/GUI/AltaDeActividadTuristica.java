package EstacionDeTrabajo.GUI;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToolBar;

import ServidorCentral.Logica.Controladores.ControladorTuristica;
import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Excepciones.UsuarioNoExisteException;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;

import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ActionEvent;

public class AltaDeActividadTuristica extends JInternalFrame {
	private IUsuario iUsu;
	private ITuristica iTur;
	private JTextField NombreField;
	private JTextField DescripcionField;
	private JTextField DuracionField;
	private JTextField CostoTuristaField;
	private JTextField CiudadField;
	private JButton AceptarButton;
	private JButton CancelarButton;
	private JComboBox DepartamentoBox;
	private JLabel lblDepartamento;
	private JLabel lblProveedor;
	private JComboBox ProveedorBox;

	public AltaDeActividadTuristica(ITuristica interf, IUsuario interfU) {
		setResizable(true);
		setMaximizable(true);
		setTitle("Alta de Actividad Turistica");
		iTur = interf;
		iUsu = interfU;
		setBounds(100, 100, 692, 402);
		setClosable(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {-27, 30, 104, 30, 0, 0};
		gridBagLayout.rowHeights = new int[] { 30, 0, 0, 0, 0, 0, 0, 0, 52, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
				
						JLabel lblNombre = new JLabel("Nombre");
						GridBagConstraints gbc_lblNombre = new GridBagConstraints();
						gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
						gbc_lblNombre.gridx = 1;
						gbc_lblNombre.gridy = 1;
						getContentPane().add(lblNombre, gbc_lblNombre);
		
				NombreField = new JTextField();
				GridBagConstraints gbc_NombreField = new GridBagConstraints();
				gbc_NombreField.gridwidth = 2;
				gbc_NombreField.insets = new Insets(0, 0, 5, 5);
				gbc_NombreField.fill = GridBagConstraints.HORIZONTAL;
				gbc_NombreField.gridx = 2;
				gbc_NombreField.gridy = 1;
				getContentPane().add(NombreField, gbc_NombreField);
				NombreField.setColumns(10);
		
				JLabel lblDescripcion = new JLabel("Descripcion");
				GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
				gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
				gbc_lblDescripcion.gridx = 1;
				gbc_lblDescripcion.gridy = 2;
				getContentPane().add(lblDescripcion, gbc_lblDescripcion);

		DescripcionField = new JTextField();
		DescripcionField.setColumns(10);
		GridBagConstraints gbc_DescripcionField = new GridBagConstraints();
		gbc_DescripcionField.gridwidth = 2;
		gbc_DescripcionField.insets = new Insets(0, 0, 5, 5);
		gbc_DescripcionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_DescripcionField.gridx = 2;
		gbc_DescripcionField.gridy = 2;
		getContentPane().add(DescripcionField, gbc_DescripcionField);
		
				JLabel lblDuracion = new JLabel("Duracion");
				GridBagConstraints gbc_lblDuracion = new GridBagConstraints();
				gbc_lblDuracion.insets = new Insets(0, 0, 5, 5);
				gbc_lblDuracion.gridx = 1;
				gbc_lblDuracion.gridy = 3;
				getContentPane().add(lblDuracion, gbc_lblDuracion);

		DuracionField = new JTextField();
		DuracionField.setColumns(10);
		GridBagConstraints gbc_DuracionField = new GridBagConstraints();
		gbc_DuracionField.gridwidth = 2;
		gbc_DuracionField.insets = new Insets(0, 0, 5, 5);
		gbc_DuracionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_DuracionField.gridx = 2;
		gbc_DuracionField.gridy = 3;
		getContentPane().add(DuracionField, gbc_DuracionField);
		
				JLabel lblCostoTurista = new JLabel("Costo por Turista");
				GridBagConstraints gbc_lblCostoTurista = new GridBagConstraints();
				gbc_lblCostoTurista.insets = new Insets(0, 0, 5, 5);
				gbc_lblCostoTurista.gridx = 1;
				gbc_lblCostoTurista.gridy = 4;
				getContentPane().add(lblCostoTurista, gbc_lblCostoTurista);

		CostoTuristaField = new JTextField();
		CostoTuristaField.setColumns(10);
		GridBagConstraints gbc_CostoTuristaField = new GridBagConstraints();
		gbc_CostoTuristaField.gridwidth = 2;
		gbc_CostoTuristaField.insets = new Insets(0, 0, 5, 5);
		gbc_CostoTuristaField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CostoTuristaField.gridx = 2;
		gbc_CostoTuristaField.gridy = 4;
		getContentPane().add(CostoTuristaField, gbc_CostoTuristaField);
		
				JLabel lblCiudad = new JLabel("Ciudad");
				GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
				gbc_lblCiudad.insets = new Insets(0, 0, 5, 5);
				gbc_lblCiudad.gridx = 1;
				gbc_lblCiudad.gridy = 5;
				getContentPane().add(lblCiudad, gbc_lblCiudad);

		CiudadField = new JTextField();
		CiudadField.setColumns(10);
		GridBagConstraints gbc_CiudadField = new GridBagConstraints();
		gbc_CiudadField.gridwidth = 2;
		gbc_CiudadField.insets = new Insets(0, 0, 5, 5);
		gbc_CiudadField.fill = GridBagConstraints.HORIZONTAL;
		gbc_CiudadField.gridx = 2;
		gbc_CiudadField.gridy = 5;
		getContentPane().add(CiudadField, gbc_CiudadField);
		JInternalFrame monturaFrame = this;
				
						lblDepartamento = new JLabel("Departamento");
						GridBagConstraints gbc_lblDepartamento = new GridBagConstraints();
						gbc_lblDepartamento.insets = new Insets(0, 0, 5, 5);
						gbc_lblDepartamento.gridx = 1;
						gbc_lblDepartamento.gridy = 6;
						getContentPane().add(lblDepartamento, gbc_lblDepartamento);
		
				DepartamentoBox = new JComboBox();
				GridBagConstraints gbc_DepartamentoBox = new GridBagConstraints();
				gbc_DepartamentoBox.gridwidth = 2;
				gbc_DepartamentoBox.insets = new Insets(0, 0, 5, 5);
				gbc_DepartamentoBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_DepartamentoBox.gridx = 2;
				gbc_DepartamentoBox.gridy = 6;
				getContentPane().add(DepartamentoBox, gbc_DepartamentoBox);
				
						lblProveedor = new JLabel("Proveedor");
						GridBagConstraints gbc_lblProveedor = new GridBagConstraints();
						gbc_lblProveedor.insets = new Insets(0, 0, 5, 5);
						gbc_lblProveedor.gridx = 1;
						gbc_lblProveedor.gridy = 7;
						getContentPane().add(lblProveedor, gbc_lblProveedor);
		
				ProveedorBox = new JComboBox();
				GridBagConstraints gbc_ProveedorBox = new GridBagConstraints();
				gbc_ProveedorBox.gridwidth = 2;
				gbc_ProveedorBox.insets = new Insets(0, 0, 5, 5);
				gbc_ProveedorBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_ProveedorBox.gridx = 2;
				gbc_ProveedorBox.gridy = 7;
				getContentPane().add(ProveedorBox, gbc_ProveedorBox);
																				
																						AceptarButton = new JButton("Aceptar");
																						GridBagConstraints gbc_AceptarButton = new GridBagConstraints();
																						gbc_AceptarButton.insets = new Insets(0, 0, 5, 5);
																						gbc_AceptarButton.gridx = 2;
																						gbc_AceptarButton.gridy = 8;
																						getContentPane().add(AceptarButton, gbc_AceptarButton);
																						
																								AceptarButton.addActionListener(new ActionListener() {
																									public void actionPerformed(ActionEvent e) {
																										try {
																											cmdAltaDeActividadTuristicaActionPerformed(e);
																										} catch (NombreActividadRepetidoException e1) {
																										}
																									}
																						
																								});
																		
																				CancelarButton = new JButton("Cancelar");
																				GridBagConstraints gbc_CancelarButton = new GridBagConstraints();
																				gbc_CancelarButton.insets = new Insets(0, 0, 5, 5);
																				gbc_CancelarButton.gridx = 3;
																				gbc_CancelarButton.gridy = 8;
																				getContentPane().add(CancelarButton, gbc_CancelarButton);
												
														CancelarButton.addActionListener(new ActionListener() {
															public void actionPerformed(ActionEvent e) {
																limpiarFormulario();
																setVisible(false);
															}
														});

	}

	public void cmdAltaDeActividadTuristicaActionPerformed(ActionEvent e) throws NombreActividadRepetidoException {
		
		String depa = "-1";
		String prov = "-1";
		if (this.DepartamentoBox.getSelectedIndex() != -1){
			depa = DepartamentoBox.getSelectedItem().toString();
		}
		if (this.ProveedorBox.getSelectedIndex() != -1) {
			prov = ProveedorBox.getSelectedItem().toString();
		}
		String nombre = this.NombreField.getText();
		String descripcion = this.DescripcionField.getText();
		String duracion = this.DuracionField.getText();
		String costoTurista = this.CostoTuristaField.getText();
		String ciudad = CiudadField.getText();

		if (checkFormulario()) {
			try {
				iTur.crearActividadTuristica(nombre, descripcion, Integer.parseInt(duracion),
						Float.valueOf(costoTurista), LocalDate.now(), ciudad, depa, prov);

				JOptionPane.showMessageDialog(this, "La actividad se ha creado con éxito", "Registrar actividad",
						JOptionPane.INFORMATION_MESSAGE);

				limpiarFormulario();
			} catch (NombreActividadRepetidoException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Registrar actividad", JOptionPane.ERROR_MESSAGE);
				throw new NombreActividadRepetidoException("La actividad ya esta registrada");
			}
		}

	}

	private boolean checkFormulario() {
		String nombre = this.NombreField.getText();
		String descripcion = this.DescripcionField.getText();
		String duracion = this.DuracionField.getText();
		String costoTurista = this.CostoTuristaField.getText();
		String ciudad = CiudadField.getText();

		if (nombre.isEmpty() || descripcion.isEmpty() || duracion.isEmpty() || costoTurista.isEmpty()
				|| ciudad.isEmpty() || this.DepartamentoBox.getSelectedIndex() == -1
				|| this.ProveedorBox.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar actividad",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (Integer.parseInt(duracion) < 0 ||  Integer.parseInt(costoTurista) < 0) {
			JOptionPane.showMessageDialog(this, "Ingrese un numero valido", "Registrar actividad",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		try {
			Integer.parseInt(duracion);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "La duracion debe ser un numero", "Registrar actividad",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		try {
			Integer.parseInt(costoTurista);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "El costo debe ser un numero", "Registrar actividad",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	public void cargarDatosDepartamentos() {

		Set<String> depas = iTur.listarDepartamentos();
		Iterator<String> itr = depas.iterator();
		DepartamentoBox.removeAllItems();
		while (itr.hasNext()) {
			DepartamentoBox.addItem(itr.next());
		}
		DepartamentoBox.setSelectedIndex(-1);

	}

	public void cargarDatosProveedores() {
		try {
			Set<String> provs = iUsu.listarProveedores();
			Iterator<String> itr = provs.iterator();
			ProveedorBox.removeAllItems();
			while (itr.hasNext()) {
				ProveedorBox.addItem(itr.next());
			}
			ProveedorBox.setSelectedIndex(-1);
		} catch (UsuarioNoExisteException ex) {
			// // No se imprime mensaje de error sino que simplemente no se muestra ningún
			// elemento
		}
	}

	public void limpiarFormulario() {
		NombreField.setText("");
		DescripcionField.setText("");
		DuracionField.setText("");
		CiudadField.setText("");
		CostoTuristaField.setText("");
		DepartamentoBox.setSelectedIndex(-1);
		ProveedorBox.setSelectedIndex(-1);
	}

}
