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
    private String templateOtorgaCOnsentimiento;
    private Integer padres;

    /**
     * Instancias de reconocimiento dto y reconocimiento service
     */

    @Autowired
    private ReconocimientoDTO reconocimiento;


    @Autowired
    private ReconocimientoService reconocimientoService;


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
     * Lugar de nacimiento del reconocido
     */
    private List<PaisDTO> listaPaisReconocido;
    private List<PaisDTO> listaPaisReconocedor;
    private List<PaisDTO> listaPaisTestigoUno;
    private List<PaisDTO> listaPaisTestigoDos;
    private List<PaisDTO> listaPaisPersonaConsentimiento;
    private List<PaisDTO> listaPaisAbueloUnoProgenitor;
    private List<PaisDTO> listaPaisAbueloDosReconocedor;

    private List<EstadoDTO> listaEstadoReconocido;
    private List<EstadoDTO> listaEstadoReconocedor;
    private List<EstadoDTO> listaEstadoTestigoUno;
    private List<EstadoDTO> listaEstadoTestigoDos;
    private List<EstadoDTO> listaEstadoPersonaConsentimiento;
    private List<EstadoDTO> listaEstadoAbueloUnoProgenitor;
    private List<EstadoDTO> listaEstadoAbueloDosProgenitor;

    private List<MunicipioDTO> listaMunicipioReconocido;
    private List<MunicipioDTO> listaMunicipioReconocedor;
    private List<MunicipioDTO> listaMunicipioTestigoUno;
    private List<MunicipioDTO> listaMunicipioTestigoDos;
    private List<MunicipioDTO> listaMunicipioPersonaConsentimiento;
    private List<MunicipioDTO> listaMunicipioAbueloUnoProgenitor;
    private List<MunicipioDTO> listaMunicipioAbueloDosProgenitor;

    private List<LocalidadDTO> listaLocalidadReconocido;
    private List<LocalidadDTO> listaLocalidadReconocedor;
    private List<LocalidadDTO> listaLocalidadTestigoUno;
    private List<LocalidadDTO> listaLocalidadTestigoDos;
    private List<LocalidadDTO> listaLocalidadPersonaConsentimiento;
    private List<LocalidadDTO> listaLocalidadAbueloUnoProgenitor;
    private List<LocalidadDTO> listaLocalidadAbueloDosProgenitor;



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

    private List<EstadoDTO> listaEstadoInegiReconocido;
    private List<EstadoDTO> listaEstadoInegiReconocedor;
    private List<EstadoDTO> listaEstadoInegiTestigoUno;
    private List<EstadoDTO> listaEstadoInegiTestigoDos;
    private List<EstadoDTO> listaEstadoInegiPersonaConsentimiento;
    private List<EstadoDTO> listaEstadoInegiAbueloUnoProgenitor;
    private List<EstadoDTO> listaEstadoInegiAbueloDosProgenitor;

    private List<MunicipioDTO> listaMunicipioInegiReconocido;
    private List<MunicipioDTO> listaMunicipioInegiReconocedor;
    private List<MunicipioDTO> listaMunicipioInegiTestigoUno;
    private List<MunicipioDTO> listaMunicipioInegiTestigoDos;
    private List<MunicipioDTO> listaMunicipioInegiPersonaConsentimiento;
    private List<MunicipioDTO> listaMunicipioInegiAbueloUnoProgenitor;
    private List<MunicipioDTO> listaMunicipioInegiAbueloDosProgenitor;

    private List<CatTipoLocalidadDTO> listaTipoLocalidadReconocido;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadReconocedor;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadTestigoUno;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadTestigoDos;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadPersonaConsentimiento;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadAbueloUnoProgenitor;
    private List<CatTipoLocalidadDTO> listaTipoLocalidadAbueloDosProgenitor;

    private List<LocalidadDTO> listaLocalidadColoniaInegiReconocedor;
    private List<LocalidadDTO> listaLocalidadColoniaInegiTestigoUno;
    private List<LocalidadDTO> listaLocalidadColoniaInegiTestigoDos;
    private List<LocalidadDTO> listaLocalidadColoniaInegiPersonaConsentimiento;
    private List<LocalidadDTO> listaLocalidadColoniaInegiAbueloUnoProgenitor;
    private List<LocalidadDTO> listaLocalidadColoniaInegiAbueloDosProgenitor;

    private List<CatEstadoCivilDTO> listaEstadoCivilReconocido;
    private List<CatEstadoCivilDTO> listaEstadoCivilReconocedor;
    private List<CatEstadoCivilDTO> listaEstadoCivilTestigoUno;
    private List<CatEstadoCivilDTO> listaEstadoCivilTestigoDos;
    private List<CatEstadoCivilDTO> listaEstadocivilPersonaConsentimiento;
    private List<CatEstadoCivilDTO> listaEstadoCivilAbueloUnoProgenitor;
    private List<CatEstadoCivilDTO> listaEstadoCivilAbueloDosProgenitor;

    //                  Parentesco con el reconocido

    private List<CatParentescoDTO>  listaParentescoReconocedor;
    private List<CatParentescoDTO>  listaParentescoTestigoUno;
    private List<CatParentescoDTO>  listaParentescoTestigoDos;
    private List<CatParentescoDTO>  listaParentescoPersonaConsentimiento;
    private List<CatParentescoDTO>  listaParentescoAbueloUnoProgenitor;
    private List<CatParentescoDTO>  listaParentescoAbueloDosProgenitor;

}




