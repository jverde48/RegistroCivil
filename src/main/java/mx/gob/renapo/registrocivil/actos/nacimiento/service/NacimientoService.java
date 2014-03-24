package mx.gob.renapo.registrocivil.actos.nacimiento.service;

import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/9/14
 * Time: 6:07 PM
 * Interface de service de nacimiento
 */
public interface NacimientoService {

    /**
     * Metodo para el registro de un nuevo nacimiento
     * @param nacimientoDTO
     */
    void guardarNacimiento(NacimientoDTO nacimientoDTO);

    /**
     * Metodo para la edicion de un nacimiento
     * @param nacimientoDTO
     */
    void editarNacimiento(NacimientoDTO nacimientoDTO);




}
