package mx.gob.renapo.registrocivil.actos.defuncion.service;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 07:50 PM
 * To change this template use File | Settings | File Templates.
 */

import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;

import java.util.List;

public interface DefuncionService {

    /**
     * Metodo para el registro de un nuevo nacimiento
     * @param defuncionDTO
     */
    //void guardarDefuncion(DefuncionDTO defuncionDTO);
    public DefuncionDTO guardarDefuncion(DefuncionDTO defuncionDTO, Boolean existenciaConyuge,
                                         Boolean existenciaProgenitorUno, Boolean existenciaProgenitorDos);

    /**
     * Metodo para la edicion de un defuncion
     * @param defuncionDTO
     */
    void editarDefuncion(DefuncionDTO defuncionDTO);


    /**
     * Metodo para consultar una defuncion por la cadena
     * @param cadena
     * @return DefuncionDTO
     */
    List<DefuncionDTO> consultaDefuncionPorCadena(String cadena);

    /**
     * Metodo para consltar una defuncion por su numero de acta
     * @param numeroActa
     * @param anio
     * @return DefuncionDTO
     */
    List<DefuncionDTO> consultaDefuncionPorNumeroActa(Integer anio, String numeroActa);

}
