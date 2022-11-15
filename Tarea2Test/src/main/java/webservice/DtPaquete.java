
package webservice;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtPaquete complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtPaquete">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="PeriodoValidez" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="Descuento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="FechaAlta" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         <element name="ActividadesTuristicas" type="{http://WebService/}dtActividadTuristica" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtPaquete", propOrder = {
    "nombre",
    "descripcion",
    "periodoValidez",
    "descuento",
    "fechaAlta",
    "actividadesTuristicas"
})
public class DtPaquete {

    @XmlElement(name = "Nombre")
    protected String nombre;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "PeriodoValidez")
    protected int periodoValidez;
    @XmlElement(name = "Descuento")
    protected int descuento;
    @XmlElement(name = "FechaAlta")
    protected Object fechaAlta;
    @XmlElement(name = "ActividadesTuristicas", nillable = true)
    protected List<DtActividadTuristica> actividadesTuristicas;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad periodoValidez.
     * 
     */
    public int getPeriodoValidez() {
        return periodoValidez;
    }

    /**
     * Define el valor de la propiedad periodoValidez.
     * 
     */
    public void setPeriodoValidez(int value) {
        this.periodoValidez = value;
    }

    /**
     * Obtiene el valor de la propiedad descuento.
     * 
     */
    public int getDescuento() {
        return descuento;
    }

    /**
     * Define el valor de la propiedad descuento.
     * 
     */
    public void setDescuento(int value) {
        this.descuento = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAlta.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Define el valor de la propiedad fechaAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setFechaAlta(Object value) {
        this.fechaAlta = value;
    }

    /**
     * Gets the value of the actividadesTuristicas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the actividadesTuristicas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividadesTuristicas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtActividadTuristica }
     * 
     * 
     * @return
     *     The value of the actividadesTuristicas property.
     */
    public List<DtActividadTuristica> getActividadesTuristicas() {
        if (actividadesTuristicas == null) {
            actividadesTuristicas = new ArrayList<>();
        }
        return this.actividadesTuristicas;
    }

}
