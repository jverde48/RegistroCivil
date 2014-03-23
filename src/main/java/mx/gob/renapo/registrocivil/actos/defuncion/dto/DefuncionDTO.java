package mx.gob.renapo.registrocivil.actos.defuncion.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 02:44 PM
 * To change this template use File | Settings | File Templates.
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.dto.CatalogoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import javax.persistence.*;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class DefuncionDTO {

    /**
     * Propiedades de PersonaDTOs que forman parte del acto de nacimiento
     */
    private PersonaDTO finado;
    private PersonaDTO conyuge;
    private PersonaDTO progenitorUno;
    private PersonaDTO progenitorDos;
    private PersonaDTO declarante;
    private ActaDefuncionDTO datosFallecimiento;
    private PersonaDTO testigoUno;
    private PersonaDTO testigoDos;
    private ActaDTO acta;
    private EstadisticosDTO estadisticos;

}
