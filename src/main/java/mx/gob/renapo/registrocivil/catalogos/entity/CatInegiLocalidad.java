package mx.gob.renapo.registrocivil.catalogos.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/3/14
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "CAT_INEGI_LOCALIDAD")
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "descripcion"})
public class CatInegiLocalidad extends SequenceGenerator{

    public CatInegiLocalidad() {

    }

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "TIPO_LOCALIDAD", nullable = false)
    private  String tipoLocalidad;
}
