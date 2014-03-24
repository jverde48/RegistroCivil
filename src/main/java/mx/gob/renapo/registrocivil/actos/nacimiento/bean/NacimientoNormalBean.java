package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.impl.NacimientoServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dao.impl.CatEstadoCivilDAOImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.CatAtendioParto;
import mx.gob.renapo.registrocivil.catalogos.service.impl.*;
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


    /**
     * Beans
     */
    @ManagedProperty(name = "paises", value = "#{paises}")
    private List<PaisDTO> paises;
    @ManagedProperty(name = "estados", value = "#{estados}")
    private List<EstadoDTO> estados;
    @ManagedProperty(name = "municipios", value = "#{municipios}")
    private List<MunicipioDTO> municipios;
    @ManagedProperty(name = "atendioPartoLista", value = "#{atendioPartoList}")
    private List<CatAtendioPartoDTO> atendioPartoList;
    @ManagedProperty(name = "tipoPartoList", value = "#{tipoPartoList}")
    private List<CatTipoPartoDTO> tipoPartoList;
    @ManagedProperty(name = "parentescoList", value = "#{parentescoList}")
    private List<CatParentescoDTO> parentescoList;
    @ManagedProperty(name = "lugarPartoList", value = "#{lugarPartoList}")
    private List<CatLugarPartoDTO> lugarPartoList;
    @ManagedProperty(name = "escolaridadList", value = "#{escolaridadList}")
    private List<CatEscolaridadDTO> escolaridadList;
    @ManagedProperty(name = "situacionLaboralList", value = "#{situacionLaboralList}")
    private List<CatSituacionLaboralDTO> situacionLaboralList;
    @ManagedProperty(name = "paisesInegi", value = "#{paisesInegi}")
    private List<PaisDTO> paisesInegi;
    @ManagedProperty(name = "estadosInegi", value = "#{estadosInegi}")
    private List<EstadoDTO> estadosInegi;
    @ManagedProperty(name = "municipiosInegi", value = "#{municipiosInegi}")
    private List<MunicipioDTO> municipiosInegi;
    @ManagedProperty(name = "estadoCivilList", value = "#{estadoCivilLit}")
    private List<CatEstadoCivilDTO> estadoCivilList;
    @ManagedProperty(name = "posicionTrabajoList", value = "#{posicionTrabajoList}")
    private List<CatPuestoDTO> posicionTrabajoList;




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


    }

    /**
     * Metodo para guardar un nuevo registro de nacimiento
     */
    public void guardaRegistroNacimiento() {
         logger.info(nacimientoDTO.getRegistrado().getNombre());
         nacimientoService.guardarNacimiento(nacimientoDTO);

    }


}
