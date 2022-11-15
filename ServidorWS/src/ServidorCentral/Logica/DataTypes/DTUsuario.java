package ServidorCentral.Logica.DataTypes;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

//import java.util.Calendar;
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class DTUsuario {

	private String Nickname;
	private String Nombre;
	private String Apellido;
	private String Email;
	private Calendar FechaNacimiento;
	private String contra;
	
	public DTUsuario(String nickname,String nombre,String apellido,String email,LocalDate fechaNacimiento,String contra) {
		setNickname(nickname);
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
		LocalDate in = fechaNacimiento;
		setFechaNacimiento(new GregorianCalendar(in.getYear(),in.getMonthValue(),in.getDayOfMonth()));
		setContra(contra);
		
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
	public Calendar getFechaNacimiento() {
		return FechaNacimiento;
	}
	public void setFechaNacimiento(Calendar fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
}
