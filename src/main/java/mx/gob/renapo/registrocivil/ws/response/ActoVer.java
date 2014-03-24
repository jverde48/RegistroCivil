
package mx.gob.renapo.registrocivil.ws.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actoVer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actoVer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actaBis" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="anioRegistro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cadena" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="curp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoNac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoNacNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoReg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoRegNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaRegistro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="foja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="folio" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="libro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="madre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipioNac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipioNacNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipioNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipioReg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipioRegNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noActa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombrePrimeraPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombreSegundaPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notasMarginales" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroActa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oficialia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="oficialia_Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="padre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primerApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primerApellidoPrimeraPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primerApellidoSegundaPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segundoApellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segundoApellidoPrimeraPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segundoApellidoSegundaPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sello" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tomo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actoVer", propOrder = {
    "actaBis",
    "anioRegistro",
    "cadena",
    "curp",
    "estadoNac",
    "estadoNacNombre",
    "estadoReg",
    "estadoRegNombre",
    "fechaNacimiento",
    "fechaRegistro",
    "foja",
    "folio",
    "libro",
    "localidad",
    "madre",
    "municipio",
    "municipioNac",
    "municipioNacNombre",
    "municipioNombre",
    "municipioReg",
    "municipioRegNombre",
    "noActa",
    "nombre",
    "nombrePrimeraPersona",
    "nombreSegundaPersona",
    "notasMarginales",
    "numeroActa",
    "oficialia",
    "oficialiaNombre",
    "padre",
    "primerApellido",
    "primerApellidoPrimeraPersona",
    "primerApellidoSegundaPersona",
    "segundoApellido",
    "segundoApellidoPrimeraPersona",
    "segundoApellidoSegundaPersona",
    "sello",
    "sexo",
    "ssa",
    "tomo"
})
@XmlSeeAlso({
    DefuncionVerActo.class,
    ReconocimientoVerActo.class,
    AdopcionVerActo.class,
    NacimientoVerActo.class
})
public abstract class ActoVer {

    protected String actaBis;
    protected String anioRegistro;
    protected String cadena;
    protected String curp;
    protected String estadoNac;
    protected String estadoNacNombre;
    protected String estadoReg;
    protected String estadoRegNombre;
    protected String fechaNacimiento;
    protected String fechaRegistro;
    protected String foja;
    protected long folio;
    protected String libro;
    protected String localidad;
    protected String madre;
    protected String municipio;
    protected String municipioNac;
    protected String municipioNacNombre;
    protected String municipioNombre;
    protected String municipioReg;
    protected String municipioRegNombre;
    protected String noActa;
    protected String nombre;
    protected String nombrePrimeraPersona;
    protected String nombreSegundaPersona;
    protected String notasMarginales;
    protected String numeroActa;
    protected String oficialia;
    @XmlElement(name = "oficialia_Nombre")
    protected String oficialiaNombre;
    protected String padre;
    protected String primerApellido;
    protected String primerApellidoPrimeraPersona;
    protected String primerApellidoSegundaPersona;
    protected String segundoApellido;
    protected String segundoApellidoPrimeraPersona;
    protected String segundoApellidoSegundaPersona;
    protected String sello;
    protected String sexo;
    protected String ssa;
    protected String tomo;

    /**
     * Gets the value of the actaBis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActaBis() {
        return actaBis;
    }

    /**
     * Sets the value of the actaBis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActaBis(String value) {
        this.actaBis = value;
    }

    /**
     * Gets the value of the anioRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnioRegistro() {
        return anioRegistro;
    }

    /**
     * Sets the value of the anioRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnioRegistro(String value) {
        this.anioRegistro = value;
    }

    /**
     * Gets the value of the cadena property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCadena() {
        return cadena;
    }

    /**
     * Sets the value of the cadena property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCadena(String value) {
        this.cadena = value;
    }

    /**
     * Gets the value of the curp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Sets the value of the curp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurp(String value) {
        this.curp = value;
    }

    /**
     * Gets the value of the estadoNac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoNac() {
        return estadoNac;
    }

    /**
     * Sets the value of the estadoNac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoNac(String value) {
        this.estadoNac = value;
    }

    /**
     * Gets the value of the estadoNacNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoNacNombre() {
        return estadoNacNombre;
    }

    /**
     * Sets the value of the estadoNacNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoNacNombre(String value) {
        this.estadoNacNombre = value;
    }

    /**
     * Gets the value of the estadoReg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoReg() {
        return estadoReg;
    }

    /**
     * Sets the value of the estadoReg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoReg(String value) {
        this.estadoReg = value;
    }

    /**
     * Gets the value of the estadoRegNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoRegNombre() {
        return estadoRegNombre;
    }

    /**
     * Sets the value of the estadoRegNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoRegNombre(String value) {
        this.estadoRegNombre = value;
    }

    /**
     * Gets the value of the fechaNacimiento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Sets the value of the fechaNacimiento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaNacimiento(String value) {
        this.fechaNacimiento = value;
    }

    /**
     * Gets the value of the fechaRegistro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Sets the value of the fechaRegistro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaRegistro(String value) {
        this.fechaRegistro = value;
    }

    /**
     * Gets the value of the foja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoja() {
        return foja;
    }

    /**
     * Sets the value of the foja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoja(String value) {
        this.foja = value;
    }

    /**
     * Gets the value of the folio property.
     * 
     */
    public long getFolio() {
        return folio;
    }

    /**
     * Sets the value of the folio property.
     * 
     */
    public void setFolio(long value) {
        this.folio = value;
    }

