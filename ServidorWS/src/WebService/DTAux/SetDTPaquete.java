package WebService.DTAux;

import java.util.Set;

import ServidorCentral.Logica.DataTypes.DTPaquete;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
@XmlAccessorType(XmlAccessType.FIELD)
public class SetDTPaquete {
	
	private Set<DTPaquete> dato;
	
	public SetDTPaquete(Set<DTPaquete> map) {
		dato = map;
	}
	
	public Set<DTPaquete> getDato() {
		return dato;
	}
}
