package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 2:01 PM
 * DTO de Municipio, este DTO se puede utilizar tanto para el catalogo de INEGI como
 * el que maneja RENAPO
 */
@Data
@Component
public class MunicipioDTO {

    private Long id;
    private Long idRenapo;
    private String nombreMunicipio;

    @Autowired
    private EstadoDTO estado;


}
