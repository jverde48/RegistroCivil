package mx.gob.renapo.registrocivil.actos.defuncion.dao.impl;

/**
 * Created with IntelliJ IDEA.
 * User: fase1_16
 * Date: 20/03/14
 * Time: 07:37 PM
 * To change this template use File | Settings | File Templates.
 */

import mx.gob.renapo.registrocivil.actos.adopcion.entity.Adopcion;
import mx.gob.renapo.registrocivil.actos.defuncion.dao.DefuncionDAO;
import mx.gob.renapo.registrocivil.actos.defuncion.entity.Defuncion;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.actos.reconocimiento.entity.Reconocimiento;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;
import mx.gob.renapo.registrocivil.comun.dao.impl.TriggerDAOImpl;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class DefuncionDAOImpl extends GeneralDAOImpl<Defuncion> implements DefuncionDAO{

    private static Logger logger = Logger.getLogger(DefuncionDAOImpl.class);

    @Autowired
    private TriggerDAOImpl triggerDAO;

    @Override
    @Transactional
    public Defuncion guardarRegistro(Defuncion entidad) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.save(entidad);
            session.getTransaction().commit();
            if(entidad.getNacimiento()!=null) {
                triggerDAO.afectarNacimientoPorDefuncion(entidad.getNacimiento());
            }

        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
            throw e;
        }
        finally {
//            session.close();
        }
        return entidad;

    }

}
