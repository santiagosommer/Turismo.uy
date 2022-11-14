package WebService.DTAux;

import java.util.Set;

import ServidorCentral.Logica.DataTypes.DTSalidaTuristica;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SetDTSalidaTuristica {
	
	private Set<DTSalidaTuristica> dato;
	
	public SetDTSalidaTuristica(Set<DTSalidaTuristica> set) {
		dato = set;
	}
	
	public Set<DTSalidaTuristica> getDato() {
		return dato;
	}
}
