package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoDocumento;

public interface CatTipoDocumentoService {

	boolean crearTipoDocumento (String descripcion);
	boolean actualizarTipoDocumento (String decripicon);
	boolean eliminarTipoDocumento (Long id);
	CatTipoDocumento findById(Long id);
	List <CatTipoDocumento> findAll();
	
}
