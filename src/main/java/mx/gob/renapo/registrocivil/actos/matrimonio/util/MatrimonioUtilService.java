package mx.gob.renapo.registrocivil.actos.matrimonio.util;

import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 07/04/14
 * Time: 16:32
 * To change this template use File | Settings | File Templates.
 */
public interface MatrimonioUtilService {

    MatrimonioDTO mapearEntityMatrimonioADTO(Matrimonio matrimonioEntity);
}
