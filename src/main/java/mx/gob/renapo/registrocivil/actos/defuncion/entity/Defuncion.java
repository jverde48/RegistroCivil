package mx.gob.renapo.registrocivil.actos.defuncion.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.Domicilio;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.Persona;
import mx.gob.renapo.registrocivil.actos.nacimiento.entity.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DEFUNCION")
@Data
@EqualsAndHashCode(callSuper=false)
public class Defuncion extends SequenceGenerator implements Serializable{

	public Defuncion(){
		
	}

    /**
     * Propiedades que forman parte de la informacion de Personas
     */

    @OneToOne
    @JoinColumn(name = "FALLECIDO", nullable = false)
    private Persona fallecido;

    @OneToOne
    @JoinColumn(name = "CONYUGE", nullable = true)
    private Persona conyuge;

    @OneToOne
    @JoinColumn(name = "PADRE_FALLECIDO", nullable = true)
    private Persona padreFallecido;

    @OneToOne
    @JoinColumn(name = "MADRE_FALLECIDO", nullable = true)
    private Persona madreFallecido;

    @OneToOne
    @JoinColumn(name = "DECLARANTE", nullable = false)
    private Persona declarante;

    @OneToOne
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;

    @OneToOne
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;


    /**
     * Propiedades que forman parte de la informacion DATOS EXCLUSIVOS DE UN ACTO DE DEFUNCIÓN
     */

    @Column(name = "FECHA_DEFUNCION", nullable = true)
    private Date fechaDefuncion;

    @Column(name = "HORA_DEFUNCION", nullable = true)
    @Temporal(TemporalType.TIME)
    private Date horaDefuncion;

    @Column(name = "NUM_CERT_DEFUNCION", nullable = true)
    private String numCertDefuncion;

    @OneToOne
    private Domicilio domicilioFallecimiento;

    @Column(name = "CAUSA_FALLECE", nullable = true)
    private String causaFallece;

    @Column(name = "NOMBRE_MEDICO", nullable = true)
    private String nombreMedico;

    @Column(name = "CEDULA_MEDICO", nullable = true)
    private String cedulaMedico;

    @Column(name = "DOMICILIO_MEDICO", nullable = true)
    private String domicilioMedico;

    @Column(name = "NOMBRE_DESTINO", nullable = true)
    private String nombreDestino;

    @OneToOne
    @JoinColumn(name = "DESTINO_CADAVER", nullable = true)
    private CatDestinoCadaver destinoCadaver;

    @Column(name = "DOMICILIO_DESTINO_FINADO", nullable = true)
    private String DomicilioDestinoFinado;

    @Column(name = "NUM_ORDEN", nullable = true)
    private Integer numOrden;

	/**
     * Propiedades que forman parte de la informacion del ACTA
     */

    //Falta Entidad Registro

    //Municipio Registro

    @OneToOne
    @JoinColumn(name = "OFICIALIA", nullable = true)
    private CatOficialia oficialia;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    private Date fechaRegistro;

    @Column(name = "NUM_ACTA_DEFUNCION", nullable = true)
    private String numActaDefuncion;

    @Column(name = "ACTA_BIS", nullable = true)
    private Integer actaBis;

    @Column(name = "TOMO", nullable = true)
    private String tomo;

    @Column(name = "LIBRO", nullable = true)
    private String libro;

    @Column(name = "FOJA", nullable = true)
    private String foja;

    @OneToOne
    @JoinColumn(name = "LOCALIDAD_REGISTRO", nullable = false)
    private CatInegiLocalidad localidadRegistro;

    @Column(name = "CADENA", nullable = false)
    private String cadena;

    @Column(name = "CRIP_FALLECIDO", nullable = true)
    private String cripFallecido;

    @Column(name = "A&Ntilde;O_REGISTRO")
    private String anoRegistro;

    @Column(name = "LLAVE_ORIGINAL", nullable = true)
    private String llaveOriginal;

    //Faltan Notas Marginales

    @OneToOne
    @JoinColumn(name = "TIPO_DOCUMENTO", nullable = false)
    private CatTipoDocumento tipoDocumento;

    @OneToOne
    @JoinColumn(name = "TIPO_OPERACION", nullable = true)
    private CatTipoOperacion tipoOperacion;


    /**
     * Propiedades que forman parte de la informacion de DATOS ESTADISTICOS DEFUNCION
     */

    @Column(name = "ASIST_MEDICA", nullable = true)
    private  Boolean asistMedica;

    @OneToOne
    @JoinColumn(name = "LUGAR_FALLECE", nullable = true)
    private CatLugarFallece lugarFallece;

    @OneToOne
    @JoinColumn(name = "ESCOLARIDAD_FALLECIDO", nullable = true)
    private CatEscolaridad escolaridadFallecido;

    @OneToOne
    @JoinColumn(name = "ESCOLARIDAD_JEFE_HOGAR", nullable = true)
    private CatEscolaridad escolaridadJefeHogar;

    @OneToOne
    @JoinColumn(name = "SIT_LAB_FINADO", nullable = true)
    private CatSituacionLaboral sitLabFinado;


    /**
     * Propiedades que forman parte de la informacion de CATALOGOS PERSONA
     */

    @Column(name = "OCUPACION_DECLARANTE", nullable = true)
    private String ocupacionDeclarante;

    @Column(name = "OCUPACION_TESTIGO_UNO", nullable = true)
    private String ocupacionTestigoUno;

    @Column(name = "OCUPACION_TESTIGO_DOS", nullable = true)
    private String ocupacionTestigoDOS;

    @OneToOne
    @JoinColumn(name = "PARENT_DECLARANTE", nullable = true)
    private CatParentesco parentDeclarante;

    @OneToOne
    @JoinColumn(name = "PARENT_TESTIGO_UNO", nullable = true)
    private CatParentesco parentTestigoUno;

    @OneToOne
    @JoinColumn(name = "PARENT_TESTIGO_DOS", nullable = true)
    private CatParentesco parentTestigoDos;

    @OneToOne
    @JoinColumn(name = "PUESTO_TRAB_JEFE_HOGAR", nullable = true)
    private CatPuesto puestoTrabJefeHogar;


    //TODO verificar generacion de GUID
    
  //Se guarda ruta de archivo
    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;
    
    @Column(name = "INHUMACION", nullable = true)
    private  Boolean inhumacion;

    @Column(name = "SELLO", nullable = true)
    private String sello;

    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;


}
