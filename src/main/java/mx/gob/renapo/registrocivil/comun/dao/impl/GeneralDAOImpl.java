package mx.gob.renapo.registrocivil.comun.dao.impl;

import mx.gob.renapo.registrocivil.actos.adopcion.entity.Adopcion;
import mx.gob.renapo.registrocivil.actos.defuncion.entity.Defuncion;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.actos.reconocimiento.entity.Reconocimiento;
import mx.gob.renapo.registrocivil.comun.dao.GeneralDAO;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import javax.transaction.Transactional;
import java.util.List;
import org.apache.log4j.Logger;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

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
    public T guardarRegistro(T entidad) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.save(entidad);
            session.getTransaction().commit();
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

    /**
     * Metodo para editar un registro
     * @param entidad parametro con la entidad a editar
     */
    @Transactional
    public T editarRegistro(T entidad) throws Exception{
        Session session = getSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(entidad);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            session.getTransaction().rollback();
            throw  e;
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
    public T borrarRegistro(T entidad) throws Exception{
        Session session = getSession();

        try {
            session.beginTransaction();
            session.update(entidad);
            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            session.getTransaction().rollback();
            throw e;
        }
        finally {
            session.close();
        }
        return entidad;
    }

    public T recuperarRegistro(Long id) throws Exception{
        Session session = getSession();
        Criteria criteria = null;
        T resultado = null;
        try {
            session.beginTransaction();
            criteria = session.createCriteria(getPersistentClass());
            criteria.add(Restrictions.idEq(id));
            resultado = (T)criteria.uniqueResult();
        }catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
            throw e;
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
    public List<T> listarRegistros() throws Exception{
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
            throw e;
        }
        finally {
            session.close();
        }
        return lista;
    }

    /**
     * Metodo que recupera un acto por algun parametro que se le envie y un valor de tipo String
     * la regla de negocio indica que debería encontrar solo un registro, pero se regresa una lista
     * por alguna inconcistencia en los datos en la BBDD
     * @param valor
     * @return devuelve el valor del acto consultado
     * @throws Exception
     */
    public List <T> consultaActaCadena(String valor) throws Exception {
        List <T> resultados = null;
        Session session = getSession();
        Criteria criteria = null;

        try {
            session.beginTransaction();
            criteria = session.createCriteria(getPersistentClass());
            criteria.add(Restrictions.eq("cadena", valor));
            resultados = criteria.list();

        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            session.close();
        }
        return resultados;
    }

    public List <T> consultaActaNumeroActaAnioRegistro(Integer anio, String numActa)
            throws Exception {
        List<T> resultadosConsulta = null;
        List<T> resultados = null;
        Session session = getSession();
        Criteria criteria = null;
        try {
            session.beginTransaction();
            criteria = session.createCriteria(getPersistentClass());
            criteria.add(Restrictions.eq("numActa", numActa));
            resultadosConsulta = criteria.list();
            if(resultadosConsulta!=null || !resultadosConsulta.isEmpty()) {
                resultados =  new ArrayList<T>();
                for(T acta: resultadosConsulta) {
                    if(getPersistentClass()== Nacimiento.class) {
                        if(((Nacimiento)acta).getFechaRegistro().getYear()==anio) {
                            resultados.add(acta);
                        }
                    }
                    else if(getPersistentClass() == Matrimonio.class) {
                        if(((Matrimonio)acta).getFechaRegistro().getYear()==anio) {
                            resultados.add(acta);
                        }
                    }
                    else if(getPersistentClass() == Defuncion.class) {
                        if(((Defuncion)acta).getFechaRegistro().getYear()==anio) {
                            resultados.add(acta);
                        }
                    }
                    else if(getPersistentClass() == Divorcio.class) {
                        if(((Divorcio)acta).getFechaRegistro().getYear()==anio) {
                            resultados.add(acta);
                        }
                    }
                    else if(getPersistentClass() == Reconocimiento.class) {
                        if(((Reconocimiento)acta).getFechaRegistro().getYear()==anio) {
                            resultados.add(acta);
                        }
                    }
                    else if(getPersistentClass() == Adopcion.class) {
                        if(((Adopcion)acta).getFechaRegistro().getYear()==anio) {
                            resultados.add(acta);
                        }
                    }
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        finally {
            session.close();
        }

        return resultados;
    }


}
