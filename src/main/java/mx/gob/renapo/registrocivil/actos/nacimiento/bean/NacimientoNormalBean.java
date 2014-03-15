package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.impl.NacimientoServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "nacimientoNormalBean")
@ViewScoped
@Data
public class NacimientoNormalBean extends NacimientosPrincipalBean implements Serializable{


	private static final long serialVersionUID = 1L;

    private static Logger logger = Logger.getLogger(NacimientoNormalBean.class);

    private NacimientoDTO nacimientoDTO;

    /**
     * Propiedad de NacimientoService
     */
    @Autowired
    private NacimientoServiceImpl nacimientoService;

    /**
     * Metodo para guardar un nuevo registro de nacimiento
     */
    public void guardaRegistroNacimiento() {
         logger.info(nacimientoDTO.getRegistrado().getNombre());
         nacimientoService.guardarNacimiento(nacimientoDTO);

    }


    //Getter y Setters
    public NacimientoServiceImpl getNacimientoService() {
        return nacimientoService;
    }

    public void setNacimientoService(NacimientoServiceImpl nacimientoService) {
        this.nacimientoService = nacimientoService;
    }
	

}
