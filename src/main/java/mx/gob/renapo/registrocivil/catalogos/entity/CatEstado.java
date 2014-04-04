package mx.gob.renapo.registrocivil.catalogos.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_ESTADO")
public class CatEstado extends Catalogo implements Serializable {
    
    public CatEstado(){}
   
    @Column(name="ID_RENAPO", nullable=false)
    private Long idRenapo;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS", nullable = false)
    private CatPais pais;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="estado")
    private Set<CatMunicipio> municipios;

    //getters y setters


    public Long getIdRenapo() {
        return idRenapo;
    }

    public void setIdRenapo(Long idRenapo) {
        this.idRenapo = idRenapo;
    }

    public CatPais getPais() {
        return pais;
    }

    public void setPais(CatPais pais) {
        this.pais = pais;
    }

    public Set<CatMunicipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Set<CatMunicipio> municipios) {
        this.municipios = municipios;
    }
}
