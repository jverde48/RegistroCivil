package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 1:43 PM
 * DTO de oficial
 */
@Data
@Component
public class OficialDTO {

    private Long id;
    private String nombre;
    private Integer numeroOficial;

    @Autowired
    private OficialiaDTO oficialia;

}
