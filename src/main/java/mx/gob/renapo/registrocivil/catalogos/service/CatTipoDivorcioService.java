package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoDivorcioDTO;

public interface CatTipoDivorcioService {

	boolean crearTipoDivorcio (String descripcion);
	boolean actualizarTipoDivorcio (String decripicon);
	boolean eliminarTipoDivorcio (Long id);
	CatTipoDivorcioDTO findById(Long id);
	List <CatTipoDivorcioDTO> findAll();
	
}
