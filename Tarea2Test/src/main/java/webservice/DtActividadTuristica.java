
package webservice;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtActividadTuristica complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>{@code
 * <complexType name="dtActividadTuristica">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Duracion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="CostoTurista" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         <element name="FechaAlta" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" minOccurs="0"/>
 *         <element name="InfoDepartamento" type="{http://WebService/}dtDepartamento" minOccurs="0"/>
 *         <element name="InfoSalidas" type="{http://WebService/}dtSalidaTuristica" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="Proveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="InfoPaquetes" type="{http://WebService/}dtPaquete" maxOccurs="unbounded" minOccurs="0"/>
 *         <element name="Ciudad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="estado" type="{http://WebService/}estadoActividad" minOccurs="0"/>
 *         <element name="categorias" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtActividadTuristica", propOrder = {
    "nombre",
    "descripcion",
    "duracion",
    "costoTurista",
    "fechaAlta",
    "infoDepartamento",
    "infoSalidas",
    "proveedor",
    "infoPaquetes",
    "ciudad",
    "estado",
    "categorias"
})
public class DtActividadTuristica {

    @XmlElement(name = "Nombre")
    protected String nombre;
    @XmlElement(name = "Descripcion")
    protected String descripcion;
    @XmlElement(name = "Duracion")
    protected int duracion;
    @XmlElement(name = "CostoTurista")
    protected float costoTurista;
    @XmlElement(name = "FechaAlta")
    protected Object fechaAlta;
    @XmlElement(name = "InfoDepartamento")
    protected DtDepartamento infoDepartamento;
    @XmlElement(name = "InfoSalidas", nillable = true)
    protected List<DtSalidaTuristica> infoSalidas;
    @XmlElement(name = "Proveedor")
    protected String proveedor;
    @XmlElement(name = "InfoPaquetes", nillable = true)
    protected List<DtPaquete> infoPaquetes;
    @XmlElement(name = "Ciudad")
    protected String ciudad;
    @XmlSchemaType(name = "string")
    protected EstadoActividad estado;
    @XmlElement(nillable = true)
    protected List<String> categorias;

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
     * Obtiene el valor de la propiedad duracion.
     * 
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Define el valor de la propiedad duracion.
     * 
     */
    public void setDuracion(int value) {
        this.duracion = value;
    }

    /**
     * Obtiene el valor de la propiedad costoTurista.
     * 
     */
    public float getCostoTurista() {
        return costoTurista;
    }

    /**
     * Define el valor de la propiedad costoTurista.
     * 
     */
    public void setCostoTurista(float value) {
        this.costoTurista = value;
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
     * Obtiene el valor de la propiedad infoDepartamento.
     * 
     * @return
     *     possible object is
     *     {@link DtDepartamento }
     *     
     */
    public DtDepartamento getInfoDepartamento() {
        return infoDepartamento;
    }

    /**
     * Define el valor de la propiedad infoDepartamento.
     * 
     * @param value
     *     allowed object is
     *     {@link DtDepartamento }
     *     
     */
    public void setInfoDepartamento(DtDepartamento value) {
        this.infoDepartamento = value;
    }

    /**
     * Gets the value of the infoSalidas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the infoSalidas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoSalidas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtSalidaTuristica }
     * 
     * 
     * @return
     *     The value of the infoSalidas property.
     */
    public List<DtSalidaTuristica> getInfoSalidas() {
        if (infoSalidas == null) {
            infoSalidas = new ArrayList<>();
        }
        return this.infoSalidas;
    }

    /**
     * Obtiene el valor de la propiedad proveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * Define el valor de la propiedad proveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProveedor(String value) {
        this.proveedor = value;
    }

    /**
     * Gets the value of the infoPaquetes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the infoPaquetes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoPaquetes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtPaquete }
     * 
     * 
     * @return
     *     The value of the infoPaquetes property.
     */
    public List<DtPaquete> getInfoPaquetes() {
        if (infoPaquetes == null) {
            infoPaquetes = new ArrayList<>();
        }
        return this.infoPaquetes;
    }

    /**
     * Obtiene el valor de la propiedad ciudad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Define el valor de la propiedad ciudad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCiudad(String value) {
        this.ciudad = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link EstadoActividad }
     *     
     */
    public EstadoActividad getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoActividad }
     *     
     */
    public void setEstado(EstadoActividad value) {
        this.estado = value;
    }

    /**
     * Gets the value of the categorias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the categorias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCategorias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     * @return
     *     The value of the categorias property.
     */
    public List<String> getCategorias() {
        if (categorias == null) {
            categorias = new ArrayList<>();
        }
        return this.categorias;
    }

}
