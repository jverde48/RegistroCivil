package mx.gob.renapo.registrocivil.catalogos.dao;

import java.util.List;

import mx.gob.renapo.registrocivil.comun.dao.GeneralDAO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatMunicipio;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/20/14
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CatMunicipioDAO extends GeneralDAO<CatMunicipio> {
	
	List<CatMunicipio> recuperarMunicipiosPorEstado(CatEstado estado);

}
