package mx.gob.renapo.registrocivil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CAT_LUGAR_PARTO")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatLugarParto extends SequenceGenerator {

    public CatLugarParto(){}

    @Column(name="DESCRIPCION", nullable=false)
    private String descripcion;
    
}
