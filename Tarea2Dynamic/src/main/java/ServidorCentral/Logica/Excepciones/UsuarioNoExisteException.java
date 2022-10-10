package ServidorCentral.Logica.Excepciones;

@SuppressWarnings("serial")
public class UsuarioNoExisteException extends Exception {

    public UsuarioNoExisteException(String string) {
        super(string);
    }
}
