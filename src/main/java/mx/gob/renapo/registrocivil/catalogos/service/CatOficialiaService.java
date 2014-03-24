package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.OficialiaDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatOficialia;

public interface CatOficialiaService {
	
	boolean crearOficialia (OficialiaDTO oficialiaDTO);
	boolean actualizarOficialia (OficialiaDTO oficialiaDTO);
	boolean eliminarOficialia (Long id);
	OficialiaDTO findById(Long id);
	List <OficialiaDTO> findAll();
}
