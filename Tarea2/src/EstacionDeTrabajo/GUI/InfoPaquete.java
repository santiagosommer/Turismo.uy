package EstacionDeTrabajo.GUI;

import javax.swing.JInternalFrame;

import ServidorCentral.Logica.Clases.Paquete;
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
import javax.swing.JScrollPane;

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
		setMaximizable(true);
		setResizable(true);
		setClosable(true);
		setVisible(true);
		setTitle("Informacion de Paquete");
		setBounds(0, 0, 550, 400);
		
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		getContentPane().add(lblNombre);
		
		JLabel lblNombrecontent = new JLabel("NombreContent");
		getContentPane().add(lblNombrecontent);
		lblNombrecontent.setText(paquete.getNombre());
		
		JLabel lblDescripcion = new JLabel("Descripcion: ");
		getContentPane().add(lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane);
		
		JLabel lblDescripcionContent = new JLabel("Descripcion Content");
		scrollPane.setViewportView(lblDescripcionContent);
		lblDescripcionContent.setText(paquete.getDescripcion());
		
		JLabel lblPeriodoValidez = new JLabel("Periodo de Validez:");
		getContentPane().add(lblPeriodoValidez);
		lblPeriodoValidez.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblPeriodoDeValidezContent = new JLabel("Periodo de validez content");
		getContentPane().add(lblPeriodoDeValidezContent);
		lblPeriodoDeValidezContent.setText(String.valueOf(paquete.getPeriodoValidez()) + " dia/dias");
		
		JLabel lblDescuento = new JLabel("Descuento:");
		getContentPane().add(lblDescuento);
		lblDescuento.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblDescuentoContent = new JLabel("Descuento Content");
		getContentPane().add(lblDescuentoContent);
		lblDescuentoContent.setText(String.valueOf(paquete.getDescuento()) + "%");
		
		
		
	}
}