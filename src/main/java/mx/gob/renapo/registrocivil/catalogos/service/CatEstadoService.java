package mx.gob.renapo.registrocivil.catalogos.service;


import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 18/03/14
 * Time: 19:54
 * To change this template use File | Settings | File Templates.
 */
public interface CatEstadoService {
    EstadoDTO findById(Long id);
    List<EstadoDTO> findAll();
    List<EstadoDTO> recuperarPorPais(PaisDTO pais);
}
