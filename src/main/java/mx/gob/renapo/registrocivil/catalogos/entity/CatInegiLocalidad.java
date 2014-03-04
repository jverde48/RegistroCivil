package mx.gob.renapo.registrocivil.catalogos.entity;

import mx.gob.renapo.registrocivil.comun.entity.SequenceGenerator;

import javax.persistence.Column;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/3/14
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class CatInegiLocalidad extends SequenceGenerator {

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "TIPO_LOCALIDAD", nullable = false)
    private  String tipoLocalidad;

}
