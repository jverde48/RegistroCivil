package mx.gob.renapo.registrocivil.actos.defuncion.bean;
/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 01:47 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import lombok.Data;

@Data
public class DefuncionesPrincipalBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean existenciaConyuge;
    private Boolean existenciaProgenitorUno;
    private Boolean existenciaProgenitorDos;
}
