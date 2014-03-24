package mx.gob.renapo.registrocivil.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/18/14
 * Time: 8:04 PM
 * Converter de Estado
 */
public class EstadoConverter implements Converter {

    @Override
    public EstadoDTO getAsObject(FacesContext context,
                               UIComponent toValidate, String valor) {
        return null;
    }

    @Override
    public String getAsString(FacesContext context,
                              UIComponent toValidate, Object valor) {
        return null;
    }
}
