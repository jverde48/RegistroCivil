package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
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
    private CatColoniaLocalidadServiceImpl coloniaLocalidadService;
    @Autowired
    private CatTipoLocalidadServiceImpl tipoLocalidadService;


    /**
     * Beans
     */
    private List<PaisDTO> paises;
    private List<EstadoDTO> estadosParaRegistrado;
    private List<EstadoDTO> estados;
    private List<MunicipioDTO> municipios;
    private List<CatAtendioPartoDTO> atendioPartoList;
    private List<CatTipoPartoDTO> tipoPartoList;
    private List<CatParentescoDTO> parentescoList;
    private List<CatLugarPartoDTO> lugarPartoList;
    private List<CatEscolaridadDTO> escolaridadList;
    private List<CatSituacionLaboralDTO> situacionLaboralList;
    private List<PaisDTO> paisesInegi;
    private List<EstadoDTO> estadosInegi;
    private List<MunicipioDTO> municipiosInegi;
    private List<CatPuestoDTO> posicionTrabajoList;
    private List<LocalidadDTO> localidadesList;
    private List<CatTipoLocalidadDTO> tipoLocalidadList;
    private List<CatEstadoCivilDTO> estadoCivilList;

    @PostConstruct
    public void init() {
        paises = paisService.findAll();
        paisesInegi = inegiPaisService.findAll();
        atendioPartoList = atendioPartoService.findAll();
        tipoPartoList = tipoPartoService.findAll();
        parentescoList = parentescoService.findAll();
        lugarPartoList = lugarPartoService.findAll();
        escolaridadList = escolaridadService.findAll();
        situacionLaboralList = situacionLaboralService.findAll();
        posicionTrabajoList = puestoService.findAll();
        tipoLocalidadList = tipoLocalidadService.findAll();
        estadoCivilList = estadoCivilService.findAll();
        for(PaisDTO pais: paises) {
        	if(pais.getDescripcion().equals(ConstantesComunes.MEXICO)) {
        		nacimientoDTO.getRegistrado().setPaisNacimiento(pais);
        	}
        }
        
        estadosParaRegistrado = estadoService.recuperarPorPais
        		(nacimientoDTO.getRegistrado().getPaisNacimiento());
    }

    /**
     * Metodo para guardar un nuevo registro de nacimiento
     */
    public void guardaRegistroNacimiento() {
         nacimientoService.guardarNacimiento(nacimientoDTO);

    }
    
    public void consultaEstados(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	
    	estados = estadoService.recuperarPorPais
    			(persona.getPaisNacimiento());
    }
    
    public void consultaMuncipios(Integer tipoPersona) {   	
    	
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	municipios = municipioService.recuperarMunicipiosPorEstado
    			(persona.getEntidadNacimiento());
    }
    
    public void consultaEstadosInegi(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);  	
    	estadosInegi = inegiEstadoService.recupearEstadosPorPais(persona.getDomicilio().getPais());
    }
    
    public void consultaMunicipiosInegi(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	municipiosInegi = inegiMunicipioService.recuperaMunicipiosPorEstado(persona.getDomicilio().getEstado());
    }
    
    public void consultaLocalidadesInegi(Integer tipoPersona) {
    	PersonaDTO persona = obtienePersona(tipoPersona);
    	//TODO meter consulta de localidades
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


}
