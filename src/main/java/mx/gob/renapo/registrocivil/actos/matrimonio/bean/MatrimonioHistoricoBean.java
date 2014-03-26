package mx.gob.renapo.registrocivil.actos.matrimonio.bean;

import lombok.Data;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

@ManagedBean(name = "matrimonioHistoricoBean")
@Data
@ViewScoped

public class MatrimonioHistoricoBean {
	//Datos Acta
		@ManagedProperty(value="#{datosActa}")
		private ActaDTO datosActa;
		
		//Datos Contrayentes
		@ManagedProperty(value="#{contrayente1}")
		private PersonaDTO contrayente1;
		@ManagedProperty(value="#{contrayente2}")
		private PersonaDTO contrayente2;
		
		//Datos Padres contrayente1
		@ManagedProperty(value="#{padreContrayente1}")
		private PersonaDTO padreContrayente1;
		@ManagedProperty(value="#{madreContrayente1}")
		private PersonaDTO madreContrayente1;
		
		//Datos Padres contrayente2
		@ManagedProperty(value="#{padreContrayente2}")
		private PersonaDTO padreContrayente2;
		@ManagedProperty(value="#{madreContrayente2}")
		private PersonaDTO madreContrayente2;
		
		//Datos Testigos
		@ManagedProperty(value="#{testigo1}")
		private PersonaDTO testigo1;
		@ManagedProperty(value="#{testigo2}")
		private PersonaDTO testigo2;
		@ManagedProperty(value="#{testigo3}")
		private PersonaDTO testigo3;
		@ManagedProperty(value="#{testigo4}")
		private PersonaDTO testigo4;
		
		private Integer consentimientoContrayenteUno;
		private Integer consentimientoContrayenteDos;
		private String templateConsentimientoContrayenteUno;
		private String templateConsentimientoContrayenteDos;
		
		@PostConstruct
		public void init(){
			if (datosActa == null)
				datosActa = new ActaDTO();
			if (contrayente1 == null)
				contrayente1 = new PersonaDTO();
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