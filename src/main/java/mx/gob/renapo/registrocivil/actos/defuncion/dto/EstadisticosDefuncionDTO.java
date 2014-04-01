package mx.gob.renapo.registrocivil.actos.defuncion.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 05:23 PM
 * To change this template use File | Settings | File Templates.
 */

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class EstadisticosDefuncionDTO {

    private Boolean tuvoAsistenciaMedica;

    @Autowired
    private CatLugarFalleceDTO dondeFallecio;

    @Autowired
    private CatEscolaridadDTO escolaridad;

    @Autowired
    private CatSituacionLaboralDTO situacionLaboral;

    @Autowired
    private CatPuestoDTO posicionTrabajo;

}
