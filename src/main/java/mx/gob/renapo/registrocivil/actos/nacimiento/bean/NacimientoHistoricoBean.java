package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import lombok.Data;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import mx.gob.renapo.registrocivil.comun.dto.PersonaDTO;
import mx.gob.renapo.registrocivil.util.ConstantesComunes;

@ManagedBean(name = "registroHistoricoNacimientoBean")
@Data
@ViewScoped
public class NacimientoHistoricoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		//Datos Acta
		@ManagedProperty(value="#{acta}")
		private ActaDTO acta;
		
	//Datos registrado
		@ManagedProperty(value="#{registrado}")
		private PersonaDTO registrado;
		
	//Datos progenitores (padres)
		@ManagedProperty(value = "#{progenitorUno}")
		private PersonaDTO progenitorUno;
		@ManagedProperty(value = "#{progenitorDos}")
		private PersonaDTO progenitorDos;
		
	//Datos Abuelos
		@ManagedProperty(value = "#{abueloUnoProgenitorUno}")
		private PersonaDTO abueloUnoProgenitorUno;
		@ManagedProperty(value = "#{abueloDosProgenitorUno}")
		private PersonaDTO abueloDosProgenitorUno;
		@ManagedProperty(value = "#{abueloUnoProgenitorDos}")
		private PersonaDTO abueloUnoProgenitorDos;
		@ManagedProperty(value = "#{abueloDosProgenitorDos}")
		private PersonaDTO abueloDosProgenitorDos;
		
	//Datos Testigos
		@ManagedProperty(value = "#{testigoUno}")
		private PersonaDTO testigoUno;
		@ManagedProperty(value = "#{testigoDos}")
		private PersonaDTO testigoDos;
		
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

}
