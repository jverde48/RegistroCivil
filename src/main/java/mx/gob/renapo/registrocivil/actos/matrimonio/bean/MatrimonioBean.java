package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import java.io.Serializable;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import mx.gob.renapo.registrocivil.common.beans.*;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

@ManagedBean(name = "matrimonioBean")
@Data
@ViewScoped
public class MatrimonioBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Datos Acta
	@ManagedProperty(value="#{datosActa}")
	private ActaBean datosActa;
	
	//Datos Contrayentes
	@ManagedProperty(value="#{contrayente1}")
	private PersonaBean contrayente1;
	@ManagedProperty(value="#{contrayente2}")
	private PersonaBean contrayente2;
	
	//Datos Padres contrayente1
	@ManagedProperty(value="#{padreContrayente1}")
	private PersonaBean padreContrayente1;
	@ManagedProperty(value="#{madreContrayente1}")
	private PersonaBean madreContrayente1;
	
	//Datos Padres contrayente2
	@ManagedProperty(value="#{padreContrayente2}")
	private PersonaBean padreContrayente2;
	@ManagedProperty(value="#{madreContrayente2}")
	private PersonaBean madreContrayente2;
	
	//Datos Testigos
	@ManagedProperty(value="#{testigo1}")
	private PersonaBean testigo1;
	@ManagedProperty(value="#{testigo2}")
	private PersonaBean testigo2;
	@ManagedProperty(value="#{testigo3}")
	private PersonaBean testigo3;
	@ManagedProperty(value="#{testigo4}")
	private PersonaBean testigo4;
	
	private Integer consentimientoContrayenteUno;
	private Integer consentimientoContrayenteDos;
	private String templateConsentimientoContrayenteUno;
	private String templateConsentimientoContrayenteDos;
	
	@PostConstruct
	public void init(){
		if (datosActa == null)
			datosActa = new ActaBean();
		if (contrayente1 == null)
			contrayente1 = new PersonaBean();
	}
	
	//Validaciones (validacion Hora)
	public void validate(FacesContext context, UIComponent toValidate, Object arg){
		
		 String[] numerosComoArray = ((String) arg).split(":");
		 
	        	if (Integer.parseInt(numerosComoArray[0]) > 24
	        		|| Integer.parseInt(numerosComoArray[1]) > 59
					|| Integer.parseInt(numerosComoArray[2]) > 59) {
	        		FacesMessage msg = 
	                        new FacesMessage("Hora Invalida", 
	                                "La hora ingresada no es valida");
	        		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	        		throw new ValidatorException(msg);
	        	}  
	}
	
	/**
     * Metodo para cargar template de consentimiento a contrayente uno menor de edad
     */
    public void cambiaTemplateConsentimientoContrayenteUno() {
   	 if(consentimientoContrayenteUno==ConstantesComunes.CONSENTIMIENTO_OTRO) {
   		 templateConsentimientoContrayenteUno = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_CONSENTIMIENTO_CONTRAYENTE_UNO;
   	 }
   	 else{
   		 templateConsentimientoContrayenteUno = "";
   	 }
    }
    
    /**
     * Metodo para cargar template de consentimiento a contrayente dos menor de edad
     */
    public void cambiaTemplateConsentimientoContrayenteDos() {
   	 if(consentimientoContrayenteDos==ConstantesComunes.CONSENTIMIENTO_OTRO) {
   		 templateConsentimientoContrayenteDos = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_CONSENTIMIENTO_CONTRAYENTE_DOS;
   	 }
   	 else{
   		 templateConsentimientoContrayenteDos = "";
   	 }
    }

}
