package ServidorCentral.Logica.Clases;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Usuario {

	private String Nickname;
	private String Nombre;
	private String Apellido;
	private String Email;
	private LocalDate FechaNacimiento;
	private String Contrasenia;
	ArrayList<Usuario> Seguidores;
	


public Usuario(String nickname,String nombre,String apellido,String email,LocalDate fechaNacimiento,String contrasenia) {
	setNickname(nickname);
	setNombre(nombre);
	setApellido(apellido);
	setEmail(email);
	setFechaNacimiento(fechaNacimiento);
	Contrasenia = contrasenia;
	Seguidores = new ArrayList<Usuario>();

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


public String toString() {
    return getNombre() + " " + getApellido() + " - NickName: " + getNickname();
}




public String getContrasenia() {
	return Contrasenia;
}




public void setContrasenia(String contrasenia) {
	Contrasenia = contrasenia;
}


public ArrayList<Usuario> getSeguidores(){
	return Seguidores;
}


public void setSeguidores(ArrayList<Usuario> seguidores ) {
	Seguidores = seguidores;
}
}