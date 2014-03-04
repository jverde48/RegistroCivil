package mx.gob.renapo.registrocivil.catalogos.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name="CAT_MUNICIPIO")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatMunicipio extends SequenceGenerator {
    
    public CatMunicipio(){}
    
    @Column(name="ID_RENAPO", nullable=false)
    private Long idRenapo;
    
    @Column(name="NOMBRE", nullable=false, length=50)
    private String nombre;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", nullable = false)
    private CatEstado estado;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="municipio")
    private Set<CatOficialia> oficialias;
   
}
