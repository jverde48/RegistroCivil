package mx.gob.renapo.registrocivil.catalogos.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.gob.renapo.registrocivil.catalogos.dao.CatEstadoDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPais;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 18/03/14
 * Time: 19:57
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class CatEstadoDAOImpl extends GeneralDAOImpl<CatEstado> implements CatEstadoDAO {

	@Override
	public List<CatEstado> recuperarEstadosPorPais(CatPais pais) {
		 Session session = getSession();
	     Criteria criteria = null;
	     List<CatEstado> lista = null;
	     Map<String, CatPais> restricciones = new HashMap<String, CatPais>();
	     try {
	    	 restricciones.put("pais", pais);
	    	 session.beginTransaction();
	    	 criteria = session.createCriteria(CatEstado.class);
	    	 criteria.add(Restrictions.allEq(restricciones));
	    	 lista = criteria.list();
	    	 
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }	
	     finally {
	    	 session.close();
	     }
		return lista;
	}
}
