package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.OficialDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatAtendioParto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 04:21
 * To change this template use File | Settings | File Templates.
 */
public interface CatOficialService {

    boolean crearAtendioParto (OficialDTO oficialDTO);
    boolean actualizarAtendioParto (OficialDTO oficialDTO);
    boolean eliminarAtendioParto (Long id);
    OficialDTO findById(Long id);
    List<OficialDTO> findAll();
}
