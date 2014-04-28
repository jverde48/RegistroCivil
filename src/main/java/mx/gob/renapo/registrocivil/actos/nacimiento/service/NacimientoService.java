package mx.gob.renapo.registrocivil.actos.nacimiento.service;

import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;

import java.util.List;

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
    NacimientoDTO guardarNacimiento
    (NacimientoDTO nacimientoDTO, Boolean abueloUnoProgenitorUno,
    Boolean abueloDosProgenitorUno, Boolean abueloUnoProgenitorDos,
    Boolean abueloDosProgenitorDos, Boolean madreSoltera, Integer comparece);

    /**
     * Metodo para la edicion de un nacimiento
     * @param nacimientoDTO
     */
    void editarNacimiento(NacimientoDTO nacimientoDTO) throws Exception;

    /**
     * Metodo para eliminar logicamente un registro de nacimiento
     * @param nacimientoDTO
     * @return
     */
    Integer borrarNacimiento(NacimientoDTO nacimientoDTO);

    /**
     * Metodo para recuperar un acta de nacimiento por el id
     * @param id
     * @return
     */
    NacimientoDTO recuperarActaNacimiento(Long id);

    /**
     * Metodo para consultar un nacimiento por la cadena
     * @param cadena
     * @return NacimientoDTO
     */
    List<NacimientoDTO> consultaNacimientoPorCadena(String cadena);

    /**
     * Metodo para consltar un nacimiento por su numero de acta
     * @param numeroActa
     * @param anio
     * @return NacimientoDTO
     */
    List<NacimientoDTO> consultaNacimientoPorNumeroActa(Integer anio, String numeroActa);




}
