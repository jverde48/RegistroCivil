package mx.gob.renapo.registrocivil.actos.reconocimiento.util.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ActaReconocimientoDTO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.entity.Reconocimiento;
import mx.gob.renapo.registrocivil.actos.reconocimiento.util.ReconocimientoUtilService;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

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

    public ReconocimientoDTO mapeaEntityReconocimientoDTO(Reconocimiento reconocimiento) {

        ReconocimientoDTO reconocimientoDTO = new ReconocimientoDTO();

        //Datos de un Acta de Reconocimiento

        reconocimientoDTO.setActaDTO(mapearDatosActa(reconocimiento));

        //Datos del Acta del Reconocido

        reconocimientoDTO.setActaNacimientoReconocido(mapearDatosActaReconocido(reconocimiento));

        //Personas para el detalle de Reconocimiento

        reconocimientoDTO.setReconocido(utileriaService.mapearEntityDTOPersona(reconocimiento.getReconocido()));
        reconocimientoDTO.setReconocedor(utileriaService.mapearEntityDTOPersona(reconocimiento.getReconocedor()));

        reconocimientoDTO.setAbueloUnoProgenitor(utileriaService.mapearEntityDTOPersona
                (reconocimiento.getProgenitorUnoReconocedor()));
        reconocimientoDTO.setAbueloDosProgenitor(utileriaService.mapearEntityDTOPersona
                (reconocimiento.getProgenitorDosReconocedor()));

        if(reconocimientoDTO.getPersonaConsentimiento()!=null){
            reconocimientoDTO.setPersonaConsentimiento(utileriaService.mapearEntityDTOPersona
                    (reconocimiento.getPersonaConsen()));
        }

        reconocimientoDTO.setTestigoUno(utileriaService.mapearEntityDTOPersona(reconocimiento.getTestigoUno()));
        reconocimientoDTO.setTestigoDos(utileriaService.mapearEntityDTOPersona(reconocimiento.getTestigoDos()));
        reconocimientoDTO.setPadreSanguineo(utileriaService.mapearEntityDTOPersona(reconocimiento.getPadreSanguineo()));

        reconocimientoDTO.setCodigoRespuesta(0);

        return reconocimientoDTO;
    }

    private ActaDTO mapearDatosActa(Reconocimiento reconocimientoEntity){

        ActaDTO actaDTO = new ActaDTO();

        if (actaDTO.getEntidadRegistro() != null)
            actaDTO.setEntidadRegistro(utileriaService.mapearEntityADtoEstado(
                    reconocimientoEntity.getOficialia().getMunicipio().getEstado()));

        if (actaDTO.getOficialia() != null)
            actaDTO.setOficialia(utileriaService.mapeaEntityOficialiaADTO(reconocimientoEntity.getOficialia()));

        actaDTO.setFechaRegistro(reconocimientoEntity.getFechaRegistro());

        if (actaDTO.getNumeroActa() != null)
            actaDTO.setNumeroActa(reconocimientoEntity.getNumeroActa());

        if (actaDTO.getTomo() != null)
            actaDTO.setTomo(reconocimientoEntity.getTomo());

        if (actaDTO.getLibro() != null)
            actaDTO.setLibro(reconocimientoEntity.getLibro());

        if (actaDTO.getFoja() != null)
            actaDTO.setFoja(reconocimientoEntity.getFoja());

        if (actaDTO.getCadena() != null)
            actaDTO.setCadena(reconocimientoEntity.getCadena());

        actaDTO.setNotasMarginales(null);

        if (actaDTO.getOficial() != null)
            actaDTO.setOficial(utileriaService.mapeaEntityOficialADTO(
                    reconocimientoEntity.getOficialia().getIdOficial()));

        actaDTO.setAnioRegistro(String.valueOf(obtenerAnioRegistro(reconocimientoEntity.getFechaRegistro())));

        return actaDTO;

    }

    private ActaReconocimientoDTO mapearDatosActaReconocido(Reconocimiento reconocimientoEntity){

        ActaReconocimientoDTO actaReconocimientoDTO = new ActaReconocimientoDTO();

        if (actaReconocimientoDTO.getEntidadRegistro() != null)
            actaReconocimientoDTO.setEntidadRegistro(utileriaService.mapearEntityADtoEstado(
                    reconocimientoEntity.getOficialia().getMunicipio().getEstado()));

        if (actaReconocimientoDTO.getOficialia() != null)
            actaReconocimientoDTO.setOficialia(utileriaService.mapeaEntityOficialiaADTO(
                    reconocimientoEntity.getOficialia()));

        actaReconocimientoDTO.setFechaRegistro(reconocimientoEntity.getFechaRegistro());

        if (actaReconocimientoDTO.getNumeroActa() != null)
            actaReconocimientoDTO.setNumeroActa(reconocimientoEntity.getNumeroActa());

        if (actaReconocimientoDTO.getTomo() != null)
            actaReconocimientoDTO.setTomo(reconocimientoEntity.getTomo());

        if (actaReconocimientoDTO.getLibro() != null)
            actaReconocimientoDTO.setLibro(reconocimientoEntity.getLibro());

        if (actaReconocimientoDTO.getFoja() != null)
            actaReconocimientoDTO.setFoja(reconocimientoEntity.getFoja());

        if (actaReconocimientoDTO.getCadena() != null)
            actaReconocimientoDTO.setCadena(reconocimientoEntity.getCadena());

        actaReconocimientoDTO.setNotasMarginales(null);

        if (actaReconocimientoDTO.getOficial() != null)
            actaReconocimientoDTO.setOficial(utileriaService.mapeaEntityOficialADTO(
                    reconocimientoEntity.getOficialia().getIdOficial()));

        actaReconocimientoDTO.setAnioRegistro(String.valueOf(obtenerAnioRegistro(
                reconocimientoEntity.getFechaRegistro())));

        return actaReconocimientoDTO;

    }

    private static Integer obtenerAnioRegistro(Date fechaRegistro) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaRegistro);

        return calendar.get(Calendar.YEAR);
    }

}
