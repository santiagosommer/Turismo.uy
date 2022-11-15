
package webservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "NombreActividadRepetidoException", targetNamespace = "http://WebService/")
public class NombreActividadRepetidoException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NombreActividadRepetidoException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NombreActividadRepetidoException_Exception(String message, NombreActividadRepetidoException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public NombreActividadRepetidoException_Exception(String message, NombreActividadRepetidoException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: webservice.NombreActividadRepetidoException
     */
    public NombreActividadRepetidoException getFaultInfo() {
        return faultInfo;
    }

}
