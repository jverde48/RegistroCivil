package mx.gob.renapo.registrocivil.actos.defuncion.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 03:04 PM
 * To change this template use File | Settings | File Templates.
 */

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatCompareceDTO;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.comun.dto.DomicilioDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import java.util.Date;

@Data
public class ActaDefuncionDTO {

    private Date fechaDefuncion;
    private Date horaFallecimiento;
    private String numeroCertificadoDefuncion;
    private DomicilioDTO domicilioOcurrioFallecimiento;
    private String causasDefuncion;
    private String nombreMedico;
    private String cedulaProfesionalMedico;
    private String domicilioMedico;
    private String nombreDestinoPanteon;
    private CatDestinoCadaverDTO destinoCadaver;
    private String domicilioPanteon;
    private Integer noOrden;


}
