package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatAtendioPartoDTO;

public interface CatAtendioPartoService {

	boolean crearAtendioParto (String descripcion);
	boolean actualizarAtendioParto (String descripcion);
	boolean eliminarAtendioParto (Long id);
    CatAtendioPartoDTO findById(Long id);
	List <CatAtendioPartoDTO> findAll();
	
}
