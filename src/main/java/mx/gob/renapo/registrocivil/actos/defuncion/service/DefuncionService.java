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
    public DefuncionDTO guardarDefuncion(DefuncionDTO defuncionDTO, Boolean existenciaConyuge,
                                         Boolean existenciaProgenitorUno, Boolean existenciaProgenitorDos);

     /**
     * Metodo para consultar una defuncion por la cadena
     * @param cadena
     * @return DefuncionDTO
     */
     public List<DefuncionDTO> consultaPorCadena(String cadena)throws Exception;

    /**
     * Metodo para consltar una defuncion por su numero de acta
     * @param numeroActa
     * @param anioRegistro
     * @return DefuncionDTO
     */
    List<DefuncionDTO> consultaPorNumeroActa(
            String numeroActa, Integer anioRegistro) throws Exception;


    /**
     * Metodo para eliminar una defuncion por ID
     * @param idDefuncion
     * @return DefuncionDTO
     */
    public void eliminarActoDefuncion(Long idDefuncion);

}
