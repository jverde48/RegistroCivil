package mx.gob.renapo.registrocivil.common.beans;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "validatorBean")
@ViewScoped
public class ValidatorBean {

    /**
     * Validator numeros negativos
     * 
     */
    public void validateNegativos(FacesContext context, UIComponent toValidate,
            Object arg) {
        if (Integer.parseInt(arg.toString()) < 0) {
            FacesMessage msg = new FacesMessage("Dato validation failed.",
                    "El numero ingresado no es valido.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
    
    public Date getDate() {
        return new Date();
    }
}
