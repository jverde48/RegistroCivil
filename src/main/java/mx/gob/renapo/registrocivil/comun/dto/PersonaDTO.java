package mx.gob.renapo.registrocivil.comun.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class
        PersonaDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public PersonaDTO(){}
	
	
	//Datos Persona
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private char sexo;
	private Date fechaNacimiento;
	private String cadenaNacimiento;
	private String certificadoNacimiento;
	private String curp;
    private Integer edad;
    private String localidadNacimiento;

    @Autowired
	private EstadoDTO entidadNacimiento;

    @Autowired
	private MunicipioDTO municipioNacimiento;

    @Autowired
    private LocalidadDTO coloniaLocalidad;

	private String fechaNacimientoInc;

    private String nacionalidad;

    @Autowired
	private PaisDTO paisNacimiento;

    @Autowired
    private CatEstadoCivilDTO estadoCivil;

    @Autowired
    private DomicilioDTO domicilio;
}
