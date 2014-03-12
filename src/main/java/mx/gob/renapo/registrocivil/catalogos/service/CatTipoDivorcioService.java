package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoDivorcio;

public interface CatTipoDivorcioService {

	boolean crearTipoDivorcio (String descripcion);
	boolean actualizarTipoDivorcio (String decripicon);
	boolean eliminarTipoDivorcio (Long id);
	CatTipoDivorcio findById(Long id);
	List <CatTipoDivorcio> findAll();
	
}
