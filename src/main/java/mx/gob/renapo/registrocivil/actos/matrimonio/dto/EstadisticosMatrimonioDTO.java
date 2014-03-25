package mx.gob.renapo.registrocivil.actos.matrimonio.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatEscolaridadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatPuestoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatSituacionLaboralDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 21/03/14
 * Time: 13:24
 * To change this template use File | Settings | File Templates.
 */
@Data
@Component
public class EstadisticosMatrimonioDTO {

    /**
     * Datos estadisiticos de los contayentes
     */
    @Autowired
    private CatSituacionLaboralDTO situacionLaboralDTOContrayenteUno;

    @Autowired
    private CatSituacionLaboralDTO situacionLaboralDTOContrayenteDos;

    @Autowired
    private CatPuestoDTO puestoDTOContrayenteUno;

    @Autowired
    private CatPuestoDTO puestoDTOContrayenteDos;

    @Autowired
    private CatEscolaridadDTO escolaridadContrayenteUno;


    @Autowired
    private CatEscolaridadDTO escolaridadContrayenteDos;

    /**
     * Datos estadicos de la persona que daconsentimiento en un matrimonio
     */

    @Autowired
    private CatPuestoDTO puestoDTOConsentimientoContrayenteUno;

    @Autowired
    private CatPuestoDTO puestoDTOConsentimientoContrayenteDos;

    /**
     * Datos estadicos de los padres de los contrayentes
     */

    @Autowired
    private CatPuestoDTO puestoDTOProgenitorUnoContrayenteUno;

    @Autowired
    private CatPuestoDTO puestoDTOProgenitorDosContrayenteUno;

    @Autowired
    private CatPuestoDTO puestoDTOProgenitorUnoContrayenteDos;

    @Autowired
    private CatPuestoDTO puestoDTOProgenitorDosContrayenteDos;

    /**
     * Datos estadicos de los padres de los contrayentes
     */

    @Autowired
    private CatPuestoDTO puestoDTOTestigoUno;

    @Autowired
    private CatPuestoDTO puestoDTOTestigoDos;

    @Autowired
    private CatPuestoDTO puestoDTOTestigoTres;

    @Autowired
    private CatPuestoDTO puestoDTOTestigoCuatro;

}
