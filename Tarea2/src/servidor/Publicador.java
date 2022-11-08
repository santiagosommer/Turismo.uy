package servidor;
import src.main.java.ServidorCentral.Logica.Controladores.*;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;
/**
 *
 * @author Pablo
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {

    private ControladorTuristica ct = new ControladorTuristica();
    private Endpoint endpoint = null;
    //Constructor
    public Publicador(){}

    //Operaciones las cuales quiero publicar

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9129/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }

    @WebMethod
    public int suma(int i, int j){
        Logica log = new Logica();
        int ret = log.sumar(i,j);
        return ret;
    }

}
