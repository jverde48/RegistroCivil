package mx.gob.renapo.registrocivil.actos.nacimiento.service.impl;

import lombok.Data;
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
@Data
public class NacimientoServiceImpl {

	@Autowired
    private NacimientoDAO nacimientoDAO;
	
	@Autowired
	private Utileria utileria;

    /**
     * Metodo para el registro de un nuevo nacimiento
     * @param nacimientoDTO
     */
    public void guardarNacimiento(NacimientoDTO nacimientoDTO) {
        Nacimiento nacimientoEntity = mapearNacimiento(nacimientoDTO);
        
        nacimientoDAO.guardarRegistro(nacimientoEntity);
    }
    
    private Nacimiento mapearNacimiento(NacimientoDTO nacimientoDTO) {
    	Nacimiento nacimientoEntity = new Nacimiento();
    	nacimientoEntity.setRegistrado(utileria.mapearDtoAEntityPersona(nacimientoDTO.getRegistrado()));
        nacimientoEntity.setPadre(utileria.mapearDtoAEntityPersona(nacimientoDTO.getProgenitorDos()));
        nacimientoEntity.setMadre(utileria.mapearDtoAEntityPersona(nacimientoDTO.getProgenitorDos()));
        nacimientoEntity.setAbuelaMaterna(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloUnoProgenitorUno()));
        nacimientoEntity.setAbueloMaterno(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloDosProgenitorUno()));
        nacimientoEntity.setAbuelaPaterna(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbuelaUnoProgenitorDos()));
        nacimientoEntity.setAbueloPaterno(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloDosProgenitorDos()));
        nacimientoEntity.setTestigoUno(utileria.mapearDtoAEntityPersona(nacimientoDTO.getTestigoUno()));
        nacimientoEntity.setTestigoDos(utileria.mapearDtoAEntityPersona(nacimientoDTO.getTestigoDos()));
        nacimientoEntity.setPersonaDistintaComparece(utileria.mapearDtoAEntityPersona
                (nacimientoDTO.getPersonaDistintaComparece()));
        nacimientoEntity.setActaBis(nacimientoDTO.getActaNacimiento().getActaBis());
        nacimientoEntity.setCadena(nacimientoDTO.getActaNacimiento().getCadena());
        nacimientoEntity.setCrip(nacimientoDTO.getActaNacimiento().getCrip());
        nacimientoEntity.setFoja(nacimientoDTO.getActaNacimiento().getFoja());
        nacimientoEntity.setImArchivo(nacimientoDTO.getImArchivo());
        nacimientoEntity.setLibro(nacimientoDTO.getActaNacimiento().getLibro());
        nacimientoEntity.setFoja(nacimientoDTO.getActaNacimiento().getFoja());
        nacimientoEntity.setAtendioParto(
        		utileria.recuperarAtendioParto(nacimientoDTO.getDatosEstadisticos().getAtendioParto()));
        nacimientoEntity.setComparece(
        		utileria.recuperarComparece(nacimientoDTO.getActaNacimiento().getComparece()));
        nacimientoEntity.setFechaRegistro(nacimientoDTO.getActaNacimiento().getFechaRegistro());
        nacimientoEntity.setOficialia(
        		utileria.recuperarOficialia(nacimientoDTO.getActaNacimiento().getOficialia()));
        nacimientoEntity.setLocalidadRegistro(
        		utileria.recuperarLocalidad(nacimientoDTO.getActaNacimiento().getLocalidadRegistro()));
        nacimientoEntity.setTomo(nacimientoDTO.getActaNacimiento().getTomo());
        nacimientoEntity.setTipoDocumento(
        		utileria.recuperarTipoDocumento(nacimientoDTO.getActaNacimiento().getTipoDocumento()));
        nacimientoEntity.setTipoOperacion(
                utileria.recuperarTipoOperacion(nacimientoDTO.getActaNacimiento().getTipoOperacion()));
        nacimientoEntity.setSello(nacimientoDTO.getSello());
        nacimientoEntity.setSelloImg(nacimientoDTO.getSelloImg());
        nacimientoEntity.setVacunado(nacimientoDTO.getVacunado());
        nacimientoEntity.setEscolaridadMadre(
        		utileria.recuperarEscolaridad(nacimientoDTO.getDatosEstadisticos().getEscolaridadMadre()));
        nacimientoEntity.setEscolaridadPadre(
        		utileria.recuperarEscolaridad(nacimientoDTO.getDatosEstadisticos().getEscolaridadPadre()));
        nacimientoEntity.setTranscripcion(nacimientoDTO.getTranscripcion());
        nacimientoEntity.setTipoParto(
        		utileria.recuperarTipoParto(nacimientoDTO.getDatosEstadisticos().getTipoParto()));
        nacimientoEntity.setViven(nacimientoDTO.getDatosEstadisticos().getVivenAun());
        nacimientoEntity.setNumParto(nacimientoDTO.getDatosEstadisticos().getNumParto());
        nacimientoEntity.setNacieronVivos(nacimientoDTO.getDatosEstadisticos().getNacieronVivos());        
        return nacimientoEntity;
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
    
    public void setUtileria(Utileria utileria) {
    	this.utileria = utileria;
    }
    
    public Utileria getUtileria() {
    	return this.utileria;
    }
}
