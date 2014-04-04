package mx.gob.renapo.registrocivil.catalogos.entity;


import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/3/14
 * Time: 2:21 PM
 * Clase que representa a la entidad del catalogo de de INEGI de Pais
 */
@Entity
@Table(name = "CAT_INEGI_PAIS")
public class CatInegiPais extends Catalogo implements Serializable {

    public CatInegiPais() {

    }
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pais")
    private Set<CatInegiEstado> estados;

}
