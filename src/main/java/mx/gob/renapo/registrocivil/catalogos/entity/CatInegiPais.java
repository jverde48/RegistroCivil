package mx.gob.renapo.registrocivil.catalogos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/3/14
 * Time: 2:21 PM
 * Clase que representa a la entidad del catalogo de de INEGI de Pais
 */
@Entity
@Table(name = "CAT_INEGI_PAIS")
@Data
@EqualsAndHashCode(callSuper=false)
public class CatInegiPais extends SequenceGenerator implements Serializable{
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;
    
    @Column(name = "NACIONALIDAD", nullable = false)
    private String nacionalidad;
    
    @Column(name = "CLAVE_PAIS", nullable = false)
    private String clavePais;

}
