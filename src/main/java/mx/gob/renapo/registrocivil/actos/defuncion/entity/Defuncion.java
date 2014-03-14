package mx.gob.renapo.registrocivil.actos.defuncion.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
     * Propiedades que forman parte de la informacion del acta
     */
	
	@Column(name = "ACTA_BIS", nullable = true)
    private Integer actaBis;
	
	@Column(name = "ASIST_MEDICA", nullable = true)
    private  Boolean asistMedica;
	
    @Column(name = "CADENA", nullable = false)
    private String cadena;
    
    @Column(name = "CAUSA_FALLECE", nullable = true)
    private String causaFallece;
    
    @Column(name = "COD_POST_FALLECIMIENTO", nullable = true)
    private String codPostFallecimiento;
    
    @OneToOne
    @JoinColumn(name = "COLONIA_FALLECIMIENTO", nullable = true)
    private CatInegiLocalidad coloniaFallecimiento;
    
    @OneToOne
    @JoinColumn(name = "DESTINO_CADAVER", nullable = true)
    private CatDestinoCadaver destinoCadaver;
    
    @OneToOne
    @JoinColumn(name = "OFICIALIA", nullable = true)
    private CatOficialia oficialia;
    
    @Column(name = "FECHA_REGISTRO", nullable = false)
    private Date fechaRegistro;
    
    @Column(name = "FECHA_DEFUNCION", nullable = true)
    private Date fechaDefuncion;
    
    @Column(name = "FOJA", nullable = true)
    private String foja;

    @Column(name = "LIBRO", nullable = true)
    private String libro;

    @Column(name = "TOMO", nullable = true)
    private String tomo;
    
    @Column(name = "HORA_DEFUNCION", nullable = true)
    @Temporal(TemporalType.TIME)
    private Date horaDefuncion;
    
  //TODO verificar generacion de GUID
    
  //Se guarda ruta de archivo
    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;
    
    @Column(name = "INHUMACION", nullable = true)
    private  Boolean inhumacion;
    
    @OneToOne
    @JoinColumn(name = "MUNICIPIO_FALLECIMIENTO", nullable = true)
    private CatMunicipio municipioFallece;
    
    @Column(name = "NOMBRE_DESTINO", nullable = true)
    private String nombreDestino;
   
    @Column(name = "NUM_ACTA_DEFUNCION", nullable = true)
    private String numActaDefuncion;
    
    @Column(name = "NUM_CERT_DEFUNCION", nullable = true)
    private String numCertDefuncion;
    
    @Column(name = "NUM_ORDEN", nullable = true)
    private Integer numOrden;
    
    @OneToOne
    @JoinColumn(name = "TIPO_OPERACION", nullable = true)
    private Persona tipoOperacion;
    
    @Column(name = "TRANSCRIPCION", nullable = true)
    private String transcripcion;
    
    @Column(name = "UBICA_DESTINO", nullable = true)
    private String ubicaDestino;
    
    /**
     * Propiedades de personas que forman parte del acto de nacimiento
     */
    @OneToOne
    @JoinColumn(name = "CONYUGE", nullable = true)
    private Persona conyuge;
    
    @Column(name = "CALLE_MEDICO", nullable = true)
    private String calleMedico;
    
    @Column(name = "CEDULA_MEDICO", nullable = true)
    private String cedulaMedico;
    
    @Column(name = "COD_POST_MEDICO", nullable = true)
    private String codPostMedico;
    
    @OneToOne
    @JoinColumn(name = "COLONIA_DOMI_MEDICO", nullable = true)
    private CatInegiLocalidad coloniaMedico;
    
    @Column(name = "CRIP_FALLECIDO", nullable = true)
    private String cripFallecido;
    
    @OneToOne
    @JoinColumn(name = "DECLARANTE", nullable = false)
    private Persona declarante;
    
    @OneToOne
    @JoinColumn(name = "ESCOLARIDAD_FALLECIDO", nullable = true)
    private CatEscolaridad escolaridadFallecido;
    
    @OneToOne
    @JoinColumn(name = "ESCOLARIDAD_JEFE_HOGAR", nullable = true)
    private CatEscolaridad escolaridadJefeHogar;
    
    @OneToOne
    @JoinColumn(name = "FALLECIDO", nullable = false)
    private Persona fallecido;
    
    @OneToOne
    @JoinColumn(name = "MADRE_FALLECIDO", nullable = true)
    private Persona madreFallecido;
    
    @OneToOne
    @JoinColumn(name = "MUNICIPIO_DOMI_MEDICO", nullable = true)
    private CatEstado municipioMedico;
    
    @Column(name = "NOMBRE_MEDICO", nullable = true)
    private String nombreMedico;
    
    @Column(name = "NUM_DOMI_MEDICO", nullable = true)
    private String numDomiMedico;
    
    @Column(name = "OCUPACION_DECLARANTE", nullable = true)
    private String ocupacionDeclarante;
    
    @Column(name = "OCUPACION_TESTIGO_UNO", nullable = true)
    private String ocupacionTestigoUno;
    
    @Column(name = "OCUPACION_TESTIGO_DOS", nullable = true)
    private String ocupacionTestigoDOS;
    
    @OneToOne
    @JoinColumn(name = "PADRE_FALLECIDO", nullable = true)
    private Persona padreFallecido;
    
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
    
    @Column(name = "SELLO", nullable = true)
    private String sello;

    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;
    
    @OneToOne
    @JoinColumn(name = "SIT_LAB_FINADO", nullable = true)
    private CatPuesto sitLabFinado;
    
    @OneToOne
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;
    
    @OneToOne
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;
}
