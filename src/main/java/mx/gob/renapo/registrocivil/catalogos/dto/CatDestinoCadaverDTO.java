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
 * Date: 3/18/14
 * Time: 6:20 PM
 * DTO de Catalogo de Destino Cadaver
 */
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "descripcion"})
@Data
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CatDestinoCadaverDTO implements Serializable {

    private Long id;
    private String descripcion;

}
