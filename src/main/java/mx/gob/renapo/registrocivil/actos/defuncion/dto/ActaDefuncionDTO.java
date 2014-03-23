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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class ActaDefuncionDTO {

    private Date fechaDefuncion;
    private Date horaFallecimiento;
    private String numeroCertificadoDefuncion;

    @Autowired
    private DomicilioDTO domicilioOcurrioFallecimiento;
    private String causasDefuncion;
    private String nombreMedico;
    private String cedulaProfesionalMedico;
    private String domicilioMedico;
    private String nombreDestinoPanteon;

    @Autowired
    private CatDestinoCadaverDTO destinoCadaver;
    private String domicilioPanteon;
    private Integer noOrden;


}
