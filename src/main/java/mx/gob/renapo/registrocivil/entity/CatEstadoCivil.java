package mx.gob.renapo.registrocivil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CAT_ESTADO_CIVIL")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatEstadoCivil extends SequenceGenerator {
    public CatEstadoCivil(){}

    @Column(name="DESCRIPCION", nullable=false)
    private String descripcion;
    
}
