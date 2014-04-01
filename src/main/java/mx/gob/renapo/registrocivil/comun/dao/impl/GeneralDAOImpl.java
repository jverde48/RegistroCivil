package mx.gob.renapo.registrocivil.comun.dao.impl;

import mx.gob.renapo.registrocivil.comun.dao.GeneralDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import javax.transaction.Transactional;
import java.util.List;
import org.apache.log4j.Logger;
import java.lang.reflect.ParameterizedType;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/5/14
 * Time: 1:45 AM
 * DAO generico con las operaciones CRUD
 */
public abstract class GeneralDAOImpl<T> implements GeneralDAO<T> {

    private static Logger logger = Logger.getLogger(GeneralDAOImpl.class);

    private Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;


    protected Session getSession() {
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
    public T guardarRegistro(T entidad) {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.save(entidad);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            session.getTransaction().rollback();
            return entidad;
        }
        finally {
            session.close();
        }
        return entidad;

    }

    /**
     * Metodo para editar un registro
     * @param entidad parametro con la entidad a editar
     */
    @Transactional
    public T editarRegistro(T entidad) {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(entidad);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            session.getTransaction().rollback();
            return entidad;
        }
        finally {
            session.close();
        }
        return entidad;
    }

    /**
     * Metodo para realizar un borrado logico de un registro
     * @param entidad
     */
    public T borrarRegistro(T entidad) {
        Session session = getSession();

        try {
            session.beginTransaction();
            session.update(entidad);
            session.getTransaction().commit();
        }catch (Exception e) {
            logger.info(e.getMessage());
            session.getTransaction().rollback();
            return entidad;
        }
        finally {
            session.close();
        }
        return entidad;
    }

    public T recuperarRegistro(Long id) {
        Session session = getSession();
        Criteria criteria = null;
        T resultado = null;
        try {
            session.beginTransaction();
            criteria = session.createCriteria(getPersistentClass());
            criteria.add(Restrictions.idEq(id));
            resultado = (T)criteria.uniqueResult();
        }catch (Exception e) {
            logger.info(e.getMessage());
        }
        finally {
            session.close();
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
        List<T> lista = null;
        try {
            session.beginTransaction();
            criteria = session.createCriteria(getPersistentClass());
            criteria.add(Restrictions.isNull("fechaBorrado"));
            lista = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return lista;
    }


}
