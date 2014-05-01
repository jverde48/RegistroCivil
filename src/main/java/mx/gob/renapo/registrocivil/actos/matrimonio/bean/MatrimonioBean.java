package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.service.MatrimonioService;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.CatParentesco;
import mx.gob.renapo.registrocivil.catalogos.service.*;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import mx.gob.renapo.registrocivil.util.UtileriaService;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@ViewScoped
@ManagedBean(name = "matrimonioBean")
public class MatrimonioBean implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * Instancias de matriminio dto y matrimonio service
     */
    @Autowired
    private MatrimonioDTO matrimonio;

    @Autowired
    private MatrimonioDTO matrimonioDetalle;

    @Autowired
    private MatrimonioService matrimonioService;

    @Autowired
    private UtileriaService utileriaService;


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

    /**
     * Services para carga de informacion de acta matrimonio
     */
    @Autowired
    private CatRegimenService regimenService;

    @Autowired
    private CatOficialiaService oficialiaService;


    /**
     * Lugar de nacimiento del contrayente
     */
    private List<EstadoDTO> listaEstadosContrayenteUno;
    private List<EstadoDTO> listaEstadosContrayenteDos;
    private List<EstadoDTO> listaEstadosConsentimientoUno;
    private List<EstadoDTO> listaEstadosConsentimientoDos;
    private List<EstadoDTO> listaEstadosProgenitorUnoContrayenteUno;
    private List<EstadoDTO> listaEstadosProgenitorDosContrayenteUno;
    private List<EstadoDTO> listaEstadosProgenitorUnoContrayenteDos;
    private List<EstadoDTO> listaEstadosProgenitorDosContrayenteDos;
    private List<EstadoDTO> listaEstadosEstadisticos;

    private List<MunicipioDTO> listaMunicipiosContrayenteUno;
    private List<MunicipioDTO> listaMunicipiosContrayenteDos;
    private List<MunicipioDTO> listaMunicipiosConsentimientoUno;
    private List<MunicipioDTO> listaMunicipiosConsentimientoDos;
    private List<MunicipioDTO> listaMunicipiosProgenitorUnoContrayenteUno;
    private List<MunicipioDTO> listaMunicipiosProgenitorDosContrayenteUno;
    private List<MunicipioDTO> listaMunicipiosProgenitorUnoContrayenteDos;
    private List<MunicipioDTO> listaMunicipiosProgenitorDosContrayenteDos;
    private List<MunicipioDTO> listaMunicipiosEstadisticos;


    /**
     * Domicilio del contrayente - INEGI
     */
    private List<EstadoDTO> listaEstadosInegiContrayenteUno;
    private List<EstadoDTO> listaEstadosInegiContrayenteDos;
    private List<EstadoDTO> listaEstadosInegiConsentimientoUno;
    private List<EstadoDTO> listaEstadosInegiConsentimientoDos;
    private List<EstadoDTO> listaEstadosInegiProgenitorUnoContrayenteUno;
    private List<EstadoDTO> listaEstadosInegiProgenitorDosContrayenteUno;
    private List<EstadoDTO> listaEstadosInegiProgenitorUnoContrayenteDos;
    private List<EstadoDTO> listaEstadosInegiProgenitorDosContrayenteDos;
    private List<EstadoDTO> listaEstadosInegiTestigoUno;
    private List<EstadoDTO> listaEstadosInegiTestigoDos;
    private List<EstadoDTO> listaEstadosInegiTestigoTres;
    private List<EstadoDTO> listaEstadosInegiTestigoCuatro;

    private List<MunicipioDTO> listaMunicipiosInegiContrayenteUno;
    private List<MunicipioDTO> listaMunicipiosInegiContrayenteDos;
    private List<MunicipioDTO> listaMunicipiosInegiConsentimientoUno;
    private List<MunicipioDTO> listaMunicipiosInegiConsentimientoDos;
    private List<MunicipioDTO> listaMunicipiosInegiProgenitorUnoContrayenteUno;
    private List<MunicipioDTO> listaMunicipiosInegiProgenitorDosContrayenteUno;
    private List<MunicipioDTO> listaMunicipiosInegiProgenitorUnoContrayenteDos;
    private List<MunicipioDTO> listaMunicipiosInegiProgenitorDosContrayenteDos;
    private List<MunicipioDTO> listaMunicipiosInegiTestigoUno;
    private List<MunicipioDTO> listaMunicipiosInegiTestigoDos;
    private List<MunicipioDTO> listaMunicipiosInegiTestigoTres;
    private List<MunicipioDTO> listaMunicipiosInegiTestigoCuatro;

    private List<CatTipoLocalidadDTO> listaTipoLocalidadContrayenteUno;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadContrayenteDos;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadConsentimientoUno;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadConsentimientoDos;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadProgenitorUnoContrayenteUno;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadProgenitorDosContrayenteUno;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadProgenitorUnoContrayenteDos;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadProgenitorDosContrayenteDos;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadTestigoUno;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadTestigoDos;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadTestigoTres;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadTestigoCuatro;

    private List<LocalidadDTO> listaLocalidadColoniasInegiContrayenteUno;
    private List<LocalidadDTO> listaLocalidadColoniasInegiContrayenteDos;
    private List<LocalidadDTO> listaLocalidadColoniasInegiConsentimientoUno;
    private List<LocalidadDTO> listaLocalidadColoniasInegiConsentimientoDos;
    private List<LocalidadDTO> listaLocalidadColoniasInegiProgenitorUnoContrayenteUno;
    private List<LocalidadDTO> listaLocalidadColoniasInegiProgenitorDosContrayenteUno;
    private List<LocalidadDTO> listaLocalidadColoniasInegiProgenitorUnoContrayenteDos;
    private List<LocalidadDTO> listaLocalidadColoniasInegiProgenitorDosContrayenteDos;
    private List<LocalidadDTO> listaLocalidadColoniasInegiTestigoUno;
    private List<LocalidadDTO> listaLocalidadColoniasInegiTestigoDos;
    private List<LocalidadDTO> listaLocalidadColoniasInegiTestigoTres;
    private List<LocalidadDTO> listaLocalidadColoniasInegiTestigoCuatro;

    private List<CatEstadoCivilDTO> listaEstadoCivilContrayenteUno;
    private List<CatEstadoCivilDTO> listaEstadoCivilContrayenteDos;
    private List<CatEstadoCivilDTO> listaEstadoCivilConsentimientoUno;
    private List<CatEstadoCivilDTO> listaEstadoCivilConsentimientoDos;
    private List<CatEstadoCivilDTO> listaEstadoCivilProgenitorUnoContrayenteUno;
    private List<CatEstadoCivilDTO> listaEstadoCivilProgenitorDosContrayenteUno;
    private List<CatEstadoCivilDTO> listaEstadoCivilProgenitorUnoContrayenteDos;
    private List<CatEstadoCivilDTO> listaEstadoCivilProgenitorDosContrayenteDos;
    private List<CatEstadoCivilDTO> listaEstadoCivilTestigoUno;
    private List<CatEstadoCivilDTO> listaEstadoCivilTestigoDos;
    private List<CatEstadoCivilDTO> listaEstadoCivilTestigoTres;
    private List<CatEstadoCivilDTO> listaEstadoCivilTestigoCuatro;

    private List<CatSituacionLaboralDTO> listaSituacionLaboralContrayenteUno;
    private List<CatSituacionLaboralDTO> listaSituacionLaboralContrayenteDos;

    /**
     * Parentesco testigos
     */
    private List<CatParentescoDTO> listaParentescoTestigoUno;
    private List<CatParentescoDTO> listaParentescoTestigoDos;
    private List<CatParentescoDTO> listaParentescoTestigoTres;
    private List<CatParentescoDTO> listaParentescoTestigoCuatro;

    /**
     * Datos estadisticos
     */
    private List<CatEscolaridadDTO> listaEscolaridadContrayenteUno;
    private List<CatEscolaridadDTO> listaEscolaridadContrayenteDos;

    private List<CatPuestoDTO> listaPuestoContrayenteUno;
    private List<CatPuestoDTO> listaPuestoContrayenteDos;

    /**
     * Datos del acta de matrimonio
     */
    private List<CatRegimenDTO> listaRegimen;
    private List<OficialiaDTO> listaOficialias;

    private Integer consentimientoContrayenteUno;
	private Integer consentimientoContrayenteDos;
	private String templateConsentimientoContrayenteUno;
	private String templateConsentimientoContrayenteDos;

    /**
     * listas para consultar una vez la bd.
     */
    private List<PaisDTO> listaPaises;
    private List<PaisDTO> listaPaisesInegi;
    private List<CatTipoLocalidadDTO> listaTipoLocalidad;
    private List<CatEstadoCivilDTO> listaEstadoCivil;
    private List<CatSituacionLaboralDTO> listaSituacionLaboral;
    private List<CatParentescoDTO> listaParentesco;
    private List<CatEscolaridadDTO> listaEscolaridad;
    private List<CatPuestoDTO> listaPuestos;


    /**
     * Recupera los estados de renapo del Pais seleccionado
     */
    public void cargarEstadosRenapo(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);

        if (persona.equals(1))
            listaEstadosContrayenteUno = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(2))
            listaEstadosContrayenteDos = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(3))
            listaEstadosConsentimientoUno = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(4))
            listaEstadosConsentimientoDos = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(5))
            listaEstadosProgenitorUnoContrayenteUno = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(6))
            listaEstadosProgenitorDosContrayenteUno = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(7))
            listaEstadosProgenitorUnoContrayenteDos = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
        else if (persona.equals(8))
            listaEstadosProgenitorDosContrayenteDos = estadoService.recuperarPorPais(
                    personaDTO.getPaisNacimiento());
    }

    /**
     * Recupera los municipios de renapo  del estado seleccionado
     */
    public void cargarMunicipiosRenapo(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);
        if (persona.equals(1))
            listaMunicipiosContrayenteUno = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(2))
            listaMunicipiosContrayenteDos = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(3))
            listaMunicipiosConsentimientoUno = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(4))
            listaMunicipiosConsentimientoDos = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(5))
            listaMunicipiosProgenitorUnoContrayenteUno = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(6))
            listaMunicipiosProgenitorDosContrayenteUno = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(7))
            listaMunicipiosProgenitorUnoContrayenteDos = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else if (persona.equals(8))
            listaMunicipiosProgenitorDosContrayenteDos = municipioService.recuperarMunicipiosPorEstado(
                    personaDTO.getEntidadNacimiento());
        else
            listaMunicipiosEstadisticos = municipioService.recuperarMunicipiosPorEstado(
                    matrimonio.getActaMatrimonioDTO().getEntidadRegistro());
    }

    /**
     * Recupera los estados de inegi  del estado seleccionado
     */
    public void cargarEstadosInegi(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);

        if (persona.equals(1))
            listaEstadosInegiContrayenteUno = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(2))
            listaEstadosInegiContrayenteDos = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(3))
            listaEstadosInegiConsentimientoUno = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(4))
            listaEstadosInegiConsentimientoDos = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(5))
            listaEstadosInegiProgenitorUnoContrayenteUno = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(6))
            listaEstadosInegiProgenitorDosContrayenteUno = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(7))
            listaEstadosInegiProgenitorUnoContrayenteDos = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(8))
            listaEstadosInegiProgenitorDosContrayenteDos = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(9))
            listaEstadosInegiTestigoUno = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(10))
            listaEstadosInegiTestigoDos = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(11))
            listaEstadosInegiTestigoTres = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());
        else if (persona.equals(12))
            listaEstadosInegiTestigoCuatro = inegiEstadoService.recupearEstadosPorPais(
                    personaDTO.getDomicilio().getPais());

    }

    /**
     * Recupera los municipios de inegi  del estado seleccionado
     */
    public void cargarMunicipiosInegi(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);

        if (persona.equals(1))
            listaMunicipiosInegiContrayenteUno = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(2))
            listaMunicipiosInegiContrayenteDos = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(3))
            listaMunicipiosInegiConsentimientoUno = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(4))
            listaMunicipiosInegiConsentimientoDos = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(5))
            listaMunicipiosInegiProgenitorUnoContrayenteUno = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(6))
            listaMunicipiosInegiProgenitorDosContrayenteUno = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(7))
            listaMunicipiosInegiProgenitorUnoContrayenteDos = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(8))
            listaMunicipiosInegiProgenitorDosContrayenteDos = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(9))
            listaMunicipiosInegiTestigoUno = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(10))
            listaMunicipiosInegiTestigoDos = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(11))
            listaMunicipiosInegiTestigoTres = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
        else if (persona.equals(12))
            listaMunicipiosInegiTestigoCuatro = inegiMunicipioService.recuperaMunicipiosPorEstado(
                    personaDTO.getDomicilio().getEstado());
    }

    /**
     * Recupera las localidades de inegi del estado seleccionado
     */
    public void cargarLocalidadesInegi(Integer persona) {
        PersonaDTO personaDTO = getPersona(persona);

        if (persona.equals(1))
            listaLocalidadColoniasInegiContrayenteUno = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(2))
            listaLocalidadColoniasInegiContrayenteDos = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(3))
            listaLocalidadColoniasInegiConsentimientoUno = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(4))
            listaLocalidadColoniasInegiConsentimientoDos = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(5))
            listaLocalidadColoniasInegiProgenitorUnoContrayenteUno = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(6))
            listaLocalidadColoniasInegiProgenitorDosContrayenteUno = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(7))
            listaLocalidadColoniasInegiProgenitorUnoContrayenteDos = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(8))
            listaLocalidadColoniasInegiProgenitorDosContrayenteDos = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(9))
            listaLocalidadColoniasInegiTestigoUno = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(10))
            listaLocalidadColoniasInegiTestigoDos = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(11))
            listaLocalidadColoniasInegiTestigoTres = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
        else if (persona.equals(12))
            listaLocalidadColoniasInegiTestigoCuatro = localidadService.findAllByMunicipio(
                    personaDTO.getDomicilio().getMunicipio());
    }

    /**
     * Metodo para cargar oficilias por municipio
     */
    public void cargarOficialias(){
        listaOficialias = oficialiaService.findByMunicipio(
                matrimonio.getActaMatrimonioDTO().getMunicipioRegistro());
    }
	
	/**
     * Metodo para cargar template de consentimiento a contrayente uno menor de edad
     */
    public void cambiaTemplateConsentimientoContrayenteUno() {
   	 if(consentimientoContrayenteUno==ConstantesComunes.CONSENTIMIENTO_OTRO) {
   		 templateConsentimientoContrayenteUno = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_CONSENTIMIENTO_CONTRAYENTE_UNO;
   	 }
   	 else{
   		 templateConsentimientoContrayenteUno = "";
   	 }
    }

    public void cambiaTemplateConsentimientoReconocimientoOtro() {
        if(consentimientoContrayenteUno==ConstantesComunes.CONSENTIMIENTO_OTRO) {
            templateConsentimientoContrayenteUno = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_COSENTIMIENTO_RECONOCIMIENTO_OTRO;
        }
        else{
            templateConsentimientoContrayenteUno = "";
        }
    }

    /**
     * Metodo para cargar template de consentimiento a contrayente dos menor de edad
     */
    public void cambiaTemplateConsentimientoContrayenteDos() {
   	 if(consentimientoContrayenteDos==ConstantesComunes.CONSENTIMIENTO_OTRO) {
   		 templateConsentimientoContrayenteDos = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_CONSENTIMIENTO_CONTRAYENTE_DOS;
   	 }
   	 else{
   		 templateConsentimientoContrayenteDos = "";
   	 }
    }

    private PersonaDTO getPersona(Integer persona) {
        PersonaDTO personaDTO = null;

        if (persona.equals(1))  // Contrayente Uno
            personaDTO = matrimonio.getContrayenteUno();
        else if (persona.equals(2))  //Contrayente dos
            return matrimonio.getContrayenteDos();
        else if (persona.equals(3))  // Consentimiento Uno
            personaDTO = matrimonio.getConsentimientoContrayenteUno();
        else if (persona.equals(4))  // Consentimiento dos
            personaDTO = matrimonio.getConsentimientoContrayenteDos();
        else if (persona.equals(5))  // Padre uno Cont. uno
            personaDTO = matrimonio.getProgenitorUnoContrayenteUno();
        else if (persona.equals(6))  // Padre dos cont. uno
            personaDTO = matrimonio.getProgenitorDosContrayenteUno();
        else if (persona.equals(7))  // Padre uno Cont. dos
            personaDTO = matrimonio.getProgenitorUnoContrayenteDos();
        else if (persona.equals(8))  // Padre dos Cont. dos
            personaDTO = matrimonio.getProgenitorDosContrayenteDos();
        else if (persona.equals(9))  // testigo uno
            personaDTO = matrimonio.getTestigoUno();
        else if (persona.equals(10))  // testigo dos
            personaDTO = matrimonio.getTestigoDos();
        else if (persona.equals(11))  // testigo tres
            personaDTO = matrimonio.getTestigoTres();
        else if (persona.equals(12))  // testigo cuatro
            personaDTO = matrimonio.getTestigoCuatro();

        return personaDTO;
    }

    public void eliminarMatrimonio(Long id) throws IOException {
        if(matrimonioService.eliminarActoMatrimonio(id)) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getFlash().setKeepMessages(true);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_INFO,"El registro se ha eliminado correctamente.", ""));

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.CONSULTA_MATRIMONIO));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR,"Ocurri\u00f3 un error al guardar el registro.", ""));
            RequestContext.getCurrentInstance().execute("errorDialog.show()");
        }
    }

    public void regresar() throws IOException {
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(externalContext.getRequestContextPath()
                    .concat(ConstantesComunes.CONSULTA_MATRIMONIO));
    }

    public void calcularEdad(Integer persona) {
        int edad = 0;
        PersonaDTO personaDTO = getPersona(persona);

        if (persona.equals(1)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getContrayenteUno().getFechaNacimiento());
            matrimonio.getContrayenteUno().setEdad(edad);
        } else if (persona.equals(2)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getContrayenteDos().getFechaNacimiento());
            matrimonio.getContrayenteDos().setEdad(edad);
        } else if (persona.equals(3)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getConsentimientoContrayenteUno().getFechaNacimiento());
            matrimonio.getConsentimientoContrayenteUno().setEdad(edad);
        } else if (persona.equals(4)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getConsentimientoContrayenteDos().getFechaNacimiento());
            matrimonio.getConsentimientoContrayenteDos().setEdad(edad);
        } else if (persona.equals(5)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getProgenitorUnoContrayenteUno().getFechaNacimiento());
            matrimonio.getProgenitorUnoContrayenteUno().setEdad(edad);
        } else if (persona.equals(6)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getProgenitorDosContrayenteUno().getFechaNacimiento());
            matrimonio.getProgenitorDosContrayenteUno().setEdad(edad);
        } else if (persona.equals(7)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getProgenitorUnoContrayenteDos().getFechaNacimiento());
            matrimonio.getProgenitorUnoContrayenteDos().setEdad(edad);
        } else if (persona.equals(8)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getProgenitorDosContrayenteDos().getFechaNacimiento());
            matrimonio.getProgenitorDosContrayenteDos().setEdad(edad);
        } else if (persona.equals(9)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getTestigoUno().getFechaNacimiento());
            matrimonio.getTestigoUno().setEdad(edad);
        } else if (persona.equals(10)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getTestigoDos().getFechaNacimiento());
            matrimonio.getTestigoDos().setEdad(edad);
        } else if (persona.equals(11)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getTestigoTres().getFechaNacimiento());
            matrimonio.getTestigoTres().setEdad(edad);
        } else if (persona.equals(12)) {
            edad = utileriaService.calcularEdadPersona(
                    matrimonio.getTestigoCuatro().getFechaNacimiento());
            matrimonio.getTestigoCuatro().setEdad(edad);
        }
    }
}
