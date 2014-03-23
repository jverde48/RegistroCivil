package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.impl.NacimientoServiceImpl;
import mx.gob.renapo.registrocivil.catalogos.dao.impl.CatEstadoCivilDAOImpl;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
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
    private CatMunicipioServiceImpl municipioService;
    @Autowired
    private CatAtendioPartoServiceImpl atendioPartoService;
    /*@Autowired
    private CatEstadoCivilServiceImpl estadoCivilService;*/
    @Autowired
    private CatEscolaridadServiceImpl escolaridadService;
    @Autowired
    private CatTipoPartoServiceImpl tipoPartoService;
    @Autowired
    private CatParentescoServiceImpl parentescoService;
    @Autowired
    private CatLugarPartoServiceImpl lugarPartoService;


    /**
     * Beans
     */
    @ManagedProperty(name = "paises", value = "#{paises}")
    private List<PaisDTO> paises;
    @ManagedProperty(name = "estados", value = "#{estados}")
    private List<EstadoDTO> estados;
    @ManagedProperty(name = "municipios", value = "#{municipios}")
    private List<MunicipioDTO> municipios;


    @PostConstruct
    public void init() {
        paises = paisService.findAll();
    }

    /**
     * Metodo para guardar un nuevo registro de nacimiento
     */
    public void guardaRegistroNacimiento() {
         logger.info(nacimientoDTO.getRegistrado().getNombre());
         nacimientoService.guardarNacimiento(nacimientoDTO);

    }


    //Getter y Setters
    public NacimientoServiceImpl getNacimientoService() {
        return this.nacimientoService;
    }

    public void setNacimientoService(NacimientoServiceImpl nacimientoService) {
        this.nacimientoService = nacimientoService;
    }
	
    public CatPaisServiceImpl getPaisService() {
        return this.paisService;
    }

    public void setPaisService(CatPaisServiceImpl paisService) {
        this.paisService = paisService;
    }

    public CatEstadoServiceImpl getEstadoService() {
        return this.estadoService;
    }

    public void setEstadoService(CatEstadoServiceImpl estadoService) {
        this.estadoService = estadoService;
    }
}
