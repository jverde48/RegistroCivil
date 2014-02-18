package mx.gob.renapo.registrocivil.common.beans;

import lombok.Data;

@Data

public class DomicilioBean {
	
	private String calle;
	private String numeroExterior;
	private String numeroInteror;
	private Integer colonia; //TODO pk a catálogo de localidad de INEGI
	private Integer tipoLocalidad; //TODO pk hacia localidad de INEGI
	private Integer municipio; //TODO pk del catálogo de municipios
	private Integer estado; //TODO pk del catálogo de estados
	private String codigoPostal; 
	private Integer pais;  //TODO pk del catálogo de país
	
	public DomicilioBean(){}

}
