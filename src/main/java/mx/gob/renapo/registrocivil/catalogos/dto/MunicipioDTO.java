package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 2:01 PM
 * DTO de Municipio, este DTO se puede utilizar tanto para el catalogo de INEGI como
 * el que maneja RENAPO
 */
@Data
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "nombreMunicipio"})
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MunicipioDTO implements Serializable {

    private Long id;
    private Long idRenapo;
    private String nombreMunicipio;

    @Autowired
    private EstadoDTO estado;


}
