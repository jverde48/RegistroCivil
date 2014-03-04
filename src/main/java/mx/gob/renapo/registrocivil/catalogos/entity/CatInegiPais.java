package mx.gob.renapo.registrocivil.catalogos.entity;

import mx.gob.renapo.registrocivil.common.entity.SequenceGenerator;

import javax.persistence.Column;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/3/14
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class CatInegiPais extends SequenceGenerator {

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

}
