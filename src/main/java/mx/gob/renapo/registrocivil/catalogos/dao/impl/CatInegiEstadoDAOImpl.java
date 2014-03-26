package mx.gob.renapo.registrocivil.catalogos.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import mx.gob.renapo.registrocivil.catalogos.dao.CatInegiEstadoDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiPais;
import mx.gob.renapo.registrocivil.comun.dao.impl.GeneralDAOImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/23/14
 * Time: 1:32 AM
 * Implementacion del dao del catalogo de estado de inegi
 */
@Repository
public class CatInegiEstadoDAOImpl extends GeneralDAOImpl<CatInegiEstado>
        implements CatInegiEstadoDAO{

	@Override
	public List<CatInegiEstado> recuperaEstadoPorPais(CatInegiPais pais) {
		
		Session session = getSession();
		Criteria criteria = null;
		Map<String, CatInegiPais> restricciones = new HashMap<String, CatInegiPais>();
		List<CatInegiEstado> listaEstados = new ArrayList<CatInegiEstado>();
		try {
			session.beginTransaction();
			criteria = session.createCriteria(CatInegiEstado.class);
			restricciones.put("pais", pais);
			criteria.add(Restrictions.allEq(restricciones));
			listaEstados = criteria.list();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return listaEstados;
	}
}
