package mx.gob.renapo.registrocivil.catalogos.dao.impl;

import mx.gob.renapo.registrocivil.catalogos.dao.CatPaisDAO;
import mx.gob.renapo.registrocivil.catalogos.service.CatPaisService;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPais;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/20/14
 * Time: 1:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CatPaisDAOImpl extends GeneralDAOImpl<CatPais> implements CatPaisDAO {


    @Override
    public CatPais findMexico() {
        Session session = getSession();
        Criteria criteria = null;
        CatPais pais = null;

        try {
            session.beginTransaction();
            criteria = session.createCriteria(CatPais.class);
            criteria.add( Restrictions.eq("descripcion", "MEXICO"));
            Criterion criteriaMexicoCamel = Restrictions.eq("descripcion", "Mexico");
            Criterion criteriaMexicoAcentoMayus = Restrictions.eq("descripcion", "M\\u00C9XICO");
            Criterion criteriaMexicoAcentoMinus = Restrictions.eq("descripcion", "M\\u00e9xico");

            criteria.add(Restrictions.or(criteriaMexicoAcentoMayus,
                    criteriaMexicoCamel,criteriaMexicoAcentoMinus));

            pais = (CatPais) criteria.uniqueResult();

        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return pais;
    }
}
