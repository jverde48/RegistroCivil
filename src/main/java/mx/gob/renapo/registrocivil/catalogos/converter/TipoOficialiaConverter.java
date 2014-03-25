package mx.gob.renapo.registrocivil.catalogos.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoOficialiaDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoOficialiaService;
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
 * Time: 03:31
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter(value = "tipoOficialiaConverter", forClass = CatTipoOficialiaDTO.class)
public class TipoOficialiaConverter implements Converter {

    @Autowired
    private CatTipoOficialiaService oficialiaService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CatTipoOficialiaDTO) || ((CatTipoOficialiaDTO) value).getId() == null)
            return null;

        return String.valueOf(((CatTipoOficialiaDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        CatTipoOficialiaDTO oficialia = oficialiaService.findById(Long.valueOf(value));

        if (oficialia == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return oficialia;
    }
}
