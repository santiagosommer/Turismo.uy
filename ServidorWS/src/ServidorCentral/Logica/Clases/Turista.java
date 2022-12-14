package ServidorCentral.Logica.Clases;

import java.time.LocalDate;
import java.util.ArrayList;



public class Turista extends Usuario{
	
	 private String Nacionalidad ;
	 private ArrayList<Inscripcion> Inscripciones;  
	 private ArrayList<ActividadTuristica> ActividadesFavoritas;
	 
	public Turista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento,String contrasenia, String nacionalidad) {
		super(nickname, nombre, apellido, email, fechaNacimiento, contrasenia);
		setNacionalidad(nacionalidad);
		setInscripciones(new ArrayList<Inscripcion>());
		setActividadesFavoritas(new ArrayList<ActividadTuristica>() );
		
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public ArrayList<Inscripcion> getInscripciones() {
		return Inscripciones;
	}

	public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
		Inscripciones = inscripciones;
	}
 
	public void agregarInscripcion(Inscripcion i) {
		Inscripciones.add(i);
	}
	public ArrayList<ActividadTuristica> getActividadesFavoritas() {
		return ActividadesFavoritas;
	}

	public void setActividadesFavoritas(ArrayList<ActividadTuristica> actividadesFavoritas) {
		ActividadesFavoritas = actividadesFavoritas;
	}
	
	
	
}
