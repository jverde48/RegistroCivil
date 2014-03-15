package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoSentencia;

public interface CatTipoSentenciaService {

	boolean crearTipoSentencia (String descripcion);
	boolean actualizarTipoSentencia (String decripicon);
	boolean eliminarTipoSentencia (Long id);
	CatTipoSentencia findById(Long id);
	List <CatTipoSentencia> findAll();
	
}