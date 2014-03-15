package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_SITUACION_LABORAL")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatSituacionLaboral extends Catalogo {

    public CatSituacionLaboral(){}
    
}
