package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.ArrayList;

//import java.util.Calendar;

public abstract class DTUsuario {

	private String Nickname;
	private String Nombre;
	private String Apellido;
	private String Email;
	private LocalDate FechaNacimiento;
	private String contra;
	private ArrayList<DTUsuario> Seguidores;
	
	public DTUsuario(String nickname,String nombre,String apellido,String email,LocalDate fechaNacimiento,String contra, ArrayList<DTUsuario> seg) {
		setNickname(nickname);
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
		setFechaNacimiento(fechaNacimiento);
		setContra(contra);
		setSeguidores(seg);
		
	}
	public String getNickname() {
		return Nickname;
	}
	public void setNickname(String nickname) {
		Nickname = nickname;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public LocalDate getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	public ArrayList<DTUsuario> getSeguidores() {
		return Seguidores;
	}
	public void setSeguidores(ArrayList<DTUsuario> seg) {
		this.Seguidores = seg;
	}
}
