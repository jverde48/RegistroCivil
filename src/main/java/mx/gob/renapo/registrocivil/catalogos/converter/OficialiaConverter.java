package mx.gob.renapo.registrocivil.catalogos.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.OficialiaDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.catalogos.service.CatOficialiaService;
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
 * Time: 03:33
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(value = "oficialiaConverter", forClass = OficialiaDTO.class)
public class OficialiaConverter implements Converter {

    @Autowired
    private CatOficialiaService oficialiaService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof OficialiaDTO) || ((OficialiaDTO) value).getId() == null)
            return null;

        return String.valueOf(((OficialiaDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        OficialiaDTO oficialia = oficialiaService.findById(Long.valueOf(value));

        if (oficialia == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return oficialia;
    }
}
