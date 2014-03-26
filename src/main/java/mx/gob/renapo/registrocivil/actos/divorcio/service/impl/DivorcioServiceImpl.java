package mx.gob.renapo.registrocivil.actos.divorcio.service.impl;

import mx.gob.renapo.registrocivil.actos.divorcio.dao.DivorcioDAO;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.util.Utileria;

import org.springframework.stereotype.Service;


@Service
public class DivorcioServiceImpl {

	private DivorcioDAO divorcioDAO;
	
	/**
     * Metodo para el registro de un nuevo divorcio
     * @param divorcioDTO
     */
	 public void guardarDivorcio(DivorcioDTO divorcioDTO) {
	 
		 Divorcio divorcioEntity = new Divorcio();
		 
		 //Datos del acta divorcio
		 //TODO relacion Acta de matrimonio
		 
		 divorcioEntity.setCadena(divorcioDTO.getActaDivorcio().getCadena()); 
		 divorcioEntity.setOficialia(Utileria.mapearDTOAEntityOficialia(divorcioDTO.getActaDivorcio().getOficialia()));
		 divorcioEntity.setFechaEjecutoria(divorcioDTO.getActaDivorcio().getFechaEjecutoria());
		 divorcioEntity.setFechaRegistro(divorcioDTO.getActaDivorcio().getFechaRegistro());
		 divorcioEntity.setFechaResolucion(divorcioDTO.getActaDivorcio().getFechaResolucion());
		 divorcioEntity.setFoja(divorcioDTO.getActaDivorcio().getFoja());
		 divorcioEntity.setLibro(divorcioDTO.getActaDivorcio().getLibro());
		 divorcioEntity.setTomo(divorcioDTO.getActaDivorcio().getTomo());
		 divorcioEntity.setImArchivo(divorcioDTO.getImArchivo());
		 divorcioEntity.setLocalidadRegistro(Utileria.mapearDTOEntityLocalidad(divorcioDTO.getActaDivorcio().getLocalidadRegistro()));
		 divorcioEntity.setNumActaDivorcio(divorcioDTO.getActaDivorcio().getNumeroActa());
		 divorcioEntity.setRegimen(Utileria.mapearDTOAEntityRegimen(divorcioDTO.getActaDivorcio().getRegimen()));
		 divorcioEntity.setResolucionAdmin(divorcioDTO.getActaDivorcio().getResolucionAdmin());
		 divorcioEntity.setSello(divorcioDTO.getSello());
		 divorcioEntity.setSelloImg(divorcioDTO.getSelloImg());
		 divorcioEntity.setTipoDivorcio(Utileria.mapearDTOAEntityTipoDivorcio(divorcioDTO.getActaDivorcio().getTipoDivorcio()));
		 divorcioEntity.setTribunal(divorcioDTO.getActaDivorcio().getTribunal());
		 divorcioEntity.setCripDivorciadoUno(divorcioDTO.getCripDivorciadoUno());
		 divorcioEntity.setCripDivorciadoDos(divorcioDTO.getCripDivorciadoDos());
		 //Datos tipo Persona de divorcio
		 divorcioEntity.setDivorciadoUno(Utileria.mapearDtoAEntityPersona(divorcioDTO.getDivorciadoUno()));
		 divorcioEntity.setDivorciadoDos(Utileria.mapearDtoAEntityPersona(divorcioDTO.getDivorciadoDos()));
		 divorcioEntity.setTestigoUno(Utileria.mapearDtoAEntityPersona(divorcioDTO.getTestigoUno()));
		 divorcioEntity.setTestigoDos(Utileria.mapearDtoAEntityPersona(divorcioDTO.getTestigoDos()));
		 //Datos estadisticos
		 divorcioEntity.setEscolaridadDivorciadoUno(Utileria.mapearDTOAEntityEscolaridad(divorcioDTO.getDatosEstadisticos().getEscolaridadDivorciadoUno()));
		 divorcioEntity.setEscolaridadDivorciadoDos(Utileria.mapearDTOAEntityEscolaridad(divorcioDTO.getDatosEstadisticos().getEscolaridadDivorciadoDos()));
		 divorcioEntity.setPosTrabDivorciadoUno(Utileria.mapearDTOAEntityPuesto(divorcioDTO.getDatosEstadisticos().getPosTrabDivorciadoUno()));
		 divorcioEntity.setPosTrabDivorciadoDos(Utileria.mapearDTOAEntityPuesto(divorcioDTO.getDatosEstadisticos().getPosTrabDivorciadoDos()));
		 divorcioEntity.setSitLabDivorciadoUno(Utileria.mapearDTOAEntitySituacionLaboral(divorcioDTO.getDatosEstadisticos().getSitLabDivorciadoUno()));
		 divorcioEntity.setSitLabDivorciadoDos(Utileria.mapearDTOAEntitySituacionLaboral(divorcioDTO.getDatosEstadisticos().getSitLabDivorciadoDos()));
		 
		 divorcioDAO.guardarRegistro(divorcioEntity);
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
