package mx.gob.renapo.registrocivil.comun.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import mx.gob.renapo.registrocivil.catalogos.entity.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 3/3/14
 * Time: 4:43 PM
 * Clase que representa la entidad de Domicilio
 */
@Entity
@Table(name = "DOMICILIO")
@Data
@EqualsAndHashCode(callSuper=false)
public class Domicilio extends SequenceGenerator implements Serializable{

    @Column(name = "CALLE", nullable = true)
    private String calle;

    @Column(name = "NUMERO_EXT")
    private String numeroExt;

    @Column(name = "NUMERO_INT")
    private String numeroInt;

    @Column(name = "COLONIA")
    private String colonia;

    @OneToOne
    private CatInegiLocalidad localidad;

    @OneToOne
    private CatInegiMunicipio municipio;

    @OneToOne
    private CatInegiEstado estado;

    @Column(name = "CODIGO_POSTAL", nullable = true)
    private String codigoPostal;

    @OneToOne
    private CatInegiPais pais;

}
