package mx.gob.renapo.registrocivil.catalogos.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
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
@EqualsAndHashCode(callSuper = false, of = {"id"})
@ToString(of = {"id", "descripcion"})
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class PaisDTO implements Serializable{
    private Long id;
    private String descripcion;
    private String nacionalidad;
    private List<EstadoDTO> estados;

}
