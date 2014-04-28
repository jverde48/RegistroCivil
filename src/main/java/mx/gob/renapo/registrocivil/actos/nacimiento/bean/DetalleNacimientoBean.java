package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 4/27/14
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */

@Data
@ManagedBean(name = "detalleNacimientoBean")
@Component
@ViewScoped
public class DetalleNacimientoBean {

    @Autowired
    private NacimientoDTO detalleNacimiento;

    private Boolean existenciaAbueloUnoProgenitorUno;
    private Boolean existenciaAbueloDosProgenitorUno;
    private Boolean existenciaAbueloUnoProgenitorDos;
    private Boolean existenciaAbueloDosProgenitorDos;

    public void cargarDetalleNacimiento(NacimientoDTO nacimientoDTO) throws IOException {

        setDetalleNacimiento(nacimientoDTO);
        if(nacimientoDTO.getProgenitorDos()!=null) {
            setExistenciaAbueloDosProgenitorDos(false);
            setExistenciaAbueloUnoProgenitorDos(false);
            setExistenciaAbueloUnoProgenitorUno(true);
            setExistenciaAbueloDosProgenitorUno(true);
        }

        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(externalContext.getRequestContextPath()
                .concat(ConstantesComunes.DETALLE_NACIMIENTO));

    }

}
