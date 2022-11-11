package WebService.DTAux;

import java.util.Set;

import ServidorCentral.Logica.DataTypes.DTActividadTuristica;

public class SetDTActividadTuristica {
	
	private Set<DTActividadTuristica> dato;
	
	public SetDTActividadTuristica(Set<DTActividadTuristica> set) {
		dato = set;
	}
	
	public Set<DTActividadTuristica> getDato() {
		return dato;
	}
}
