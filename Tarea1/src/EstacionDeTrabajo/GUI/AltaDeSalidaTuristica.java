package EstacionDeTrabajo.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ServidorCentral.Logica.DataTypes.DTDepartamento;
import ServidorCentral.Logica.Interfaces.ITuristica;
import ServidorCentral.Logica.Interfaces.IUsuario;

import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class AltaDeSalidaTuristica extends JInternalFrame {
	
	private ITuristica controlTur;
	private JTextField textField;
	private JTextField textField_1;
	
	public static void main(String[] args, ITuristica ctrl) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDeSalidaTuristica frame = new AltaDeSalidaTuristica(ctrl);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AltaDeSalidaTuristica(ITuristica iCTuri) {
		setBounds(10, 40, 360, 300);
		
		controlTur = iCTuri;
		setResizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Alta Salida Turistica");
		setBounds(10, 40, 360, 300);
		setClosable(true);
		
		getContentPane().setLayout(null);
		
		JLabel lblEli = new JLabel("Elija Departamento");
		lblEli.setBounds(12, 12, 136, 15);
		getContentPane().add(lblEli);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(166, 7, 172, 24);
		getContentPane().add(comboBox);
		
		JLabel lblElija = new JLabel("Elija Actividad");
		lblElija.setBounds(12, 48, 136, 15);
		getContentPane().add(lblElija);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(166, 43, 172, 24);
		getContentPane().add(comboBox_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 88, 70, 15);
		getContentPane().add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(76, 86, 100, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFechaDeSalida = new JLabel("Fecha de salida:");
		lblFechaDeSalida.setBounds(12, 115, 116, 15);
		getContentPane().add(lblFechaDeSalida);
		
		JLabel lblAnio = new JLabel("Anio");
		lblAnio.setBounds(136, 115, 42, 15);
		getContentPane().add(lblAnio);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(178, 110, 80, 24);
		getContentPane().add(comboBox_2);
		
		JLabel lblMes = new JLabel("Mes");
		lblMes.setBounds(136, 150, 70, 15);
		getContentPane().add(lblMes);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(178, 145, 80, 24);
		getContentPane().add(comboBox_3);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(136, 183, 70, 15);
		getContentPane().add(lblDia);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(178, 178, 80, 24);
		getContentPane().add(comboBox_4);
		
		JLabel lblCantidadMaximaDe = new JLabel("Cantidad maxima de turistas");
		lblCantidadMaximaDe.setBounds(12, 210, 246, 15);
		getContentPane().add(lblCantidadMaximaDe);
		
		textField_1 = new JTextField();
		textField_1.setBounds(225, 208, 58, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
        
        
        JButton btnNewButton = new JButton("Aceptar");
        btnNewButton.setBounds(35, 231, 117, 25);
        getContentPane().add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//AltaSalidaTuristicaActionPerformed(e);
            }
        });
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(205, 231, 117, 25);
        getContentPane().add(btnCancelar);
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // limpiarFormulario();
               setVisible(false);
            }
        });
        
        
        
	}
}
