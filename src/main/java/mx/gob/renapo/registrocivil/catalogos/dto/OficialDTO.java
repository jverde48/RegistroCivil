package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 1:43 PM
 * DTO de oficial
 */
@Data
public class OficialDTO {

    private Long id;
    private String nombre;
    private Integer numeroOficial;
    private OficialiaDTO oficialia;

}
