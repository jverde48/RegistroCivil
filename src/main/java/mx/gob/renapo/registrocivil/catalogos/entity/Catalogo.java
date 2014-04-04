package mx.gob.renapo.registrocivil.catalogos.entity;

import lombok.Data;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 11:55 PM
 * Entity abstracta con los atributos escenciales de los catalogos
 */
@MappedSuperclass
//@Data
public abstract class Catalogo extends SequenceGenerator{
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Catalogo catalogo = (Catalogo) o;

        if (descripcion != null ? !descripcion.equals(catalogo.descripcion) : catalogo.descripcion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }

    @Column(name = "DESCRIPCION", nullable = true)
    private String descripcion;

}
