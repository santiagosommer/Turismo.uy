
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
 *         <element name="actividadTuristicaAsoc" type="{http://WebService/}dtActividadTuristica" minOccurs="0"/>
 *         <element name="cantidadMaxTuristas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="cuposDisponibles" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="fechaAlta" type="{http://WebService/}localDate" minOccurs="0"/>
 *         <element name="infoSalida" type="{http://WebService/}dtInfoSalida" minOccurs="0"/>
 *         <element name="inscripciones" type="{http://WebService/}dtInscripcion" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "actividadTuristicaAsoc",
    "cantidadMaxTuristas",
    "cuposDisponibles",
    "fechaAlta",
    "infoSalida",
    "inscripciones",
    "nombre"
})
public class DtSalidaTuristica {

    protected DtActividadTuristica actividadTuristicaAsoc;
    protected int cantidadMaxTuristas;
    protected int cuposDisponibles;
    protected LocalDate fechaAlta;
    protected DtInfoSalida infoSalida;
    @XmlElement(nillable = true)
    protected List<DtInscripcion> inscripciones;
    protected String nombre;

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
     * Obtiene el valor de la propiedad fechaAlta.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Define el valor de la propiedad fechaAlta.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setFechaAlta(LocalDate value) {
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
     * Gets the value of the inscripciones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the inscripciones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInscripciones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtInscripcion }
     * 
     * 
     * @return
     *     The value of the inscripciones property.
     */
    public List<DtInscripcion> getInscripciones() {
        if (inscripciones == null) {
            inscripciones = new ArrayList<>();
        }
        return this.inscripciones;
    }

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

}
