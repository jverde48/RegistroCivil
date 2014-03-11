package mx.gob.renapo.registrocivil.comun.entity;

import java.util.Date;

import javax.persistence.*;

@MappedSuperclass
public abstract class SequenceGenerator {
    @Id
    @TableGenerator(name="SEQUENCE_TABLE",
            table="SEQUENCE_TABLE",
            pkColumnName="TABLE_SEQUENCE_NAME",
            valueColumnName="TABLE_SEQUENCE_VAL",
            initialValue=1,
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SEQUENCE_TABLE")
    private Long id;

    @Column(name="FECHA_ACTUALIZACION", nullable = true)
    private Date fechaActualizacion;

    @Column(name="FECHA_CREACION", nullable = true)
    private Date fechaCreacion;

    @Column(name = "FECHA_BORRADO", nullable = true)
    private Date fechaBorrado;

    @OneToOne
    private Usuario usuarioCreo;

    @OneToOne
    private Usuario usuarioModifica;

    @OneToOne
    private Usuario usuarioBorra;

    @Column(name="VERSION", nullable = false)
    private Long version;



    public SequenceGenerator(){}
}
