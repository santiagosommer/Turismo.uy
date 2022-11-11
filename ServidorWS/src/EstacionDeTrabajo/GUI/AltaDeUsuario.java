package EstacionDeTrabajo.GUI;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import ServidorCentral.Logica.Interfaces.IUsuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AltaDeUsuario extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
