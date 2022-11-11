package WebService.DTAux;

import java.util.Set;

import ServidorCentral.Logica.DataTypes.DTUsuario;

public class SetDTUsuario {
	private Set<DTUsuario> dato;
	
	public SetDTUsuario(Set<DTUsuario> set) {
		dato = set;
	}
	
	public Set<DTUsuario> getDato() {
		return dato;
	}
}
