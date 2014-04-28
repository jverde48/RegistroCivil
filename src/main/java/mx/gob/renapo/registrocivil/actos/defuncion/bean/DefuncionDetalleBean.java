package mx.gob.renapo.registrocivil.actos.defuncion.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.defuncion.dto.DefuncionDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molins S
 * Date: 28/04/14
 * Time: 01:05 AM
 * To change this template use File | Settings | File Templates.
 */
@Data
@Component
@ViewScoped
@ManagedBean(name = "defuncionDetalleBean")
public class DefuncionDetalleBean extends DefuncionesPrincipalBean implements Serializable{

    public void cargarDefuncionDetalle(DefuncionDTO detalle) throws Exception {
        System.out.println("La defuncion" + detalle);
        setDefuncionDetalle(detalle);

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath()
                .concat(ConstantesComunes.DETALLE_DEFUNCION));
    }
}
