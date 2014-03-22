package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 1:45 PM
 * DTO de OficialiaDTO
 */
@Data
@Component
public class OficialiaDTO {

    private Long id;
    private Long idRenapo;
    private String nombreOficialia;

    @Autowired
    private CatTipoOficialiaDTO tipoOficialia;

    @Autowired
    private OficialDTO oficial;

    @Autowired
    private MunicipioDTO municipio;

    @Override
    public String toString() {
        return getNombreOficialia();
    }


}
