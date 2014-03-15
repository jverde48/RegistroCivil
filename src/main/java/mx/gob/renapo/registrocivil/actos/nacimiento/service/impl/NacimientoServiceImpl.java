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

public class NacimientoServiceImpl {

    private NacimientoDAO nacimientoDAO;

    /**
     * Metodo para el registro de un nuevo nacimiento
     * @param nacimientoDTO
     */
    public void guardarNacimiento(NacimientoDTO nacimientoDTO) {
        Nacimiento nacimientoEntity = new Nacimiento();
        nacimientoEntity.setRegistrado(mapearDtoAEntity(nacimientoDTO.getRegistrado()));
        nacimientoEntity.setPadre(mapearDtoAEntity(nacimientoDTO.getProgenitorUno()));
        nacimientoEntity.setMadre(mapearDtoAEntity(nacimientoDTO.getProgenitorDos()));
        nacimientoEntity.setAbuelaMaterna(mapearDtoAEntity(nacimientoDTO.getAbueloUnoProgenitorUno()));
        nacimientoEntity.setAbueloMaterno(mapearDtoAEntity(nacimientoDTO.getAbueloDosProgenitorUno()));
        nacimientoEntity.setAbuelaPaterna(mapearDtoAEntity(nacimientoDTO.getAbuelaUnoProgenitorDos()));
        nacimientoEntity.setAbueloPaterno(mapearDtoAEntity(nacimientoDTO.getAbueloDosProgenitorDos()));
        nacimientoEntity.setTestigoUno(mapearDtoAEntity(nacimientoDTO.getTestigoUno()));
        nacimientoEntity.setTestigoDos(mapearDtoAEntity(nacimientoDTO.getTestigoDos()));
        nacimientoEntity.setPersonaDistintaComparece(mapearDtoAEntity
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


    public Persona mapearDtoAEntity (PersonaDTO personaDTO) {
        Persona persona = new Persona();

        persona.setCadena(personaDTO.getCadenaNacimiento());
        persona.setCertificadoNacimiento(personaDTO.getCadenaNacimiento());
        persona.setCurp(personaDTO.getCertificadoNacimiento());
        persona.setEdad(personaDTO.getEdad());
        persona.setEntidad(
                Utileria.mapearDTOAEntityEstado(personaDTO.getEntidadNacimiento()));
        persona.setMunicipio(
                Utileria.mapearDTOAEntityMunicipio(personaDTO.getMunicipioNacimiento()));
        persona.setLocalidad(
                Utileria.mapearDTOEntityLocalidad(personaDTO.getColoniaLocalidad()));
        persona.setEstadoCivil(
                Utileria.mapearDTOAEntityEstadoCivil(personaDTO.getEstadoCivil()));
        persona.setNombre(personaDTO.getNombre());
        persona.setPrimerApellido(personaDTO.getPrimerApellido());
        persona.setSegundoApellido(personaDTO.getSegundoApellido());
        persona.setSexo(personaDTO.getSexo());
        persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
        persona.setFechaNacimientoIncorrecta(personaDTO.getFechaNacimientoInc());
        persona.setPais(personaDTO.getPaisNacimiento());
        persona.setNacionalidad(Utileria.mapearDTOEntityNacionalidad(personaDTO.getNacionalidad()));

        return persona;
    }

    public void setNacimientoDAO(NacimientoDAO nacimientoDAO) {
        this.nacimientoDAO = nacimientoDAO;
    }

    public NacimientoDAO getNacimientoDAO() {
        return this.nacimientoDAO;
    }
}
