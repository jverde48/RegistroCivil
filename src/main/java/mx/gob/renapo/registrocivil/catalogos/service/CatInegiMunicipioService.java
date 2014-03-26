package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 01:24
 * To change this template use File | Settings | File Templates.
 */
public interface CatInegiMunicipioService {
    MunicipioDTO findById(Long id);
    List<MunicipioDTO> findAll();
    List<MunicipioDTO> recuperaMunicipiosPorEstado(EstadoDTO estado);
}
