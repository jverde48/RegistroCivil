package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.impl.NacimientoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Ale
 * Date: 26/04/14
 * Time: 03:35 PM
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean(name="consultasBean")
@ViewScoped
@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ConsultasBean {

    private List<NacimientoDTO> nacimientos;
    private String cadena;
    private String numeroActa;
    private Integer anioRegistro;
    @Autowired
    private NacimientoServiceImpl nacimientoService;

    public void cosultaNacimientoPorCadena() throws IOException {
        setNacimientos(nacimientoService.consultaNacimientoPorCadena( getCadena()));
    }

    public void cosultaNacimientoPorNumeroActa() throws IOException {

        setNacimientos(nacimientoService.consultaNacimientoPorNumeroActa(
                getAnioRegistro(), getNumeroActa()));

    }

}
