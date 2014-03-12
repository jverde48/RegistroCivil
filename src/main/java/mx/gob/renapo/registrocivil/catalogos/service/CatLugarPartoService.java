package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatLugarParto;

public interface CatLugarPartoService {

	boolean crearLugarParto (String descripcion);
	boolean actualizarLugarParto (String decripicon);
	boolean eliminarLugarParto (Long id);
	CatLugarParto findById(Long id);
	List <CatLugarParto> findAll();
	
}
