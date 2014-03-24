package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoOperacionDTO;

public interface CatTipoOperacionService {

	boolean crearTipoOperacion (String descripcion);
	boolean actualizarTipoOperacion (String decripicon);
	boolean eliminarTipoOperacion (Long id);
	CatTipoOperacionDTO findById(Long id);
	List <CatTipoOperacionDTO> findAll();
	
}
