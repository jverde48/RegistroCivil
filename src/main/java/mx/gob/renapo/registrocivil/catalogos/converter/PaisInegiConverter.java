package mx.gob.renapo.registrocivil.catalogos.converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.PaisDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatInegiPaisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean(name = "paisInegiConverter")
@Data
@Component
public class PaisInegiConverter implements Converter {
	
	@Autowired
	private CatInegiPaisService inegiPaisService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		if (value == null || !value.matches("\\d+"))
            return null;

        PaisDTO pais = inegiPaisService.findById(Long.valueOf(value));

        if (pais == null)
            throw new ConverterException(new FacesMessage("ID de Pais desconocido: " + value));

        return pais;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		 if (!(value instanceof PaisDTO) || ((PaisDTO) value).getId() == null)
	            return null;

	        return String.valueOf(((PaisDTO) value).getId());
	}

}
