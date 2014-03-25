package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.impl.NacimientoServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dao.impl.CatEstadoCivilDAOImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.CatAtendioParto;
import mx.gob.renapo.registrocivil.catalogos.entity.CatNacionalidad;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoLocalidadService;
import mx.gob.renapo.registrocivil.catalogos.service.impl.*;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    private List<LocalidadDTO> coloniaLocalidadList;
    private List<CatTipoLocalidadDTO> tipoLocalidadList;
    private List<NacionalidadDTO> nacionalidadList;
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
        estadoCivilList = estadoCivilService.findAll();
        posicionTrabajoList = puestoService.findAll();
        tipoLocalidadList = tipoLocalidadService.findAll();
        estadoCivilList = estadoCivilService.findAll();
        for(PaisDTO pais: paises) {
        	if(pais.getDescripcion().equals(ConstantesComunes.MEXICO)) {
        		nacimientoDTO.getRegistrado().setPaisNacimiento(pais);
        	}
        }
        
        estados = estadoService.recuperarPorPais
        		(nacimientoDTO.getRegistrado().getPaisNacimiento());
    }

    /**
     * Metodo para guardar un nuevo registro de nacimiento
     */
    public void guardaRegistroNacimiento() {
         logger.info(nacimientoDTO.getRegistrado().getNombre());
         nacimientoService.guardarNacimiento(nacimientoDTO);

    }
    
    public void consultaEstados() {

    	estados = estadoService.recuperarPorPais
    			(nacimientoDTO.getRegistrado().getPaisNacimiento());
    }
    
    public void consultaMuncipios() {   	
    	municipios = municipioService.recuperarMunicipiosPorEstado
    			(nacimientoDTO.getRegistrado().getEntidadNacimiento());
    }


}
