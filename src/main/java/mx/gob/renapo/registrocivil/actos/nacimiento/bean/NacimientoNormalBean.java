package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.impl.NacimientoServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.impl.*;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "nacimientoNormalBean")
@ViewScoped
@Data
@Component
@EqualsAndHashCode(callSuper=false)
public class NacimientoNormalBean extends NacimientosPrincipalBean implements Serializable{


	private static final long serialVersionUID = 1L;

    private static Logger logger = Logger.getLogger(NacimientoNormalBean.class);

    @Autowired
    private NacimientoDTO nacimientoDTO;

    /**
     * Beans de services
     */
    @Autowired
    private NacimientoServiceImpl nacimientoService;
    @Autowired
    private CatPaisServiceImpl paisService;
    @Autowired
    private CatEstadoServiceImpl estadoService;
    @Autowired
    private CatInegiPaisServiceImpl inegiPaisService;
    @Autowired
    private CatInegiEstadoServiceImpl inegiEstadoService;
    @Autowired
    private CatInegiMunicipioServiceImpl inegiMunicipioService;
    @Autowired
    private CatMunicipioServiceImpl municipioService;
    @Autowired
    private CatAtendioPartoServiceImpl atendioPartoService;
    @Autowired
    private CatEstadoCivilServiceImpl estadoCivilService;
    @Autowired
    private CatEscolaridadServiceImpl escolaridadService;
    @Autowired
    private CatTipoPartoServiceImpl tipoPartoService;
    @Autowired
    private CatParentescoServiceImpl parentescoService;
    @Autowired
    private CatLugarPartoServiceImpl lugarPartoService;
    @Autowired
    private CatSituacionLaboralServiceImpl situacionLaboralService;
    @Autowired
    private CatPuestoServiceImpl puestoService;
    @Autowired
    private CatColoniaLocalidadServiceImpl localidadService;
    @Autowired
    private CatTipoLocalidadServiceImpl tipoLocalidadService;

    /**
	 * Listas para carga de paises de cada una personas del acto de nacimiento
	 */
	private List<PaisDTO> paises;	
	private List<PaisDTO> paisesInegi;
	
	/**
	 * Listas para carga de estados de cada persona del acto de nacimiento
	 */
    private List<EstadoDTO> estadosRegistrado;
    private List<EstadoDTO> estadosProgenitorUno;
    private List<EstadoDTO> estadosProgenitorDos;
    private List<EstadoDTO> estadosTestigoUno;
    private List<EstadoDTO> estadosTestigoDos;
    private List<EstadoDTO> estadosPersonaDistintaComparece;
    
    private List<EstadoDTO> estadosInegiRegistrado;
    private List<EstadoDTO> estadosInegiProgenitorUno;
    private List<EstadoDTO> estadosInegiProgenitorDos;
    private List<EstadoDTO> estadosInegiTestigoUno;
    private List<EstadoDTO> estadosInegiTestigoDos;
    private List<EstadoDTO> estadosInegiPersonaDistintaComarece;
    
    /**
     * Listas para carga de municipios de cada persona del acto de nacimiento
     */
    private List<MunicipioDTO> municipiosResgistrado;
    private List<MunicipioDTO> municipiosProgenitorUno;
    private List<MunicipioDTO> municipiosProgenitorDos;
    private List<MunicipioDTO> municipiosTestigoUno;
    private List<MunicipioDTO> municipiosTestigoDos;
    private List<MunicipioDTO> municipiosPersonaDistintaComparece;
    
    private List<MunicipioDTO> municipiosInegiRegistrado;
    private List<MunicipioDTO> municipiosInegiProgenitorUno;
    private List<MunicipioDTO> municipiosInegiProgenitorDos;
    private List<MunicipioDTO> municipiosInegiTestigoUno;
    private List<MunicipioDTO> municipiosInegiTestigoDos;
    private List<MunicipioDTO> municipiosInegiPersonaDistintaComparece;
    
    
    /**
     * Listas para carga de localidades de cada persona del acto de nacimient0
     */
    private List<LocalidadDTO> localidadesRegistrado;
    private List<LocalidadDTO> localidadesProgenitorUno;
    private List<LocalidadDTO> localidadesProgenitorDos;
    private List<LocalidadDTO> localidadesTestigoUno;
    private List<LocalidadDTO> localidadesTestigoDos;
    private List<LocalidadDTO> localidadesPersonaDistintaComparece;
    
    /**
     * Listas para tipo de localidad para cada persona del acto de nacimiento
     */
    private List<CatTipoLocalidadDTO> tipoLocalidadList;
    
