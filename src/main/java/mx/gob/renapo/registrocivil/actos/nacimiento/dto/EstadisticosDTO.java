package mx.gob.renapo.registrocivil.actos.nacimiento.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 12:35 AM
 * DTO de datos estadisticos del acta de nacimiento
 */
@Data
public class EstadisticosDTO {

    //Propiedades de datos estadisticos del padre
    private CatEscolaridadDTO escolaridadPadre;
    private CatSituacionLaboralDTO situacionLaboralPadre;
    private CatPuestoDTO puestoPadre;

    //Propiedades de datos estadisticos de la madre
    private CatEscolaridadDTO escolaridadMadre;
    private CatSituacionLaboralDTO situacionLaboralMadre;
    private CatPuestoDTO puestoMadre;
    private CatAtendioPartoDTO atendioParto;
    private CatLugarPartoDTO lugarAtencionParto;
    private Integer nacieronVivos;
    private Integer numParto;
    private CatTipoPartoDTO tipoParto;
    private Integer vivenAun;
    private Integer vivenEnElMismoHogar;
    private CatEstadoCivilDTO estadoCivilMadre;

}
