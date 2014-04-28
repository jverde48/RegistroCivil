package mx.gob.renapo.registrocivil.comun.dao;

import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.comun.entity.Persona;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 4/27/14
 * Time: 9:53 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TriggerDAO<T> {

    Nacimiento afectarNacimientoPorDefuncion(Nacimiento nacimiento) throws Exception;
    Nacimiento afectarNacimientoPorReconocimientoAdopcion(Nacimiento nacimiento) throws Exception;
    Matrimonio afectarMatrimonioPorDivorcion(Divorcio divorcio) throws Exception;
    Matrimonio actualizaEstadoCivilContrayentesMatrimonio(Matrimonio matrimonio) throws Exception;

}
