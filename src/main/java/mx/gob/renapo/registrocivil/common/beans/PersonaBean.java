package mx.gob.renapo.registrocivil.common.beans;

import java.util.Date;

import lombok.Data;
@Data
public class PersonaBean {
	
	//Datos Persona
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Integer sexo;   //TODO PK catalogo de sexo
	private Date fechaNacimiento;
	private String cadenaNacimiento;
	private String certificadoNacimiento;
	private String curp;
	private Integer entidadNAcimiento;  //TODO PK catalogo estados
	private Integer municipioNacimiento;  //PK catalogo municimios
	private String localidadNacimiento;
	private String fechaNacimientoIncEspecial;
	private Integer nacionalidad;  //TODO PK catalogo nacionalidad
	private Integer paisNacimiento; //TODO PK catalogo pais
	
	public PersonaBean(){}
	
	
	

}
