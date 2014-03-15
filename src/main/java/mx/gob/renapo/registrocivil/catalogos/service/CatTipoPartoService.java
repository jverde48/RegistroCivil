package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoParto;

public interface CatTipoPartoService {

	boolean crearTipoParto (String descripcion);
	boolean actualizarTipoParto (String decripicon);
	boolean eliminarTipoParto (Long id);
	CatTipoParto findById(Long id);
	List <CatTipoParto> findAll();
	
}
