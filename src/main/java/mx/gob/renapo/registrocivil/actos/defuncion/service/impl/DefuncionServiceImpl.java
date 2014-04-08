package mx.gob.renapo.registrocivil.actos.defuncion.service.impl;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 08:01 PM
 * To change this template use File | Settings | File Templates.
 */

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.defuncion.dao.DefuncionDAO;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;
import mx.gob.renapo.registrocivil.actos.defuncion.service.DefuncionService;
import mx.gob.renapo.registrocivil.actos.defuncion.util.DefuncionUtilService;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.gob.renapo.registrocivil.actos.defuncion.entity.Defuncion;

import javax.annotation.Resource;

@Data
@Service
public class DefuncionServiceImpl implements DefuncionService{

    @Autowired
    private DefuncionDAO defuncionDAO;

    @Autowired
    private UtileriaService utileriaService;

    @Autowired
    DefuncionUtilService defuncionUtilService;

    @Override
    public DefuncionDTO guardarDefuncion(DefuncionDTO defuncionDTO){

        Defuncion defuncionEntity = null;
        DefuncionDTO defuncionDTOReponse = null;

        try {
        defuncionEntity = new Defuncion();

        //DATOS DE PERSONAS DEFUNCION

        defuncionEntity.setFallecido(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getFinado()));
        defuncionEntity.setConyuge(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getConyuge()));
        defuncionEntity.setPadreFallecido(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getProgenitorUno()));
        defuncionEntity.setMadreFallecido(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getProgenitorDos()));
        defuncionEntity.setDeclarante(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getDeclarante()));
        defuncionEntity.setTestigoUno(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getTestigoUno()));
        defuncionEntity.setTestigoDos(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getTestigoDos()));

        //DATOS EXCLUSIVOS DE UN ACTO DE DEFUNCION

        defuncionEntity.setFechaDefuncion(defuncionDTO.getDatosFallecimiento().getFechaDefuncion());
        defuncionEntity.setHoraDefuncion(defuncionDTO.getDatosFallecimiento().getHoraFallecimiento());
        defuncionEntity.setNumCertDefuncion(defuncionDTO.getDatosFallecimiento().getNumeroCertificadoDefuncion());
        defuncionEntity.setDomicilioFallecimiento(utileriaService.mapearDtoAEntityDomicilio(defuncionDTO.getDatosFallecimiento().getDomicilioOcurrioFallecimiento()));
        defuncionEntity.setCausaFallece(defuncionDTO.getDatosFallecimiento().getCausasDefuncion());
        defuncionEntity.setNombreMedico(defuncionDTO.getDatosFallecimiento().getNombreMedico());
        defuncionEntity.setCedulaMedico(defuncionDTO.getDatosFallecimiento().getCedulaProfesionalMedico());
        defuncionEntity.setDomicilioMedico(defuncionDTO.getDatosFallecimiento().getDomicilioMedico());
        defuncionEntity.setNombreDestino(defuncionDTO.getDatosFallecimiento().getNombreDestinoPanteon());
        defuncionEntity.setDestinoCadaver(utileriaService.recuperarDestinoCadaver(defuncionDTO.getDatosFallecimiento().getDestinoCadaver()));
        defuncionEntity.setDomicilioDestinoFinado(defuncionDTO.getDatosFallecimiento().getNombreDestinoPanteon());
        defuncionEntity.setNumOrden(defuncionDTO.getDatosFallecimiento().getNoOrden());

        defuncionEntity.setParentDeclarante(utileriaService.recuperarParentesco(defuncionDTO.getDatosFallecimiento().getParentescoDeclarante()));
        defuncionEntity.setParentTestigoUno(utileriaService.recuperarParentesco(defuncionDTO.getDatosFallecimiento().getParentescoTestigoUno()));
        defuncionEntity.setParentTestigoDos(utileriaService.recuperarParentesco(defuncionDTO.getDatosFallecimiento().getParentescoTestigoDos()));
        defuncionEntity.setOcupacionDeclarante(defuncionDTO.getDatosFallecimiento().getOcupacionDeclarante());
        defuncionEntity.setOcupacionTestigoUno(defuncionDTO.getDatosFallecimiento().getOcupacionTestigoUno());
        defuncionEntity.setOcupacionTestigoDOS(defuncionDTO.getDatosFallecimiento().getOcupacionTestigoDos());

        //DATOS DE ACTA DEFUNCION

        defuncionEntity.setEntidadRegistro(utileriaService.recuperarEstado(defuncionDTO.getActaDTO().getEntidadRegistro()));
        defuncionEntity.setMunicipioRegistro(utileriaService.recupearMunicipio(defuncionDTO.getActaDTO().getMunicipioRegistro()));
        defuncionEntity.setOficialia(utileriaService.recuperarOficialia(defuncionDTO.getActaDTO().getOficialia()));
        defuncionEntity.setFechaRegistro(defuncionDTO.getActaDTO().getFechaRegistro());
        defuncionEntity.setNumActaDefuncion(defuncionDTO.getActaDTO().getNumeroActa());
        defuncionEntity.setActaBis(defuncionDTO.getActaDTO().getActaBis());
        defuncionEntity.setTomo(defuncionDTO.getActaDTO().getTomo());
        defuncionEntity.setLibro(defuncionDTO.getActaDTO().getLibro());
        defuncionEntity.setFoja(defuncionDTO.getActaDTO().getFoja());
        defuncionEntity.setLocalidadRegistro(utileriaService.recuperarLocalidad(defuncionDTO.getActaDTO().getLocalidadRegistro()));
        defuncionEntity.setCadena(defuncionDTO.getActaDTO().getCadena());
        defuncionEntity.setLlaveOriginal(defuncionDTO.getActaDTO().getLlaveOriginal());
        //Notas Marginales acta
        defuncionEntity.setNombreOficial(defuncionDTO.getActaDTO().getOficial().getNombre());
        //defuncionEntity.setTipoDocumento(utileriaService.recuperarTipoDocumento(defuncionDTO.getActaDTO().getTipoDocumento()));
        //defuncionEntity.setTipoOperacion(utileriaService.recuperarTipoOperacion(defuncionDTO.getActaDTO().getTipoOperacion()));

        //DATOS ESTADISTICOS DEFUNCION

        defuncionEntity.setAsistMedica(defuncionDTO.getEstadisticos().getTuvoAsistenciaMedica());
        defuncionEntity.setLugarFallece(utileriaService.recuperarLugarFallece(defuncionDTO.getEstadisticos().getDondeFallecio()));
        defuncionEntity.setEscolaridadFallecido(utileriaService.recuperarEscolaridad(defuncionDTO.getEstadisticos().getEscolaridad()));
        defuncionEntity.setSitLabFinado(utileriaService.recuperarSituacionLaboral(defuncionDTO.getEstadisticos().getSituacionLaboral()));
        defuncionEntity.setPuestoTrabFallecido(utileriaService.recuperarPuesto(defuncionDTO.getEstadisticos().getPosicionTrabajo()));

        defuncionEntity.setVersion(1L);


        defuncionDTOReponse = defuncionUtilService.mapearEntityDefuncionADTO(defuncionDAO.guardarRegistro(defuncionEntity));

        return defuncionDTOReponse;
        } catch (Exception e) {
            e.printStackTrace();
            defuncionDTOReponse = new DefuncionDTO();
            defuncionDTOReponse.setCodigoRespuesta(1);
            return  defuncionDTOReponse;
        }



    }

    /**
     * Metodo para la edicion de una DEFUNCION
     * @param defuncionDTO
     */
    public void editarDefuncion(DefuncionDTO defuncionDTO) {

    }

    public void setDefuncionDAO(DefuncionDAO defuncionDAO) {
        this.defuncionDAO = defuncionDAO;
    }

    public DefuncionDAO getDefuncionDAO() {
        return this.defuncionDAO;
    }


}
