package ServidorCentral.Logica.DataTypes;

public enum EstadoError {
	ERROR_NICK_OR_EMAIL,    // usuario con ese nickname o email no existe
	ERROR_EMAIL,
    ERROR_CONTRA,   // contraseña incorrecta
    EXITO_TURISTA, // exito se logueo un turista
    EXITO_PROVEEDOR, // exito se logueo un proveedor
    ERROR_ACTIVIDAD, // actividad con ese nombre ya existe
    ERROR_SALIDA  // salida con ese nombre ya existe
}
