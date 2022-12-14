
package webservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "NombrePaqueteRepetidoException", targetNamespace = "http://WebService/")
public class NombrePaqueteRepetidoException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NombrePaqueteRepetidoException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NombrePaqueteRepetidoException_Exception(String message, NombrePaqueteRepetidoException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public NombrePaqueteRepetidoException_Exception(String message, NombrePaqueteRepetidoException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: webservice.NombrePaqueteRepetidoException
     */
    public NombrePaqueteRepetidoException getFaultInfo() {
        return faultInfo;
    }

}
