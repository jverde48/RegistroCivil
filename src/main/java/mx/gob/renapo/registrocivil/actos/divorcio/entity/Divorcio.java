package mx.gob.renapo.registrocivil.actos.divorcio.entity;

import mx.gob.renapo.registrocivil.actos.matrimonio.entity.Matrimonio;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;
import mx.gob.renapo.registrocivil.catalogos.entity.*;
import mx.gob.renapo.registrocivil.comun.entity.Persona;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DIVORCIO")

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
	/*
	@OneToOne
	@JoinColumn(name = "OFICIALIA", nullable = true)
	private CatOficialia oficialia;
	*/
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
    
    /*
    @OneToOne
   	@JoinColumn(name = "ID_CAUSA_BAJA", nullable = true)
   	private char idCausaBaja;*/
    
    @Column(name = "TIPO_CAPTURA", nullable = true)
    private char tipoCaptura;
    
	/**
     * Propiedades de personas que forman parte del acto de divorcio
     */
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DIVORCIADO_UNO", nullable = true)
	private Persona divorciadoUno;
	    
	@OneToOne(cascade = CascadeType.ALL)
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
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;
    
    @OneToOne
    @JoinColumn(name = "PARENTESCO_TESTIGO_UNO", nullable = true)
    private CatParentesco parentescoTestigoUno;

    @OneToOne
    @JoinColumn(name = "PARENTESCO_TESTIGO_DOS", nullable = true)
    private CatParentesco parentescoTestigoDos;

    //Getters y Setters
	public Matrimonio getActaMatrimonio() {
		return actaMatrimonio;
	}

	public void setActaMatrimonio(Matrimonio actaMatrimonio) {
		this.actaMatrimonio = actaMatrimonio;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getLlaveOriginal() {
		return llaveOriginal;
	}

	public void setLlaveOriginal(String llaveOriginal) {
		this.llaveOriginal = llaveOriginal;
	}

	public Integer getActaBis() {
		return actaBis;
	}

	public void setActaBis(Integer actaBis) {
		this.actaBis = actaBis;
	}

	public Date getFechaEjecutoria() {
		return fechaEjecutoria;
	}

	public void setFechaEjecutoria(Date fechaEjecutoria) {
		this.fechaEjecutoria = fechaEjecutoria;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	public String getFoja() {
		return foja;
	}

	public void setFoja(String foja) {
		this.foja = foja;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public String getTomo() {
		return tomo;
	}

	public void setTomo(String tomo) {
		this.tomo = tomo;
	}

	public String getImArchivo() {
		return imArchivo;
	}

	public void setImArchivo(String imArchivo) {
		this.imArchivo = imArchivo;
	}

	public String getNumActaDivorcio() {
		return numActaDivorcio;
	}

	public void setNumActaDivorcio(String numActaDivorcio) {
		this.numActaDivorcio = numActaDivorcio;
	}

	public CatRegimen getRegimen() {
		return regimen;
	}

	public void setRegimen(CatRegimen regimen) {
		this.regimen = regimen;
	}

	public String getResolucionAdmin() {
		return resolucionAdmin;
	}

	public void setResolucionAdmin(String resolucionAdmin) {
		this.resolucionAdmin = resolucionAdmin;
	}

	public String getSello() {
		return sello;
	}

	public void setSello(String sello) {
		this.sello = sello;
	}

	public String getSelloImg() {
		return selloImg;
	}

	public void setSelloImg(String selloImg) {
		this.selloImg = selloImg;
	}

	public CatTipoDivorcio getTipoDivorcio() {
		return tipoDivorcio;
	}

	public void setTipoDivorcio(CatTipoDivorcio tipoDivorcio) {
		this.tipoDivorcio = tipoDivorcio;
	}

	public String getTribunal() {
		return tribunal;
	}

	public void setTribunal(String tribunal) {
		this.tribunal = tribunal;
	}

	public CatTipoOperacion getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(CatTipoOperacion tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public CatTipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(CatTipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getAutoridad() {
		return autoridad;
	}

	public void setAutoridad(String autoridad) {
		this.autoridad = autoridad;
	}

	public char getTipoCaptura() {
		return tipoCaptura;
	}

	public void setTipoCaptura(char tipoCaptura) {
		this.tipoCaptura = tipoCaptura;
	}

	public Persona getDivorciadoUno() {
		return divorciadoUno;
	}

	public void setDivorciadoUno(Persona divorciadoUno) {
		this.divorciadoUno = divorciadoUno;
	}

	public Persona getDivorciadoDos() {
		return divorciadoDos;
	}

	public void setDivorciadoDos(Persona divorciadoDos) {
		this.divorciadoDos = divorciadoDos;
	}

	public CatEscolaridad getEscolaridadDivorciadoUno() {
		return escolaridadDivorciadoUno;
	}

	public void setEscolaridadDivorciadoUno(CatEscolaridad escolaridadDivorciadoUno) {
		this.escolaridadDivorciadoUno = escolaridadDivorciadoUno;
	}

	public CatEscolaridad getEscolaridadDivorciadoDos() {
		return escolaridadDivorciadoDos;
	}

	public void setEscolaridadDivorciadoDos(CatEscolaridad escolaridadDivorciadoDos) {
		this.escolaridadDivorciadoDos = escolaridadDivorciadoDos;
	}

	public CatPuesto getPosTrabDivorciadoUno() {
		return posTrabDivorciadoUno;
	}

	public void setPosTrabDivorciadoUno(CatPuesto posTrabDivorciadoUno) {
		this.posTrabDivorciadoUno = posTrabDivorciadoUno;
	}

	public CatPuesto getPosTrabDivorciadoDos() {
		return posTrabDivorciadoDos;
	}

	public void setPosTrabDivorciadoDos(CatPuesto posTrabDivorciadoDos) {
		this.posTrabDivorciadoDos = posTrabDivorciadoDos;
	}

	public CatSituacionLaboral getSitLabDivorciadoUno() {
		return sitLabDivorciadoUno;
	}

	public void setSitLabDivorciadoUno(CatSituacionLaboral sitLabDivorciadoUno) {
		this.sitLabDivorciadoUno = sitLabDivorciadoUno;
	}

	public CatSituacionLaboral getSitLabDivorciadoDos() {
		return sitLabDivorciadoDos;
	}

	public void setSitLabDivorciadoDos(CatSituacionLaboral sitLabDivorciadoDos) {
		this.sitLabDivorciadoDos = sitLabDivorciadoDos;
	}

	public Persona getTestigoUno() {
		return testigoUno;
	}

	public void setTestigoUno(Persona testigoUno) {
		this.testigoUno = testigoUno;
	}

	public Persona getTestigoDos() {
		return testigoDos;
	}

	public void setTestigoDos(Persona testigoDos) {
		this.testigoDos = testigoDos;
	}

	public CatParentesco getParentescoTestigoUno() {
		return parentescoTestigoUno;
	}

	public void setParentescoTestigoUno(CatParentesco parentescoTestigoUno) {
		this.parentescoTestigoUno = parentescoTestigoUno;
	}

	public CatParentesco getParentescoTestigoDos() {
		return parentescoTestigoDos;
	}

	public void setParentescoTestigoDos(CatParentesco parentescoTestigoDos) {
		this.parentescoTestigoDos = parentescoTestigoDos;
	}

	@Override
	public String toString() {
		return "Divorcio [cadena=" + cadena + ", numActaDivorcio="
				+ numActaDivorcio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cadena == null) ? 0 : cadena.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Divorcio other = (Divorcio) obj;
		if (cadena == null) {
			if (other.cadena != null)
				return false;
		} else if (!cadena.equals(other.cadena))
			return false;
		return true;
	}
	
	
}
