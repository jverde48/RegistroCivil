package mx.gob.renapo.registrocivil.catalogos.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.CatPuestoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.catalogos.service.CatPuestoService;
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
 * Time: 03:29
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(value = "puestoConverter", forClass = CatPuestoDTO.class)
public class PuestoConverter implements Converter {

    @Autowired
    private CatPuestoService puestoService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CatPuestoDTO) || ((CatPuestoDTO) value).getId() == null)
            return null;

        return String.valueOf(((CatPuestoDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        CatPuestoDTO puesto = puestoService.findById(Long.valueOf(value));

        if (puesto == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return puesto;
    }
}
