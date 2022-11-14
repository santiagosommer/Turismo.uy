package WebService.DTAux;

import java.util.Set;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;


@XmlAccessorType(XmlAccessType.FIELD)
public class SetString {
	
	private Set<String> dato;
	
	public SetString(){
		;
	}
	
	public SetString(Set<String> set) {
		dato = set;
	}
	
	public Set<String> getDato() {
		return dato;
	}
}
