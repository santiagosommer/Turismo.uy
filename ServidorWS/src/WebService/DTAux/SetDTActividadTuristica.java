package WebService.DTAux;

import java.util.Set;

import ServidorCentral.Logica.DataTypes.DTActividadTuristica;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class SetDTActividadTuristica {
	
	private Set<DTActividadTuristica> dato;
	
	public SetDTActividadTuristica(Set<DTActividadTuristica> set) {
		dato = set;
	}
	
	public Set<DTActividadTuristica> getDato() {
		return dato;
	}
}
