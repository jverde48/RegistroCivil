package mx.gob.renapo.registrocivil.catalogos.dto;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/18/14
 * Time: 6:54 PM
 * DTO del catalogo de tipo de documento
 */
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of={"id", "descripcion"})
public class CatTipoDocumentoDTO extends CatalogoDTO implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
