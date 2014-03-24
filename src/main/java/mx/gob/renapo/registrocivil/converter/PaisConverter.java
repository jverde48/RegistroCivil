package mx.gob.renapo.registrocivil.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/18/14
 * Time: 7:51 PM
 * Converter de Pais
 */
public class PaisConverter implements Converter {

    @Override
    public PaisDTO getAsObject(FacesContext context,
                              UIComponent toValidate, String valor) {
        return null;
    }

    @Override
    public String getAsString(FacesContext context,
                              UIComponent toValidate, Object valor) {
        return null;
    }
}
