package mx.gob.renapo.registrocivil.actos.matrimonio.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatPuestoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatSituacionLaboralDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 21/03/14
 * Time: 13:24
 * To change this template use File | Settings | File Templates.
 */
@Data
@Component
public class EstadisticosMatrimonioDTO {

    @Autowired
    private CatSituacionLaboralDTO situacionLaboralDTOContrayenteUno;

    @Autowired
    private CatSituacionLaboralDTO situacionLaboralDTOContrayenteDos;

    @Autowired
    private CatPuestoDTO puestoDTOContrayenteUno;

    @Autowired
    private CatPuestoDTO puestoDTOContrayenteDos;

}
