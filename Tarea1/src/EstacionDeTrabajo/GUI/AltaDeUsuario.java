package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import ServidorCentral.Logica.Interfaces.IUsuario;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AltaDeUsuario extends JInternalFrame {

	private IUsuario controlUsr;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args,IUsuario ctrl) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDeUsuario frame = new AltaDeUsuario(ctrl);
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
	public AltaDeUsuario(IUsuario ctrlUsr) {
		setBounds(100, 100, 450, 300);
		
		  controlUsr = ctrlUsr;
		    setResizable(true);
	        setIconifiable(true);
	        setMaximizable(true);
	        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        setClosable(true);
	        setTitle("Alta de Usuario");
	        setBounds(10, 40, 360, 150);
	        getContentPane().setLayout(null);
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(0, 0, 348, 121);
	        getContentPane().add(panel);
	        panel.setLayout(new MigLayout("", "[50px][grow][5px][41px][grow][5px][][36px][grow][][grow][][5px][9px][5px][][][36px][5px][41px][5px][50px][5px][30px]", "[19px][][21px][grow][][21px][]"));
	        
	        JLabel lblNewLabel = new JLabel("NickName");
	        panel.add(lblNewLabel, "cell 1 0,alignx right,aligny center");
	        
	        textField_3 = new JTextField();
	        panel.add(textField_3, "flowx,cell 4 0 3 1,alignx left,aligny top");
	        textField_3.setColumns(10);
	        
	        JLabel lblNewLabel_1 = new JLabel("Nombre");
	        panel.add(lblNewLabel_1, "cell 7 0,alignx left,aligny center");
	        
	        textField_2 = new JTextField();
	        panel.add(textField_2, "cell 9 0 2 1,growx,aligny top");
	        textField_2.setColumns(10);
	        
	        JLabel lblNewLabel_2 = new JLabel("Apellido");
	        panel.add(lblNewLabel_2, "cell 1 1,alignx left,aligny center");
	        
	        textField = new JTextField();
	        panel.add(textField, "cell 4 1 3 1,growx,aligny center");
	        textField.setColumns(10);
	        
	        JLabel lblNewLabel_3 = new JLabel("Email");
	        panel.add(lblNewLabel_3, "cell 7 1,alignx left,aligny center");
	        
	        textField_1 = new JTextField();
	        panel.add(textField_1, "cell 9 1 2 1,growx,aligny center");
	        textField_1.setColumns(10);
	        
	        JLabel lblNewLabel_4 = new JLabel("New label");
	        panel.add(lblNewLabel_4, "cell 1 3");
	        
	        JComboBox comboBox = new JComboBox();
	        panel.add(comboBox, "cell 4 3,growx");
	        
	        JLabel lblNewLabel_5 = new JLabel("New label");
	        panel.add(lblNewLabel_5, "cell 6 3,alignx trailing");
	        
	        JComboBox comboBox_1 = new JComboBox();
	        panel.add(comboBox_1, "cell 7 3,growx");
	        
	        JLabel lblNewLabel_6 = new JLabel("New label");
	        panel.add(lblNewLabel_6, "cell 9 3,alignx trailing");
	        
	        JComboBox comboBox_2 = new JComboBox();
	        panel.add(comboBox_2, "cell 10 3 5 1,growx");
	        
	   
	        
	        
	        JButton btnAceptar = new JButton("Aceptar");
	        panel.add(btnAceptar, "cell 6 6,alignx center,aligny top");
	        btnAceptar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	//AltaUsuarioActionPerformed(e);
	            }
	        });
	        
	   
	        JButton btnCancelar = new JButton("Cancelar");
	        btnCancelar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              // limpiarFormulario();
	               setVisible(false);
	            }
	        });
	        
	        panel.add(btnCancelar, "cell 9 6,alignx left,aligny top");
	}

}
