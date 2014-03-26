package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.actos.matrimonio.service.MatrimonioService;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.CatParentesco;
import mx.gob.renapo.registrocivil.catalogos.service.*;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public abstract class MatrimonioBean implements Serializable {

	private static final long serialVersionUID = 1L;

    /**
     * Instancias de matriminio dto y matrimonio service
     */
    @Autowired
    private MatrimonioDTO matrimonio;

    @Autowired
    private MatrimonioService matrimonioService;


    /**
     * Services para carga de informacion de catalogos lugar de nacimiento
     */
    @Autowired
    private CatPaisService paisService;

    @Autowired
    private CatEstadoService estadoService;

    @Autowired
    private CatMunicipioService municipioService;

    @Autowired
    private CatNacionalidadService nacionalidadService;


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


    /**
     * Lugar de nacimiento del contrayente
     */
    private List<PaisDTO> listaPaises;

    private List<EstadoDTO> listaEstados;

    private List<MunicipioDTO> listaMunicipios;

    private List<NacionalidadDTO> listaNacionalidad;


    /**
     * Domicilio del contrayente - INEGI
     */
    private List<PaisDTO> listaPaisesInegi;

    private List<EstadoDTO> listaEstadosInegi;

    private List<MunicipioDTO> listaMunicipiosInegi;

    private List<CatTipoLocalidadDTO> listaTipoLocalidad;

    private List<LocalidadDTO> listaLocalidadColoniasInegi;

    private List<CatEstadoCivilDTO> listaEstadoCivil;

    private List<CatSituacionLaboralDTO> listaSituacionLaboral;

    /**
     * Parentesco testigos
     */
    private List<CatParentescoDTO> listaParentesco;

    /**
     * Datos estadisticos
     */
    private List<CatEscolaridadDTO> listaEscolaridad;

    private List<CatPuestoDTO> listaPuestos;

    /**
     * Datos del acta de matrimonio
     */
    private List<CatRegimenDTO> listaRegimen;

    private Integer consentimientoContrayenteUno;
	private Integer consentimientoContrayenteDos;
	private String templateConsentimientoContrayenteUno;
	private String templateConsentimientoContrayenteDos;
	
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

}
