package EstacionDeTrabajo.GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

import ServidorCentral.Logica.Clases.ActividadTuristica;
import ServidorCentral.Logica.Clases.Departamento;
import ServidorCentral.Logica.Clases.Paquete;
import ServidorCentral.Logica.Clases.Proveedor;
import ServidorCentral.Logica.Clases.SalidaTuristica;
import ServidorCentral.Logica.Clases.Turista;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Interfaces.*;

public class CargaDeDatos {
	
	HashMap<String, Proveedor> mapaProveedores;
	HashMap<String, Turista> mapaTuristas;
	HashMap<String, Departamento> mapaDepartamentos;
	HashMap<String, ActividadTuristica> mapaActividades;
	HashMap<String, SalidaTuristica> mapaSalidas;
	HashMap<String, Paquete> mapaPaquetes;
	
	Scanner scUsuarios;
	Scanner scProveedores;
	Scanner scTuristas;
	Scanner scDepartamentos;
	Scanner scActividades;
	Scanner scSalidas;
	Scanner scPaquetes;
	
	Boolean yaCargo = false;
	
	IUsuario interfazUsuario;
	ITuristica interfazTuristica;
	IPaquete interfazPaquetes;
	
	
	public CargaDeDatos(IUsuario interfazUsuario, ITuristica interfazTuristica, IPaquete interfazPaquete) throws FileNotFoundException {
		this.interfazUsuario = interfazUsuario;
		this.interfazTuristica =interfazTuristica;
		this.interfazPaquetes = interfazPaquete;
		
		mapaProveedores = new HashMap<>();
		mapaTuristas = new HashMap<>();
		mapaDepartamentos = new HashMap<>();
		mapaActividades = new HashMap<>();
		mapaSalidas = new HashMap<>();
		mapaPaquetes = new HashMap<>();
		
		File folder = new File(System.getProperty("user.dir")+"/src/EstacionDeTrabajo/GUI/Datos de Prueba/");
		
		scDepartamentos = new Scanner(new File(folder, "Departamentos.csv"));
		scDepartamentos.useDelimiter(",");
		scDepartamentos.nextLine();
		
		scUsuarios = new Scanner(new File(folder, "Usuarios.csv"));
		scUsuarios.useDelimiter(",");
		scUsuarios.nextLine();
		
		scProveedores = new Scanner(new File(folder, "Usuarios-Proveedores.csv"));
		scProveedores.useDelimiter(",");
		scProveedores.nextLine();
		
		scTuristas = new Scanner(new File(folder, "Usuarios-Turistas.csv"));
		scTuristas.useDelimiter(",");
		scTuristas.nextLine();
	}
	
