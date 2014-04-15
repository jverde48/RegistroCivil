package mx.gob.renapo.registrocivil.actos.sentencia.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoSentenciaDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoSentencia;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;


/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 8/04/14
 * Time: 04:09 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class SentenciaDTO {

    //Propiedades de personasDTO de sentencia

    @Autowired
    private PersonaDTO declarante;

    @Autowired
    private PersonaDTO titular;

    @Autowired
    private PersonaDTO registrado;

    @Autowired
    private PersonaDTO responsable;


    private ActaDTO acta;

    private CatTipoSentenciaDTO tipoSentenciaDTO;



}
