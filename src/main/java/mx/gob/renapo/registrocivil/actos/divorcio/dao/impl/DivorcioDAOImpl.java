package mx.gob.renapo.registrocivil.actos.divorcio.dao.impl;

import org.springframework.stereotype.Repository;

import mx.gob.renapo.registrocivil.actos.divorcio.dao.DivorcioDAO;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;

@Repository
public class DivorcioDAOImpl extends GeneralDAOImpl<Divorcio> implements DivorcioDAO {

}
