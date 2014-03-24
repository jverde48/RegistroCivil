package mx.gob.renapo.registrocivil.catalogos.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.CatTipoDocumentoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.catalogos.service.CatTipoDocumentoService;
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
@FacesConverter(value = "tipoDocumentoConverter", forClass = CatTipoDocumentoDTO.class)
public class TipoDocumentoConverter implements Converter {

    @Autowired
    private CatTipoDocumentoService documentoService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CatTipoDocumentoDTO) || ((CatTipoDocumentoDTO) value).getId() == null)
            return null;

        return String.valueOf(((CatTipoDocumentoDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        CatTipoDocumentoDTO documento = documentoService.findById(Long.valueOf(value));

        if (documento == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return documento;
    }
}
