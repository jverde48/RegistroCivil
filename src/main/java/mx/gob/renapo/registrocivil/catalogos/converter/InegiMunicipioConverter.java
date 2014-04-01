package mx.gob.renapo.registrocivil.catalogos.converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.MunicipioDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatInegiMunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean(name = "inegiMunicipioConverter")
@Component
@Data
public class InegiMunicipioConverter implements Converter {
	
	@Autowired
	private CatInegiMunicipioService inegiMunicipioService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || !value.matches("\\d+"))
            return null;

        MunicipioDTO municipio = inegiMunicipioService.findById(Long.valueOf(value));

        if (municipio == null)
            throw new ConverterException(new FacesMessage("ID de Municipio desconocido: " + value));

        return municipio;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (!(value instanceof MunicipioDTO) || ((MunicipioDTO) value).getId() == null)
            return null;

        return String.valueOf(((MunicipioDTO) value).getId());
	}

}
