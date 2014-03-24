package mx.gob.renapo.registrocivil.actos.defuncion.service;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 07:50 PM
 * To change this template use File | Settings | File Templates.
 */

import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;

public interface DefuncionService {

    /**
     * Metodo para el registro de un nuevo nacimiento
     * @param defuncionDTO
     */
    void guardarDefuncion(DefuncionDTO defuncionDTO);

    /**
     * Metodo para la edicion de un nacimiento
     * @param defuncionDTO
     */
    void editarDefuncion(DefuncionDTO defuncionDTO);

}
