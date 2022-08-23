package datatypes;

import java.time.LocalDate;
import java.util.ArrayList;

public class DTTurista extends DTUsuario {
	private String Nacionalidad ;
	private ArrayList<DTInscripcion> Inscripciones;
	
   public DTTurista(String nickname, String nombre, String apellido, String email,LocalDate fechaNacimiento, String nacionalidad, ArrayList<DTInscripcion> inscripciones) {
	   super(nickname,nombre,apellido,email,fechaNacimiento);
	   Nacionalidad = nacionalidad;
	   Inscripciones = inscripciones;
       
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
