package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatDestinoCadaver;

public interface CatDestinoCadaverService {
	
	boolean crearDestinoCadaver (String descripcion);
	boolean actualizarDestinoCadaver (String decripicon);
	boolean eliminarDestinoCadaver (Long id);
	CatDestinoCadaver findById(Long id);
	List <CatDestinoCadaver> findAll();

}
