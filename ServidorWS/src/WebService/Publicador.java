package WebService;

import java.time.LocalDate;

import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import ServidorCentral.Logica.DataTypes.DTDepartamento;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import ServidorCentral.Logica.DataTypes.DTPaquete;
import ServidorCentral.Logica.DataTypes.DTProveedor;
import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import ServidorCentral.Logica.DataTypes.DTTurista;
import ServidorCentral.Logica.DataTypes.EstadoError;
import ServidorCentral.Logica.Excepciones.CategoriaRepetidaException;
import ServidorCentral.Logica.Excepciones.NoHayActividadConEseNombreException;
import ServidorCentral.Logica.Excepciones.NombreActividadRepetidoException;
import ServidorCentral.Logica.Excepciones.NombrePaqueteRepetidoException;
import ServidorCentral.Logica.Excepciones.NombreSalidaRepetidoException;
import ServidorCentral.Logica.Excepciones.UsuarioNoExisteException;
import ServidorCentral.Logica.Excepciones.UsuarioRepetidoException;
import ServidorCentral.Logica.Excepciones.YaExisteInscripcionTuristaSalida;
import ServidorCentral.Logica.Fabrica.Fabrica;
import ServidorCentral.Logica.Interfaces.*;
import WebService.DTAux.SetDTActividadTuristica;
import WebService.DTAux.SetDTPaquete;
import WebService.DTAux.SetDTSalidaTuristica;
import WebService.DTAux.SetDTUsuario;
import WebService.DTAux.SetString;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;
/**
 *
 * @author Pablo
 */