	public Boolean cargarDatos() throws UsuarioRepetidoException {
		if (yaCargo)
			return false;
		else {
			yaCargo = true;
			//Caso Departamentos 
			while (scDepartamentos.hasNextLine()) {
				String line = scDepartamentos.nextLine();
				String[] lineSplit = line.trim().split("\\s*,\\s*");
				interfazTuristica.crearDepartamento(lineSplit[1], lineSplit[2], lineSplit[3]);	
			}
			scDepartamentos.close();
			
			//Caso Usuarios
			
			interfazUsuario.altaTurista("lachiqui","Rosa María","Martínez", "mirtha.legrand.ok@hotmail.com.ar",	LocalDate.of(1927, 2, 23), "argentina");
			interfazUsuario.altaTurista("isabelita","Elizabeth","Windsor", "isabelita@thecrown.co.uk",LocalDate.of(1926,04,21), "inglesa");
			interfazUsuario.altaTurista("anibal","Aníbal","Lecter","anibal@fing.edu.uy",LocalDate.of(1937,12,31),"lituana");
			interfazUsuario.altaTurista("waston","Emma", "Waston","e.waston@gmail.com", LocalDate.of(1990,4,15), "inglesa" );
			interfazUsuario.altaTurista("elelvis","Elvis","Lacio","suavemente@hotmail.com", LocalDate.of(1971,7,1971), "estadounidense");
			interfazUsuario.altaTurista("eleven11","Eleven","Once", "eleven11@gmail.com",LocalDate.of(2004,2,19),"española");
			interfazUsuario.altaTurista("bobesponja","Bob","Esponja","bobesponja@nickelodeon.com",LocalDate.of(1999,5,1),"japonesa");
			interfazUsuario.altaTurista("tony","Antonio","Pacheco","eltony@manya.org.uy", LocalDate.of(1976,4,11), "uruguaya");
			interfazUsuario.altaTurista("chino","Álvaro","Recoba","chino@trico.org.uy", LocalDate.of(1976,3,17), "uruguaya");
			interfazUsuario.altaTurista("mastropiero","Johann","Sebastian Mastropiero","johann.sebastian@gmail.com",LocalDate.of(1922,02,07),"austríaca");
			interfazUsuario.altaProveedor("washington","Washington","Rocha","washington@turismorocha.gub.uy",LocalDate.of(1970,9,14),"Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha - Uruguay","http://turismorocha.gub.uy/");
			interfazUsuario.altaProveedor("eldiez","Pablo","Bengoechea","eldiez@socfomturriv.org.uy",LocalDate.of(1965,6,27),"Pablo es el presidente de la Sociedad de Fomento Turístico de Rivera (conocida como Socfomturriv)","http://wwww.socfomturriv.org.uy");
			interfazUsuario.altaProveedor("meche","Mercedes","Venn","meche@colonia.gub.uy", LocalDate.of(1990,12,31),"Departamento de Turismo del Departamento de Colonia","https://colonia.gub.uy/turismo/");
			
			//Caso Actividades Turisticas
			
			try {
				interfazTuristica.crearActividadTuristica("Degusta","Festival gastronómico de productos locales en Rocha",3,800,LocalDate.of(2022, 7, 20),"Rocha","Rocha","washington");
			interfazTuristica.crearActividadTuristica("Teatro con Sabores","En el mes aniversario del Club Deportivo Unión de Rocha te invitamos a una merienda deliciosa.",3,500,LocalDate.of(2022,7,21),"Rocha","Rocha","washington");
			interfazTuristica.crearActividadTuristica("Tour por Colonia del Sacramento","Con guía especializado y en varios idiomas. Varios circuitos posibles.",2,400,LocalDate.of(2022, 8, 1),"Colonia del Sacramento","Colonia","meche");
			interfazTuristica.crearActividadTuristica("Almuerzo en el Real de San Carlos", "Restaurante en la renovada Plaza de Toros con menú internacional",2,800,LocalDate.of(2022, 8, 1),"Colonia del Sacramento","Colonia","meche");
			interfazTuristica.crearActividadTuristica("Almuerzo en Valle del Lunarejo", "Almuerzo en la Posada con ticket fijo. Menú que incluye bebida y postre casero.",2,300,LocalDate.of(2022,8,1),"Tranqueras","Rivera","eldiez");
			interfazTuristica.crearActividadTuristica("Cabalgata en Valle del Lunarejo", "Cabalgata por el área protegida. Varios recorridos para elegir.",2,150,LocalDate.of(2022,8,1),"Tranqueras","Rivera","eldiez");
			} catch (NombreActividadRepetidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Caso Salidas Turisticas crearSalidaTuristica(String nombre, int cantMaxTuristas, LocalDate fechaAlta,
			//											DTInfoSalida infoSalida, int cuposDisponibles, String actividad)
			try {
				interfazTuristica.crearSalidaTuristica("Degusta Agosto", 20, LocalDate.of(2022,7,21), new DTInfoSalida(LocalDate.of(2022,8,20), LocalTime.of(17,0), "Sociedad Agropecuaria de Rocha"), "Degusta");
				interfazTuristica.crearSalidaTuristica("Degusta Setiembre", 20, LocalDate.of(2022,7,22), new DTInfoSalida(LocalDate.of(2022,9,3), LocalTime.of(17,0), "Sociedad Agropecuaria de Rocha"), "Degusta");
				interfazTuristica.crearSalidaTuristica("Teatro con Sabores 1", 30, LocalDate.of(2022,7,23), new DTInfoSalida(LocalDate.of(2022,9,4), LocalTime.of(18,0), "Club Deportivo Unión"), "Teatro con Sabores");
				interfazTuristica.crearSalidaTuristica("Teatro con Sabores 2", 30, LocalDate.of(2022,7,23), new DTInfoSalida(LocalDate.of(2022,9,11), LocalTime.of(18,0), "Club Deportivo Unión"), "Teatro con Sabores");
				interfazTuristica.crearSalidaTuristica("Tour Colonia del Sacramento 11-09", 5, LocalDate.of(2022,8,5), new DTInfoSalida(LocalDate.of(2022,9,11), LocalTime.of(10,0), "Encuentro en la base del Faro"), "Tour por Colonia del Sacramento");
				interfazTuristica.crearSalidaTuristica("Tour Colonia del Sacramento 18-09", 5, LocalDate.of(2022,8,5), new DTInfoSalida(LocalDate.of(2022,8,20), LocalTime.of(17,0), "Sociedad Agropecuaria de Rocha"), "Tour por Colonia del Sacramento");
			
			} catch (NombreSalidaRepetidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoHayActividadConEseNombreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			return true;
		}
	}
}
