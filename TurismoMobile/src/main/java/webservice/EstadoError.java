
package webservice;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoError.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>{@code
 * <simpleType name="estadoError">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="ERROR_NICK_OR_EMAIL"/>
 *     <enumeration value="ERROR_EMAIL"/>
 *     <enumeration value="ERROR_CONTRA"/>
 *     <enumeration value="EXITO_TURISTA"/>
 *     <enumeration value="EXITO_PROVEEDOR"/>
 *     <enumeration value="ERROR_ACTIVIDAD"/>
 *     <enumeration value="ERROR_SALIDA"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "estadoError")
@XmlEnum
public enum EstadoError {

    ERROR_NICK_OR_EMAIL,
    ERROR_EMAIL,
    ERROR_CONTRA,
    EXITO_TURISTA,
    EXITO_PROVEEDOR,
    ERROR_ACTIVIDAD,
    ERROR_SALIDA;

    public String value() {
        return name();
    }

    public static EstadoError fromValue(String v) {
        return valueOf(v);
    }

}
