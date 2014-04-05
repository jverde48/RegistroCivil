package mx.gob.renapo.registrocivil.catalogos.entity;


import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/19/14
 * Time: 11:55 AM
 * Entity del catalogo de inegi de estados
 */
@Entity
@Table(name = "CAT_INEGI_ESTADO")
public class CatInegiEstado extends Catalogo implements Serializable {

    public CatInegiEstado() {

    }
    
    @ManyToOne
    @JoinColumn(name = "ID_PAIS", nullable = false)
    private CatInegiPais pais;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="estado")
    private Set<CatInegiMunicipio> municipios;

}
