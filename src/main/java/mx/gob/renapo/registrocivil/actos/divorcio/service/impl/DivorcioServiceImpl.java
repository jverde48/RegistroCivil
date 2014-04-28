package mx.gob.renapo.registrocivil.actos.divorcio.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.gob.renapo.registrocivil.actos.divorcio.dao.DivorcioDAO;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.entity.Divorcio;
import mx.gob.renapo.registrocivil.actos.divorcio.service.DivorcioService;
import mx.gob.renapo.registrocivil.actos.divorcio.util.DivorcioUtilService;
import mx.gob.renapo.registrocivil.actos.matrimonio.dao.MatrimonioDAO;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.actos.matrimonio.util.MatrimonioUtilService;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.Nacimiento;
import mx.gob.renapo.registrocivil.actos.reconocimiento.entity.Reconocimiento;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatCompareceServiceImpl;
import mx.gob.renapo.registrocivil.comun.dao.PersonaDAO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import mx.gob.renapo.registrocivil.util.UtileriaService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DivorcioServiceImpl implements DivorcioService {

	@Autowired
	private DivorcioDAO divorcioDAO;
	
	@Autowired
	private MatrimonioDAO matrimonioDAO;
	
	@Autowired
	private PersonaDAO personaDAO;
	
	@Autowired
    private UtileriaService utileriaService;
	
	@Autowired
	private DivorcioUtilService divorcioUtilService;
	
	@Autowired
	private MatrimonioUtilService matrimonioUtilService;
	
	@Autowired
	private DivorcioDTO divorcioDTO;
	
	private static Logger logger = Logger.getLogger(DivorcioServiceImpl.class);
	/**
     * Metodo para el registro de un nuevo divorcio
     * @param divorcioDTO
     */
	@Override
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
			 divorcioEntity.setNumeroActa("");
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
			 if(divorcioDTO.isNormal()){
				 //TODO Obtener contrayentes del acta de matrimonio
				 divorcioEntity.setDivorciadoUno(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getDivorciadoUno()));
				 divorcioEntity.setDivorciadoDos(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getDivorciadoDos()));
			 }else{
				 //if(divorcioDTO.getActaMatrimonio().getActaMatrimonioDTO().getId == null){
					 if(divorcioDTO.getDivorciadoUno().getId() == null)
						 divorcioEntity.setDivorciadoUno(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getDivorciadoUno()));
					 else
						 divorcioEntity.setDivorciadoUno(personaDAO.recuperarRegistro(divorcioDTO.getDivorciadoUno().getId()));
					 
					 if(divorcioDTO.getDivorciadoDos().getId() == null)
						 divorcioEntity.setDivorciadoDos(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getDivorciadoDos()));
					 else
						 divorcioEntity.setDivorciadoDos(personaDAO.recuperarRegistro(divorcioDTO.getDivorciadoDos().getId()));
			 }
			 	
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
			 if(divorcioDTO.isHistorico() || 
					 divorcioDTO.getActaDivorcio().getTipoDivorcio().getDescripcion().equals(ConstantesComunes.TIPO_DIVORCIO_ADMINISTRATIVO) ||
					 divorcioDTO.getActaDivorcio().getTipoDivorcio().getDescripcion().equals(ConstantesComunes.TIPO_DIVORCIO_INDETERMINADO)){
				 
				 if(divorcioDTO.getTestigoUno().getId() == null)
					 divorcioEntity.setTestigoUno(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getTestigoUno()));
				 else
					 divorcioEntity.setTestigoUno(personaDAO.recuperarRegistro(divorcioDTO.getTestigoUno().getId()));
				 
				 if(divorcioDTO.getTestigoDos().getId() == null)
				 	divorcioEntity.setTestigoDos(utileriaService.mapearDtoAEntityPersona(divorcioDTO.getTestigoDos()));
				 else
					 divorcioEntity.setTestigoDos(personaDAO.recuperarRegistro(divorcioDTO.getTestigoDos().getId())); 
				
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
	@Override
	 public void editarDivorcio(DivorcioDTO divorcioDTO){
		
	 }
	 
	 /**
     * Metodo para la eliminacion de un divorcio
     */
    public void eliminarDivorcio(Long idDivorcio){

        try{

            Divorcio divorcio = divorcioDAO.recuperarRegistro(idDivorcio);

            divorcio.setFechaBorrado(new Date());
            divorcioDAO.borrarRegistro(divorcio);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    
	 /**
	     * Metodo para consultar un divorcio por la cadena
	     * @param cadena
	     * @return DivorcioDTO
	     */
	@Override
    public List<DivorcioDTO> consultaDivorcioPorCadena(String cadena) {
		
        List<DivorcioDTO> divorcioDTOList = new ArrayList<DivorcioDTO>();
        List<Divorcio> divorcioList = new ArrayList<Divorcio>();
        try {
            divorcioList = divorcioDAO.consultaActaCadena(cadena);

            if(divorcioList!=null || !divorcioList.isEmpty()) {
                for(Divorcio divorcio: divorcioList) {
                    divorcioDTOList.add(divorcioUtilService.mapearEntityDivorcioADTO(divorcio));
                }
            }
        }catch (Exception e) {
        }
        return divorcioDTOList;
	}
	    
    @Override
    public List<DivorcioDTO> consultaDivorcioPorNumeroActa(Integer anio, String numeroActa) {
    
        List<DivorcioDTO> divorcioDTOList = new ArrayList<DivorcioDTO>();
        List<Divorcio> divorcioList = new ArrayList<Divorcio>();
        try {
            divorcioList = divorcioDAO.consultaActaNumeroActaAnioRegistro(anio, numeroActa);
            if(divorcioList!=null || !divorcioList.isEmpty()) {
                for(Divorcio divorcio: divorcioList) {
                    divorcioDTOList.add(divorcioUtilService.mapearEntityDivorcioADTO(divorcio));
                }
            }
        }catch (Exception e) {

        }
        return divorcioDTOList;
    }   
	 
	 public MatrimonioDTO recuperarMatrimonioPorCadena(String cadena){
		 
		 MatrimonioDTO matrimonioDTO = null;
		 List<MatrimonioDTO> matrimonioDTOList = new ArrayList<MatrimonioDTO>();
	     List<Matrimonio> matrimonioList = new ArrayList<Matrimonio>();
	     
	        try {
	            matrimonioList = matrimonioDAO.consultaActaCadena(cadena);

	            if(matrimonioList!=null || !matrimonioList.isEmpty()) {
	                for(Matrimonio matrimonio: matrimonioList) {
	                    matrimonioDTOList.add(matrimonioUtilService.mapearEntityMatrimonioADTO(matrimonio));
	                }
	            }
	        }catch (Exception e) {
	        }
		 
		 
		 matrimonioDTO = matrimonioDTOList.get(0);
		 
		 
		 return matrimonioDTO;
	 }
	 
	 public DivorcioDTO findById(Long id) {
        DivorcioDTO divorcioDTO = null;
        	
        try {
            Divorcio divorcioEntity = divorcioDAO.recuperarRegistro(id);
            logger.info("DIVORCIO " + divorcioEntity.getCadena());
            if (divorcioEntity != null) {
            	logger.info("DENTRO DEL IF ");
                divorcioDTO = new DivorcioDTO();
                
                divorcioDTO = divorcioUtilService.mapearEntityDivorcioADTO(divorcioEntity);
                logger.info("DIVORCIO DTO " + divorcioDTO.getActaDivorcio().getCadena());
            }

        }catch (Exception e) {
            logger.error("Error: " + e);
        }

        return divorcioDTO;
    }
	 
	 public void setDivorcioDAO(DivorcioDAO divorcioDAO) {
	        this.divorcioDAO = divorcioDAO;
	    }

    public DivorcioDAO getDivorcioDAO() {
        return this.divorcioDAO;
    }
    
}
