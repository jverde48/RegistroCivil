package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.ColoniaLocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 01:56
 * To change this template use File | Settings | File Templates.
 */
public interface CatColoniaLocalidadService {
    ColoniaLocalidadDTO findById(Long id);
    List<ColoniaLocalidadDTO> findAll();
}
