package WebService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

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

    //endpoint = Endpoint.publish("http://localhost:9129/publicador", this);
    	
    	Properties defaultProps = new Properties();
    	
    	try (FileInputStream in = new FileInputStream(System.getProperty("user.home") + File.separator + "git/tpgr25/turismouy.properties")) {
    		defaultProps.load(in);
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
			e.printStackTrace();
		}    	
        endpoint = Endpoint.publish("http://" + defaultProps.getProperty("maquina") + ":" + defaultProps.getProperty("puerto") +"/publicador", this);
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
	public void crearPaquete(String nombrePaque, String descripcion, int periodoValidez,int Descuento, Calendar fechaAlta) throws NombrePaqueteRepetidoException{
    	Date input = fechaAlta.getTime();
    	LocalDate localDate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	
    	iPaquete.crearPaquete(nombrePaque, descripcion, periodoValidez, Descuento, localDate);
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
	public void crearActividadTuristica(String nombre, String descripcion, int duracion, float costoTurista, Calendar fechaAlta, String ciudad, String departamento,String proveedorNick, SetString categorias) throws NombreActividadRepetidoException{
    	Date input = fechaAlta.getTime();
    	LocalDate localDate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	
    	
    	iTuristica.crearActividadTuristica(nombre, descripcion, duracion, costoTurista, localDate, ciudad, departamento, proveedorNick, categorias.getDato());
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
	public void crearSalidaTuristica(String nombre,int cantMaxTuristas, Calendar fechaAlta, Calendar fechaInfo, String lugarInfo, String actividad) throws NombreSalidaRepetidoException, NoHayActividadConEseNombreException{
    	Date input = fechaAlta.getTime();
        LocalDate localDate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        TimeZone tz = fechaInfo.getTimeZone();

        // Getting zone id
        ZoneId zoneId = tz.toZoneId();

        // conversion
        LocalDateTime date = LocalDateTime.ofInstant(fechaInfo.toInstant(), zoneId);
    	
    	LocalDate fecha = date.toLocalDate();
        LocalTime hora = date.toLocalTime();

	    DTInfoSalida dtInfo = new DTInfoSalida(fecha, hora, lugarInfo);
    	iTuristica.crearSalidaTuristica(nombre, cantMaxTuristas, localDate, dtInfo, actividad);
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
    //Nueva
    @WebMethod
    public  void finalizarActividadTuristica(String nombreActividad) {
    	 iTuristica.finalizarActividadTuristica(nombreActividad);
    }
    
    
    //----------IUsuario------------------------------------------
    //Nueva
    @WebMethod
    public void finalizarActividadTuristicaProveedor(String nombreActividad) {
    	iUsuario.finalizarActividadTuristicaProveedor(nombreActividad);
    }
    
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
	public void crearInscripcion(String nombreTurista,String nombreSalida, int cantidadTuristas,Float costo, Calendar fechaAlta) throws YaExisteInscripcionTuristaSalida{
    	Date input = fechaAlta.getTime();
    	LocalDate localDate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	
    	iUsuario.crearInscripcion(nombreTurista, nombreSalida, cantidadTuristas, costo, localDate);
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
	public void altaProveedor(String nickname, String nombre, String apellido, String email, Calendar fechaNacimiento, String contraseña, String descripcionGeneral, String url) throws UsuarioRepetidoException{
    	Date input = fechaNacimiento.getTime();
    	LocalDate localDate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	
    	iUsuario.altaProveedor(nickname, nombre, apellido, email, localDate, contraseña, descripcionGeneral, url);
	}
    
    @WebMethod
	public void altaTurista(String nickname, String nombre, String apellido, String email, Calendar fechaNacimiento, String contraseña, String nacionalidad) throws UsuarioRepetidoException{
    	Date input = fechaNacimiento.getTime();
    	LocalDate localDate = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    	
    	iUsuario.altaTurista(nickname, nombre, apellido, email, localDate, contraseña, nacionalidad);
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
