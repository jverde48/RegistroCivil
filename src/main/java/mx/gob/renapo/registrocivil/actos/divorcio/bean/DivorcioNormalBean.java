package mx.gob.renapo.registrocivil.actos.divorcio.bean;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.service.impl.DivorcioServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.impl.*;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;


@ManagedBean(name="divorcioNormalBean")
@ViewScoped
@Data
@Component
public class DivorcioNormalBean implements Serializable{

	private static final long serialVersionUID = 1L;

    private static Logger logger = Logger.getLogger(DivorcioNormalBean.class);
    
    @Autowired
    private DivorcioDTO divorcioDTO;
    
    @Autowired
    private DivorcioDTO divorcioDetalle;
    /**
     * Variable para habilitar o deshabilitar los campos de 
     * Fecha ejecutoria y Autoridad dependiendo el tipo de Divorcio
     */
    private boolean deshabilitado = false;
    
    private String rutaTestigoUno;
    private String rutaTestigoDos;
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
     * Beans listas para catalogos de paises
     */
    @ManagedProperty(name = "paises", value = "#{paises}")
    private List<PaisDTO> paises;
    @ManagedProperty(name = "paisesInegi", value = "#{paisesInegi}")
    private List<PaisDTO> paisesInegi;
    @ManagedProperty(name = "tipoDivorcioList", value = "#{tipoDivorcioList}")
    private List<CatTipoDivorcioDTO> tipoDivorcioList;
    
    /**
     * Beans listas para catalogos de datos de Nacimiento Divorciado Uno
     */
    @ManagedProperty(name = "estadosDivorciadoUno", value = "#{estadosDivorciadoUno}")
    private List<EstadoDTO> estadosDivorciadoUno;
    @ManagedProperty(name = "municipiosDivorciadoUno", value = "#{municipiosDivorciadoUno}")
    private List<MunicipioDTO> municipiosDivorciadoUno;
   
    /**
     * Beans listas para catalogos de datos de Nacimiento Divorciado Dos
     */
    @ManagedProperty(name = "estadosDivorciadoDos", value = "#{estadosDivorciadoDos}")
    private List<EstadoDTO> estadosDivorciadoDos;
    @ManagedProperty(name = "municipiosDivorciadoDos", value = "#{municipiosDivorciadoDos}")
    private List<MunicipioDTO> municipiosDivorciadoDos;
    
    /**
     * Beans listas para catalogos de datos de Testigos
     */
    @ManagedProperty(name = "parentescoList", value = "#{parentescoList}")
    private List<CatParentescoDTO> parentescoList;
    @ManagedProperty(name = "estadoCivilList", value = "#{estadoCivilList}")
    private List<CatEstadoCivilDTO> estadoCivilList;
    
    /**
     * Beans listas para catalogos de datos de Domicilio Divorciado Uno
     */
    @ManagedProperty(name = "estadosInegiDivorciadoUno", value = "#{estadosInegiDivorciadoUno}")
    private List<EstadoDTO> estadosInegiDivorciadoUno;
    @ManagedProperty(name = "municipiosInegiDivorciadoUno", value = "#{municipiosInegiDivorciadoUno}")
    private List<MunicipioDTO> municipiosInegiDivorciadoUno;
    @ManagedProperty(name = "localidadesInegiDivorciadoUno", value = "#{localidadesInegiDivorciadoUno}")
    private List<LocalidadDTO> localidadesInegiDivorciadoUno;
    @ManagedProperty(name = "tipoLocalidadDivorciadoUno", value = "#{tipoLocalidadDivorciadoUno}")
    private List<CatTipoLocalidadDTO> tipoLocalidadDivorciadoUno;
    /**
     * Beans listas para catalogos de datos de Domicilio Divorciado Dos
     */
    @ManagedProperty(name = "estadosInegiDivorciadoDos", value = "#{estadosInegiDivorciadoDos}")
    private List<EstadoDTO> estadosInegiDivorciadoDos;
    @ManagedProperty(name = "municipiosInegiDivorciadoDos", value = "#{municipiosInegiDivorciadoDos}")
    private List<MunicipioDTO> municipiosInegiDivorciadoDos;
    @ManagedProperty(name = "localidadesInegiDivorciadoDos", value = "#{localidadesInegiDivorciadoDos}")
    private List<LocalidadDTO> localidadesInegiDivorciadoDos;
    @ManagedProperty(name = "tipoLocalidadDivorciadoDos", value = "#{tipoLocalidadDivorciadoDos}")
    private List<CatTipoLocalidadDTO> tipoLocalidadDivorciadoDos;
    
