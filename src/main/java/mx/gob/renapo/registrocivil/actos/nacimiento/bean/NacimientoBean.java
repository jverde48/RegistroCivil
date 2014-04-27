package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.impl.NacimientoServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.impl.*;
import mx.gob.renapo.registrocivil.comun.dto.DomicilioDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ale
 * Date: 25/04/14
 * Time: 01:00 PM
 * To change this template use File | Settings | File Templates.
 */

@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@ViewScoped
@ManagedBean(name = "nacimientoBean")
public class NacimientoBean {

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(NacimientoBean.class);

    @Autowired
    private NacimientoDTO nacimientoDTO;
    @Autowired
    private NacimientoDTO detalleNacimiento;
    private List<NacimientoDTO> nacimientos;
    private String templatePadres = "";
    private Integer padres;
    private Boolean existenciaAbueloUnoProgenitorUno;
    private Boolean existenciaAbueloDosProgenitorUno;
    private Boolean existenciaAbueloUnoProgenitorDos;
    private Boolean existenciaAbueloDosProgenitorDos;
    private Integer comparece;
    private String templateComparece;
    private String templateEstadisticosPadre;
    private Boolean madreSoltera;
    private Integer fechaRegistro;

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
    @Autowired
    private CatPuestoServiceImpl puestoTrabajoService;
    @Autowired
    private CatCompareceServiceImpl compareceService;

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
    private boolean compareceOtro;


    @PostConstruct
    public void init() {
        if(nacimientos==null) {
            nacimientos = new ArrayList<NacimientoDTO>();
        }
    }

    public void cosultaNacimientoPorCadena() throws IOException {

        setNacimientos(nacimientoService.consultaNacimientoPorCadena(
                getNacimientoDTO().getActaNacimiento().getCadena()));
    }

    public void cosultaNacimientoPorNumeroActa() throws IOException {

        setNacimientos(nacimientoService.consultaNacimientoPorNumeroActa(
                Integer.valueOf(getNacimientoDTO().getActaNacimiento().getAnioRegistro())
                ,getNacimientoDTO().getActaNacimiento().getNumeroActa()));

    }

    /**
     * Metodo para recuperar los estados por pais de una persona en especifico
     * (Progenitor Uno, Progenitor Dos, Testigo Uno, Testigo Dos, Persona Distinta
     * que comparece)
     * @param tipoPersona
     */
    public void consultaEstados(Integer tipoPersona, Integer tipoRegistro) {
        PersonaDTO persona = obtienePersona(tipoPersona);
        PaisDTO pais = persona.getPaisNacimiento();

        switch(tipoPersona) {
            case 2:
                setEstadosProgenitorUno(getEstadoService().recuperarPorPais(pais));
                break;
            case 3:
                setEstadosProgenitorDos(getEstadoService().recuperarPorPais(pais));
                break;
            case 8:
                setEstadosTestigoUno(getEstadoService().recuperarPorPais(pais));
                break;
            case 9:
                setEstadosTestigoDos(getEstadoService().recuperarPorPais(pais));
                break;
            case 10:
                setEstadosPersonaDistintaComparece(getEstadoService().recuperarPorPais(pais));
                break;
        }
    }

