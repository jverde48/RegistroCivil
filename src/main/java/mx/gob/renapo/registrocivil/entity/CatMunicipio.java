package mx.gob.renapo.registrocivil.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;

@Entity
@Table(name="CAT_MUNICIPIO")
@Data
public class CatMunicipio {
    
    public CatMunicipio(){}
    
    @Id
    @TableGenerator(name="SEQUENCE_TABLE",
            table="SEQUENCE_TABLE",
            pkColumnName="TABLE_SEQUENCE_NAME",
            valueColumnName="TABLE_SEQUENCE_VAL",
            pkColumnValue="CAT_MUNICIPIO",
            initialValue=1,
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCE_TABLE")
    private Long id;
    
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
