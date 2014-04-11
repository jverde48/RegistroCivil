package mx.gob.renapo.registrocivil.actos.defuncion.util.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.ActaDefuncionDTO;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.EstadisticosDefuncionDTO;
import mx.gob.renapo.registrocivil.actos.defuncion.entity.Defuncion;
import mx.gob.renapo.registrocivil.actos.defuncion.util.DefuncionUtilService;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: fase1_16
 * Date: 8/04/14
 * Time: 02:43 AM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Service
public class DefuncionUtilServiceImpl implements DefuncionUtilService{

    @Autowired
    private UtileriaService utileriaService;


    @Override
    public DefuncionDTO mapearEntityDefuncionADTO(Defuncion defuncionEntity) {

        DefuncionDTO defuncionDTO = new DefuncionDTO();

        defuncionDTO.setFinado(utileriaService.mapearEntityDTOPersona(defuncionEntity.getFallecido()));
        defuncionDTO.setConyuge(utileriaService.mapearEntityDTOPersona(defuncionEntity.getConyuge()));
        defuncionDTO.setProgenitorUno(utileriaService.mapearEntityDTOPersona(defuncionEntity.getPadreFallecido()));
        defuncionDTO.setProgenitorDos(utileriaService.mapearEntityDTOPersona(defuncionEntity.getMadreFallecido()));
        defuncionDTO.setDeclarante(utileriaService.mapearEntityDTOPersona(defuncionEntity.getDeclarante()));
        defuncionDTO.setTestigoUno(utileriaService.mapearEntityDTOPersona(defuncionEntity.getTestigoUno()));
        defuncionDTO.setTestigoDos(utileriaService.mapearEntityDTOPersona(defuncionEntity.getTestigoDos()));

        defuncionDTO.setDatosFallecimiento(mapearDatosActaDefuncion(defuncionEntity));

        defuncionDTO.setActaDTO(mapearDatosActa(defuncionEntity));

        defuncionDTO.setEstadisticos(mapearDatosEstadisticosDefuncion(defuncionEntity));

        defuncionDTO.setCodigoRespuesta(0);

        return defuncionDTO;
    }



    private ActaDefuncionDTO mapearDatosActaDefuncion (Defuncion defuncionEntity){

         ActaDefuncionDTO actaDefuncionDTO = new ActaDefuncionDTO();

        actaDefuncionDTO.setFechaDefuncion(defuncionEntity.getFechaDefuncion());
        actaDefuncionDTO.setHoraFallecimiento(defuncionEntity.getHoraDefuncion());
        actaDefuncionDTO.setNumeroCertificadoDefuncion(defuncionEntity.getNumCertDefuncion());
        actaDefuncionDTO.setDomicilioOcurrioFallecimiento(utileriaService.mapeaEntityADtoDomicilio(defuncionEntity.getDomicilioFallecimiento()));
        actaDefuncionDTO.setCausasDefuncion(defuncionEntity.getCausaFallece());
        actaDefuncionDTO.setNombreMedico(defuncionEntity.getNombreMedico());
        actaDefuncionDTO.setCedulaProfesionalMedico(defuncionEntity.getCedulaMedico());
        actaDefuncionDTO.setDomicilioMedico(defuncionEntity.getDomicilioMedico());
        actaDefuncionDTO.setNombreDestinoPanteon(defuncionEntity.getNombreDestino());
        actaDefuncionDTO.setDestinoCadaver(utileriaService.mapearEntityADTODestinoCadaver(defuncionEntity.getDestinoCadaver()));
        actaDefuncionDTO.setDomicilioPanteon(defuncionEntity.getDomicilioDestinoFinado());
        actaDefuncionDTO.setNoOrden(defuncionEntity.getNumOrden());

        actaDefuncionDTO.setParentescoDeclarante(utileriaService.mapearEntityADTOParentesco(defuncionEntity.getParentDeclarante()));
        actaDefuncionDTO.setParentescoTestigoUno(utileriaService.mapearEntityADTOParentesco(defuncionEntity.getParentTestigoUno()));
        actaDefuncionDTO.setParentescoTestigoDos(utileriaService.mapearEntityADTOParentesco(defuncionEntity.getParentTestigoDos()));
        actaDefuncionDTO.setOcupacionDeclarante(defuncionEntity.getOcupacionDeclarante());
        actaDefuncionDTO.setOcupacionTestigoUno(defuncionEntity.getOcupacionTestigoUno());
        actaDefuncionDTO.setOcupacionTestigoDos(defuncionEntity.getOcupacionTestigoDOS());

        return actaDefuncionDTO;

    }

    private ActaDTO mapearDatosActa(Defuncion defuncionEntity){

        ActaDTO actaDTO = new ActaDTO();

        actaDTO.setEntidadRegistro(utileriaService.mapearEntityADtoEstado(defuncionEntity.getEntidadRegistro()));
        actaDTO.setMunicipioRegistro(utileriaService.mapearEntityADtoMunicipio(defuncionEntity.getMunicipioRegistro()));
        actaDTO.setOficialia(utileriaService.mapeaEntityOficialiaADTO(defuncionEntity.getOficialia()));
        actaDTO.setFechaRegistro(defuncionEntity.getFechaRegistro());
        actaDTO.setNumeroActa(defuncionEntity.getNumActaDefuncion());
        actaDTO.setActaBis(defuncionEntity.getActaBis());
        actaDTO.setTomo(defuncionEntity.getTomo());
        actaDTO.setLibro(defuncionEntity.getLibro());
        actaDTO.setFoja(defuncionEntity.getFoja());
        //actaDTO.setLocalidadRegistro(utileriaService.mapeaEntityADTOLocalidad(defuncionEntity.getLocalidadRegistro().getNombre()));
        actaDTO.setCadena(defuncionEntity.getCadena());
        actaDTO.setLlaveOriginal(defuncionEntity.getLlaveOriginal());
        //Notas Marginales acta
        actaDTO.setOficial(utileriaService.mapeaEntityOficialADTO(defuncionEntity.getOficialia().getIdOficial()));
        //actaDTO.setTipoDocumento(utileriaService.recuperarTipoDocumento(defuncionDTO.getActaDTO().getTipoDocumento()));
        //actaDTO.setTipoOperacion(utileriaService.recuperarTipoOperacion(defuncionDTO.getActaDTO().getTipoOperacion()));

        return actaDTO;

    }

    private EstadisticosDefuncionDTO mapearDatosEstadisticosDefuncion(Defuncion defuncionEntity){

        EstadisticosDefuncionDTO estadisticosDefuncionDTO = new EstadisticosDefuncionDTO();

        estadisticosDefuncionDTO.setTuvoAsistenciaMedica(defuncionEntity.getAsistMedica());
        estadisticosDefuncionDTO.setDondeFallecio(utileriaService.mapeaEntityADTOLugarFallece(defuncionEntity.getLugarFallece()));
        estadisticosDefuncionDTO.setEscolaridad(utileriaService.mapearEntityADTOEscolaridad(defuncionEntity.getEscolaridadFallecido()));
        estadisticosDefuncionDTO.setSituacionLaboral(utileriaService.mapearEntityADTOSituacionLaboral(defuncionEntity.getSitLabFinado()));
        estadisticosDefuncionDTO.setPosicionTrabajo(utileriaService.mapearEntityADTOPuesto(defuncionEntity.getPuestoTrabFallecido()));

        return estadisticosDefuncionDTO;
    }

}
