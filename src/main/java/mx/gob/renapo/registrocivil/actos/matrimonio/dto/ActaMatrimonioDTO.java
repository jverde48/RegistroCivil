package mx.gob.renapo.registrocivil.actos.matrimonio.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatRegimenDTO;
import mx.gob.renapo.registrocivil.comun.dto.ActaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 24/03/14
 * Time: 02:42
 * To change this template use File | Settings | File Templates.
 */

@Data
@Component
public class ActaMatrimonioDTO extends ActaDTO {

    /**
     * Campo para autorizacion de extrajeros.
     */
    private String autorizacionRg;

    @Autowired
    private CatRegimenDTO regimenDTO;
}
