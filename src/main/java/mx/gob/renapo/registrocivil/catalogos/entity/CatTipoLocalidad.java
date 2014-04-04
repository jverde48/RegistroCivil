package mx.gob.renapo.registrocivil.catalogos.entity;



import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz
 * Date: 3/22/14
 * Time: 7:20 PM
 * Entity de tipo de localidad
 */
@Entity
@Table(name = "CAT_TIPO_LOCALIDAD")
public class CatTipoLocalidad extends Catalogo implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
