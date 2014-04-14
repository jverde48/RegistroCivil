package mx.gob.renapo.registrocivil.actos.reconocimiento.util.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.entity.Reconocimiento;
import mx.gob.renapo.registrocivil.actos.reconocimiento.util.ReconocimientoUtilService;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: G3ra
 * Date: 8/04/14
 * Time: 07:02 PM
 * To change this template use File | Settings | File Templates.
 */

@Data
@Service
public class ReconocimientoUtilServiceImpl implements ReconocimientoUtilService {

    @Autowired
    private UtileriaService utileriaService;

    public ReconocimientoDTO mapeaEntityReconocimientoDTO(Reconocimiento reconocimiento,Integer personaConsentimiento) {

        ReconocimientoDTO reconocimientoDTO = new ReconocimientoDTO();

        //Personas para el detalle de Reconocimiento

        reconocimientoDTO.setReconocido(utileriaService.mapearEntityDTOPersona(reconocimiento.getReconocido()));
        reconocimientoDTO.setReconocedor(utileriaService.mapearEntityDTOPersona(reconocimiento.getReconocedor()));

        reconocimientoDTO.setAbueloUnoProgenitor(utileriaService.mapearEntityDTOPersona
                (reconocimiento.getProgenitorUnoReconocedor()));
        reconocimientoDTO.setAbueloDosProgenitor(utileriaService.mapearEntityDTOPersona
                (reconocimiento.getProgenitorDosReconocedor()));

        if(personaConsentimiento.equals(4)){
            reconocimientoDTO.setPersonaConsentimiento(utileriaService.mapearEntityDTOPersona
                    (reconocimiento.getPersonaConsen()));
        }

        reconocimientoDTO.setTestigoUno(utileriaService.mapearEntityDTOPersona(reconocimiento.getTestigoUno()));
        reconocimientoDTO.setTestigoDos(utileriaService.mapearEntityDTOPersona(reconocimiento.getTestigoDos()));

        reconocimientoDTO.setCodigoRespuesta(0);

        return reconocimientoDTO;
    }
}
