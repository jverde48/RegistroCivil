package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/23/14
 * Time: 1:36 AM
 * Interface del service del catalogo de pais de inegi
 */
public interface CatInegiPaisService {

    List<PaisDTO> findAll();
    PaisDTO findById(Long id);

}
