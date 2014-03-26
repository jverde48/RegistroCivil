package mx.gob.renapo.registrocivil.catalogos.converter;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dao.CatTipoPartoDAO;
import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoPartoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoPartoService;

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
 * Time: 03:32
 * To change this template use File | Settings | File Templates.
 */

//@FacesConverter(value = "tipoPartoConverter", forClass = CatTipoPartoDTO.class)
@ManagedBean(name = "tipoPartoConverter")
@Data
@Component
public class TipoPartoConverter implements Converter {

    @Autowired
    private CatTipoPartoService tipoPartoService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CatTipoPartoDTO) || ((CatTipoPartoDTO) value).getId() == null)
            return null;

        return String.valueOf(((CatTipoPartoDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        CatTipoPartoDTO tipoParto = tipoPartoService.findById(Long.valueOf(value));

        if (tipoParto == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return tipoParto;
    }
}
