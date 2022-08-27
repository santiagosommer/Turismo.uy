package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
import java.awt.BorderLayout;
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
	
	private JLabel lblElijaDepartamento;
	private JComboBox<String> comboBoxDepartamentos;
	private JLabel lblElijaActividad;
	private JComboBox<String> comboBoxActividades;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JLabel lblFechaDeSalida;
	private JLabel lblAnio;
	private JComboBox<String> comboBoxAnio;
	private JLabel lblMes;
	private JComboBox comboBoxMes;
	private JLabel lblDia;
	private JComboBox<String> comboBoxDia;
	private JLabel lblCantidadMaximaTur;
	private JTextField textFieldCantMax;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	
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
		setClosable(true);
		setTitle("Alta Salida Turistica");
		setBounds(10, 40, 360, 300);
		
		getContentPane().setLayout(null);
		
		lblElijaDepartamento = new JLabel("Elija Departamento");
		lblElijaDepartamento.setBounds(12, 12, 136, 15);
		getContentPane().add(lblElijaDepartamento);
		
		comboBoxDepartamentos = new JComboBox();
		comboBoxDepartamentos.setBounds(166, 7, 172, 24);
		getContentPane().add(comboBoxDepartamentos);
		
		lblElijaActividad = new JLabel("Elija Actividad");
		lblElijaActividad.setBounds(12, 48, 136, 15);
		getContentPane().add(lblElijaActividad);
		
		comboBoxActividades = new JComboBox();
		comboBoxActividades.setBounds(166, 43, 172, 24);
		getContentPane().add(comboBoxActividades);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 88, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(76, 86, 100, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblFechaDeSalida = new JLabel("Fecha de salida:");
		lblFechaDeSalida.setBounds(12, 115, 116, 15);
		getContentPane().add(lblFechaDeSalida);
		
		lblAnio = new JLabel("Anio");
		lblAnio.setBounds(136, 115, 42, 15);
		getContentPane().add(lblAnio);
		
		comboBoxAnio = new JComboBox();
		comboBoxAnio.setBounds(178, 110, 80, 24);
		getContentPane().add(comboBoxAnio);
		
		lblMes = new JLabel("Mes");
		lblMes.setBounds(136, 150, 70, 15);
		getContentPane().add(lblMes);
		
		comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(178, 145, 80, 24);
		getContentPane().add(comboBoxMes);
		
		lblDia = new JLabel("Dia");
		lblDia.setBounds(136, 183, 70, 15);
		getContentPane().add(lblDia);
		
		comboBoxDia = new JComboBox();
		comboBoxDia.setBounds(178, 178, 80, 24);
		getContentPane().add(comboBoxDia);
		
		lblCantidadMaximaTur = new JLabel("Cantidad maxima de turistas");
		lblCantidadMaximaTur.setBounds(12, 210, 246, 15);
		getContentPane().add(lblCantidadMaximaTur);
		
		textFieldCantMax = new JTextField();
		textFieldCantMax.setBounds(225, 208, 58, 19);
		getContentPane().add(textFieldCantMax);
		textFieldCantMax.setColumns(10);
        
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//AltaSalidaTuristicaActionPerformed(e);
            }
        });
        btnAceptar.setBounds(35, 231, 117, 25);
        getContentPane().add(btnAceptar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              // limpiarFormulario();
               setVisible(false);
            }
        });
        btnCancelar.setBounds(205, 231, 117, 25);
        getContentPane().add(btnCancelar);
        
        
	}

	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldCantMax.setText("");	
		
	}
}
