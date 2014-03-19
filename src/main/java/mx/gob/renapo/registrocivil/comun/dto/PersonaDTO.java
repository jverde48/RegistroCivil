package mx.gob.renapo.registrocivil.comun.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import mx.gob.renapo.registrocivil.catalogos.entity.*;

@Data
public class PersonaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public PersonaDTO(){}
	
	
	//Datos Persona
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private Integer sexo;
	private Date fechaNacimiento;
	private String cadenaNacimiento;
	private String certificadoNacimiento;
	private String curp;
	private EstadoDTO entidadNacimiento;
	private MunicipioDTO municipioNacimiento;
    private ColoniaLocalidadDTO coloniaLocalidad;
	private String fechaNacimientoInc;
	private NacionalidadDTO nacionalidad;
	private CatInegiPais paisNacimiento;
	private Integer edad;
    private CatEstadoCivilDTO estadoCivil;
    private DomicilioDTO domicilio;


}
