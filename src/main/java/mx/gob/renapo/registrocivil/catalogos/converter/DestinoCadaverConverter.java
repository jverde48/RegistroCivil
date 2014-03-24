package mx.gob.renapo.registrocivil.catalogos.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.CatDestinoCadaverDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatDestinoCadaverService;
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
@FacesConverter(value = "destinoCadaverConverter", forClass = CatDestinoCadaverDTO.class)
public class DestinoCadaverConverter implements Converter {

    @Autowired
    private CatDestinoCadaverService destinoCadaverService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CatDestinoCadaverDTO) || ((CatDestinoCadaverDTO) value).getId() == null)
            return null;

        return String.valueOf(((CatDestinoCadaverDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        CatDestinoCadaverDTO destinoCadaver = destinoCadaverService.findById(Long.valueOf(value));

        if (destinoCadaver == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return destinoCadaver;
    }
}
