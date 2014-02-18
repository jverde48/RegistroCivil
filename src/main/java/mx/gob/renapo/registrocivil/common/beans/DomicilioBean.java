package mx.gob.renapo.registrocivil.common.beans;

import lombok.Data;

@Data

public class DomicilioBean {
	
	private String calle;
	private String numeroExterior;
	private String numeroInteror;
	private Integer colonia; //TODO pk a cat�logo de localidad de INEGI
	private Integer tipoLocalidad; //TODO pk hacia localidad de INEGI
	private Integer municipio; //TODO pk del cat�logo de municipios
	private Integer estado; //TODO pk del cat�logo de estados
	private String codigoPostal; 
	private Integer pais;  //TODO pk del cat�logo de pa�s
	
	public DomicilioBean(){}

}
