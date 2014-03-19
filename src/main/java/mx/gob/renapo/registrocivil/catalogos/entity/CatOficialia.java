package mx.gob.renapo.registrocivil.catalogos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

@Entity
@Table(name = "CAT_OFICIALIA")
@Data
@EqualsAndHashCode(callSuper=false)
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
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MUNICIPIO", nullable = false)
    private CatMunicipio municipio;
   
}
