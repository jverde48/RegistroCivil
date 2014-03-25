package mx.gob.renapo.registrocivil.comun.dto;

import java.util.Date;
import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * DTO de Acta con propiedades que aplican en al menos 3 actos
 */
@Data
@Component
public class ActaDTO {

    //Datos del Acta
    private Date fechaRegistro;
    private String numeroActa;
    private Integer actaBis;
    private String tomo;
    private String libro;
    private String foja;
    private String cadena;
    private String crip;
    private String anioRegistro;
    private String llaveOriginal;
    private Boolean estatusValidacion;
    private List<NotasMarginalesDTO> notasMarginales;

    @Autowired
    private EstadoDTO entidadRegistro;

    @Autowired
    private MunicipioDTO municipioRegistro;

    @Autowired
    private OficialiaDTO oficialia;

    @Autowired
    private LocalidadDTO localidadRegistro;

    @Autowired
    private CatTipoDocumentoDTO tipoDocumento;

    @Autowired
    private CatTipoOperacionDTO tipoOperacion;

    /**
     *Esta propiedad se refiere a la transcripcion cuando se trata de una inscripcion
     * y aplica para Nacimiento, Matrimonio y Defuncion
     */
    private StringBuilder transcripcion;


    public ActaDTO() {
    }

}
