package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;


import mx.gob.renapo.registrocivil.catalogos.dto.CatCompareceDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatComparece;

public interface CatCompareceService {
	
	boolean crearComparece (String descripcion);
	boolean actualizarComparece (String decripicon);
	boolean eliminarComparece (Long id);
	CatCompareceDTO findById(Long id);
	List <CatCompareceDTO> findAll();

}
