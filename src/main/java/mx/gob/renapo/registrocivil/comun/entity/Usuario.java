package mx.gob.renapo.registrocivil.comun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.entity.CatEstado;
import mx.gob.renapo.registrocivil.catalogos.entity.CatMunicipio;
import mx.gob.renapo.registrocivil.catalogos.entity.CatOficialia;

@Entity
@Table(name = "USUARIO")
public class Usuario extends SequenceGenerator {

    public Usuario(){}

    @Column(name="NIVEL", nullable=false)
    private Long nivel;

    @Column(name="SISTEMA", nullable=false)
    private Boolean sistema;
    
    @OneToOne
    private CatEstado entidad;
    
    @OneToOne
    private CatMunicipio municipio;
    
    @OneToOne
    private CatOficialia oficialia;


    //Getter and Setter

    public Long getNivel() {
        return nivel;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public Boolean getSistema() {
        return sistema;
    }

    public void setSistema(Boolean sistema) {
        this.sistema = sistema;
    }

    public CatEstado getEntidad() {
        return entidad;
    }

    public void setEntidad(CatEstado entidad) {
        this.entidad = entidad;
    }

    public CatMunicipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(CatMunicipio municipio) {
        this.municipio = municipio;
    }

    public CatOficialia getOficialia() {
        return oficialia;
    }

    public void setOficialia(CatOficialia oficialia) {
        this.oficialia = oficialia;
    }


    //Equals and Hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        if (!super.equals(o)) return false;

        Usuario usuario = (Usuario) o;

        if (entidad != null ? !entidad.equals(usuario.entidad) : usuario.entidad != null) return false;
        if (municipio != null ? !municipio.equals(usuario.municipio) : usuario.municipio != null) return false;
        if (nivel != null ? !nivel.equals(usuario.nivel) : usuario.nivel != null) return false;
        if (oficialia != null ? !oficialia.equals(usuario.oficialia) : usuario.oficialia != null) return false;
        if (sistema != null ? !sistema.equals(usuario.sistema) : usuario.sistema != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (nivel != null ? nivel.hashCode() : 0);
        result = 31 * result + (sistema != null ? sistema.hashCode() : 0);
        result = 31 * result + (entidad != null ? entidad.hashCode() : 0);
        result = 31 * result + (municipio != null ? municipio.hashCode() : 0);
        result = 31 * result + (oficialia != null ? oficialia.hashCode() : 0);
        return result;
    }

    //ToString

    @Override
    public String toString() {
        return "Usuario{" +
                "nivel=" + nivel +
                ", sistema=" + sistema +
                ", entidad=" + entidad +
                ", municipio=" + municipio +
                ", oficialia=" + oficialia +
                '}';
    }
}
