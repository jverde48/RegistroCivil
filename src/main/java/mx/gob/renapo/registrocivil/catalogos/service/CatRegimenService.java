package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatRegimen;

public interface CatRegimenService {

	boolean crearRegimen (String descripcion);
	boolean actualizarRegimen (String decripicon);
	boolean eliminarRegimen (Long id);
	CatRegimen findById(Long id);
	List <CatRegimen> findAll();
	
}
