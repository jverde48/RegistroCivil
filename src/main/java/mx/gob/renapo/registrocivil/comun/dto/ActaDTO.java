package mx.gob.renapo.registrocivil.comun.dto;

import java.util.Date;
import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoDocumento;
import mx.gob.renapo.registrocivil.catalogos.entity.CatTipoOperacion;
import java.util.List;

@Data
/**
 * DTO de Acta con propiedades que aplican en al menos 3 actos
 */
public class ActaDTO {

    //Datos del Acta
    private EstadoDTO entidadRegistro;
    private MunicipioDTO municipioRegistro;
    private OficialiaDTO oficialia;
    private Date fechaRegistro;
    private String numeroActa;
    private Integer actaBis;
    private String tomo;
    private String libro;
    private String foja;
    private ColoniaLocalidadDTO localidadRegistro;
    private String cadena;
    private String crip;
    private String anioRegistro;
    private String llaveOriginal;
    private List<NotasMarginalesDTO> notasMarginales;
    private CatTipoDocumentoDTO tipoDocumento;
    private CatTipoOperacionDTO tipoOperacion;
    private Boolean estatusValidacion;
    /**
     *Esta propiedad se refiere a la transcripcion cuando se trata de una inscripcion
     * y aplica para Nacimiento, Matrimonio y Defuncion
     */
    private StringBuilder transcripcion;


    public ActaDTO() {
    }

}
