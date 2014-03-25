package mx.gob.renapo.registrocivil.catalogos.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.CatEscolaridadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEscolaridadService;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
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
 * Time: 03:27
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(value = "escolaridadConverter", forClass = CatEscolaridadDTO.class)
public class EscolaridadConverter implements Converter {

    @Autowired
    private CatEscolaridadService escolaridadService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CatEscolaridadDTO) || ((CatEscolaridadDTO) value).getId() == null)
            return null;

        return String.valueOf(((CatEscolaridadDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        CatEscolaridadDTO escolaridad = escolaridadService.findById(Long.valueOf(value));

        if (escolaridad == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return escolaridad;
    }
}
