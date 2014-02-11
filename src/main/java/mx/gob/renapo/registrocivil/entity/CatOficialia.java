package mx.gob.renapo.registrocivil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;

@Entity
@Table(name = "CAT_OFICIALIA")
@Data
public class CatOficialia {
    
    public CatOficialia(){}
    
    @Id
    @TableGenerator(name="SEQUENCE_TABLE",
            table="SEQUENCE_TABLE",
            pkColumnName="TABLE_SEQUENCE_NAME",
            valueColumnName="TABLE_SEQUENCE_VAL",
            pkColumnValue="CAT_OFICIALIA",
            initialValue=1,
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCE_TABLE")
    private Long id;
    
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