    /**
     * Metodo que carga los municipios de un estado seleccionado segun la persona
     * @param tipoPersona
     */
    public void consultaMuncipios(Integer tipoPersona, Integer tipoRegistro) {
        PersonaDTO persona = obtienePersona(tipoPersona);
        EstadoDTO estado = persona.getEntidadNacimiento();

        switch(tipoPersona) {
            case 1:
                setMunicipiosResgistrado(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 2:
                setMunicipiosProgenitorUno(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 3:
                setMunicipiosProgenitorDos(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 8:
                setMunicipiosTestigoUno(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 9:
                setMunicipiosTestigoDos(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
            case 10:
                setMunicipiosPersonaDistintaComparece(getMunicipioService().recuperarMunicipiosPorEstado(estado));
                break;
        }

    }

    public void consultaEstadosInegi(Integer tipoPersona, Integer tipoRegistro) {
        PersonaDTO persona = obtienePersona(tipoPersona);
        PaisDTO pais = persona.getDomicilio().getPais();
        switch(tipoPersona) {
            case 1:
                setEstadosInegiRegistrado(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 2:
                setEstadosInegiProgenitorUno(getInegiEstadoService().recupearEstadosPorPais(pais));
                agregaDomicilioPadresRegistrado(1);
                break;
            case 3:
                setEstadosInegiProgenitorDos(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 8:
                setEstadosInegiTestigoUno(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 9:
                setEstadosInegiTestigoDos(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
            case 10:
                setEstadosInegiPersonaDistintaComarece(getInegiEstadoService().recupearEstadosPorPais(pais));
                break;
        }

    }

    public void consultaMunicipiosInegi(Integer tipoPersona, Integer tipoRegistro) {
        PersonaDTO persona = obtienePersona(tipoPersona);
        EstadoDTO estado = persona.getDomicilio().getEstado();
        switch(tipoPersona) {
            case 1:
                setMunicipiosInegiRegistrado(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 2:
                setMunicipiosInegiProgenitorUno(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                agregaDomicilioPadresRegistrado(2);
                break;
            case 3:
                setMunicipiosInegiProgenitorDos(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 8:
                setMunicipiosInegiTestigoUno(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 9:
                setMunicipiosInegiTestigoDos(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
                break;
            case 10:
                setMunicipiosInegiPersonaDistintaComparece(getInegiMunicipioService().recuperaMunicipiosPorEstado(estado));
        }
    }

    public void consultaLocalidadesInegi(Integer tipoPersona, Integer tipoRegistro) {
        PersonaDTO persona = obtienePersona(tipoPersona);
        MunicipioDTO municipio = persona.getDomicilio().getMunicipio();
        switch(tipoPersona) {
            case 1:
                setLocalidadesRegistrado(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 2:
                setLocalidadesProgenitorUno(getLocalidadService().findAllByMunicipio(municipio));
                agregaDomicilioPadresRegistrado(3);
                break;
            case 3:
                setLocalidadesProgenitorDos(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 8:
                setLocalidadesTestigoUno(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 9:
                setLocalidadesTestigoDos(getLocalidadService().findAllByMunicipio(municipio));
                break;
            case 10:
                setLocalidadesPersonaDistintaComparece (getLocalidadService().findAllByMunicipio(municipio));
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
                persona = getNacimientoDTO().getRegistrado();
                break;
            case 2:
                persona = getNacimientoDTO().getProgenitorUno();
                break;
            case 3:
                persona = getNacimientoDTO().getProgenitorDos();
                break;
            case 4:
                persona = getNacimientoDTO().getAbueloUnoProgenitorUno();
                break;
            case 5:
                persona = getNacimientoDTO().getAbuelaUnoProgenitorDos();
                break;
            case 6:
                persona = getNacimientoDTO().getAbueloDosProgenitorUno();
                break;
            case 7:
                persona = getNacimientoDTO().getAbueloDosProgenitorDos();
                break;
            case 8:
                persona = getNacimientoDTO().getTestigoUno();
                break;
            case 9:
                persona = getNacimientoDTO().getTestigoDos();
                break;
            case 10:
                persona = getNacimientoDTO().getPersonaDistintaComparece();
                break;
        }
        return persona;
    }



    /**
     * Metodo para cambiar el template necesario para el formulario de los
     * padres
     */
    public void cambiaTemplateProgenitores() {
        if (padres == 1) {
            templatePadres = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_PROGENITOR_UNO;
        } else if (padres == 2) {
            templatePadres = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_AMBOS_PADRES;
        }
    }


    /**
     * Metodo para cargar template de comparece
     */
    public void cambiaTemplateComparece() {
        if (getNacimientoDTO().getCompareceDTO().getId().intValue() == ConstantesComunes.COMPARCENCIA_OTRO
                ||
                getNacimientoDTO().getCompareceDTO().getId().intValue() == ConstantesComunes.COMPARENCIA_INDETERMINADO) {
            setCompareceOtro(true);
            setTemplateComparece(ConstantesComunes.TEMPLATE_DATOS_PERSONALES_COMPARECE);
        }
        else {
            setCompareceOtro(false);
        }
    }


    public void validaComparecencia(FacesContext context, UIComponent toValidate,
                                    Object arg) {
        if(nacimientoDTO.getCompareceDTO()!=null){
            if(getMadreSoltera() && nacimientoDTO.getCompareceDTO().getId().intValue() == 1 ||
                    nacimientoDTO.getCompareceDTO().getId().intValue() == 3 ) {
                FacesMessage msg = new FacesMessage("Dato validation failed.",
                        "La comparecencia no es valida debido a que la madre es soltera");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
    }

    /**
     * Metodo que sirve para asignar el domicilio del progenitor uno al registrado en cuanto a catalogos se refiere
     * @param seccionDomicilio indica que seccion del domicilio va a asignar, si se trata del pais, estado, municipio o localidad
     */
    public void agregaDomicilioPadresRegistrado(Integer seccionDomicilio) {

        DomicilioDTO domicilioProgenitor = getNacimientoDTO().getProgenitorUno().getDomicilio();

        switch (seccionDomicilio){
            case 1:
                getNacimientoDTO().getRegistrado().getDomicilio().setPais(domicilioProgenitor.getPais());
                break;
            case 2:
                setEstadosInegiRegistrado(getInegiEstadoService()
                        .recupearEstadosPorPais(domicilioProgenitor.getPais()));
                getNacimientoDTO().getRegistrado().getDomicilio().setEstado(domicilioProgenitor.getEstado());
                break;
            case 3:
                setMunicipiosInegiRegistrado(getInegiMunicipioService()
                        .recuperaMunicipiosPorEstado(domicilioProgenitor.getEstado()));
                getNacimientoDTO().getRegistrado().getDomicilio().setMunicipio(domicilioProgenitor.getMunicipio());
                break;
            case 4:
                setLocalidadesRegistrado(getLocalidadService().findAllByMunicipio(domicilioProgenitor.getMunicipio()));
                getNacimientoDTO().getRegistrado().getDomicilio().setLocalidad(domicilioProgenitor.getLocalidad());
                break;
            case 5:
                getNacimientoDTO().getRegistrado().getDomicilio().setTipoLocalidad((domicilioProgenitor.getTipoLocalidad()));
                break;
        }


    }
}