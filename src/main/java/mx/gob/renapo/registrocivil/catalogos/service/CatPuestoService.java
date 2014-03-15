package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatPuesto;

public interface CatPuestoService {
	
	boolean crearPuesto (String descripcion);
	boolean actualizarPuesto (String decripicon);
	boolean eliminarPuesto (Long id);
	CatPuesto findById(Long id);
	List <CatPuesto> findAll();

}
