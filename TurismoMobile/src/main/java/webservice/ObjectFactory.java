
package webservice;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CategoriaRepetidaException_QNAME = new QName("http://WebService/", "CategoriaRepetidaException");
    private final static QName _NoHayActividadConEseNombreException_QNAME = new QName("http://WebService/", "NoHayActividadConEseNombreException");
    private final static QName _NombreActividadRepetidoException_QNAME = new QName("http://WebService/", "NombreActividadRepetidoException");
    private final static QName _NombrePaqueteRepetidoException_QNAME = new QName("http://WebService/", "NombrePaqueteRepetidoException");
    private final static QName _NombreSalidaRepetidoException_QNAME = new QName("http://WebService/", "NombreSalidaRepetidoException");
    private final static QName _UsuarioNoExisteException_QNAME = new QName("http://WebService/", "UsuarioNoExisteException");
    private final static QName _UsuarioRepetidoException_QNAME = new QName("http://WebService/", "UsuarioRepetidoException");
    private final static QName _YaExisteInscripcionTuristaSalida_QNAME = new QName("http://WebService/", "YaExisteInscripcionTuristaSalida");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CategoriaRepetidaException }
     * 
     * @return
     *     the new instance of {@link CategoriaRepetidaException }
     */
    public CategoriaRepetidaException createCategoriaRepetidaException() {
        return new CategoriaRepetidaException();
    }

    /**
     * Create an instance of {@link NoHayActividadConEseNombreException }
     * 
     * @return
     *     the new instance of {@link NoHayActividadConEseNombreException }
     */
    public NoHayActividadConEseNombreException createNoHayActividadConEseNombreException() {
        return new NoHayActividadConEseNombreException();
    }

    /**
     * Create an instance of {@link NombreActividadRepetidoException }
     * 
     * @return
     *     the new instance of {@link NombreActividadRepetidoException }
     */
    public NombreActividadRepetidoException createNombreActividadRepetidoException() {
        return new NombreActividadRepetidoException();
    }

    /**
     * Create an instance of {@link NombrePaqueteRepetidoException }
     * 
     * @return
     *     the new instance of {@link NombrePaqueteRepetidoException }
     */
    public NombrePaqueteRepetidoException createNombrePaqueteRepetidoException() {
        return new NombrePaqueteRepetidoException();
    }

    /**
     * Create an instance of {@link NombreSalidaRepetidoException }
     * 
     * @return
     *     the new instance of {@link NombreSalidaRepetidoException }
     */
    public NombreSalidaRepetidoException createNombreSalidaRepetidoException() {
        return new NombreSalidaRepetidoException();
    }

    /**
     * Create an instance of {@link UsuarioNoExisteException }
     * 
     * @return
     *     the new instance of {@link UsuarioNoExisteException }
     */
    public UsuarioNoExisteException createUsuarioNoExisteException() {
        return new UsuarioNoExisteException();
    }

    /**
     * Create an instance of {@link UsuarioRepetidoException }
     * 
     * @return
     *     the new instance of {@link UsuarioRepetidoException }
     */
    public UsuarioRepetidoException createUsuarioRepetidoException() {
        return new UsuarioRepetidoException();
    }

    /**
     * Create an instance of {@link YaExisteInscripcionTuristaSalida }
     * 
     * @return
     *     the new instance of {@link YaExisteInscripcionTuristaSalida }
     */
    public YaExisteInscripcionTuristaSalida createYaExisteInscripcionTuristaSalida() {
        return new YaExisteInscripcionTuristaSalida();
    }

    /**
     * Create an instance of {@link DtActividadTuristica }
     * 
     * @return
     *     the new instance of {@link DtActividadTuristica }
     */
    public DtActividadTuristica createDtActividadTuristica() {
        return new DtActividadTuristica();
    }

    /**
     * Create an instance of {@link DtDepartamento }
     * 
     * @return
     *     the new instance of {@link DtDepartamento }
     */
    public DtDepartamento createDtDepartamento() {
        return new DtDepartamento();
    }

    /**
     * Create an instance of {@link DtSalidaTuristica }
     * 
     * @return
     *     the new instance of {@link DtSalidaTuristica }
     */
    public DtSalidaTuristica createDtSalidaTuristica() {
        return new DtSalidaTuristica();
    }

    /**
     * Create an instance of {@link DtInfoSalida }
     * 
     * @return
     *     the new instance of {@link DtInfoSalida }
     */
    public DtInfoSalida createDtInfoSalida() {
        return new DtInfoSalida();
    }

    /**
     * Create an instance of {@link DtInscripcion }
     * 
     * @return
     *     the new instance of {@link DtInscripcion }
     */
    public DtInscripcion createDtInscripcion() {
        return new DtInscripcion();
    }

    /**
     * Create an instance of {@link DtTurista }
     * 
     * @return
     *     the new instance of {@link DtTurista }
     */
    public DtTurista createDtTurista() {
        return new DtTurista();
    }

    /**
     * Create an instance of {@link DtPaquete }
     * 
     * @return
     *     the new instance of {@link DtPaquete }
     */
    public DtPaquete createDtPaquete() {
        return new DtPaquete();
    }

    /**
     * Create an instance of {@link SetDTPaquete }
     * 
     * @return
     *     the new instance of {@link SetDTPaquete }
     */
    public SetDTPaquete createSetDTPaquete() {
        return new SetDTPaquete();
    }

    /**
     * Create an instance of {@link SetString }
     * 
     * @return
     *     the new instance of {@link SetString }
     */
    public SetString createSetString() {
        return new SetString();
    }

    /**
     * Create an instance of {@link DtProveedor }
     * 
     * @return
     *     the new instance of {@link DtProveedor }
     */
    public DtProveedor createDtProveedor() {
        return new DtProveedor();
    }

    /**
     * Create an instance of {@link SetDTSalidaTuristica }
     * 
     * @return
     *     the new instance of {@link SetDTSalidaTuristica }
     */
    public SetDTSalidaTuristica createSetDTSalidaTuristica() {
        return new SetDTSalidaTuristica();
    }

    /**
     * Create an instance of {@link SetDTUsuario }
     * 
     * @return
     *     the new instance of {@link SetDTUsuario }
     */
    public SetDTUsuario createSetDTUsuario() {
        return new SetDTUsuario();
    }

    /**
     * Create an instance of {@link SetDTActividadTuristica }
     * 
     * @return
     *     the new instance of {@link SetDTActividadTuristica }
     */
    public SetDTActividadTuristica createSetDTActividadTuristica() {
        return new SetDTActividadTuristica();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoriaRepetidaException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CategoriaRepetidaException }{@code >}
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "CategoriaRepetidaException")
    public JAXBElement<CategoriaRepetidaException> createCategoriaRepetidaException(CategoriaRepetidaException value) {
        return new JAXBElement<>(_CategoriaRepetidaException_QNAME, CategoriaRepetidaException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoHayActividadConEseNombreException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NoHayActividadConEseNombreException }{@code >}
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "NoHayActividadConEseNombreException")
    public JAXBElement<NoHayActividadConEseNombreException> createNoHayActividadConEseNombreException(NoHayActividadConEseNombreException value) {
        return new JAXBElement<>(_NoHayActividadConEseNombreException_QNAME, NoHayActividadConEseNombreException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NombreActividadRepetidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NombreActividadRepetidoException }{@code >}
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "NombreActividadRepetidoException")
    public JAXBElement<NombreActividadRepetidoException> createNombreActividadRepetidoException(NombreActividadRepetidoException value) {
        return new JAXBElement<>(_NombreActividadRepetidoException_QNAME, NombreActividadRepetidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NombrePaqueteRepetidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NombrePaqueteRepetidoException }{@code >}
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "NombrePaqueteRepetidoException")
    public JAXBElement<NombrePaqueteRepetidoException> createNombrePaqueteRepetidoException(NombrePaqueteRepetidoException value) {
        return new JAXBElement<>(_NombrePaqueteRepetidoException_QNAME, NombrePaqueteRepetidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NombreSalidaRepetidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NombreSalidaRepetidoException }{@code >}
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "NombreSalidaRepetidoException")
    public JAXBElement<NombreSalidaRepetidoException> createNombreSalidaRepetidoException(NombreSalidaRepetidoException value) {
        return new JAXBElement<>(_NombreSalidaRepetidoException_QNAME, NombreSalidaRepetidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioNoExisteException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UsuarioNoExisteException }{@code >}
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "UsuarioNoExisteException")
    public JAXBElement<UsuarioNoExisteException> createUsuarioNoExisteException(UsuarioNoExisteException value) {
        return new JAXBElement<>(_UsuarioNoExisteException_QNAME, UsuarioNoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioRepetidoException }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UsuarioRepetidoException }{@code >}
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "UsuarioRepetidoException")
    public JAXBElement<UsuarioRepetidoException> createUsuarioRepetidoException(UsuarioRepetidoException value) {
        return new JAXBElement<>(_UsuarioRepetidoException_QNAME, UsuarioRepetidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link YaExisteInscripcionTuristaSalida }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link YaExisteInscripcionTuristaSalida }{@code >}
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "YaExisteInscripcionTuristaSalida")
    public JAXBElement<YaExisteInscripcionTuristaSalida> createYaExisteInscripcionTuristaSalida(YaExisteInscripcionTuristaSalida value) {
        return new JAXBElement<>(_YaExisteInscripcionTuristaSalida_QNAME, YaExisteInscripcionTuristaSalida.class, null, value);
    }

}
