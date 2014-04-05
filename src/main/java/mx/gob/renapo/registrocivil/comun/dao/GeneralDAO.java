package mx.gob.renapo.registrocivil.comun.dao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/4/14
 * Time: 1:47 PM
 * Interface para DAO generico
 */
public interface GeneralDAO <T>{

    T guardarRegistro(T entidad) throws Exception;
    T editarRegistro(T entidad) throws Exception;
    T borrarRegistro(T entidad) throws Exception;
    T recuperarRegistro(Long id) throws Exception;
    List <T> listarRegistros() throws  Exception;


}
