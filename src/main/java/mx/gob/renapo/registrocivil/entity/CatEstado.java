package mx.gob.renapo.registrocivil.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CAT_ESTADO")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatEstado extends SequenceGenerator {
    
    public CatEstado(){}
   
    @Column(name="ID_RENAPO", nullable=false)
    private Long idRenapo;
    
    @Column(name="NOMBRE", nullable=false, length=50)
    private String nombre;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="estado")
    private Set<CatMunicipio> municipios;

}