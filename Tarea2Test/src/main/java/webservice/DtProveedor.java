
package webservice;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtProveedor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtProveedor">
 *   <complexContent>
 *     <extension base="{http://WebService/}dtUsuario">
 *       <sequence>
 *         <element name="DescripcionGeneral" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="URL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="InfoActividades" type="{http://WebService/}dtActividadTuristica" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtProveedor", propOrder = {
    "descripcionGeneral",
    "url",
    "infoActividades"
})
public class DtProveedor
    extends DtUsuario
{

    @XmlElement(name = "DescripcionGeneral")
    protected String descripcionGeneral;
    @XmlElement(name = "URL")
    protected String url;
    @XmlElement(name = "InfoActividades", nillable = true)
    protected List<DtActividadTuristica> infoActividades;

    /**
     * Obtiene el valor de la propiedad descripcionGeneral.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    /**
     * Define el valor de la propiedad descripcionGeneral.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionGeneral(String value) {
        this.descripcionGeneral = value;
    }

    /**
     * Obtiene el valor de la propiedad url.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Define el valor de la propiedad url.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the infoActividades property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the infoActividades property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoActividades().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtActividadTuristica }
     * 
     * 
     * @return
     *     The value of the infoActividades property.
     */
    public List<DtActividadTuristica> getInfoActividades() {
        if (infoActividades == null) {
            infoActividades = new ArrayList<>();
        }
        return this.infoActividades;
    }

}
