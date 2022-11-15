
package webservice;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtInscripcion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtInscripcion">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Fecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         <element name="CantidadTuristas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="Costo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         <element name="Autor" type="{http://WebService/}dtTurista" minOccurs="0"/>
 *         <element name="SalidaAsociada" type="{http://WebService/}dtSalidaTuristica" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtInscripcion", propOrder = {
    "fecha",
    "cantidadTuristas",
    "costo",
    "autor",
    "salidaAsociada"
})
public class DtInscripcion {

    @XmlElement(name = "Fecha")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecha;
    @XmlElement(name = "CantidadTuristas")
    protected int cantidadTuristas;
    @XmlElement(name = "Costo")
    protected float costo;
    @XmlElement(name = "Autor")
    protected DtTurista autor;
    @XmlElement(name = "SalidaAsociada")
    protected DtSalidaTuristica salidaAsociada;

    /**
     * Obtiene el valor de la propiedad fecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * Define el valor de la propiedad fecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecha(XMLGregorianCalendar value) {
        this.fecha = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidadTuristas.
     * 
     */
    public int getCantidadTuristas() {
        return cantidadTuristas;
    }

    /**
     * Define el valor de la propiedad cantidadTuristas.
     * 
     */
    public void setCantidadTuristas(int value) {
        this.cantidadTuristas = value;
    }

    /**
     * Obtiene el valor de la propiedad costo.
     * 
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Define el valor de la propiedad costo.
     * 
     */
    public void setCosto(float value) {
        this.costo = value;
    }

    /**
     * Obtiene el valor de la propiedad autor.
     * 
     * @return
     *     possible object is
     *     {@link DtTurista }
     *     
     */
    public DtTurista getAutor() {
        return autor;
    }

    /**
     * Define el valor de la propiedad autor.
     * 
     * @param value
     *     allowed object is
     *     {@link DtTurista }
     *     
     */
    public void setAutor(DtTurista value) {
        this.autor = value;
    }

    /**
     * Obtiene el valor de la propiedad salidaAsociada.
     * 
     * @return
     *     possible object is
     *     {@link DtSalidaTuristica }
     *     
     */
    public DtSalidaTuristica getSalidaAsociada() {
        return salidaAsociada;
    }

    /**
     * Define el valor de la propiedad salidaAsociada.
     * 
     * @param value
     *     allowed object is
     *     {@link DtSalidaTuristica }
     *     
     */
    public void setSalidaAsociada(DtSalidaTuristica value) {
        this.salidaAsociada = value;
    }

}
