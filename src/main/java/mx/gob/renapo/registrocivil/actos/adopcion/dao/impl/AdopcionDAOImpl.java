package mx.gob.renapo.registrocivil.actos.adopcion.dao.impl;

import mx.gob.renapo.registrocivil.actos.adopcion.dao.AdopcionDAO;
import mx.gob.renapo.registrocivil.actos.adopcion.entity.Adopcion;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;
import org.springframework.stereotype.Repository;

@Repository
public class AdopcionDAOImpl extends GeneralDAOImpl<Adopcion> implements AdopcionDAO{
}
