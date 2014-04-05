package mx.gob.renapo.registrocivil.comun.dto;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoNotaMarginalDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatalogoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/13/14
 * Time: 1:32 PM
 * DTO para notas marginales
 */
@Data
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class NotasMarginalesDTO {

    private Long id;
    private Date fechaRegistro;
    private Boolean imprimible;
    private StringBuilder informacion;

    @Autowired
    private CatTipoNotaMarginalDTO tipoNotaMarginal;

}
