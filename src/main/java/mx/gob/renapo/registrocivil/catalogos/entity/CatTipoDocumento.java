package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_TIPO_DOCUMENTO")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatTipoDocumento extends SequenceGenerator {

    public CatTipoDocumento(){}

    @Column(name="DESCRIPCION", nullable=false)
    private String descripcion;
    
}
