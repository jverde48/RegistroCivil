package mx.gob.renapo.registrocivil.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

@MappedSuperclass
public abstract class SequenceGenerator {
    @Id
    @TableGenerator(name="SEQUENCE_TABLE",
            table="SEQUENCE_TABLE",
            pkColumnName="TABLE_SEQUENCE_NAME",
            valueColumnName="TABLE_SEQUENCE_VAL",
            pkColumnValue="CAT_ESTADO",
            initialValue=1,
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCE_TABLE")
    private Long id;
    
    public SequenceGenerator(){}
}
