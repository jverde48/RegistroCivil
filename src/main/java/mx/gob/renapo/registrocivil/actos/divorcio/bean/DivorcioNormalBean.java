package mx.gob.renapo.registrocivil.actos.divorcio.bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.divorcio.dto.DivorcioDTO;
import mx.gob.renapo.registrocivil.actos.divorcio.service.impl.DivorcioServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.service.impl.*;


@ManagedBean(name="divorcioNormalBean")
@ViewScoped
@Data
@Component
public class DivorcioNormalBean implements Serializable{

	private static final long serialVersionUID = 1L;

    private static Logger logger = Logger.getLogger(DivorcioNormalBean.class);
    
    @Autowired
    private DivorcioDTO divorcioDTO;
    
    /**
     * Beans de services
     */
    @Autowired
    private DivorcioServiceImpl divorcioService;
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
    private CatEstadoCivilServiceImpl estadoCivilService;
    @Autowired
    private CatEscolaridadServiceImpl escolaridadService;
    @Autowired
    private CatParentescoServiceImpl parentescoService;
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
    @ManagedProperty(name = "parentescoList", value = "#{parentescoList}")
    private List<CatParentescoDTO> parentescoList;
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
        parentescoList = parentescoService.findAll();
        escolaridadList = escolaridadService.findAll();
        situacionLaboralList = situacionLaboralService.findAll();
        estadoCivilList = estadoCivilService.findAll();
        posicionTrabajoList = puestoService.findAll();

    }
    
    /**
     * Metodo para guardar un nuevo registro de divorcio
     */
    public void guardaRegistroDivorcio() {
         logger.info(divorcioDTO.getDivorciadoUno().getNombre());
         divorcioService.guardarDivorcio(divorcioDTO);

    }
    
}
