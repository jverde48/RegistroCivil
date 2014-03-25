package mx.gob.renapo.registrocivil.catalogos.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.gob.renapo.registrocivil.catalogos.dao.CatMunicipioDAO;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatMunicipio;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/20/14
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CatMunicipioDAOImpl extends GeneralDAOImpl<CatMunicipio>
        implements CatMunicipioDAO{

	@Override
	public List<CatMunicipio> recuperarMunicipiosPorEstado(CatEstado estado) {
		
		 Session session = getSession();
	     Criteria criteria = null;
	     List<CatMunicipio> listaMunicipios = null;
	     Map<String, CatEstado> restricciones = new HashMap<String, CatEstado>();
	     
	     try {
	    	restricciones.put("estado", estado); 
	    	session.beginTransaction();
	    	criteria = session.createCriteria(CatMunicipio.class);
	    	criteria.add(Restrictions.allEq(restricciones));
	    	listaMunicipios = criteria.list();
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     finally {
	    	 session.close();
	     }
	     
		return listaMunicipios;
	}



}
