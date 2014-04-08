package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_OFICIALIA")
public class CatOficialia extends SequenceGenerator {
    
    public CatOficialia(){}
    
    @Column(name = "ID_RENAPO", nullable=false)
    private Long idRenapo;
    
    @Column(name = "DESCRIPCION", nullable=true)
    private String descripcion;
    
    @OneToOne
    @JoinColumn(name = "ID_OFICIAL", nullable=true)
    private CatOficial idOficial;
    
    @OneToOne
    @JoinColumn(name="TIPO_OFICIALIA", nullable=true)
    private CatTipoOficialia tipoOficialia;

    @Column(name="LOCALIDAD", nullable=true)
    private String localidad;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MUNICIPIO", nullable = false)
    private CatMunicipio municipio;

    //getters y setters

    public Long getIdRenapo() {
        return idRenapo;
    }

    public void setIdRenapo(Long idRenapo) {
        this.idRenapo = idRenapo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CatOficial getIdOficial() {
        return idOficial;
    }

    public void setIdOficial(CatOficial idOficial) {
        this.idOficial = idOficial;
    }

    public CatTipoOficialia getTipoOficialia() {
        return tipoOficialia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setTipoOficialia(CatTipoOficialia tipoOficialia) {
        this.tipoOficialia = tipoOficialia;
    }

    public CatMunicipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(CatMunicipio municipio) {
        this.municipio = municipio;
    }

    // equals y hascode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CatOficialia that = (CatOficialia) o;

        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (idOficial != null ? !idOficial.equals(that.idOficial) : that.idOficial != null) return false;
        if (idRenapo != null ? !idRenapo.equals(that.idRenapo) : that.idRenapo != null) return false;
        if (municipio != null ? !municipio.equals(that.municipio) : that.municipio != null) return false;
        if (tipoOficialia != null ? !tipoOficialia.equals(that.tipoOficialia) : that.tipoOficialia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (idRenapo != null ? idRenapo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (idOficial != null ? idOficial.hashCode() : 0);
        result = 31 * result + (tipoOficialia != null ? tipoOficialia.hashCode() : 0);
        result = 31 * result + (municipio != null ? municipio.hashCode() : 0);
        return result;
    }

    //to string

    @Override
    public String toString() {
        return "CatOficialia{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
