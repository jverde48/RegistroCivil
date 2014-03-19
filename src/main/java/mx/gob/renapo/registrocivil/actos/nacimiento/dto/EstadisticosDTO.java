package mx.gob.renapo.registrocivil.actos.nacimiento.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatalogoDTO;
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
    private CatEscolaridad escolaridadPadre;
    private CatSituacionLaboral situacionLaboralPadre;
    private CatPuesto puestoPadre;

    //Propiedades de datos estadisticos de la madre
    private CatEscolaridad escolaridadMadre;
    private CatSituacionLaboral situacionLaboralMadre;
    private CatPuesto puestoMadre;
    private CatAtendioParto atendioParto;
    private CatLugarParto lugarAtencionParto;
    private Integer nacieronVivos;
    private Integer numParto;
    private CatTipoParto tipoParto;
    private Integer vivenAun;
    private Integer vivenEnElMismoHogar;
    private CatEstadoCivil estadoCivilMadre;

}
