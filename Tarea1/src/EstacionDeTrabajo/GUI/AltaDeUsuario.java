package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import ServidorCentral.Logica.Interfaces.IUsuario;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class AltaDeUsuario extends JInternalFrame {

	
	private IUsuario controlUsr;
	private JTextField textFieldNombre;
    private JTextField textFieldApellido;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public AltaDeUsuario(IUsuario ctrlUsr) {
		  
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
	        panel.setLayout(new FormLayout(new ColumnSpec[] {
	        		FormSpecs.UNRELATED_GAP_COLSPEC,
	        		ColumnSpec.decode("45px"),
	        		FormSpecs.UNRELATED_GAP_COLSPEC,
	        		ColumnSpec.decode("86px"),
	        		ColumnSpec.decode("20px"),
	        		ColumnSpec.decode("45px"),
	        		FormSpecs.RELATED_GAP_COLSPEC,
	        		ColumnSpec.decode("86px"),},
	        	new RowSpec[] {
	        		FormSpecs.RELATED_GAP_ROWSPEC,
	        		RowSpec.decode("19px"),
	        		FormSpecs.LINE_GAP_ROWSPEC,
	        		RowSpec.decode("19px"),}));
	        
	        JLabel lblNewLabel = new JLabel("New label");
	        panel.add(lblNewLabel, "2, 2, left, center");
	        
	        textField = new JTextField();
	        panel.add(textField, "4, 2, left, top");
	        textField.setColumns(10);
	        
	        JLabel lblNewLabel_1 = new JLabel("New label");
	        panel.add(lblNewLabel_1, "2, 4, left, center");
	        
	        textFieldNombre = new JTextField();
	        panel.add( textFieldNombre, "4, 4, left, top");
	        textFieldNombre.setColumns(10);
	        
	        JLabel lblNewLabel_2 = new JLabel("New label");
	        panel.add(lblNewLabel_2, "6, 4, left, center");
	        
	        textFieldApellido = new JTextField();
	        panel.add(textFieldApellido, "8, 4, left, top");
	        textFieldApellido.setColumns(10);
	        

	        
	}
}
