package mx.gob.renapo.registrocivil.actos.reconocimiento.bean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import mx.gob.renapo.registrocivil.actos.reconocimiento.dto.ReconocimientoDTO;
import mx.gob.renapo.registrocivil.actos.reconocimiento.service.ReconocimientoService;
import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.*;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.springframework.beans.factory.annotation.Autowired;
import javax.faces.validator.ValidatorException;
import javax.faces.context.FacesContext;
import javax.faces.component.UIComponent;


@Data
public abstract class ReconocimientoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String otorgaConsentimiento;
    private Integer personaOtorgaConsentimiento;
    private String templateOtorgaCOnsentimiento;
    private Integer padres;
    private Integer tipoFormato; //Normal(1), Histórico(2), Especial(3)

    /**
     * Instancias de reconocimiento dto y reconocimiento service
     */

    @Autowired
    private ReconocimientoDTO reconocimiento;

    @Autowired
    private ReconocimientoService reconocimientoService;

    @Autowired
    private ReconocimientoDTO reconocimientoDetalle;

    /**
     * Services para carga de informacion de catalogos lugar de reconocimiento
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
     * Services para carga de informacion de Acta
     */
    @Autowired
    private CatOficialiaService oficialiaService;

    @Autowired
    private CatOficialService oficialService;

    /**
     * Lugar de nacimiento del reconocido
     */
    private List<PaisDTO> listaPaisReconocido;
    private List<PaisDTO> listaPaisReconocedor;
    private List<PaisDTO> listaPaisTestigoUno;
    private List<PaisDTO> listaPaisTestigoDos;
    private List<PaisDTO> listaPaisPersonaConsentimiento;
    private List<PaisDTO> listaPaisAbueloUnoProgenitor;
    private List<PaisDTO> listaPaisAbueloDosReconocedor;
    private List<PaisDTO> listaPaisPadreSanguineo;

    private List<EstadoDTO> listaEstadoReconocido;
    private List<EstadoDTO> listaEstadoReconocedor;
    private List<EstadoDTO> listaEstadoTestigoUno;
    private List<EstadoDTO> listaEstadoTestigoDos;
    private List<EstadoDTO> listaEstadoPersonaConsentimiento;
    private List<EstadoDTO> listaEstadoAbueloUnoProgenitor;
    private List<EstadoDTO> listaEstadoAbueloDosProgenitor;
    private List<EstadoDTO> listaEstadoPadreSanguineo;

    private List<MunicipioDTO> listaMunicipioReconocido;
    private List<MunicipioDTO> listaMunicipioReconocedor;
    private List<MunicipioDTO> listaMunicipioTestigoUno;
    private List<MunicipioDTO> listaMunicipioTestigoDos;
    private List<MunicipioDTO> listaMunicipioPersonaConsentimiento;
    private List<MunicipioDTO> listaMunicipioAbueloUnoProgenitor;
    private List<MunicipioDTO> listaMunicipioAbueloDosProgenitor;
    private List<MunicipioDTO> listaMunicipioPadreSanguineo;

    private List<LocalidadDTO> listaLocalidadReconocido;
    private List<LocalidadDTO> listaLocalidadReconocedor;
    private List<LocalidadDTO> listaLocalidadTestigoUno;
    private List<LocalidadDTO> listaLocalidadTestigoDos;
    private List<LocalidadDTO> listaLocalidadPersonaConsentimiento;
    private List<LocalidadDTO> listaLocalidadAbueloUnoProgenitor;
    private List<LocalidadDTO> listaLocalidadAbueloDosProgenitor;
    private List<LocalidadDTO> listaLocalidadPadreSanguineo;


    /**
     * Domicilio del reconocido - INEGI
     */
    private List<PaisDTO> listaPaisInegiReconocido;
    private List<PaisDTO> listaPaisInegiReconocedor;
    private List<PaisDTO> listaPaisInegiTestigoUno;
    private List<PaisDTO> listaPaisInegiTestigoDos;
    private List<PaisDTO> listaPaisInegiPersonaConsentimiento;
    private List<PaisDTO> listaPaisInegiAbueloUnoProgenitor;
    private List<PaisDTO> listaPaisInegiAbueloDosProgenitor;
    private List<PaisDTO> listaPaisInegiPadreSanguineo;

    private List<EstadoDTO> listaEstadoInegiReconocido;
    private List<EstadoDTO> listaEstadoInegiReconocedor;
    private List<EstadoDTO> listaEstadoInegiTestigoUno;
    private List<EstadoDTO> listaEstadoInegiTestigoDos;
    private List<EstadoDTO> listaEstadoInegiPersonaConsentimiento;
    private List<EstadoDTO> listaEstadoInegiAbueloUnoProgenitor;
    private List<EstadoDTO> listaEstadoInegiAbueloDosProgenitor;
    private List<EstadoDTO> listaEstadoInegiPadreSanguineo;

    private List<MunicipioDTO> listaMunicipioInegiReconocido;
    private List<MunicipioDTO> listaMunicipioInegiReconocedor;
    private List<MunicipioDTO> listaMunicipioInegiTestigoUno;
    private List<MunicipioDTO> listaMunicipioInegiTestigoDos;
    private List<MunicipioDTO> listaMunicipioInegiPersonaConsentimiento;
    private List<MunicipioDTO> listaMunicipioInegiAbueloUnoProgenitor;
    private List<MunicipioDTO> listaMunicipioInegiAbueloDosProgenitor;
    private List<MunicipioDTO> listaMunicipioInegiPadreSanguineo;

    private List<CatTipoLocalidadDTO> listaTipoLocalidadReconocido;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadReconocedor;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadTestigoUno;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadTestigoDos;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadPersonaConsentimiento;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadAbueloUnoProgenitor;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadAbueloDosProgenitor;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadPadreSanguineo;

    private List<LocalidadDTO> listaLocalidadColoniaInegiReconocido;
    private List<LocalidadDTO> listaLocalidadColoniaInegiReconocedor;
    private List<LocalidadDTO> listaLocalidadColoniaInegiTestigoUno;
    private List<LocalidadDTO> listaLocalidadColoniaInegiTestigoDos;
    private List<LocalidadDTO> listaLocalidadColoniaInegiPersonaConsentimiento;
    private List<LocalidadDTO> listaLocalidadColoniaInegiAbueloUnoProgenitor;
    private List<LocalidadDTO> listaLocalidadColoniaInegiAbueloDosProgenitor;
    private List<LocalidadDTO> listaLocalidadColoniaInegiPadreSanguineo;

    private List<CatEstadoCivilDTO> listaEstadoCivilReconocido;
    private List<CatEstadoCivilDTO> listaEstadoCivilReconocedor;
    private List<CatEstadoCivilDTO> listaEstadoCivilTestigoUno;
    private List<CatEstadoCivilDTO> listaEstadoCivilTestigoDos;
    private List<CatEstadoCivilDTO> listaEstadocivilPersonaConsentimiento;
    private List<CatEstadoCivilDTO> listaEstadoCivilAbueloUnoProgenitor;
    private List<CatEstadoCivilDTO> listaEstadoCivilAbueloDosProgenitor;
    private List<CatEstadoCivilDTO> listaEstadoCivilPadreSanguineo;

    //                  Parentesco con el reconocido

    private List<CatParentescoDTO>  listaParentescoReconocedor;
    private List<CatParentescoDTO>  listaParentescoTestigoUno;
    private List<CatParentescoDTO>  listaParentescoTestigoDos;
    private List<CatParentescoDTO>  listaParentescoPersonaConsentimiento;
    private List<CatParentescoDTO>  listaParentescoAbueloUnoProgenitor;
    private List<CatParentescoDTO>  listaParentescoAbueloDosProgenitor;
    private List<CatParentescoDTO>  listaParentescoPadreSanguineo;

    //Listas para el Acta de un Reconocimiento Historico

    private List<EstadoDTO> listaEstadosActa;
    private List<EstadoDTO> listaEstadosActaReconocido;
    private List<MunicipioDTO> listaMunicipiosActa;
    private List<MunicipioDTO> listaMunicipiosActaReconocido;
    private List<OficialiaDTO> listaOficialiasActa;
    private List<OficialiaDTO> listaOficialiasActaReconocido;
    private List<OficialDTO> listaOficialHistorico;

    //Listas para el Acta de un Reconocimiento Historico

    private List<MunicipioDTO> listaMunicipiosEspecial;


    // Cambio de template para la pestaña de Persona de Consentimiento
    public void cambiaTemplateConsentimientoReconocimientoOtro() {
        if(personaOtorgaConsentimiento==ConstantesComunes.CONSENTIMIENTO_OTRO) {
            templateOtorgaCOnsentimiento = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_COSENTIMIENTO_RECONOCIMIENTO_OTRO;
        }
        else{
            templateOtorgaCOnsentimiento = "";
        }
    }

    private PersonaDTO getPersona(Integer persona) {
        PersonaDTO personaDTO = null;

        if (persona.equals(1))
            personaDTO = reconocimiento.getReconocido();
        else if (persona.equals(2))
            return reconocimiento.getReconocedor();
        else if (persona.equals(3))
            personaDTO = reconocimiento.getPersonaConsentimiento();
        else if (persona.equals(4))
            personaDTO = reconocimiento.getAbueloUnoProgenitor();
        else if (persona.equals(5))
            personaDTO = reconocimiento.getAbueloDosProgenitor();
        else if (persona.equals(6))
            personaDTO = reconocimiento.getTestigoUno();
        else if (persona.equals(7))
            personaDTO = reconocimiento.getTestigoDos();
        else if (persona.equals(8))
            personaDTO = reconocimiento.getPadreSanguineo();

        return personaDTO;
    }

    /**
     * Recupera los estados de renapo del Pais seleccionado
     */
    public void cargarEstados(Integer persona) {

        PersonaDTO personaDTO = getPersona(persona);

        if (persona.equals(1)){
            listaEstadoReconocido = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        }else if (persona.equals(2))
            listaEstadoReconocedor = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(3))
            listaEstadoPersonaConsentimiento = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(4))
            listaEstadoAbueloUnoProgenitor = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(5))
            listaEstadoAbueloDosProgenitor = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(6))
            listaEstadoTestigoUno = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(7))
            listaEstadoTestigoDos = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(8))
            listaEstadoPadreSanguineo = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());

    }

    /**
     * Recupera los municipios de renapo del Estado seleccionado
     */
    public void cargarMunicipios(Integer persona) {

        PersonaDTO personaDTO = getPersona(persona);

        if (persona.equals(1)){
            listaMunicipioReconocido = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        }else if (persona.equals(2))
            listaMunicipioReconocedor = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(3))
            listaMunicipioPersonaConsentimiento = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(4))
            listaMunicipioAbueloUnoProgenitor = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(5))
            listaMunicipioAbueloDosProgenitor = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(6))
            listaMunicipioTestigoUno = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(7))
            listaMunicipioTestigoDos = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(8))
            listaMunicipioPadreSanguineo = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
    }

    /**
     * Recupera los Estados de inegi del Pais seleccionado
     */
    public void cargarEstadosInegi(Integer persona) {

        PersonaDTO personaDTO = getPersona(persona);

        if (persona.equals(1)){
            listaEstadoInegiReconocido = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        }else if (persona.equals(2))
            listaEstadoInegiReconocedor = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(3))
            listaEstadoInegiPersonaConsentimiento =inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(4))
            listaEstadoInegiAbueloUnoProgenitor = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(5))
            listaEstadoInegiAbueloDosProgenitor = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(6))
            listaEstadoInegiTestigoUno = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(7))
            listaEstadoInegiTestigoDos = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(8))
            listaEstadoInegiPadreSanguineo = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());

    }

    /**
     * Recupera los municipios de inegi  del estado seleccionado
     */
    public void cargarMunicipiosInegi(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);

        if (persona.equals(1))
            listaMunicipioInegiReconocido = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(2))
            listaMunicipioInegiReconocedor = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(3))
            listaMunicipioInegiPersonaConsentimiento = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(4))
            listaMunicipioInegiAbueloUnoProgenitor = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(5))
            listaMunicipioInegiAbueloDosProgenitor = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(6))
            listaMunicipioInegiTestigoUno = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(7))
            listaMunicipioInegiTestigoDos = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(8))
            listaMunicipioInegiPadreSanguineo = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());

    }

    /**
     * Recupera los municipios de inegi  del estado seleccionado
     */
    public void cargarLocalidadesInegi(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);

        if (persona.equals(1))
            listaLocalidadColoniaInegiReconocido = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(2))
            listaLocalidadColoniaInegiReconocedor = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(3))
            listaLocalidadColoniaInegiPersonaConsentimiento = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(4))
            listaLocalidadColoniaInegiAbueloUnoProgenitor = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(5))
            listaLocalidadColoniaInegiAbueloDosProgenitor = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(6))
            listaLocalidadColoniaInegiTestigoUno = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(7))
            listaLocalidadColoniaInegiTestigoDos = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(8))
            listaLocalidadColoniaInegiPadreSanguineo = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());

    }

    /**
     * Recupera los municipios de inegi  del estado seleccionado
     */
    public void cargarMunicipiosActa(Integer pestanaSeleccionada) {

        if (pestanaSeleccionada.equals(1))
            listaMunicipiosActa =  municipioService.recuperarMunicipiosPorEstado(
                    reconocimiento.getActaDTO().getEntidadRegistro());
        else if (pestanaSeleccionada.equals(2))
            listaMunicipiosActaReconocido = municipioService.recuperarMunicipiosPorEstado(
                    reconocimiento.getActaNacimientoReconocido().getEntidadRegistro());

    }

    /**
     * Metodo para cargar oficilias por municipio
     */
    public void CargarOficialias(Integer pestanaSeleccionada){

        if (pestanaSeleccionada.equals(1))
        listaOficialiasActa = oficialiaService.findByMunicipio
                (reconocimiento.getActaDTO().getMunicipioRegistro());
        else if (pestanaSeleccionada.equals(2))
            listaOficialiasActaReconocido = oficialiaService.findByMunicipio
                    (reconocimiento.getActaNacimientoReconocido().getMunicipioRegistro());
    }

}




