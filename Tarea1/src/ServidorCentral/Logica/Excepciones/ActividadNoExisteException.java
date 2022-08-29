package ServidorCentral.Logica.Excepciones;

@SuppressWarnings("serial")
public class ActividadNoExisteException extends Exception {

    public ActividadNoExisteException(String string) {
        super(string);
    }
}
