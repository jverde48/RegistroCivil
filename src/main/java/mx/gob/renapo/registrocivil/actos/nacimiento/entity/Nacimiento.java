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

    @Column(name = "NUMERO_ACTA", nullable = true)
    private String numeroActa;

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

    @Column(name = "TIPO_OPERACION")
    private Integer tipoOperacion;

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

    @Column(name = "TIPO_CAPTURA")
    private char tipoCaptura;


    public Integer getActaBis() {
        return actaBis;
    }

    public void setActaBis(Integer actaBis) {
        this.actaBis = actaBis;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public Boolean getCambioApellido() {
        return cambioApellido;
    }

    public void setCambioApellido(Boolean cambioApellido) {
        this.cambioApellido = cambioApellido;
    }

    public CatComparece getComparece() {
        return comparece;
    }

    public void setComparece(CatComparece comparece) {
        this.comparece = comparece;
    }

    public String getCrip() {
        return crip;
    }

    public void setCrip(String crip) {
        this.crip = crip;
    }

    public CatEscolaridad getEscolaridadMadre() {
        return escolaridadMadre;
    }

    public void setEscolaridadMadre(CatEscolaridad escolaridadMadre) {
        this.escolaridadMadre = escolaridadMadre;
    }

    public CatEscolaridad getEscolaridadPadre() {
        return escolaridadPadre;
    }

    public void setEscolaridadPadre(CatEscolaridad escolaridadPadre) {
        this.escolaridadPadre = escolaridadPadre;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    public Date getHoraNacRegistrado() {
        return horaNacRegistrado;
    }

    public void setHoraNacRegistrado(Date horaNacRegistrado) {
        this.horaNacRegistrado = horaNacRegistrado;
    }

    public String getImArchivo() {
        return imArchivo;
    }

    public void setImArchivo(String imArchivo) {
        this.imArchivo = imArchivo;
    }

    public CatInegiLocalidad getLocalidadRegistro() {
        return localidadRegistro;
    }

    public void setLocalidadRegistro(CatInegiLocalidad localidadRegistro) {
        this.localidadRegistro = localidadRegistro;
    }

    public CatLugarParto getLugarAtencionParto() {
        return lugarAtencionParto;
    }

    public void setLugarAtencionParto(CatLugarParto lugarAtencionParto) {
        this.lugarAtencionParto = lugarAtencionParto;
    }

    public CatAtendioParto getAtendioParto() {
        return atendioParto;
    }

    public void setAtendioParto(CatAtendioParto atendioParto) {
        this.atendioParto = atendioParto;
    }

    public Integer getNacieronVivos() {
        return nacieronVivos;
    }

    public void setNacieronVivos(Integer nacieronVivos) {
        this.nacieronVivos = nacieronVivos;
    }

    public String getNombreOficial() {
        return nombreOficial;
    }

    public void setNombreOficial(String nombreOficial) {
        this.nombreOficial = nombreOficial;
    }

    public String getNumeroActa() {
        return numeroActa;
    }

    public void setNumeroActa(String numeroActa) {
        this.numeroActa = numeroActa;
    }

    public Integer getNumParto() {
        return numParto;
    }

    public void setNumParto(Integer numParto) {
        this.numParto = numParto;
    }

    public CatOficialia getOficialia() {
        return oficialia;
    }

    public void setOficialia(CatOficialia oficialia) {
        this.oficialia = oficialia;
    }

    public Persona getRegistrado() {
        return registrado;
    }

    public void setRegistrado(Persona registrado) {
        this.registrado = registrado;
    }

    public Persona getPadre() {
        return padre;
    }

    public void setPadre(Persona padre) {
        this.padre = padre;
    }

    public Persona getMadre() {
        return madre;
    }

    public void setMadre(Persona madre) {
        this.madre = madre;
    }

    public Persona getAbuelaMaterna() {
        return abuelaMaterna;
    }

    public void setAbuelaMaterna(Persona abuelaMaterna) {
        this.abuelaMaterna = abuelaMaterna;
    }

    public Persona getAbuelaPaterna() {
        return abuelaPaterna;
    }

    public void setAbuelaPaterna(Persona abuelaPaterna) {
        this.abuelaPaterna = abuelaPaterna;
    }

    public Persona getAbueloMaterno() {
        return abueloMaterno;
    }

    public void setAbueloMaterno(Persona abueloMaterno) {
        this.abueloMaterno = abueloMaterno;
    }

    public Persona getAbueloPaterno() {
        return abueloPaterno;
    }

    public void setAbueloPaterno(Persona abueloPaterno) {
        this.abueloPaterno = abueloPaterno;
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

    public Persona getPersonaDistintaComparece() {
        return personaDistintaComparece;
    }

    public void setPersonaDistintaComparece(Persona personaDistintaComparece) {
        this.personaDistintaComparece = personaDistintaComparece;
    }

    public CatParentesco getParentPersonaDistintaPresenta() {
        return parentPersonaDistintaPresenta;
    }

    public void setParentPersonaDistintaPresenta(CatParentesco parentPersonaDistintaPresenta) {
        this.parentPersonaDistintaPresenta = parentPersonaDistintaPresenta;
    }

    public CatPuesto getPosicionTrabajoMadre() {
        return posicionTrabajoMadre;
    }

    public void setPosicionTrabajoMadre(CatPuesto posicionTrabajoMadre) {
        this.posicionTrabajoMadre = posicionTrabajoMadre;
    }

    public CatPuesto getPosicionTrabajoPadre() {
        return posicionTrabajoPadre;
    }

    public void setPosicionTrabajoPadre(CatPuesto posicionTrabajoPadre) {
        this.posicionTrabajoPadre = posicionTrabajoPadre;
    }

    public char getVivoMuerto() {
        return vivoMuerto;
    }

    public void setVivoMuerto(char vivoMuerto) {
        this.vivoMuerto = vivoMuerto;
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

    public CatSituacionLaboral getSituacionLaboralMadre() {
        return situacionLaboralMadre;
    }

    public void setSituacionLaboralMadre(CatSituacionLaboral situacionLaboralMadre) {
        this.situacionLaboralMadre = situacionLaboralMadre;
    }

    public CatSituacionLaboral getSituacionLaboralpadre() {
        return situacionLaboralpadre;
    }

    public void setSituacionLaboralpadre(CatSituacionLaboral situacionLaboralpadre) {
        this.situacionLaboralpadre = situacionLaboralpadre;
    }

    public Integer getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(Integer tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public CatTipoParto getTipoParto() {
        return tipoParto;
    }

    public void setTipoParto(CatTipoParto tipoParto) {
        this.tipoParto = tipoParto;
    }

    public String getTranscripcion() {
        return transcripcion;
    }

    public void setTranscripcion(String transcripcion) {
        this.transcripcion = transcripcion;
    }

    public Boolean getVacunado() {
        return vacunado;
    }

    public void setVacunado(Boolean vacunado) {
        this.vacunado = vacunado;
    }

    public Integer getViven() {
        return viven;
    }

    public void setViven(Integer viven) {
        this.viven = viven;
    }

    public char getTipoCaptura() {
        return tipoCaptura;
    }

    public void setTipoCaptura(char tipoCaptura) {
        this.tipoCaptura = tipoCaptura;
    }
}
