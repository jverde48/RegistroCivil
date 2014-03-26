package mx.gob.renapo.registrocivil.catalogos.converter;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.OficialDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.catalogos.service.CatOficialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
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
//@FacesConverter(value = "oficialConverter", forClass = OficialDTO.class)
@Data
@Component
@ManagedBean(name = "oficialConverter")
public class OficialConverter implements Converter {

    @Autowired
    private CatOficialService oficialService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof OficialDTO) || ((OficialDTO) value).getId() == null)
            return null;

        return String.valueOf(((OficialDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        OficialDTO oficial = oficialService.findById(Long.valueOf(value));

        if (oficial == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return oficial;
    }
}
