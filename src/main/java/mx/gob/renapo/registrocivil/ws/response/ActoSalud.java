
package mx.gob.renapo.registrocivil.ws.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for actoSalud complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="actoSalud">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="estadoNac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estadoNac_Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaNacimiento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="madre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipioNac" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipioNac_Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="municipio_Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombrePrimeraPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primerApellidoPrimeraPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primer_Apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="respuesta" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="segundoApellidoPrimeraPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="segundo_Apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actoSalud", propOrder = {
    "estadoNac",
    "estadoNacNombre",
    "fechaNacimiento",
    "madre",
    "municipio",
    "municipioNac",
    "municipioNacNombre",
    "municipioNombre",
    "nombre",
    "nombrePrimeraPersona",
    "primerApellidoPrimeraPersona",
    "primerApellido",
    "respuesta",
    "segundoApellidoPrimeraPersona",
    "segundoApellido",
    "ssa"
})
public abstract class ActoSalud {

    protected String estadoNac;
    @XmlElement(name = "estadoNac_Nombre")
    protected String estadoNacNombre;
    protected String fechaNacimiento;
    protected String madre;
    protected String municipio;
    protected String municipioNac;
    @XmlElement(name = "municipioNac_Nombre")
    protected String municipioNacNombre;
    @XmlElement(name = "municipio_Nombre")
    protected String municipioNombre;
    protected String nombre;
    protected String nombrePrimeraPersona;
    protected String primerApellidoPrimeraPersona;
    @XmlElement(name = "primer_Apellido")
    protected String primerApellido;
    protected long respuesta;
    protected String segundoApellidoPrimeraPersona;
    @XmlElement(name = "segundo_Apellido")
    protected String segundoApellido;
    protected String ssa;

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
     * Gets the value of the respuesta property.
     * 
     */
    public long getRespuesta() {
        return respuesta;
    }

    /**
     * Sets the value of the respuesta property.
     * 
     */
    public void setRespuesta(long value) {
        this.respuesta = value;
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

}
