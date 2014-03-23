package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoOficialiaDTO;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/23/14
 * Time: 4:33 AM
 * To change this template use File | Settings | File Templates.
 */
public interface CatTipoOficialiaService {

    List<CatTipoOficialiaDTO> findAll();
    CatTipoOficialiaDTO findById(Long id);

}
