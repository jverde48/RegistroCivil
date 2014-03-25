package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoLocalidadDTO;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 24/03/14
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */

public interface CatTipoLocalidadService {

    CatTipoLocalidadDTO findById(Long id);
    List<CatTipoLocalidadDTO> findAll();
}
