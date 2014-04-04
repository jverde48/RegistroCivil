package mx.gob.renapo.registrocivil.catalogos.entity;



import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/19/14
 * Time: 12:10 PM
 * Entity del catalogo de INEGI de Municipio
 */
@Entity
@Table(name = "CAT_INEGI_MUNICIPIO")
public class CatInegiMunicipio  extends Catalogo implements Serializable {

    public CatInegiMunicipio() {

    }
    
    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", nullable = false)
    private CatInegiEstado estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="municipio")
    private Set<CatInegiLocalidad> localidadades;
}
