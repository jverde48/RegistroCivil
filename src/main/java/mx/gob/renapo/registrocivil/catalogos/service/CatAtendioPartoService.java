package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatAtendioParto;

public interface CatAtendioPartoService {

	boolean crearAtendioParto (String descripcion);
	boolean actualizarAtendioParto (String descripcion);
	boolean eliminarAtendioParto (Long id);
	CatAtendioParto findById(Long id);
	List <CatAtendioParto> findAll();
	
}
