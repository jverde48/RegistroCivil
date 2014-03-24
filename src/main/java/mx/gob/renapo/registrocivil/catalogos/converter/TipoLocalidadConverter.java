package mx.gob.renapo.registrocivil.catalogos.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoLocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created with IntelliJ IDEA.
 * User: green-4
 * Date: 24/03/14
 * Time: 03:30
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(value = "tipoLocaliadadConverter", forClass = CatTipoLocalidadDTO.class)
public class TipoLocalidadConverter implements Converter {

    @Autowired
    private CatTipoLocalidadService tipoLocalidadService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CatTipoLocalidadDTO) || ((CatTipoLocalidadDTO) value).getId() == null)
            return null;

        return String.valueOf(((CatTipoLocalidadDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        CatTipoLocalidadDTO tipoLocalidad = tipoLocalidadService.findById(Long.valueOf(value));

        if (tipoLocalidad == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return tipoLocalidad;
    }
}
