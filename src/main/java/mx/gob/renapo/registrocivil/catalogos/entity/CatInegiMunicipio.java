package mx.gob.renapo.registrocivil.catalogos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/19/14
 * Time: 12:10 PM
 * Entity del catalogo de INEGI de Municipio
 */
@Entity
@Table(name = "CAT_INEGI_MUNICIPIO")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatInegiMunicipio  extends Catalogo implements Serializable {

    public CatInegiMunicipio() {

    }


}