    /**
     * Gets the value of the libro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLibro() {
        return libro;
    }

    /**
     * Sets the value of the libro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLibro(String value) {
        this.libro = value;
    }

    /**
     * Gets the value of the localidad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Sets the value of the localidad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalidad(String value) {
        this.localidad = value;
    }

    /**
     * Gets the value of the madre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMadre() {
        return madre;
    }

    /**
     * Sets the value of the madre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMadre(String value) {
        this.madre = value;
    }

    /**
     * Gets the value of the municipio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * Sets the value of the municipio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipio(String value) {
        this.municipio = value;
    }

    /**
     * Gets the value of the municipioNac property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipioNac() {
        return municipioNac;
    }

    /**
     * Sets the value of the municipioNac property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipioNac(String value) {
        this.municipioNac = value;
    }

    /**
     * Gets the value of the municipioNacNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipioNacNombre() {
        return municipioNacNombre;
    }

    /**
     * Sets the value of the municipioNacNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipioNacNombre(String value) {
        this.municipioNacNombre = value;
    }

    /**
     * Gets the value of the municipioNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipioNombre() {
        return municipioNombre;
    }

    /**
     * Sets the value of the municipioNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipioNombre(String value) {
        this.municipioNombre = value;
    }

    /**
     * Gets the value of the municipioReg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipioReg() {
        return municipioReg;
    }

    /**
     * Sets the value of the municipioReg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipioReg(String value) {
        this.municipioReg = value;
    }

    /**
     * Gets the value of the municipioRegNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMunicipioRegNombre() {
        return municipioRegNombre;
    }

    /**
     * Sets the value of the municipioRegNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMunicipioRegNombre(String value) {
        this.municipioRegNombre = value;
    }

    /**
     * Gets the value of the noActa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoActa() {
        return noActa;
    }

    /**
     * Sets the value of the noActa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoActa(String value) {
        this.noActa = value;
    }

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the nombrePrimeraPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePrimeraPersona() {
        return nombrePrimeraPersona;
    }

    /**
     * Sets the value of the nombrePrimeraPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePrimeraPersona(String value) {
        this.nombrePrimeraPersona = value;
    }

    /**
     * Gets the value of the nombreSegundaPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreSegundaPersona() {
        return nombreSegundaPersona;
    }

    /**
     * Sets the value of the nombreSegundaPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreSegundaPersona(String value) {
        this.nombreSegundaPersona = value;
    }

    /**
     * Gets the value of the notasMarginales property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotasMarginales() {
        return notasMarginales;
    }

    /**
     * Sets the value of the notasMarginales property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotasMarginales(String value) {
        this.notasMarginales = value;
    }

    /**
     * Gets the value of the numeroActa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroActa() {
        return numeroActa;
    }

    /**
     * Sets the value of the numeroActa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroActa(String value) {
        this.numeroActa = value;
    }

    /**
     * Gets the value of the oficialia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOficialia() {
        return oficialia;
    }

    /**
     * Sets the value of the oficialia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOficialia(String value) {
        this.oficialia = value;
    }

    /**
     * Gets the value of the oficialiaNombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOficialiaNombre() {
        return oficialiaNombre;
    }

    /**
     * Sets the value of the oficialiaNombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOficialiaNombre(String value) {
        this.oficialiaNombre = value;
    }

    /**
     * Gets the value of the padre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPadre() {
        return padre;
    }

    /**
     * Sets the value of the padre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPadre(String value) {
        this.padre = value;
    }

    /**
     * Gets the value of the primerApellido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Sets the value of the primerApellido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerApellido(String value) {
        this.primerApellido = value;
    }

    /**
     * Gets the value of the primerApellidoPrimeraPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerApellidoPrimeraPersona() {
        return primerApellidoPrimeraPersona;
    }

    /**
     * Sets the value of the primerApellidoPrimeraPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerApellidoPrimeraPersona(String value) {
        this.primerApellidoPrimeraPersona = value;
    }

    /**
     * Gets the value of the primerApellidoSegundaPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimerApellidoSegundaPersona() {
        return primerApellidoSegundaPersona;
    }

    /**
     * Sets the value of the primerApellidoSegundaPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimerApellidoSegundaPersona(String value) {
        this.primerApellidoSegundaPersona = value;
    }

    /**
     * Gets the value of the segundoApellido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Sets the value of the segundoApellido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundoApellido(String value) {
        this.segundoApellido = value;
    }

    /**
     * Gets the value of the segundoApellidoPrimeraPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundoApellidoPrimeraPersona() {
        return segundoApellidoPrimeraPersona;
    }

    /**
     * Sets the value of the segundoApellidoPrimeraPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundoApellidoPrimeraPersona(String value) {
        this.segundoApellidoPrimeraPersona = value;
    }

    /**
     * Gets the value of the segundoApellidoSegundaPersona property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSegundoApellidoSegundaPersona() {
        return segundoApellidoSegundaPersona;
    }

    /**
     * Sets the value of the segundoApellidoSegundaPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSegundoApellidoSegundaPersona(String value) {
        this.segundoApellidoSegundaPersona = value;
    }

    /**
     * Gets the value of the sello property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSello() {
        return sello;
    }

    /**
     * Sets the value of the sello property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSello(String value) {
        this.sello = value;
    }

    /**
     * Gets the value of the sexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Sets the value of the sexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexo(String value) {
        this.sexo = value;
    }

    /**
     * Gets the value of the ssa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSsa() {
        return ssa;
    }

    /**
     * Sets the value of the ssa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSsa(String value) {
        this.ssa = value;
    }

    /**
     * Gets the value of the tomo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTomo() {
        return tomo;
    }

    /**
     * Sets the value of the tomo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTomo(String value) {
        this.tomo = value;
    }

}
