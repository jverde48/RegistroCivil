package mx.gob.renapo.registrocivil.catalogos.converter;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatMunicipioService;
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
 * User: Alejandro Diaz Solis
 * Date: 3/18/14
 * Time: 8:06 PM
 * Converter de municipio
 */
//@FacesConverter(value="municipioConverter", forClass = MunicipioDTO.class)
@Data
@Component
@ManagedBean(name = "municipioConverter")
public class MunicipioConverter implements Converter {

    @Autowired
    private CatMunicipioService municipioService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof MunicipioDTO) || ((MunicipioDTO) value).getId() == null)
            return null;

        return String.valueOf(((MunicipioDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        MunicipioDTO municipio = municipioService.findById(Long.valueOf(value));

        if (municipio == null)
            throw new ConverterException(new FacesMessage("ID de Municipio desconocido: " + value));

        return municipio;
    }
}
