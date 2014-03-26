package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 1:45 PM
 * DTO de OficialiaDTO
 */
@Data
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "nombreOficialia"})
public class OficialiaDTO implements Serializable{

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
