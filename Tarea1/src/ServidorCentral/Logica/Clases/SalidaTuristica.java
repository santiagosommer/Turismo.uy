package ServidorCentral.Logica.Clases;
import ServidorCentral.Logica.DataTypes.DTInfoSalida;
import java.time.LocalDate;
import java.util.Map;



public class SalidaTuristica {

	 private String Nombre;
	 private int CantidadMaxTuristas;
	 private LocalDate FechaSalida;
	 private ServidorCentral.Logica.DataTypes.DTInfoSalida InfoSalida;
	 private int CuposDisponibles;
	 private ActividadTuristica ActividadTuristicaAsociada;

	 
	 public  SalidaTuristica (String nombre,int cantidadMaxTuristas,LocalDate fechaSalida,DTInfoSalida infoSalida,int cuposDisponibles 
			) {
		 Nombre = nombre;
		 CantidadMaxTuristas = cantidadMaxTuristas;
		 FechaSalida = fechaSalida;
		 InfoSalida = infoSalida;
		 CuposDisponibles = cuposDisponibles;
	     			 
	 }	 
	 
	 public String getNombre() {
			return Nombre;
		}
		public void setNombre(String nombre) {
			Nombre = nombre;
		}
		public int getCantidadMaxTuristas() {
			return CantidadMaxTuristas;
		}
		public void setCantidadMaxTuristas(int cantidadMaxTuristas) {
			CantidadMaxTuristas = cantidadMaxTuristas;
		}
		public LocalDate getFechaSalida() {
			return FechaSalida;
		}
		public void setFechaSalida(LocalDate fechaSalida) {
			FechaSalida = fechaSalida;
		}
		public DTInfoSalida getInfoSalida() {
			return InfoSalida;
		}
		public void setInfoSalida(DTInfoSalida infoSalida) {
			InfoSalida = infoSalida;
		}
		public int getCuposDisponibles() {
			return CuposDisponibles;
		}
		public void setCuposDisponibles(int cuposDisponibles) {
			CuposDisponibles = cuposDisponibles;
		}

		public ActividadTuristica getActividadTuristicaAsociada() {
			return ActividadTuristicaAsociada;
		}

		public void setActividadTuristicaAsociada(ActividadTuristica actividadTuristicaAsociada) {
			ActividadTuristicaAsociada = actividadTuristicaAsociada;
		}

	

}
