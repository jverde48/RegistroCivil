package mx.gob.renapo.registrocivil.catalogos.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.gob.renapo.registrocivil.catalogos.dao.CatInegiMunicipioDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiMunicipio;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 01:29
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class CatInegiMunicipioDAOImpl extends GeneralDAOImpl<CatInegiMunicipio> 
implements CatInegiMunicipioDAO {

	@Override
	public List<CatInegiMunicipio> recuperaMunicipiosPorEstado(
			CatInegiEstado estado) {
		
		Session session = getSession();
		Criteria criteria = null;
		Map<String, CatInegiEstado> restricciones = new HashMap<String, CatInegiEstado>();
		List<CatInegiMunicipio> listaMunicipios = new ArrayList<CatInegiMunicipio>();
		
		try {
			session.beginTransaction();
			criteria = session.createCriteria(CatInegiMunicipio.class);
			restricciones.put("estado", estado);
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
