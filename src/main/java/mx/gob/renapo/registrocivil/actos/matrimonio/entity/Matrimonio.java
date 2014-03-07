package mx.gob.renapo.registrocivil.actos.matrimonio.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
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
public class Matrimonio {

    /**
     * Propiedades que forman parte de la informacion misma del acta de matrimonio
     */

     @Column(name = "ACTA_BIS", nullable = true)
    private String actaBis;

    @Column(name = "AUTORIZACION_DGRC", nullable = true)
    private String autorizacionDgrc;

    //TODO verificar generacion de cadena, verificar si se genera en otra tabla

    @Column(name = "CRIP_UNO", nullable = true)
    private String cripUno;

    @Column(name = "CRIP_DOS", nullable = true)
    private String cripDos;

    @OneToOne
    @JoinColumn(name = "ESCOLARIDAD_UNO", nullable = false)
    private CatEscolaridad escolaridadContrayenteUno;

    @OneToOne
    @JoinColumn(name = "ESCOLARIDAD_DOS", nullable = false)
    private CatEscolaridad escolaridadContrayenteDos;

    //TODO verificar relacion de estado

    @Column(name = "FECHA_REGISTRO", nullable = false)
    private Date fechaRegistro;

    @Column(name = "FOJA", nullable = true)
    private String foja;

    //TODO verificar generacion de GUID

    //TODO verificar que se mande guardar mejor la ruta del archivo
    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;

    @Column(name = "IM_NOMBRE", nullable = true)
    private String imNombre;

    @Column(name = "LIBRO", nullable = true)
    private String libro;

    //TODO verificar localidad de registro, ya que en modelo de datos hace referencia a CatOficialia

    //TODO municipio registro, verificar relacion con CatOficialia

    //TODO verificar nombre de oficial por relacion con CatOficialia

    @Column(name = "NUMERO_ACTA_MATRIMONIO", nullable = true)
    private String numeroActaMatrimonio;

    @Column(name = "OCUPACION_MADRE_UNO", nullable = true)
    private String ocupacionMadreContrayenteUno;

    @Column(name = "OCUPACION_MADRE_DOS", nullable = true)
    private String ocupacionMadreContrayenteDos;

    @Column(name = "OCUPACION_PADRE_UNO", nullable = true)
    private String ocupacionPadreContrayenteUno;

    @Column(name = "OCUPACION_PADRE_DOS", nullable = false)
    private String ocupacionPadreContrayenteDos;

    @Column(name = "OCUPACION_TEST_UNO", nullable = false)
    private String ocupacionTestigoUno;

    @Column(name =  "OCUPACION_TEST_DOS", nullable = false)
    private String ocupacionTestigoDos;

    @Column(name = "OCUPACION_TEST_TRES", nullable = false)
    private String ocupacionTestigoTres;

    @Column(name = "OCUPACION_TEST_CUATRO", nullable = false)
    private String ocupacionTestigoCuatro;

    @Column(name = "OCUPACION_CONTRAYENTE_UNO", nullable = false)
    private String ocupacionContrayenteUno;

    @Column(name = "OCUPACION _CONTRAYENTE_DOS", nullable = false)
    private String ocupacionContrayenteDos;

    @OneToOne
    @JoinColumn(name = "OFICIALIA", nullable = false)
    private CatOficialia oficialia;

    @Column(name = "SELLO", nullable = true)
    private String sello;

    // Esta propiedad hace referencia a la ruta donde se guarda la imagen
    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;

    @OneToOne
    @JoinColumn(name = "SIT_LAB_UNO", nullable = false)
    private CatSituacionLaboral situacionLaboralContrayenteUno;

    @OneToOne
    @JoinColumn(name = "SIT_LAB_DOS", nullable = false)
    private CatSituacionLaboral situacionLaboralContrayenteDos;

    @OneToOne
    @JoinColumn(name = "TIPO_OPERACION", nullable = false)
    private CatTipoOperacion tipoOperacion;

    @Column(name = "TOMO", nullable = true)
    private String tomo;

    @Column(name = "TRANSCRIPCION", nullable = true)
    private String transcripcion;


    /**
     * Personas que forman parte del acto de matrimonio
     */

    @OneToOne
    @JoinColumn(name = "CONTRAYENTE_UNO", nullable = false)
    private Persona contrayenteUno;

    @OneToOne
    @JoinColumn(name = "CONTRAYENTE_DOS", nullable = false)
    private Persona contrayenteDos;

    @OneToOne
    @JoinColumn(name = "MADRE_UNO", nullable = true)
    private Persona madreContrayenteUno;

    @OneToOne
    @JoinColumn(name = "MADRE_DOS", nullable = true)
    private Persona madreContrayenteDos;

    @OneToOne
    @JoinColumn(name = "PADRE_UNO", nullable = true)
    private Persona padreContrayenteUno;

    @OneToOne
    @JoinColumn(name = "PADRE_DOS", nullable = true)
    private Persona padreContrayenteDos;

    @OneToOne
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;

    @OneToOne
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;

    @OneToOne
    @JoinColumn(name = "TESTIGO_TRES", nullable = true)
    private Persona testigoTres;

    @OneToOne
    @JoinColumn(name = "TESTIGO_CUATRO", nullable = true)
    private Persona testigoCuatro;

    @OneToOne
    @JoinColumn(name = "PARENTESCO_TEST_UNO", nullable = false)
    private CatParentesco parentescoTestigoUno;

    @OneToOne
    @JoinColumn(name = "PARENTESCO_TEST_DOS", nullable = false)
    private CatParentesco parentescoTestigoDos;

    @OneToOne
    @JoinColumn(name = "PARENTESCO_TEST_TRES", nullable = false)
    private CatParentesco parentescoTestigoTres;

    @OneToOne
    @JoinColumn(name = "PARENTESCO_TEST_CUATRO", nullable = false)
    private CatParentesco parentescoTestigoCuatro;

    @OneToOne
    @JoinColumn(name = "POS_TRAB_UNO", nullable = false)
    private CatPuesto posicionTrabajoContrayenteUno;

    @OneToOne
    @JoinColumn(name = "POS_TRAB_DOS", nullable = false)
    private CatPuesto posicionTrabajoContrayenteDos;

    @OneToOne
    @JoinColumn(name = "CONSEN_MENOR", nullable = true)
    private Persona consenMenor;




}
