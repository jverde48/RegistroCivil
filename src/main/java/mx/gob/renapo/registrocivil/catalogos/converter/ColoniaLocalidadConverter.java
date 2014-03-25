package mx.gob.renapo.registrocivil.catalogos.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.ColoniaLocalidadDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatColoniaLocalidadService;
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
 * Time: 03:32
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(value = "coloniaLocalidadConverter", forClass = ColoniaLocalidadDTO.class)
public class ColoniaLocalidadConverter implements Converter {

    @Autowired
    private CatColoniaLocalidadService coloniaLocalidadService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof ColoniaLocalidadDTO) || ((ColoniaLocalidadDTO) value).getId() == null)
            return null;

        return String.valueOf(((ColoniaLocalidadDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        ColoniaLocalidadDTO coloniaLocalidad = coloniaLocalidadService.findById(Long.valueOf(value));

        if (component == null)
            throw new ConverterException(new FacesMessage("ID de Localidad o colonia desconocido: " + value));

        return coloniaLocalidad;
    }
}
