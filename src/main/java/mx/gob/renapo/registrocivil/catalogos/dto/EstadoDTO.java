package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Aleandro Diaz Solis
 * Date: 3/13/14
 * Time: 2:02 PM
 * DTO de Estado (Entidad Federativa), este DTO se puede utilizar t
 * anto para el catalogo de INEGI como el que maneja RENAPO
 */
@Data
@Component
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "nombreEstado"})
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class EstadoDTO implements Serializable {

    private Long id;
    private Long idRenapo;
    private String nombreEstado;

    private List<MunicipioDTO> municipios;

    @Autowired
    private PaisDTO pais;


}
