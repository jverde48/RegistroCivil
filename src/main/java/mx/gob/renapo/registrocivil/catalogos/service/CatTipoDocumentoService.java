package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoDocumentoDTO;

public interface CatTipoDocumentoService {

	boolean crearTipoDocumento (String descripcion);
	boolean actualizarTipoDocumento (String decripicon);
	boolean eliminarTipoDocumento (Long id);
	CatTipoDocumentoDTO findById(Long id);
	List <CatTipoDocumentoDTO> findAll();
	
}
