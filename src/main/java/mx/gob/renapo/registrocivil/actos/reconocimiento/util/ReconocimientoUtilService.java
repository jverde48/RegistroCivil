package mx.gob.renapo.registrocivil.actos.reconocimiento.util;

import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.entity.Reconocimiento;

/**
 * Created with IntelliJ IDEA.
 * User: G3ra
 * Date: 8/04/14
 * Time: 07:01 PM
 * To change this template use File | Settings | File Templates.
 */

public interface ReconocimientoUtilService {

    ReconocimientoDTO mapeaEntityReconocimientoDTO(Reconocimiento reconocimiento);
}
