package mx.gob.renapo.registrocivil.catalogos.entity;

import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CAT_INEGI_PAIS")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatInegiPais extends SequenceGenerator {

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    @Column(name = "NACIONALIDAD", nullable = false)
    private String nacionalidad;
    
    @Column(name = "CLAVE_PAIS", nullable = false)
    private String clavePais;

}
