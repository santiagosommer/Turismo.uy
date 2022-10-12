package ServidorCentral.Logica.DataTypes;

public enum EstadoError {
	ERROR_NICK_OR_EMAIL,    // usuario con ese nickname o email no existe
    ERROR_CONTRA,   // contraseña incorrecta
    EXITO_TURISTA, // exito se logueo un turista
    EXITO_PROVEEDOR // exito se logueo un proveedor
}
