package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatEstadoCivil;

public interface CatEstadoCivilService {

	boolean crearEstadoCivil (String descripcion);
	boolean actualizarEstadoCivil (String decripicon);
	boolean eliminarEstadoCivil (Long id);
	CatEstadoCivil findById(Long id);
	List <CatEstadoCivil> findAll();
	
}
