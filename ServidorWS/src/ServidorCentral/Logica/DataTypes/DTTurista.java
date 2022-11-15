package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import ServidorCentral.Logica.Clases.Inscripcion;
import ServidorCentral.Logica.Clases.Turista;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class DTTurista extends DTUsuario {
	private String Nacionalidad ;
	private ArrayList<DTInscripcion> Inscripciones;
	
   public DTTurista(String nickname, String nombre, String apellido, String email,LocalDate fechaNacimiento,String contra, String nacionalidad) {
	   super(nickname,nombre,apellido,email,fechaNacimiento,contra);
	   Nacionalidad = nacionalidad;
	   Inscripciones = new ArrayList<DTInscripcion>();
       
   }
   
   public DTTurista(Turista turi) {
	   super(turi.getNickname(),turi.getNombre(),turi.getApellido(),turi.getEmail(),turi.getFechaNacimiento(),turi.getContraseña());
	   setNacionalidad(turi.getNacionalidad());
	   
	   Inscripciones = new ArrayList<DTInscripcion>();
	   ArrayList<Inscripcion> arrIns = turi.getInscripciones();
	   
	   Iterator<Inscripcion> iter = arrIns.iterator();
	   
	   while(iter.hasNext()) {
		   DTInscripcion auxIns = new DTInscripcion(iter.next());
		   Inscripciones.add(auxIns);
	   }
   
   }

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public ArrayList<DTInscripcion> getInscripciones() {
		return Inscripciones;
	}

	public void setInscripciones(ArrayList<DTInscripcion> inscripciones) {
		Inscripciones = inscripciones;
	}
	
	
}
