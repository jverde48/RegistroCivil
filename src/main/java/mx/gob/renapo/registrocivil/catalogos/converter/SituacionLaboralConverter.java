package mx.gob.renapo.registrocivil.catalogos.converter;

import mx.gob.renapo.registrocivil.catalogos.dto.CatSituacionLaboralDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatEstadoService;
import mx.gob.renapo.registrocivil.catalogos.service.CatSituacionLaboralService;
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
@FacesConverter(value = "situacionLaboralConverter", forClass = CatSituacionLaboralDTO.class)
public class SituacionLaboralConverter implements Converter {

    @Autowired
    private CatSituacionLaboralService situacionLaboralService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof CatSituacionLaboralDTO) || ((CatSituacionLaboralDTO) value).getId() == null)
            return null;

        return String.valueOf(((CatSituacionLaboralDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        CatSituacionLaboralDTO situacionLaboral = situacionLaboralService.findById(Long.valueOf(value));

        if (situacionLaboral == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return situacionLaboral;
    }
}
