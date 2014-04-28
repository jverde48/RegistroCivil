package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.matrimonio.dto.MatrimonioDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 27/04/14
 * Time: 09:44 PM
 * To change this template use File | Settings | File Templates.
 */

@Data
@Component
@ViewScoped
@ManagedBean(name = "matrimonioDetalleBean")
public class MatrimonioDetalleBean extends MatrimonioBean implements Serializable {

    public void cargarMatrimonioDetalle(MatrimonioDTO detalle) throws Exception {
        System.out.println("el matrimonio" + detalle);
        setMatrimonioDetalle(detalle);

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath()
                .concat(ConstantesComunes.DETALLE_MATRIMONIO));
    }
}
