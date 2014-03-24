package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatEscolaridadDTO;

public interface CatEscolaridadService {
	
	boolean crearEscolaridad (String descripcion);
	boolean actualizarEscolaridad (String decripicon);
	boolean eliminarEscolaridad (Long id);
    CatEscolaridadDTO findById(Long id);
	List <CatEscolaridadDTO> findAll();

}
