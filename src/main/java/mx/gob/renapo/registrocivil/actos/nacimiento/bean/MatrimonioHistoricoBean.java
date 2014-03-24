package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.gob.renapo.registrocivil.comun.bean.*;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

@ManagedBean(name = "matrimonioHistoricoBean")
@Data
@ViewScoped

public class MatrimonioHistoricoBean {
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
