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

    void guardarRegistro(T entidad);
    void editarRegistro(T entidad);
    void borrarRegistro(T entidad);
    Object recuperarRegistro(Long id);
    List <T> listarRegistros();


}
