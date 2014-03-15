package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatSituacionLaboral;

public interface CatSituacionLaboralService {
	
	boolean crearSituacionLaboral (String descripcion);
	boolean actualizarSituacionLaboral (String decripicon);
	boolean eliminarSituacionLaboral (Long id);
	CatSituacionLaboral findById(Long id);
	List <CatSituacionLaboral> findAll();

}
