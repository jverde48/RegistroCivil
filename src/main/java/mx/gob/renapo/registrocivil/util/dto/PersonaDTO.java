package mx.gob.renapo.registrocivil.util.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Green4
 * Date: 7/03/14
 * Time: 08:08 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
public class PersonaDTO {
    //Datos de la persona
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;
    private String sexo;
    private String curp;
    private Boolean vivoMuerto;

    //Datos del lugar de Nacimiento
    private Integer idEstadoNacimiento;
    private String estadoNacimiento;
    private Integer idMunicipioNacimiento;
    private String municipioNacimiento;
    private String localidad;

    //Datos del lugar y fecha de registro
    private Integer idEstadoRegistro;
    private String estadoRegistro;
    private Integer idMunicipioRegistro;
    private String municipioRegistro;
    private Long idOficialia;
    private String oficialiaRegistro;
    private Integer anioRegistro;
    private Date fechaRegistro;

    //Datos de los padres
    //Progenitor Uno
    private String nombreProgenitorUno;
    private String primerApellidoProgenitorUno;
    private String segundoApellidoProgenitorUno;
    private String curpProgenitorUno;
    //Progenitor Dos
    private String nombreProgenitorDos;
    private String primerApellidoProgenitorDos;
    private String segundoApellidoProgenitorDos;
    private String curpProgenitorDos;

    //Datos del Acta
    private String actaBis;
    private String foja;
    private String libro;
    private String tomo;
    private Long folio;
    private String numeroActa;
    private String ssa;

    //Codigo de Respuesta
    private int codigoRespuesta;
}
