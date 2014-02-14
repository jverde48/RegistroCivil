package mx.gob.renapo.registrocivil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CAT_ATENDIO_PARTO")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatAtendioParto extends SequenceGenerator {

    public CatAtendioParto(){}

    @Column(name="DESCRIPCION", nullable=false)
    private String descripcion;
   
}
