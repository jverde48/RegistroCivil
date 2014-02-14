package mx.gob.renapo.registrocivil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CAT_ESCOLARIDAD")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatEscolaridad extends SequenceGenerator {

    public CatEscolaridad(){}

    @Column(name="DESCRIPCION", nullable=false)
    private String descripcion;
    
}
