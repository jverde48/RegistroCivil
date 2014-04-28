package mx.gob.renapo.registrocivil.actos.divorcio.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.service.impl.DivorcioServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.CatOficialiaService;
import mx.gob.renapo.registrocivil.catalogos.service.impl.*;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@ManagedBean(name="divorcioBean")
@ViewScoped
@Component
public class DivorcioBean implements Serializable {
	private static Logger logger = Logger.getLogger(DivorcioBean.class);

	private static final long serialVersionUID = 1L;
	
	@Autowired
    private DivorcioDTO divorcioDTO;
    
    @Autowired
    private DivorcioDTO divorcioDetalle;
   
    /**
     * Beans de services
     */
    @Autowired
    private DivorcioServiceImpl divorcioService;
    
    /**
     * Services para carga de informacion de catalogos lugar de nacimiento
     */
    @Autowired
    private CatPaisServiceImpl paisService;
    @Autowired
    private CatEstadoServiceImpl estadoService;
    @Autowired
    private CatMunicipioServiceImpl municipioService;
    
    /**
     * Services para carga de informacion de catalogos de domicilio
     */
    @Autowired
    private CatInegiPaisServiceImpl inegiPaisService;
    @Autowired
    private CatInegiEstadoServiceImpl inegiEstadoService;
    @Autowired
    private CatInegiMunicipioServiceImpl inegiMunicipioService;
    @Autowired
    private CatTipoLocalidadServiceImpl tipoLocalidadService;
    @Autowired
    private CatColoniaLocalidadServiceImpl inegiLocalidadService;
    
    /**
     * Services para carga de informacion de catalogos de testigos
     */
    @Autowired
    private CatEstadoCivilServiceImpl estadoCivilService;
    @Autowired
    private CatParentescoServiceImpl parentescoService;
    
    /**
     * Services para carga de informacion de catalogos estadisticos
     */
    @Autowired
    private CatEscolaridadServiceImpl escolaridadService;
    @Autowired
    private CatSituacionLaboralServiceImpl situacionLaboralService;
    @Autowired
    private CatPuestoServiceImpl puestoService;
    
    /**
     * Services para carga de informacion de catalogos de informacion del acta
     */
    @Autowired
    private CatTipoDivorcioServiceImpl tipoDivorcioService;
   
    /**
     * Service para carga de oficialias en registro historico
     */
    @Autowired
	private CatOficialiaService oficialiaService;
    
    /**
     * Beans listas para catalogos de paises
     */
    private List<PaisDTO> paises;
    private List<PaisDTO> paisesInegi;
    private List<CatTipoDivorcioDTO> tipoDivorcioList;
    
    /**
     * Beans listas para catalogos de datos de Nacimiento Divorciado Uno
     */
    private List<EstadoDTO> estadosDivorciadoUno;
    private List<MunicipioDTO> municipiosDivorciadoUno;
   
    /**
     * Beans listas para catalogos de datos de Nacimiento Divorciado Dos
     */
    private List<EstadoDTO> estadosDivorciadoDos;
    private List<MunicipioDTO> municipiosDivorciadoDos;
    
    /**
     * Beans listas para catalogos de datos de Testigos
     */
    private List<CatParentescoDTO> parentescoList;
    private List<CatEstadoCivilDTO> estadoCivilList;
    
    /**
     * Beans listas para catalogos de datos de Domicilio Divorciado Uno
     */
    private List<EstadoDTO> estadosInegiDivorciadoUno;
    private List<MunicipioDTO> municipiosInegiDivorciadoUno;
    private List<LocalidadDTO> localidadesInegiDivorciadoUno;
    private List<CatTipoLocalidadDTO> tipoLocalidadDivorciadoUno;
    /**
     * Beans listas para catalogos de datos de Domicilio Divorciado Dos
     */
    private List<EstadoDTO> estadosInegiDivorciadoDos;
    private List<MunicipioDTO> municipiosInegiDivorciadoDos;
    private List<LocalidadDTO> localidadesInegiDivorciadoDos;
    private List<CatTipoLocalidadDTO> tipoLocalidadDivorciadoDos;
    
