package mx.gob.renapo.registrocivil.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * Created with IntelliJ IDEA.
 * User: Alejandro Diaz Solis
 * Date: 3/18/14
 * Time: 8:06 PM
 * Converter de municipio
 */
public class MunicipioConverter implements Converter {

    @Override
    public MunicipioDTO getAsObject(FacesContext context,
                               UIComponent toValidate, String valor) {
        return null;
    }

    @Override
    public String getAsString(FacesContext context,
                              UIComponent toValidate, Object valor) {
        return null;
    }

}