    /**
     * Beans listas para catalogos de datos de Domicilio Testigo Uno
     */
    @ManagedProperty(name = "estadosInegiTestigoUno", value = "#{estadosInegiTestigoUno}")
    private List<EstadoDTO> estadosInegiTestigoUno;
    @ManagedProperty(name = "municipiosInegiTestigoUno", value = "#{municipiosInegiTestigoUno}")
    private List<MunicipioDTO> municipiosInegiTestigoUno;
    @ManagedProperty(name = "localidadesInegiTestigoUno", value = "#{localidadesInegiTestigoUno}")
    private List<LocalidadDTO> localidadesInegiTestigoUno;
    @ManagedProperty(name = "tipoLocalidadTestigoUno", value = "#{tipoLocalidadTestigoUno}")
    private List<CatTipoLocalidadDTO> tipoLocalidadTestigoUno;
    /**
     * Beans listas para catalogos de datos de Domicilio Testigo Dos
     */
    @ManagedProperty(name = "estadosInegiTestigoDos", value = "#{estadosInegiTestigoDos}")
    private List<EstadoDTO> estadosInegiTestigoDos;
    @ManagedProperty(name = "municipiosInegiTestigoDos", value = "#{municipiosInegiTestigoDos}")
    private List<MunicipioDTO> municipiosInegiTestigoDos;
    @ManagedProperty(name = "localidadesInegiTestigoDos", value = "#{localidadesInegiTestigoDos}")
    private List<LocalidadDTO> localidadesInegiTestigoDos;
    @ManagedProperty(name = "tipoLocalidadTestigoDos", value = "#{tipoLocalidadTestigoDos}")
    private List<CatTipoLocalidadDTO> tipoLocalidadTestigoDos;
    /**
     * Beans listas para catalogos de datos Estadisticos
     */
    @ManagedProperty(name = "escolaridadList", value = "#{escolaridadList}")
    private List<CatEscolaridadDTO> escolaridadList;
    @ManagedProperty(name = "situacionLaboralList", value = "#{situacionLaboralList}")
    private List<CatSituacionLaboralDTO> situacionLaboralList;
    @ManagedProperty(name = "posicionTrabajoList", value = "#{posicionTrabajoList}")
    private List<CatPuestoDTO> posicionTrabajoList;
   
    
    @PostConstruct
    public void init() {
   
        paises = paisService.findAll();
        paisesInegi = inegiPaisService.findAll();
        escolaridadList = escolaridadService.findAll();
        situacionLaboralList = situacionLaboralService.findAll();
        posicionTrabajoList = puestoService.findAll();
        parentescoList = parentescoService.findAll();
        estadoCivilList = estadoCivilService.findAll();
        tipoDivorcioList = tipoDivorcioService.findAll();
    }
    
    /**
     * Metodo para guardar un nuevo registro de divorcio
     */
    public void guardaRegistroDivorcio() throws IOException {
         
         divorcioDetalle = divorcioService.guardarDivorcio(divorcioDTO);

         if(divorcioDetalle.getCodigoRespuesta() == 0){
        	 FacesContext context = FacesContext.getCurrentInstance();
             context.getExternalContext().getFlash().setKeepMessages(true);

             FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                     FacesMessage.SEVERITY_INFO,"El registro se ha guardado correctamente.", ""));

             ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
             externalContext.redirect(externalContext.getRequestContextPath()
                     .concat(ConstantesComunes.DETALLE_DIVORCIO));
         }else {
        	 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                     FacesMessage.SEVERITY_ERROR,"Ocurri\u00f3 un error al guardar el registro.", ""));
             RequestContext.getCurrentInstance().execute("errorDialog.show()");
         }
    }
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
     * Metodo para habilitar o deshabilitar los campos de 
     * Fecha ejecutoria y Autoridad dependiendo el tipo de Divorcio
     */
    public void habilitarCampos(){
    	
    	String tipoDivorcio = divorcioDTO.getActaDivorcio().getTipoDivorcio().getDescripcion();
    
    	if(tipoDivorcio.equals(ConstantesComunes.ADMINISTRATIVO)){
    		deshabilitado = true;
    		rutaTestigoUno = ConstantesComunes.DIVORCIO_TESTIGO_UNO;
    		rutaTestigoDos = ConstantesComunes.DIVORCIO_TESTIGO_DOS;
    	}else if(tipoDivorcio.equals(ConstantesComunes.JUDICIAL)){
    		deshabilitado = false;
    		rutaTestigoUno = "";
    		rutaTestigoDos = "";
    	}
    }
}
