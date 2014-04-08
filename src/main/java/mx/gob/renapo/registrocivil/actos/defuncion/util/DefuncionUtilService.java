package mx.gob.renapo.registrocivil.actos.defuncion.util;

import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;
import mx.gob.renapo.registrocivil.actos.defuncion.entity.Defuncion;

/**
 * Created with IntelliJ IDEA.
 * User: fase1_16
 * Date: 8/04/14
 * Time: 02:36 AM
 * To change this template use File | Settings | File Templates.
 */
public interface DefuncionUtilService {

    DefuncionDTO mapearEntityDefuncionADTO(Defuncion defuncionEntity);
}
