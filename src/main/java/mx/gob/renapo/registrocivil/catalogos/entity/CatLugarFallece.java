package mx.gob.renapo.registrocivil.catalogos.entity;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 06:06 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name="CAT_LUGAR_FALLECE")
@Data
@EqualsAndHashCode(callSuper = false)
public class CatLugarFallece extends Catalogo {

    public CatLugarFallece(){}

}
