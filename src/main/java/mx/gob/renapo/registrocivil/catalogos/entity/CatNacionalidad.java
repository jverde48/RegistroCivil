package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_NACIONALIDAD")
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "descripcion"})
public class CatNacionalidad extends SequenceGenerator {

    public CatNacionalidad(){}

    @Column(name="DESCRIPCION", nullable=false)
    private String descripcion;

    @Column(name="PAIS", nullable=false)
    private String pais;

}
