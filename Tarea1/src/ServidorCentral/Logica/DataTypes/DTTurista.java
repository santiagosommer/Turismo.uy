package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;

public class DTTurista extends DTUsuario {
	private String Nacionalidad ;
	private ArrayList<DTInscripcion> Inscripciones;
	
   public DTTurista(String nickname, String nombre, String apellido, String email,LocalDate fechaNacimiento, String nacionalidad) {
	   super(nickname,nombre,apellido,email,fechaNacimiento);
	   Nacionalidad = nacionalidad;
	   Inscripciones = new ArrayList<DTInscripcion>();
       
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
