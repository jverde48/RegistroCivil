package mx.gob.renapo.registrocivil.comun.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/3/14
 * Time: 1:19 PM
 * Clase  que representa la entidad de Persona en la BBDD
 */

@Entity
@Table(name = "PERSONA")
@Data
@EqualsAndHashCode(callSuper=false)
public class Persona extends SequenceGenerator implements Serializable{

    @Column(name = "CADENA", nullable = false)
    private String cadena;

    @Column(name = "CERTIFICADO_NACIMIENTO", nullable = true)
    private String certificadoNacimiento;

    @Column(name = "CURP", nullable = true)
    private String curp;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "PRIMER_APELLIDO", nullable = false)
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO", nullable = true)
    private String segundoApellido;

    @Column(name = "EDAD", nullable = true)
    private  Integer edad;

    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    private Date fechaNacimiento;

    @Column(name = "FECHA_NACIMIENTO_INCORRECTA", nullable = true)
    private String fechaNacimientoIncorrecta;

    @Column(name = "SEXO", nullable = false)
    private char sexo;

    @OneToOne
    @JoinColumn(name = "NACIONALIDAD", nullable = true)
    private CatNacionalidad nacionalidad;

    @OneToOne
    @JoinColumn(name = "PAIS", nullable = true)
    private CatPais pais;

    @OneToOne
    @JoinColumn(name = "ENTIDAD", nullable = true)
    private CatEstado entidad;

    @OneToOne
    @JoinColumn(name = "MUNICIPIO", nullable = true)
    private CatMunicipio municipio;

    @OneToOne
    @JoinColumn(name = "LOCALIDAD", nullable = true)
    private CatInegiLocalidad localidad;

    @OneToOne
    @JoinColumn(name = "DOMICILIO", nullable = true)
    private Domicilio domicilio;

    @OneToOne
    @JoinColumn(name = "ESTADO_CIVIL", nullable = true)
    private CatEstadoCivil estadoCivil;

}
