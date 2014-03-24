package mx.gob.renapo.registrocivil.catalogos.service;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.dto.CatDestinoCadaverDTO;

public interface CatDestinoCadaverService {
	
	boolean crearDestinoCadaver (String descripcion);
	boolean actualizarDestinoCadaver (String decripicon);
	boolean eliminarDestinoCadaver (Long id);
    CatDestinoCadaverDTO findById(Long id);
	List <CatDestinoCadaverDTO> findAll();

}
