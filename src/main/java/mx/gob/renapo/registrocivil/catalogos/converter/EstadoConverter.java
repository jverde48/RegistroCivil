package mx.gob.renapo.registrocivil.catalogos.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
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
 * Date: 18/03/14
 * Time: 16:56
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(value="estadoConverter", forClass = EstadoDTO.class)
public class EstadoConverter implements Converter {

    @Autowired
    private CatEstadoService catEstadoService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof EstadoDTO) || ((EstadoDTO) value).getId() == null)
            return null;

        return String.valueOf(((EstadoDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        EstadoDTO estado = catEstadoService.findById(Long.valueOf(value));

        if (estado == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return estado;
    }
}
