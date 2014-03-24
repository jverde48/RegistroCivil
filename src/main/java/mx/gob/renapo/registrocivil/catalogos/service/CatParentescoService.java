package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatParentescoDTO;

public interface CatParentescoService {

	boolean crearParentesco (String descripcion);
	boolean actualizarParentesco (String decripicon);
	boolean eliminarParentesco (Long id);
    CatParentescoDTO findById(Long id);
	List <CatParentescoDTO> findAll();
	
}
