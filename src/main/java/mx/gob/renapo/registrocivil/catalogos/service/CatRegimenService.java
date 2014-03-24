package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatRegimenDTO;

public interface CatRegimenService {

	boolean crearRegimen (String descripcion);
	boolean actualizarRegimen (String decripicon);
	boolean eliminarRegimen (Long id);
	CatRegimenDTO findById(Long id);
	List <CatRegimenDTO> findAll();
	
}
