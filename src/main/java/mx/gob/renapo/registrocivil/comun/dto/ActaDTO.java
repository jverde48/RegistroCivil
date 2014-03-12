package mx.gob.renapo.registrocivil.comun.dto;

import java.util.Date;

import lombok.Data;

@Data

public class ActaDTO {
	
	//Datos del Acta
		private Integer entidadRegistro;
		private Integer municipioRegistro;
		private Integer oficialia;
		private Date fechaRegistro;
		private String numeroActa;
		private String actabis;
		//private String tomo;     //TODO Falta definir tipo de Dato
		private String libro;
		private String foja;
		private String localidadRegistro;
		private String crip;
		private String cadena;
		private String anioRegistro;
		private String llaveOriginal;
		private Long notasMarginales;  //TODO pk del catalogo de Notas Marginales
		private Long nombreOficialRegistroCivil; //TODO pk del catalogo Oficiales
		private Long tipoDocumento; //TODO pk del catalogo Tipo_Documento
		private char vivoMuerto;
		private String horaNacimiento; //TODO falta definir el tipo de dato
		private Long comparece; //TODO pk	
		
		public ActaDTO(){}

}
