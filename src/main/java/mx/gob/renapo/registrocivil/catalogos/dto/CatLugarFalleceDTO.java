package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Abel Molina S
 * Date: 20/03/14
 * Time: 06:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "descripcion"})
public class CatLugarFalleceDTO extends CatalogoDTO implements Serializable {

}