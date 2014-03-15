package mx.gob.renapo.registrocivil.util.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Green4
 * Date: 7/03/14
 * Time: 09:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Data
public class PersonaCertificadoDTO {
    //Datos de la persona
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;

    //Datos del lugar de Nacimiento
    private Integer idEstadoNacimiento;
    private String estadoNacimiento;
    private Integer idMunicipioNacimiento;
    private String municipioNacimiento;

    //Datos de los padres
    //Progenitor Uno
    private String nombreProgenitorUno;
    private String primerApellidoProgenitorUno;
    private String segundoApellidoProgenitorUno;
    private int codigoRespuesta;
}
