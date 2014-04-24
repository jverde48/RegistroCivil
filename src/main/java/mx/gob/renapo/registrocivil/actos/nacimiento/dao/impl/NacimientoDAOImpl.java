package mx.gob.renapo.registrocivil.actos.nacimiento.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import mx.gob.renapo.registrocivil.actos.nacimiento.dao.NacimientoDAO;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/5/14
 * Time: 7:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class NacimientoDAOImpl extends GeneralDAOImpl<Nacimiento> implements NacimientoDAO {


}
