package ServidorCentral.Logica.DataTypes;

public enum EstadoError {
	ERROR_NICK,    // usuario con ese nickname no existe
    ERROR_EMAIL,   // usuario con ese email no existe
    ERROR_CONTRA   // contraseña incorrecta
}
