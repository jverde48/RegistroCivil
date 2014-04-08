package mx.gob.renapo.registrocivil.actos.matrimonio.service;

import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 21/03/14
 * Time: 12:38
 * To change this template use File | Settings | File Templates.
 */
public interface MatrimonioService {
    public MatrimonioDTO registrarMatrimonio(MatrimonioDTO matrimonio,
                    Integer consentimientoUno, Integer consentimientoDos);
}
