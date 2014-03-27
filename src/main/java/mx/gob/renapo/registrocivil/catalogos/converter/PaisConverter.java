package mx.gob.renapo.registrocivil.catalogos.converter;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatMunicipioService;
import mx.gob.renapo.registrocivil.catalogos.service.CatPaisService;
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
 * Time: 7:51 PM
 * Converter de Pais
 */
//@FacesConverter(value = "paisConvertet", forClass = PaisDTO.class)
@Data
@Component
@ManagedBean(name = "paisConverter")
public class PaisConverter implements Converter {

    @Autowired
    private CatPaisService paisService;

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof PaisDTO) || ((PaisDTO) value).getId() == null)
            return null;

        return String.valueOf(((PaisDTO) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || !value.matches("\\d+"))
            return null;

        PaisDTO pais = paisService.findById(Long.valueOf(value));

        if (pais == null)
            throw new ConverterException(new FacesMessage("ID de Municipio desconocido: " + value));

        return pais;
    }
}
