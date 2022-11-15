
package webservice;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtSalidaTuristica complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtSalidaTuristica">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="CantidadMaxTuristas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="FechaAlta" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         <element name="InfoSalida" type="{http://WebService/}dtInfoSalida" minOccurs="0"/>
 *         <element name="CuposDisponibles" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="ActividadTuristicaAsoc" type="{http://WebService/}dtActividadTuristica" minOccurs="0"/>
 *         <element name="inscripcionesAsoc" type="{http://WebService/}dtInscripcion" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtSalidaTuristica", propOrder = {
    "nombre",
    "cantidadMaxTuristas",
    "fechaAlta",
    "infoSalida",
    "cuposDisponibles",
    "actividadTuristicaAsoc",
    "inscripcionesAsoc"
})
public class DtSalidaTuristica {

    @XmlElement(name = "Nombre")
    protected String nombre;
    @XmlElement(name = "CantidadMaxTuristas")
    protected int cantidadMaxTuristas;
    @XmlElement(name = "FechaAlta")
    protected Object fechaAlta;
    @XmlElement(name = "InfoSalida")
    protected DtInfoSalida infoSalida;
    @XmlElement(name = "CuposDisponibles")
    protected int cuposDisponibles;
    @XmlElement(name = "ActividadTuristicaAsoc")
    protected DtActividadTuristica actividadTuristicaAsoc;
    @XmlElement(nillable = true)
    protected List<DtInscripcion> inscripcionesAsoc;

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
     * Obtiene el valor de la propiedad cantidadMaxTuristas.
     * 
     */
    public int getCantidadMaxTuristas() {
        return cantidadMaxTuristas;
    }

    /**
     * Define el valor de la propiedad cantidadMaxTuristas.
     * 
     */
    public void setCantidadMaxTuristas(int value) {
        this.cantidadMaxTuristas = value;
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
     * Obtiene el valor de la propiedad infoSalida.
     * 
     * @return
     *     possible object is
     *     {@link DtInfoSalida }
     *     
     */
    public DtInfoSalida getInfoSalida() {
        return infoSalida;
    }

    /**
     * Define el valor de la propiedad infoSalida.
     * 
     * @param value
     *     allowed object is
     *     {@link DtInfoSalida }
     *     
     */
    public void setInfoSalida(DtInfoSalida value) {
        this.infoSalida = value;
    }

    /**
     * Obtiene el valor de la propiedad cuposDisponibles.
     * 
     */
    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    /**
     * Define el valor de la propiedad cuposDisponibles.
     * 
     */
    public void setCuposDisponibles(int value) {
        this.cuposDisponibles = value;
    }

    /**
     * Obtiene el valor de la propiedad actividadTuristicaAsoc.
     * 
     * @return
     *     possible object is
     *     {@link DtActividadTuristica }
     *     
     */
    public DtActividadTuristica getActividadTuristicaAsoc() {
        return actividadTuristicaAsoc;
    }

    /**
     * Define el valor de la propiedad actividadTuristicaAsoc.
     * 
     * @param value
     *     allowed object is
     *     {@link DtActividadTuristica }
     *     
     */
    public void setActividadTuristicaAsoc(DtActividadTuristica value) {
        this.actividadTuristicaAsoc = value;
    }

    /**
     * Gets the value of the inscripcionesAsoc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the inscripcionesAsoc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInscripcionesAsoc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtInscripcion }
     * 
     * 
     * @return
     *     The value of the inscripcionesAsoc property.
     */
    public List<DtInscripcion> getInscripcionesAsoc() {
        if (inscripcionesAsoc == null) {
            inscripcionesAsoc = new ArrayList<>();
        }
        return this.inscripcionesAsoc;
    }

}
