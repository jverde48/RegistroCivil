package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 5:33 PM
 * DTO de Colonia/Localidad
 */
@Data
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "nombreLocalidad"})
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class LocalidadDTO implements Serializable {

    private Long id;
    private String nombreLocalidad;

}
