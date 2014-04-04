package mx.gob.renapo.registrocivil.catalogos.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/19/14
 * Time: 12:14 PM
 * Entity del catalogo de Pais
 */
@Entity
@Table(name = "CAT_PAIS")
public class CatPais extends Catalogo implements Serializable {

    public CatPais() {

    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pais")
    private Set<CatEstado> estados;

    @Column(name = "NACIONALIDAD", nullable = false)
    private String nacionalidad;

    //getters y setters

    public Set<CatEstado> getEstados() {
        return estados;
    }

    public void setEstados(Set<CatEstado> estados) {
        this.estados = estados;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }



}
