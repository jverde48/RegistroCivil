package mx.gob.renapo.registrocivil.catalogos.converter;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.CatAtendioPartoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatAtendioPartoService;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
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
 * Time: 03:26
 * To change this template use File | Settings | File Templates.
 */
//@FacesConverter(value = "atendioPartoConverter", forClass = CatAtendioPartoDTO.class)
@ManagedBean(name = "atendioPartoConverter")
@Data
@Component
public class AtendioPartoConverter implements Converter {

    @Autowired
    private CatAtendioPartoService atendioPartoService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CatAtendioPartoDTO) || ((CatAtendioPartoDTO) value).getId() == null)
            return null;

        return String.valueOf(((CatAtendioPartoDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        CatAtendioPartoDTO atendioParto = atendioPartoService.findById(Long.valueOf(value));

        if (atendioParto == null)
            throw new ConverterException(new FacesMessage("ID de Atendio Parto desconocido: " + value));

        return atendioParto;
    }
}
