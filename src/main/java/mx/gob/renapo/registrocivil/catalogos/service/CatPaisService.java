package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPais;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/20/14
 * Time: 12:42 PM
 * Interface
 */
public interface CatPaisService {

   List<PaisDTO> findAll();
   PaisDTO findById(Long id);
   PaisDTO findMexico();

}
