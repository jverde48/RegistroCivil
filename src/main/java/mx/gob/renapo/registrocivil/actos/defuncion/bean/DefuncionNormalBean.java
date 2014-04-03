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
    private List<PaisDTO> listaPaisesFinado;

    private List<EstadoDTO> listaEstadosFinado;

    private List<MunicipioDTO> listaMunicipiosFinado;

    /**
     * Lugar de nacimiento del DECLARANTE
     */
    private List<PaisDTO> listaPaisesDeclarante;
    private List<EstadoDTO> listaEstadosDeclarante;

    /**
     * Lugar de nacimiento del CONYUGE
     */
    private List<PaisDTO> listaPaisesConyuge;
    private List<EstadoDTO> listaEstadosConyuge;

    /**
     * Lugar de nacimiento del PROGENITOR UNO
     */
    private List<PaisDTO> listaPaisesProgenitorUno;
    private List<EstadoDTO> listaEstadosProgenitorUno;

    /**
     * Lugar de nacimiento del PROGENITOR DOS
     */
    private List<PaisDTO> listaPaisesProgenitorDos;
    private List<EstadoDTO> listaEstadosProgenitorDos;

    /**
     * Lugar de nacimiento del TESTIGO UNO
     */
    private List<PaisDTO> listaPaisesTestigoUno;
    private List<EstadoDTO> listaEstadosTestigoUno;

    /**
     * Lugar de nacimiento del TESTIGO DOS
     */
    private List<PaisDTO> listaPaisesTestigoDos;
    private List<EstadoDTO> listaEstadosTestigoDos;


    /**
     * Domicilio del Finado - INEGI
     */
    private List<PaisDTO> listaPaisesInegiFinado;

    private List<EstadoDTO> listaEstadosInegiFinado;

    private List<MunicipioDTO> listaMunicipiosInegiFinado;

    private List<CatTipoLocalidadDTO> listaTipoLocalidadFinado;

    private List<LocalidadDTO> listaLocalidadColoniasInegiFinado;

    /**
     * Domicilio del Declarante - INEGI
     */
    private List<PaisDTO> listaPaisesInegiDeclarante;

    private List<EstadoDTO> listaEstadosInegiDeclarante;

    private List<MunicipioDTO> listaMunicipiosInegiDeclarante;

    private List<CatTipoLocalidadDTO> listaTipoLocalidadDeclarante;

    private List<LocalidadDTO> listaLocalidadColoniasInegiDeclarante;

    /**
     * Domicilio del Testigo Uno - INEGI
     */
    private List<PaisDTO> listaPaisesInegiTestigoUno;

    private List<EstadoDTO> listaEstadosInegiTestigoUno;

    private List<MunicipioDTO> listaMunicipiosInegiTestigoUno;

    private List<CatTipoLocalidadDTO> listaTipoLocalidadTestigoUno;

    private List<LocalidadDTO> listaLocalidadColoniasInegiTestigoUno;

    /**
     * Domicilio del Testigo Dos - INEGI
     */
    private List<PaisDTO> listaPaisesInegiTestigoDos;

    private List<EstadoDTO> listaEstadosInegiTestigoDos;

    private List<MunicipioDTO> listaMunicipiosInegiTestigoDos;

    private List<CatTipoLocalidadDTO> listaTipoLocalidadTestigoDos;

    private List<LocalidadDTO> listaLocalidadColoniasInegiTestigoDos;

    /**
     * Domicilio del Lugar Fallecimiento - INEGI
     */
    private List<PaisDTO> listaPaisesInegiLugarFallecimiento;

    private List<EstadoDTO> listaEstadosInegiLugarFallecimiento;

    private List<MunicipioDTO> listaMunicipiosInegiLugarFallecimiento;

    private List<CatTipoLocalidadDTO> listaTipoLocalidadLugarFallecimiento;

    private List<LocalidadDTO> listaLocalidadColoniasInegiLugarFallecimiento;


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
        listaPaisesFinado = paisService.findAll();
        listaPaisesInegiFinado = inegiPaisService.findAll();
        listaPaisesDeclarante = paisService.findAll();
        listaPaisesInegiDeclarante = inegiPaisService.findAll();
        listaPaisesInegiLugarFallecimiento = inegiPaisService.findAll();
        listaPaisesInegiTestigoUno = inegiPaisService.findAll();
        listaPaisesTestigoUno = paisService.findAll();
        listaPaisesInegiTestigoDos = inegiPaisService.findAll();
        listaPaisesTestigoDos = paisService.findAll();
        listaPaisesConyuge = paisService.findAll();
        listaPaisesProgenitorUno = paisService.findAll();
        listaPaisesProgenitorDos = paisService.findAll();
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
        defuncionService.guardarDefuncion(defuncionDTO);

    }

    /**
     * Recupera los estados de renapo del Pais Estado y Municipio Nacimiento FINADO
     */
    public void consultaEstadosRenapoFinado(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosFinado = estadoService.recuperarPorPais(
                personaDTO.getPaisNacimiento());
    }

    public void consultaMunicipiosRenapoFinado(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaMunicipiosFinado = municipioService.recuperarMunicipiosPorEstado(
                personaDTO.getEntidadNacimiento());
    }

    /**
     * Recupera los estados  Municipiode  y localidad inegi  del FINADO
     */
    public void cargarEstadosInegiFinado(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosInegiFinado = inegiEstadoService.recupearEstadosPorPais(
                personaDTO.getDomicilio().getPais());
    }

    public void cargarMunicipiosInegiFinado(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaMunicipiosInegiFinado = inegiMunicipioService.recuperaMunicipiosPorEstado(
                personaDTO.getDomicilio().getEstado());
    }


    public void cargarLocalidadesInegiFinado(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaLocalidadColoniasInegiFinado = localidadService.findAllByMunicipio(
                personaDTO.getDomicilio().getMunicipio());
        listaTipoLocalidadFinado = tipoLocalidadService.findAll();
    }

    /**
     * Recupera los estados  Municipiode  y localidad inegi  del DECLARANTE
     */

    public void consultaEstadosRenapoDeclarante(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosDeclarante = estadoService.recuperarPorPais(
                personaDTO.getPaisNacimiento());
    }

    public void cargarEstadosInegiDeclarante(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosInegiDeclarante = inegiEstadoService.recupearEstadosPorPais(
                personaDTO.getDomicilio().getPais());
    }

    public void cargarMunicipiosInegiDeclarante(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaMunicipiosInegiDeclarante = inegiMunicipioService.recuperaMunicipiosPorEstado(
                personaDTO.getDomicilio().getEstado());
    }


    public void cargarLocalidadesInegiDeclarante(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaLocalidadColoniasInegiDeclarante = localidadService.findAllByMunicipio(
                personaDTO.getDomicilio().getMunicipio());
        listaTipoLocalidadDeclarante = tipoLocalidadService.findAll();
    }

    /**
     * Recupera los estados  Municipiode  y localidad inegi  del TESTIGO UNO
     */

    public void consultaEstadosRenapoTestigoUno(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosTestigoUno = estadoService.recuperarPorPais(
                personaDTO.getPaisNacimiento());
    }

    public void cargarEstadosInegiTestigoUno(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosInegiTestigoUno = inegiEstadoService.recupearEstadosPorPais(
                personaDTO.getDomicilio().getPais());
    }

    public void cargarMunicipiosInegiTestigoUno(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaMunicipiosInegiTestigoUno = inegiMunicipioService.recuperaMunicipiosPorEstado(
                personaDTO.getDomicilio().getEstado());
    }


    public void cargarLocalidadesInegiTestigoUno(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaLocalidadColoniasInegiTestigoUno = localidadService.findAllByMunicipio(
                personaDTO.getDomicilio().getMunicipio());
        listaTipoLocalidadTestigoUno = tipoLocalidadService.findAll();
    }

    /**
     * Recupera los estados  Municipiode  y localidad inegi  del TESTIGO DOS
     */
    public void consultaEstadosRenapoTestigoDos(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosTestigoDos = estadoService.recuperarPorPais(
                personaDTO.getPaisNacimiento());
    }

    public void cargarEstadosInegiTestigoDos(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosInegiTestigoDos = inegiEstadoService.recupearEstadosPorPais(
                personaDTO.getDomicilio().getPais());
    }

    public void cargarMunicipiosInegiTestigoDos(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaMunicipiosInegiTestigoDos = inegiMunicipioService.recuperaMunicipiosPorEstado(
                personaDTO.getDomicilio().getEstado());
    }


    public void cargarLocalidadesInegiTestigoDos(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaLocalidadColoniasInegiTestigoDos = localidadService.findAllByMunicipio(
                personaDTO.getDomicilio().getMunicipio());
        listaTipoLocalidadTestigoDos = tipoLocalidadService.findAll();
    }

    /**
     *
     * Recupera los estados de renapo del Pais Conyuge y Progenitores
     *
     */
    public void consultaEstadosRenapoConyuge(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosConyuge = estadoService.recuperarPorPais(
                personaDTO.getPaisNacimiento());
    }

    public void consultaEstadosRenapoProgenitorUno(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosProgenitorUno = estadoService.recuperarPorPais(
                personaDTO.getPaisNacimiento());
    }

    public void consultaEstadosRenapoProgenitorDos(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        listaEstadosProgenitorDos = estadoService.recuperarPorPais(
                personaDTO.getPaisNacimiento());
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
        listaEstadosInegiLugarFallecimiento = inegiEstadoService.recupearEstadosPorPais(
                actaDefuncionDTO.getDomicilioOcurrioFallecimiento().getPais());
    }

    /**
     * Recupera los municipios de inegi  del estado Fallecimiento seleccionado
     */
    public void cargarMunicipiosFallecimientoInegi(Integer actaDeDefuncion) {
        ActaDefuncionDTO actaDefuncionDTO = getActaDeDefuncion(actaDeDefuncion);
        listaMunicipiosInegiLugarFallecimiento = inegiMunicipioService.recuperaMunicipiosPorEstado(
                actaDefuncionDTO.getDomicilioOcurrioFallecimiento().getEstado());
    }

    /**
     * Recupera las localidades de inegi del estado Fallecimiento seleccionado
     */
    public void cargarLocalidadesFallecimientoInegi(Integer actaDeDefuncion) {
        ActaDefuncionDTO actaDefuncionDTO = getActaDeDefuncion(actaDeDefuncion);
        listaLocalidadColoniasInegiLugarFallecimiento = localidadService.findAllByMunicipio(
                actaDefuncionDTO.getDomicilioOcurrioFallecimiento().getMunicipio());
        listaTipoLocalidadLugarFallecimiento = tipoLocalidadService.findAll();
    }






}
