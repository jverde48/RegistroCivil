package mx.gob.renapo.registrocivil.actos.nacimiento.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.dto.CatCompareceDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatalogoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/9/14
 * Time: 6:10 PM
 * DTO de Nacimiiento
 */
@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class NacimientoDTO {

    /**
     * Propiedades que forman parte de la informacion del acta
     */
    @Autowired
    private ActaNacimientoDTO actaNacimiento;

    private  Boolean cambioApellido;

    //Se guarda ruta de archivo
    private String imArchivo;

    /**
     * Propiedades de PersonaDTOs que forman parte del acto de nacimiento
     */
    @Autowired
    private PersonaDTO registrado;

    @Autowired
    private PersonaDTO progenitorUno;

    @Autowired
    private PersonaDTO progenitorDos;

    @Autowired
    private PersonaDTO abueloUnoProgenitorUno;

    @Autowired
    private PersonaDTO abuelaUnoProgenitorDos;

    @Autowired
    private PersonaDTO abueloDosProgenitorUno;

    @Autowired
    private PersonaDTO abueloDosProgenitorDos;

    @Autowired
    private PersonaDTO testigoUno;

    @Autowired
    private PersonaDTO testigoDos;

    @Autowired
    private PersonaDTO personaDistintaComparece;

    private String sello;

    private String selloImg;

    private String transcripcion;

    private Boolean vacunado;
    
    private Long id;

    private CatCompareceDTO compareceDTO;

    @Autowired
    private EstadisticosDTO datosEstadisticos;

    private Date horaNacRegistrado;

    private String mensajeError;

    private Integer codigoError;

    private boolean registroNormal;
    private boolean registroHistorico;
    private boolean registroEspecial;


}
