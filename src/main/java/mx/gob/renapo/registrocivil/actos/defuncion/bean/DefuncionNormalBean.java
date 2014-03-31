package mx.gob.renapo.registrocivil.actos.defuncion.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 02:01 PM
 * To change this template use File | Settings | File Templates.
 */

import mx.gob.renapo.registrocivil.actos.defuncion.dto.ActaDefuncionDTO;
import mx.gob.renapo.registrocivil.actos.defuncion.service.DefuncionService;
import mx.gob.renapo.registrocivil.actos.defuncion.service.impl.DefuncionServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.*;
import mx.gob.renapo.registrocivil.catalogos.service.impl.CatSituacionLaboralServiceImpl;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
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

    /**
     * Services para carga de informacion de catalogos lugar de nacimiento
     */
    @Autowired
    private CatPaisService paisService;

    @Autowired
    private CatEstadoService estadoService;

    @Autowired
    private CatMunicipioService municipioService;

    /**
     * Services para carga de informacion de catlogos de domicilio
     */
    @Autowired
    private CatInegiPaisService inegiPaisService;

    @Autowired
    private CatInegiEstadoService inegiEstadoService;

    @Autowired
    private CatInegiMunicipioService inegiMunicipioService;

    @Autowired
    private CatTipoLocalidadService tipoLocalidadService;

    @Autowired
    private CatColoniaLocalidadService localidadService;

    @Autowired
    private CatEstadoCivilService estadoCivilService;

    @Autowired
    private CatSituacionLaboralService situacionLaboralService;

    /**
     * Services para carga de informacion de parentesco
     */
    @Autowired
    private CatParentescoService parentescoService;

    @Autowired
    private CatPuestoService puestoService;

    /**
     * Services para carga de informacion de estadisticos
     */
    @Autowired
    private CatEscolaridadService escolaridadService;
    @Autowired
    private CatLugarFalleceService lugarFalleceService;
    @Autowired
    private CatDestinoCadaverService destinoCadaverService;

    /**
     * Lugar de nacimiento del Finado
     */
    private List<PaisDTO> listaPaises;

    private List<EstadoDTO> listaEstados;

    private List<MunicipioDTO> listaMunicipios;


    /**
     * Domicilio del Finado - INEGI
     */
    private List<PaisDTO> listaPaisesInegi;

    private List<EstadoDTO> listaEstadosInegi;

    private List<MunicipioDTO> listaMunicipiosInegi;

    private List<CatTipoLocalidadDTO> listaTipoLocalidad;

    private List<LocalidadDTO> listaLocalidadColoniasInegi;

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
        listaPaises = paisService.findAll();
        listaPaisesInegi = inegiPaisService.findAll();
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

    /**
     * Recupera los estados de renapo del Pais seleccionado
     */
    public void consultaEstadosRenapo(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstados = estadoService.recuperarPorPais(
                personaDTO.getPaisNacimiento());
    }

    /**
     * Recupera los municipios de renapo  del estado seleccionado
     */
    public void consultaMunicipiosRenapo(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaMunicipios = municipioService.recuperarMunicipiosPorEstado(
                personaDTO.getEntidadNacimiento());
    }

    /**
     * Recupera los estados de inegi  del estado seleccionado
     */
    public void cargarEstadosInegi(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosInegi = inegiEstadoService.recupearEstadosPorPais(
                personaDTO.getDomicilio().getPais());
    }

    /**
     * Recupera los municipios de inegi  del estado seleccionado
     */
    public void cargarMunicipiosInegi(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaMunicipiosInegi = inegiMunicipioService.recuperaMunicipiosPorEstado(
                personaDTO.getDomicilio().getEstado());
    }

    /**
     * Recupera las localidades de inegi del estado seleccionado
     */
    public void cargarLocalidadesInegi(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaLocalidadColoniasInegi = localidadService.findAllByMunicipio(
                personaDTO.getDomicilio().getMunicipio());
        listaTipoLocalidad = tipoLocalidadService.findAll();
    }



    private PersonaDTO getPersona(Integer persona) {
        PersonaDTO personaDTO = null;


        if (persona.equals(1))  // Finado
            personaDTO = defuncionDTO.getFinado();
        else if (persona.equals(2))  //Declarante
            personaDTO = defuncionDTO.getDeclarante();
        else if (persona.equals(3))  // Testigo Uno
            personaDTO = defuncionDTO.getTestigoUno();
        else if (persona.equals(4))  // Testigo Dos
            personaDTO = defuncionDTO.getTestigoDos();
        else if (persona.equals(5)) // Progenitor Uno
            personaDTO = defuncionDTO.getProgenitorUno();
        else if (persona.equals(6)) // Progenitor Dos
            personaDTO = defuncionDTO.getProgenitorDos();
        else if (persona.equals(7)) // Conyuge
            personaDTO = defuncionDTO.getConyuge();


        return personaDTO;
    }

    private ActaDefuncionDTO getActaDeDefuncion(Integer actaDeDefuncion){
        ActaDefuncionDTO actaDefuncionDTO = null;

        if (actaDeDefuncion.equals(8))
            actaDefuncionDTO = defuncionDTO.getDatosFallecimiento();

        return actaDefuncionDTO;
    }

    /**
     * Recupera los estados de inegi  del estado Fallecimiento seleccionado
     */
    public void cargarEstadosFallecimientoInegi(Integer actaDeDefuncion) {
        ActaDefuncionDTO actaDefuncionDTO = getActaDeDefuncion(actaDeDefuncion);
        listaEstadosInegi = inegiEstadoService.recupearEstadosPorPais(
                actaDefuncionDTO.getDomicilioOcurrioFallecimiento().getPais());
    }

    /**
     * Recupera los municipios de inegi  del estado Fallecimiento seleccionado
     */
    public void cargarMunicipiosFallecimientoInegi(Integer actaDeDefuncion) {
        ActaDefuncionDTO actaDefuncionDTO = getActaDeDefuncion(actaDeDefuncion);
        listaMunicipiosInegi = inegiMunicipioService.recuperaMunicipiosPorEstado(
                actaDefuncionDTO.getDomicilioOcurrioFallecimiento().getEstado());
    }

    /**
     * Recupera las localidades de inegi del estado Fallecimiento seleccionado
     */
    public void cargarLocalidadesFallecimientoInegi(Integer actaDeDefuncion) {
        ActaDefuncionDTO actaDefuncionDTO = getActaDeDefuncion(actaDeDefuncion);
        listaLocalidadColoniasInegi = localidadService.findAllByMunicipio(
                actaDefuncionDTO.getDomicilioOcurrioFallecimiento().getMunicipio());
        listaTipoLocalidad = tipoLocalidadService.findAll();
    }

}
