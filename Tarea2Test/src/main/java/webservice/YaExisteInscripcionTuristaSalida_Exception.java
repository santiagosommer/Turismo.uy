
package webservice;

import jakarta.xml.ws.WebFault;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebFault(name = "YaExisteInscripcionTuristaSalida", targetNamespace = "http://WebService/")
public class YaExisteInscripcionTuristaSalida_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private YaExisteInscripcionTuristaSalida faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public YaExisteInscripcionTuristaSalida_Exception(String message, YaExisteInscripcionTuristaSalida faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param cause
     * @param faultInfo
     * @param message
     */
    public YaExisteInscripcionTuristaSalida_Exception(String message, YaExisteInscripcionTuristaSalida faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: webservice.YaExisteInscripcionTuristaSalida
     */
    public YaExisteInscripcionTuristaSalida getFaultInfo() {
        return faultInfo;
    }

}