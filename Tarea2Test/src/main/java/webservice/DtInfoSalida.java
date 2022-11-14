
package webservice;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtInfoSalida complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtInfoSalida">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="fecha" type="{http://WebService/}localDate" minOccurs="0"/>
 *         <element name="hora" type="{http://WebService/}localTime" minOccurs="0"/>
 *         <element name="lugar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtInfoSalida", propOrder = {
    "fecha",
    "hora",
    "lugar"
})
public class DtInfoSalida {

    protected LocalDate fecha;
    protected LocalTime hora;
    protected String lugar;

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param fecha2
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFecha(LocalDate fecha2) {
        this.fecha = fecha2;
    }

    /**
     * Obtiene el valor de la propiedad hora.
     * 
     * @return
     *     possible object is
     *     {@link LocalTime }
     *     
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Define el valor de la propiedad hora.
     * 
     * @param hora2
     *     allowed object is
     *     {@link LocalTime }
     *     
     */
    public void setHora(LocalTime hora2) {
        this.hora = hora2;
    }

    /**
     * Obtiene el valor de la propiedad lugar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Define el valor de la propiedad lugar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLugar(String value) {
        this.lugar = value;
    }

}
