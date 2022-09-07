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
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.BorderLayout;

public class AltaDeUsuario extends JInternalFrame {

	private IUsuario controlUsr;
	
	AltaDeProveedor internalFrameAltaDeProveedor;
	AltaDeTurista internalFrameAltaDeTurista;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args,IUsuario ctrl) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AltaDeUsuario frame = new AltaDeUsuario(ctrl);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AltaDeUsuario(IUsuario ctrlUsr) {
		setBounds(100, 100, 593, 450);
		
		  controlUsr = ctrlUsr;
		    setResizable(true);
	        setMaximizable(true);
	        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        setClosable(true);
	        setTitle("Alta de Usuario");
	        setBounds(10, 40, 360, 450);
	        
	        JMenuBar menuBar = new JMenuBar();
	        setJMenuBar(menuBar);
	        getContentPane().setLayout(null);
	        
	         internalFrameAltaDeProveedor = new AltaDeProveedor(controlUsr);
	         internalFrameAltaDeProveedor.setResizable(true);
	        internalFrameAltaDeProveedor.setBounds(10, 11, 324, 327);
	        getContentPane().add(internalFrameAltaDeProveedor);
	        
	         internalFrameAltaDeTurista = new AltaDeTurista(controlUsr);
	        internalFrameAltaDeTurista.setBounds(10, 11, 324, 327);
	        getContentPane().add(internalFrameAltaDeTurista);
	        internalFrameAltaDeTurista.setVisible(false);
	        internalFrameAltaDeProveedor.setVisible(false);
	        
	        JMenu mnSeleccionar = new JMenu("Seleccionar");
	        menuBar.add(mnSeleccionar);
	        
	        JMenuItem mntmProveedor = new JMenuItem("Proveedor");
	        mntmProveedor.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		internalFrameAltaDeProveedor.setVisible(true);
	        	}
	        });
	        mnSeleccionar.add(mntmProveedor);
	        
	        JMenuItem mntmTurista = new JMenuItem("Turista");
	        mntmTurista.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		internalFrameAltaDeTurista.setVisible(true);
	        	}
	        });
	        mnSeleccionar.add(mntmTurista);
	        
	        JMenuItem mntmSalir = new JMenuItem("Salir");
	        mntmSalir.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		setVisible(false);
	        	}
	        });
	        mnSeleccionar.add(mntmSalir);
	}
}
