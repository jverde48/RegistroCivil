package mx.gob.renapo.registrocivil.catalogos.dao.impl;

import mx.gob.renapo.registrocivil.catalogos.dao.CatEstadoCivilDAO;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstadoCivil;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/22/14
 * Time: 8:17 PM
 * implementacion del dao del catalogo de estado civil
 */
@Repository
public class CatEstadoCivilDAOImpl extends GeneralDAOImpl<CatEstadoCivil>
        implements CatEstadoCivilDAO{
}
