package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatPuestoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPuesto;

public interface CatPuestoService {
	
	boolean crearPuesto (CatPuestoDTO puestoDTO);
	boolean actualizarPuesto (CatPuestoDTO puestoDTO);
	boolean eliminarPuesto (Long id);
    CatPuestoDTO findById(Long id);
	List <CatPuestoDTO> findAll();

}
