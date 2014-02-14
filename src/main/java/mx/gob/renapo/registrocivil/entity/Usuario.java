package mx.gob.renapo.registrocivil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "USUARIO")
@Data
@EqualsAndHashCode(callSuper=false)
public class Usuario extends SequenceGenerator {

    public Usuario(){}

    @Column(name="NIVEL", nullable=false)
    private Long nivel;

    @Column(name="SISTEMA", nullable=false)
    private Boolean sistema;
    
    @OneToOne
    private CatEstado entidad;
    
    @OneToOne
    private CatMunicipio municipio;
    
    @OneToOne
    private CatOficialia oficialia;
  
}
