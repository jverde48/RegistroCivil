
package mx.gob.renapo.registrocivil.ws.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nacimientoVerActo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nacimientoVerActo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://controller.cirr.renapo.segob.gob.mx/}actoVer">
 *       &lt;sequence>
 *         &lt;element name="vivoMuerto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nacimientoVerActo", propOrder = {
    "vivoMuerto"
})
@XmlSeeAlso({
    NacimientoRepActo.class
})
public class NacimientoVerActo
    extends ActoVer
{

    protected String vivoMuerto;

    /**
     * Gets the value of the vivoMuerto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVivoMuerto() {
        return vivoMuerto;
    }

    /**
     * Sets the value of the vivoMuerto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVivoMuerto(String value) {
        this.vivoMuerto = value;
    }

}