    /**
     * Beans listas para catalogos de datos de Domicilio Testigo Uno
     */
    private List<EstadoDTO> estadosInegiTestigoUno;
    private List<MunicipioDTO> municipiosInegiTestigoUno;
    private List<LocalidadDTO> localidadesInegiTestigoUno;
    private List<CatTipoLocalidadDTO> tipoLocalidadTestigoUno;
    /**
     * Beans listas para catalogos de datos de Domicilio Testigo Dos
     */
    private List<EstadoDTO> estadosInegiTestigoDos;
    private List<MunicipioDTO> municipiosInegiTestigoDos;
    private List<LocalidadDTO> localidadesInegiTestigoDos;
    private List<CatTipoLocalidadDTO> tipoLocalidadTestigoDos;
    
    /**
     * Beans listas para catalogos de datos Estadisticos
     */
    
    private List<CatEscolaridadDTO> escolaridadList;
    private List<CatSituacionLaboralDTO> situacionLaboralList;
    private List<CatPuestoDTO> posicionTrabajoList;
   
    /**
     * Beans listas para estados, municipios y oficialias de registro historico
     */
  	private List<EstadoDTO> estadosActa;
  	private List<MunicipioDTO> municipiosMatrimonio;
  	private List<MunicipioDTO> municipiosDivorcio;
  	private List<OficialiaDTO> oficialiasMatrimonio;
  	private List<OficialiaDTO> oficialiasDivorcio;
  	
  	/**
  	 * Lista para divorcios encontrados en consulta
  	 */
  	private List<DivorcioDTO> divorcios;
  	
  	/**
  	 * Metodo para consultar divorcios por cadena
  	 */
  	public void consultaDivorcioPorCadena() throws IOException{
  		
  		setDivorcios(divorcioService.consultaDivorcioPorCadena(
                getDivorcioDTO().getActaDivorcio().getCadena()));
  	}
  	
  	/**
  	 * Metodo para consultar divorcios por numero de acta
  	 */
  	public void consultaDivorcioPorNumeroActa() throws IOException{
  		
  		 setDivorcios(divorcioService.consultaDivorcioPorNumeroActa(
  				Integer.valueOf(getDivorcioDTO().getActaDivorcio().getAnioRegistro()), getDivorcioDTO().getActaDivorcio().getNumeroActa()));

  	}
  	
  	/**
     * Metodo para buscar un matrimonio por cadena
     
    
    public void buscarMatrimonioPorCadena() throws IOException{
    	logger.debug("CADENA " + divorcioDTO.getActaMatrimonio().getActaMatrimonioDTO().getCadena());
    	
    	//getDivorcioDTO().getActaMatrimonio().getActaMatrimonioDTO().setCadena("12345678900987654321");
    	
    	getDivorcioDTO().setActaMatrimonio(divorcioService.recuperarMatrimonioPorCadena(divorcioDTO.getActaMatrimonio().getActaMatrimonioDTO().getCadena()));
		getDivorcioDTO().setDivorciadoUno(divorcioDTO.getActaMatrimonio().getContrayenteUno());
		getDivorcioDTO().setDivorciadoDos(divorcioDTO.getActaMatrimonio().getContrayenteDos());
    }
    */
    
  	/**
     * Metodo que recupera los estados de renapo del pais seleccionado
     */
    public void consultaEstados(Integer persona) {
    	
    	switch (persona){
    	
    	case 1:
    		estadosDivorciadoUno = estadoService.recuperarPorPais
			(divorcioDTO.getDivorciadoUno().getPaisNacimiento());
    		break;
    	case 2:
    		estadosDivorciadoDos = estadoService.recuperarPorPais
			(divorcioDTO.getDivorciadoDos().getPaisNacimiento());
    		break;
    
    	}
    }
    
    /**
     * Metodo que recupera los municipios de renapo del estado seleccionado
     */
    public void consultaMunicipios(Integer persona) {
    	
    	switch(persona){
    	
    	case 1:
    		municipiosDivorciadoUno = municipioService.recuperarMunicipiosPorEstado
			(divorcioDTO.getDivorciadoUno().getEntidadNacimiento());
    		break;
    	case 2:
    		municipiosDivorciadoDos = municipioService.recuperarMunicipiosPorEstado
			(divorcioDTO.getDivorciadoDos().getEntidadNacimiento());
    		break;
    	}
    	
    }
    
