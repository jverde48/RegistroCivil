package mx.gob.renapo.registrocivil.actos.defuncion.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 02:44 PM
 * To change this template use File | Settings | File Templates.
 */

import lombok.Data;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class DefuncionDTO {

    /**
     * Propiedades de PersonaDTOs que forman parte del acto de nacimiento
     */
    @Autowired
    private PersonaDTO finado;

    @Autowired
    private PersonaDTO conyuge;

    @Autowired
    private PersonaDTO progenitorUno;

    @Autowired
    private PersonaDTO progenitorDos;

    @Autowired
    private PersonaDTO declarante;

    @Autowired
    private ActaDefuncionDTO datosFallecimiento;

    @Autowired
    private PersonaDTO testigoUno;

    @Autowired
    private PersonaDTO testigoDos;

    @Autowired
    private ActaDTO actaDTO;

    @Autowired
    private EstadisticosDefuncionDTO estadisticos;

    /**
     * Para saber si ocurrio una excepcion al guardar,
     * aactualizar o eliminar el registro.
     * 0 exitoso.
     * 1 excepcion
     */
    private Integer codigoRespuesta;
    private String mensajeError;
    private Integer codigoError;

    private boolean isNormal;
    private boolean isHistorico;
    private boolean isEspecial;

}
