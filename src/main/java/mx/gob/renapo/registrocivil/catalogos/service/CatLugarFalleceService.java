package mx.gob.renapo.registrocivil.catalogos.service;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 23/03/14
 * Time: 03:32 AM
 * To change this template use File | Settings | File Templates.
 */

import mx.gob.renapo.registrocivil.catalogos.dto.CatLugarFalleceDTO;
import java.util.List;

public interface CatLugarFalleceService {
    CatLugarFalleceDTO findById(Long id);
    List<CatLugarFalleceDTO> findAll();
}
