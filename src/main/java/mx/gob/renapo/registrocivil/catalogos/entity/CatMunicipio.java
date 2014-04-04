package mx.gob.renapo.registrocivil.catalogos.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name="CAT_MUNICIPIO")
public class CatMunicipio extends SequenceGenerator {
    
    public CatMunicipio(){}
    
    @Column(name="ID_RENAPO", nullable=false)
    private Long idRenapo;
    
    @Column(name="NOMBRE", nullable=false, length=50)
    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "ID_ESTADO", nullable = false)
    private CatEstado estado;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="municipio")
    private Set<CatOficialia> oficialias;

    //getters y setters

    public Set<CatOficialia> getOficialias() {
        return oficialias;
    }

    public void setOficialias(Set<CatOficialia> oficialias) {
        this.oficialias = oficialias;
    }

    public CatEstado getEstado() {
        return estado;
    }

    public void setEstado(CatEstado estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdRenapo() {
        return idRenapo;
    }

    public void setIdRenapo(Long idRenapo) {
        this.idRenapo = idRenapo;
    }

    //equalas and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CatMunicipio that = (CatMunicipio) o;

        if (estado != null ? !estado.equals(that.estado) : that.estado != null) return false;
        if (idRenapo != null ? !idRenapo.equals(that.idRenapo) : that.idRenapo != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (oficialias != null ? !oficialias.equals(that.oficialias) : that.oficialias != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (idRenapo != null ? idRenapo.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (oficialias != null ? oficialias.hashCode() : 0);
        return result;
    }

    //to string

    @Override
    public String toString() {
        return "CatMunicipio{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
