package mx.gob.renapo.registrocivil.actos.nacimiento.service.impl;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dao.NacimientoDAO;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.NacimientoService;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

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

    private static Logger logger = Logger.getLogger(NacimientoServiceImpl.class);

	@Autowired
    private NacimientoDAO nacimientoDAO;
	
	@Autowired
	private UtileriaService utileria;

    @Autowired
    private NacimientoDTO nacimientoDTO;


    /**
     * Metodo para el registro de un nuevo nacimiento
     * @param nacimientoDTO
     */
    public NacimientoDTO guardarNacimiento(NacimientoDTO nacimientoDTO, Boolean abueloUnoProgenitorUno,
    	    Boolean abueloDosProgenitorUno, Boolean abueloUnoProgenitorDos,
    	    Boolean abueloDosProgenitorDos, Boolean madreSoltera, Integer comparece){
        Nacimiento nacimientoEntity = mapearNacimiento(nacimientoDTO, abueloUnoProgenitorUno,
        	    abueloDosProgenitorUno, abueloUnoProgenitorDos,
        	    abueloDosProgenitorDos, madreSoltera, comparece);
        try {
            nacimientoEntity = nacimientoDAO.guardarRegistro(nacimientoEntity);
            nacimientoDTO = mapearEntityADtoNacimiento(nacimientoEntity);
            nacimientoDTO.setCodigoError(0);
        }
        catch (Exception e) {
             logger.error("Error: " + e);
             nacimientoDTO.setCodigoError(1);
             nacimientoDTO.setMensajeError(utileria.getStackTrace(e));
        }

            return nacimientoDTO;

    }
    
    

    /**
     * Metodo para la edicion de un nacimiento
     * @param nacimientoDTO
     */
    public void editarNacimiento(NacimientoDTO nacimientoDTO) throws Exception{

    }

    /**
     * Metodo para recuperar un acta de nacimiento por el id
     * @param id
     * @return
     */
    public NacimientoDTO recuperarActaNacimiento(Long id) {
        try {
            nacimientoDTO = mapearEntityADtoNacimiento(nacimientoDAO.recuperarRegistro(id));
            nacimientoDTO.setCodigoError(ConstantesComunes.CODIGO_EXITOSO);
        }catch (Exception e) {
            nacimientoDTO.setCodigoError(ConstantesComunes.CODIGO_ERROR);
            nacimientoDTO.setMensajeError(utileria.getStackTrace(e));
        }

        return nacimientoDTO;
    }

    public Integer borrarNacimiento(NacimientoDTO nacimientoDTO) {
        Integer resultadoRegistro = null;



        return resultadoRegistro;
    }

    /**
     * Metodo para consultar un nacimiento por la cadena
     * @param cadena
     * @return NacimientoDTO
     */
    public List<NacimientoDTO> consultaNacimientoPorCadena(String cadena) {
        List<NacimientoDTO> nacimientoDTOList = new ArrayList<NacimientoDTO>();
        List<Nacimiento> nacimientoList = new ArrayList<Nacimiento>();
        try {
            nacimientoList = nacimientoDAO.consultaActaCadena(cadena);

            if(nacimientoList!=null || !nacimientoList.isEmpty()) {
                for(Nacimiento nacimiento: nacimientoList) {
                    nacimientoDTOList.add(mapearEntityADtoNacimiento(nacimiento));
                }
            }
        }catch (Exception e) {
        }
        return nacimientoDTOList;
    }

    public List<NacimientoDTO> consultaNacimientoPorNumeroActa(Integer anio, String numeroActa) {
        List<NacimientoDTO> nacimientoDTOList = new ArrayList<NacimientoDTO>();
        List<Nacimiento> nacimientoList = new ArrayList<Nacimiento>();
        try {
            nacimientoList = nacimientoDAO.consultaActaNumeroActaAnioRegistro(anio, numeroActa);
            if(nacimientoList!=null || !nacimientoList.isEmpty()) {
                for(Nacimiento nacimiento: nacimientoList) {
                    nacimientoDTOList.add(mapearEntityADtoNacimiento(nacimiento));
                }
            }
        }catch (Exception e) {

        }
        return nacimientoDTOList;
    }

    
    /**
     * Metodo para mapear un objeto  DTO a una entity de Nacimiento
     * @param nacimientoDTO
     * @param abueloUnoProgenitorUno
     * @param abueloDosProgenitorUno
     * @param abueloUnoProgenitorDos
     * @param abueloDosProgenitorDos
     * @param madreSoltera
     * @param comparece
     * @return Nacimiento
     */
    private Nacimiento mapearNacimiento(NacimientoDTO nacimientoDTO, Boolean abueloUnoProgenitorUno,
    	    Boolean abueloDosProgenitorUno, Boolean abueloUnoProgenitorDos,
    	    Boolean abueloDosProgenitorDos, Boolean madreSoltera, Integer comparece) {
    	Nacimiento nacimientoEntity = new Nacimiento();
    	nacimientoEntity.setTomo("");
    	nacimientoEntity.setVersion(1L);
    	nacimientoEntity.setCrip("");
    	nacimientoEntity.setCadena("");
    	nacimientoEntity.setLibro("");
        nacimientoEntity.setFechaRegistro(new Date());
    	nacimientoEntity.setRegistrado(utileria.mapearDtoAEntityPersona(nacimientoDTO.getRegistrado()));
        nacimientoEntity.setMadre(utileria.mapearDtoAEntityPersona(nacimientoDTO.getProgenitorUno()));
        if(!madreSoltera) {
        	nacimientoEntity.setPadre(utileria.mapearDtoAEntityPersona(nacimientoDTO.getProgenitorDos()));
        }
        if(abueloUnoProgenitorUno) {
        	nacimientoEntity.setAbuelaMaterna(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloUnoProgenitorUno()));
            nacimientoEntity.getAbuelaMaterna().setDomicilio(null);
        }
        if(abueloDosProgenitorUno) {
        	nacimientoEntity.setAbueloMaterno(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloDosProgenitorUno()));
            nacimientoEntity.getAbueloMaterno().setDomicilio(null);
        }
        if(abueloUnoProgenitorDos) {
        	nacimientoEntity.setAbuelaPaterna(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbuelaUnoProgenitorDos()));
            nacimientoEntity.getAbuelaPaterna().setDomicilio(null);
        }
        if(abueloDosProgenitorDos) {
        	nacimientoEntity.setAbueloPaterno(utileria.mapearDtoAEntityPersona(nacimientoDTO.getAbueloDosProgenitorDos()));
            nacimientoEntity.getAbueloPaterno().setDomicilio(null);
        }
        if(nacimientoDTO.getTestigoUno()!=null) {
            nacimientoEntity.setTestigoUno(utileria.mapearDtoAEntityPersona(nacimientoDTO.getTestigoUno()));
        }
        if(nacimientoDTO.getTestigoDos()!=null) {
            nacimientoEntity.setTestigoDos(utileria.mapearDtoAEntityPersona(nacimientoDTO.getTestigoDos()));
        }
        if(nacimientoDTO.getCompareceDTO()!=null) {
            nacimientoEntity.setComparece(utileria.recuperarComparece(nacimientoDTO.getCompareceDTO()));
        }
        if(nacimientoDTO.getCompareceDTO().getId().intValue()==ConstantesComunes.COMPARCENCIA_OTRO) {
        	nacimientoEntity.setPersonaDistintaComparece(utileria.mapearDtoAEntityPersona
                    (nacimientoDTO.getPersonaDistintaComparece()));
        }

        nacimientoEntity.setVivoMuerto(nacimientoDTO.getActaNacimiento().getVivoMuerto());
        if(nacimientoDTO.getActaNacimiento().getActaBis()!=null) {
            nacimientoEntity.setActaBis(nacimientoDTO.getActaNacimiento().getActaBis());
        }
        nacimientoEntity.setCadena(nacimientoDTO.getActaNacimiento().getCadena());
        nacimientoEntity.setFoja(nacimientoDTO.getActaNacimiento().getFoja());
        nacimientoEntity.setImArchivo(nacimientoDTO.getImArchivo());
        nacimientoEntity.setLibro(nacimientoDTO.getActaNacimiento().getLibro());
        nacimientoEntity.setFoja(nacimientoDTO.getActaNacimiento().getFoja());
        nacimientoEntity.setParentPersonaDistintaPresenta(
                utileria.recuperarParentesco(nacimientoDTO.getActaNacimiento().getParentescoPersonaDistintaComparece()));
        nacimientoEntity.setAtendioParto(
        		utileria.recuperarAtendioParto(nacimientoDTO.getDatosEstadisticos().getAtendioParto()));
        nacimientoEntity.setOficialia(
        		utileria.recuperarOficialia(nacimientoDTO.getActaNacimiento().getOficialia()));
        nacimientoEntity.setLocalidadRegistro(
        		utileria.recuperarLocalidad(nacimientoDTO.getActaNacimiento().getLocalidadRegistro()));
        nacimientoEntity.setTomo(nacimientoDTO.getActaNacimiento().getTomo());
        nacimientoEntity.setTipoOperacion(nacimientoDTO.getActaNacimiento().getTipoOperacion());
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

        if(nacimientoDTO.isRegistroNormal()) {
            nacimientoEntity.setTipoCaptura('N');
        }
        else if(nacimientoDTO.isRegistroHistorico()) {
            nacimientoEntity.setTipoCaptura('H');
        }
        else if(nacimientoDTO.isRegistroEspecial()) {
            nacimientoEntity.setTipoCaptura('E');
        }

        return nacimientoEntity;
    }



    public NacimientoDTO mapearEntityADtoNacimiento(Nacimiento nacimiento) {

        nacimientoDTO.setId(nacimiento.getId());
        nacimientoDTO.setRegistrado(utileria.mapearEntityDTOPersona(nacimiento.getRegistrado()));
        nacimientoDTO.setProgenitorUno(utileria.mapearEntityDTOPersona(nacimiento.getMadre()));
        if(nacimiento.getAbuelaMaterna()!=null) {
            nacimientoDTO.setAbueloUnoProgenitorUno(utileria.mapearEntityDTOPersona(nacimiento.getAbuelaMaterna()));
        }
        if(nacimiento.getAbueloMaterno()!=null) {
            nacimientoDTO.setAbuelaUnoProgenitorDos(utileria.mapearEntityDTOPersona(nacimiento.getAbueloMaterno()));
        }
        if(nacimiento.getPadre()!=null) {
            nacimientoDTO.setProgenitorDos(utileria.mapearEntityDTOPersona(nacimiento.getPadre()));
            if(nacimiento.getAbuelaPaterna()!=null){
                nacimientoDTO.setAbuelaUnoProgenitorDos(utileria.mapearEntityDTOPersona(nacimiento.getAbuelaPaterna()));
            }
            if(nacimiento.getAbueloPaterno()!=null) {
                nacimientoDTO.setAbueloDosProgenitorDos(utileria.mapearEntityDTOPersona(nacimiento.getAbueloPaterno()));
            }
        }

        nacimientoDTO.setTestigoUno(utileria.mapearEntityDTOPersona(nacimiento.getTestigoUno()));
        nacimientoDTO.setTestigoDos(utileria.mapearEntityDTOPersona(nacimiento.getTestigoDos()));

        if (nacimiento.getComparece().getDescripcion().equals(ConstantesComunes.COMPARECE_OTRO) ||
            nacimiento.getComparece().getDescripcion().equals(ConstantesComunes.COMPARECE_INDETERMINADO)) {
            nacimientoDTO.setPersonaDistintaComparece
                    (utileria.mapearEntityDTOPersona    (nacimiento.getPersonaDistintaComparece()));
        }
        nacimientoDTO.setCompareceDTO(
                utileria.mapeaEntityADtoComparece(nacimiento.getComparece()));
        nacimientoDTO.getActaNacimiento().setHoraNacRegistrado(nacimiento.getHoraNacRegistrado());
        nacimientoDTO.getActaNacimiento().setVacunado(nacimiento.getVacunado());
        nacimientoDTO.getActaNacimiento().setVivoMuerto(nacimiento.getVivoMuerto());
        nacimientoDTO.getActaNacimiento().setActaBis(nacimiento.getActaBis());
        nacimientoDTO.getActaNacimiento().setCadena(nacimiento.getCadena());
        nacimientoDTO.getActaNacimiento().setAnioRegistro(String.valueOf(nacimiento.getFechaRegistro().getYear()));
        nacimientoDTO.getActaNacimiento().setFechaRegistro(nacimiento.getFechaRegistro());
        nacimientoDTO.getActaNacimiento().setActaBis(nacimiento.getActaBis());
        nacimientoDTO.getActaNacimiento().setTomo(nacimiento.getTomo());
        if(nacimiento.getFoja()!=null) {
            nacimientoDTO.getActaNacimiento().setFoja(nacimiento.getFoja());
        }
        if(nacimiento.getTipoOperacion()==ConstantesComunes.TIPO_OPERACION_INSCRIPCION) {
            nacimientoDTO.setTranscripcion(nacimiento.getTranscripcion());
        }
        if (nacimiento.getFechaBorrado()!=null) {
            nacimientoDTO.getActaNacimiento().setFechaBorrado(nacimiento.getFechaBorrado());
        }
       /* nacimientoDTO.getActaNacimiento().setMunicipioRegistro
                (utileria.mapearEntityADtoMunicipio(nacimiento.getOficialia().getMunicipio()));
        nacimientoDTO.getActaNacimiento().setEntidadRegistro(
                utileria.mapearEntityADtoEstado(nacimiento.getOficialia().getMunicipio().getEstado()));
        nacimientoDTO.getActaNacimiento().setOficialia(
                utileria.mapeaEntityOficialiaADTO(nacimiento.getOficialia()));*/

        return nacimientoDTO;
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
