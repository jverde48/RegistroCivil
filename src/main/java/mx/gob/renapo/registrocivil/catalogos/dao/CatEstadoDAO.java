package mx.gob.renapo.registrocivil.catalogos.dao;

import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatPais;
import mx.gob.renapo.registrocivil.comun.dao.GeneralDAO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 18/03/14
 * Time: 19:56
 * To change this template use File | Settings | File Templates.
 */
public interface CatEstadoDAO extends GeneralDAO<CatEstado> {
	
	List<CatEstado> recuperarEstadosPorPais(CatPais pais);

}