@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {

	private IUsuario iUsuario = Fabrica.getInstance().getControladorUsuario();
	private ITuristica iTuristica = Fabrica.getInstance().getControladorTuristica();
	private IPaquete iPaquete = Fabrica.getInstance().getControladorPaquete();
    private Endpoint endpoint = null;
    //Constructor
    public Publicador(){}

    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9129/publicador", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    //----------IPaquetes------------------------------------------
    
    @WebMethod
    public SetString listarCategoriasPaquete(String paquete){
    	return new SetString(iPaquete.listarCategoriasPaquete(paquete));
    }
    
    @WebMethod
	public void seleccionarPaquete(String paquete) {
		iPaquete.seleccionarPaquete(paquete);
	}

    @WebMethod
	public void crearPaquete(String nombrePaque, String descripcion, int periodoValidez,int Descuento, LocalDate fechaAlta) throws NombrePaqueteRepetidoException{
		iPaquete.crearPaquete(nombrePaque, descripcion, periodoValidez, Descuento, fechaAlta);
	}
	
    @WebMethod
	public boolean existePaquete(String paquete) {
		return iPaquete.existePaquete(paquete);
	}

    @WebMethod
	public SetString listarPaquetes(){
		return new SetString(iPaquete.listarPaquetes());
	}

    @WebMethod
	public SetString listarActividadesAAgregar(String departamento){
		return new SetString(iPaquete.listarActividadesAAgregar(departamento));
	}

    @WebMethod
	public DTPaquete getDtPaquete() {
    	return iPaquete.getDtPaquete();
    }

    @WebMethod
	public void AgregarActividadPaquete(String paqueteSelecBox, String actividadSelecBox) {
    	iPaquete.AgregarActividadPaquete(paqueteSelecBox, actividadSelecBox);
    }
	
    @WebMethod
	public SetString listarActividadesPaquete(){
    	return new SetString(iPaquete.listarActividadesPaquete());
    }
	
    @WebMethod
    public SetDTPaquete infoPaquetes(){
    	return new SetDTPaquete(iPaquete.infoPaquetes());
    }
    
    //----------ITuristica------------------------------------------
    
    @WebMethod
    public SetString listarCategorias(){
    	return new SetString(iTuristica.listarCategorias());
    }
    
    @WebMethod
	public SetString listarCategoriasActividad(String actividad){
    	return new SetString(iTuristica.listarCategoriasActividad(actividad));
	}
    
    @WebMethod
	public void crearCategoria(String nombre) throws CategoriaRepetidaException{
    	iTuristica.crearCategoria(nombre);
	}
    
    @WebMethod
	public void seleccionarActividad(String actividad){
    	iTuristica.seleccionarActividad(actividad);
	}
    
    @WebMethod
	public void seleccionarSalida(String salida){
    	iTuristica.seleccionarSalida(salida);
	}
    
    @WebMethod
	public void seleccionarDepartamento(String departemneto){
    	iTuristica.seleccionarDepartamento(departemneto);
	}
    
    @WebMethod
	public DTActividadTuristica getDTActividadTuristica(){
    	return iTuristica.getDTActividadTuristica();
	}
    
    @WebMethod
	public DTSalidaTuristica getDTSalidaTuristica(){
    	return iTuristica.getDTSalidaTuristica();
	}
    
    @WebMethod
	public DTDepartamento getDTDepartamento(){
    	return iTuristica.getDTDepartamento();
	}
    
    @WebMethod
	public void crearActividadTuristica(String nombre, String descripcion, int duracion, float costoTurista, LocalDate fechaAlta, String ciudad, String departamento,String proveedorNick, SetString categorias) throws NombreActividadRepetidoException{
    	iTuristica.crearActividadTuristica(nombre, descripcion, duracion, costoTurista, fechaAlta, ciudad, departamento, proveedorNick, categorias.getDato());
	}
    
    @WebMethod
	public SetString listarDepartamentos(){
    	return new SetString(iTuristica.listarDepartamentos());
	}
    
    @WebMethod
	public SetString listarActividadesDeDepartamento(String departemento){
    	return new SetString(iTuristica.listarActividadesDeDepartamento(departemento));
	}
    
    @WebMethod
	public SetDTSalidaTuristica datosSalidasVigentes(String actividad){
    	return new SetDTSalidaTuristica(iTuristica.datosSalidasVigentes(actividad));
	}
    
    @WebMethod
	public void crearSalidaTuristica(String nombre,int cantMaxTuristas, LocalDate fechaAlta, DTInfoSalida infoSalida, String actividad) throws NombreSalidaRepetidoException, NoHayActividadConEseNombreException{
    	iTuristica.crearSalidaTuristica(nombre, cantMaxTuristas, fechaAlta, infoSalida, actividad);
	}
    
    @WebMethod
	public SetString listarSalidasActividad(String actividad){
    	return new SetString(iTuristica.listarSalidasActividad(actividad));
	}
    
    @WebMethod
	public Boolean existeActividad(String actividad){
    	return iTuristica.existeActividad(actividad);
	}
    
    @WebMethod
	public Boolean existeSalida(String salida){
    	return iTuristica.existeSalida(salida);
	}
    
    @WebMethod
	public Boolean existeDepartamento(String departamento){
    	return iTuristica.existeDepartamento(departamento);
	}
    
    @WebMethod
	public void crearDepartamento(String nombre,String descripcion, String URL){
    	iTuristica.crearDepartamento(nombre, descripcion, URL);
	}
    
    @WebMethod
	public Boolean existeInscripcion(String salida, String nombreTurista){
    	return iTuristica.existeInscripcion(salida, nombreTurista);
	}
    
    @WebMethod
	public SetString listarActividadesAgregadas(){
    	return new SetString(iTuristica.listarActividadesAgregadas());
	}
    
    @WebMethod
	public void AceptarActividad(String actividad){
    	iTuristica.AceptarActividad(actividad);
	}
    
    @WebMethod
	public void RechazarActividad(String actividad){
    	iTuristica.RechazarActividad(actividad);
	}
    
    @WebMethod
	public SetDTActividadTuristica listarActividadesDeptoYCate(String depto,String cat){
    	return new SetDTActividadTuristica(iTuristica.listarActividadesDeptoYCate(depto, cat));
	}
    
    @WebMethod
	public SetDTPaquete listarPaquetesCategoria(String cat){
    	return new SetDTPaquete(iTuristica.listarPaquetesCategoria(cat));
	}
    
    //----------IUsuario------------------------------------------
    
    @WebMethod
    public Boolean esTurista(String nickname){
    	return iUsuario.esTurista(nickname);
    }
    
    @WebMethod
	public void seleccionarTurista(String Turista){
    	iUsuario.seleccionarTurista(Turista);
	}
    
    @WebMethod
	public void seleccionarProveedor(String Proveedor){
    	iUsuario.seleccionarProveedor(Proveedor);
	}
    
    @WebMethod
	public SetString listarUsuarios() throws UsuarioNoExisteException{
    	return new SetString(iUsuario.listarUsuarios());
	} 
    
    @WebMethod
	public SetString listarProveedores() throws UsuarioNoExisteException{
    	return new SetString(iUsuario.listarProveedores());
	}
    
    @WebMethod
	public SetString listarTuristas(){
    	return new SetString(iUsuario.listarTuristas());
	}
    
    @WebMethod
	public DTTurista getDTTurista(){
    	return iUsuario.getDTTurista();
	}
    
    @WebMethod
	public DTProveedor getDTProveedor(){
    	return iUsuario.getDTProveedor();
	}
    
    @WebMethod
	public void crearInscripcion(String nombreTurista,String nombreSalida, int cantidadTuristas,Float costo, LocalDate fechaAlta) throws YaExisteInscripcionTuristaSalida{
    	iUsuario.crearInscripcion(nombreTurista, nombreSalida, cantidadTuristas, costo, fechaAlta);
	}
    
    @WebMethod
	public Boolean existeUsuario(String nickN){
    	return iUsuario.existeUsuario(nickN);
	}
    
    @WebMethod
	public Boolean existeUsuarioEmail(String email){
    	return iUsuario.existeUsuarioEmail(email);
	}
    
    @WebMethod
	public void altaProveedor(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contraseña, String descripcionGeneral, String url) throws UsuarioRepetidoException{
    	iUsuario.altaProveedor(nickname, nombre, apellido, email, fechaNacimiento, contraseña, descripcionGeneral, url);
	}
    
    @WebMethod
	public void altaTurista(String nickname, String nombre, String apellido, String email, LocalDate fechaNacimiento, String contraseña, String nacionalidad) throws UsuarioRepetidoException{
    	iUsuario.altaTurista(nickname, nombre, apellido, email, fechaNacimiento, contraseña, nacionalidad);
	}
    
    @WebMethod
	public String getNickname(String email){
    	return iUsuario.getNickname(email);
	}
    
    @WebMethod
	public EstadoError iniciarSesion(String nick_or_email, String passw){
    	return iUsuario.iniciarSesion(nick_or_email, passw);
	}
    
    @WebMethod
	public SetDTUsuario getDTSUsuarios(){
    	return new SetDTUsuario(iUsuario.getDTSUsuarios());
	}

}
