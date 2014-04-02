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

    public Matrimonio() {

    }

    /**
     * Propiedades que forman parte de la informacion misma del acta de matrimonio
     */

     @Column(name = "ACTA_BIS", nullable = true)
    private String actaBis;

    @Column(name = "AUTORIZACION_DGRC", nullable = true)
    private String autorizacionDgrc;

    @Column(name = "CADENA", nullable = true)
    private String cadena;

    @Column(name = "CRIP_UNO", nullable = true)
    private String cripUno;

    @Column(name = "CRIP_DOS", nullable = true)
    private String cripDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ESCOLARIDAD_UNO", nullable = true)
    private CatEscolaridad escolaridadContrayenteUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ESCOLARIDAD_DOS", nullable = true)
    private CatEscolaridad escolaridadContrayenteDos;

    @Column(name = "FECHA_REGISTRO", nullable = true)
    private Date fechaRegistro;

    @Column(name = "FOJA", nullable = true)
    private String foja;

    //TODO verificar generacion de GUID

    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;

    @Column(name = "IM_NOMBRE", nullable = true)
    private String imNombre;

    @Column(name = "LIBRO", nullable = true)
    private String libro;

    @Column(name = "NUMERO_ACTA_MATRIMONIO", nullable = true)
    private String numeroActaMatrimonio;

    @Column(name = "OCUPACION_MADRE_UNO", nullable = true)
    private String ocupacionMadreContrayenteUno;

    @Column(name = "OCUPACION_MADRE_DOS", nullable = true)
    private String ocupacionMadreContrayenteDos;

    @Column(name = "OCUPACION_PADRE_UNO", nullable = true)
    private String ocupacionPadreContrayenteUno;

    @Column(name = "OCUPACION_PADRE_DOS", nullable = true)
    private String ocupacionPadreContrayenteDos;

    @Column(name = "OCUPACION_TEST_UNO", nullable = true)
    private String ocupacionTestigoUno;

    @Column(name =  "OCUPACION_TEST_DOS", nullable = true)
    private String ocupacionTestigoDos;

    @Column(name = "OCUPACION_TEST_TRES", nullable = true)
    private String ocupacionTestigoTres;

    @Column(name = "OCUPACION_TEST_CUATRO", nullable = true)
    private String ocupacionTestigoCuatro;

    @Column(name = "OCUPACION_CONTRAYENTE_UNO", nullable = true)
    private String ocupacionContrayenteUno;

    @Column(name = "OCUPACION_CONTRAYENTE_DOS", nullable = true)
    private String ocupacionContrayenteDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OFICIALIA", nullable = true)
    private CatOficialia oficialia;

    @Column(name = "SELLO", nullable = true)
    private String sello;

    // Esta propiedad hace referencia a la ruta donde se guarda la imagen
    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SIT_LAB_UNO", nullable = true)
    private CatSituacionLaboral situacionLaboralContrayenteUno;

    @OneToOne
    @JoinColumn(name = "SIT_LAB_DOS", nullable = true)
    private CatSituacionLaboral situacionLaboralContrayenteDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TIPO_OPERACION", nullable = true)
    private CatTipoOperacion tipoOperacion;

    @Column(name = "TOMO", nullable = true)
    private String tomo;

    @Column(name = "TRANSCRIPCION", nullable = true)
    private String transcripcion;


    /**
     * Personas que forman parte del acto de matrimonio
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTRAYENTE_UNO", nullable = true)
    private Persona contrayenteUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTRAYENTE_DOS", nullable = true)
    private Persona contrayenteDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MADRE_UNO", nullable = true)
    private Persona madreContrayenteUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MADRE_DOS", nullable = true)
    private Persona madreContrayenteDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PADRE_UNO", nullable = true)
    private Persona padreContrayenteUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PADRE_DOS", nullable = true)
    private Persona padreContrayenteDos;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARENTESCO_TEST_UNO", nullable = true)
    private CatParentesco parentescoTestigoUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARENTESCO_TEST_DOS", nullable = true)
    private CatParentesco parentescoTestigoDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARENTESCO_TEST_TRES", nullable = true)
    private CatParentesco parentescoTestigoTres;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PARENTESCO_TEST_CUATRO", nullable = true)
    private CatParentesco parentescoTestigoCuatro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "POS_TRAB_UNO", nullable = true)
    private CatPuesto posicionTrabajoContrayenteUno;

    @OneToOne
    @JoinColumn(name = "POS_TRAB_DOS", nullable = true)
    private CatPuesto posicionTrabajoContrayenteDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONSEN_MENOR_CONTRAYENTE_UNO", nullable = true)
    private Persona consenMenorContrayenteUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONSEN_MENOR_CONTRAYENTE_DOS", nullable = true)
    private Persona consenMenorContrayenteDos;

    @Column(name = "TIPO_CAPTURA", nullable = true)
    private char tipoCaptura;

    @Column(name = "ID_CAUSA_BAJA", nullable = true)
    private char idCausaBaja;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "REGIMEN", nullable = true)
    private CatRegimen regimen;


}
