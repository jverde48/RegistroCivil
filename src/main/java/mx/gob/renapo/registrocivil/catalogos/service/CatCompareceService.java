package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;


import mx.gob.renapo.registrocivil.catalogos.entity.CatComparece;

public interface CatCompareceService {
	
	boolean crearComparece (String descripcion);
	boolean actualizarComparece (String decripicon);
	boolean eliminarComparece (Long id);
	CatComparece findById(Long id);
	List <CatComparece> findAll();

}
