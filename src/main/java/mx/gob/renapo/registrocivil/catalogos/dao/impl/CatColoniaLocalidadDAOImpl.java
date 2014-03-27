package mx.gob.renapo.registrocivil.catalogos.dao.impl;

import mx.gob.renapo.registrocivil.catalogos.dao.CatColoniaLocalidadDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiLocalidad;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiMunicipio;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;
import org.hibernate.Criteria;
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
 * Time: 02:00
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class CatColoniaLocalidadDAOImpl extends GeneralDAOImpl<CatInegiLocalidad>
        implements CatColoniaLocalidadDAO {

    @Override
    public List<CatInegiLocalidad> findAllByMunicipio(CatInegiMunicipio municipio) {
        Session session = getSession();
        Criteria criteria = null;
        List<CatInegiLocalidad> listaLocalidades = null;
        Map<String, CatInegiMunicipio> restricciones = new HashMap<String, CatInegiMunicipio>();

        try {
            restricciones.put("municipio", municipio);
            session.beginTransaction();
            criteria = session.createCriteria(CatInegiLocalidad.class);
            criteria.add(Restrictions.allEq(restricciones));
            listaLocalidades = criteria.list();
        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return listaLocalidades;
    }
}
