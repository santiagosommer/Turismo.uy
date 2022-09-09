package EstacionDeTrabajo.GUI;

import javax.swing.JInternalFrame;

import ServidorCentral.Logica.DataTypes.DTPaquete;
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

public class InfoPaquete extends JInternalFrame{
	
	public static void main(String[] args, DTPaquete dt) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoPaquete frame = new InfoPaquete(dt);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InfoPaquete(DTPaquete paquete) {
		setResizable(true);
		setClosable(true);
		setVisible(true);
		setTitle("Informacion de Paquete");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNombre = new JLabel("Nombre:");
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
		lblNombrecontent.setText(paquete.getNombre());
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 1;
		gbc_lblDescripcion.gridy = 2;
		getContentPane().add(lblDescripcion, gbc_lblDescripcion);
		
		JLabel lblDescripcionContent = new JLabel("Descripcion Content");
		GridBagConstraints gbc_lblDescripcionContent = new GridBagConstraints();
		gbc_lblDescripcionContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcionContent.gridx = 2;
		gbc_lblDescripcionContent.gridy = 2;
		getContentPane().add(lblDescripcionContent, gbc_lblDescripcionContent);
		lblDescripcionContent.setText("<dynamic>");
		
		JLabel lblPeriodoValidez = new JLabel("Periodo de Validez:");
		GridBagConstraints gbc_lblPeriodoValidez = new GridBagConstraints();
		gbc_lblPeriodoValidez.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeriodoValidez.gridx = 1;
		gbc_lblPeriodoValidez.gridy = 3;
		getContentPane().add(lblPeriodoValidez, gbc_lblPeriodoValidez);
		lblPeriodoValidez.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblPeriodoDeValidezContent = new JLabel("Periodo de validez content");
		GridBagConstraints gbc_lblPeriodoDeValidezContent = new GridBagConstraints();
		gbc_lblPeriodoDeValidezContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblPeriodoDeValidezContent.gridx = 2;
		gbc_lblPeriodoDeValidezContent.gridy = 3;
		getContentPane().add(lblPeriodoDeValidezContent, gbc_lblPeriodoDeValidezContent);
		lblPeriodoDeValidezContent.setText(String.valueOf(paquete.getPeriodoValidez()) + " dia/dias");
		
		JLabel lblDescuento = new JLabel("Descuento:");
		GridBagConstraints gbc_lblDescuento = new GridBagConstraints();
		gbc_lblDescuento.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuento.gridx = 1;
		gbc_lblDescuento.gridy = 4;
		getContentPane().add(lblDescuento, gbc_lblDescuento);
		lblDescuento.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblDescuentoContent = new JLabel("Descuento Content");
		GridBagConstraints gbc_lblDescuentoContent = new GridBagConstraints();
		gbc_lblDescuentoContent.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescuentoContent.gridx = 2;
		gbc_lblDescuentoContent.gridy = 4;
		getContentPane().add(lblDescuentoContent, gbc_lblDescuentoContent);
		lblDescuentoContent.setText(String.valueOf(paquete.getDescuento()) + "%");
		
		
		
	}
}