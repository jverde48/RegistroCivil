package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.NacionalidadDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 04:01
 * To change this template use File | Settings | File Templates.
 */
public interface CatNacionalidadService {

    NacionalidadDTO findById(Long id);
    List<NacionalidadDTO> findAll();
}
