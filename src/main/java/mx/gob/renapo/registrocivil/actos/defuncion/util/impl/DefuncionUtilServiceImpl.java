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

import java.util.Calendar;
import java.util.Date;

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

        if (defuncionDTO.getConyuge() != null)
            defuncionDTO.setConyuge(utileriaService.mapearEntityDTOPersona(defuncionEntity.getConyuge()));

        if (defuncionDTO.getProgenitorUno() != null)
            defuncionDTO.setProgenitorUno(utileriaService.mapearEntityDTOPersona(defuncionEntity.getPadreFallecido()));

        if (defuncionDTO.getProgenitorDos() != null)
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

        if (actaDefuncionDTO.getDomicilioOcurrioFallecimiento() != null)
            actaDefuncionDTO.setDomicilioOcurrioFallecimiento(utileriaService.mapeaEntityADtoDomicilio(defuncionEntity.getDomicilioFallecimiento()));

        actaDefuncionDTO.setCausasDefuncion(defuncionEntity.getCausaFallece());
        actaDefuncionDTO.setNombreMedico(defuncionEntity.getNombreMedico());
        actaDefuncionDTO.setCedulaProfesionalMedico(defuncionEntity.getCedulaMedico());
        actaDefuncionDTO.setDomicilioMedico(defuncionEntity.getDomicilioMedico());
        actaDefuncionDTO.setNombreDestinoPanteon(defuncionEntity.getNombreDestino());

        if (actaDefuncionDTO.getDestinoCadaver() != null)
            actaDefuncionDTO.setDestinoCadaver(utileriaService.mapearEntityADTODestinoCadaver(defuncionEntity.getDestinoCadaver()));

        actaDefuncionDTO.setDomicilioPanteon(defuncionEntity.getDomicilioDestinoFinado());
        actaDefuncionDTO.setNoOrden(defuncionEntity.getNumOrden());

        if (actaDefuncionDTO.getParentescoDeclarante() != null)
            actaDefuncionDTO.setParentescoDeclarante(utileriaService.mapearEntityADTOParentesco(defuncionEntity.getParentDeclarante()));

        if (actaDefuncionDTO.getParentescoTestigoUno() != null)
            actaDefuncionDTO.setParentescoTestigoUno(utileriaService.mapearEntityADTOParentesco(defuncionEntity.getParentTestigoUno()));

        if (actaDefuncionDTO.getParentescoTestigoDos() != null)
        actaDefuncionDTO.setParentescoTestigoDos(utileriaService.mapearEntityADTOParentesco(defuncionEntity.getParentTestigoDos()));
        actaDefuncionDTO.setOcupacionDeclarante(defuncionEntity.getOcupacionDeclarante());
        actaDefuncionDTO.setOcupacionTestigoUno(defuncionEntity.getOcupacionTestigoUno());
        actaDefuncionDTO.setOcupacionTestigoDos(defuncionEntity.getOcupacionTestigoDOS());

        return actaDefuncionDTO;

    }

    private ActaDTO mapearDatosActa(Defuncion defuncionEntity){

        ActaDTO actaDTO = new ActaDTO();

        if (actaDTO.getEntidadRegistro() != null)
        actaDTO.setEntidadRegistro(utileriaService.mapearEntityADtoEstado(defuncionEntity.getOficialia().getMunicipio().getEstado()));

        if (actaDTO.getMunicipioRegistro() != null)
        actaDTO.setMunicipioRegistro(utileriaService.mapearEntityADtoMunicipio(defuncionEntity.getMunicipioRegistro()));

        //TODO verificar oficialia
        if (actaDTO.getOficialia() != null)
        actaDTO.setOficialia(utileriaService.mapeaEntityOficialiaADTO(defuncionEntity.getOficialia()));

        actaDTO.setFechaRegistro(defuncionEntity.getFechaRegistro());

        if (actaDTO.getNumeroActa() != null)
        actaDTO.setNumeroActa(defuncionEntity.getNumeroActa());

        if (actaDTO.getActaBis() != null)
        actaDTO.setActaBis(defuncionEntity.getActaBis());

        if (actaDTO.getTomo() != null)
        actaDTO.setTomo(defuncionEntity.getTomo());

        if (actaDTO.getLibro() != null)
        actaDTO.setLibro(defuncionEntity.getLibro());

        if (actaDTO.getFoja() != null)
        actaDTO.setFoja(defuncionEntity.getFoja());

        //actaDTO.setLocalidadRegistro(utileriaService.mapeaEntityADTOLocalidad(defuncionEntity.getLocalidadRegistro().getNombre()));

        if (actaDTO.getCadena() != null)
        actaDTO.setCadena(defuncionEntity.getCadena());

        if (actaDTO.getLlaveOriginal() != null)
        actaDTO.setLlaveOriginal(defuncionEntity.getLlaveOriginal() != null ?
                                 defuncionEntity.getLlaveOriginal() : "");

        actaDTO.setNotasMarginales(null);

        if (actaDTO.getOficial() != null)
        actaDTO.setOficial(utileriaService.mapeaEntityOficialADTO(defuncionEntity.getOficialia().getIdOficial()));
        //actaDTO.setTipoDocumento(utileriaService.recuperarTipoDocumento(defuncionDTO.getActaDTO().getTipoDocumento()));
        actaDTO.setTipoOperacion(defuncionEntity.getTipoOperacion());

        actaDTO.setAnioRegistro(String.valueOf(obtenerAnioRegistro(defuncionEntity.getFechaRegistro())));


        return actaDTO;

    }

    private EstadisticosDefuncionDTO mapearDatosEstadisticosDefuncion(Defuncion defuncionEntity){

        EstadisticosDefuncionDTO estadisticosDefuncionDTO = new EstadisticosDefuncionDTO();

        estadisticosDefuncionDTO.setTuvoAsistenciaMedica(defuncionEntity.getAsistMedica());

        if (estadisticosDefuncionDTO.getDondeFallecio() != null)
            estadisticosDefuncionDTO.setDondeFallecio(utileriaService.mapeaEntityADTOLugarFallece(defuncionEntity.getLugarFallece()));

        if (estadisticosDefuncionDTO.getEscolaridad() != null)
            estadisticosDefuncionDTO.setEscolaridad(utileriaService.mapearEntityADTOEscolaridad(defuncionEntity.getEscolaridadFallecido()));

        if (estadisticosDefuncionDTO.getSituacionLaboral() != null)
        estadisticosDefuncionDTO.setSituacionLaboral(utileriaService.mapearEntityADTOSituacionLaboral(defuncionEntity.getSitLabFinado()));

        if (estadisticosDefuncionDTO.getPosicionTrabajo() != null)
        estadisticosDefuncionDTO.setPosicionTrabajo(utileriaService.mapearEntityADTOPuesto(defuncionEntity.getPuestoTrabFallecido()));

        return estadisticosDefuncionDTO;
    }


    private static Integer obtenerAnioRegistro(Date fechaRegistro) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaRegistro);

        return calendar.get(Calendar.YEAR);
    }

}
