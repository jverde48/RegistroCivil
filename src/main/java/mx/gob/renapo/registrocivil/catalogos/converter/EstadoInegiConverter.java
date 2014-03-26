package mx.gob.renapo.registrocivil.catalogos.converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import lombok.Data;
import mx.gob.renapo.registrocivil.catalogos.dto.EstadoDTO;
import mx.gob.renapo.registrocivil.catalogos.service.CatInegiEstadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean(name = "inegiEstadoConverter")
@Component
@Data
public class EstadoInegiConverter  implements Converter {
	
	@Autowired
	private CatInegiEstadoService inegiEstadoService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || !value.matches("\\d+"))
            return null;

        EstadoDTO estado = inegiEstadoService.findById(Long.valueOf(value));

        if (estado == null)
            throw new ConverterException(new FacesMessage("ID de Estado desconocido: " + value));

        return estado;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		 if (!(value instanceof EstadoDTO) || ((EstadoDTO) value).getId() == null)
	            return null;

	        return String.valueOf(((EstadoDTO) value).getId());
	}
	
	

}
