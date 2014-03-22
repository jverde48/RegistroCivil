package mx.gob.renapo.registrocivil.actos.nacimiento.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.dto.CatalogoDTO;
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
    private ActaNacimientoDTO actaNacimiento;

    private  Boolean cambioApellido;

    //Se guarda ruta de archivo
    private String imArchivo;

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

    private PersonaDTO PersonaDistintaComparece;

    private String sello;

    private String selloImg;

    private String transcripcion;

    private Boolean vacunado;

    private EstadisticosDTO datosEstadisticos;

    private Boolean vivoMuerto;

    private String horaNacRegistrado;


}
