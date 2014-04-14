package mx.gob.renapo.registrocivil.actos.nacimiento.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatCompareceDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatParentescoDTO;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 12:51 AM
 * DTO del acto de nacimiento
 */
@Data
@Component
public class ActaNacimientoDTO extends ActaDTO {

    private Boolean vacunado;
    private String viveCon;
    private Date horaNacRegistrado;
    private char vivoMuerto;
    private CatParentescoDTO parentescoPersonaDistintaComparece;

}
