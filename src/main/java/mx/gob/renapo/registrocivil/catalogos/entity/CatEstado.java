package mx.gob.renapo.registrocivil.catalogos.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_ESTADO")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatEstado extends Catalogo implements Serializable {
    
    public CatEstado(){}
   
    @Column(name="ID_RENAPO", nullable=false)
    private Long idRenapo;

    @ManyToOne
    @JoinColumn(name = "ID_PAIS", nullable = false)
    private CatPais pais;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="estado")
    private Set<CatMunicipio> municipios;


}
