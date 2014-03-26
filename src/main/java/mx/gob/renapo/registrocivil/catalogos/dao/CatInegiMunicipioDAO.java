package mx.gob.renapo.registrocivil.catalogos.dao;

import java.util.List;

import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiMunicipio;
import mx.gob.renapo.registrocivil.comun.dao.GeneralDAO;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 23/03/14
 * Time: 01:28
 * To change this template use File | Settings | File Templates.
 */
public interface CatInegiMunicipioDAO extends GeneralDAO<CatInegiMunicipio> {
	
	List<CatInegiMunicipio> recuperaMunicipiosPorEstado(CatInegiEstado estado);

}
