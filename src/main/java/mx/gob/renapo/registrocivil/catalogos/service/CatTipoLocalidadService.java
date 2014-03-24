package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoLocalidadDTO;
import java.util.List;

public interface CatTipoLocalidadService {
	
	List<CatTipoLocalidadDTO> findAll();
	CatTipoLocalidadDTO findById(Long id);

}
