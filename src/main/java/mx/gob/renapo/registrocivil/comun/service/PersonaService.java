package mx.gob.renapo.registrocivil.comun.service;

import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Green4
 * Date: 21/04/14
 * Time: 06:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PersonaService {

    public List<PersonaDTO> findByCurp (String curp);
    public List<PersonaDTO> findByCadena (String cadena);
    public List<PersonaDTO> findByDatosPersonales(HashMap<String, Object> datosPersonales);
    public PersonaDTO findById(Long id) throws Exception;
}
