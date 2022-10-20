package ServidorCentral.Logica.Interfaces;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.Excepciones.CategoriaRepetidaException;
import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Excepciones.NombrePaqueteRepetidoException;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Excepciones.YaExisteInscripcionTuristaSalida;
import ServidorCentral.Logica.Fabrica.Fabrica;

public class CargaDeDatos {
	
	Boolean yaCargo = false;
	
	IUsuario interfazUsuario;
	ITuristica interfazTuristica;
	IPaquete interfazPaquetes;
	
	private static CargaDeDatos instancia = null;
	
	public static CargaDeDatos getInstancia() {
		if (instancia == null) {
			instancia = new CargaDeDatos();
		}
		return instancia;
	}
	
	private CargaDeDatos() {
		Fabrica fabrica = Fabrica.getInstance();
		this.interfazUsuario = fabrica.getControladorUsuario();
		this.interfazTuristica =fabrica.getControladorTuristica();
		this.interfazPaquetes = fabrica.getControladorPaquete();
				
	}
	
	public Boolean cargarDatos() throws UsuarioRepetidoException {
		if (yaCargo)
			return false;
		else {
			yaCargo = true;
			
			interfazTuristica.crearDepartamento("Canelones", "División Turismo de la Intendencia" , "https://www.imcanelones.gub.uy/es");
			interfazTuristica.crearDepartamento("Maldonado", "División Turismo de la Intendencia" , "https://www.maldonado.gub.uy/");
			interfazTuristica.crearDepartamento("Rocha", "La Organización de Gestión del Destino (OGD) Rocha es un ámbito de articulación público – privada en el sector turístico que integran la Corporación Rochense de Turismo y la Intendencia de Rocha a través de su Dirección de Turismo." , "www.turismorocha.gub.uy");
			interfazTuristica.crearDepartamento("Treinta y Tres", "División Turismo de la Intendencia" ,"https://treintaytres.gub.uy/");
			interfazTuristica.crearDepartamento("Cerro Largo", "División Turismo de la Intendencia" , "https://www.gub.uy/intendencia-cerro-largo/");
			interfazTuristica.crearDepartamento("Rivera", "Promociona e implementa proyectos e iniciativas sostenibles de interés turístico con la participación institucional pública – privada en bien del desarrollo socioeconómico de la comunidad."  , "www.rivera.gub.uy/social/turismo/");
			interfazTuristica.crearDepartamento("Artigas", "División Turismo de la Intendencia" , "http://www.artigas.gub.uy");
			interfazTuristica.crearDepartamento("Salto", "División Turismo de la Intendencia" , "https://www.salto.gub.uy");
			interfazTuristica.crearDepartamento("Paysandú", "División Turismo de la Intendencia" , "https://www.paysandu.gub.uy");
			interfazTuristica.crearDepartamento("Río Negro", "División Turismo de la Intendencia" ,"https://www.rionegro.gub.uy");
			interfazTuristica.crearDepartamento("Soriano", "División Turismo de la Intendencia" , "https://www.soriano.gub.uy");
			interfazTuristica.crearDepartamento("Colonia", "La propuesta del Departamento de Colonia divide en cuatro actos su espectáculo anual. Cada acto tiene su magia. Desde su naturaleza y playas hasta sus tradiciones y el patrimonio mundial. Todo el año se disfruta." , "https://colonia.gub.uy/turismo/");
			interfazTuristica.crearDepartamento("San José", "División Turismo de la Intendencia" , "https://sanjose.gub.uy");
			interfazTuristica.crearDepartamento("Flores", "División Turismo de la Intendencia" , "https://flores.gub.uy");
			interfazTuristica.crearDepartamento("Florida", "División Turismo de la Intendencia" , "http://www.florida.gub.uy");
			interfazTuristica.crearDepartamento("Lavalleja", "División Turismo de la Intendencia" , "http://www.lavalleja.gub.uy");
			interfazTuristica.crearDepartamento("Durazno", "División Turismo de la Intendencia" , "https://durazno.uy");
			interfazTuristica.crearDepartamento("Tacuarembó", "División Turismo de la Intendencia" , "https://tacuarembo.gub.uy");
			interfazTuristica.crearDepartamento("Montevideo", "División Turismo de la Intendencia" , "https://montevideo.gub.uy/areas-tematicas/turismo");
			
			//Caso Usuarios
			
			interfazUsuario.altaTurista("lachiqui","Rosa María","Martínez", "mirtha.legrand.ok@hotmail.com.ar",	LocalDate.of(1927, 2, 23), "awdrg543", "argentina");
			interfazUsuario.altaTurista("isabelita","Elizabeth","Windsor", "isabelita@thecrown.co.uk",LocalDate.of(1926,04,21), "r5t6y7u8", "inglesa");
			interfazUsuario.altaTurista("anibal","Aníbal","Lecter","anibal@fing.edu.uy",LocalDate.of(1937,12,31), "edrft543", "lituana");
			interfazUsuario.altaTurista("waston","Emma", "Waston","e.waston@gmail.com", LocalDate.of(1990,4,15),"poiuy987", "inglesa" );
			interfazUsuario.altaTurista("elelvis","Elvis","Lacio","suavemente@hotmail.com", LocalDate.of(1971,7,30),"45idgaf67", "estadounidense");
			interfazUsuario.altaTurista("eleven11","Eleven","Once", "eleven11@gmail.com",LocalDate.of(2004,2,19),"xdrgb657", "española");
			interfazUsuario.altaTurista("bobesponja","Bob","Esponja","bobesponja@nickelodeon.com",LocalDate.of(1999,5,1),"sbsplol1", "japonesa");
			interfazUsuario.altaTurista("tony","Antonio","Pacheco","eltony@manya.org.uy", LocalDate.of(1976,4,11), "okmnji98", "uruguaya");
			interfazUsuario.altaTurista("chino","Álvaro","Recoba","chino@trico.org.uy", LocalDate.of(1976,3,17), "qsxcdw43", "uruguaya");
			interfazUsuario.altaTurista("mastropiero","Johann","Sebastian Mastropiero","johann.sebastian@gmail.com",LocalDate.of(1922,02,07), "qpwoei586", "austríaca");
			interfazUsuario.altaProveedor("washington","Washington","Rocha","washington@turismorocha.gub.uy",LocalDate.of(1970,9,14),"asdfg654","Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha - Uruguay","http://turismorocha.gub.uy/");
			interfazUsuario.altaProveedor("eldiez","Pablo","Bengoechea","eldiez@socfomturriv.org.uy",LocalDate.of(1965,6,27), "ytrewq10","Pablo es el presidente de la Sociedad de Fomento Turístico de Rivera (conocida como Socfomturriv)","http://wwww.socfomturriv.org.uy");
			interfazUsuario.altaProveedor("meche","Mercedes","Venn","meche@colonia.gub.uy", LocalDate.of(1990,12,31),"mnjkiu89","Departamento de Turismo del Departamento de Colonia","https://colonia.gub.uy/turismo/");
			
			//Caso Categorias
			
			try {
				interfazTuristica.crearCategoria("Aventura y Deporte");
				interfazTuristica.crearCategoria("Campo y Naturaleza");
				interfazTuristica.crearCategoria("Cultura y Patrimonio");
				interfazTuristica.crearCategoria("Gastronomia");
				interfazTuristica.crearCategoria("Turismo Playas");
			} catch (CategoriaRepetidaException e1) {
				e1.printStackTrace();
			}
			
			//Caso Actividades Turisticas
			
			String C1 ="Aventura y Deporte";
			String C2 ="Campo y Naturaleza";
			String C3 ="Cultura y Patrimonio";
			String C4 ="Gastronomia";
			String C5 ="Turismo Playas";

			Set<String> A1 = new HashSet<String>();
			A1.add(C4);
			Set<String> A2 = new HashSet<String>();
			A2.add(C3);
			A2.add(C4);
			Set<String> A3 = new HashSet<String>();
			A3.add(C5);
			Set<String> A4 = new HashSet<String>();
			A4.add(C4);
			Set<String> A5 = new HashSet<String>();
			A5.add(C2);
			A5.add(C4);
			Set<String> A6 = new HashSet<String>();
			A6.add(C2);
			Set<String> A7 = new HashSet<String>();
			A7.add(C3);
			Set<String> A8 = new HashSet<String>();
			A8.add(C3);
			Set<String> A9 = new HashSet<String>();
			A9.add(C1);
			A9.add(C5);
			Set<String> A10 = new HashSet<String>();
			A10.add(C3);
			
			
			try {
				
			interfazTuristica.crearActividadTuristica("Degusta","Festival gastronómico de productos locales en Rocha",3,800,LocalDate.of(2022, 7, 20),"Rocha","Rocha","washington",A1);
			interfazTuristica.AceptarActividad("Degusta");
			interfazTuristica.crearActividadTuristica("Teatro con Sabores","En el mes aniversario del Club Deportivo Unión de Rocha te invitamos a una merienda deliciosa.",3,500,LocalDate.of(2022,7,21),"Rocha","Rocha","washington",A2);
			interfazTuristica.AceptarActividad("Teatro con Sabores");
			interfazTuristica.crearActividadTuristica("Tour por Colonia del Sacramento","Con guía especializado y en varios idiomas. Varios circuitos posibles.",2,400,LocalDate.of(2022, 8, 1),"Colonia del Sacramento","Colonia","meche",A3);
			interfazTuristica.AceptarActividad("Tour por Colonia del Sacramento");
			interfazTuristica.crearActividadTuristica("Almuerzo en el Real de San Carlos", "Restaurante en la renovada Plaza de Toros con menú internacional",2,800,LocalDate.of(2022, 8, 1),"Colonia del Sacramento","Colonia","meche",A4);
			interfazTuristica.AceptarActividad("Almuerzo en el Real de San Carlos");
			interfazTuristica.crearActividadTuristica("Almuerzo en Valle del Lunarejo", "Almuerzo en la Posada con ticket fijo. Menú que incluye bebida y postre casero.",2,300,LocalDate.of(2022,8,1),"Tranqueras","Rivera","eldiez",A5);
			interfazTuristica.AceptarActividad("Almuerzo en Valle del Lunarejo");
			interfazTuristica.crearActividadTuristica("Cabalgata en Valle del Lunarejo", "Cabalgata por el área protegida. Varios recorridos para elegir.",2,150,LocalDate.of(2022,8,1),"Tranqueras","Rivera","eldiez",A6);
			interfazTuristica.AceptarActividad("Cabalgata en Valle del Lunarejo");
			interfazTuristica.crearActividadTuristica("Bus turístico Colonia","Recorrida por los principales atractivos de la ciudad",3,600,LocalDate.of(2022, 9, 1),"Colonia del Sacramento","Colonia","meche",A7);
			//interfazTuristica.AceptarActividad(C5);
			interfazTuristica.crearActividadTuristica("Colonia Premium Tour","Visita lugares exclusivos y relevantes",4,2600,LocalDate.of(2022, 9, 3),"Colonia del Sacramento","Colonia","meche",A8);
			interfazTuristica.RechazarActividad("Colonia Premium Tour");
			interfazTuristica.crearActividadTuristica("Deportesnáuticos sin uso de motor","kitsurf - windsurf - kayakismo - canotaje en Rocha",3,1200,LocalDate.of(2022, 9, 5),"Rocha","Rocha","washington",A9);
			//interfazTuristica.AceptarActividad(C5);
			interfazTuristica.crearActividadTuristica("Descubre Rivera","Rivera es un departamento de extraordinaria riqueza natural patrimonial y cultural con una ubicación geográfica privilegiada",2,650,LocalDate.of(2022, 9, 16),"Rivera","Rivera","eldiez",A10);
			interfazTuristica.RechazarActividad("Descubre Rivera");
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
				interfazTuristica.crearSalidaTuristica("Tour Colonia del Sacramento 18-09", 5, LocalDate.of(2022,8,5), new DTInfoSalida(LocalDate.of(2022,9,18), LocalTime.of(10,0), "Encuentro en la base del Faro"), "Tour por Colonia del Sacramento");
				interfazTuristica.crearSalidaTuristica("Almuerzo 1", 5, LocalDate.of(2022,8,4), new DTInfoSalida(LocalDate.of(2022,9,18), LocalTime.of(12,0), "Restaurante de la Plaza de Toros"), "Almuerzo en el Real de San Carlos");
				interfazTuristica.crearSalidaTuristica("Almuerzo 2", 5, LocalDate.of(2022,8,4), new DTInfoSalida(LocalDate.of(2022,9,25), LocalTime.of(12,0), "Restaurante de la Plaza de Toros"), "Almuerzo en el Real de San Carlos");
				interfazTuristica.crearSalidaTuristica("Almuerzo 3", 4, LocalDate.of(2022,8,15), new DTInfoSalida(LocalDate.of(2022,9,10), LocalTime.of(12,0), "Posada Del Lunarejo"), "Almuerzo en Valle del Lunarejo");
				interfazTuristica.crearSalidaTuristica("Almuerzo 4", 4, LocalDate.of(2022,8,15), new DTInfoSalida(LocalDate.of(2022,9,11), LocalTime.of(12,0), "Posada Del Lunarejo"), "Almuerzo en Valle del Lunarejo");
				interfazTuristica.crearSalidaTuristica("Cabalgata 1", 4, LocalDate.of(2022,8,15), new DTInfoSalida(LocalDate.of(2022,9,10), LocalTime.of(16,0), "Posada Del Lunarejo"), "Cabalgata en Valle del Lunarejo");
				interfazTuristica.crearSalidaTuristica("Cabalgata 2", 4, LocalDate.of(2022,8,15), new DTInfoSalida(LocalDate.of(2022,9,11), LocalTime.of(16,0), "Posada Del Lunarejo"), "Cabalgata en Valle del Lunarejo");
				interfazTuristica.crearSalidaTuristica("Degusta Octubre", 20, LocalDate.of(2022,9,22), new DTInfoSalida(LocalDate.of(2022,10,30), LocalTime.of(17,0), "Sociedad Agropecuaria de Rocha"), "Degusta");
				interfazTuristica.crearSalidaTuristica("Degusta Noviembre", 20, LocalDate.of(2022,10,2), new DTInfoSalida(LocalDate.of(2022,11,5), LocalTime.of(17,0), "Sociedad Agropecuaria de Rocha"), "Degusta");
				interfazTuristica.crearSalidaTuristica("Teatro con Sabores 3", 30, LocalDate.of(2022,8,25), new DTInfoSalida(LocalDate.of(2022,11,11), LocalTime.of(18,0), "Club Deportivo Unión"), "Teatro con Sabores");
				interfazTuristica.crearSalidaTuristica("Tour Colonia del Sacramento 30-10", 10, LocalDate.of(2022,9,7), new DTInfoSalida(LocalDate.of(2022,10,30), LocalTime.of(10,0), "Encuentro en la base del Faro"), "Tour por Colonia del Sacramento");
				interfazTuristica.crearSalidaTuristica("Cabalgata Extrema", 4, LocalDate.of(2022,9,15), new DTInfoSalida(LocalDate.of(2022,10,30), LocalTime.of(16,0), "Posada Del Lunarejo"), "Cabalgata en Valle del Lunarejo");
				interfazTuristica.crearSalidaTuristica("Almuerzo en el Real 1", 10, LocalDate.of(2022,10,10), new DTInfoSalida(LocalDate.of(2022,10,30), LocalTime.of(12,0), "Restaurante de la Plaza de Toros"), "Almuerzo en el Real de San Carlos");
			
			} catch (NombreSalidaRepetidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoHayActividadConEseNombreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Caso Inscripciones
			
			//(String nombreTurista,String nombreSalida, int cantidadTuristas,Float costo, LocalDate fechaAlta)
			try {

				interfazUsuario.crearInscripcion("lachiqui", "Degusta Agosto" , 3 , (float) 2400 , LocalDate.of(2022, 8, 15));
				interfazUsuario.crearInscripcion("elelvis", "Degusta Agosto" , 5 , (float) 4000 , LocalDate.of(2022, 8, 16));
				interfazUsuario.crearInscripcion("lachiqui", "Tour Colonia del Sacramento 18-09", 3 , (float) 1200,  LocalDate.of(2022, 8, 18));
				interfazUsuario.crearInscripcion("isabelita", "Tour Colonia del Sacramento 18-09", 1, (float) 400, LocalDate.of(2022, 8, 19));
				interfazUsuario.crearInscripcion("mastropiero", "Almuerzo 2", 2, (float) 1600 , LocalDate.of(2022, 8, 19));
				interfazUsuario.crearInscripcion("chino","Teatro con Sabores 1", 1, (float) 500 , LocalDate.of(2022, 8, 19));
				interfazUsuario.crearInscripcion("chino", "Teatro con Sabores 2", 10, (float) 5000 , LocalDate.of(2022, 8, 20));
				interfazUsuario.crearInscripcion("bobesponja","Teatro con Sabores 2", 2, (float) 1000 , LocalDate.of(2022, 8, 20));
				interfazUsuario.crearInscripcion("anibal","Teatro con Sabores 2", 1, (float) 500 , LocalDate.of(2022, 8, 21));
				interfazUsuario.crearInscripcion("tony", "Degusta Setiembre" , 11, (float) 8800 , LocalDate.of(2022, 8, 21));
				
				//inscripcion paquete
				/*11*/interfazUsuario.crearInscripcion("lachiqui", "Degusta Noviembre" , 2, (float) 1280 , LocalDate.of(2022, 10, 3));
				/*12*/interfazUsuario.crearInscripcion("lachiqui", "Teatro con Sabores 3" , 2, (float) 800 , LocalDate.of(2022, 10, 3));
				/*13*/interfazUsuario.crearInscripcion("elelvis", "Degusta Setiembre" , 5, (float) 3200 , LocalDate.of(2022, 9, 2));
				/*14*/interfazUsuario.crearInscripcion("elelvis", "Teatro con Sabores 1" , 5, (float) 2000 , LocalDate.of(2022, 9, 2));
				/*15*/interfazUsuario.crearInscripcion("lachiqui", "Tour Colonia del Sacramento 11-09" , 5, (float) 1700 , LocalDate.of(2022, 9, 3));
				/*16*/interfazUsuario.crearInscripcion("lachiqui", "Almuerzo 1" , 5, (float) 3400 , LocalDate.of(2022, 9, 3));
				/*17*/interfazUsuario.crearInscripcion("waston", "Tour Colonia del Sacramento 18-09" , 1, (float) 340 , LocalDate.of(2022, 9, 5));
				/*18*/interfazUsuario.crearInscripcion("waston", "Almuerzo 2" , 1, (float) 680 , LocalDate.of(2022, 9, 5));
				/*19*/interfazUsuario.crearInscripcion("elelvis", "Tour Colonia del Sacramento 30-10" , 2, (float) 680 , LocalDate.of(2022, 10, 2));
				/*20*/interfazUsuario.crearInscripcion("elelvis", "Almuerzo en el Real 1" , 2, (float) 1360 , LocalDate.of(2022, 10, 2));
				/*21*/interfazUsuario.crearInscripcion("mastropiero", "Tour Colonia del Sacramento 30-10" , 1360, (float) 0 , LocalDate.of(2022, 10, 12));
				/*22*/interfazUsuario.crearInscripcion("mastropiero", "Almuerzo en el Real 1" , 4, (float) 2720, LocalDate.of(2022, 10, 12));
				
			} catch (YaExisteInscripcionTuristaSalida e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Caso Paquetes
			try {
				interfazPaquetes.crearPaquete("Disfrutar Rocha", "Actividades para hacer en familia y disfrutar arte y gastronomia", 60, 20, LocalDate.of(2022, 8, 10));
				interfazPaquetes.crearPaquete("Un dia en Colonia", "Paseos por el casco historico y se puede terminar con Almuerzo en la Plaza de Toros", 45, 15, LocalDate.of(2022, 8, 1));
				interfazPaquetes.crearPaquete("Valle Del Lunarejo", "Visite un área protegida con un paisaje natural hermoso", 60, 15, LocalDate.of(2022, 9, 15));
				
				interfazPaquetes.AgregarActividadPaquete("Disfrutar Rocha", "Degusta");
				interfazPaquetes.AgregarActividadPaquete("Disfrutar Rocha", "Teatro con Sabores");
				interfazPaquetes.AgregarActividadPaquete("Un dia en Colonia", "Tour por Colonia del Sacramento");
				interfazPaquetes.AgregarActividadPaquete("Un dia en Colonia", "Almuerzo en el Real de San Carlos");
				interfazPaquetes.AgregarActividadPaquete("Valle Del Lunarejo","Almuerzo en Valle del Lunarejo");
				interfazPaquetes.AgregarActividadPaquete("Valle Del Lunarejo","Cabalgata en Valle del Lunarejo");
			} catch (NombrePaqueteRepetidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
	}
}