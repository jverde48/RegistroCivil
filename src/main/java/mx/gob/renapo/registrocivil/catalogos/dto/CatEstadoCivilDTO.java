package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/18/14
 * Time: 6:38 PM
 * DTO de catalogo de Estado Civil
 */
@Data
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "descripcion"})
public class CatEstadoCivilDTO implements Serializable {

    private Long id;
    private String descripcion;
}
