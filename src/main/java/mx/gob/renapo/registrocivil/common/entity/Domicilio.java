package mx.gob.renapo.registrocivil.common.entity;

import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiLocalidad;
import mx.gob.renapo.registrocivil.catalogos.entity.CatInegiPais;
import mx.gob.renapo.registrocivil.catalogos.entity.CatMunicipio;

import javax.persistence.Column;
import javax.persistence.OneToOne;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/3/14
 * Time: 4:43 PM
 * Clase que representa la entidad de Domicilio
 */
public class Domicilio extends SequenceGenerator {

    @Column(name = "CALLE", nullable = true)
    private String calle;

    @Column(name = "CODIGO_POSTAL", nullable = true)
    private String codigoPostal;

    @Column(name = "NUMERO_EXT")
    private String numeroExt;

    @Column(name = "NUMERO_INT")
    private String numeroInt;

    @OneToOne
    private CatInegiLocalidad localidad;

    @OneToOne
    private CatMunicipio municipio;

    @OneToOne
    private CatInegiPais pais;

}