    /**
     * Metodo que recupera los estados de inegi del pais seleccionado
     */
    public void consultaEstadosInegi(Integer persona) {
    
    	switch (persona){
    	case 1:
    		estadosInegiDivorciadoUno = inegiEstadoService.recupearEstadosPorPais
			(divorcioDTO.getDivorciadoUno().getDomicilio().getPais());
    		break;
    	case 2:
    		estadosInegiDivorciadoDos = inegiEstadoService.recupearEstadosPorPais
			(divorcioDTO.getDivorciadoDos().getDomicilio().getPais());
    		break;
    	case 3:
    		estadosInegiTestigoUno = inegiEstadoService.recupearEstadosPorPais
			(divorcioDTO.getTestigoUno().getDomicilio().getPais());
    		break;
    	case 4:
    		estadosInegiTestigoDos = inegiEstadoService.recupearEstadosPorPais
			(divorcioDTO.getTestigoDos().getDomicilio().getPais());
    		break;
    	}
    	
    }
    
    /**
     * Metodo que recupera los municipios de inegi del estado seleccionado
     */
    public void consultaMunicipiosInegi(Integer persona) {
    	
    	switch (persona){
    	case 1:
    		municipiosInegiDivorciadoUno = inegiMunicipioService.recuperaMunicipiosPorEstado
			(divorcioDTO.getDivorciadoUno().getDomicilio().getEstado());
    		break;
    	case 2:
    		municipiosInegiDivorciadoDos = inegiMunicipioService.recuperaMunicipiosPorEstado
			(divorcioDTO.getDivorciadoDos().getDomicilio().getEstado());
    		break;
    	case 3:
    		municipiosInegiTestigoUno = inegiMunicipioService.recuperaMunicipiosPorEstado
			(divorcioDTO.getTestigoUno().getDomicilio().getEstado());
    		break;
    	case 4:
    		municipiosInegiTestigoDos = inegiMunicipioService.recuperaMunicipiosPorEstado
			(divorcioDTO.getTestigoDos().getDomicilio().getEstado());
    		break;
    	}
    	
    }
    
    /**
     * Metodo que recupera las localidades de inegi del municipio seleccionado para el domicilio
     */
    public void consultaLocalidades(Integer persona){
    	
    	switch(persona){
    	case 1:
    		localidadesInegiDivorciadoUno = inegiLocalidadService.findAllByMunicipio
    		(divorcioDTO.getDivorciadoUno().getDomicilio().getMunicipio());
    		tipoLocalidadDivorciadoUno = tipoLocalidadService.findAll();
    		break;
    	case 2:
    		localidadesInegiDivorciadoDos = inegiLocalidadService.findAllByMunicipio
    		(divorcioDTO.getDivorciadoDos().getDomicilio().getMunicipio());
    		tipoLocalidadDivorciadoDos = tipoLocalidadService.findAll();
    		break;
    	case 3:
    		localidadesInegiTestigoUno = inegiLocalidadService.findAllByMunicipio
    		(divorcioDTO.getTestigoUno().getDomicilio().getMunicipio());
    		tipoLocalidadTestigoUno = tipoLocalidadService.findAll();
    		break;
    	case 4:
    		localidadesInegiTestigoDos = inegiLocalidadService.findAllByMunicipio
    		(divorcioDTO.getTestigoDos().getDomicilio().getMunicipio());
    		tipoLocalidadTestigoDos = tipoLocalidadService.findAll();
    		break;
    	}
    	
    }
    
    /**
     * Metodo para cargar oficilias por municipio
     */
    public void cargarOficialiasMatrimonio(){
        oficialiasMatrimonio = oficialiaService.findByMunicipio(
        		
                divorcioDTO.getActaMatrimonio().getActaMatrimonioDTO().getMunicipioRegistro());
    }
    
    public void cargarOficialiasDivorcio(){
        oficialiasDivorcio = oficialiaService.findByMunicipio(
                divorcioDTO.getActaDivorcio().getMunicipioRegistro());
    }
    
    public void mostrarDivorcioDetalle(DivorcioDTO divorcioDetalle) throws IOException{
    	
    	setDivorcioDetalle(divorcioDetalle);
    	
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath()
                .concat(ConstantesComunes.DETALLE_DIVORCIO));
    }
    
    /**
     * Metodo para eliminar un Divorcio
     */
    public void eliminarDivorcio() throws IOException {

        Long idDivorcio = getDivorcioDetalle().getId();
        
        logger.info("ID DIVORCIO" + getDivorcioDetalle().getId());
        
        getDivorcioService().eliminarDivorcio(idDivorcio);

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                FacesMessage.SEVERITY_INFO,"El registro se ha eliminado correctamente.", ""));

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath()
                .concat(ConstantesComunes.CONSULTA_DIVORCIO));



    }
}
