
package webservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "NombreSalidaRepetidoException", targetNamespace = "http://WebService/")
public class NombreSalidaRepetidoException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NombreSalidaRepetidoException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NombreSalidaRepetidoException_Exception(String message, NombreSalidaRepetidoException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public NombreSalidaRepetidoException_Exception(String message, NombreSalidaRepetidoException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: webservice.NombreSalidaRepetidoException
     */
    public NombreSalidaRepetidoException getFaultInfo() {
        return faultInfo;
    }

}
