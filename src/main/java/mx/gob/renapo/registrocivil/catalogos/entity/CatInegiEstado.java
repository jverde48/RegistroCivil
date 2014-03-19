package mx.gob.renapo.registrocivil.catalogos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/19/14
 * Time: 11:55 AM
 * Entity del catalogo de inegi de estados
 */
@Entity
@Table(name = "CAT_INEGI_ESTADO")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatInegiEstado extends Catalogo implements Serializable {

    public CatInegiEstado() {

    }

}