    /**
     * Listas para parentesco de la persona distinta que comparece y testigos
     */
    private List<CatParentescoDTO> parentescoList;
    
    private List<CatAtendioPartoDTO> atendioPartoList;
    private List<CatTipoPartoDTO> tipoPartoList;
    private List<CatEscolaridadDTO> escolaridadList;
    private List<CatSituacionLaboralDTO> situacionLaboralList;
    private List<CatPuestoDTO> posicionTrabajoList;
    private List<CatEstadoCivilDTO> estadoCivilList;
    private List<CatLugarPartoDTO> lugarPartoList;
    private List<CatCompareceDTO> compareceList;
    
    
    @PostConstruct
    public void init() {
    	paises = paisService.findAll();
        atendioPartoList = atendioPartoService.findAll();
        parentescoList = parentescoService.findAll();
        tipoPartoList = tipoPartoService.findAll();
        lugarPartoList = lugarPartoService.findAll();
        escolaridadList = escolaridadService.findAll();
        for(PaisDTO pais: getPaises()) {
        	if(pais.getDescripcion().equals(ConstantesComunes.MEXICO)) {
        		nacimientoDTO.getRegistrado().setPaisNacimiento(pais);
        		break;
        	}
        }
        
        if(estadoCivilList!=null) {
        	for(CatEstadoCivilDTO estadoCivil: estadoCivilList) {
            	if(estadoCivil.getDescripcion().equals("Soltero")) {
            		nacimientoDTO.getRegistrado().setEstadoCivil(estadoCivil);
            		break;
            	}
            }
        }
 
        estadosRegistrado = estadoService.recuperarPorPais
        		(nacimientoDTO.getRegistrado().getPaisNacimiento());
    }

    /**
     * Metodo para guardar un nuevo registro de nacimiento
     */
    public void guardaRegistroNacimiento() {
         nacimientoService.guardarNacimiento(nacimientoDTO);
    }
    
    /**
     * Metodo para recupear los estados por pais de una persona en especifico
     * (Progenitor Uno, Progenitor Dos, Testigo Uno, Testigo Dos, Persona Distinta
     * que comparece)
     * @param tipoPersona
     */
    public void consultaEstados(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	PaisDTO pais = persona.getPaisNacimiento();
    	
    	switch(tipoPersona) {
    	case 2:
    		estadosProgenitorUno = estadoService.recuperarPorPais(pais);
    		break;
    	case 3:
    		estadosProgenitorDos = estadoService.recuperarPorPais(pais);
    		break;
    	case 8:
    		estadosTestigoUno = estadoService.recuperarPorPais(pais);
    		break;
    	case 9:
    		estadosTestigoDos = estadoService.recuperarPorPais(pais);
    		break;
    	case 10:
    		estadosPersonaDistintaComparece = estadoService.recuperarPorPais(pais);
    		break;
    	}
    }
    
    /**
     * Metodo que carga los municipios de un estado seleccionado segun la persona
     * @param tipoPersona
     */
    public void consultaMuncipios(Integer tipoPersona) {   	
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	EstadoDTO estado = persona.getEntidadNacimiento();
    	
    	switch(tipoPersona) {
    	case 1:
    		municipiosResgistrado = municipioService.recuperarMunicipiosPorEstado(estado);
    		break;
    	case 2:
    		municipiosProgenitorUno = municipioService.recuperarMunicipiosPorEstado(estado);
    		break;
    	case 3:
    		municipiosProgenitorDos = municipioService.recuperarMunicipiosPorEstado(estado);
    		break;
    	case 8:
    		municipiosTestigoUno = municipioService.recuperarMunicipiosPorEstado(estado);
    		break;
    	case 9:
    		municipiosTestigoDos = municipioService.recuperarMunicipiosPorEstado(estado);
    		break;
    	case 10:
    		municipiosPersonaDistintaComparece = municipioService.recuperarMunicipiosPorEstado(estado);
    		break;
    	}
    	
    }
    
