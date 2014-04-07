package mx.gob.renapo.registrocivil.actos.divorcio.service.impl;

import mx.gob.renapo.registrocivil.actos.divorcio.dao.DivorcioDAO;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DivorcioServiceImpl {

	private DivorcioDAO divorcioDAO;
	
	@Autowired
    private UtileriaService utileriaService;
	
	/**
     * Metodo para el registro de un nuevo divorcio
     * @param divorcioDTO
     */
	 public boolean  guardarDivorcio(DivorcioDTO divorcioDTO) {
	 
		 Divorcio divorcioEntity = new Divorcio();
		 
		 //TODO relacion Acta de matrimonio
		 /**
		  * Datos del acta de divorcio
		  */
		 divorcioEntity.setActaMatrimonio(null);
		 divorcioEntity.setCadena(""); 
		 //divorcioEntity.setOficialia(utileriaService);
		 divorcioEntity.setFechaEjecutoria(null);
		 divorcioEntity.setFechaRegistro(null);
		 divorcioEntity.setFechaResolucion(null);
		 divorcioEntity.setFoja("");
		 divorcioEntity.setLibro("");
		 divorcioEntity.setTomo("");
		 divorcioEntity.setImArchivo("");
		 divorcioEntity.setNumActaDivorcio("");
		 divorcioEntity.setRegimen(utileriaService.recuperarRegimen(divorcioDTO.getActaDivorcio().getRegimen()));
		 divorcioEntity.setResolucionAdmin(divorcioDTO.getActaDivorcio().getResolucionAdmin());
		 divorcioEntity.setSello("");
		 divorcioEntity.setSelloImg("");
		 divorcioEntity.setTipoDivorcio(utileriaService.recuperarTipoDivorcio(divorcioDTO.getActaDivorcio().getTipoDivorcio()));
		 divorcioEntity.setTribunal(divorcioDTO.getActaDivorcio().getTribunal());
		 divorcioEntity.setTipoCaptura('N');
		 divorcioEntity.setVersion(1L);
		 divorcioEntity.setActaBis(0);
		 divorcioEntity.setLlaveOriginal("");
		 
		 /**
		  * Datos de los divorciados
		  */
		 divorcioEntity.setDivorciadoUno(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getDivorciadoUno()));
		 divorcioEntity.setDivorciadoDos(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getDivorciadoDos()));
		 
		 divorcioEntity.setEscolaridadDivorciadoUno(utileriaService.recuperarEscolaridad(divorcioDTO.getDatosEstadisticos().getEscolaridadDivorciadoUno()));
		 divorcioEntity.setEscolaridadDivorciadoDos(utileriaService.recuperarEscolaridad(divorcioDTO.getDatosEstadisticos().getEscolaridadDivorciadoDos()));
		 
		 divorcioEntity.setPosTrabDivorciadoUno(utileriaService.recuperarPuesto(divorcioDTO.getDatosEstadisticos().getPosTrabDivorciadoUno()));
		 divorcioEntity.setPosTrabDivorciadoDos(utileriaService.recuperarPuesto(divorcioDTO.getDatosEstadisticos().getPosTrabDivorciadoDos()));
		 
		 divorcioEntity.setSitLabDivorciadoUno(utileriaService.recuperarSituacionLaboral(divorcioDTO.getDatosEstadisticos().getSitLabDivorciadoUno()));
		 divorcioEntity.setSitLabDivorciadoDos(utileriaService.recuperarSituacionLaboral(divorcioDTO.getDatosEstadisticos().getSitLabDivorciadoDos()));
		 
		 /**
		  * Datos de los testigos
		  */
		 divorcioEntity.setTestigoUno(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getTestigoUno()));
		 divorcioEntity.setTestigoDos(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getTestigoDos()));
		 
		 divorcioEntity.setParentescoTestigoUno(utileriaService.recuperarParentesco(divorcioDTO.getParentescoTestigoUno()));
		 divorcioEntity.setParentescoTestigoDos(utileriaService.recuperarParentesco(divorcioDTO.getParentescoTestigoDos()));
		 
		 //divorcioDAO.guardarRegistro(divorcioEntity);
		 
		 return false;
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
