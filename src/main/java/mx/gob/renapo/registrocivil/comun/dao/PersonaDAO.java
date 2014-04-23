package mx.gob.renapo.registrocivil.comun.dao;

import mx.gob.renapo.registrocivil.comun.entity.Persona;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Green4
 * Date: 21/04/14
 * Time: 06:42 PM
 * To change this template use File | Settings | File Templates.
 */

public interface PersonaDAO extends GeneralDAO<Persona> {

    List<Persona> findByCurp(String curp);
    List<Persona> findByCadena(String cadena);
    List<Persona> findByDatosPersonales(HashMap<String, Object> datosPersonales);
}