    public void consultaEstadosInegi(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);  	
    	PaisDTO pais = persona.getDomicilio().getPais();
    	switch(tipoPersona) {
    	case 1:
    		estadosInegiRegistrado = inegiEstadoService.recupearEstadosPorPais(pais);
    		break;
    	case 2:
    		estadosInegiProgenitorUno = inegiEstadoService.recupearEstadosPorPais(pais);
    		break;
    	case 3:
    		estadosInegiProgenitorDos = inegiEstadoService.recupearEstadosPorPais(pais);
    		break;
    	case 8:
    		estadosInegiTestigoUno = inegiEstadoService.recupearEstadosPorPais(pais);
    		break;
    	case 9:
    		estadosInegiTestigoDos = inegiEstadoService.recupearEstadosPorPais(pais);
    		break;
    	case 10:
    		estadosInegiPersonaDistintaComarece = inegiEstadoService.recupearEstadosPorPais(pais);
    		break;
    	}
    	
    }
    
    public void consultaMunicipiosInegi(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	EstadoDTO estado = persona.getDomicilio().getEstado();
    	switch(tipoPersona) {
    	case 1:
    		municipiosInegiRegistrado = inegiMunicipioService.recuperaMunicipiosPorEstado(estado); 
    		break;
    	case 2:
    		municipiosInegiProgenitorUno = inegiMunicipioService.recuperaMunicipiosPorEstado(estado);
    		break;
    	case 3:	
    		municipiosInegiProgenitorDos = inegiMunicipioService.recuperaMunicipiosPorEstado(estado);
    		break;
    	case 8:
    		municipiosInegiTestigoUno = inegiMunicipioService.recuperaMunicipiosPorEstado(estado); 
    		break;
    	case 9:
    		municipiosInegiTestigoDos = inegiMunicipioService.recuperaMunicipiosPorEstado(estado);
    		break;
    	case 10:
    		municipiosInegiPersonaDistintaComparece = inegiMunicipioService.recuperaMunicipiosPorEstado(estado);
    	}
    }
    
    public void consultaLocalidadesInegi(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	MunicipioDTO municipio = persona.getDomicilio().getMunicipio();
    	switch(tipoPersona) {
    	case 1:
    		localidadesRegistrado = localidadService.findAllByMunicipio(municipio);
    		break;
    	case 2:
    		localidadesProgenitorUno = localidadService.findAllByMunicipio(municipio);
    		break;
    	case 3:
    		localidadesProgenitorDos = localidadService.findAllByMunicipio(municipio);
    		break;
    	case 8:
    		localidadesTestigoUno = localidadService.findAllByMunicipio(municipio);
    		break;
    	case 9:
    		localidadesTestigoDos = localidadService.findAllByMunicipio(municipio);
    		break;
    	case 10:
    		localidadesPersonaDistintaComparece = localidadService.findAllByMunicipio(municipio);
    		break;
    	}
    }
    
    
    /**
     * Metodo para recuperar una persona dependiendo su rol
     * @param tipoPersona
     * @return PersonaDTO
     */
    private PersonaDTO obtienePersona(Integer tipoPersona) {
    	PersonaDTO persona = null;
    	
    	switch (tipoPersona) {
		case 1:
			persona = nacimientoDTO.getRegistrado();
			break;
		case 2:
			persona = nacimientoDTO.getProgenitorUno();
			break;
		case 3:
			persona = nacimientoDTO.getProgenitorDos();
			break;
		case 4:
			persona = nacimientoDTO.getAbueloUnoProgenitorUno();
			break;
		case 5:
			persona = nacimientoDTO.getAbuelaUnoProgenitorDos();
			break;
		case 6:
			persona = nacimientoDTO.getAbueloDosProgenitorUno();
			break;
		case 7:
			persona = nacimientoDTO.getAbueloDosProgenitorDos();
			break;	
		case 8:
			persona = nacimientoDTO.getTestigoUno();
			break;	
		case 9:
			persona = nacimientoDTO.getTestigoDos();
			break;
		case 10:
			persona = nacimientoDTO.getPersonaDistintaComparece();
			break;
		}
    	return persona;
    }
    
    /**
	 * Metodo para cambiar el template necesario para el formulario de los
	 * padres y cargar la lista de paises correspondiente
	 */
    @Override
	public void cambiaTemplateProgenitores() {
		if (getPadres() == 1) {
			setTemplatePadres(ConstantesComunes.TEMPLATE_DATOS_PERSONALES_PROGENITOR_UNO);
			estadoCivilList = estadoCivilService.findAll();
		} else if (getPadres() == 2) {
			setTemplatePadres(ConstantesComunes.TEMPLATE_DATOS_PERSONALES_AMBOS_PADRES);
			estadoCivilList = estadoCivilService.findAll();
		}
	}

    /**
	 * Metodo para cargar template de comparece
	 */
    @Override
	public void cambiaTemplateComparece() {
		if (getComparece() == ConstantesComunes.COMPARCENCIA_OTRO) {
			setTemplateComparece(ConstantesComunes.TEMPLATE_DATOS_PERSONALES_COMPARECE);
		}
	}

}
