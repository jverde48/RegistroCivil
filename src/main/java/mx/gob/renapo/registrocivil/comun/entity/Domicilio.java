package mx.gob.renapo.registrocivil.comun.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.entity.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/3/14
 * Time: 4:43 PM
 * Clase que representa la entidad de Domicilio
 */
@Entity
@Table(name = "DOMICILIO")
public class Domicilio extends SequenceGenerator implements Serializable{

    @Column(name = "CALLE", nullable = true)
    private String calle;

    @Column(name = "NUMERO_EXT")
    private String numeroExt;

    @Column(name = "NUMERO_INT")
    private String numeroInt;

    @Column(name = "COLONIA")
    private String colonia;

    @OneToOne
    private CatInegiLocalidad localidad;

    @OneToOne
    private CatInegiMunicipio municipio;

    @OneToOne
    private CatInegiEstado estado;

    @Column(name = "CODIGO_POSTAL", nullable = true)
    private String codigoPostal;

    @OneToOne
    private CatInegiPais pais;


    //Getter and Setter

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExt() {
        return numeroExt;
    }

    public void setNumeroExt(String numeroExt) {
        this.numeroExt = numeroExt;
    }

    public String getNumeroInt() {
        return numeroInt;
    }

    public void setNumeroInt(String numeroInt) {
        this.numeroInt = numeroInt;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public CatInegiLocalidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(CatInegiLocalidad localidad) {
        this.localidad = localidad;
    }

    public CatInegiMunicipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(CatInegiMunicipio municipio) {
        this.municipio = municipio;
    }

    public CatInegiEstado getEstado() {
        return estado;
    }

    public void setEstado(CatInegiEstado estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public CatInegiPais getPais() {
        return pais;
    }

    public void setPais(CatInegiPais pais) {
        this.pais = pais;
    }

    //Equals and Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Domicilio)) return false;
        if (!super.equals(o)) return false;

        Domicilio domicilio = (Domicilio) o;

        if (calle != null ? !calle.equals(domicilio.calle) : domicilio.calle != null) return false;
        if (codigoPostal != null ? !codigoPostal.equals(domicilio.codigoPostal) : domicilio.codigoPostal != null)
            return false;
        if (colonia != null ? !colonia.equals(domicilio.colonia) : domicilio.colonia != null) return false;
        if (estado != null ? !estado.equals(domicilio.estado) : domicilio.estado != null) return false;
        if (localidad != null ? !localidad.equals(domicilio.localidad) : domicilio.localidad != null) return false;
        if (municipio != null ? !municipio.equals(domicilio.municipio) : domicilio.municipio != null) return false;
        if (numeroExt != null ? !numeroExt.equals(domicilio.numeroExt) : domicilio.numeroExt != null) return false;
        if (numeroInt != null ? !numeroInt.equals(domicilio.numeroInt) : domicilio.numeroInt != null) return false;
        if (pais != null ? !pais.equals(domicilio.pais) : domicilio.pais != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (calle != null ? calle.hashCode() : 0);
        result = 31 * result + (numeroExt != null ? numeroExt.hashCode() : 0);
        result = 31 * result + (numeroInt != null ? numeroInt.hashCode() : 0);
        result = 31 * result + (colonia != null ? colonia.hashCode() : 0);
        result = 31 * result + (localidad != null ? localidad.hashCode() : 0);
        result = 31 * result + (municipio != null ? municipio.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (codigoPostal != null ? codigoPostal.hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        return result;
    }


    //ToString

    @Override
    public String toString() {
        return "Domicilio{" +
                "calle='" + calle + '\'' +
                ", numeroExt='" + numeroExt + '\'' +
                ", numeroInt='" + numeroInt + '\'' +
                ", colonia='" + colonia + '\'' +
                ", localidad=" + localidad +
                ", municipio=" + municipio +
                ", estado=" + estado +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", pais=" + pais +
                '}';
    }
}
