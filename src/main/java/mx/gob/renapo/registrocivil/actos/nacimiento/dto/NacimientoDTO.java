package mx.gob.renapo.registrocivil.actos.nacimiento.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
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
@EqualsAndHashCode(callSuper=false)
public class NacimientoDTO {

    /**
     * Propiedades que forman parte de la informacion del acta
     */
    private Integer actaBis;

    private String cadena;

    private  Boolean cambioApellido;

    private CatComparece comparece;

    private String crip;

    private CatEscolaridad escolaridadMadre;

    private CatEscolaridad escolaridadPadre;

    private Date fechaRegistro;

    private String foja;

    private String libro;

    private String tomo;

    private Date horaNacRegistrado;

    //TODO verificar generacion de GUID

    //Se guarda ruta de archivo
    private String imArchivo;

    private CatInegiLocalidad localidadRegistro;

    private CatLugarParto lugarAtencionParto;

    private CatAtendioParto atendioParto;

    private Integer nacieronVivos;

    private String nombreOficial;

    private Integer numActaNacimiento;

    private Integer numParto;

    private CatOficialia oficialia;


    /**
     * Propiedades de PersonaDTOs que forman parte del acto de nacimiento
     */
    private PersonaDTO registrado;

    private PersonaDTO progenitorUno;

    private PersonaDTO progenitorDos;

    private PersonaDTO abueloUnoProgenitorUno;

    private PersonaDTO abuelaUnoProgenitorDos;

    private PersonaDTO abueloDosProgenitorUno;

    private PersonaDTO abueloDosProgenitorDos;

    private PersonaDTO testigoUno;

    private PersonaDTO testigoDos;

    private PersonaDTO PersonaDTODistintaComparece;

    private CatParentesco parentPersonaDTODistintaPresenta;

    private CatPuesto posicionTrabajoMadre;

    private CatPuesto posicionTrabajoPadre;

    private String sello;

    private String selloImg;

    private CatSituacionLaboral situacionLaboralMadre;

    private CatSituacionLaboral situacionLaboralpadre;

    private CatTipoDocumento tipoDocumento;

    private CatTipoOperacion tipoOperacion;

    private CatTipoParto tipoParto;

    private String transcripcion;

    private Boolean vacunado;

    //TODO verificar informacion de vive con  (se va a hacer referencia a paretesco)
    private Integer viven;




}
