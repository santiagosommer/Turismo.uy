package EstacionDeTrabajo.GUI;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import ServidorCentral.Logica.Clases.SalidaTuristica;
import ServidorCentral.Logica.DataTypes.DTDepartamento;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.Excepciones.ActividadNoExisteException;
import ServidorCentral.Logica.Excepciones.DepartamentoNoExisteException;
import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Fabrica.Fabrica;
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
	private JComboBox<String> comboBoxMes;
	private JLabel lblDia;
	private JComboBox<String> comboBoxDia;
	private JLabel lblCantidadMaximaTur;
	private JTextField textFieldCantMax;
	private JLabel lblHora;
	private JComboBox<String> comboBoxHour;
	private JComboBox<String> comboBoxMinute;
	private JLabel lblLugar;
	private JTextField textFieldLugar;
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
	
	public AltaDeSalidaTuristica(ITuristica iCTuri) throws DepartamentoNoExisteException {
		setBounds(10, 40, 400, 300);
		
		controlTur = iCTuri;
		setResizable(true);
		setIconifiable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Alta Salida Turistica");
		setBounds(10, 40, 400, 300);
		
		getContentPane().setLayout(null);
		
		lblElijaDepartamento = new JLabel("Elija Departamento");
		lblElijaDepartamento.setBounds(12, 12, 136, 15);
		getContentPane().add(lblElijaDepartamento);
		
		comboBoxDepartamentos = new JComboBox<String>();
		comboBoxDepartamentos.setBounds(166, 7, 172, 24);
		getContentPane().add(comboBoxDepartamentos);
		
		/*Fabrica fabricaU = Fabrica.getInstance();
		ITuristica ctr = fabricaU.getControladorTuristica();
		
		
		comboBoxDepartamentos.setSelectedIndex(-1);
		//agrega departamentos
		   if (!ctr.listarDepartamentos().isEmpty()) {
	         Iterator<String> iterator = ctr.listarDepartamentos().iterator(); 
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    comboBoxDepartamentos.addItem(setElement);
		     }
		   } */
		
		lblElijaActividad = new JLabel("Elija Actividad");
		lblElijaActividad.setBounds(12, 48, 136, 15);
		getContentPane().add(lblElijaActividad);
		
		comboBoxActividades = new JComboBox<String>();
		comboBoxActividades.setBounds(166, 43, 172, 24);
		getContentPane().add(comboBoxActividades);
		
		/*comboBoxActividades.setSelectedIndex(-1);
		//agrega departamentos
		if (comboBoxDepartamentos.getSelectedItem() != null) {
		   if (ctr.listarActividadesDeDepartamento(comboBoxDepartamentos.getSelectedItem().toString()) != null) {
	         Iterator<String> iterator = ctr.listarActividadesDeDepartamento((String)comboBoxDepartamentos.getSelectedItem()).iterator(); 
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    comboBoxActividades.addItem(setElement);
		     }
		   } 
		}*/
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 88, 70, 15);
		getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(76, 86, 100, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblFechaDeSalida = new JLabel("Info de salida:");
		lblFechaDeSalida.setBounds(12, 115, 116, 15);
		getContentPane().add(lblFechaDeSalida);
		
		lblAnio = new JLabel("Anio");
		
		lblAnio.setBounds(124, 122, 42, 15);
		getContentPane().add(lblAnio);
		
		comboBoxAnio = new JComboBox<String>();
		comboBoxAnio.setModel(new DefaultComboBoxModel<String>(new String[] {"Año","2022","2023","2024","2025"}));
		comboBoxAnio.setBounds(166, 117, 80, 24);
		getContentPane().add(comboBoxAnio);
		
		lblMes = new JLabel("Mes");
		lblMes.setBounds(124, 150, 70, 15);
		getContentPane().add(lblMes);
		
		comboBoxMes = new JComboBox<String>();
		comboBoxMes.setModel(new DefaultComboBoxModel<String>(new String[] { "Mes", "Enero", "Febrero", "Marzo",
				"Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre" }));
		comboBoxMes.setBounds(166, 145, 80, 24);
		getContentPane().add(comboBoxMes);
		
		lblDia = new JLabel("Dia");
		lblDia.setBounds(124, 183, 70, 15);
		getContentPane().add(lblDia);
		
		comboBoxDia = new JComboBox<String>();
		comboBoxDia.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBoxDia.setBounds(166, 177, 80, 24);
		getContentPane().add(comboBoxDia);
		
		lblCantidadMaximaTur = new JLabel("Cantidad maxima de turistas");
		lblCantidadMaximaTur.setBounds(12, 210, 246, 15);
		getContentPane().add(lblCantidadMaximaTur);
		
		textFieldCantMax = new JTextField();
		textFieldCantMax.setBounds(225, 208, 58, 19);
		getContentPane().add(textFieldCantMax);
		textFieldCantMax.setColumns(10);
		
        lblHora = new JLabel("Hora");
        lblHora.setBounds(253, 122, 70, 15);
        getContentPane().add(lblHora);
        
        comboBoxHour = new JComboBox<String>();
        comboBoxHour.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Hora","0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24" }));
        comboBoxHour.setBounds(290, 117, 48, 24);
        getContentPane().add(comboBoxHour);
        
        comboBoxMinute = new JComboBox<String>();
        comboBoxMinute.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Minuto","0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28","29", "30", "31", "32", "33", 
						"34","35", "36", "37", "38","39", "40", "41","42", "43","44","45", "46","47", "48", "49", "50","51",
						"52", "53","54","55", "56","57", "58", "59", "60"}));
        comboBoxMinute.setBounds(346, 117, 44, 24);
        getContentPane().add(comboBoxMinute);
        
        lblLugar = new JLabel("Lugar");
        lblLugar.setBounds(252, 150, 70, 15);
        getContentPane().add(lblLugar);
        
        textFieldLugar = new JTextField();
        textFieldLugar.setBounds(300, 148, 78, 19);
        getContentPane().add(textFieldLugar);
        textFieldLugar.setColumns(10);
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		AltaSalidaActionPerformed(e);
            		setVisible(false);
           }
        });
        btnAceptar.setBounds(35, 231, 117, 25);
        getContentPane().add(btnAceptar);
        
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	limpiarFormulario();
            	setVisible(false);
            }
        });
        btnCancelar.setBounds(205, 231, 117, 25);
        getContentPane().add(btnCancelar);
        
        
    }
	
	protected void AltaSalidaActionPerformed(ActionEvent e) {
		
		String depSeleccionadoComboBox = (String)comboBoxDepartamentos.getSelectedItem();
		String actSeleccionadaComboBox = (String)comboBoxActividades.getSelectedItem();
		String nombreSalida = textFieldNombre.getText();
		String dia = (String)comboBoxDia.getSelectedItem();
		String mes = (String)comboBoxMes.getSelectedItem();
		String anio = (String)comboBoxAnio.getSelectedItem();
		String hora = (String)comboBoxHour.getSelectedItem();
		String minuto = (String)comboBoxMinute.getSelectedItem();
		String lugar = textFieldLugar.getText();
		String cantMaxTS = textFieldCantMax.getText();
		
		if (checkFormulario()) {
			int cantMaxT = Integer.parseInt(cantMaxTS);
			int iDia = Integer.parseInt(dia);
			int iAnio = Integer.parseInt(anio);
			int iMes;
			if (mes.equals("Enero")) {
				iMes = 0;
			} else if (mes.equals("Febrero")) {
				iMes = 1;
			} else if (mes.equals("Marzo")) {
				iMes = 2;
			} else if (mes.equals("Abril")) {
				iMes = 3;
			} else if (mes.equals("Mayo")) {
				iMes = 4;
			} else if (mes.equals("Junio")) {
				iMes = 5;
			} else if (mes.equals("Julio")) {
				iMes = 6;
			} else if (mes.equals("Agosto")) {
				iMes = 7;
			} else if (mes.equals("Setiembre")) {
				iMes = 8;
			} else if (mes.equals("Octubre")) {
				iMes = 9;
			} else if (mes.equals("Noviembre")) {
				iMes = 10;
			} else {
				iMes = 11;
			}
			int iHora = Integer.parseInt(hora);
			int iMinuto = Integer.parseInt(minuto);
			
			try {
				
				LocalDate fechaActual = LocalDate.now();
				LocalDate fechaSalida = LocalDate.of(iAnio,iMes,iDia);
				LocalTime horaSalida =  LocalTime.of(iHora, iMinuto);
				
				DTInfoSalida info = new DTInfoSalida(fechaSalida, horaSalida, lugar);
				controlTur.crearSalidaTuristica(nombreSalida, cantMaxT,fechaActual, info, actSeleccionadaComboBox);
				
				JOptionPane.showMessageDialog(this, "La Salida " + nombreSalida + " se ha creado con éxito", "Alta de Salida Turistica",
                        JOptionPane.INFORMATION_MESSAGE);
				
				limpiarFormulario();
				setVisible(false);
			} catch (NombreSalidaRepetidoException ex) {
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Alta de Salida Turistica", JOptionPane.ERROR_MESSAGE);
			} catch (NoHayActividadConEseNombreException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Alta de Salida Turistica", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
				
		}
		
	}
	

	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textFieldCantMax.setText("");	
		textFieldLugar.setText("");
		comboBoxDepartamentos.setSelectedIndex(-1);
		comboBoxActividades.setSelectedIndex(-1);
		comboBoxDia.setSelectedIndex(-1);
		comboBoxMes.setSelectedIndex(-1);
		comboBoxAnio.setSelectedIndex(-1);
		comboBoxHour.setSelectedIndex(-1);
		comboBoxMinute.setSelectedIndex(-1);
		
	}
	
	private boolean checkFormulario() {
		
		String depSeleccionadoComboBox = (String)comboBoxDepartamentos.getSelectedItem();
		String actSeleccionadaComboBox = (String)comboBoxActividades.getSelectedItem();
		String nombreSalida = textFieldNombre.getText();
		String dia = (String)comboBoxDia.getSelectedItem();
		String mes = (String)comboBoxMes.getSelectedItem();
		String anio = (String)comboBoxAnio.getSelectedItem();
		String hora = (String)comboBoxHour.getSelectedItem();
		String minuto = (String)comboBoxMinute.getSelectedItem();
		String lugar = textFieldLugar.getText();
		String cantMaxTS = textFieldCantMax.getText();
		
		if ( nombreSalida.isEmpty() || lugar.isEmpty()|| cantMaxTS.isEmpty() || dia.equals("Dia") ||
				mes.equals("Mes") || anio.equals("Año") || hora.equals("Hora")|| minuto.equals("Minuto") || depSeleccionadoComboBox.equals("Departamento")|| actSeleccionadaComboBox.equals("Actividad")) {
			JOptionPane.showMessageDialog(this, "Rellene los campos (*)", "Alta de Salida Turistica",
                    JOptionPane.ERROR_MESSAGE);
		return false;
		}
		if (!checkFecha()) {
			JOptionPane.showMessageDialog(this, "Ingrese una fecha valida", "Alta de Salida Turistica",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (controlTur.existeSalida(nombreSalida)) {
			JOptionPane.showMessageDialog(this, "Ya existe una Salida con este nombre", "Alta de Salida Turistica",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private boolean checkFecha() {
		String dia = (String)comboBoxDia.getSelectedItem();
		String mes = (String)comboBoxMes.getSelectedItem();
		String hora = (String)comboBoxHour.getSelectedItem();
		String minuto = (String)comboBoxMinute.getSelectedItem();
		int iDia = Integer.parseInt(dia);
		int iHora = Integer.parseInt(hora);
		int iMinuto = Integer.parseInt(minuto);
		int iMes;
		if (mes.equals("Enero")) {
			iMes = 1;
		} else if (mes.equals("Febrero")) {
			iMes = 2;
		} else if (mes.equals("Marzo")) {
			iMes = 3;
		} else if (mes.equals("Abril")) {
			iMes = 4;
		} else if (mes.equals("Mayo")) {
			iMes = 5;
		} else if (mes.equals("Junio")) {
			iMes = 6;
		} else if (mes.equals("Julio")) {
			iMes = 7;
		} else if (mes.equals("Agosto")) {
			iMes = 8;
		} else if (mes.equals("Setiembre")) {
			iMes = 9;
		} else if (mes.equals("Octubre")) {
			iMes = 10;
		} else if (mes.equals("Noviembre")) {
			iMes = 11;
		} else {
			iMes = 12;
		}
		
		if ((iMes == 3) || (iMes == 5) || (iMes == 8) || (iMes == 10)) {
			if (iDia > 30) {
				return false;
			}
		}
		if ((iMes==1) && (iDia > 28)){
			return false;
		}
		if ((iHora > 24 )){
			return false;
		}
		if ((iMinuto > 60 )){
			return false;
		}

		return true;
	}
	
	public void cargarDep() {
		//comboBoxDepartamentos.setSelectedIndex(-1);
		try {
			Set<String> deps = controlTur.listarDepartamentos();
			Iterator<String> iterator = deps.iterator(); 
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    comboBoxDepartamentos.addItem(setElement);
		     }
		} catch (DepartamentoNoExisteException ex) {}
	}
	
	public void cargarAct() {
		comboBoxActividades.setSelectedIndex(-1);
			String dep = (String)comboBoxDepartamentos.getSelectedItem();
			if(controlTur.listarActividadesDeDepartamento(dep)!= null) {
				Iterator<String> iterator = controlTur.listarActividadesDeDepartamento(dep).iterator(); 
				while(iterator.hasNext()) { 
					String setElement = iterator.next(); 
					comboBoxActividades.addItem(setElement);
				}
			}
	}
	
}
