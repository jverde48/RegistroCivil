package mx.gob.renapo.registrocivil.actos.matrimonio.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/4/14
 * Time: 4:20 PM
 * Clase para representar la entity de Matrimonio
 */

@Entity
@Table(name = "MATRIMONIO")
@Data
@EqualsAndHashCode(callSuper=false)
public class Matrimonio extends SequenceGenerator implements Serializable {

    public Matrimonio() {}

    /**
     * Datos del Acta
     */
    @Column(name = "TOMO", nullable = true)
    private String tomo;

    @Column(name = "LIBRO", nullable = true)
    private String libro;

    @Column(name = "FOJA", nullable = true)
    private String foja;

    @Column(name = "ACTA_BIS", nullable = true)
    private Integer actaBis;

    @Column(name = "CADENA", nullable = true)
    private String cadena;

    @Column(name = "NUMERO_ACTA_MATRIMONIO", nullable = true)
    private String numeroActaMatrimonio;

    @Column(name = "FECHA_REGISTRO", nullable = true)
    private Date fechaRegistro;

    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;

    @Column(name = "IM_NOMBRE", nullable = true)
    private String imNombre;

    @Column(name = "SELLO", nullable = true)
    private String sello;

    // Esta propiedad hace referencia a la ruta donde se guarda la imagen
    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;

    @Column(name = "AUTORIZACION_DGRC", nullable = true)
    private String autorizacionDgrc;

    @Column(name = "TRANSCRIPCION", nullable = true)
    private String transcripcion;

    @Column(name = "LLAVE_ORIGINAL", nullable = true)
    private String llaveOriginal;

    @OneToOne
    @JoinColumn(name = "OFICIALIA", nullable = true)
    private CatOficialia oficialia;

    @OneToOne
    @JoinColumn(name = "REGIMEN", nullable = true)
    private CatRegimen regimen;

    /**
     * Datos de los contrayentes
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTRAYENTE_UNO", nullable = true)
    private Persona contrayenteUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTRAYENTE_DOS", nullable = true)
    private Persona contrayenteDos;

    //Situacion laboral contrayentes
    @OneToOne
    @JoinColumn(name = "SIT_LAB_UNO", nullable = true)
    private CatSituacionLaboral situacionLaboralContrayenteUno;

    @OneToOne
    @JoinColumn(name = "SIT_LAB_DOS", nullable = true)
    private CatSituacionLaboral situacionLaboralContrayenteDos;

    //Escolaridad contrayentes
    @OneToOne
    @JoinColumn(name = "ESCOLARIDAD_UNO", nullable = true)
    private CatEscolaridad escolaridadContrayenteUno;

    @OneToOne
    @JoinColumn(name = "ESCOLARIDAD_DOS", nullable = true)
    private CatEscolaridad escolaridadContrayenteDos;

    //Ocupacion de los contrayentes
    @Column(name = "OCUPACION_CONTRAYENTE_UNO", nullable = true)
    private String ocupacionContrayenteUno;

    @Column(name = "OCUPACION_CONTRAYENTE_DOS", nullable = true)
    private String ocupacionContrayenteDos;

    //Puesto de los contrayentes
    @OneToOne
    @JoinColumn(name = "POS_TRAB_UNO", nullable = true)
    private CatPuesto posicionTrabajoContrayenteUno;

    @OneToOne
    @JoinColumn(name = "POS_TRAB_DOS", nullable = true)
    private CatPuesto posicionTrabajoContrayenteDos;

    /**
     * Datos de las personas que otorgan consetimiento
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONSEN_MENOR_CONTRAYENTE_UNO", nullable = true)
    private Persona consenMenorContrayenteUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONSEN_MENOR_CONTRAYENTE_DOS", nullable = true)
    private Persona consenMenorContrayenteDos;

    /**
     * Datos de los padres de los contrayentes
     */
    //Padres contrayente uno
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MADRE_UNO", nullable = true)
    private Persona madreContrayenteUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PADRE_UNO", nullable = true)
    private Persona padreContrayenteUno;

    //Padres contrayente dos
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MADRE_DOS", nullable = true)
    private Persona madreContrayenteDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PADRE_DOS", nullable = true)
    private Persona padreContrayenteDos;

    // Ocupacion de los padres
    //Ocupacion padres uno
    @Column(name = "OCUPACION_MADRE_UNO", nullable = true)
    private String ocupacionMadreContrayenteUno;

    @Column(name = "OCUPACION_PADRE_UNO", nullable = true)
    private String ocupacionPadreContrayenteUno;

    @Column(name = "OCUPACION_MADRE_DOS", nullable = true)
    private String ocupacionMadreContrayenteDos;

    @Column(name = "OCUPACION_PADRE_DOS", nullable = true)
    private String ocupacionPadreContrayenteDos;

    /**
     * Testigos
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_TRES", nullable = true)
    private Persona testigoTres;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_CUATRO", nullable = true)
    private Persona testigoCuatro;

    //Ocupacion de los testigos
    @Column(name = "OCUPACION_TEST_UNO", nullable = true)
    private String ocupacionTestigoUno;

    @Column(name =  "OCUPACION_TEST_DOS", nullable = true)
    private String ocupacionTestigoDos;

    @Column(name = "OCUPACION_TEST_TRES", nullable = true)
    private String ocupacionTestigoTres;

    @Column(name = "OCUPACION_TEST_CUATRO", nullable = true)
    private String ocupacionTestigoCuatro;

    //Prentesco de los testigos
    @OneToOne
    @JoinColumn(name = "PARENTESCO_TEST_UNO", nullable = true)
    private CatParentesco parentescoTestigoUno;

    @OneToOne
    @JoinColumn(name = "PARENTESCO_TEST_DOS", nullable = true)
    private CatParentesco parentescoTestigoDos;

    @OneToOne
    @JoinColumn(name = "PARENTESCO_TEST_TRES", nullable = true)
    private CatParentesco parentescoTestigoTres;

    @OneToOne
    @JoinColumn(name = "PARENTESCO_TEST_CUATRO", nullable = true)
    private CatParentesco parentescoTestigoCuatro;


    /**
     * Datos del registro del acto
     */
    @Column(name = "TIPO_CAPTURA", nullable = true)
    private char tipoCaptura;

    @Column(name = "TIPO_OPERACION", nullable = true)
    private Integer tipoOperacion;

    //TODO RELACION A TABLA DE NOTAS MARGINALES
}
