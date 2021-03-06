package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 12:02 PM
 * DTO para catalogos, este DTO servira para todos aquellos catalogos con las
 * mismas caracteristicas  (AtendioParto, Comparece, DestinoCadaver, Escolaridad,
 * EstadoCivil, LugarParto, Parentesco, Puesto, Regimen, SituacionLaboral, TipoDivorcio,
 * TipoDocumento, TipoOperacion, TipoParto, TipoSentencia, TipoNotaMarginal, TipoOficialia
 * TipoLocalidad)
 */

@Data
@ToString(of = {"id", "descripcion"})
public abstract class CatalogoDTO {

    private Long id;
    private String descripcion;

}
