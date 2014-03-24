package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatSituacionLaboralDTO;

public interface CatSituacionLaboralService {
	
	boolean crearSituacionLaboral (String descripcion);
	boolean actualizarSituacionLaboral (String decripicon);
	boolean eliminarSituacionLaboral (Long id);
    CatSituacionLaboralDTO findById(Long id);
	List <CatSituacionLaboralDTO> findAll();

}
