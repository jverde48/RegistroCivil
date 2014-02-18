package mx.gob.renapo.registrocivil.actos.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import lombok.Data;
import mx.gob.renapo.registrocivil.common.beans.ActaBean;
import mx.gob.renapo.registrocivil.common.beans.PersonaBean;

@ManagedBean(name = "registroNormalNacimientoBean")
@Data
@RequestScoped
public class NacimientoNormalBean {
	
	//Datos Acta
		@ManagedProperty(value="#{acta}")
		private ActaBean acta;
		
	//Datos registrado
		@ManagedProperty(value="#{registrado}")
		private PersonaBean registrado;
		
	//Datos progenitores (padres)
		@ManagedProperty(value = "#{progenitorUno}")
		private PersonaBean progenitorUno;		
		@ManagedProperty(value = "#{progenitorDos}")
		private PersonaBean progenitorDos;
		
	//Datos Abuelos
		@ManagedProperty(value = "#{abueloUnoProgenitorUno}")
		private PersonaBean abueloUnoProgenitorUno;		
		@ManagedProperty(value = "#{abueloDosProgenitorUno}")
		private PersonaBean abueloDosProgenitorUno;
		@ManagedProperty(value = "#{abueloUnoProgenitorDos}")
		private PersonaBean abueloUnoProgenitorDos;		
		@ManagedProperty(value = "#{abueloDosProgenitorDos}")
		private PersonaBean abueloDosProgenitorDos;
		
	//Datos Testigos
		@ManagedProperty(value = "#{testigoUno}")
		private PersonaBean testigoUno;		
		@ManagedProperty(value = "#{testigoDos}")
		private PersonaBean testigoDos;
		
     private String template = "";
     private Integer padres;
     
     
     public void cambiaTemplateProgenitores() {
    	 if(padres == 1) {
    		 template = "datosPersonalesProgenitorUno.xhtml";
    	 }
    	 else if(padres == 2) {
    		 template = "datosPersonalesProgenitorDos.xhtml";
    	 }
    	 else if(padres == 3){
    		 template = "datosPersonalesAmbosPadres.xhtml";
    	 }
     }
	
	

}
