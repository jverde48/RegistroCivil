package mx.gob.renapo.registrocivil.comun.bean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "validatorBean")
@ViewScoped
public class ValidatorBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Validator numeros negativos
	 * 
	 */
	public void validateNegativos(FacesContext context, UIComponent toValidate,
			Object arg) {
		
		try {
			if (Integer.parseInt(arg.toString()) < 0) {
				FacesMessage msg = new FacesMessage("Dato validation failed.",
						"El numero ingresado no es valido.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		}catch(NumberFormatException e) {
			FacesMessage msg = new FacesMessage("Dato validation failed.",
					"El numero ingresado no es valido.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		
	}

	public Date getDate() {
		return new Date();
	}

    public void validarEdad(FacesContext context, UIComponent toValidate,
                                        Object edad) {

        try {
            if (Integer.parseInt(edad.toString()) <= 0 || Integer.parseInt(edad.toString()) > 130) {
                FacesMessage msg = new FacesMessage("Dato validation failed.",
                        "Debe ingresar un valor entre 1 y 130.");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }catch(NumberFormatException e) {
            FacesMessage msg = new FacesMessage("Dato validation failed.",
                    "El numero ingresado no es valido.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
