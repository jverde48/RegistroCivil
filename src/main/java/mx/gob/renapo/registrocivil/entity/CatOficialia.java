package mx.gob.renapo.registrocivil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CAT_OFICIALIA")
@Data
public class CatOficialia extends SequenceGenerator{
    
    public CatOficialia(){}
    
    @Column(name = "ID_RENAPO", nullable=false)
    private Long idRenapo;
    
    @Column(name = "DESCRIPCION", nullable=true)
    private String descripcion;
    
    @Column(name = "OFICIAL", nullable=false)
    private String oficial;
    
    @Column(name="TIPO_OFICIALIA")
    private String tipoOficialia;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", nullable = false)
    private CatMunicipio municipio;
   
}
