package mx.gob.renapo.registrocivil.catalogos.dao;

import mx.gob.renapo.registrocivil.catalogos.entity.CatMunicipio;
import mx.gob.renapo.registrocivil.catalogos.entity.CatOficialia;
import mx.gob.renapo.registrocivil.comun.dao.GeneralDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 04:39
 * To change this template use File | Settings | File Templates.
 */
public interface CatOficialiaDAO extends GeneralDAO<CatOficialia> {
    List<CatOficialia> findByMunicipio(CatMunicipio municipio);
    CatOficialia findOficialia(Long id);
}
