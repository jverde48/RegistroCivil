package mx.gob.renapo.registrocivil.actos.nacimiento.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.common.entity.SequenceGenerator;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.common.entity.Persona;
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

    /**
     * Propiedades que forman parte de la informacion del acta
     */
    @Column(name = "ACTA_BIS", nullable = true)
    private Integer actaBis;

    //TODO verificar creacion de CADENA, verificar si es relacion a una tabla CADENA o no

    @Column(name = "CAMBIO_APELLIDO", nullable = false)
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

    @OneToOne
    @JoinColumn(name = "ESTADO_REGISTRO", nullable = false)
    private CatEstado estadoRegistro;

    @Column(name = "FECHA_REGISTRO", nullable = false)
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

    //TODO verificar guardado de archivos: im_archivo
    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;

    @Column(name = "IM_NOMBRE", nullable = true)
    private String imNombre;

    @OneToOne
    @JoinColumn(name = "LOCALIDAD_REGISTRO", nullable = false)
    private CatInegiLocalidad localidadRegistro;

    @OneToOne
    @JoinColumn(name = "LUGAR_ATENCION_PARTO", nullable = false)
    private CatLugarParto lugarAtencionParto;

    @OneToOne
    @JoinColumn(name = "ATENDIO_PARTO", nullable = false)
    private CatAtendioParto atendioParto;

    @OneToOne
    @JoinColumn(name = "MUNICIPIO_REGISTRO", nullable = false)
    private CatMunicipio municipioRegistro;

    @Column(name = "NACIERON_VIVOS", nullable = true)
    private Integer nacieronVivos;

    //TODO verificar relacion de nombre de oficialia

    @Column(name = "NUM_ACTA_NACIMIENTO", nullable = false)
    private Integer numActaNacimiento;

    @Column(name = "NUM_PARTO", nullable = true)
    private Integer numParto;

    @OneToOne
    @JoinColumn(name = "OFICIALIA", nullable = false)
    private CatOficialia oficialia;


    /**
     * Propiedades de personas que forman parte del acto de nacimiento
     */
    @OneToOne
    @JoinColumn(name = "REGISTRADO", nullable = false)
    private Persona registrado;

    @OneToOne
    @JoinColumn(name = "PADRE", nullable = true)
    private Persona padre;

    @OneToOne
    @JoinColumn(name = "MADRE", nullable = true)
    private Persona madre;

    @OneToOne
    @JoinColumn(name = "ABUELA_MATERNA", nullable = true)
    private Persona abuelaMaterna;

    @OneToOne
    @JoinColumn(name = "ABUELA_PATERNA", nullable = true)
    private Persona abuelaPaterna;

    @OneToOne
    @JoinColumn(name = "ABUELO_MATERNO", nullable = true)
    private Persona abueloMaterno;

    @OneToOne
    @JoinColumn(name = "ABUELO_PATERNO", nullable = true)
    private Persona abueloPaterno;

    @OneToOne
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;

    @OneToOne
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;

    @OneToOne
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

    //TODO verificar si va a existir catalogo de vivo o muerto

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
    @JoinColumn(name = "TIPO_DOCUMENTO", nullable = false)
    private CatTipoDocumento tipoDocumento;

    @OneToOne
    @JoinColumn(name = "TIPO_OPERACION", nullable = false)
    private CatTipoOperacion tipoOperacion;

    @OneToOne
    @JoinColumn(name = "TIPO_PARTO", nullable = true)
    private CatTipoParto tipoParto;

    @Column(name = "TRANSCRIPCION", nullable = true)
    private String transcripcion;

    @Column(name = "VACUNADO", nullable = true)
    private Boolean vacunado;

    //TODO verificar informacion de vive con

    @Column(name = "VIVEN", nullable = true)
    private Integer viven;


}
