package mx.gob.renapo.registrocivil.actos.defuncion.bean;

/**
 * Created with IntelliJ IDEA.
 * User: fase1_16
 * Date: 20/03/14
 * Time: 02:01 PM
 * To change this template use File | Settings | File Templates.
 */

import mx.gob.renapo.registrocivil.actos.defuncion.service.impl.DefuncionServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.*;
import mx.gob.renapo.registrocivil.catalogos.service.impl.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    private DefuncionServiceImpl defuncionService;

    @Autowired
    private CatPaisService paisService;
    @Autowired
    private CatEstadoService estadoService;
    @Autowired
    private CatMunicipioService municipioService;
    @Autowired
    private CatEscolaridadService escolaridadService;
    @Autowired
    private CatParentescoService parentescoService;
    @Autowired
    private CatLugarFalleceService lugarFalleceService;

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

    private List<ColoniaLocalidadDTO> listaLocalidadColoniasInegi;

    private List<EstadoDTO> listaEstadosInegi;

    private List<PaisDTO> listaPaisesInegi;

    private List<CatEstadoCivilDTO> listaEstadoCivil;

    private List<CatSituacionLaboralDTO> listaSituacionLaboral;


}
