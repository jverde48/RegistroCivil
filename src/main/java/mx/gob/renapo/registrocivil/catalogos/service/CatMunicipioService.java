package mx.gob.renapo.registrocivil.catalogos.service;

import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/20/14
 * Time: 2:39 PM
 * Interface de la capa de Service para el catalogo de municipio
 */
public interface CatMunicipioService {

    List<MunicipioDTO> findAll();
    MunicipioDTO findById(Long id);

}
