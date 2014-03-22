package mx.gob.renapo.registrocivil.actos.nacimiento.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 12:35 AM
 * DTO de datos estadisticos del acta de nacimiento
 */
@Data
@Component
public class EstadisticosDTO {

    //Propiedades de datos estadisticos del padre
    @Autowired
    private CatEscolaridadDTO escolaridadPadre;

    @Autowired
    private CatSituacionLaboralDTO situacionLaboralPadre;

    @Autowired
    private CatPuestoDTO puestoPadre;

    //Propiedades de datos estadisticos de la madre
    private Integer numParto;
    private Integer vivenAun;
    private Integer nacieronVivos;
    private Integer vivenEnElMismoHogar;

    @Autowired
    private CatEscolaridadDTO escolaridadMadre;

    @Autowired
    private CatSituacionLaboralDTO situacionLaboralMadre;

    @Autowired
    private CatPuestoDTO puestoMadre;

    @Autowired
    private CatAtendioPartoDTO atendioParto;

    @Autowired
    private CatLugarPartoDTO lugarAtencionParto;

    @Autowired
    private CatTipoPartoDTO tipoParto;

    @Autowired
    private CatEstadoCivilDTO estadoCivilMadre;

}
