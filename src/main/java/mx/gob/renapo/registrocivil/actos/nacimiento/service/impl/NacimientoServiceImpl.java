package mx.gob.renapo.registrocivil.actos.nacimiento.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dao.NacimientoDAO;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.NacimientoService;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import mx.gob.renapo.registrocivil.util.UtileriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 2/28/14
 * Time: 1:49 PM
 * Clase de implementacion de service de nacimiento
 */

@Service
@Data
public class NacimientoServiceImpl implements NacimientoService{

	@Autowired
    private NacimientoDAO nacimientoDAO;
	
	@Autowired
	private UtileriaService utileria;

    /**
     * Metodo para el registro de un nuevo nacimiento
     * @param nacimientoDTO
     */
    public void guardarNacimiento(NacimientoDTO nacimientoDTO, Boolean abueloUnoProgenitorUno,
    	    Boolean abueloDosProgenitorUno, Boolean abueloUnoProgenitorDos,
    	    Boolean abueloDosProgenitorDos, Integer padres, Integer comparece)
      throws Exception{
        Nacimiento nacimientoEntity = mapearNacimiento(nacimientoDTO, abueloUnoProgenitorUno,
        	    abueloDosProgenitorUno, abueloUnoProgenitorDos,
        	    abueloDosProgenitorDos, padres, comparece);
            nacimientoEntity = nacimientoDAO.guardarRegistro(nacimientoEntity);

    }
    
    

    /**
     * Metodo para la edicion de un nacimiento
     * @param nacimientoDTO
     */
    public void editarNacimiento(NacimientoDTO nacimientoDTO) throws Exception{

    }
    
    /**
     * Metodo para mapear un objeto  DTO a una entity de Nacimiento
     * @param nacimientoDTO
     * @param abueloUnoProgenitorUno
     * @param abueloDosProgenitorUno
     * @param abueloUnoProgenitorDos
     * @param abueloDosProgenitorDos
     * @param padres
     * @param comparece
     * @return Nacimiento
     */
    private Nacimiento mapearNacimiento(NacimientoDTO nacimientoDTO, Boolean abueloUnoProgenitorUno,
    	    Boolean abueloDosProgenitorUno, Boolean abueloUnoProgenitorDos,
    	    Boolean abueloDosProgenitorDos, Integer padres, Integer comparece) {
    	Nacimiento nacimientoEntity = new Nacimiento();
    	nacimientoEntity.setTomo("");
    	nacimientoEntity.setVersion(1L);
    	nacimientoEntity.setCrip("");
    	nacimientoEntity.setCadena("");
    	nacimientoEntity.setLibro("");
    	nacimientoEntity.setRegistrado(utileria.mapearDtoAEntityPersona(nacimientoDTO.getRegistrado()));
        nacimientoEntity.setPadre(utileria.mapearDtoAEntityPersona(nacimientoDTO.getProgenitorUno()));
        if(padres==2) {
        	nacimientoEntity.setMadre(utileria.mapearDtoAEntityPersona(nacimientoDTO.getProgenitorDos()));	
        }
        if(abueloUnoProgenitorUno) {
        	nacimientoEntity.setAbuelaMaterna(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloUnoProgenitorUno()));
        }
        if(abueloDosProgenitorUno) {
        	nacimientoEntity.setAbueloMaterno(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloDosProgenitorUno()));
        }
        if(abueloUnoProgenitorDos) {
        	nacimientoEntity.setAbuelaPaterna(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbuelaUnoProgenitorDos()));
        }
        if(abueloDosProgenitorDos) {
        	nacimientoEntity.setAbueloPaterno(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloDosProgenitorDos()));
        }
        
        nacimientoEntity.setTestigoUno(utileria.mapearDtoAEntityPersona(nacimientoDTO.getTestigoUno()));
        nacimientoEntity.setTestigoDos(utileria.mapearDtoAEntityPersona(nacimientoDTO.getTestigoDos()));
        if(comparece==ConstantesComunes.COMPARCENCIA_OTRO) {
        	nacimientoEntity.setPersonaDistintaComparece(utileria.mapearDtoAEntityPersona
                    (nacimientoDTO.getPersonaDistintaComparece()));
        }
        nacimientoEntity.setVivoMuerto(nacimientoDTO.getVivoMuerto());
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

    public void setNacimientoDAO(NacimientoDAO nacimientoDAO) {
        this.nacimientoDAO = nacimientoDAO;
    }

    public NacimientoDAO getNacimientoDAO() {
        return this.nacimientoDAO;
    }
    
    public void setUtileria(UtileriaService utileria) {
    	this.utileria = utileria;
    }
    
    public UtileriaService getUtileria() {
    	return this.utileria;
    }
}
