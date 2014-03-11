package mx.gob.renapo.registrocivil.comun.dto;

import lombok.Data;

@Data

public class DomicilioDTO {
	
	private String calle;
	private String numeroExterior;
	private String numeroInteror;
	private Integer colonia; //TODO pk a catalogo de localidad de INEGI
	private Integer tipoLocalidad; //TODO pk hacia localidad de INEGI
	private Integer municipio; //TODO pk del catalogo de municipios
	private Integer estado; //TODO pk del catalogo de estados
	private String codigoPostal; 
	private Integer pais;  //TODO pk del catalogo de pais
	
	public DomicilioDTO(){}

}
