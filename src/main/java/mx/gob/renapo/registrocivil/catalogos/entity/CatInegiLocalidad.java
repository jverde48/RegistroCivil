package mx.gob.renapo.registrocivil.catalogos.entity;


import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/3/14
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "CAT_INEGI_LOCALIDAD")
public class CatInegiLocalidad extends SequenceGenerator implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CatInegiLocalidad() {

    }

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "TIPO_LOCALIDAD", nullable = false)
    private  CatTipoLocalidad tipoLocalidad;

    @ManyToOne
    @JoinColumn(name = "ID_MUNICIPIO", nullable = false)
    private CatInegiMunicipio municipio;

    //getters y setters


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CatTipoLocalidad getTipoLocalidad() {
        return tipoLocalidad;
    }

    public void setTipoLocalidad(CatTipoLocalidad tipoLocalidad) {
        this.tipoLocalidad = tipoLocalidad;
    }

    public CatInegiMunicipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(CatInegiMunicipio municipio) {
        this.municipio = municipio;
    }

    //equals and hashcode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CatInegiLocalidad that = (CatInegiLocalidad) o;

        if (municipio != null ? !municipio.equals(that.municipio) : that.municipio != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (tipoLocalidad != null ? !tipoLocalidad.equals(that.tipoLocalidad) : that.tipoLocalidad != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (tipoLocalidad != null ? tipoLocalidad.hashCode() : 0);
        result = 31 * result + (municipio != null ? municipio.hashCode() : 0);
        return result;
    }

    // tostring


    @Override
    public String toString() {
        return "CatInegiLocalidad{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
