package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_ESCOLARIDAD")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatEscolaridad extends Catalogo {

    public CatEscolaridad(){}
    
}
