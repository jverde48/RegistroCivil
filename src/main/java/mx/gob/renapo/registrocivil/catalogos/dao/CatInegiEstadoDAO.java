package mx.gob.renapo.registrocivil.catalogos.dao;

import java.util.List;

import mx.gob.renapo.registrocivil.comun.dao.GeneralDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiPais;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/23/14
 * Time: 1:26 AM
 * Interface del dao del catalogo de estado de inegi
 */
public interface CatInegiEstadoDAO extends GeneralDAO<CatInegiEstado>{
	
	List<CatInegiEstado> recuperaEstadoPorPais(CatInegiPais pais);
	
}
