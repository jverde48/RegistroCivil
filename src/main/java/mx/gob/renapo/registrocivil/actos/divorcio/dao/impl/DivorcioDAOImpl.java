package mx.gob.renapo.registrocivil.actos.divorcio.dao.impl;

import mx.gob.renapo.registrocivil.comun.dao.impl.TriggerDAOImpl;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mx.gob.renapo.registrocivil.actos.divorcio.dao.DivorcioDAO;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;

import javax.transaction.Transactional;

@Repository
public class DivorcioDAOImpl extends GeneralDAOImpl<Divorcio> implements DivorcioDAO {

    private static Logger logger = Logger.getLogger(DivorcioDAOImpl.class);

    @Autowired
    private TriggerDAOImpl triggerDAO;

    @Override
    /**
     * Metodo para guardar un registro en la BBDD
     * @param entidad parametro con la entidad a persistir
     */
    @Transactional
    public Divorcio guardarRegistro(Divorcio divorcio) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.save(divorcio);
            session.getTransaction().commit();
            triggerDAO.afectarMatrimonioPorDivorcion(divorcio);
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
            throw e;
        }
        finally {
//            session.close();
        }
        return divorcio;

    }



}
