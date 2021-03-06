package mx.gob.renapo.registrocivil.comun.dto;

import java.util.Date;
import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * DTO de Acta con propiedades que aplican en al menos 3 actos
 */
@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ActaDTO {

    //Datos del Acta
    private Date fechaRegistro;
    private String numeroActa;
    private Integer actaBis;
    private String tomo;
    private String libro;
    private String foja;
    private String cadena;
    private String anioRegistro;
    private String llaveOriginal;
    private Boolean estatusValidacion;//TODO PREREGISTGRO DE TABLA DE ACTOS
    private List<NotasMarginalesDTO> notasMarginales;//TODO NO SE HA REALIZADO LA TABLA
    private Date fechaBorrado;

    @Autowired
    private EstadoDTO entidadRegistro;

    @Autowired
    private MunicipioDTO municipioRegistro;

    @Autowired
    private OficialDTO  oficial;

    @Autowired
    private OficialiaDTO oficialia;

    @Autowired
    private LocalidadDTO localidadRegistro;

    private Integer tipoDocumento;

    private Integer tipoOperacion;

    /**
     *Esta propiedad se refiere a la transcripcion cuando se trata de una inscripcion
     * y aplica para Nacimiento, Matrimonio y Defuncion
     */
    private StringBuilder transcripcion;


    public ActaDTO() {
    }

}
