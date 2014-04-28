package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.ParametrosBusqueda;
import mx.gob.renapo.registrocivil.actos.nacimiento.service.impl.NacimientoServiceImpl;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
    @Autowired
    @ManagedProperty(value = "#{detalleNacimientoBean}")
    private DetalleNacimientoBean detalleNacimientoBean;

    public void cosultaNacimientoPorCadena() throws IOException {
        busqueda.setNacimientos(nacimientoService.consultaNacimientoPorCadena(busqueda.getCadena()));
    }

    public void cosultaNacimientoPorNumeroActa() throws IOException {

        busqueda.setNacimientos(nacimientoService.consultaNacimientoPorNumeroActa(
                busqueda.getAnioRegistro(), busqueda.getNumeroActa()));

    }

    public void consultarNacimiento(Long id) throws IOException {
        detalleNacimientoBean.setDetalleNacimiento(
                nacimientoService.recuperarActaNacimiento(id)
        );

        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);

        FacesContext.getCurrentInstance().addMessage
                (null, new FacesMessage
                        (FacesMessage.SEVERITY_INFO,"Exito", "Se ha generado el acta de nacimiento"));

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath()
                .concat(ConstantesComunes.DETALLE_NACIMIENTO));

    }

}
