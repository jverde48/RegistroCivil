package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro
 * Date: 3/18/14
 * Time: 6:06 PM
 * DTO del Catalogo de AtendioParto
 */
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "descripcion"})
public class CatAtendioPartoDTO extends CatalogoDTO implements Serializable {


}
