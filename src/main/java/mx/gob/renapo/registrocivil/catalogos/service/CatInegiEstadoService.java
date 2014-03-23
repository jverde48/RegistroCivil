package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/23/14
 * Time: 1:45 AM
 * Interface del service del catalogo de estado de inegi
 */
public interface CatInegiEstadoService {

    EstadoDTO findById(Long id);
    List<EstadoDTO> findAll();

}
