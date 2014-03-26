package mx.gob.renapo.registrocivil.actos.defuncion.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 02:01 PM
 * To change this template use File | Settings | File Templates.
 */

import mx.gob.renapo.registrocivil.actos.defuncion.service.DefuncionService;
import mx.gob.renapo.registrocivil.actos.defuncion.service.impl.DefuncionServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.*;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatSituacionLaboralServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;
import org.springframework.stereotype.Component;


@ManagedBean(name="defuncionNormalBean")
@ViewScoped
@Data
@Component
public class DefuncionNormalBean extends DefuncionesPrincipalBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(DefuncionNormalBean.class);

    @Autowired
    private DefuncionDTO defuncionDTO;

    /**
     * Beans de services
     */
    @Autowired
    private DefuncionService defuncionService;

    @Autowired
    private CatPaisService paisService;
    @Autowired
    private CatEstadoService estadoService;
    @Autowired
    private CatInegiPaisService inegiPaisService;
    @Autowired
    private CatInegiEstadoService inegiEstadoService;
    @Autowired
    private CatInegiMunicipioService inegiMunicipioService;
    @Autowired
    private CatMunicipioService municipioService;
    @Autowired
    private CatEstadoCivilService estadoCivilService;
    @Autowired
    private CatEscolaridadService escolaridadService;
    @Autowired
    private CatParentescoService parentescoService;
    @Autowired
    private CatLugarFalleceService lugarFalleceService;
    @Autowired
    private CatSituacionLaboralServiceImpl situacionLaboralService;
    @Autowired
    private CatPuestoService puestoService;
    @Autowired
    private CatDestinoCadaverService destinoCadaverService;
    @Autowired
    private CatColoniaLocalidadService coloniaLocalidadService;
    @Autowired
    private CatTipoLocalidadService tipoLocalidadService;
    @Autowired
    private CatNacionalidadService nacionalidadService;

    /**
     * Lugar de nacimiento del Finado
     */
    private List<PaisDTO> listaPaises;

    private List<EstadoDTO> listaEstados;

    private List<MunicipioDTO> listaMunicipios;

    private List<NacionalidadDTO> listaNacionalidad;


    /**
     * Domicilio del Finado - INEGI
     */
    private List<MunicipioDTO> listaMunicipiosInegi;

    private List<CatTipoLocalidadDTO> listaTipoLocalidad;

    private List<LocalidadDTO> listaLocalidadColoniasInegi;

    private List<EstadoDTO> listaEstadosInegi;

    private List<PaisDTO> listaPaisesInegi;

    private List<CatEstadoCivilDTO> listaEstadoCivil;

    private List<CatSituacionLaboralDTO> listaSituacionLaboral;

    /**
     * Parentesco Testigos y Declarante
     */

    private List<CatParentescoDTO> listaParentesco;

    /**
     * Datos Estadisticos
     */

    private List<CatLugarFalleceDTO> listaLugarFallece;

    private List<CatEscolaridadDTO> listaEscolaridad;

    private List<CatPuestoDTO> listaPuesto;

    private List<CatDestinoCadaverDTO> listaDestinoCadaver;



    @PostConstruct
    public void init() {
        listaEstados = estadoService.findAll();
        listaEstadosInegi = inegiEstadoService.findAll();
        listaMunicipios = municipioService.findAll();
        listaMunicipiosInegi = inegiMunicipioService.findAll();
        listaPaises = paisService.findAll();
        listaPaisesInegi = inegiPaisService.findAll();
        listaLocalidadColoniasInegi = coloniaLocalidadService.findAll();
        listaTipoLocalidad = tipoLocalidadService.findAll();
        listaNacionalidad = nacionalidadService.findAll();
        listaParentesco = parentescoService.findAll();
        listaEscolaridad = escolaridadService.findAll();
        listaSituacionLaboral = situacionLaboralService.findAll();
        listaEstadoCivil = estadoCivilService.findAll();
        listaPuesto = puestoService.findAll();
        listaLugarFallece = lugarFalleceService.findAll();
        listaDestinoCadaver = destinoCadaverService.findAll();

    }


    /**
     * Metodo para guardar un nuevo registro de nacimiento
     */
   public void guardaRegistroNormalDefuncion() {
        logger.info(defuncionDTO.getFinado().getNombre());
        defuncionService.guardarDefuncion(defuncionDTO);

    }


}