package mx.gob.renapo.registrocivil.comun.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.entity.*;

@Data
public class PersonaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//Datos Persona
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Integer sexo;   //TODO PK catalogo de sexo
	private Date fechaNacimiento;
	private String cadenaNacimiento;
	private String certificadoNacimiento;
	private String curp;
	private CatEstado entidadNAcimiento;  //TODO PK catalogo estados
	private CatMunicipio municipioNacimiento;  //PK catalogo municimios
	private CatInegiLocalidad localidadNacimiento;
	private String fechaNacimientoIncEspecial;
	private CatNacionalidad nacionalidad;  //TODO PK catalogo nacionalidad
	private CatInegiPais paisNacimiento; //TODO PK catalogo pais
	private Integer edad;
    private CatEstadoCivil estadoCivil;
	
	public PersonaDTO(){}
	
	
	

}
