package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 1:45 PM
 * DTO de OficialiaDTO
 */
@Data
public class OficialiaDTO {

    private Long id;
    private Long idRenapo;
    private MunicipioDTO municipio;
    private String nombreOficialia;
    private CatalogoDTO tipoOficialia;
    private OficialDTO oficial;

    @Override
    public String toString() {
        return getNombreOficialia();
    }


}
