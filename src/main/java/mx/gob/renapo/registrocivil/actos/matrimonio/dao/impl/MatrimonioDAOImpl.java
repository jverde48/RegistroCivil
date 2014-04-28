package mx.gob.renapo.registrocivil.actos.matrimonio.dao.impl;

import mx.gob.renapo.registrocivil.actos.matrimonio.dao.MatrimonioDAO;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;
import mx.gob.renapo.registrocivil.comun.dao.impl.TriggerDAOImpl;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 21/03/14
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class MatrimonioDAOImpl extends GeneralDAOImpl<Matrimonio> implements MatrimonioDAO {

    private static Logger logger = Logger.getLogger(MatrimonioDAOImpl.class);

    @Autowired
    private TriggerDAOImpl triggerDAO;


    @Override
    /**
     * Metodo para guardar un registro en la BBDD
     * @param entidad parametro con la entidad a persistir
     */
    @Transactional
    public Matrimonio guardarRegistro(Matrimonio matrimonio) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.save(matrimonio);
            session.getTransaction().commit();
            triggerDAO.actualizaEstadoCivilContrayentesMatrimonio(matrimonio);

        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
            throw e;
        }
        finally {
//            session.close();
        }
        return matrimonio;

    }


}
