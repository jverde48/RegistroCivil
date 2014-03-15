package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatOficialia;

public interface CatOficialiaService {
	
	boolean crearOficialia (String descripcion, String oficial, Object tipoOficialia);
	boolean actualizarOficialia (String decripicon, String oficial, Object tipoOficialia);
	boolean eliminarOficialia (Long id);
	CatOficialia findById(Long id);
	List <CatOficialia> findAll();

	
	
	
}
