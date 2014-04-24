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

    @Column(name = "DESCRIPCION", nullable = true)
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
