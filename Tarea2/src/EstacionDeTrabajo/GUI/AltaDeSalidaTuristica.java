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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class AltaDeSalidaTuristica extends JInternalFrame {
	
	private ITuristica controlTur;
	
	private JLabel lblElijaDepartamento;
	private JComboBox<String> comboBoxDepartamentos;
	private JLabel lblElijaActividad;
	private JComboBox<String> comboBoxActividades;
	private JLabel lblNombre;
	private JTextField textFieldNombre;
	private JLabel lblFecha;
	private JComboBox<String> comboBoxAnio;
	private JComboBox<String> comboBoxMes;
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
	
	
	
	
//public static void main(String[] args, ITuristica ctrl) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AltaDeSalidaTuristica frame = new AltaDeSalidaTuristica(ctrl);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public AltaDeSalidaTuristica(ITuristica iCTuri) {
		setMaximizable(true);
		
		controlTur = iCTuri;
		setResizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Alta de Salida Turistica");
		setBounds(10, 40, 828, 394);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {50, 50, 30, 91, 31, 30};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 0, 0, 30, };
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		
		lblElijaDepartamento = new JLabel("Departamento");
		GridBagConstraints gbc_lblElijaDepartamento = new GridBagConstraints();
		gbc_lblElijaDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_lblElijaDepartamento.gridx = 1;
		gbc_lblElijaDepartamento.gridy = 1;
		getContentPane().add(lblElijaDepartamento, gbc_lblElijaDepartamento);
		
		comboBoxDepartamentos = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxDepartamentos = new GridBagConstraints();
		gbc_comboBoxDepartamentos.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDepartamentos.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDepartamentos.gridwidth = 3;
		gbc_comboBoxDepartamentos.gridx = 2;
		gbc_comboBoxDepartamentos.gridy = 1;
		getContentPane().add(comboBoxDepartamentos, gbc_comboBoxDepartamentos);
		
		comboBoxDepartamentos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	comboBoxActividades.removeAllItems();
            	cargarAct();
            		//setVisible(false);
           }
        });
		
		
		lblElijaActividad = new JLabel("Actividad Turistica");
		GridBagConstraints gbc_lblElijaActividad = new GridBagConstraints();
		gbc_lblElijaActividad.insets = new Insets(0, 0, 5, 5);
		gbc_lblElijaActividad.gridx = 1;
		gbc_lblElijaActividad.gridy = 2;
		getContentPane().add(lblElijaActividad, gbc_lblElijaActividad);
		
		comboBoxActividades = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxActividades = new GridBagConstraints();
		gbc_comboBoxActividades.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxActividades.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxActividades.gridwidth = 3;
		gbc_comboBoxActividades.gridx = 2;
		gbc_comboBoxActividades.gridy = 2;
		getContentPane().add(comboBoxActividades, gbc_comboBoxActividades);
        
        
        lblNombre = new JLabel("Nombre");
        GridBagConstraints gbc_lblNombre = new GridBagConstraints();
        gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblNombre.gridx = 1;
        gbc_lblNombre.gridy = 3;
        getContentPane().add(lblNombre, gbc_lblNombre);
        
        textFieldNombre = new JTextField();
        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
        gbc_textFieldNombre.gridwidth = 3;
        gbc_textFieldNombre.fill = GridBagConstraints.HORIZONTAL;
        gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
        gbc_textFieldNombre.gridx = 2;
        gbc_textFieldNombre.gridy = 3;
        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
        textFieldNombre.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 4;
		getContentPane().add(lblFecha, gbc_lblFecha);
		
		comboBoxDia = new JComboBox<String>();
		comboBoxDia.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		GridBagConstraints gbc_comboBoxDia = new GridBagConstraints();
		gbc_comboBoxDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxDia.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxDia.gridx = 2;
		gbc_comboBoxDia.gridy = 4;
		getContentPane().add(comboBoxDia, gbc_comboBoxDia);
		
		comboBoxMes = new JComboBox<String>();
		comboBoxMes.setModel(new DefaultComboBoxModel<String>(new String[] { "1", "2", "3",
				"4", "5", "6", "7", "8", "9", "10", "1", "12" }));
		GridBagConstraints gbc_comboBoxMes = new GridBagConstraints();
		gbc_comboBoxMes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMes.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMes.gridx = 3;
		gbc_comboBoxMes.gridy = 4;
		getContentPane().add(comboBoxMes, gbc_comboBoxMes);
		
		comboBoxAnio = new JComboBox<String>();
		comboBoxAnio.setModel(new DefaultComboBoxModel<String>(new String[] { "2022","2023","2024","2025"}));
		GridBagConstraints gbc_comboBoxAnio = new GridBagConstraints();
		gbc_comboBoxAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAnio.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAnio.gridx = 4;
		gbc_comboBoxAnio.gridy = 4;
		getContentPane().add(comboBoxAnio, gbc_comboBoxAnio);
		
        lblHora = new JLabel("Hora");
        GridBagConstraints gbc_lblHora = new GridBagConstraints();
        gbc_lblHora.insets = new Insets(0, 0, 5, 5);
        gbc_lblHora.gridx = 1;
        gbc_lblHora.gridy = 5;
        getContentPane().add(lblHora, gbc_lblHora);
		
		comboBoxHour = new JComboBox<String>();
		comboBoxHour.setModel(new DefaultComboBoxModel<String>(
				new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23" }));
		GridBagConstraints gbc_comboBoxHour = new GridBagConstraints();
		gbc_comboBoxHour.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxHour.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxHour.gridx = 2;
		gbc_comboBoxHour.gridy = 5;
		getContentPane().add(comboBoxHour, gbc_comboBoxHour);
		
		comboBoxMinute = new JComboBox<String>();
		comboBoxMinute.setModel(new DefaultComboBoxModel<String>(
				new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28","29", "30", "31", "32", "33", 
						"34","35", "36", "37", "38","39", "40", "41","42", "43","44","45", "46","47", "48", "49", "50","51",
						"52", "53","54","55", "56","57", "58", "59"}));
		GridBagConstraints gbc_comboBoxMinute = new GridBagConstraints();
		gbc_comboBoxMinute.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMinute.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxMinute.gridx = 3;
		gbc_comboBoxMinute.gridy = 5;
		getContentPane().add(comboBoxMinute, gbc_comboBoxMinute);
		
		lblLugar = new JLabel("Lugar");
		GridBagConstraints gbc_lblLugar = new GridBagConstraints();
		gbc_lblLugar.insets = new Insets(0, 0, 5, 5);
		gbc_lblLugar.gridx = 1;
		gbc_lblLugar.gridy = 6;
		getContentPane().add(lblLugar, gbc_lblLugar);
		
		textFieldLugar = new JTextField();
		GridBagConstraints gbc_textFieldLugar = new GridBagConstraints();
		gbc_textFieldLugar.gridwidth = 3;
		gbc_textFieldLugar.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLugar.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLugar.gridx = 2;
		gbc_textFieldLugar.gridy = 6;
		getContentPane().add(textFieldLugar, gbc_textFieldLugar);
		textFieldLugar.setColumns(10);
		
		lblCantidadMaximaTur = new JLabel("Cupos Maximos");
		GridBagConstraints gbc_lblCantidadMaximaTur = new GridBagConstraints();
		gbc_lblCantidadMaximaTur.insets = new Insets(0, 0, 5, 5);
		gbc_lblCantidadMaximaTur.gridx = 1;
		gbc_lblCantidadMaximaTur.gridy = 7;
		getContentPane().add(lblCantidadMaximaTur, gbc_lblCantidadMaximaTur);
		
		textFieldCantMax = new JTextField();
		GridBagConstraints gbc_textFieldCantMax = new GridBagConstraints();
		gbc_textFieldCantMax.gridwidth = 3;
		gbc_textFieldCantMax.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCantMax.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCantMax.gridx = 2;
		gbc_textFieldCantMax.gridy = 7;
		getContentPane().add(textFieldCantMax, gbc_textFieldCantMax);
		textFieldCantMax.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    		AltaSalidaActionPerformed(e);
		    		//setVisible(false);
		   }
		});
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 2;
		gbc_btnAceptar.gridy = 9;
		getContentPane().add(btnAceptar, gbc_btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	limpiarFormulario();
		    	setVisible(false);
		    }
		});
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancelar.gridx = 4;
		gbc_btnCancelar.gridy = 9;
		getContentPane().add(btnCancelar, gbc_btnCancelar);
        
        
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
				LocalDate fechaSalida = LocalDate.of(iAnio,iMes+1,iDia);
				LocalTime horaSalida =  LocalTime.of(iHora, iMinuto);
				
				DTInfoSalida info = new DTInfoSalida(fechaSalida, horaSalida, lugar);
				controlTur.crearSalidaTuristica(nombreSalida, cantMaxT,fechaActual, info, actSeleccionadaComboBox);
				
				JOptionPane.showMessageDialog(this, "La Salida " + nombreSalida + " se ha creado con éxito", "Alta de Salida Turistica",
                        JOptionPane.INFORMATION_MESSAGE);
				
				limpiarFormulario();
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
		
	//	String depSeleccionadoComboBox = (String)comboBoxDepartamentos.getSelectedItem();
	// String actSeleccionadaComboBox = (String)comboBoxActividades.getSelectedItem();
		String nombreSalida = textFieldNombre.getText();
	//	String dia = (String)comboBoxDia.getSelectedItem();
	//	String mes = (String)comboBoxMes.getSelectedItem();
	//	String anio = (String)comboBoxAnio.getSelectedItem();
	//	String hora = (String)comboBoxHour.getSelectedItem();
	//	String minuto = (String)comboBoxMinute.getSelectedItem();
		String lugar = textFieldLugar.getText();
		String cantMaxTS = textFieldCantMax.getText();
		
		if (!cantMaxTS.isEmpty()) {
		 try {
	            Integer.parseInt(cantMaxTS);
	        } catch (NumberFormatException e) { 
	            JOptionPane.showMessageDialog(this, "La cantidad debe ser un numero", "Inscripcion a Salida Turistica",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	     }
		}
		
		if ( nombreSalida.isEmpty() || lugar.isEmpty()|| cantMaxTS.isEmpty() || comboBoxDia.getSelectedIndex() == -1|| comboBoxHour.getSelectedIndex() == -1||
				comboBoxAnio.getSelectedIndex() == -1 || comboBoxMinute.getSelectedIndex() == -1 || comboBoxMes.getSelectedIndex() == -1 || 
			comboBoxActividades.getSelectedIndex() == -1 || comboBoxDepartamentos.getSelectedIndex() == -1 ) {
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
		if (Integer.parseInt(cantMaxTS) < 0) {
			JOptionPane.showMessageDialog(this, "Ingrese un numero valido", "Alta de Salida Turistica",
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
		
		if ((iMes == 3) || (iMes == 5) || (iMes == 8) || (iMes == 10)) {
			if (iDia > 30) {
				return false;
			}
		}
		if ((iMes==1) && (iDia > 29)){
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
		
			Set<String> deps = controlTur.listarDepartamentos();
			Iterator<String> iterator = deps.iterator(); 
			comboBoxDepartamentos.removeAllItems();
	         while(iterator.hasNext()) { 
	    	    String setElement = iterator.next(); 
	    	    
	    	    comboBoxDepartamentos.addItem(setElement);
		     }
	      
		
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
