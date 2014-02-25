package mx.gob.renapo.registrocivil.actos.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import lombok.Data;
import mx.gob.renapo.registrocivil.common.beans.ActaBean;
import mx.gob.renapo.registrocivil.common.beans.PersonaBean;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

/**
 * Clase padre para el acto de nacimiento
 * @author Alejandro Diaz
 *
 */
@Data
public class NacimientosPrincipalBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Datos Acta
	@ManagedProperty(value = "#{acta}")
	private ActaBean acta;

	// Datos registrado
	@ManagedProperty(value = "#{registrado}")
	private PersonaBean registrado;

	// Datos progenitores (padres)
	@ManagedProperty(value = "#{progenitorUno}")
	private PersonaBean progenitorUno;
	@ManagedProperty(value = "#{progenitorDos}")
	private PersonaBean progenitorDos;

	// Datos Abuelos
	@ManagedProperty(value = "#{abueloUnoProgenitorUno}")
	private PersonaBean abueloUnoProgenitorUno;
	@ManagedProperty(value = "#{abueloDosProgenitorUno}")
	private PersonaBean abueloDosProgenitorUno;
	@ManagedProperty(value = "#{abueloUnoProgenitorDos}")
	private PersonaBean abueloUnoProgenitorDos;
	@ManagedProperty(value = "#{abueloDosProgenitorDos}")
	private PersonaBean abueloDosProgenitorDos;

	// Datos Testigos
	@ManagedProperty(value = "#{testigoUno}")
	private PersonaBean testigoUno;
	@ManagedProperty(value = "#{testigoDos}")
	private PersonaBean testigoDos;

	private String templatePadres = "";
	private Integer padres;

	private Boolean existenciaAbueloUnoProgenitorUno;
	private Boolean existenciaAbueloDosProgenitorUno;
	private Boolean existenciaAbueloUnoProgenitorDos;
	private Boolean existenciaAbueloDosProgenitorDos;

	private Integer comparece;
	private String templateComparece;
	private String templateEstadisticosPadre;

	/**
	 * Metodo para cambiar el template necesario para el formulario de los
	 * padres
	 */
	public void cambiaTemplateProgenitores() {
		if (padres == 1) {
			templatePadres = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_PROGENITOR_UNO;
		} else if (padres == 2) {
			templatePadres = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_AMBOS_PADRES;
		}
	}

	/**
	 * Metodo para cargar template de comparece
	 */
	public void cambiaTemplateComparece() {
		if (comparece == ConstantesComunes.COMPARCENCIA_OTRO) {
			templateComparece = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_COMPARECE;
		}
	}


     public void validaComparecencia(FacesContext context, UIComponent toValidate,
            Object arg) {
		if(padres == 1 && (Integer.valueOf(arg.toString()) == 2 || 
				Integer.valueOf(arg.toString()) == 3)) {
			 FacesMessage msg = new FacesMessage("Dato validation failed.",
			"La comparecencia no es valida debido a que la madre es soltera");
	            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	            throw new ValidatorException(msg);
		}
	}

}
