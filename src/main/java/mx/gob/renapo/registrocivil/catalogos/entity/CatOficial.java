package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_OFICIAL")
public class CatOficial extends SequenceGenerator {
	
	 public CatOficial(){}
	 
	 @Column(name = "NOMBRE", nullable=false)
	 private String descripcion;

	 @Column(name = "NUM_OFICIAL", nullable=true)
	 private Long numOficial;

    //getters y setters

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getNumOficial() {
        return numOficial;
    }

    public void setNumOficial(Long numOficial) {
        this.numOficial = numOficial;
    }

    //equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CatOficial that = (CatOficial) o;

        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (numOficial != null ? !numOficial.equals(that.numOficial) : that.numOficial != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (numOficial != null ? numOficial.hashCode() : 0);
        return result;
    }

    // to string

    @Override
    public String toString() {
        return "CatOficial{" +
                "descripcion='" + descripcion + '\'' +
                '}';
    }
}
