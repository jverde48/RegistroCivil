package mx.gob.renapo.registrocivil.catalogos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

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
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "descripcion"})
public class CatPais extends Catalogo implements Serializable {

    public CatPais() {

    }

    @OneToMany
    private Set<CatEstado> estados;
    
    @Column(name = "NACIONALIDAD", nullable = false)
    private String nacionalidad;


}
