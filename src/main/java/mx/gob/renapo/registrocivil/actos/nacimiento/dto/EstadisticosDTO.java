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
    private CatalogoDTO escolaridadPadre;
    private CatalogoDTO situacionLaboralPadre;
    private CatalogoDTO puestoPadre;

    //Propiedades de datos estadisticos de la madre
    private CatalogoDTO escolaridadMadre;
    private CatalogoDTO situacionLaboralMadre;
    private CatalogoDTO puestoMadre;
    private CatalogoDTO atendioParto;
    private CatalogoDTO lugarAtencionParto;
    private Integer nacieronVivos;
    private Integer numParto;
    private CatalogoDTO tipoParto;
    private Integer vivenAun;
    private Integer vivenEnElMismoHogar;
    private CatalogoDTO estadoCivilMadre;

}
