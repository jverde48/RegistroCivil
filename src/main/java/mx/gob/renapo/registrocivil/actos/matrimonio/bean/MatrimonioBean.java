package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import java.io.Serializable;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

@Data
public abstract class MatrimonioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer consentimientoContrayenteUno;
	private Integer consentimientoContrayenteDos;
	private String templateConsentimientoContrayenteUno;
	private String templateConsentimientoContrayenteDos;
	
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
