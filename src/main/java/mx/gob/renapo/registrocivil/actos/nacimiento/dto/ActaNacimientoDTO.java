package mx.gob.renapo.registrocivil.actos.nacimiento.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatalogoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatComparece;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 12:51 AM
 * DTO del acto de nacimiento
 */
@Data
public class ActaNacimientoDTO extends ActaDTO {

    private Boolean vacunado;
    private String viveCon;
    private CatComparece comparece;
    private Date horaNacRegistrado;
    private Integer vivoMuerto;

}
