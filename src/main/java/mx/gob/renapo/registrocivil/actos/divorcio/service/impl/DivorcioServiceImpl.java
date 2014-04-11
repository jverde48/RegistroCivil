package mx.gob.renapo.registrocivil.actos.divorcio.service.impl;

import java.util.Date;

import mx.gob.renapo.registrocivil.actos.divorcio.dao.DivorcioDAO;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.actos.divorcio.util.DivorcioUtilService;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatCompareceServiceImpl;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import mx.gob.renapo.registrocivil.util.UtileriaService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DivorcioServiceImpl {

	@Autowired
	private DivorcioDAO divorcioDAO;
	
	@Autowired
    private UtileriaService utileriaService;
	
	@Autowired
	private DivorcioUtilService divorcioUtilService;
	
	private static Logger logger = Logger.getLogger(CatCompareceServiceImpl.class);
	/**
     * Metodo para el registro de un nuevo divorcio
     * @param divorcioDTO
     */
	 public DivorcioDTO  guardarDivorcio(DivorcioDTO divorcioDTO) {
	 
		 Divorcio divorcioEntity = new Divorcio();
		 DivorcioDTO divorcioDTOResponse = null;
		 
		 
		 try{
			 
			 
			 //TODO relacion Acta de matrimonio
			 /**
			  * Datos del acta de divorcio
			  */
		 
			 divorcioEntity.setActaMatrimonio(null);
			 divorcioEntity.setCadena(""); 
			 divorcioEntity.setActaBis(0);
			 divorcioEntity.setImArchivo("");
			 divorcioEntity.setNumActaDivorcio("");
			 //divorcioEntity.setOficialia(utileriaService);
			 divorcioEntity.setFechaEjecutoria(divorcioDTO.getActaDivorcio().getFechaEjecutoria());
			 divorcioEntity.setFechaRegistro(new Date());
			 divorcioEntity.setFechaResolucion(divorcioDTO.getActaDivorcio().getFechaResolucion());
			 divorcioEntity.setResolucionAdmin(divorcioDTO.getActaDivorcio().getResolucionAdmin());
			 divorcioEntity.setSello("");
			 divorcioEntity.setSelloImg("");
			 divorcioEntity.setTipoDivorcio(utileriaService.recuperarTipoDivorcio(divorcioDTO.getActaDivorcio().getTipoDivorcio()));
			 divorcioEntity.setTipoDocumento(null);
			 divorcioEntity.setVersion(1L);
			 divorcioEntity.setAutoridad(divorcioDTO.getActaDivorcio().getAutoridad());
			 
			 //Tipo de captura Normal
			 if(divorcioDTO.isNormal()){
				 divorcioEntity.setTipoCaptura('N');
				 divorcioEntity.setLlaveOriginal("");
				 divorcioEntity.setFoja("");
				 divorcioEntity.setLibro("");
				 divorcioEntity.setTomo("");
			 }else{ 
				 divorcioEntity.setFoja(divorcioDTO.getActaDivorcio().getFoja());
				 divorcioEntity.setLibro(divorcioDTO.getActaDivorcio().getLibro());
				 divorcioEntity.setTomo(divorcioDTO.getActaDivorcio().getTomo());
				 //Tipo de captura Historico
				 if(divorcioDTO.isHistorico()){
					 divorcioEntity.setLlaveOriginal(divorcioDTO.getActaDivorcio().getLlaveOriginal());
					 divorcioEntity.setTipoCaptura('H');
				 //Tipo de captura Especial	 
				 }else if(divorcioDTO.isEspecial()){
					 divorcioEntity.setLlaveOriginal("");
					 divorcioEntity.setTipoCaptura('E');
				 }
			 }
			 /**
			  * Datos de los divorciados
			  */
			 divorcioEntity.setDivorciadoUno(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getDivorciadoUno()));
			 divorcioEntity.setDivorciadoDos(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getDivorciadoDos()));
			 /**
			  * Datos estadisticos de los divorciados
			  */
			 divorcioEntity.setEscolaridadDivorciadoUno(utileriaService.recuperarEscolaridad(divorcioDTO.getDatosEstadisticos().getEscolaridadDivorciadoUno()));
			 divorcioEntity.setEscolaridadDivorciadoDos(utileriaService.recuperarEscolaridad(divorcioDTO.getDatosEstadisticos().getEscolaridadDivorciadoDos()));
			 
			 divorcioEntity.setPosTrabDivorciadoUno(utileriaService.recuperarPuesto(divorcioDTO.getDatosEstadisticos().getPosTrabDivorciadoUno()));
			 divorcioEntity.setPosTrabDivorciadoDos(utileriaService.recuperarPuesto(divorcioDTO.getDatosEstadisticos().getPosTrabDivorciadoDos()));
			 
			 divorcioEntity.setSitLabDivorciadoUno(utileriaService.recuperarSituacionLaboral(divorcioDTO.getDatosEstadisticos().getSitLabDivorciadoUno()));
			 divorcioEntity.setSitLabDivorciadoDos(utileriaService.recuperarSituacionLaboral(divorcioDTO.getDatosEstadisticos().getSitLabDivorciadoDos()));
			 
			 /**
			  * Datos de los testigos
			 */ 
			 if(divorcioDTO.isHistorico() || divorcioDTO.getActaDivorcio().getTipoDivorcio().getDescripcion().equals(ConstantesComunes.ADMINISTRATIVO)){
				 divorcioEntity.setTestigoUno(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getTestigoUno()));
				 divorcioEntity.setTestigoDos(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getTestigoDos()));
				
				 divorcioEntity.setParentescoTestigoUno(utileriaService.recuperarParentesco(divorcioDTO.getParentescoTestigoUno()));
				 divorcioEntity.setParentescoTestigoDos(utileriaService.recuperarParentesco(divorcioDTO.getParentescoTestigoDos()));
			 }
			 
			 
			 divorcioDTOResponse = divorcioUtilService.mapearEntityDivorcioADTO(divorcioDAO.guardarRegistro(divorcioEntity));
			 
			 return divorcioDTOResponse;
		 }catch (Exception e) {
	           logger.info("Error DivorcioServiceImpl: " + e);
	           e.printStackTrace();
	           divorcioDTOResponse = new DivorcioDTO();
	           divorcioDTOResponse.setCodigoRespuesta(1);
	           divorcioDTOResponse.setMensajeError(utileriaService.getStackTrace(e));
	          return divorcioDTOResponse;
	     }
	 }
	
	
	 /**
	     * Metodo para la edicion de un divorcio
	     * @param divorcioDTO
	     */
	 public void editarDivorcio(DivorcioDTO divorcioDTO){
		 
	 }
	 
	 public void setDivorcioDAO(DivorcioDAO divorcioDAO) {
	        this.divorcioDAO = divorcioDAO;
	    }

    public DivorcioDAO getDivorcioDAO() {
        return this.divorcioDAO;
    }
}
