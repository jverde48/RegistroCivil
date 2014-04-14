package mx.gob.renapo.registrocivil.actos.reconocimiento.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.dto.CatParentescoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatalogoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.dto.DomicilioDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Data
@Component
public class ReconocimientoDTO {



    @Autowired
    private PersonaDTO reconocido;

    @Autowired
    private PersonaDTO reconocedor;

    @Autowired
    private PersonaDTO testigoUno;

    @Autowired
    private PersonaDTO testigoDos;

    @Autowired
    private ActaReconocimientoDTO  actaNacimientoReconocido;

    @Autowired
    private ActaDTO actaDTO;

    @Autowired
    private PersonaDTO abueloUnoProgenitor;

    @Autowired
    private PersonaDTO abueloDosProgenitor;

    @Autowired
    private PersonaDTO personaConsentimiento;

    @Autowired
    private CatParentescoDTO parentescoConsentimientoPersonaDTO;

    /**
     * Para saber si ocurrio una excepcion al guardar,
     * aactualizar o eliminar el registro.
     * 0 exitoso.
     * 1 excepcion
     */
    private Integer codigoRespuesta;
    private String mensajeError;

}
