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
public class Defuncion extends SequenceGenerator implements Serializable{

	public Defuncion(){
		
	}

    /**
     * Propiedades que forman parte de la informacion de Personas
     */

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FALLECIDO", nullable = true)
    private Persona fallecido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONYUGE", nullable = true)
    private Persona conyuge;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PADRE_FALLECIDO", nullable = true)
    private Persona padreFallecido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MADRE_FALLECIDO", nullable = true)
    private Persona madreFallecido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DECLARANTE", nullable = true)
    private Persona declarante;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_UNO", nullable = true)
    private Persona testigoUno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "TESTIGO_DOS", nullable = true)
    private Persona testigoDos;


    /**
     * Propiedades que forman parte de la informacion DATOS EXCLUSIVOS DE UN ACTO DE DEFUNCION
     */

    @Column(name = "FECHA_DEFUNCION", nullable = true)
    private Date fechaDefuncion;

    @Column(name = "HORA_DEFUNCION", nullable = true)
    @Temporal(TemporalType.TIME)
    private Date horaDefuncion;

    @Column(name = "NUM_CERT_DEFUNCION", nullable = true)
    private String numCertDefuncion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOM_LUG_FALLECE", nullable = true)
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

    @OneToOne
    @JoinColumn(name = "ENTIDAD_REGISTRO", nullable = true)
    private CatEstado entidadRegistro;

    @OneToOne
    @JoinColumn(name = "MUNICIPIO_REGISTRO", nullable = true)
    private CatMunicipio municipioRegistro;

    @OneToOne
    @JoinColumn(name = "OFICIALIA", nullable = true)
    private CatOficialia oficialia;

    @Column(name = "FECHA_REGISTRO", nullable = true)
    private Date fechaRegistro;

    @Column(name = "NUM_ACTA_DEFUNCION", nullable = true)
    private String numeroActa;

    @Column(name = "ACTA_BIS", nullable = true)
    private Integer actaBis;

    @Column(name = "TOMO", nullable = true)
    private String tomo;

    @Column(name = "LIBRO", nullable = true)
    private String libro;

    @Column(name = "FOJA", nullable = true)
    private String foja;

    @OneToOne
    @JoinColumn(name = "LOCALIDAD_REGISTRO", nullable = true)
    private CatInegiLocalidad localidadRegistro;

    @Column(name = "CADENA", nullable = true)
    private String cadena;

    @Column(name = "LLAVE_ORIGINAL", nullable = true)
    private String llaveOriginal;

    //Faltan Notas Marginales

    @Column(name = "NOMBRE_OFICIAL", nullable = true)
    private String nombreOficial;

    @OneToOne
    @JoinColumn(name = "TIPO_DOCUMENTO", nullable = true)
    private CatTipoDocumento tipoDocumento;

    @Column(name = "TIPO_OPERACION", nullable = true)
    private Integer tipoOperacion;

    @Column(name = "TIPO_CAPTURA", nullable = true)
    private char tipoCaptura;


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
    @JoinColumn(name = "SIT_LAB_FINADO", nullable = true)
    private CatSituacionLaboral sitLabFinado;

    @OneToOne
    @JoinColumn(name = "PUESTO_TRAB_FALLECIDO", nullable = true)
    private CatPuesto puestoTrabFallecido;


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



    //TODO verificar generacion de GUID
    
    //Se guarda ruta de archivo
    @Column(name = "IM_ARCHIVO", nullable = true)
    private String imArchivo;

    @Column(name = "IM_NOMBRE", nullable = true)
    private String imNombre;
    
    @Column(name = "INHUMACION", nullable = true)
    private  Boolean inhumacion;

    @Column(name = "SELLO", nullable = true)
    private String sello;

    @Column(name = "SELLO_IMG", nullable = true)
    private String selloImg;


    //GETTER AND SETTER


    public Persona getFallecido() {
        return fallecido;
    }

    public void setFallecido(Persona fallecido) {
        this.fallecido = fallecido;
    }

    public Persona getConyuge() {
        return conyuge;
    }

    public void setConyuge(Persona conyuge) {
        this.conyuge = conyuge;
    }

    public Persona getPadreFallecido() {
        return padreFallecido;
    }

    public void setPadreFallecido(Persona padreFallecido) {
        this.padreFallecido = padreFallecido;
    }

    public Persona getMadreFallecido() {
        return madreFallecido;
    }

    public void setMadreFallecido(Persona madreFallecido) {
        this.madreFallecido = madreFallecido;
    }

    public Persona getDeclarante() {
        return declarante;
    }

    public void setDeclarante(Persona declarante) {
        this.declarante = declarante;
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

    public Date getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(Date fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public Date getHoraDefuncion() {
        return horaDefuncion;
    }

    public void setHoraDefuncion(Date horaDefuncion) {
        this.horaDefuncion = horaDefuncion;
    }

    public String getNumCertDefuncion() {
        return numCertDefuncion;
    }

    public void setNumCertDefuncion(String numCertDefuncion) {
        this.numCertDefuncion = numCertDefuncion;
    }

    public Domicilio getDomicilioFallecimiento() {
        return domicilioFallecimiento;
    }

    public void setDomicilioFallecimiento(Domicilio domicilioFallecimiento) {
        this.domicilioFallecimiento = domicilioFallecimiento;
    }

    public String getCausaFallece() {
        return causaFallece;
    }

    public void setCausaFallece(String causaFallece) {
        this.causaFallece = causaFallece;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getCedulaMedico() {
        return cedulaMedico;
    }

    public void setCedulaMedico(String cedulaMedico) {
        this.cedulaMedico = cedulaMedico;
    }

    public String getDomicilioMedico() {
        return domicilioMedico;
    }

    public void setDomicilioMedico(String domicilioMedico) {
        this.domicilioMedico = domicilioMedico;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public CatDestinoCadaver getDestinoCadaver() {
        return destinoCadaver;
    }

    public void setDestinoCadaver(CatDestinoCadaver destinoCadaver) {
        this.destinoCadaver = destinoCadaver;
    }

    public String getDomicilioDestinoFinado() {
        return DomicilioDestinoFinado;
    }

    public void setDomicilioDestinoFinado(String domicilioDestinoFinado) {
        DomicilioDestinoFinado = domicilioDestinoFinado;
    }

    public Integer getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(Integer numOrden) {
        this.numOrden = numOrden;
    }

    public CatEstado getEntidadRegistro() {
        return entidadRegistro;
    }

    public void setEntidadRegistro(CatEstado entidadRegistro) {
        this.entidadRegistro = entidadRegistro;
    }

    public CatMunicipio getMunicipioRegistro() {
        return municipioRegistro;
    }

    public void setMunicipioRegistro(CatMunicipio municipioRegistro) {
        this.municipioRegistro = municipioRegistro;
    }

    public CatOficialia getOficialia() {
        return oficialia;
    }

    public void setOficialia(CatOficialia oficialia) {
        this.oficialia = oficialia;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNumeroActa() {
        return numeroActa;
    }

    public void setNumeroActa(String numeroActa) {
        this.numeroActa = numeroActa;
    }

    public Integer getActaBis() {
        return actaBis;
    }

    public void setActaBis(Integer actaBis) {
        this.actaBis = actaBis;
    }

    public String getTomo() {
        return tomo;
    }

    public void setTomo(String tomo) {
        this.tomo = tomo;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getFoja() {
        return foja;
    }

    public void setFoja(String foja) {
        this.foja = foja;
    }

    public CatInegiLocalidad getLocalidadRegistro() {
        return localidadRegistro;
    }

    public void setLocalidadRegistro(CatInegiLocalidad localidadRegistro) {
        this.localidadRegistro = localidadRegistro;
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

    public String getNombreOficial() {
        return nombreOficial;
    }

    public void setNombreOficial(String nombreOficial) {
        this.nombreOficial = nombreOficial;
    }

    public CatTipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(CatTipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Integer tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public char getTipoCaptura() {
        return tipoCaptura;
    }

    public void setTipoCaptura(char tipoCaptura) {
        this.tipoCaptura = tipoCaptura;
    }

    public Boolean getAsistMedica() {
        return asistMedica;
    }

    public void setAsistMedica(Boolean asistMedica) {
        this.asistMedica = asistMedica;
    }

    public CatLugarFallece getLugarFallece() {
        return lugarFallece;
    }

    public void setLugarFallece(CatLugarFallece lugarFallece) {
        this.lugarFallece = lugarFallece;
    }

    public CatEscolaridad getEscolaridadFallecido() {
        return escolaridadFallecido;
    }

    public void setEscolaridadFallecido(CatEscolaridad escolaridadFallecido) {
        this.escolaridadFallecido = escolaridadFallecido;
    }

    public CatSituacionLaboral getSitLabFinado() {
        return sitLabFinado;
    }

    public void setSitLabFinado(CatSituacionLaboral sitLabFinado) {
        this.sitLabFinado = sitLabFinado;
    }

    public CatPuesto getPuestoTrabFallecido() {
        return puestoTrabFallecido;
    }

    public void setPuestoTrabFallecido(CatPuesto puestoTrabFallecido) {
        this.puestoTrabFallecido = puestoTrabFallecido;
    }

    public String getOcupacionDeclarante() {
        return ocupacionDeclarante;
    }

    public void setOcupacionDeclarante(String ocupacionDeclarante) {
        this.ocupacionDeclarante = ocupacionDeclarante;
    }

    public String getOcupacionTestigoUno() {
        return ocupacionTestigoUno;
    }

    public void setOcupacionTestigoUno(String ocupacionTestigoUno) {
        this.ocupacionTestigoUno = ocupacionTestigoUno;
    }

    public String getOcupacionTestigoDOS() {
        return ocupacionTestigoDOS;
    }

    public void setOcupacionTestigoDOS(String ocupacionTestigoDOS) {
        this.ocupacionTestigoDOS = ocupacionTestigoDOS;
    }

    public CatParentesco getParentDeclarante() {
        return parentDeclarante;
    }

    public void setParentDeclarante(CatParentesco parentDeclarante) {
        this.parentDeclarante = parentDeclarante;
    }

    public CatParentesco getParentTestigoUno() {
        return parentTestigoUno;
    }

    public void setParentTestigoUno(CatParentesco parentTestigoUno) {
        this.parentTestigoUno = parentTestigoUno;
    }

    public CatParentesco getParentTestigoDos() {
        return parentTestigoDos;
    }

    public void setParentTestigoDos(CatParentesco parentTestigoDos) {
        this.parentTestigoDos = parentTestigoDos;
    }

    public String getImArchivo() {
        return imArchivo;
    }

    public void setImArchivo(String imArchivo) {
        this.imArchivo = imArchivo;
    }

    public String getImNombre() {
        return imNombre;
    }

    public void setImNombre(String imNombre) {
        this.imNombre = imNombre;
    }

    public Boolean getInhumacion() {
        return inhumacion;
    }

    public void setInhumacion(Boolean inhumacion) {
        this.inhumacion = inhumacion;
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

    //Equals And HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Defuncion)) return false;

        Defuncion defuncion = (Defuncion) o;

        if (tipoCaptura != defuncion.tipoCaptura) return false;
        if (DomicilioDestinoFinado != null ? !DomicilioDestinoFinado.equals(defuncion.DomicilioDestinoFinado) : defuncion.DomicilioDestinoFinado != null)
            return false;
        if (actaBis != null ? !actaBis.equals(defuncion.actaBis) : defuncion.actaBis != null) return false;
        if (asistMedica != null ? !asistMedica.equals(defuncion.asistMedica) : defuncion.asistMedica != null)
            return false;
        if (cadena != null ? !cadena.equals(defuncion.cadena) : defuncion.cadena != null) return false;
        if (causaFallece != null ? !causaFallece.equals(defuncion.causaFallece) : defuncion.causaFallece != null)
            return false;
        if (cedulaMedico != null ? !cedulaMedico.equals(defuncion.cedulaMedico) : defuncion.cedulaMedico != null)
            return false;
        if (conyuge != null ? !conyuge.equals(defuncion.conyuge) : defuncion.conyuge != null) return false;
        if (declarante != null ? !declarante.equals(defuncion.declarante) : defuncion.declarante != null) return false;
        if (destinoCadaver != null ? !destinoCadaver.equals(defuncion.destinoCadaver) : defuncion.destinoCadaver != null)
            return false;
        if (domicilioFallecimiento != null ? !domicilioFallecimiento.equals(defuncion.domicilioFallecimiento) : defuncion.domicilioFallecimiento != null)
            return false;
        if (domicilioMedico != null ? !domicilioMedico.equals(defuncion.domicilioMedico) : defuncion.domicilioMedico != null)
            return false;
        if (entidadRegistro != null ? !entidadRegistro.equals(defuncion.entidadRegistro) : defuncion.entidadRegistro != null)
            return false;
        if (escolaridadFallecido != null ? !escolaridadFallecido.equals(defuncion.escolaridadFallecido) : defuncion.escolaridadFallecido != null)
            return false;
        if (fallecido != null ? !fallecido.equals(defuncion.fallecido) : defuncion.fallecido != null) return false;
        if (fechaDefuncion != null ? !fechaDefuncion.equals(defuncion.fechaDefuncion) : defuncion.fechaDefuncion != null)
            return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(defuncion.fechaRegistro) : defuncion.fechaRegistro != null)
            return false;
        if (foja != null ? !foja.equals(defuncion.foja) : defuncion.foja != null) return false;
        if (horaDefuncion != null ? !horaDefuncion.equals(defuncion.horaDefuncion) : defuncion.horaDefuncion != null)
            return false;
        if (imArchivo != null ? !imArchivo.equals(defuncion.imArchivo) : defuncion.imArchivo != null) return false;
        if (imNombre != null ? !imNombre.equals(defuncion.imNombre) : defuncion.imNombre != null) return false;
        if (inhumacion != null ? !inhumacion.equals(defuncion.inhumacion) : defuncion.inhumacion != null) return false;
        if (libro != null ? !libro.equals(defuncion.libro) : defuncion.libro != null) return false;
        if (llaveOriginal != null ? !llaveOriginal.equals(defuncion.llaveOriginal) : defuncion.llaveOriginal != null)
            return false;
        if (localidadRegistro != null ? !localidadRegistro.equals(defuncion.localidadRegistro) : defuncion.localidadRegistro != null)
            return false;
        if (lugarFallece != null ? !lugarFallece.equals(defuncion.lugarFallece) : defuncion.lugarFallece != null)
            return false;
        if (madreFallecido != null ? !madreFallecido.equals(defuncion.madreFallecido) : defuncion.madreFallecido != null)
            return false;
        if (municipioRegistro != null ? !municipioRegistro.equals(defuncion.municipioRegistro) : defuncion.municipioRegistro != null)
            return false;
        if (nombreDestino != null ? !nombreDestino.equals(defuncion.nombreDestino) : defuncion.nombreDestino != null)
            return false;
        if (nombreMedico != null ? !nombreMedico.equals(defuncion.nombreMedico) : defuncion.nombreMedico != null)
            return false;
        if (nombreOficial != null ? !nombreOficial.equals(defuncion.nombreOficial) : defuncion.nombreOficial != null)
            return false;
        if (numeroActa != null ? !numeroActa.equals(defuncion.numeroActa) : defuncion.numeroActa != null)
            return false;
        if (numCertDefuncion != null ? !numCertDefuncion.equals(defuncion.numCertDefuncion) : defuncion.numCertDefuncion != null)
            return false;
        if (numOrden != null ? !numOrden.equals(defuncion.numOrden) : defuncion.numOrden != null) return false;
        if (ocupacionDeclarante != null ? !ocupacionDeclarante.equals(defuncion.ocupacionDeclarante) : defuncion.ocupacionDeclarante != null)
            return false;
        if (ocupacionTestigoDOS != null ? !ocupacionTestigoDOS.equals(defuncion.ocupacionTestigoDOS) : defuncion.ocupacionTestigoDOS != null)
            return false;
        if (ocupacionTestigoUno != null ? !ocupacionTestigoUno.equals(defuncion.ocupacionTestigoUno) : defuncion.ocupacionTestigoUno != null)
            return false;
        if (oficialia != null ? !oficialia.equals(defuncion.oficialia) : defuncion.oficialia != null) return false;
        if (padreFallecido != null ? !padreFallecido.equals(defuncion.padreFallecido) : defuncion.padreFallecido != null)
            return false;
        if (parentDeclarante != null ? !parentDeclarante.equals(defuncion.parentDeclarante) : defuncion.parentDeclarante != null)
            return false;
        if (parentTestigoDos != null ? !parentTestigoDos.equals(defuncion.parentTestigoDos) : defuncion.parentTestigoDos != null)
            return false;
        if (parentTestigoUno != null ? !parentTestigoUno.equals(defuncion.parentTestigoUno) : defuncion.parentTestigoUno != null)
            return false;
        if (puestoTrabFallecido != null ? !puestoTrabFallecido.equals(defuncion.puestoTrabFallecido) : defuncion.puestoTrabFallecido != null)
            return false;
        if (sello != null ? !sello.equals(defuncion.sello) : defuncion.sello != null) return false;
        if (selloImg != null ? !selloImg.equals(defuncion.selloImg) : defuncion.selloImg != null) return false;
        if (sitLabFinado != null ? !sitLabFinado.equals(defuncion.sitLabFinado) : defuncion.sitLabFinado != null)
            return false;
        if (testigoDos != null ? !testigoDos.equals(defuncion.testigoDos) : defuncion.testigoDos != null) return false;
        if (testigoUno != null ? !testigoUno.equals(defuncion.testigoUno) : defuncion.testigoUno != null) return false;
        if (tipoDocumento != null ? !tipoDocumento.equals(defuncion.tipoDocumento) : defuncion.tipoDocumento != null)
            return false;
        if (tipoOperacion != null ? !tipoOperacion.equals(defuncion.tipoOperacion) : defuncion.tipoOperacion != null)
            return false;
        if (tomo != null ? !tomo.equals(defuncion.tomo) : defuncion.tomo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fallecido != null ? fallecido.hashCode() : 0;
        result = 31 * result + (conyuge != null ? conyuge.hashCode() : 0);
        result = 31 * result + (padreFallecido != null ? padreFallecido.hashCode() : 0);
        result = 31 * result + (madreFallecido != null ? madreFallecido.hashCode() : 0);
        result = 31 * result + (declarante != null ? declarante.hashCode() : 0);
        result = 31 * result + (testigoUno != null ? testigoUno.hashCode() : 0);
        result = 31 * result + (testigoDos != null ? testigoDos.hashCode() : 0);
        result = 31 * result + (fechaDefuncion != null ? fechaDefuncion.hashCode() : 0);
        result = 31 * result + (horaDefuncion != null ? horaDefuncion.hashCode() : 0);
        result = 31 * result + (numCertDefuncion != null ? numCertDefuncion.hashCode() : 0);
        result = 31 * result + (domicilioFallecimiento != null ? domicilioFallecimiento.hashCode() : 0);
        result = 31 * result + (causaFallece != null ? causaFallece.hashCode() : 0);
        result = 31 * result + (nombreMedico != null ? nombreMedico.hashCode() : 0);
        result = 31 * result + (cedulaMedico != null ? cedulaMedico.hashCode() : 0);
        result = 31 * result + (domicilioMedico != null ? domicilioMedico.hashCode() : 0);
        result = 31 * result + (nombreDestino != null ? nombreDestino.hashCode() : 0);
        result = 31 * result + (destinoCadaver != null ? destinoCadaver.hashCode() : 0);
        result = 31 * result + (DomicilioDestinoFinado != null ? DomicilioDestinoFinado.hashCode() : 0);
        result = 31 * result + (numOrden != null ? numOrden.hashCode() : 0);
        result = 31 * result + (entidadRegistro != null ? entidadRegistro.hashCode() : 0);
        result = 31 * result + (municipioRegistro != null ? municipioRegistro.hashCode() : 0);
        result = 31 * result + (oficialia != null ? oficialia.hashCode() : 0);
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + (numeroActa != null ? numeroActa.hashCode() : 0);
        result = 31 * result + (actaBis != null ? actaBis.hashCode() : 0);
        result = 31 * result + (tomo != null ? tomo.hashCode() : 0);
        result = 31 * result + (libro != null ? libro.hashCode() : 0);
        result = 31 * result + (foja != null ? foja.hashCode() : 0);
        result = 31 * result + (localidadRegistro != null ? localidadRegistro.hashCode() : 0);
        result = 31 * result + (cadena != null ? cadena.hashCode() : 0);
        result = 31 * result + (llaveOriginal != null ? llaveOriginal.hashCode() : 0);
        result = 31 * result + (nombreOficial != null ? nombreOficial.hashCode() : 0);
        result = 31 * result + (tipoDocumento != null ? tipoDocumento.hashCode() : 0);
        result = 31 * result + (tipoOperacion != null ? tipoOperacion.hashCode() : 0);
        result = 31 * result + (int) tipoCaptura;
        result = 31 * result + (asistMedica != null ? asistMedica.hashCode() : 0);
        result = 31 * result + (lugarFallece != null ? lugarFallece.hashCode() : 0);
        result = 31 * result + (escolaridadFallecido != null ? escolaridadFallecido.hashCode() : 0);
        result = 31 * result + (sitLabFinado != null ? sitLabFinado.hashCode() : 0);
        result = 31 * result + (puestoTrabFallecido != null ? puestoTrabFallecido.hashCode() : 0);
        result = 31 * result + (ocupacionDeclarante != null ? ocupacionDeclarante.hashCode() : 0);
        result = 31 * result + (ocupacionTestigoUno != null ? ocupacionTestigoUno.hashCode() : 0);
        result = 31 * result + (ocupacionTestigoDOS != null ? ocupacionTestigoDOS.hashCode() : 0);
        result = 31 * result + (parentDeclarante != null ? parentDeclarante.hashCode() : 0);
        result = 31 * result + (parentTestigoUno != null ? parentTestigoUno.hashCode() : 0);
        result = 31 * result + (parentTestigoDos != null ? parentTestigoDos.hashCode() : 0);
        result = 31 * result + (imArchivo != null ? imArchivo.hashCode() : 0);
        result = 31 * result + (imNombre != null ? imNombre.hashCode() : 0);
        result = 31 * result + (inhumacion != null ? inhumacion.hashCode() : 0);
        result = 31 * result + (sello != null ? sello.hashCode() : 0);
        result = 31 * result + (selloImg != null ? selloImg.hashCode() : 0);
        return result;
    }


    //TO STRING

    @Override
    public String toString() {
        return "Defuncion{" +
                "fallecido=" + fallecido +
                ", conyuge=" + conyuge +
                ", padreFallecido=" + padreFallecido +
                ", madreFallecido=" + madreFallecido +
                ", declarante=" + declarante +
                ", testigoUno=" + testigoUno +
                ", testigoDos=" + testigoDos +
                ", fechaDefuncion=" + fechaDefuncion +
                ", horaDefuncion=" + horaDefuncion +
                ", numCertDefuncion='" + numCertDefuncion + '\'' +
                ", domicilioFallecimiento=" + domicilioFallecimiento +
                ", causaFallece='" + causaFallece + '\'' +
                ", nombreMedico='" + nombreMedico + '\'' +
                ", cedulaMedico='" + cedulaMedico + '\'' +
                ", domicilioMedico='" + domicilioMedico + '\'' +
                ", nombreDestino='" + nombreDestino + '\'' +
                ", destinoCadaver=" + destinoCadaver +
                ", DomicilioDestinoFinado='" + DomicilioDestinoFinado + '\'' +
                ", numOrden=" + numOrden +
                ", entidadRegistro=" + entidadRegistro +
                ", municipioRegistro=" + municipioRegistro +
                ", oficialia=" + oficialia +
                ", fechaRegistro=" + fechaRegistro +
                ", numeroActa='" + numeroActa + '\'' +
                ", actaBis=" + actaBis +
                ", tomo='" + tomo + '\'' +
                ", libro='" + libro + '\'' +
                ", foja='" + foja + '\'' +
                ", localidadRegistro=" + localidadRegistro +
                ", cadena='" + cadena + '\'' +
                ", llaveOriginal='" + llaveOriginal + '\'' +
                ", nombreOficial='" + nombreOficial + '\'' +
                ", tipoDocumento=" + tipoDocumento +
                ", tipoOperacion=" + tipoOperacion +
                ", tipoCaptura=" + tipoCaptura +
                ", asistMedica=" + asistMedica +
                ", lugarFallece=" + lugarFallece +
                ", escolaridadFallecido=" + escolaridadFallecido +
                ", sitLabFinado=" + sitLabFinado +
                ", puestoTrabFallecido=" + puestoTrabFallecido +
                ", ocupacionDeclarante='" + ocupacionDeclarante + '\'' +
                ", ocupacionTestigoUno='" + ocupacionTestigoUno + '\'' +
                ", ocupacionTestigoDOS='" + ocupacionTestigoDOS + '\'' +
                ", parentDeclarante=" + parentDeclarante +
                ", parentTestigoUno=" + parentTestigoUno +
                ", parentTestigoDos=" + parentTestigoDos +
                ", imArchivo='" + imArchivo + '\'' +
                ", imNombre='" + imNombre + '\'' +
                ", inhumacion=" + inhumacion +
                ", sello='" + sello + '\'' +
                ", selloImg='" + selloImg + '\'' +
                '}';
    }
}
