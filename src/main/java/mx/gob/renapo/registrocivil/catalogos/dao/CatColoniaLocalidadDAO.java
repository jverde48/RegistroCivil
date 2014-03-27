package mx.gob.renapo.registrocivil.catalogos.dao;

import mx.gob.renapo.registrocivil.catalogos.dto.LocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiLocalidad;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiMunicipio;
import mx.gob.renapo.registrocivil.catalogos.entity.CatMunicipio;
import mx.gob.renapo.registrocivil.comun.dao.GeneralDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 01:59
 * To change this template use File | Settings | File Templates.
 */
public interface CatColoniaLocalidadDAO extends GeneralDAO<CatInegiLocalidad> {

    List<CatInegiLocalidad> findAllByMunicipio(CatInegiMunicipio municipio);
}
