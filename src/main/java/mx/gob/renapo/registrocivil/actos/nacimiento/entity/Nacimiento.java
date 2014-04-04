package mx.gob.renapo.registrocivil.actos.nacimiento.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.Persona;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/3/14
 * Time: 5:38 PM
 * Clase que representa a la entidad de Nacimiento
 */
@Entity
@Table(name = "NACIMIENTO")
@Data
@EqualsAndHashCode(callSuper=false)
public class Nacimiento extends SequenceGenerator implements Serializable{

    public Nacimiento() {

    }

    /**
     * Propiedades que forman parte de la informacion del acta
     */
    @Column(name = "ACTA_BIS", nullable = true)
    private Integer actaBis;

    @Column(name = "CADENA", nullable = true)
    private String cadena;

    @Column(name = "CAMBIO_APELLIDO", nullable = true)
    private  Boolean cambioApellido;

    @OneToOne
    @JoinColumn(name = "COMPARECE", nullable = true)
    private CatComparece comparece;

    @Column(name = "CRIP")
    private String crip;

    @OneToOne
    @JoinColumn(name = "ESCOLARIDAD_MADRE", nullable = true)
    private CatEscolaridad escolaridadMadre;

    @OneToOne
    @JoinColumn(name = "ESCOLARIDAD_PADRE", nullable = true)
    private CatEscolaridad escolaridadPadre;

    @Column(name = "FECHA_REGISTRO", nullable = true)
    private Date fechaRegistro;

    @Column(name = "FOJA", nullable = true)
    private String foja;

    @Column(name = "LIBRO", nullable = true)
    private String libro;

    @Column(name = "TOMO", nullable = true)
    private String tomo;

    @Column(name = "HORA_NAC_REGISTRADO", nullable = true)
    @Temporal(TemporalType.TIME)
    private Date horaNacRegistrado;

    //TODO verificar generacion de GUID

    //Se guarda ruta de archivo
    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;


    @OneToOne
    @JoinColumn(name = "LOCALIDAD_REGISTRO", nullable = true)
    private CatInegiLocalidad localidadRegistro;

    @OneToOne
    @JoinColumn(name = "LUGAR_ATENCION_PARTO", nullable = true)
    private CatLugarParto lugarAtencionParto;

    @OneToOne
    @JoinColumn(name = "ATENDIO_PARTO", nullable = true)
    private CatAtendioParto atendioParto;

    @Column(name = "NACIERON_VIVOS", nullable = true)
    private Integer nacieronVivos;

    @Column(name = "NOMBRE_OFICIAL", nullable = true)
    private String nombreOficial;

    @Column(name = "NUM_ACTA_NACIMIENTO", nullable = true)
    private Integer numActaNacimiento;

    @Column(name = "NUM_PARTO", nullable = true)
    private Integer numParto;

    @OneToOne
    @JoinColumn(name = "OFICIALIA", nullable = true)
    private CatOficialia oficialia;


    /**
     * Propiedades de personas que forman parte del acto de nacimiento
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "REGISTRADO", nullable = true)
    private Persona registrado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PADRE", nullable = true)
    private Persona padre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MADRE", nullable = true)
    private Persona madre;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ABUELA_MATERNA", nullable = true)
    private Persona abuelaMaterna;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ABUELA_PATERNA", nullable = true)
    private Persona abuelaPaterna;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ABUELO_MATERNO", nullable = true)
    private Persona abueloMaterno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ABUELO_PATERNO", nullable = true)
    private Persona abueloPaterno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSONA_DISTINTA_COMPARECE", nullable = true)
    private Persona personaDistintaComparece;

    @OneToOne
    @JoinColumn(name = "PARENT_PERSONA_DISTINTA_PRESENTA", nullable = true)
    private CatParentesco parentPersonaDistintaPresenta;

    @OneToOne
    @JoinColumn(name = "POSICION_TRABAJO_MADRE", nullable = true)
    private CatPuesto posicionTrabajoMadre;

    @OneToOne
    @JoinColumn(name = "POSICION_TRABAJO_PADRE", nullable = true)
    private CatPuesto posicionTrabajoPadre;

    @Column(name = "REGISTRA_VIVO_MUERTO")
    private char vivoMuerto;

    @Column(name = "SELLO", nullable = true)
    private String sello;

    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;

    @OneToOne
    @JoinColumn(name = "SIT_LAB_MADRE", nullable = true)
    private CatSituacionLaboral situacionLaboralMadre;

    @OneToOne
    @JoinColumn(name = "SIT_LAB_PADRE", nullable = true)
    private CatSituacionLaboral situacionLaboralpadre;

    @OneToOne
    @JoinColumn(name = "TIPO_DOCUMENTO", nullable = true)
    private CatTipoDocumento tipoDocumento;

    @OneToOne
    @JoinColumn(name = "TIPO_OPERACION", nullable = true)
    private CatTipoOperacion tipoOperacion;

    @OneToOne
    @JoinColumn(name = "TIPO_PARTO", nullable = true)
    private CatTipoParto tipoParto;

    @Column(name = "TRANSCRIPCION", nullable = true)
    private String transcripcion;

    @Column(name = "VACUNADO", nullable = true)
    private Boolean vacunado;

    //TODO verificar informacion de vive con  (se va a hacer referencia a paretesco)

    @Column(name = "VIVEN", nullable = true)
    private Integer viven;

}
