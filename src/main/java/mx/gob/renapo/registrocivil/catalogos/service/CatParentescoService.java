package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatParentesco;

public interface CatParentescoService {

	boolean crearParentesco (String descripcion);
	boolean actualizarParentesco (String decripicon);
	boolean eliminarParentesco (Long id);
	CatParentesco findById(Long id);
	List <CatParentesco> findAll();
	
}
