package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;

//import java.util.Calendar;

public abstract class DTUsuario {

	private String Nickname;
	private String Nombre;
	private String Apellido;
	private String Email;
	private LocalDate FechaNacimiento;
	
	public DTUsuario(String nickname,String nombre,String apellido,String email,LocalDate fechaNacimiento) {
		setNickname(nickname);
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
		setFechaNacimiento(fechaNacimiento);
		
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
}
