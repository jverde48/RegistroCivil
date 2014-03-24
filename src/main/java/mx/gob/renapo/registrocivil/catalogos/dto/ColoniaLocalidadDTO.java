package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 5:33 PM
 * DTO de Colonia/Localidad
 */
@Data
@Component
public class ColoniaLocalidadDTO {

    private Long id;
    private String nombreLocalidadColonia;

}
