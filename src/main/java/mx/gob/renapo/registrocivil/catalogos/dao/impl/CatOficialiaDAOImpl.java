package mx.gob.renapo.registrocivil.catalogos.dao.impl;

import mx.gob.renapo.registrocivil.catalogos.dao.CatOficialiaDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatMunicipio;
import mx.gob.renapo.registrocivil.catalogos.entity.CatOficialia;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPais;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 04:39
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class CatOficialiaDAOImpl extends GeneralDAOImpl<CatOficialia> implements CatOficialiaDAO {

    @Override
    public List<CatOficialia> findByMunicipio(CatMunicipio municipio) {
        Session session = getSession();
        Criteria criteria = null;
        List<CatOficialia> lista = null;
        Map<String, CatMunicipio> restricciones = new HashMap<String, CatMunicipio>();
        try {
            restricciones.put("municipio", municipio);
            session.beginTransaction();
            criteria = session.createCriteria(CatOficialia.class);
            criteria.add(Restrictions.allEq(restricciones));

            lista = criteria.list();

            for (CatOficialia oficialia : lista) {
                Hibernate.initialize(oficialia.getMunicipio());
                Hibernate.initialize(oficialia.getMunicipio().getEstado());
                Hibernate.initialize(oficialia.getTipoOficialia());
                Hibernate.initialize(oficialia.getIdOficial());
            }

        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return lista;
    }

    @Override
    public CatOficialia findOficialia(Long id) {
        Session session = getSession();
        Criteria criteria = null;
        CatOficialia oficialia = null;
        try {
            session.beginTransaction();
            criteria = session.createCriteria(CatOficialia.class);
            criteria.add(Restrictions.idEq(id));
            oficialia = (CatOficialia) criteria.uniqueResult();

            Hibernate.initialize(oficialia.getMunicipio());
            Hibernate.initialize(oficialia.getMunicipio().getEstado());
            Hibernate.initialize(oficialia.getTipoOficialia());
            Hibernate.initialize(oficialia.getIdOficial());

        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return oficialia;
    }
}
