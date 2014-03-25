package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.LocalidadDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 01:56
 * To change this template use File | Settings | File Templates.
 */
public interface CatColoniaLocalidadService {
    LocalidadDTO findById(Long id);
    List<LocalidadDTO> findAll();
}
