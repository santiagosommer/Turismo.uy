package WebService.DTAux;

import java.util.Set;

import ServidorCentral.Logica.DataTypes.DTUsuario;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class SetDTUsuario {
	private Set<DTUsuario> dato;
	
	public SetDTUsuario(Set<DTUsuario> set) {
		dato = set;
	}
	
	public Set<DTUsuario> getDato() {
		return dato;
	}
}
