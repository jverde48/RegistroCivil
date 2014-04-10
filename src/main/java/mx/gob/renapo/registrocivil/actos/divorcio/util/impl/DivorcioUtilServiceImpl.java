package mx.gob.renapo.registrocivil.actos.divorcio.util.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.ActaDivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.EstadisticosDivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.actos.divorcio.util.DivorcioUtilService;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import mx.gob.renapo.registrocivil.util.UtileriaService;

@Data
@Service
public class DivorcioUtilServiceImpl implements DivorcioUtilService {

	@Autowired
	private UtileriaService utileriaService;
	
	public DivorcioDTO mapearEntityDivorcioADTO(Divorcio divorcioEntity){
		
		DivorcioDTO divorcioDTO=new DivorcioDTO();
		
		//Divorciados
		divorcioDTO.setDivorciadoUno(utileriaService.mapearEntityDTOPersona(divorcioEntity.getDivorciadoUno()));
		divorcioDTO.setDivorciadoDos(utileriaService.mapearEntityDTOPersona(divorcioEntity.getDivorciadoDos()));
		
		
		if(divorcioEntity.getTipoDivorcio().getDescripcion().equals(ConstantesComunes.ADMINISTRATIVO)){
			//Testigos
			divorcioDTO.setTestigoUno(utileriaService.mapearEntityDTOPersona(divorcioEntity.getTestigoUno()));
			divorcioDTO.setTestigoDos(utileriaService.mapearEntityDTOPersona(divorcioEntity.getTestigoDos()));
		
			//Parentesco de testigos
			divorcioDTO.setParentescoTestigoUno(utileriaService.mapearEntityADTOParentesco(divorcioEntity.getParentescoTestigoUno()));
			divorcioDTO.setParentescoTestigoDos(utileriaService.mapearEntityADTOParentesco(divorcioEntity.getParentescoTestigoDos()));
		}
		
		//Datos estadisticos de divorciados
		divorcioDTO.setDatosEstadisticos(mapearDatosEstadisticos(divorcioEntity));
		
		//Datos acta
		divorcioDTO.setActaDivorcio(mapearDatosActa(divorcioEntity));
		
		divorcioDTO.setCodigoRespuesta(0);
		return divorcioDTO;
	}
	
	public EstadisticosDivorcioDTO mapearDatosEstadisticos(Divorcio divorcioEntity){
		EstadisticosDivorcioDTO estadisticosDTO = new EstadisticosDivorcioDTO();
		
		estadisticosDTO.setEscolaridadDivorciadoUno(utileriaService.mapearEntityADTOEscolaridad(divorcioEntity.getEscolaridadDivorciadoUno()));
		estadisticosDTO.setEscolaridadDivorciadoDos(utileriaService.mapearEntityADTOEscolaridad(divorcioEntity.getEscolaridadDivorciadoDos()));
		estadisticosDTO.setPosTrabDivorciadoUno(utileriaService.mapearEntityADTOPuesto(divorcioEntity.getPosTrabDivorciadoUno()));
		estadisticosDTO.setPosTrabDivorciadoDos(utileriaService.mapearEntityADTOPuesto(divorcioEntity.getPosTrabDivorciadoDos()));
		estadisticosDTO.setSitLabDivorciadoUno(utileriaService.mapearEntityADTOSituacionLaboral(divorcioEntity.getSitLabDivorciadoUno()));
		estadisticosDTO.setSitLabDivorciadoDos(utileriaService.mapearEntityADTOSituacionLaboral(divorcioEntity.getSitLabDivorciadoDos()));
		
		return estadisticosDTO;
	}
	
	public ActaDivorcioDTO mapearDatosActa(Divorcio divorcioEntity){
		ActaDivorcioDTO actaDTO = new ActaDivorcioDTO();
		
		actaDTO.setActaBis(divorcioEntity.getActaBis());
		actaDTO.setAnioRegistro(String.valueOf(obtenerAnioRegistro(divorcioEntity.getFechaRegistro())));
		actaDTO.setAutoridad(divorcioEntity.getAutoridad());
		actaDTO.setCadena(divorcioEntity.getCadena());
		/*actaDTO.setOficialia(utileriaService.mapeaEntityOficialiaADTO(
        		divorcioEntity.getOficialia()));
		actaDTO.setOficial(utileriaService.mapeaEntityOficialADTO(
		        divorcioEntity.getOficialia().getIdOficial()));
		actaDTO.setEntidadRegistro(utileriaService.mapearEntityADtoEstado(
		        divorcioEntity.getOficialia().getMunicipio().getEstado()));
		actaDTO.setMunicipioRegistro(utileriaService.mapearEntityADtoMunicipio(
		        divorcioEntity.getOficialia().getMunicipio()));
		actaDTO.setLocalidadRegistro(utileriaService.mapearEntityADTOLocalidad(
		        divorcioEntity.getOficialia().getLocalidad()));
		*/
		actaDTO.setFechaEjecutoria(divorcioEntity.getFechaEjecutoria());
		actaDTO.setFechaRegistro(divorcioEntity.getFechaRegistro());
		actaDTO.setFechaResolucion(divorcioEntity.getFechaResolucion());
		actaDTO.setFoja(divorcioEntity.getFoja());
		actaDTO.setLibro(divorcioEntity.getLibro());
		actaDTO.setLlaveOriginal(divorcioEntity.getLlaveOriginal());
		actaDTO.setNotasMarginales(null);
		actaDTO.setNumeroActa(divorcioEntity.getNumActaDivorcio());
		actaDTO.setResolucionAdmin(divorcioEntity.getResolucionAdmin());
		actaDTO.setTipoDivorcio(utileriaService.mapeaEntityTipoDivorcioADTO(divorcioEntity.getTipoDivorcio()));
		//actaDTO.setTipoDocumento(divorcioEntity.getTipoDocumento());
		actaDTO.setTipoOperacion(divorcioEntity.getTipoOperacion());
		actaDTO.setTomo(divorcioEntity.getTomo());
		
		return actaDTO;
	}
	
	private static Integer obtenerAnioRegistro(Date fechaRegistro) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaRegistro);

        return calendar.get(Calendar.YEAR);
    }
}
