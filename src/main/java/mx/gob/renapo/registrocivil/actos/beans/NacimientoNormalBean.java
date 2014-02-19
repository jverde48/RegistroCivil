package mx.gob.renapo.registrocivil.actos.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import lombok.Data;
import mx.gob.renapo.registrocivil.common.beans.ActaBean;
import mx.gob.renapo.registrocivil.common.beans.PersonaBean;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

@ManagedBean(name = "registroNormalNacimientoBean")
@Data
@ViewScoped
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
      * Metodo para cambiar el template necesario para el formulario de los padres
      */
     public void cambiaTemplateProgenitores() {
    	 if(padres == 1) {
    		 templatePadres = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_PROGENITOR_UNO;
    	 }
    	 else if(padres == 2) {
    		 templatePadres = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_AMBOS_PADRES;
    	 }
     }
     
             /**
             * Metodo para cargar template de comparece
             */
            public void cambiaTemplateComparece() {
           	 if(comparece==ConstantesComunes.COMPARCENCIA_OTRO) {
           		 templateComparece = ConstantesComunes.TEMPLATE_DATOS_PERSONALES_COMPARECE;
           	 }
            }
       	
     
     /**
      * Metodo para calcular la edad en base a la fecha de nacimiento	 
      */
      public void calculaEdad() {
    	  
      }

}
