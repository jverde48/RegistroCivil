package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoSentenciaDTO;

public interface CatTipoSentenciaService {

	boolean crearTipoSentencia (String descripcion);
	boolean actualizarTipoSentencia (String decripicon);
	boolean eliminarTipoSentencia (Long id);
	CatTipoSentenciaDTO findById(Long id);
	List <CatTipoSentenciaDTO> findAll();
	
}