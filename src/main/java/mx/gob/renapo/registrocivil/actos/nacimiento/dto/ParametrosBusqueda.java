package mx.gob.renapo.registrocivil.actos.nacimiento.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 4/27/14
 * Time: 6:02 PM
 * Clase que se utiliza para los parametros de busqueda del acta de nacimiento
 */
@Data
@Component
public class ParametrosBusqueda {

    private List<NacimientoDTO> nacimientos;
    private String cadena;
    private String numeroActa;
    private Integer anioRegistro;

}
