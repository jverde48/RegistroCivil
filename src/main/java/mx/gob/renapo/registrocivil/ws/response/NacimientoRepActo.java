
package mx.gob.renapo.registrocivil.ws.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nacimientoRepActo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nacimientoRepActo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://controller.cirr.renapo.segob.gob.mx/}nacimientoVerActo">
 *       &lt;sequence>
 *         &lt;element name="curpMADRE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="curpPADRE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nacMADRE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nacPADRE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nacimientoRepActo", propOrder = {
    "curpMADRE",
    "curpPADRE",
    "nacMADRE",
    "nacPADRE"
})
public class NacimientoRepActo
    extends NacimientoVerActo
{

    protected String curpMADRE;
    protected String curpPADRE;
    protected String nacMADRE;
    protected String nacPADRE;

    /**
     * Gets the value of the curpMADRE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurpMADRE() {
        return curpMADRE;
    }

    /**
     * Sets the value of the curpMADRE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurpMADRE(String value) {
        this.curpMADRE = value;
    }

    /**
     * Gets the value of the curpPADRE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurpPADRE() {
        return curpPADRE;
    }

    /**
     * Sets the value of the curpPADRE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurpPADRE(String value) {
        this.curpPADRE = value;
    }

    /**
     * Gets the value of the nacMADRE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacMADRE() {
        return nacMADRE;
    }

    /**
     * Sets the value of the nacMADRE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacMADRE(String value) {
        this.nacMADRE = value;
    }

    /**
     * Gets the value of the nacPADRE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacPADRE() {
        return nacPADRE;
    }

    /**
     * Sets the value of the nacPADRE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacPADRE(String value) {
        this.nacPADRE = value;
    }

}
