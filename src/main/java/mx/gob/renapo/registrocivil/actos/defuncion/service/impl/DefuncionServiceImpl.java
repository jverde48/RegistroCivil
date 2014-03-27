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
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import mx.gob.renapo.registrocivil.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.gob.renapo.registrocivil.actos.defuncion.entity.Defuncion;
import mx.gob.renapo.registrocivil.util.Utileria;

import javax.annotation.Resource;

@Data
@Service
public class DefuncionServiceImpl implements DefuncionService{

    private DefuncionDAO defuncionDAO;

    /**
     * Metodo para el registro de una Nueva Difuncion
     * @param defuncionDTO
     */

    public void guardarDefuncion(DefuncionDTO defuncionDTO){

        Defuncion defuncionEntity = new Defuncion();

        //DATOS DE PERSONAS DEFUNCION

        defuncionEntity.setFallecido(Utileria.mapearDtoAEntityPersona(defuncionDTO.getFinado()));
        defuncionEntity.setConyuge(Utileria.mapearDtoAEntityPersona(defuncionDTO.getConyuge()));
        defuncionEntity.setPadreFallecido(Utileria.mapearDtoAEntityPersona(defuncionDTO.getProgenitorUno()));
        defuncionEntity.setMadreFallecido(Utileria.mapearDtoAEntityPersona(defuncionDTO.getTestigoDos()));
        defuncionEntity.setDeclarante(Utileria.mapearDtoAEntityPersona(defuncionDTO.getDeclarante()));
        defuncionEntity.setTestigoUno(Utileria.mapearDtoAEntityPersona(defuncionDTO.getTestigoUno()));

        //DATOS EXCLUSIVOS DE UN ACTO DE DEFUNCION

        defuncionEntity.setFechaDefuncion(defuncionDTO.getDatosFallecimiento().getFechaDefuncion());
        defuncionEntity.setHoraDefuncion(defuncionDTO.getDatosFallecimiento().getHoraFallecimiento());
        defuncionEntity.setNumCertDefuncion(defuncionDTO.getDatosFallecimiento().getNumeroCertificadoDefuncion());
        defuncionEntity.setDomicilioFallecimiento(Utileria.mapearDtoAEntityDomicilio(defuncionDTO.getDatosFallecimiento().getDomicilioOcurrioFallecimiento()));
        defuncionEntity.setCausaFallece(defuncionDTO.getDatosFallecimiento().getCausasDefuncion());
        defuncionEntity.setNombreMedico(defuncionDTO.getDatosFallecimiento().getNombreMedico());
        defuncionEntity.setCedulaMedico(defuncionDTO.getDatosFallecimiento().getCedulaProfesionalMedico());
        defuncionEntity.setDomicilioMedico(defuncionDTO.getDatosFallecimiento().getDomicilioMedico());
        defuncionEntity.setNombreDestino(defuncionDTO.getDatosFallecimiento().getNombreDestinoPanteon());
        defuncionEntity.setDestinoCadaver(Utileria.mapearDTOAEntityDestinoCadaver(defuncionDTO.getDatosFallecimiento().getDestinoCadaver()));
        defuncionEntity.setDomicilioDestinoFinado(defuncionDTO.getDatosFallecimiento().getNombreDestinoPanteon());
        defuncionEntity.setNumOrden(defuncionDTO.getDatosFallecimiento().getNoOrden());
        defuncionEntity.setMesesNacimientoFinado(defuncionDTO.getDatosFallecimiento().getMesesNacimientoFinado());
        defuncionEntity.setHoraNacimientoFinado(defuncionDTO.getDatosFallecimiento().getHoraNacimientoFinado());
        defuncionEntity.setParentDeclarante(Utileria.mapearDTOAEntityParentesco(defuncionDTO.getDatosFallecimiento().getParentescoDeclarante()));
        defuncionEntity.setParentTestigoUno(Utileria.mapearDTOAEntityParentesco(defuncionDTO.getDatosFallecimiento().getParentescoTestigoUno()));
        defuncionEntity.setParentTestigoDos(Utileria.mapearDTOAEntityParentesco(defuncionDTO.getDatosFallecimiento().getParentescoTestigoDos()));
        defuncionEntity.setOcupacionDeclarante(defuncionDTO.getDatosFallecimiento().getOcupacionDeclarante());
        defuncionEntity.setOcupacionTestigoUno(defuncionDTO.getDatosFallecimiento().getOcupacionTestigoUno());
        defuncionEntity.setOcupacionTestigoDOS(defuncionDTO.getDatosFallecimiento().getOcupacionTestigoDos());

        //DATOS DE ACTA DEFUNCION

        defuncionEntity.setEntidadRegistro(Utileria.mapearDTOAEntityEstado(defuncionDTO.getActaDTO().getEntidadRegistro()));
        defuncionEntity.setMunicipioRegistro(Utileria.mapearDTOAEntityMunicipio(defuncionDTO.getActaDTO().getMunicipioRegistro()));
        defuncionEntity.setOficialia(Utileria.mapearDTOAEntityOficialia(defuncionDTO.getActaDTO().getOficialia()));
        defuncionEntity.setFechaRegistro(defuncionDTO.getActaDTO().getFechaRegistro());
        defuncionEntity.setNumActaDefuncion(defuncionDTO.getActaDTO().getNumeroActa());
        defuncionEntity.setActaBis(defuncionDTO.getActaDTO().getActaBis());
        defuncionEntity.setTomo(defuncionDTO.getActaDTO().getTomo());
        defuncionEntity.setLibro(defuncionDTO.getActaDTO().getLibro());
        defuncionEntity.setFoja(defuncionDTO.getActaDTO().getFoja());
        defuncionEntity.setLocalidadRegistro(Utileria.mapearDTOEntityLocalidad(defuncionDTO.getActaDTO().getLocalidadRegistro()));
        defuncionEntity.setCadena(defuncionDTO.getActaDTO().getCadena());
        defuncionEntity.setCripFallecido(defuncionDTO.getActaDTO().getCrip());
        defuncionEntity.setAnoRegistro(defuncionDTO.getActaDTO().getAnioRegistro());
        defuncionEntity.setLlaveOriginal(defuncionDTO.getActaDTO().getLlaveOriginal());
        //Notas Marginales acta
        defuncionEntity.setTipoDocumento(Utileria.mapearDTOAEntityTipoDocumento(defuncionDTO.getActaDTO().getTipoDocumento()));
        defuncionEntity.setTipoOperacion(Utileria.mapearDTOAEntityTipoOperacion(defuncionDTO.getActaDTO().getTipoOperacion()));

        //DATOS ESTADISTICOS DEFUNCION

        defuncionEntity.setAsistMedica(defuncionDTO.getEstadisticos().getTuvoAsistenciaMedica());
        defuncionEntity.setLugarFallece(Utileria.mapearDTOAEntityLugarFallece(defuncionDTO.getEstadisticos().getDondeFallecio()));
        defuncionEntity.setEscolaridadFallecido(Utileria.mapearDTOAEntityEscolaridad(defuncionDTO.getEstadisticos().getEscolaridad()));
        defuncionEntity.setSitLabFinado(Utileria.mapearDTOAEntitySituacionLaboral(defuncionDTO.getEstadisticos().getSituacionLaboral()));

        defuncionDAO.guardarRegistro(defuncionEntity);


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
