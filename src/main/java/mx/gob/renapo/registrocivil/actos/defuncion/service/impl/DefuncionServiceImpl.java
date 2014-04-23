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
import java.util.Date;

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
    public DefuncionDTO guardarDefuncion(DefuncionDTO defuncionDTO, Boolean existenciaConyuge,
                                         Boolean existenciaProgenitorUno, Boolean existenciaProgenitorDos){

        Defuncion defuncionEntity = null;
        DefuncionDTO defuncionDTOReponse = null;

        try {
        defuncionEntity = new Defuncion();

        //DATOS DE PERSONAS DEFUNCION

        defuncionEntity.setFallecido(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getFinado()));

        if (existenciaConyuge)
            defuncionEntity.setConyuge(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getConyuge()));

        if (existenciaProgenitorUno)
            defuncionEntity.setPadreFallecido(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getProgenitorUno()));

        if (existenciaProgenitorDos)
            defuncionEntity.setMadreFallecido(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getProgenitorDos()));

        defuncionEntity.setDeclarante(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getDeclarante()));
        defuncionEntity.setTestigoUno(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getTestigoUno()));
        defuncionEntity.setTestigoDos(utileriaService.mapearDtoAEntityPersona(defuncionDTO.getTestigoDos()));

        //DATOS EXCLUSIVOS DE UN ACTO DE DEFUNCION

        defuncionEntity.setFechaDefuncion(defuncionDTO.getDatosFallecimiento().getFechaDefuncion());
        defuncionEntity.setHoraDefuncion(defuncionDTO.getDatosFallecimiento().getHoraFallecimiento());
        defuncionEntity.setNumCertDefuncion(defuncionDTO.getDatosFallecimiento().getNumeroCertificadoDefuncion());

        if (defuncionDTO.getDatosFallecimiento().getDomicilioOcurrioFallecimiento() != null)
            defuncionEntity.setDomicilioFallecimiento(utileriaService.mapearDtoAEntityDomicilio(defuncionDTO.getDatosFallecimiento().getDomicilioOcurrioFallecimiento()));

        defuncionEntity.setCausaFallece(defuncionDTO.getDatosFallecimiento().getCausasDefuncion());
        defuncionEntity.setNombreMedico(defuncionDTO.getDatosFallecimiento().getNombreMedico());
        defuncionEntity.setCedulaMedico(defuncionDTO.getDatosFallecimiento().getCedulaProfesionalMedico());
        defuncionEntity.setDomicilioMedico(defuncionDTO.getDatosFallecimiento().getDomicilioMedico());
        defuncionEntity.setNombreDestino(defuncionDTO.getDatosFallecimiento().getNombreDestinoPanteon());

        if (defuncionDTO.getDatosFallecimiento().getDestinoCadaver() != null)
            defuncionEntity.setDestinoCadaver(utileriaService.recuperarDestinoCadaver(defuncionDTO.getDatosFallecimiento().getDestinoCadaver()));
        defuncionEntity.setDomicilioDestinoFinado(defuncionDTO.getDatosFallecimiento().getNombreDestinoPanteon());
        defuncionEntity.setNumOrden(defuncionDTO.getDatosFallecimiento().getNoOrden());

        if (defuncionDTO.getDatosFallecimiento().getParentescoDeclarante() != null)
            defuncionEntity.setParentDeclarante(utileriaService.recuperarParentesco(defuncionDTO.getDatosFallecimiento().getParentescoDeclarante()));

        if (defuncionDTO.getDatosFallecimiento().getParentescoTestigoUno() != null)
            defuncionEntity.setParentTestigoUno(utileriaService.recuperarParentesco(defuncionDTO.getDatosFallecimiento().getParentescoTestigoUno()));

        if (defuncionDTO.getDatosFallecimiento().getParentescoTestigoDos() != null)
            defuncionEntity.setParentTestigoDos(utileriaService.recuperarParentesco(defuncionDTO.getDatosFallecimiento().getParentescoTestigoDos()));
        defuncionEntity.setOcupacionDeclarante(defuncionDTO.getDatosFallecimiento().getOcupacionDeclarante());
        defuncionEntity.setOcupacionTestigoUno(defuncionDTO.getDatosFallecimiento().getOcupacionTestigoUno());
        defuncionEntity.setOcupacionTestigoDOS(defuncionDTO.getDatosFallecimiento().getOcupacionTestigoDos());

        //DATOS DE ACTA DEFUNCION

        if (defuncionDTO.getActaDTO().getEntidadRegistro() != null)
            defuncionEntity.setEntidadRegistro(utileriaService.recuperarEstado(defuncionDTO.getActaDTO().getEntidadRegistro()));

        if (defuncionDTO.getActaDTO().getMunicipioRegistro() != null)
            defuncionEntity.setMunicipioRegistro(utileriaService.recupearMunicipio(defuncionDTO.getActaDTO().getMunicipioRegistro()));

        if (defuncionDTO.getActaDTO().getOficialia() !=null)
            defuncionEntity.setOficialia(utileriaService.recuperarOficialia(defuncionDTO.getActaDTO().getOficialia()));

        defuncionEntity.setFechaRegistro(new Date());
        defuncionEntity.setNumeroActa(defuncionDTO.getActaDTO().getNumeroActa() != null ?
                                            defuncionDTO.getActaDTO().getNumeroActa() : "");
        defuncionEntity.setActaBis(0);
        defuncionEntity.setTomo(defuncionDTO.getActaDTO().getTomo() != null ?
                                defuncionDTO.getActaDTO().getTomo().toUpperCase() : "");
        defuncionEntity.setLibro(defuncionDTO.getActaDTO().getLibro() != null ?
                                 defuncionDTO.getActaDTO().getLibro().toUpperCase() : "");
        defuncionEntity.setFoja(defuncionDTO.getActaDTO().getFoja() != null ?
                                defuncionDTO.getActaDTO().getFoja().toUpperCase() : "");

        if (defuncionDTO.getActaDTO().getLocalidadRegistro() != null)
            defuncionEntity.setLocalidadRegistro(utileriaService.recuperarLocalidad(defuncionDTO.getActaDTO().getLocalidadRegistro()));
        defuncionEntity.setCadena("");
        defuncionEntity.setLlaveOriginal(defuncionDTO.getActaDTO().getLlaveOriginal());
        //Notas Marginales acta
        defuncionEntity.setImArchivo("");
        defuncionEntity.setImNombre("");
        defuncionEntity.setSello("");
        defuncionEntity.setSelloImg("");
        defuncionEntity.setNombreOficial(defuncionDTO.getActaDTO().getOficial().getNombre());
        defuncionEntity.setTipoOperacion(defuncionDTO.getActaDTO().getTipoOperacion());

        if (defuncionDTO.isNormal())
            defuncionEntity.setTipoCaptura('N');
        else if (defuncionDTO.isHistorico())
                 defuncionEntity.setTipoCaptura('H');
        else
            defuncionEntity.setTipoCaptura('E');

        //DATOS ESTADISTICOS DEFUNCION

        defuncionEntity.setAsistMedica(defuncionDTO.getEstadisticos().getTuvoAsistenciaMedica());

        if (defuncionDTO.getEstadisticos().getDondeFallecio() != null)
            defuncionEntity.setLugarFallece(utileriaService.recuperarLugarFallece(defuncionDTO.getEstadisticos().getDondeFallecio()));

        if (defuncionDTO.getEstadisticos().getEscolaridad() != null)
            defuncionEntity.setEscolaridadFallecido(utileriaService.recuperarEscolaridad(defuncionDTO.getEstadisticos().getEscolaridad()));

        if (defuncionDTO.getEstadisticos().getSituacionLaboral() != null)
            defuncionEntity.setSitLabFinado(utileriaService.recuperarSituacionLaboral(defuncionDTO.getEstadisticos().getSituacionLaboral()));
        defuncionEntity.setPuestoTrabFallecido(utileriaService.recuperarPuesto(defuncionDTO.getEstadisticos().getPosicionTrabajo()));

        defuncionEntity.setVersion(1L);


        defuncionDTOReponse = defuncionUtilService.mapearEntityDefuncionADTO(defuncionDAO.guardarRegistro(defuncionEntity));

        return defuncionDTOReponse;
        } catch (Exception e) {
            e.printStackTrace();
            defuncionDTOReponse = new DefuncionDTO();
            defuncionDTOReponse.setCodigoRespuesta(1);
            defuncionDTOReponse.setMensajeError(utileriaService.getStackTrace(e));
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
