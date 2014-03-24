package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatLugarPartoDTO;

public interface CatLugarPartoService {

	boolean crearLugarParto (String descripcion);
	boolean actualizarLugarParto (String decripicon);
	boolean eliminarLugarParto (Long id);
    CatLugarPartoDTO findById(Long id);
	List <CatLugarPartoDTO> findAll();
	
}
