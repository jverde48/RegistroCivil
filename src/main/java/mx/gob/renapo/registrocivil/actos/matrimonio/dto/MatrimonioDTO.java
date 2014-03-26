package mx.gob.renapo.registrocivil.actos.matrimonio.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatParentescoDTO;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 21/03/14
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */

@Data
@Component
public class MatrimonioDTO {

    /**
     * Contayentes
     */
    @Autowired
    private PersonaDTO contrayenteUno;
    @Autowired
    private PersonaDTO contrayenteDos;

    /**
     * Persona diferente de los padres que da consentimiento de
     * un matrimonio
     */
    @Autowired
    private PersonaDTO consentimientoContrayenteUno;

    @Autowired
    private PersonaDTO consentimientoContrayenteDos;

    /**
     * Padres de los contrayentes;
     */
    @Autowired
    private PersonaDTO progenitorUnoContrayenteUno;
    @Autowired
    private PersonaDTO progenitorUnoContrayenteDos;

    @Autowired
    private PersonaDTO progenitorDosContrayenteUno;
    @Autowired
    private PersonaDTO progenitorDosContrayenteDos;

    /**
     * Testigos
     */
    @Autowired
    private PersonaDTO testigoUno;
    @Autowired
    private PersonaDTO testigoDos;
    @Autowired
    private PersonaDTO testigoTres;
    @Autowired
    private PersonaDTO testigoCuatro;

    /**
     * Parentesco de testigos
     */
    @Autowired
    private CatParentescoDTO parentescoTestigoUno;

    @Autowired
    private CatParentescoDTO parentescoTestigoDos;

    @Autowired
    private CatParentescoDTO parentescoTestigoTres;

    @Autowired
    private CatParentescoDTO parentescoTestigoCuatro;

    /**
     * Datos Estadisticos del acto
     */
    @Autowired
    private EstadisticosMatrimonioDTO estadisticosDTO;

    /**
     * Datos del Acta de Matrimonio
     */
    @Autowired
    private ActaMatrimonioDTO actaMatrimonioDTO;
}