package mx.gob.renapo.registrocivil.actos.divorcio.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatParentescoDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;

@Data
@Component
public class DivorcioDTO {
	/**
     * Propiedades que forman parte de la informacion del acta
     */
	@Autowired
	private ActaDivorcioDTO actaDivorcio;
	@Autowired
	private MatrimonioDTO actaMatrimonio;
	
	private Long id;
	
	//Se guarda ruta de archivo
    private String imArchivo;
    
    private String sello;

    private String selloImg;
	/**
     * Propiedades de PersonaDTOs que forman parte del acto de divorcio
     */
    @Autowired
    private PersonaDTO divorciadoUno;
    @Autowired
    private PersonaDTO divorciadoDos;
    @Autowired
    private PersonaDTO testigoUno;
    @Autowired
    private PersonaDTO testigoDos;
    @Autowired
    private EstadisticosDivorcioDTO datosEstadisticos;
    @Autowired
    private CatParentescoDTO parentescoTestigoUno;
    @Autowired
    private CatParentescoDTO parentescoTestigoDos;
    
    private Integer estatusRegistro;
    /**
     * Para saber si ocurrio una excepcion al guardar,
     * aactualizar o eliminar el registro.
     * 0 exitoso.
     * 1 excepcion
     */
    private Integer codigoRespuesta;
    private String mensajeError;
    private String tituloMensaje;


    /**
     * Para saber si el registro fue Normal,
     * Historico o Especial.
     */
    private boolean isNormal;
    private boolean isHistorico;
    private boolean isEspecial;
}
