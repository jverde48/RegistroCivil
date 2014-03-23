package mx.gob.renapo.registrocivil.actos.defuncion.service.impl;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 08:01 PM
 * To change this template use File | Settings | File Templates.
 */

import mx.gob.renapo.registrocivil.actos.defuncion.dao.DefuncionDAO;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import mx.gob.renapo.registrocivil.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.gob.renapo.registrocivil.actos.defuncion.entity.Defuncion;
import mx.gob.renapo.registrocivil.util.Utileria;

import javax.annotation.Resource;

public class DefuncionServiceImpl {

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

        //DATOS EXCLUSIVOS DE UN ACTO DE DEFUNCIÓN

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

        //DATOS DE ACTA DEFUNCION

        //Entidad Registro
        //Municipio Registro
        defuncionEntity.setOficialia(Utileria.mapearDTOAEntityOficialia(defuncionDTO.getActa().getOficialia()));
        defuncionEntity.setFechaRegistro(defuncionDTO.getActa().getFechaRegistro());
        defuncionEntity.setNumActaDefuncion(defuncionDTO.getActa().getNumeroActa());
        defuncionEntity.setActaBis(defuncionDTO.getActa().getActaBis());
        defuncionEntity.setTomo(defuncionDTO.getActa().getTomo());
        defuncionEntity.setLibro(defuncionDTO.getActa().getLibro());
        defuncionEntity.setFoja(defuncionDTO.getActa().getFoja());
        defuncionEntity.setLocalidadRegistro(Utileria.mapearDTOEntityLocalidad(defuncionDTO.getActa().getLocalidadRegistro()));
        defuncionEntity.setCadena(defuncionDTO.getActa().getCadena());
        defuncionEntity.setCripFallecido(defuncionDTO.getActa().getCrip());
        defuncionEntity.setAnoRegistro(defuncionDTO.getActa().getAnioRegistro());
        defuncionEntity.setLlaveOriginal(defuncionDTO.getActa().getLlaveOriginal());
        //Notas Marginales acta
        defuncionEntity.setTipoDocumento(Utileria.mapearDTOAEntityTipoDocumento(defuncionDTO.getActa().getTipoDocumento()));
        defuncionEntity.setTipoOperacion(Utileria.mapearDTOAEntityTipoOperacion(defuncionDTO.getActa().getTipoOperacion()));

        //DATOS ESTADISTICOS DEFUNCION

        defuncionEntity.setAsistMedica(defuncionDTO.getEstadisticos().getTuvoAsistenciaMedica());
        defuncionEntity.setLugarFallece(defuncionDTO.getEstadisticos().getDondeFallecio());
        defuncionEntity.setEscolaridadFallecido(Utileria.mapearDTOAEntityEscolaridad(defuncionDTO.getEstadisticos().getEscolaridad()));
        defuncionEntity.setSitLabFinado(defuncionDTO.getEstadisticos().getSituacionLaboral());


    }


}
