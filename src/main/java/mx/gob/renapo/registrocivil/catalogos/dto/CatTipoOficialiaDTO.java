package mx.gob.renapo.registrocivil.catalogos.dto;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/18/14
 * Time: 6:58 PM
 * DTO del catalogo de Tipo de oficialia
 */
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of={"id", "descripcion"})
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CatTipoOficialiaDTO extends CatalogoDTO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
