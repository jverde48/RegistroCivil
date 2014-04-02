package mx.gob.renapo.registrocivil.actos.divorcio.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.Persona;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DIVORCIO")
@Data
@EqualsAndHashCode(callSuper=false)
public class Divorcio extends SequenceGenerator implements Serializable{

	public Divorcio(){
		
	}
	
	/**
     * Propiedades que forman parte de la informacion del acta
     */
	@OneToOne
	@JoinColumn(name="ACTA_MATRIMONIO", nullable = true)
	private Matrimonio actaMatrimonio; 
	
	@Column(name = "CADENA", nullable = true)
    private String cadena;
	
	@Column(name = "LLAVE_ORIGINAL", nullable = true)
    private String llaveOriginal;
	
	@Column(name = "ACTA_BIS", nullable = true)
    private Integer actaBis;
	
	@OneToOne
	@JoinColumn(name = "OFICIALIA", nullable = true)
	private CatOficialia oficialia;
	
	@Column(name = "FECHA_EJECUTORIA", nullable = true)
    private Date fechaEjecutoria;
	
	@Column(name = "FECHA_REGISTRO", nullable = true)
    private Date fechaRegistro;
	
	@Column(name = "FECHA_RESOLUCION", nullable = true)
    private Date fechaResolucion;
	
	 @Column(name = "FOJA", nullable = true)
    private String foja;

    @Column(name = "LIBRO", nullable = true)
    private String libro;

    @Column(name = "TOMO", nullable = true)
    private String tomo;
    
    //TODO verificar generacion de GUID
    
    //Se guarda ruta de archivo
    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;
    
    //TODO se va a registrar o a tomar de oficialia
    @OneToOne
    @JoinColumn(name = "LOCALIDAD_REGISTRO", nullable = true)
    private CatInegiLocalidad localidadRegistro;
    
    // TODO verificar registro de notas marginales
    
    @Column(name = "NUM_ACTA_DIVORCIO", nullable = true)
    private String numActaDivorcio;
    
    @OneToOne
	@JoinColumn(name = "REGIMEN", nullable = true)
	private CatRegimen regimen;
    
    @Column(name = "RESOLUCION_ADMIN", nullable = true)
    private String resolucionAdmin;
    
    @Column(name = "SELLO", nullable = true)
    private String sello;

    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;
    
    @OneToOne
	@JoinColumn(name = "TIPO_DIVORCIO", nullable = true)
	private CatTipoDivorcio tipoDivorcio;
    
    @Column(name = "TRIBUNAL", nullable = true)
    private String tribunal;
    
    @OneToOne
   	@JoinColumn(name = "TIPO_OPERACION", nullable = true)
   	private CatTipoOperacion tipoOperacion;
    
    @OneToOne
   	@JoinColumn(name = "TIPO_DOCUMENTO", nullable = true)
   	private CatTipoDocumento tipoDocumento;
    
    @Column(name = "AUTORIDAD", nullable = true)
    private String autoridad;
    
    /*TODO quitar comentario cuando se agregue el catalogo de causa baja
    @OneToOne
   	@JoinColumn(name = "CAUSA_BAJA", nullable = true)
   	private CatCausaBaja causaBaja;*/
    
    @Column(name = "TIPO_CAPTURA", nullable = true)
    private String tipoCaptura;
    
	/**
     * Propiedades de personas que forman parte del acto de divorcio
     */
	
	@OneToOne
	@JoinColumn(name = "DIVORCIADO_UNO", nullable = true)
	private Persona divorciadoUno;
	    
	@OneToOne
	@JoinColumn(name = "DIVORCIADO_DOS", nullable = true)
	private Persona divorciadoDos;
	
	@OneToOne
	@JoinColumn(name = "ESCOLARIDAD_DIVORCIADO_UNO", nullable = true)
	private CatEscolaridad escolaridadDivorciadoUno;
	    
	@OneToOne
	@JoinColumn(name = "ESCOLARIDAD_DIVORCIADO_DOS", nullable = true)
	private CatEscolaridad escolaridadDivorciadoDos;

	@OneToOne
	@JoinColumn(name = "POS_TRAB_DIVORCIADO_UNO", nullable = true)
	private CatPuesto posTrabDivorciadoUno;
	    
	@OneToOne
	@JoinColumn(name = "POS_TRAB_DIVORCIADO_DOS", nullable = true)
	private CatPuesto posTrabDivorciadoDos;
	
	@OneToOne
	@JoinColumn(name = "SIT_LAB_DIVORCIADO_UNO", nullable = true)
	private CatSituacionLaboral sitLabDivorciadoUno;
	    
	@OneToOne
	@JoinColumn(name = "SIT_LAB_DIVORCIADO_DOS", nullable = true)
	private CatSituacionLaboral sitLabDivorciadoDos;
	
	@OneToOne
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;

    @OneToOne
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;
    
    @OneToOne
    @JoinColumn(name = "PARENTESCO_TESTIGO_UNO", nullable = true)
    private CatParentesco parentescoTestigoUno;

    @OneToOne
    @JoinColumn(name = "PARENTESCO_TESTIGO_DOS", nullable = true)
    private CatParentesco parentescoTestigoDos;
}
