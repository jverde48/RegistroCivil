package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatEstadoCivilDTO;

public interface CatEstadoCivilService {

	boolean crearEstadoCivil (String descripcion);
	boolean actualizarEstadoCivil (String decripicon);
	boolean eliminarEstadoCivil (Long id);
	CatEstadoCivilDTO findById(Long id);
	List <CatEstadoCivilDTO> findAll();
	
}
