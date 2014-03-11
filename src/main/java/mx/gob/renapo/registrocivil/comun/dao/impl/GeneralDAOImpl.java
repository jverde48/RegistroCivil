package mx.gob.renapo.registrocivil.comun.dao.impl;

import mx.gob.renapo.registrocivil.comun.dao.GeneralDAO;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import javax.transaction.Transactional;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/5/14
 * Time: 1:45 AM
 * DAO generico con las operaciones CRUD
 */
public abstract class GeneralDAOImpl<T> implements GeneralDAO<T> {

    private static Logger logger = Logger.getLogger(GeneralDAOImpl.class);

    private Class persistentClass;

    @Autowired
    private SessionFactory sessionFactory;


    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     *
     */
    public GeneralDAOImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return this.persistentClass;
    }


    /**
     * Metodo para guardar un registro en la BBDD
     * @param entidad parametro con la entidad a persistir
     */
    @Transactional
    public void guardarRegistro(T entidad) {
        Session session = getSession();
        try {
            session.save(entidad);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            session.getTransaction().rollback();
        }

    }

    /**
     * Metodo para editar un registro
     * @param entidad parametro con la entidad a editar
     */
    @Transactional
    public void editarRegistro(T entidad) {
        Session session = getSession();
        try {
            session.saveOrUpdate(entidad);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            session.getTransaction().rollback();
        }
    }

    /**
     * Metodo para realizar un borrado logico de un registro
     * @param entidad
     */
    public void borrarRegistro(T entidad) {
        Session session = getSession();

        try {
            session.update(entidad);
            session.getTransaction().commit();
        }catch (Exception e) {
            logger.info(e.getMessage());
            session.getTransaction().rollback();
        }
    }

    public Object recuperarRegistro(Long id) {
        Session session = getSession();
        Criteria criteria = null;
        Object resultado = null;
        try {
            criteria = session.createCriteria(getPersistentClass());
            criteria.add(Restrictions.idEq(id));
            resultado = (Object)criteria.uniqueResult();
        }catch (Exception e) {
            logger.info(e.getMessage());
        }
        return resultado;
    }

    /**
     * Metodo para listar los registros de una tabla tomando como
     * criterio de filtrado, el borrado logico
     * @return
     */
    public List<T> listarRegistros() {
        Session session = getSession();
        Criteria criteria = null;
        List<Object> resultadosConsulta = null;
        try {
            criteria = session.createCriteria(getPersistentClass());
            criteria.add(Restrictions.eq("FECHA_BORRADO", null));
            resultadosConsulta = criteria.list();
        } catch (Exception e) {

        }

        return null;
    }


}
