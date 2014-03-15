package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoOperacion;

public interface CatTipoOperacionService {

	boolean crearTipoOperacion (String descripcion);
	boolean actualizarTipoOperacion (String decripicon);
	boolean eliminarTipoOperacion (Long id);
	CatTipoOperacion findById(Long id);
	List <CatTipoOperacion> findAll();
	
}
