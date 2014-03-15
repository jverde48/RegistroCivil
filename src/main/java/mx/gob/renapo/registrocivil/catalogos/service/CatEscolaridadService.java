package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatEscolaridad;

public interface CatEscolaridadService {
	
	boolean crearEscolaridad (String descripcion);
	boolean actualizarEscolaridad (String decripicon);
	boolean eliminarEscolaridad (Long id);
	CatEscolaridad findById(Long id);
	List <CatEscolaridad> findAll();

}
