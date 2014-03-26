package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 2:02 PM
 * DTO de Pais, este DTO se puede utilizar tanto para el catalogo de INEGI como
 * el que maneja RENAPO
 */
@Data
@Component
public class PaisDTO {
    private Long id;
    private String descripcion;
    private List<EstadoDTO> estados;

}