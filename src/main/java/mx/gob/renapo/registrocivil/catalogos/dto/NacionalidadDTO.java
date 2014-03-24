package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 5:28 PM
 * DTO del catalogo de nacionalidad
 */
@Data
@Component
public class NacionalidadDTO {

    private Long id;
    private String nacionalidad;

    @Autowired
    private PaisDTO pais;

}
