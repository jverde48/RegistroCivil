package mx.gob.renapo.registrocivil.catalogos.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/18/14
 * Time: 6:49 PM
 * DTO del catalogo de Regimen
 */
@Data
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of={"id", "descripcion"})
public class CatRegimenDTO implements Serializable {
	/**
	 * 
	 */
    private Long id;
    private String descripcion;
	private static final long serialVersionUID = 1L;
}
