package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: Aleandro Diaz Solis
 * Date: 3/13/14
 * Time: 2:02 PM
 * DTO dde Estado (Entidad Federativa), este DTO se puede utilizar t
 * anto para el catalogo de INEGI como el que maneja RENAPO
 */
@Data
public class EstadoDTO {

    private Long id;
    private Long idRenapo;
    private String nombreEstado;
    private PaisDTO pais;


}
