package mx.gob.renapo.registrocivil.actos.nacimiento.bean;

import lombok.Data;
import mx.gob.renapo.registrocivil.actos.nacimiento.dto.NacimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;

/**
 * Created with IntelliJ IDEA.
 * User: root
 * Date: 4/27/14
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */

@Data
@ManagedBean(name = "detalleNacimientoBean")
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class DetalleNacimientoBean {

    @Autowired
    private NacimientoDTO detalleNacimiento;

    private Boolean existenciaAbueloUnoProgenitorUno;
    private Boolean existenciaAbueloDosProgenitorUno;
    private Boolean existenciaAbueloUnoProgenitorDos;
    private Boolean existenciaAbueloDosProgenitorDos;



}
