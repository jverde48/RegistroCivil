package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 5:28 PM
 * DTO del catalogo de nacionalidad
 */
@Data
public class NacionalidadDTO {

    private Long id;
    private String nacionalidad;
    private PaisDTO pais;

}
