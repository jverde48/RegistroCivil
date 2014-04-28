package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.ParametrosBusqueda;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.impl.NacimientoServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ale
 * Date: 26/04/14
 * Time: 03:35 PM
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean(name="consultasBean")
@RequestScoped
@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ConsultasBean implements Serializable{

    private static Logger log = Logger.getLogger(ConsultasBean.class);
    private static final long serialVersionUID = 1L;
    @Autowired
    private ParametrosBusqueda busqueda;
    @Autowired
    private NacimientoServiceImpl nacimientoService;

    public void cosultaNacimientoPorCadena() throws IOException {
        busqueda.setNacimientos(nacimientoService.consultaNacimientoPorCadena(busqueda.getCadena()));
    }

    public void cosultaNacimientoPorNumeroActa() throws IOException {

        busqueda.setNacimientos(nacimientoService.consultaNacimientoPorNumeroActa(
                busqueda.getAnioRegistro(), busqueda.getNumeroActa()));

    }

    public void consultarNacimiento() throws IOException {

    }

}
