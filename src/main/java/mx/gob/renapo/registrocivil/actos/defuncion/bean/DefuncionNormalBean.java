package mx.gob.renapo.registrocivil.actos.defuncion.bean;

/**
 * Created with IntelliJ IDEA.
 * User: fase1_16
 * Date: 20/03/14
 * Time: 02:01 PM
 * To change this template use File | Settings | File Templates.
 */

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import lombok.Data;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;


@ManagedBean(name="defuncionNormalBean")
@ViewScoped
@Data

public class DefuncionNormalBean extends DefuncionesPrincipalBean implements Serializable{

    private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(DefuncionNormalBean.class);

    private DefuncionDTO defuncionDTO;

    /**
     * Propiedad de Defuncion
     */
}
