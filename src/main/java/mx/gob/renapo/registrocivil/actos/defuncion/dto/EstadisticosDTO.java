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

@Data
public class EstadisticosDTO {

    private Boolean tuvoAsistenciaMedica;
    private CatLugarFallece dondeFallecio;
    private CatEscolaridadDTO escolaridad;
    private CatSituacionLaboral situacionLaboral;
    private CatPuestoDTO posicionTrabajo;


}
