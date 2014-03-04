package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.common.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_TIPO_DIVORCIO")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatTipoDivorcio extends SequenceGenerator {

    public CatTipoDivorcio(){}

    @Column(name="DESCRIPCION", nullable=false)
    private String descripcion;
    
}
