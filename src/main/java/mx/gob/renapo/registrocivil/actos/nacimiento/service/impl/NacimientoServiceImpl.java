package mx.gob.renapo.registrocivil.actos.nacimiento.service.impl;

import mx.gob.renapo.registrocivil.actos.nacimiento.dao.NacimientoDAO;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import mx.gob.renapo.registrocivil.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.util.Utileria;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 2/28/14
 * Time: 1:49 PM
 * Clase de implementacion de service de nacimiento
 */

@Service
public class NacimientoServiceImpl {

    private NacimientoDAO nacimientoDAO;

    /**
     * Metodo para el registro de un nuevo nacimiento
     * @param nacimientoDTO
     */
    public void guardarNacimiento(NacimientoDTO nacimientoDTO) {
        Nacimiento nacimientoEntity = new Nacimiento();
        nacimientoEntity.setRegistrado(Utileria.mapearDtoAEntityPersona(nacimientoDTO.getRegistrado()));
        nacimientoEntity.setPadre(Utileria.mapearDtoAEntityPersona(nacimientoDTO.getProgenitorUno()));
        nacimientoEntity.setMadre(Utileria.mapearDtoAEntityPersona(nacimientoDTO.getProgenitorDos()));
        nacimientoEntity.setAbuelaMaterna(Utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloUnoProgenitorUno()));
        nacimientoEntity.setAbueloMaterno(Utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloDosProgenitorUno()));
        nacimientoEntity.setAbuelaPaterna(Utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbuelaUnoProgenitorDos()));
        nacimientoEntity.setAbueloPaterno(Utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloDosProgenitorDos()));
        nacimientoEntity.setTestigoUno(Utileria.mapearDtoAEntityPersona(nacimientoDTO.getTestigoUno()));
        nacimientoEntity.setTestigoDos(Utileria.mapearDtoAEntityPersona(nacimientoDTO.getTestigoDos()));
        nacimientoEntity.setPersonaDistintaComparece(Utileria.mapearDtoAEntityPersona
                (nacimientoDTO.getPersonaDistintaComparece()));
        nacimientoEntity.setActaBis(nacimientoDTO.getActaNacimiento().getActaBis());
        nacimientoEntity.setCadena(nacimientoDTO.getActaNacimiento().getCadena());
        nacimientoEntity.setCrip(nacimientoDTO.getActaNacimiento().getCrip());
        nacimientoEntity.setFoja(nacimientoDTO.getActaNacimiento().getFoja());
        nacimientoEntity.setImArchivo(nacimientoDTO.getImArchivo());
        nacimientoEntity.setLibro(nacimientoDTO.getActaNacimiento().getLibro());
        nacimientoEntity.setFoja(nacimientoDTO.getActaNacimiento().getFoja());
        nacimientoEntity.setAtendioParto(
                Utileria.mapearDTOAEntityAtendioParto(nacimientoDTO.getDatosEstadisticos().getAtendioParto()));
        nacimientoEntity.setComparece(
                Utileria.mapearDTOAEntityComparece(nacimientoDTO.getActaNacimiento().getComparece()));
        nacimientoEntity.setFechaRegistro(nacimientoDTO.getActaNacimiento().getFechaRegistro());
        nacimientoEntity.setOficialia(
                Utileria.mapearDTOAEntityOficialia(nacimientoDTO.getActaNacimiento().getOficialia()));
        nacimientoEntity.setLocalidadRegistro(
                Utileria.mapearDTOEntityLocalidad(nacimientoDTO.getActaNacimiento().getLocalidadRegistro()));
        nacimientoEntity.setTomo(nacimientoDTO.getActaNacimiento().getTomo());
        nacimientoEntity.setTipoDocumento(
                Utileria.mapearDTOAEntityTipoDocumento(nacimientoDTO.getActaNacimiento().getTipoDocumento()));
        nacimientoEntity.setTipoOperacion(
                Utileria.mapearDTOAEntityTipoOperacion(nacimientoDTO.getActaNacimiento().getTipoOperacion()));
        nacimientoEntity.setSello(nacimientoDTO.getSello());
        nacimientoEntity.setSelloImg(nacimientoDTO.getSelloImg());
        nacimientoEntity.setVacunado(nacimientoDTO.getVacunado());
        nacimientoEntity.setEscolaridadMadre(
                Utileria.mapearDTOAEntityEscolaridad(nacimientoDTO.getDatosEstadisticos().getEscolaridadMadre()));
        nacimientoEntity.setEscolaridadPadre(
                Utileria.mapearDTOAEntityEscolaridad(nacimientoDTO.getDatosEstadisticos().getEscolaridadPadre()));
        nacimientoEntity.setTranscripcion(nacimientoDTO.getTranscripcion());
        nacimientoEntity.setTipoParto(
                Utileria.mapearDTOAEntityTipoParto(nacimientoDTO.getDatosEstadisticos().getTipoParto()));
        nacimientoEntity.setViven(nacimientoDTO.getDatosEstadisticos().getVivenAun());
        nacimientoEntity.setNumParto(nacimientoDTO.getDatosEstadisticos().getNumParto());
        nacimientoEntity.setNacieronVivos(nacimientoDTO.getDatosEstadisticos().getNacieronVivos());

        nacimientoDAO.guardarRegistro(nacimientoEntity);


    }

    /**
     * Metodo para la edicion de un nacimiento
     * @param nacimientoDTO
     */
    void editarNacimiento(NacimientoDTO nacimientoDTO) {

    }

    public void setNacimientoDAO(NacimientoDAO nacimientoDAO) {
        this.nacimientoDAO = nacimientoDAO;
    }

    public NacimientoDAO getNacimientoDAO() {
        return this.nacimientoDAO;
    }
}
