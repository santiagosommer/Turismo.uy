package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import ServidorCentral.Logica.Excepciones.CategoriaRepetidaException;
import ServidorCentral.Logica.Interfaces.ITuristica;

import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AltaDeCategoria extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private ITuristica controlTur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, ITuristica ctrl) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDeCategoria frame = new AltaDeCategoria(ctrl);
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
	public AltaDeCategoria(ITuristica ctrl) {
		controlTur = ctrl;
		
		setBounds(100, 100, 450, 300);
		setTitle("Alta de Categoria");
		setMaximizable(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 123, 0, 44, 104, 0};
		gridBagLayout.rowHeights = new int[]{0, 58, 27, 0, 34, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Nombre:   ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
		    	setVisible(false);
				
			}
		});
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (checkFormulario()) {
					 
					AltaCategoriaActionPerformed(e);
					
				}
				
				
			}
		});	
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		getContentPane().add(botonAceptar, gbc_btnNewButton);
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 4;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		
		
		
		
		
		
		
		

	}
	
	
	public void limpiarFormulario() {
		textField.setText("");
	}

	
	
	private boolean checkFormulario() {
		
		String nombreCategoria = textField.getText();
		if ( nombreCategoria.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Rellene el campo (*)", "Alta de Categoria",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
	   return true;
		
		
	}	
	
	
	protected void AltaCategoriaActionPerformed(ActionEvent e) {
		String nombreCategoria = textField.getText();
		
		try {
			controlTur.crearCategoria(nombreCategoria);
			JOptionPane.showMessageDialog(this, "La Categoria " + nombreCategoria + " se ha creado con éxito", "Alta de Salida Turistica",
                    JOptionPane.INFORMATION_MESSAGE);
			
			limpiarFormulario();
		} catch (CategoriaRepetidaException  ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage(), "Alta de Categoria", JOptionPane.ERROR_MESSAGE);
	}
		
	}

}
