package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoPartoDTO;

public interface CatTipoPartoService {

	boolean crearTipoParto (String descripcion);
	boolean actualizarTipoParto (String decripicon);
	boolean eliminarTipoParto (Long id);
    CatTipoPartoDTO findById(Long id);
	List <CatTipoPartoDTO> findAll();
	
}
