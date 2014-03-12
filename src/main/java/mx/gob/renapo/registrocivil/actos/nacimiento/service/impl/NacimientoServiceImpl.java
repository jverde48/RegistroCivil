package mx.gob.renapo.registrocivil.actos.nacimiento.service.impl;

import mx.gob.renapo.registrocivil.actos.nacimiento.dao.NacimientoDAO;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import org.springframework.stereotype.Service;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;

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
        nacimientoEntity.setRegistrado(trasladarValoresDtoAEntity(nacimientoDTO.getRegistrado()));
        nacimientoEntity.setPadre(trasladarValoresDtoAEntity(nacimientoDTO.getProgenitorUno()));
        nacimientoEntity.setMadre(trasladarValoresDtoAEntity(nacimientoDTO.getProgenitorDos()));
        nacimientoEntity.setAbuelaMaterna(trasladarValoresDtoAEntity(nacimientoDTO.getAbueloUnoProgenitorUno()));
        nacimientoEntity.setAbueloMaterno(trasladarValoresDtoAEntity(nacimientoDTO.getAbueloDosProgenitorUno()));
        nacimientoEntity.setAbuelaPaterna(trasladarValoresDtoAEntity(nacimientoDTO.getAbuelaUnoProgenitorDos()));
        nacimientoEntity.setAbueloPaterno(trasladarValoresDtoAEntity(nacimientoDTO.getAbueloDosProgenitorDos()));
        nacimientoEntity.setTestigoUno(trasladarValoresDtoAEntity(nacimientoDTO.getTestigoUno()));
        nacimientoEntity.setTestigoDos(trasladarValoresDtoAEntity(nacimientoDTO.getTestigoDos()));
        nacimientoEntity.setPersonaDistintaComparece(trasladarValoresDtoAEntity
                (nacimientoDTO.getPersonaDTODistintaComparece()));
        nacimientoEntity.setActaBis(nacimientoDTO.getActaBis());
        nacimientoEntity.setCadena(nacimientoDTO.getCadena());
        nacimientoEntity.setCrip(nacimientoDTO.getCrip());
        nacimientoEntity.setFoja(nacimientoDTO.getFoja());
        nacimientoEntity.setImArchivo(nacimientoDTO.getImArchivo());
        nacimientoEntity.setLibro(nacimientoDTO.getLibro());
        nacimientoEntity.setFoja(nacimientoDTO.getFoja());
        nacimientoDTO.setCadena(nacimientoDTO.getCadena());
        nacimientoEntity.setAtendioParto(nacimientoDTO.getAtendioParto());
        nacimientoEntity.setComparece(nacimientoDTO.getComparece());

        nacimientoEntity.setFechaRegistro(nacimientoDTO.getFechaRegistro());
        nacimientoEntity.setOficialia(nacimientoDTO.getOficialia());
        nacimientoEntity.setLocalidadRegistro(nacimientoDTO.getLocalidadRegistro());
        nacimientoEntity.setTomo(nacimientoDTO.getTomo());
        nacimientoEntity.setTipoDocumento(nacimientoDTO.getTipoDocumento());
        nacimientoEntity.setTipoOperacion(nacimientoDTO.getTipoOperacion());
        nacimientoEntity.setSello(nacimientoDTO.getSello());
        nacimientoEntity.setSelloImg(nacimientoDTO.getSelloImg());
        nacimientoEntity.setVacunado(nacimientoDTO.getVacunado());

        nacimientoEntity.setEscolaridadMadre(nacimientoDTO.getEscolaridadMadre());
        nacimientoEntity.setEscolaridadPadre(nacimientoDTO.getEscolaridadPadre());
        nacimientoEntity.setTranscripcion(nacimientoDTO.getTranscripcion());
        nacimientoEntity.setTipoParto(nacimientoDTO.getTipoParto());
        nacimientoEntity.setViven(nacimientoDTO.getViven());
        nacimientoEntity.setNumParto(nacimientoDTO.getNumParto());
        nacimientoEntity.setNacieronVivos(nacimientoDTO.getNacieronVivos());

        nacimientoDAO.guardarRegistro(nacimientoEntity);


    }

    /**
     * Metodo para la edicion de un nacimiento
     * @param nacimientoDTO
     */
    void editarNacimiento(NacimientoDTO nacimientoDTO) {

    }


    public Persona trasladarValoresDtoAEntity (PersonaDTO personaDTO) {
        Persona persona = new Persona();

        persona.setCadena(personaDTO.getCadenaNacimiento());
        persona.setCertificadoNacimiento(personaDTO.getCadenaNacimiento());
        persona.setCurp(personaDTO.getCertificadoNacimiento());
        persona.setEdad(personaDTO.getEdad());
        persona.setEntidad(personaDTO.getEntidadNAcimiento());
        persona.setMunicipio(personaDTO.getMunicipioNacimiento());
        persona.setLocalidad(personaDTO.getLocalidadNacimiento());
        persona.setEstadoCivil(personaDTO.getEstadoCivil());
        persona.setNombre(personaDTO.getNombre());
        persona.setPrimerApellido(personaDTO.getPrimerApellido());
        persona.setSegundoApellido(personaDTO.getSegundoApellido());
        persona.setSexo(personaDTO.getSexo());
        persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
        persona.setFechaNacimientoIncorrecta(personaDTO.getFechaNacimientoIncEspecial());
        persona.setPais(personaDTO.getPaisNacimiento());
        persona.setNacionalidad(personaDTO.getNacionalidad());

        return persona;
    }

    public void setNacimientoDAO(NacimientoDAO nacimientoDAO) {
        this.nacimientoDAO = nacimientoDAO;
    }

    public NacimientoDAO getNacimientoDAO() {
        return this.nacimientoDAO;
    }
}
